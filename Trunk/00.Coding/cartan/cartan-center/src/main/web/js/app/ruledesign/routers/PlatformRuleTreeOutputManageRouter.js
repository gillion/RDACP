
/**
 * 决策树输出
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class",
    "utils/Log",
    "jquery",
    "base/BaseRouter",
    "base/BaseView",
    "grid/simplelist",
    "grid/SimpleListUtil",
    "js/app/ruledesign/routers/PlatformRuleTreeSelDialog",
    "rpc/AjaxEngine",
    "ddsmoothmenu",
    "jquery_ui",
    "jquery_messager",
    "jquery_page",
    "footable",
    "jquery_ztree_core_min",
    "jquery_ztree_core",
    "jquery_ztree_excheck",
    "jquery_ztree_exedit"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformRuleTreeSelDialog,
		AjaxEngine,
        ddsmoothmenu,
        jquery_ui,
        jquery_messager,
        jquery_page,
        footable,
        jquery_ztree_core_min,
        jquery_ztree_core,
        jquery_ztree_excheck,
        jquery_ztree_exedit){
	
    function showRuleTreeSelDialog(){
        var detailstr="";
        detailstr+="<div id='RuleTreegrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformRuleTreeSelDialog.showGridData($("#RuleTreegrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.ruleTreeName;
            $("#ruleTreeId").val(Id);
            $("#RuleTreeName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, height, titles);
    	
        var RuleTreeviewModel = kendo.observable({
            id: $("#ruleTreeId").val(),
            name: $("#RuleTreeName").val(),
            displayGreeting: function() {
            showRuleTreeSelDialog();
            }
        });
        kendo.bind($("#viewRuleTree"), RuleTreeviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ruleTreeId: $("#ruleTreeId").val(),treeNodeCode: $("#treeNodeCode").val(),treeNodeName: $("#treeNodeName").val(),outputVer: $("#outputVer").val(),outputValue: $("#outputValue").val()},
                    dataType: 'json',
                    complete: function(transport){
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("操作成功！");
                        kendoUIWindow.close();
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                        $("#submitBtn").attr("disabled", false);
                    }
                }
            );
        });
    	} else{
        $("#QueryBtn").click(function(){
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),ruleTreeId: $("#ruleTreeId").val(),treeNodeCode: $("#treeNodeCode").val(),treeNodeName: $("#treeNodeName").val(),outputVer: $("#outputVer").val(),outputValue: $("#outputValue").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["RuleTreeName"] = PlatformRuleTreeSelDialog.codetodes(data["ruleTreeId"]);

        						
                            }
                        }

                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.data([]);
                        table0.dataSource.data(result.resultJson);
                        $("#QueryBtn").attr("disabled", false);
                        kendoUIWindow.close();
                    }
                }
            );
        });
    	}
        SimpleListUtil.setDataTimeCn();

        
    }
    
    var PlatformRuleTreeOutputManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_RuleTreeOutput_manage": "showPlatformRuleTreeOutputManageList",  
            "basic_manage/platform_ckRuleTreeOutput_manage": "showPlatformckRuleTreeOutputManageList"
        },
        showPlatformckRuleTreeOutputManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformRuleTreeOutputManageList: function(){
            var ruleTreeId=SimpleListUtil.GetQueryString("id");
            var RuleTreeName=decodeURI(SimpleListUtil.GetQueryString("name"));
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformRuleTreeOutputManageListView = new SimpleListView({
                id: "platform_ruleTreeOutput_manage_list",
                title: "规则管理 > 决策树 > 节点定义",
                buttonCount:4,

                ready: function(){
                    this.setSimpleListHeader("决策树 > 节点定义");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleTreeId' align='right'>决策树：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewRuleTree'>";                        
                        detailstr+="<input id='ruleTreeId' name='ruleTreeId' hidden='true' data-bind='value: id' value='"+ruleTreeId+"' style='...'/>";
                        detailstr+="<input id='RuleTreeName' name='RuleTreeName' data-bind='value: name' value='"+RuleTreeName+"' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltreeNodeCode' align='right'>节点代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='treeNodeCode' name='节点代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltreeNodeName' align='right'>节点名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='treeNodeName' name='节点名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loutputVer' align='right'>输出变量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='outputVer' name='输出变量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loutputValue' align='right'>输出值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='outputValue' name='输出值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ruleTreeOutput.createRuleTreeOutput&v=1.0&format=json",$(detailstr),190);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformRuleTreeOutputManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformRuleTreeOutputManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformRuleTreeOutputManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ruleTreeOutput.deleteRuleTreeOutput&v=1.0&format=json",
                            {
                                async: false,
                                data:{id: ID},
                                dataType: 'json',
                                complete: function(transport){
                                    result = transport.responseText;
                                    result = $.parseJSON(result);
                                	}
                            	}
                            );
                        }
                        alert("删除成功！");
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                        } else {
                            alert("请先选择记录！");
                        }
                    }, "delete");
                    this.addToolbarBtn("queryBtn", "查 询", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleTreeId' align='right'>决策树：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewRuleTree'>";                        
                        detailstr+="<input id='ruleTreeId' name='ruleTreeId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='RuleTreeName' name='RuleTreeName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltreeNodeCode' align='right'>节点代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='treeNodeCode' name='节点代码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltreeNodeName' align='right'>节点名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='treeNodeName' name='节点名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loutputVer' align='right'>输出变量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='outputVer' name='输出变量' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loutputValue' align='right'>输出值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='outputValue' name='输出值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ruleTreeOutput.selectRuleTreeOutput&v=1.0&format=json",$(detailstr),190);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("returnBtn", "决策树", function(){
                        window.location.href ="ruledesign.html#basic_manage/platform_RuleTree_manage";
                    }, "createLink");

                },

                dataSource: {
                    serverPaging: false,
                    serverSorting: false,             //排序
                    serverGrouping: false,            //分组
                    group: { field: "RuleTreeName" },
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ruleTreeOutput.selectRuleTreeOutput&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ruleTreeId: { type: "string" },treeNodeCode: { type: "string" },treeNodeName: { type: "string" },outputVer: { type: "string" },outputValue: { type: "string" }
                            }
                        },
                        parse: function(response) {
                            return response;
                        },
                        //返回的数据
                        data: function(response) {
                            var result = response["resultJson"];
                            if($.isArray(result)){
                                var data = null;
                                for(var i= 0, count=result.length; i<count; i++){
                                    data = result[i];
                                    data["RuleTreeName"] = PlatformRuleTreeSelDialog.codetodes(data["ruleTreeId"]);
                                }
                            }
                            result = platformRuleTreeOutputManageListView.appendColValue(result);
                            return result;
                        },
                        //记录条数
                        total: function(response) {
                            var result = response["total"] || response["resultJson"].length;
                            return result;
                        }
                    }
                },
                sortable: true,
                groupable: true,
                columns: [
                          {field: "chk", type:"chk", title: "&nbsp;", value:"ID"},
                          {field: "id", title:"主键", hidden:"true", align:"center", width: "100px"},
                    		{field: "ruleTreeId", title:"决策树", hidden:"true", align:"center", width: "100px"},
                    		{field: "RuleTreeName", title:"决策树", align:"center", width: "100px"},
                    		{field: "treeNodeCode", title:"节点代码", align:"center", width: "100px"},
                    		{field: "treeNodeName", title:"节点名称", align:"center", width: "100px"},
                    		{field: "outputVer", title:"输出变量", align:"center", width: "100px"},
                    		{field: "outputValue", title:"输出值", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            "text" :{ edit:"修改", cancel: "取消", update: "保存" } ,
                            name: "edit",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformRuleTreeOutputManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformRuleTreeOutputManageListView.get("columns");
                                var col = null;
                                var colName = null;
                                var value = null;
                                var ColumnValue = {};
                                for(var i= 0, colCount=columnArray.length; i<colCount; i++){
                                    col = columnArray[i];
                                    colName = col.field;
                                    value = SimpleListUtil.getSelectedColumnValue(this, colName);
                                    ColumnValue[colName] = value;
                                }

                                var detailstr="";
                                detailstr+="<div id='content' align='center'>";
                                detailstr+="<table>";
                                detailstr+="<input id='id' name='主键' hidden='true' value='"+ColumnValue["id"]+"' style='...'/>";

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleTreeId' align='right'>决策树：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewRuleTree'>";                        
                                detailstr+="<input id='ruleTreeId' name='ruleTreeId' hidden='true' data-bind='value: id' value='"+ColumnValue["ruleTreeId"]+"' style='...'/>";
                                detailstr+="<input id='RuleTreeName' name='RuleTreeName' data-bind='value: name' value='"+PlatformRuleTreeSelDialog.codetodes(ColumnValue["ruleTreeId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltreeNodeCode' align='right'>节点代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='treeNodeCode' name='节点代码' value='"+ColumnValue["treeNodeCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltreeNodeName' align='right'>节点名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='treeNodeName' name='节点名称' value='"+ColumnValue["treeNodeName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loutputVer' align='right'>输出变量：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='outputVer' name='输出变量' value='"+ColumnValue["outputVer"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loutputValue' align='right'>输出值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='outputValue' name='输出值' value='"+ColumnValue["outputValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ruleTreeOutput.updateRuleTreeOutput&v=1.0&format=json", $(detailstr),190);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformRuleTreeOutputManageListView);

            var ruleTreeId=SimpleListUtil.GetQueryString("id");
            if (ruleTreeId){
                // alert(ruleTreeId);
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
                $("#selectAll").bind("click", selectAll);
            }
        }
    });

    return PlatformRuleTreeOutputManageRouter;
});

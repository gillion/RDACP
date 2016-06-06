
/**
 * 决策表输入
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
    "js/app/ruledesign/routers/PlatformRuleTableSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformRuleTableSelDialog,
		AjaxEngine){    
	
    function showRuleTableSelDialog(){
        var detailstr="";
        detailstr+="<div id='RuleTablegrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformRuleTableSelDialog.showGridData($("#RuleTablegrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.ruleTableName;
            $("#ruleTableId").val(Id);
            $("#RuleTableName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, height, titles);
    	
        var RuleTableviewModel = kendo.observable({
            id: $("#ruleTableId").val(),
            name: $("#RuleTableName").val(),
            displayGreeting: function() {
            showRuleTableSelDialog();
            }
        });
        kendo.bind($("#viewRuleTable"), RuleTableviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ruleTableId: $("#ruleTableId").val(),outputLocation: $("#outputLocation").val(),inputVar: $("#inputVar").val(),inputValue: $("#inputValue").val()},
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
                    data:{id: $("#id").val(),ruleTableId: $("#ruleTableId").val(),outputLocation: $("#outputLocation").val(),inputVar: $("#inputVar").val(),inputValue: $("#inputValue").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["RuleTableName"] = PlatformRuleTableSelDialog.codetodes(data["ruleTableId"]);

        						
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
    
    var PlatformRuleTableInputManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_RuleTableInput_manage": "showPlatformRuleTableInputManageList",  
            "basic_manage/platform_ckRuleTableInput_manage": "showPlatformckRuleTableInputManageList"
        },
        showPlatformckRuleTableInputManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformRuleTableInputManageList: function(){
            var ruleTableId=SimpleListUtil.GetQueryString("id");
            var RuleTableName=decodeURI(SimpleListUtil.GetQueryString("name"));
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformRuleTableInputManageListView = new SimpleListView({
                id: "platform_ruleTableInput_manage_list",
                title: "规则管理 > 决策表 > 输入参数",
                buttonCount:5,

                ready: function(){
                    this.setSimpleListHeader("决策表 > 输入参数");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleTableId' align='right'>决策表：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewRuleTable'>";                        
                        detailstr+="<input id='ruleTableId' name='ruleTableId' hidden='true' data-bind='value: id' value='"+ruleTableId+"' style='...'/>";
                        detailstr+="<input id='RuleTableName' name='RuleTableName' data-bind='value: name' value='"+RuleTableName+"' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loutputLocation' align='right'>输出定位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='outputLocation' name='输出定位' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linputVar' align='right'>输入变量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inputVar' name='输入变量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linputValue' align='right'>输入值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inputValue' name='输入值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ruleTableInput.createRuleTableInput&v=1.0&format=json",$(detailstr),160);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformRuleTableInputManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformRuleTableInputManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformRuleTableInputManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ruleTableInput.deleteRuleTableInput&v=1.0&format=json",
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
                        detailstr+="<label id='lruleTableId' align='right'>决策表：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewRuleTable'>";                        
                        detailstr+="<input id='ruleTableId' name='ruleTableId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='RuleTableName' name='RuleTableName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loutputLocation' align='right'>输出定位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='outputLocation' name='输出定位' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linputVar' align='right'>输入变量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inputVar' name='输入变量' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linputValue' align='right'>输入值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inputValue' name='输入值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ruleTableInput.selectRuleTableInput&v=1.0&format=json",$(detailstr),160);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("returnBtn", "决策表", function(){
                        window.location.href ="ruledesign.html#basic_manage/platform_RuleTable_manage";
                    }, "createLink");
                    this.addToolbarBtn("resultvarBtn", "结果集", function(){
                        window.location.href ="ruletree.html#basic_manage/platform_RuleTable_manage_edit";

                    }, "edit");
                },

                dataSource: {
                    serverPaging: false,
                    serverSorting: false,             //排序
                    serverGrouping: false,            //分组
                    group: { field: "RuleTableName" },
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ruleTableInput.selectRuleTableInput&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ruleTableId: { type: "string" },outputLocation: { type: "string" },inputVar: { type: "string" },inputValue: { type: "string" }
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
                                    data["RuleTableName"] = PlatformRuleTableSelDialog.codetodes(data["ruleTableId"]);
                                }
                            }
                            result = platformRuleTableInputManageListView.appendColValue(result);
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
                    		{field: "ruleTableId", title:"决策表", hidden:"true", align:"center", width: "100px"},
                    		{field: "RuleTableName", title:"决策表", align:"center", width: "100px"},
                    		{field: "outputLocation", title:"输出定位", align:"center", width: "100px"},
                    		{field: "inputVar", title:"输入变量", align:"center", width: "100px"},
                    		{field: "inputValue", title:"输入值", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            "text" :{ edit:"修改", cancel: "取消", update: "保存" } ,
                            name: "edit",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformRuleTableInputManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformRuleTableInputManageListView.get("columns");
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
                                detailstr+="<label id='lruleTableId' align='right'>决策表：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewRuleTable'>";                        
                                detailstr+="<input id='ruleTableId' name='ruleTableId' hidden='true' data-bind='value: id' value='"+ColumnValue["ruleTableId"]+"' style='...'/>";
                                detailstr+="<input id='RuleTableName' name='RuleTableName' data-bind='value: name' value='"+PlatformRuleTableSelDialog.codetodes(ColumnValue["ruleTableId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loutputLocation' align='right'>输出定位：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='outputLocation' name='输出定位' value='"+ColumnValue["outputLocation"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linputVar' align='right'>输入变量：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='inputVar' name='输入变量' value='"+ColumnValue["inputVar"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linputValue' align='right'>输入值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='inputValue' name='输入值' value='"+ColumnValue["inputValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ruleTableInput.updateRuleTableInput&v=1.0&format=json", $(detailstr),160);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformRuleTableInputManageListView);
        }
    });

    return PlatformRuleTableInputManageRouter;
});

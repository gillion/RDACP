
/**
 * 条件细分节点
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
    "js/app/ruledesign/routers/PlatformConditionPartitionSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformConditionPartitionSelDialog,
		AjaxEngine){    
	
    function showConditionPartitionSelDialog(){
        var detailstr="";
        detailstr+="<div id='ConditionPartitiongrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformConditionPartitionSelDialog.showGridData($("#ConditionPartitiongrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.conditionName;
            $("#conPartitionId").val(Id);
            $("#ConditionPartitionName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, height, titles);
    	
        var ConditionPartitionviewModel = kendo.observable({
            id: $("#conPartitionId").val(),
            name: $("#ConditionPartitionName").val(),
            displayGreeting: function() {
            showConditionPartitionSelDialog();
            }
        });
        kendo.bind($("#viewConditionPartition"), ConditionPartitionviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),conPartitionId: $("#conPartitionId").val(),conNodeName: $("#conNodeName").val(),relationMark: $("#relationMark").val(),varName: $("#varName").val(),optChar: $("#optChar").val(),compareValue: $("#compareValue").val()},
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
                    data:{id: $("#id").val(),conPartitionId: $("#conPartitionId").val(),conNodeName: $("#conNodeName").val(),relationMark: $("#relationMark").val(),varName: $("#varName").val(),optChar: $("#optChar").val(),compareValue: $("#compareValue").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["ConditionPartitionName"] = PlatformConditionPartitionSelDialog.codetodes(data["conPartitionId"]);

                        		data["optCharName"] = SimpleListUtil.getSelectDes("104", data["optChar"]);
                        		data["relationMarkName"] = SimpleListUtil.getSelectDes("105", data["relationMark"]);
        						
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
    
    var PlatformConditionPartitionNodeManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_ConditionPartitionNode_manage": "showPlatformConditionPartitionNodeManageList",  
            "basic_manage/platform_ckConditionPartitionNode_manage": "showPlatformckConditionPartitionNodeManageList"
        },
        showPlatformckConditionPartitionNodeManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformConditionPartitionNodeManageList: function(){
            var conPartitionId=SimpleListUtil.GetQueryString("id");
            var ConditionPartitionName=decodeURI(SimpleListUtil.GetQueryString("name"));
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformConditionPartitionNodeManageListView = new SimpleListView({
                id: "platform_conditionPartitionNode_manage_list",
                title: "规则管理 > 条件细分 > 节点定义",
                buttonCount:4,

                ready: function(){
                    this.setSimpleListHeader("条件细分 > 节点定义");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconPartitionId' align='right'>条件模型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewConditionPartition'>";                        
                        detailstr+="<input id='conPartitionId' name='conPartitionId' hidden='true' data-bind='value: id' value='"+conPartitionId+"' style='...'/>";
                        detailstr+="<input id='ConditionPartitionName' name='ConditionPartitionName' data-bind='value: name' value='"+ConditionPartitionName+"' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconNodeName' align='right'>节点名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conNodeName' name='节点名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrelationMark' align='right'>关系符：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='关系符' id='relationMark' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("105","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarName' align='right'>变量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='varName' name='变量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loptChar' align='right'>操作符：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='操作符' id='optChar' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("104","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcompareValue' align='right'>对比值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='compareValue' name='对比值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=conditionPartitionNode.createConditionPartitionNode&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformConditionPartitionNodeManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformConditionPartitionNodeManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformConditionPartitionNodeManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=conditionPartitionNode.deleteConditionPartitionNode&v=1.0&format=json",
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
                        detailstr+="<label id='lconPartitionId' align='right'>条件模型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewConditionPartition'>";                        
                        detailstr+="<input id='conPartitionId' name='conPartitionId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='ConditionPartitionName' name='ConditionPartitionName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconNodeName' align='right'>节点名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conNodeName' name='节点名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrelationMark' align='right'>关系符：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='关系符' id='relationMark' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("105","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarName' align='right'>变量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='varName' name='变量' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loptChar' align='right'>操作符：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='操作符' id='optChar' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("104","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcompareValue' align='right'>对比值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='compareValue' name='对比值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=conditionPartitionNode.selectConditionPartitionNode&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("returnBtn", "条件模型", function(){
                        window.location.href ="ruledesign.html#basic_manage/platform_ConditionPartition_manage";
                    }, "createLink");
                },

                dataSource: {
                    serverPaging: false,
                    serverSorting: false,             //排序
                    serverGrouping: false,            //分组
                    group: { field: "ConditionPartitionName" },
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=conditionPartitionNode.selectConditionPartitionNode&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },conPartitionId: { type: "string" },conNodeName: { type: "string" },relationMark: { type: "string" },varName: { type: "string" },optChar: { type: "string" },compareValue: { type: "string" }
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
                                    data["ConditionPartitionName"] = PlatformConditionPartitionSelDialog.codetodes(data["conPartitionId"]);
                            		data["optCharName"] = SimpleListUtil.getSelectDes("104", data["optChar"]);
                            		data["relationMarkName"] = SimpleListUtil.getSelectDes("105", data["relationMark"]);
                                }
                            }
                            result = platformConditionPartitionNodeManageListView.appendColValue(result);
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
                    		{field: "conPartitionId", title:"条件模型", hidden:"true", align:"center", width: "100px"},
                    		{field: "ConditionPartitionName", title:"条件模型", align:"center", width: "100px"},
                    		{field: "conNodeName", title:"节点名称", align:"center", width: "100px"},
                    		{field: "relationMark", title:"关系符", hidden:"true", align:"center", width: "100px"},
                    		{field: "relationMarkName", title:"关系符", align:"center", width: "100px"},
                    		{field: "varName", title:"变量", align:"center", width: "100px"},
                    		{field: "optChar", title:"操作符", hidden:"true", align:"center", width: "100px"},
                    		{field: "optCharName", title:"操作符", align:"center", width: "100px"},
                    		{field: "compareValue", title:"对比值", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            "text" :{ edit:"修改", cancel: "取消", update: "保存" } ,
                            name: "edit",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformConditionPartitionNodeManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformConditionPartitionNodeManageListView.get("columns");
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
                                detailstr+="<label id='lconPartitionId' align='right'>条件模型：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewConditionPartition'>";                        
                                detailstr+="<input id='conPartitionId' name='conPartitionId' hidden='true' data-bind='value: id' value='"+ColumnValue["conPartitionId"]+"' style='...'/>";
                                detailstr+="<input id='ConditionPartitionName' name='ConditionPartitionName' data-bind='value: name' value='"+PlatformConditionPartitionSelDialog.codetodes(ColumnValue["conPartitionId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconNodeName' align='right'>节点名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='conNodeName' name='节点名称' value='"+ColumnValue["conNodeName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrelationMark' align='right'>关系符：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='关系符' id='relationMark' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("105", ColumnValue["relationMark"]);
                                detailstr+="</select>";
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvarName' align='right'>变量：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='varName' name='变量' value='"+ColumnValue["varName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loptChar' align='right'>操作符：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='操作符' id='optChar' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("104", ColumnValue["optChar"]);
                                detailstr+="</select>";
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcompareValue' align='right'>对比值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='compareValue' name='对比值' value='"+ColumnValue["compareValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=conditionPartitionNode.updateConditionPartitionNode&v=1.0&format=json", $(detailstr),220);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformConditionPartitionNodeManageListView);
        }
    });

    return PlatformConditionPartitionNodeManageRouter;
});



/**
 * CodegenerSelect
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
    "js/app/ruledesign/routers/PlatformCodegenerSelDialog",
    "js/app/ruledesign/routers/PlatformCodegenerTableSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformCodegenerSelDialog,
		PlatformCodegenerTableSelDialog,
		AjaxEngine){    
	
    function showCodegenerSelDialog(){
        var detailstr="";
        detailstr+="<div id='Codegenergrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformCodegenerSelDialog.showGridData($("#Codegenergrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.setupName;
            $("#setupId").val(Id);
            $("#CodegenerName").val(Name);
            kendoUIWindow.close();
        });
    }
    function showCodegenerTableSelDialog(){
        var detailstr="";
        detailstr+="<div id='CodegenerTablegrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformCodegenerTableSelDialog.showGridData($("#CodegenerTablegrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.tableName;
            $("#tableId").val(Id);
            $("#CodegenerTableName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 730, height, titles);
        
    	
        
        
        var CodegenerviewModel = kendo.observable({
            id: $("#setupId").val(),
            name: $("#CodegenerName").val(),
            displayGreeting: function() {
            showCodegenerSelDialog();
            }
        });
        kendo.bind($("#viewCodegener"), CodegenerviewModel);
        var CodegenerTableviewModel = kendo.observable({
            id: $("#tableId").val(),
            name: $("#CodegenerTableName").val(),
            displayGreeting: function() {
            showCodegenerTableSelDialog();
            }
        });
        kendo.bind($("#viewCodegenerTable"), CodegenerTableviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),setupId: $("#setupId").val(),tableId: $("#tableId").val(),selectField: $("#selectField").val(),selectTable: $("#selectTable").val(),selectDes: $("#selectDes").val()},
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
                    data:{id: $("#id").val(),setupId: $("#setupId").val(),tableId: $("#tableId").val(),selectField: $("#selectField").val(),selectTable: $("#selectTable").val(),selectDes: $("#selectDes").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["CodegenerName"] = PlatformCodegenerSelDialog.codetodes(data["setupId"]);
                                data["CodegenerTableName"] = PlatformCodegenerTableSelDialog.codetodes(data["tableId"]);

        						
        						
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
    
    var PlatformCodegenerSelectManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_CodegenerSelect_manage": "showPlatformCodegenerSelectManageList",  
            "basic_manage/platform_ckCodegenerSelect_manage": "showPlatformckCodegenerSelectManageList"
        },
        showPlatformckCodegenerSelectManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformCodegenerSelectManageList: function(){
            var CodegenerSelectId=SimpleListUtil.GetQueryString("id");
            var CodegenerSelectName=decodeURI(SimpleListUtil.GetQueryString("name"));
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformCodegenerSelectManageListView = new SimpleListView({
                id: "platform_codegenerSelect_manage_list",
                title: "基础数据 > 弹出组件",
                buttonCount:4,
                
                ready: function(){
                    this.setSimpleListHeader("弹出组件");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsetupId' align='right'>基本配置：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewCodegener'>";                        
                        detailstr+="<input id='setupId' name='setupId' hidden='true' data-bind='value: id'  value='"+CodegenerSelectId+"' style='...'/>";
                        detailstr+="<input id='CodegenerName' name='CodegenerName' data-bind='value: name'  value='"+CodegenerSelectName+"' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ltableId' align='right'>关联模型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewCodegenerTable'>";                        
                        detailstr+="<input id='tableId' name='tableId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='CodegenerTableName' name='CodegenerTableName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lselectField' align='right'>弹出字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='selectField' name='弹出字段' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lselectTable' align='right'>取数模型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='selectTable' name='取数模型' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lselectDes' align='right'>描述字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='selectDes' name='描述字段' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=codegenerSelect.createCodegenerSelect&v=1.0&format=json",$(detailstr),154);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformCodegenerSelectManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformCodegenerSelectManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformCodegenerSelectManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=codegenerSelect.deleteCodegenerSelect&v=1.0&format=json",
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
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsetupId' align='right'>基本配置：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewCodegener'>";                        
                        detailstr+="<input id='setupId' name='setupId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='CodegenerName' name='CodegenerName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='ltableId' align='right'>关联模型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewCodegenerTable'>";                        
                        detailstr+="<input id='tableId' name='tableId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='CodegenerTableName' name='CodegenerTableName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lselectField' align='right'>弹出字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='selectField' name='弹出字段' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lselectTable' align='right'>取数模型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='selectTable' name='取数模型' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lselectDes' align='right'>描述字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='selectDes' name='描述字段' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=codegenerSelect.selectCodegenerSelect&v=1.0&format=json",$(detailstr),154);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("returnBtn", "返回", function(){
                        window.location.href ="ruledesign.html#basic_manage/platform_Codegener_manage";
                    }, "createLink");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=codegenerSelect.selectCodegenerSelect&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },setupId: { type: "string" },tableId: { type: "string" },selectField: { type: "string" },selectTable: { type: "string" },selectDes: { type: "string" }
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
                                    data["CodegenerName"] = PlatformCodegenerSelDialog.codetodes(data["setupId"]);
                                    data["CodegenerTableName"] = PlatformCodegenerTableSelDialog.codetodes(data["tableId"]);
                                }
                            }
                            result = platformCodegenerSelectManageListView.appendColValue(result);
                            return result;
                        },
                        //记录条数
                        total: function(response) {
                            var result = response["total"] || response["resultJson"].length;
                            return result;
                        }
                    }
                },
                columns: [
                          {field: "chk", type:"chk", title: "&nbsp;", value:"ID"},
                          {field: "id", title:"主键", hidden:"true", align:"center", width: "100px"},
                    		{field: "setupId", title:"基本配置", hidden:"true", align:"center", width: "100px"},
                    		{field: "CodegenerName", title:"基本配置", align:"center", width: "100px"},
                    		{field: "tableId", title:"关联模型", hidden:"true", align:"center", width: "100px"},
                    		{field: "CodegenerTableName", title:"关联模型", align:"center", width: "100px"},
                    		{field: "selectField", title:"弹出字段", align:"center", width: "100px"},
                    		{field: "selectTable", title:"取数模型", align:"center", width: "100px"},
                    		{field: "selectDes", title:"描述字段", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformCodegenerSelectManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformCodegenerSelectManageListView.get("columns");
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
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lsetupId' align='right'>基本配置：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewCodegener'>";                        
                                detailstr+="<input id='setupId' name='setupId' hidden='true' data-bind='value: id' value='"+ColumnValue["setupId"]+"' style='...'/>";
                                detailstr+="<input id='CodegenerName' name='CodegenerName' data-bind='value: name' value='"+PlatformCodegenerSelDialog.codetodes(ColumnValue["setupId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='ltableId' align='right'>关联模型：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewCodegenerTable'>";                        
                                detailstr+="<input id='tableId' name='tableId' hidden='true' data-bind='value: id' value='"+ColumnValue["tableId"]+"' style='...'/>";
                                detailstr+="<input id='CodegenerTableName' name='CodegenerTableName' data-bind='value: name' value='"+PlatformCodegenerTableSelDialog.codetodes(ColumnValue["tableId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lselectField' align='right'>弹出字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='selectField' name='弹出字段' value='"+ColumnValue["selectField"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lselectTable' align='right'>取数模型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='selectTable' name='取数模型' value='"+ColumnValue["selectTable"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lselectDes' align='right'>描述字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='selectDes' name='描述字段' value='"+ColumnValue["selectDes"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=codegenerSelect.updateCodegenerSelect&v=1.0&format=json", $(detailstr),154);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformCodegenerSelectManageListView);
        }
    });

    return PlatformCodegenerSelectManageRouter;
});

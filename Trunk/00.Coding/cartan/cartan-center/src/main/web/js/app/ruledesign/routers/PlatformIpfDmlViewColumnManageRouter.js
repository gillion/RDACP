
/**
 * IpfDmlViewColumn
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
    "js/app/ruledesign/routers/PlatformIpfDmlViewSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfDmlViewSelDialog,
		AjaxEngine){    
	
    function showIpfDmlViewSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfDmlViewgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfDmlViewSelDialog.showGridData($("#IpfDmlViewgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.viewName;
            $("#ipfDmlViewId").val(Id);
            $("#IpfDmlViewName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 380, height, titles);
        
    	
        
        
        var IpfDmlViewviewModel = kendo.observable({
            id: $("#ipfDmlViewId").val(),
            name: $("#IpfDmlViewName").val(),
            displayGreeting: function() {
            showIpfDmlViewSelDialog();
            }
        });
        kendo.bind($("#viewIpfDmlView"), IpfDmlViewviewModel);

        var isNotNullModel = kendo.observable({
            isChecked: $("#isNotNull").val()=="1"
        });
        kendo.bind($("#isNotNull"), isNotNullModel);
        var isNotNullval="0";
		
        var isPrimaryKeyModel = kendo.observable({
            isChecked: $("#isPrimaryKey").val()=="1"
        });
        kendo.bind($("#isPrimaryKey"), isPrimaryKeyModel);
        var isPrimaryKeyval="0";
		
        if (tp==1){
        $("#submitBtn").click(function(){    	
            if (isNotNullModel.isChecked){
            	isNotNullval="1";
            } else {
            	isNotNullval="0";
            }
            if (isPrimaryKeyModel.isChecked){
            	isPrimaryKeyval="1";
            } else {
            	isPrimaryKeyval="0";
            }
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ipfDmlViewId: $("#ipfDmlViewId").val(),columnName: $("#columnName").val(),fieldText: $("#fieldText").val(),dataType: $("#dataType").val(),fieldLength: $("#fieldLength").val(),decimals: $("#decimals").val(),isNotNull: isNotNullval,isPrimaryKey: isPrimaryKeyval},
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
                if (isNotNullModel.isChecked){
                	isNotNullval="1";
                } else {
                	isNotNullval="";
                }
                if (isPrimaryKeyModel.isChecked){
                	isPrimaryKeyval="1";
                } else {
                	isPrimaryKeyval="";
                }
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),ipfDmlViewId: $("#ipfDmlViewId").val(),columnName: $("#columnName").val(),fieldText: $("#fieldText").val(),dataType: $("#dataType").val(),fieldLength: $("#fieldLength").val(),decimals: $("#decimals").val(),isNotNull:isNotNullval,isPrimaryKey:isPrimaryKeyval},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfDmlViewName"] = PlatformIpfDmlViewSelDialog.codetodes(data["ipfDmlViewId"]);

                        		data["dataTypeName"] = SimpleListUtil.getSelectDes("T013", data["dataType"]);
        						
        						
                        		data["isNotNullName"] = SimpleListUtil.getSelectDes("T014", data["isNotNull"]);
                        		data["isPrimaryKeyName"] = SimpleListUtil.getSelectDes("T014", data["isPrimaryKey"]);
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
    
    var PlatformIpfDmlViewColumnManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfDmlViewColumn_manage": "showPlatformIpfDmlViewColumnManageList",  
            "basic_manage/platform_ckIpfDmlViewColumn_manage": "showPlatformckIpfDmlViewColumnManageList"
        },
        showPlatformckIpfDmlViewColumnManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfDmlViewColumnManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfDmlViewColumnManageListView = new SimpleListView({
                id: "platform_ipfDmlViewColumn_manage_list",
                title: "数据建模 > 视图字段",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("视图字段");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfDmlViewId' align='right'>视图：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlView'>";                        
                        detailstr+="<input id='ipfDmlViewId' name='ipfDmlViewId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlViewName' name='IpfDmlViewName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lcolumnName' align='right'>字段名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnName' name='字段名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lfieldText' align='right'>字段标题：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldText' name='字段标题' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='数据类型' id='dataType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T013","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lfieldLength' align='right'>字段长度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldLength' name='字段长度' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldecimals' align='right'>小数位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='decimals' name='小数位' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNotNull' name='非空' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisPrimaryKey' align='right'>主键：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isPrimaryKey' name='主键' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfDmlViewColumn.createIpfDmlViewColumn&v=1.0&format=json",$(detailstr),302);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfDmlViewColumnManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfDmlViewColumnManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfDmlViewColumnManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfDmlViewColumn.deleteIpfDmlViewColumn&v=1.0&format=json",
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
                        detailstr+="<label id='lipfDmlViewId' align='right'>视图：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlView'>";                        
                        detailstr+="<input id='ipfDmlViewId' name='ipfDmlViewId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlViewName' name='IpfDmlViewName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lcolumnName' align='right'>字段名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnName' name='字段名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lfieldText' align='right'>字段标题：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldText' name='字段标题' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='数据类型' id='dataType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T013","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lfieldLength' align='right'>字段长度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldLength' name='字段长度' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldecimals' align='right'>小数位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='decimals' name='小数位' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNotNull' name='非空' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisPrimaryKey' align='right'>主键：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isPrimaryKey' name='主键' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfDmlViewColumn.selectIpfDmlViewColumn&v=1.0&format=json",$(detailstr),302);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfDmlViewColumn.selectIpfDmlViewColumn&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfDmlViewId: { type: "string" },columnName: { type: "string" },fieldText: { type: "string" },dataType: { type: "string" },fieldLength: { type: "string" },decimals: { type: "string" },isNotNull: { type: "string" },isPrimaryKey: { type: "string" }
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
                                    data["IpfDmlViewName"] = PlatformIpfDmlViewSelDialog.codetodes(data["ipfDmlViewId"]);
                            		data["dataTypeName"] = SimpleListUtil.getSelectDes("T013", data["dataType"]);
                            		data["isNotNullName"] = SimpleListUtil.getSelectDes("T014", data["isNotNull"]);
                            		data["isPrimaryKeyName"] = SimpleListUtil.getSelectDes("T014", data["isPrimaryKey"]);
                                }
                            }
                            result = platformIpfDmlViewColumnManageListView.appendColValue(result);
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
                    		{field: "ipfDmlViewId", title:"视图", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfDmlViewName", title:"视图", align:"center", width: "100px"},
                    		{field: "columnName", title:"字段名称", align:"center", width: "100px"},
                    		{field: "fieldText", title:"字段标题", align:"center", width: "100px"},
                    		{field: "dataType", title:"数据类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "dataTypeName", title:"数据类型", align:"center", width: "100px"},
                    		{field: "fieldLength", title:"字段长度", align:"center", width: "100px"},
                    		{field: "decimals", title:"小数位", align:"center", width: "100px"},
                    		{field: "isNotNull", title:"非空", hidden:"true", align:"center", width: "100px"},
                    		{field: "isNotNullName", title:"非空", align:"center", width: "100px"},
                    		{field: "isPrimaryKey", title:"主键", hidden:"true", align:"center", width: "100px"},
                    		{field: "isPrimaryKeyName", title:"主键", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfDmlViewColumnManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfDmlViewColumnManageListView.get("columns");
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
                                detailstr+="<label id='lipfDmlViewId' align='right'>视图：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfDmlView'>";                        
                                detailstr+="<input id='ipfDmlViewId' name='ipfDmlViewId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfDmlViewId"]+"' style='...'/>";
                                detailstr+="<input id='IpfDmlViewName' name='IpfDmlViewName' data-bind='value: name' value='"+PlatformIpfDmlViewSelDialog.codetodes(ColumnValue["ipfDmlViewId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lcolumnName' align='right'>字段名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnName' name='字段名称' value='"+ColumnValue["columnName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lfieldText' align='right'>字段标题：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fieldText' name='字段标题' value='"+ColumnValue["fieldText"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='数据类型' id='dataType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T013", ColumnValue["dataType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lfieldLength' align='right'>字段长度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fieldLength' name='字段长度' value='"+ColumnValue["fieldLength"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldecimals' align='right'>小数位：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='decimals' name='小数位' value='"+ColumnValue["decimals"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='isNotNull' name='非空' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isNotNull"]+"' style='...'/>";
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lisPrimaryKey' align='right'>主键：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='isPrimaryKey' name='主键' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isPrimaryKey"]+"' style='...'/>";
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfDmlViewColumn.updateIpfDmlViewColumn&v=1.0&format=json", $(detailstr),302);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfDmlViewColumnManageListView);
        }
    });

    return PlatformIpfDmlViewColumnManageRouter;
});

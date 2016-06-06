
/**
 * IpfDmlIndex
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
    "js/app/ruledesign/routers/PlatformIpfDmlTableSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfDmlTableSelDialog,
		AjaxEngine){    
	
    function showIpfDmlTableSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfDmlTablegrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfDmlTableSelDialog.showGridData($("#IpfDmlTablegrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.tableName;
            $("#ipfDmlTableId").val(Id);
            $("#IpfDmlTableName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 380, height, titles);
        
    	
        
        
        var IpfDmlTableviewModel = kendo.observable({
            id: $("#ipfDmlTableId").val(),
            name: $("#IpfDmlTableName").val(),
            displayGreeting: function() {
            showIpfDmlTableSelDialog();
            }
        });
        kendo.bind($("#viewIpfDmlTable"), IpfDmlTableviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ipfDmlTableId: $("#ipfDmlTableId").val(),indexName: $("#indexName").val(),indexType: $("#indexType").val()},
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
                    data:{id: $("#id").val(),ipfDmlTableId: $("#ipfDmlTableId").val(),indexName: $("#indexName").val(),indexType: $("#indexType").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfDmlTableName"] = PlatformIpfDmlTableSelDialog.codetodes(data["ipfDmlTableId"]);

                        		data["indexTypeName"] = SimpleListUtil.getSelectDes("T048", data["indexType"]);
        						
        						
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
    
    var PlatformIpfDmlIndexManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfDmlIndex_manage": "showPlatformIpfDmlIndexManageList",  
            "basic_manage/platform_ckIpfDmlIndex_manage": "showPlatformckIpfDmlIndexManageList"
        },
        showPlatformckIpfDmlIndexManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfDmlIndexManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfDmlIndexManageListView = new SimpleListView({
                id: "platform_ipfDmlIndex_manage_list",
                title: "数据建模 > 表索引",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("表索引");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfDmlTableId' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlTable'>";                        
                        detailstr+="<input id='ipfDmlTableId' name='ipfDmlTableId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlTableName' name='IpfDmlTableName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lindexName' align='right'>索引名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='indexName' name='索引名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lindexType' align='right'>索引类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='索引类型' id='indexType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T048","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfDmlIndex.createIpfDmlIndex&v=1.0&format=json",$(detailstr),152);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfDmlIndexManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfDmlIndexManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfDmlIndexManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfDmlIndex.deleteIpfDmlIndex&v=1.0&format=json",
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
                        detailstr+="<label id='lipfDmlTableId' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlTable'>";                        
                        detailstr+="<input id='ipfDmlTableId' name='ipfDmlTableId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlTableName' name='IpfDmlTableName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lindexName' align='right'>索引名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='indexName' name='索引名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lindexType' align='right'>索引类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='索引类型' id='indexType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T048","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfDmlIndex.selectIpfDmlIndex&v=1.0&format=json",$(detailstr),152);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfDmlIndex.selectIpfDmlIndex&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfDmlTableId: { type: "string" },indexName: { type: "string" },indexType: { type: "string" }
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
                                    data["IpfDmlTableName"] = PlatformIpfDmlTableSelDialog.codetodes(data["ipfDmlTableId"]);
                            		data["indexTypeName"] = SimpleListUtil.getSelectDes("T048", data["indexType"]);
                                }
                            }
                            result = platformIpfDmlIndexManageListView.appendColValue(result);
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
                    		{field: "ipfDmlTableId", title:"表名", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfDmlTableName", title:"表名", align:"center", width: "100px"},
                    		{field: "indexName", title:"索引名称", align:"center", width: "100px"},
                    		{field: "indexType", title:"索引类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "indexTypeName", title:"索引类型", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfDmlIndexManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfDmlIndexManageListView.get("columns");
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
                                detailstr+="<label id='lipfDmlTableId' align='right'>表名：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfDmlTable'>";                        
                                detailstr+="<input id='ipfDmlTableId' name='ipfDmlTableId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfDmlTableId"]+"' style='...'/>";
                                detailstr+="<input id='IpfDmlTableName' name='IpfDmlTableName' data-bind='value: name' value='"+PlatformIpfDmlTableSelDialog.codetodes(ColumnValue["ipfDmlTableId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lindexName' align='right'>索引名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='indexName' name='索引名称' value='"+ColumnValue["indexName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lindexType' align='right'>索引类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='索引类型' id='indexType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T048", ColumnValue["indexType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfDmlIndex.updateIpfDmlIndex&v=1.0&format=json", $(detailstr),152);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfDmlIndexManageListView);
        }
    });

    return PlatformIpfDmlIndexManageRouter;
});

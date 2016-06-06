
/**
 * IpfDmlIndexColumn
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
    "js/app/ruledesign/routers/PlatformIpfDmlIndexSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfDmlIndexSelDialog,
		AjaxEngine){    
	
    function showIpfDmlIndexSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfDmlIndexgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfDmlIndexSelDialog.showGridData($("#IpfDmlIndexgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.indexName;
            $("#ipfDmlIndexId").val(Id);
            $("#IpfDmlIndexName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 380, height, titles);
        
    	
        
        
        var IpfDmlIndexviewModel = kendo.observable({
            id: $("#ipfDmlIndexId").val(),
            name: $("#IpfDmlIndexName").val(),
            displayGreeting: function() {
            showIpfDmlIndexSelDialog();
            }
        });
        kendo.bind($("#viewIpfDmlIndex"), IpfDmlIndexviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ipfDmlIndexId: $("#ipfDmlIndexId").val(),columnName: $("#columnName").val(),indexOption: $("#indexOption").val()},
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
                    data:{id: $("#id").val(),ipfDmlIndexId: $("#ipfDmlIndexId").val(),columnName: $("#columnName").val(),indexOption: $("#indexOption").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfDmlIndexName"] = PlatformIpfDmlIndexSelDialog.codetodes(data["ipfDmlIndexId"]);

        						
        						
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
    
    var PlatformIpfDmlIndexColumnManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfDmlIndexColumn_manage": "showPlatformIpfDmlIndexColumnManageList",  
            "basic_manage/platform_ckIpfDmlIndexColumn_manage": "showPlatformckIpfDmlIndexColumnManageList"
        },
        showPlatformckIpfDmlIndexColumnManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfDmlIndexColumnManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfDmlIndexColumnManageListView = new SimpleListView({
                id: "platform_ipfDmlIndexColumn_manage_list",
                title: "数据建模 > 表索引字段",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("表索引字段");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfDmlIndexId' align='right'>索引：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlIndex'>";                        
                        detailstr+="<input id='ipfDmlIndexId' name='ipfDmlIndexId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlIndexName' name='IpfDmlIndexName' data-bind='value: name' style='...'/>";
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
                        detailstr+="<label id='lindexOption' align='right'>索引选项：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='indexOption' name='索引选项' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfDmlIndexColumn.createIpfDmlIndexColumn&v=1.0&format=json",$(detailstr),152);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfDmlIndexColumnManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfDmlIndexColumnManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfDmlIndexColumnManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfDmlIndexColumn.deleteIpfDmlIndexColumn&v=1.0&format=json",
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
                        detailstr+="<label id='lipfDmlIndexId' align='right'>索引：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlIndex'>";                        
                        detailstr+="<input id='ipfDmlIndexId' name='ipfDmlIndexId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlIndexName' name='IpfDmlIndexName' data-bind='value: name' style='...'/>";
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
                        detailstr+="<label id='lindexOption' align='right'>索引选项：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='indexOption' name='索引选项' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfDmlIndexColumn.selectIpfDmlIndexColumn&v=1.0&format=json",$(detailstr),152);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfDmlIndexColumn.selectIpfDmlIndexColumn&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfDmlIndexId: { type: "string" },columnName: { type: "string" },indexOption: { type: "string" }
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
                                    data["IpfDmlIndexName"] = PlatformIpfDmlIndexSelDialog.codetodes(data["ipfDmlIndexId"]);
                                }
                            }
                            result = platformIpfDmlIndexColumnManageListView.appendColValue(result);
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
                    		{field: "ipfDmlIndexId", title:"索引", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfDmlIndexName", title:"索引", align:"center", width: "100px"},
                    		{field: "columnName", title:"字段名称", align:"center", width: "100px"},
                    		{field: "indexOption", title:"索引选项", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfDmlIndexColumnManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfDmlIndexColumnManageListView.get("columns");
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
                                detailstr+="<label id='lipfDmlIndexId' align='right'>索引：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfDmlIndex'>";                        
                                detailstr+="<input id='ipfDmlIndexId' name='ipfDmlIndexId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfDmlIndexId"]+"' style='...'/>";
                                detailstr+="<input id='IpfDmlIndexName' name='IpfDmlIndexName' data-bind='value: name' value='"+PlatformIpfDmlIndexSelDialog.codetodes(ColumnValue["ipfDmlIndexId"])+"' style='...'/>";
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
                                detailstr+="<label id='lindexOption' align='right'>索引选项：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='indexOption' name='索引选项' value='"+ColumnValue["indexOption"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfDmlIndexColumn.updateIpfDmlIndexColumn&v=1.0&format=json", $(detailstr),152);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfDmlIndexColumnManageListView);
        }
    });

    return PlatformIpfDmlIndexColumnManageRouter;
});

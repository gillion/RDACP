
/**
 * 常用代码
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
    "js/app/member/routers/PlatformComstyleSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformComstyleSelDialog,
		AjaxEngine){    
	
    function showComstyleSelDialog(){
        var detailstr="";
        detailstr+="<div id='Comstylegrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformComstyleSelDialog.showGridData($("#Comstylegrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.name;
            $("#typecode").val(Id);
            $("#ComstyleName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, 190, titles);
    	
        var ComstyleviewModel = kendo.observable({
            id: $("#typecode").val(),
            name: $("#ComstyleName").val(),
            displayGreeting: function() {
            showComstyleSelDialog();
            }
        });
        kendo.bind($("#viewComstyle"), ComstyleviewModel);
        
        if (tp==1){
        $("#submitBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),typecode: $("#typecode").val(),code: $("#code").val(),name: $("#name").val(),shortname: $("#shortname").val()},
                    dataType: 'json',
                    complete: function(transport){
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("操作成功！");
                        kendoUIWindow.close();
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                    }
                }
            );
        });
    	} else{
        $("#QueryBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),typecode: $("#typecode").val(),code: $("#code").val(),name: $("#name").val(),shortname: $("#shortname").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["ComstyleName"] = PlatformComstyleSelDialog.codetodes(data["typecode"]);

                            }
                        }
                        
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.data([]);
                        table0.dataSource.data(result.resultJson);
                        kendoUIWindow.close();
                    }
                }
            );
        });
    	}
        SimpleListUtil.setDataTimeCn();

        
    }
    
    var PlatformComcodeManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_Comcode_manage": "showPlatformComcodeManageList",  
            "basic_manage/platform_ckComcode_manage": "showPlatformckComcodeManageList"
        },
        showPlatformckComcodeManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformComcodeManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformComcodeManageListView = new SimpleListView({
                id: "platform_comcode_manage_list",
                title: "基础管理 > 常用代码",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("常用代码");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='代码编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltypecode' align='right'>代码类别：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewComstyle'>";                        
                        detailstr+="<input id='typecode' name='typecode' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='ComstyleName' name='ComstyleName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";

						
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcode' align='right'>常用代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='code' name='常用代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>中文名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='name' name='中文名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshortname' align='right'>缩写简称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='shortname' name='缩写简称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=comcode.createComcode&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformComcodeManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformComcodeManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformComcodeManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=comcode.deleteComcode&v=1.0&format=json",
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
                        detailstr+="<input id='id' name='代码编号' hidden='true' style='...'/>";                          

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltypecode' align='right'>代码类别：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewComstyle'>";                        
                        detailstr+="<input id='typecode' name='typecode' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='ComstyleName' name='ComstyleName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";

						
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcode' align='right'>常用代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='code' name='常用代码' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>中文名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='name' name='中文名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshortname' align='right'>缩写简称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='shortname' name='缩写简称' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=comcode.selectComcode&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    serverSorting: false,             //排序
                    serverGrouping: false,            //分组
                    group: { field: "ComstyleName" },
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=comcode.selectComcode&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },typecode: { type: "string" },code: { type: "number" },name: { type: "string" },shortname: { type: "string" }
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
                                    data["ComstyleName"] = PlatformComstyleSelDialog.codetodes(data["typecode"]);
                                }
                            }
                            result = platformComcodeManageListView.appendColValue(result);
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
                          {field: "id", title:"代码编号", hidden:"true", align:"center", width: "100px"},
                    		{field: "typecode", title:"代码类别", hidden:"true", align:"center", width: "100px"},
                    		{field: "ComstyleName", title:"代码类别", align:"center", width: "100px"},
                    		{field: "code", title:"常用代码", align:"center", width: "100px"},
                    		{field: "name", title:"中文名称", align:"center", width: "100px"},
                    		{field: "shortname", title:"缩写简称", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformComcodeManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformComcodeManageListView.get("columns");
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
                                detailstr+="<input id='id' name='代码编号' hidden='true' value='"+ColumnValue["id"]+"' style='...'/>";

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltypecode' align='right'>代码类别：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewComstyle'>";
                                detailstr+="<input id='typecode' name='typecode' hidden='true' data-bind='value: id' value='"+ColumnValue["typecode"]+"' style='...'/>";
                                detailstr+="<input id='ComstyleName' name='ComstyleName' data-bind='value: name' value='"+PlatformComstyleSelDialog.codetodes(ColumnValue["typecode"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";


                                detailstr+="</td></tr>";


                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcode' align='right'>常用代码：</label>";
                                detailstr+="</td><td>";


                        		detailstr+="<input id='code' name='常用代码' value='"+ColumnValue["code"]+"' style='...'/>";
                                detailstr+="</td></tr>";


                                detailstr+="<tr><td>";
                                detailstr+="<label id='lname' align='right'>中文名称：</label>";
                                detailstr+="</td><td>";


                        		detailstr+="<input id='name' name='中文名称' value='"+ColumnValue["name"]+"' style='...'/>";
                                detailstr+="</td></tr>";


                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshortname' align='right'>缩写简称：</label>";
                                detailstr+="</td><td>";


                        		detailstr+="<input id='shortname' name='缩写简称' value='"+ColumnValue["shortname"]+"' style='...'/>";
                                detailstr+="</td></tr>";

				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=comcode.updateComcode&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformComcodeManageListView);
        }
    });

    return PlatformComcodeManageRouter;
});

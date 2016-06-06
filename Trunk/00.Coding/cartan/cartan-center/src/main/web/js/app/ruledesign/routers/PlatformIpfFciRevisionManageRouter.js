
/**
 * IpfFciRevision
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
    "js/app/ruledesign/routers/PlatformIpfFciViewSelDialog",
    "js/app/ruledesign/routers/PlatformIpfFciProjectSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfFciViewSelDialog,
		PlatformIpfFciProjectSelDialog,
		AjaxEngine){    
	
    function showIpfFciViewSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfFciViewgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfFciViewSelDialog.showGridData($("#IpfFciViewgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.viewName;
            $("#ipfFciViewId").val(Id);
            $("#IpfFciViewName").val(Name);
            kendoUIWindow.close();
        });
    }
    function showIpfFciProjectSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfFciProjectgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfFciProjectSelDialog.showGridData($("#IpfFciProjectgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.projectDes;
            $("#ipfFciProjectId").val(Id);
            $("#IpfFciProjectName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 730, height, titles);
        
    	
        
        
        var IpfFciViewviewModel = kendo.observable({
            id: $("#ipfFciViewId").val(),
            name: $("#IpfFciViewName").val(),
            displayGreeting: function() {
            showIpfFciViewSelDialog();
            }
        });
        kendo.bind($("#viewIpfFciView"), IpfFciViewviewModel);
        var IpfFciProjectviewModel = kendo.observable({
            id: $("#ipfFciProjectId").val(),
            name: $("#IpfFciProjectName").val(),
            displayGreeting: function() {
            showIpfFciProjectSelDialog();
            }
        });
        kendo.bind($("#viewIpfFciProject"), IpfFciProjectviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ipfFciViewId: $("#ipfFciViewId").val(),ipfFciProjectId: $("#ipfFciProjectId").val(),revisionNumber: $("#revisionNumber").val(),remark: $("#remark").val()},
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
                    data:{id: $("#id").val(),ipfFciViewId: $("#ipfFciViewId").val(),ipfFciProjectId: $("#ipfFciProjectId").val(),revisionNumber: $("#revisionNumber").val(),remark: $("#remark").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfFciViewName"] = PlatformIpfFciViewSelDialog.codetodes(data["ipfFciViewId"]);
                                data["IpfFciProjectName"] = PlatformIpfFciProjectSelDialog.codetodes(data["ipfFciProjectId"]);

        						
        						
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
    
    var PlatformIpfFciRevisionManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfFciRevision_manage": "showPlatformIpfFciRevisionManageList",  
            "basic_manage/platform_ckIpfFciRevision_manage": "showPlatformckIpfFciRevisionManageList"
        },
        showPlatformckIpfFciRevisionManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfFciRevisionManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfFciRevisionManageListView = new SimpleListView({
                id: "platform_ipfFciRevision_manage_list",
                title: "项目管理 > 视图修订号",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("视图修订号");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfFciViewId' align='right'>视图：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciView'>";                        
                        detailstr+="<input id='ipfFciViewId' name='ipfFciViewId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciViewName' name='IpfFciViewName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lipfFciProjectId' align='right'>项目：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciProject'>";                        
                        detailstr+="<input id='ipfFciProjectId' name='ipfFciProjectId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciProjectName' name='IpfFciProjectName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lrevisionNumber' align='right'>修订号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='revisionNumber' name='修订号' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfFciRevision.createIpfFciRevision&v=1.0&format=json",$(detailstr),124);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfFciRevisionManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfFciRevisionManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfFciRevisionManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfFciRevision.deleteIpfFciRevision&v=1.0&format=json",
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
                        detailstr+="<label id='lipfFciViewId' align='right'>视图：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciView'>";                        
                        detailstr+="<input id='ipfFciViewId' name='ipfFciViewId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciViewName' name='IpfFciViewName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lipfFciProjectId' align='right'>项目：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciProject'>";                        
                        detailstr+="<input id='ipfFciProjectId' name='ipfFciProjectId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciProjectName' name='IpfFciProjectName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lrevisionNumber' align='right'>修订号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='revisionNumber' name='修订号' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfFciRevision.selectIpfFciRevision&v=1.0&format=json",$(detailstr),124);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfFciRevision.selectIpfFciRevision&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfFciViewId: { type: "string" },ipfFciProjectId: { type: "string" },revisionNumber: { type: "string" },remark: { type: "string" }
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
                                    data["IpfFciViewName"] = PlatformIpfFciViewSelDialog.codetodes(data["ipfFciViewId"]);
                                    data["IpfFciProjectName"] = PlatformIpfFciProjectSelDialog.codetodes(data["ipfFciProjectId"]);
                                }
                            }
                            result = platformIpfFciRevisionManageListView.appendColValue(result);
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
                    		{field: "ipfFciViewId", title:"视图", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfFciViewName", title:"视图", align:"center", width: "100px"},
                    		{field: "ipfFciProjectId", title:"项目", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfFciProjectName", title:"项目", align:"center", width: "100px"},
                    		{field: "revisionNumber", title:"修订号", align:"center", width: "100px"},
                    		{field: "remark", title:"备注", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfFciRevisionManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfFciRevisionManageListView.get("columns");
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
                                detailstr+="<label id='lipfFciViewId' align='right'>视图：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfFciView'>";                        
                                detailstr+="<input id='ipfFciViewId' name='ipfFciViewId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfFciViewId"]+"' style='...'/>";
                                detailstr+="<input id='IpfFciViewName' name='IpfFciViewName' data-bind='value: name' value='"+PlatformIpfFciViewSelDialog.codetodes(ColumnValue["ipfFciViewId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lipfFciProjectId' align='right'>项目：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfFciProject'>";                        
                                detailstr+="<input id='ipfFciProjectId' name='ipfFciProjectId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfFciProjectId"]+"' style='...'/>";
                                detailstr+="<input id='IpfFciProjectName' name='IpfFciProjectName' data-bind='value: name' value='"+PlatformIpfFciProjectSelDialog.codetodes(ColumnValue["ipfFciProjectId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lrevisionNumber' align='right'>修订号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='revisionNumber' name='修订号' value='"+ColumnValue["revisionNumber"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='remark' name='备注' value='"+ColumnValue["remark"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfFciRevision.updateIpfFciRevision&v=1.0&format=json", $(detailstr),124);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfFciRevisionManageListView);
        }
    });

    return PlatformIpfFciRevisionManageRouter;
});

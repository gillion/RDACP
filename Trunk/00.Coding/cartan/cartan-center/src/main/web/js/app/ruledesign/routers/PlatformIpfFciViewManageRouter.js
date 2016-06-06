
/**
 * IpfFciView
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
    "js/app/ruledesign/routers/PlatformIpfFciProjectSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfFciProjectSelDialog,
		AjaxEngine){    
	
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
        
    	
        
        
        var IpfFciProjectviewModel = kendo.observable({
            id: $("#ipfFciProjectId").val(),
            name: $("#IpfFciProjectName").val(),
            displayGreeting: function() {
            showIpfFciProjectSelDialog();
            }
        });
        kendo.bind($("#viewIpfFciProject"), IpfFciProjectviewModel);

        var isActiveModel = kendo.observable({
            isChecked: $("#isActive").val()=="1"
        });
        kendo.bind($("#isActive"), isActiveModel);
        var isActiveval="0";
		
        var isPermissionPageOnlyModel = kendo.observable({
            isChecked: $("#isPermissionPageOnly").val()=="1"
        });
        kendo.bind($("#isPermissionPageOnly"), isPermissionPageOnlyModel);
        var isPermissionPageOnlyval="0";
		
        if (tp==1){
        $("#submitBtn").click(function(){    	
            if (isActiveModel.isChecked){
            	isActiveval="1";
            } else {
            	isActiveval="0";
            }
            if (isPermissionPageOnlyModel.isChecked){
            	isPermissionPageOnlyval="1";
            } else {
            	isPermissionPageOnlyval="0";
            }
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),viewName: $("#viewName").val(),projectName: $("#projectName").val(),viewDesc: $("#viewDesc").val(),svnBranchesPath: $("#svnBranchesPath").val(),isActive: isActiveval,connectionString: $("#connectionString").val(),ipfFciProjectId: $("#ipfFciProjectId").val(),sourceLabelId: $("#sourceLabelId").val(),isPermissionPageOnly: isPermissionPageOnlyval},
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
                if (isActiveModel.isChecked){
                	isActiveval="1";
                } else {
                	isActiveval="";
                }
                if (isPermissionPageOnlyModel.isChecked){
                	isPermissionPageOnlyval="1";
                } else {
                	isPermissionPageOnlyval="";
                }
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),viewName: $("#viewName").val(),projectName: $("#projectName").val(),viewDesc: $("#viewDesc").val(),svnBranchesPath: $("#svnBranchesPath").val(),isActive:isActiveval,connectionString: $("#connectionString").val(),ipfFciProjectId: $("#ipfFciProjectId").val(),sourceLabelId: $("#sourceLabelId").val(),isPermissionPageOnly:isPermissionPageOnlyval},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfFciProjectName"] = PlatformIpfFciProjectSelDialog.codetodes(data["ipfFciProjectId"]);

        						
        						
                        		data["isActiveName"] = SimpleListUtil.getSelectDes("T014", data["isActive"]);
                        		data["isPermissionPageOnlyName"] = SimpleListUtil.getSelectDes("T014", data["isPermissionPageOnly"]);
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
    
    var PlatformIpfFciViewManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfFciView_manage": "showPlatformIpfFciViewManageList",  
            "basic_manage/platform_ckIpfFciView_manage": "showPlatformckIpfFciViewManageList"
        },
        showPlatformckIpfFciViewManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfFciViewManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfFciViewManageListView = new SimpleListView({
                id: "platform_ipfFciView_manage_list",
                title: "项目管理 > 视图管理",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("视图管理");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lviewName' align='right'>视图名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='viewName' name='视图名称' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lprojectName' align='right'>项目名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectName' name='项目名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lviewDesc' align='right'>视图描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='viewDesc' name='视图描述' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lsvnBranchesPath' align='right'>SVN路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='svnBranchesPath' name='SVN路径' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisActive' align='right'>启用：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='启用' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lconnectionString' align='right'>目标数据库连接：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='connectionString' name='目标数据库连接' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfFciProjectId' align='right'>所属项目：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciProject'>";                        
                        detailstr+="<input id='ipfFciProjectId' name='ipfFciProjectId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciProjectName' name='IpfFciProjectName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lsourceLabelId' align='right'>基线名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sourceLabelId' name='基线名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisPermissionPageOnly' align='right'>只生成页面权限：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isPermissionPageOnly' name='只生成页面权限' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfFciView.createIpfFciView&v=1.0&format=json",$(detailstr),212);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfFciViewManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfFciViewManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfFciViewManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfFciView.deleteIpfFciView&v=1.0&format=json",
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
                        detailstr+="<label id='lviewName' align='right'>视图名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='viewName' name='视图名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lprojectName' align='right'>项目名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectName' name='项目名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lviewDesc' align='right'>视图描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='viewDesc' name='视图描述' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lsvnBranchesPath' align='right'>SVN路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='svnBranchesPath' name='SVN路径' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisActive' align='right'>启用：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='启用' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lconnectionString' align='right'>目标数据库连接：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='connectionString' name='目标数据库连接' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfFciProjectId' align='right'>所属项目：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciProject'>";                        
                        detailstr+="<input id='ipfFciProjectId' name='ipfFciProjectId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciProjectName' name='IpfFciProjectName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lsourceLabelId' align='right'>基线名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sourceLabelId' name='基线名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisPermissionPageOnly' align='right'>只生成页面权限：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isPermissionPageOnly' name='只生成页面权限' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfFciView.selectIpfFciView&v=1.0&format=json",$(detailstr),212);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfFciView.selectIpfFciView&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },viewName: { type: "string" },projectName: { type: "string" },viewDesc: { type: "string" },svnBranchesPath: { type: "string" },isActive: { type: "string" },connectionString: { type: "string" },ipfFciProjectId: { type: "string" },sourceLabelId: { type: "string" },isPermissionPageOnly: { type: "string" }
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
                                    data["IpfFciProjectName"] = PlatformIpfFciProjectSelDialog.codetodes(data["ipfFciProjectId"]);
                            		data["isActiveName"] = SimpleListUtil.getSelectDes("T014", data["isActive"]);
                            		data["isPermissionPageOnlyName"] = SimpleListUtil.getSelectDes("T014", data["isPermissionPageOnly"]);
                                }
                            }
                            result = platformIpfFciViewManageListView.appendColValue(result);
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
                    		{field: "viewName", title:"视图名称", align:"center", width: "100px"},
                    		{field: "projectName", title:"项目名称", align:"center", width: "100px"},
                    		{field: "viewDesc", title:"视图描述", align:"center", width: "100px"},
                    		{field: "svnBranchesPath", title:"SVN路径", align:"center", width: "100px"},
                    		{field: "isActive", title:"启用", hidden:"true", align:"center", width: "100px"},
                    		{field: "isActiveName", title:"启用", align:"center", width: "100px"},
                    		{field: "connectionString", title:"目标数据库连接", align:"center", width: "100px"},
                    		{field: "ipfFciProjectId", title:"所属项目", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfFciProjectName", title:"所属项目", align:"center", width: "100px"},
                    		{field: "sourceLabelId", title:"基线名称", align:"center", width: "100px"},
                    		{field: "isPermissionPageOnly", title:"只生成页面权限", hidden:"true", align:"center", width: "100px"},
                    		{field: "isPermissionPageOnlyName", title:"只生成页面权限", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfFciViewManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfFciViewManageListView.get("columns");
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
                                detailstr+="<label id='lviewName' align='right'>视图名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='viewName' name='视图名称' value='"+ColumnValue["viewName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lprojectName' align='right'>项目名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='projectName' name='项目名称' value='"+ColumnValue["projectName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lviewDesc' align='right'>视图描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='viewDesc' name='视图描述' value='"+ColumnValue["viewDesc"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lsvnBranchesPath' align='right'>SVN路径：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='svnBranchesPath' name='SVN路径' value='"+ColumnValue["svnBranchesPath"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lisActive' align='right'>启用：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='isActive' name='启用' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isActive"]+"' style='...'/>";
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lconnectionString' align='right'>目标数据库连接：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='connectionString' name='目标数据库连接' value='"+ColumnValue["connectionString"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lipfFciProjectId' align='right'>所属项目：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfFciProject'>";                        
                                detailstr+="<input id='ipfFciProjectId' name='ipfFciProjectId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfFciProjectId"]+"' style='...'/>";
                                detailstr+="<input id='IpfFciProjectName' name='IpfFciProjectName' data-bind='value: name' value='"+PlatformIpfFciProjectSelDialog.codetodes(ColumnValue["ipfFciProjectId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lsourceLabelId' align='right'>基线名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='sourceLabelId' name='基线名称' value='"+ColumnValue["sourceLabelId"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lisPermissionPageOnly' align='right'>只生成页面权限：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='isPermissionPageOnly' name='只生成页面权限' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isPermissionPageOnly"]+"' style='...'/>";
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfFciView.updateIpfFciView&v=1.0&format=json", $(detailstr),212);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfFciViewManageListView);
        }
    });

    return PlatformIpfFciViewManageRouter;
});

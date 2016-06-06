
/**
 * IpfFciProject
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
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		AjaxEngine){    
	
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 730, height, titles);
        
    	
        
        

        var isActiveModel = kendo.observable({
            isChecked: $("#isActive").val()=="1"
        });
        kendo.bind($("#isActive"), isActiveModel);
        var isActiveval="0";
		
        if (tp==1){
        $("#submitBtn").click(function(){    	
            if (isActiveModel.isChecked){
            	isActiveval="1";
            } else {
            	isActiveval="0";
            }
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),projectName: $("#projectName").val(),projectType: $("#projectType").val(),projectDes: $("#projectDes").val(),defaultViewId: $("#defaultViewId").val(),svnRepositoryPath: $("#svnRepositoryPath").val(),svnUser: $("#svnUser").val(),svnPassword: $("#svnPassword").val(),maxRevisonNumber: $("#maxRevisonNumber").val(),ddLanguage: $("#ddLanguage").val(),dbType: $("#dbType").val(),dbVersion: $("#dbVersion").val(),isActive: isActiveval},
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
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),projectName: $("#projectName").val(),projectType: $("#projectType").val(),projectDes: $("#projectDes").val(),defaultViewId: $("#defaultViewId").val(),svnRepositoryPath: $("#svnRepositoryPath").val(),svnUser: $("#svnUser").val(),svnPassword: $("#svnPassword").val(),maxRevisonNumber: $("#maxRevisonNumber").val(),ddLanguage: $("#ddLanguage").val(),dbType: $("#dbType").val(),dbVersion: $("#dbVersion").val(),isActive:isActiveval},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];

                        		data["projectTypeName"] = SimpleListUtil.getSelectDes("T002", data["projectType"]);
                        		data["ddLanguageName"] = SimpleListUtil.getSelectDes("T004", data["ddLanguage"]);
                        		data["dbTypeName"] = SimpleListUtil.getSelectDes("T004", data["dbType"]);
        						
        						
                        		data["isActiveName"] = SimpleListUtil.getSelectDes("T014", data["isActive"]);
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
    
    var PlatformIpfFciProjectManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfFciProject_manage": "showPlatformIpfFciProjectManageList",  
            "basic_manage/platform_ckIpfFciProject_manage": "showPlatformckIpfFciProjectManageList"
        },
        showPlatformckIpfFciProjectManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfFciProjectManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfFciProjectManageListView = new SimpleListView({
                id: "platform_ipfFciProject_manage_list",
                title: "项目管理 > 项目管理",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("项目管理");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lprojectName' align='right'>项目名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectName' name='项目名称' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lprojectType' align='right'>项目类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='项目类型' id='projectType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T002","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lprojectDes' align='right'>项目描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectDes' name='项目描述' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ldefaultViewId' align='right'>默认视图：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultViewId' name='默认视图' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsvnRepositoryPath' align='right'>SVN路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='svnRepositoryPath' name='SVN路径' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lsvnUser' align='right'>SVN帐户：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='svnUser' name='SVN帐户' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsvnPassword' align='right'>SVN密码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='svnPassword' name='SVN密码' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lmaxRevisonNumber' align='right'>最大修订号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='maxRevisonNumber' name='最大修订号' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lddLanguage' align='right'>默认语言：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='默认语言' id='ddLanguage' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T004","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ldbType' align='right'>数据库类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='数据库类型' id='dbType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T004","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldbVersion' align='right'>数据库版本号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dbVersion' name='数据库版本号' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lisActive' align='right'>启用：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='启用' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfFciProject.createIpfFciProject&v=1.0&format=json",$(detailstr),240);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfFciProjectManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfFciProjectManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfFciProjectManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfFciProject.deleteIpfFciProject&v=1.0&format=json",
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
                        detailstr+="<label id='lprojectName' align='right'>项目名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectName' name='项目名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lprojectType' align='right'>项目类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='项目类型' id='projectType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T002","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lprojectDes' align='right'>项目描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectDes' name='项目描述' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='ldefaultViewId' align='right'>默认视图：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultViewId' name='默认视图' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsvnRepositoryPath' align='right'>SVN路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='svnRepositoryPath' name='SVN路径' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lsvnUser' align='right'>SVN帐户：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='svnUser' name='SVN帐户' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsvnPassword' align='right'>SVN密码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='svnPassword' name='SVN密码' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lmaxRevisonNumber' align='right'>最大修订号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='maxRevisonNumber' name='最大修订号' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lddLanguage' align='right'>默认语言：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='默认语言' id='ddLanguage' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T004","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='ldbType' align='right'>数据库类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='数据库类型' id='dbType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T004","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldbVersion' align='right'>数据库版本号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dbVersion' name='数据库版本号' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lisActive' align='right'>启用：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='启用' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfFciProject.selectIpfFciProject&v=1.0&format=json",$(detailstr),240);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfFciProject.selectIpfFciProject&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },projectName: { type: "string" },projectType: { type: "string" },projectDes: { type: "string" },defaultViewId: { type: "string" },svnRepositoryPath: { type: "string" },svnUser: { type: "string" },svnPassword: { type: "string" },maxRevisonNumber: { type: "string" },ddLanguage: { type: "string" },dbType: { type: "string" },dbVersion: { type: "string" },isActive: { type: "string" }
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
                            		data["projectTypeName"] = SimpleListUtil.getSelectDes("T002", data["projectType"]);
                            		data["ddLanguageName"] = SimpleListUtil.getSelectDes("T004", data["ddLanguage"]);
                            		data["dbTypeName"] = SimpleListUtil.getSelectDes("T004", data["dbType"]);
                            		data["isActiveName"] = SimpleListUtil.getSelectDes("T014", data["isActive"]);
                                }
                            }
                            result = platformIpfFciProjectManageListView.appendColValue(result);
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
                    		{field: "projectName", title:"项目名称", align:"center", width: "100px"},
                    		{field: "projectType", title:"项目类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "projectTypeName", title:"项目类型", align:"center", width: "100px"},
                    		{field: "projectDes", title:"项目描述", align:"center", width: "100px"},
                    		{field: "defaultViewId", title:"默认视图", align:"center", width: "100px"},
                    		{field: "svnRepositoryPath", title:"SVN路径", align:"center", width: "100px"},
                    		{field: "svnUser", title:"SVN帐户", align:"center", width: "100px"},
                    		{field: "svnPassword", title:"SVN密码", align:"center", width: "100px"},
                    		{field: "maxRevisonNumber", title:"最大修订号", align:"center", width: "100px"},
                    		{field: "ddLanguage", title:"默认语言", hidden:"true", align:"center", width: "100px"},
                    		{field: "ddLanguageName", title:"默认语言", align:"center", width: "100px"},
                    		{field: "dbType", title:"数据库类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "dbTypeName", title:"数据库类型", align:"center", width: "100px"},
                    		{field: "dbVersion", title:"数据库版本号", align:"center", width: "100px"},
                    		{field: "isActive", title:"启用", hidden:"true", align:"center", width: "100px"},
                    		{field: "isActiveName", title:"启用", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfFciProjectManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfFciProjectManageListView.get("columns");
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
                                detailstr+="<label id='lprojectName' align='right'>项目名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='projectName' name='项目名称' value='"+ColumnValue["projectName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lprojectType' align='right'>项目类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='项目类型' id='projectType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T002", ColumnValue["projectType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lprojectDes' align='right'>项目描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='projectDes' name='项目描述' value='"+ColumnValue["projectDes"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldefaultViewId' align='right'>默认视图：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='defaultViewId' name='默认视图' value='"+ColumnValue["defaultViewId"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lsvnRepositoryPath' align='right'>SVN路径：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='svnRepositoryPath' name='SVN路径' value='"+ColumnValue["svnRepositoryPath"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lsvnUser' align='right'>SVN帐户：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='svnUser' name='SVN帐户' value='"+ColumnValue["svnUser"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lsvnPassword' align='right'>SVN密码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='svnPassword' name='SVN密码' value='"+ColumnValue["svnPassword"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lmaxRevisonNumber' align='right'>最大修订号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='maxRevisonNumber' name='最大修订号' value='"+ColumnValue["maxRevisonNumber"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lddLanguage' align='right'>默认语言：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='默认语言' id='ddLanguage' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T004", ColumnValue["ddLanguage"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldbType' align='right'>数据库类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='数据库类型' id='dbType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T004", ColumnValue["dbType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldbVersion' align='right'>数据库版本号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dbVersion' name='数据库版本号' value='"+ColumnValue["dbVersion"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lisActive' align='right'>启用：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='isActive' name='启用' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isActive"]+"' style='...'/>";
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfFciProject.updateIpfFciProject&v=1.0&format=json", $(detailstr),240);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfFciProjectManageListView);
        }
    });

    return PlatformIpfFciProjectManageRouter;
});

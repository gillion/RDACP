
/**
 * IpfCcmEnvironment
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
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 700, height, titles);
        
    	
        
        

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),userCode: $("#userCode").val(),projectName: $("#projectName").val(),projectPath: $("#projectPath").val(),srcPath: $("#srcPath").val(),templatePath: $("#templatePath").val(),webContentName: $("#webContentName").val(),targetProjectName: $("#targetProjectName").val(),targetProjectPath: $("#targetProjectPath").val()},
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
                    data:{id: $("#id").val(),userCode: $("#userCode").val(),projectName: $("#projectName").val(),projectPath: $("#projectPath").val(),srcPath: $("#srcPath").val(),templatePath: $("#templatePath").val(),webContentName: $("#webContentName").val(),targetProjectName: $("#targetProjectName").val(),targetProjectPath: $("#targetProjectPath").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];

        						
        						
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
    
    var PlatformIpfCcmEnvironmentManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmEnvironment_manage": "showPlatformIpfCcmEnvironmentManageList",  
            "basic_manage/platform_ckIpfCcmEnvironment_manage": "showPlatformckIpfCcmEnvironmentManageList"
        },
        showPlatformckIpfCcmEnvironmentManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmEnvironmentManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmEnvironmentManageListView = new SimpleListView({
                id: "platform_ipfCcmEnvironment_manage_list",
                title: "基础管理 > 代码生成环境配置",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("代码生成环境配置");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='luserCode' align='right'>工程代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='userCode' name='工程代码' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lprojectName' align='right'>工程名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectName' name='工程名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lprojectPath' align='right'>工程路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectPath' name='工程路径' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lsrcPath' align='right'>原代码路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='srcPath' name='原代码路径' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplatePath' align='right'>模板工程目录：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templatePath' name='模板工程目录' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lwebContentName' align='right'>模板工程名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='webContentName' name='模板工程名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltargetProjectName' align='right'>分支工程名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='targetProjectName' name='分支工程名称' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ltargetProjectPath' align='right'>分支工程路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='targetProjectPath' name='分支工程路径' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmEnvironment.createIpfCcmEnvironment&v=1.0&format=json",$(detailstr),180);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmEnvironmentManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmEnvironmentManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmEnvironmentManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmEnvironment.deleteIpfCcmEnvironment&v=1.0&format=json",
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
                        detailstr+="<label id='luserCode' align='right'>工程代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='userCode' name='工程代码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectName' align='right'>工程名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectName' name='工程名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectPath' align='right'>工程路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='projectPath' name='工程路径' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsrcPath' align='right'>原代码路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='srcPath' name='原代码路径' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemplatePath' align='right'>模板工程目录：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templatePath' name='模板工程目录' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lwebContentName' align='right'>模板工程名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='webContentName' name='模板工程名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltargetProjectName' align='right'>分支工程名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='targetProjectName' name='分支工程名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltargetProjectPath' align='right'>分支工程路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='targetProjectPath' name='分支工程路径' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmEnvironment.selectIpfCcmEnvironment&v=1.0&format=json",$(detailstr),280);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmEnvironment.selectIpfCcmEnvironment&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },userCode: { type: "string" },projectName: { type: "string" },projectPath: { type: "string" },srcPath: { type: "string" },templatePath: { type: "string" },webContentName: { type: "string" },targetProjectName: { type: "string" },targetProjectPath: { type: "string" }
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
                                }
                            }
                            result = platformIpfCcmEnvironmentManageListView.appendColValue(result);
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
                    		{field: "userCode", title:"工程代码", align:"center", width: "100px"},
                    		{field: "projectName", title:"工程名称", align:"center", width: "100px"},
                    		{field: "projectPath", title:"工程路径", align:"center", width: "100px"},
                    		{field: "srcPath", title:"原代码路径", align:"center", width: "100px"},
                    		{field: "templatePath", title:"模板工程目录", align:"center", width: "100px"},
                    		{field: "webContentName", title:"模板工程名称", align:"center", width: "100px"},
                    		{field: "targetProjectName", title:"分支工程名称", align:"center", width: "100px"},
                    		{field: "targetProjectPath", title:"分支工程路径", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmEnvironmentManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmEnvironmentManageListView.get("columns");
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
                                detailstr+="<label id='luserCode' align='right'>工程代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='userCode' name='工程代码' value='"+ColumnValue["userCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprojectName' align='right'>工程名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='projectName' name='工程名称' value='"+ColumnValue["projectName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprojectPath' align='right'>工程路径：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='projectPath' name='工程路径' value='"+ColumnValue["projectPath"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsrcPath' align='right'>原代码路径：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='srcPath' name='原代码路径' value='"+ColumnValue["srcPath"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltemplatePath' align='right'>模板工程目录：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='templatePath' name='模板工程目录' value='"+ColumnValue["templatePath"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lwebContentName' align='right'>模板工程名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='webContentName' name='模板工程名称' value='"+ColumnValue["webContentName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltargetProjectName' align='right'>分支工程名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='targetProjectName' name='分支工程名称' value='"+ColumnValue["targetProjectName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltargetProjectPath' align='right'>分支工程路径：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='targetProjectPath' name='分支工程路径' value='"+ColumnValue["targetProjectPath"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmEnvironment.updateIpfCcmEnvironment&v=1.0&format=json", $(detailstr),280);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmEnvironmentManageListView);
        }
    });

    return PlatformIpfCcmEnvironmentManageRouter;
});

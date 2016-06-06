
/**
 * LoginUser
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
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, height, titles);
        
    	
        
        

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),user: $("#user").val(),pwd: $("#pwd").val(),power: $("#power").val()},
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
                    data:{id: $("#id").val(),user: $("#user").val(),pwd: $("#pwd").val(),power: $("#power").val()},
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
    
    var PlatformLoginUserManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_LoginUser_manage": "showPlatformLoginUserManageList",  
            "basic_manage/platform_ckLoginUser_manage": "showPlatformckLoginUserManageList"
        },
        showPlatformckLoginUserManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformLoginUserManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformLoginUserManageListView = new SimpleListView({
                id: "platform_loginUser_manage_list",
                title: "基础管理 > LoginUser",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("LoginUser");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luser' align='right'>账号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='user' name='账号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpwd' align='right'>密码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='pwd' name='密码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpower' align='right'>权限：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='power' name='权限' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=loginUser.createLoginUser&v=1.0&format=json",$(detailstr),130);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformLoginUserManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformLoginUserManageListView.getGridObject().select().get(i);
                            var id = SimpleListUtil.getColumnValue(platformLoginUserManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=loginUser.deleteLoginUser&v=1.0&format=json",
                            {
                                async: false,
                                data:{id: id},
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
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luser' align='right'>账号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='user' name='账号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpwd' align='right'>密码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='pwd' name='密码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpower' align='right'>权限：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='power' name='权限' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=loginUser.selectLoginUser&v=1.0&format=json",$(detailstr),130);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=loginUser.selectLoginUser&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },user: { type: "string" },pwd: { type: "string" },power: { type: "string" }
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
                            result = platformLoginUserManageListView.appendColValue(result);
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
                          {field: "chk", type:"chk", title: "&nbsp;", value:"id"},
                          {field: "id", title:"编号", hidden:"true", align:"center", width: "100px"},
                    		{field: "user", title:"账号", align:"center", width: "100px"},
                    		{field: "pwd", title:"密码", align:"center", width: "100px"},
                    		{field: "power", title:"权限", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformLoginUserManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformLoginUserManageListView.get("columns");
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
                                detailstr+="<input id='id' name='编号' hidden='true' value='"+ColumnValue["id"]+"' style='...'/>";

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luser' align='right'>账号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='user' name='账号' value='"+ColumnValue["user"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpwd' align='right'>密码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='pwd' name='密码' value='"+ColumnValue["pwd"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpower' align='right'>权限：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='power' name='权限' value='"+ColumnValue["power"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=loginUser.updateLoginUser&v=1.0&format=json", $(detailstr),130);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformLoginUserManageListView);
        }
    });

    return PlatformLoginUserManageRouter;
});

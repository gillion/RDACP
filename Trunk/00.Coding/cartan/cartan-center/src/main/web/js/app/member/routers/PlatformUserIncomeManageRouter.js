
/**
 * 员工入职信息
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
	
    
    function showEditDetilDialog(tp, titles, id, url, content){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, 190, titles);
    	
        
        if (tp==1){
        $("#submitBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),groupLoginid: $("#groupLoginid").val(),groupName: $("#groupName").val(),groupDept: $("#groupDept").val(),groupLevel: $("#groupLevel").val(),groupPerlevel: $("#groupPerlevel").val(),groupIndate: $("#groupIndate").val(),groupType: $("#groupType").val(),groupTypeFy: $("#groupTypeFy").val(),groupStatus: $("#groupStatus").val()},
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
                    data:{id: $("#id").val(),groupLoginid: $("#groupLoginid").val(),groupName: $("#groupName").val(),groupDept: $("#groupDept").val(),groupLevel: $("#groupLevel").val(),groupPerlevel: $("#groupPerlevel").val(),groupIndate: $("#groupIndate").val(),groupType: $("#groupType").val(),groupTypeFy: $("#groupTypeFy").val(),groupStatus: $("#groupStatus").val()},
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
                        kendoUIWindow.close();
                    }
                }
            );
        });
    	}
        SimpleListUtil.setDataTimeCn();

        
    }
    
    var PlatformUserIncomeManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_UserIncome_manage": "showPlatformUserIncomeManageList",  
            "basic_manage/platform_ckUserIncome_manage": "showPlatformckUserIncomeManageList"
        },
        showPlatformckUserIncomeManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformUserIncomeManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformUserIncomeManageListView = new SimpleListView({
                id: "platform_userIncome_manage_list",
                title: "基础管理 > 员工入职信息",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("员工入职信息");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupLoginid' align='right'>用户ID：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupLoginid' name='用户ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupName' align='right'>用户名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupName' name='用户名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupDept' align='right'>员工部门：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupDept' name='员工部门' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupLevel' align='right'>对公职级：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupLevel' name='对公职级' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupPerlevel' align='right'>对私职级：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupPerlevel' name='对私职级' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupIndate' align='right'>入职日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupIndate' name='入职日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupType' align='right'>绩效员工类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupType' name='绩效员工类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupTypeFy' align='right'>费用员工类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupTypeFy' name='费用员工类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupStatus' align='right'>转正标识：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupStatus' name='转正标识' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=userIncome.createUserIncome&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformUserIncomeManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformUserIncomeManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformUserIncomeManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=userIncome.deleteUserIncome&v=1.0&format=json",
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
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupLoginid' align='right'>用户ID：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupLoginid' name='用户ID' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupName' align='right'>用户名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupName' name='用户名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupDept' align='right'>员工部门：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupDept' name='员工部门' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupLevel' align='right'>对公职级：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupLevel' name='对公职级' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupPerlevel' align='right'>对私职级：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupPerlevel' name='对私职级' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupIndate' align='right'>入职日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupIndate' name='入职日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupType' align='right'>绩效员工类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupType' name='绩效员工类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupTypeFy' align='right'>费用员工类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupTypeFy' name='费用员工类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupStatus' align='right'>转正标识：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupStatus' name='转正标识' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=userIncome.selectUserIncome&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=userIncome.selectUserIncome&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },groupLoginid: { type: "string" },groupName: { type: "string" },groupDept: { type: "string" },groupLevel: { type: "string" },groupPerlevel: { type: "string" },groupIndate: { type: "string" },groupType: { type: "string" },groupTypeFy: { type: "string" },groupStatus: { type: "string" }
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
                            result = platformUserIncomeManageListView.appendColValue(result);
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
                          {field: "id", title:"编号", hidden:"true", align:"center", width: "100px"},

    						
                    		{field: "groupLoginid", title:"用户ID", align:"center", width: "100px"},

    						
                    		{field: "groupName", title:"用户名称", align:"center", width: "100px"},

    						
                    		{field: "groupDept", title:"员工部门", align:"center", width: "100px"},

    						
                    		{field: "groupLevel", title:"对公职级", align:"center", width: "100px"},

    						
                    		{field: "groupPerlevel", title:"对私职级", align:"center", width: "100px"},

    						
                    		{field: "groupIndate", title:"入职日期", align:"center", width: "100px"},

    						
                    		{field: "groupType", title:"绩效员工类别", align:"center", width: "100px"},

    						
                    		{field: "groupTypeFy", title:"费用员工类别", align:"center", width: "100px"},

    						
                    		{field: "groupStatus", title:"转正标识", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformUserIncomeManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformUserIncomeManageListView.get("columns");
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
                                detailstr+="<label id='lgroupLoginid' align='right'>用户ID：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupLoginid' name='用户ID' value='"+ColumnValue["groupLoginid"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupName' align='right'>用户名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupName' name='用户名称' value='"+ColumnValue["groupName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupDept' align='right'>员工部门：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupDept' name='员工部门' value='"+ColumnValue["groupDept"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupLevel' align='right'>对公职级：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupLevel' name='对公职级' value='"+ColumnValue["groupLevel"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupPerlevel' align='right'>对私职级：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupPerlevel' name='对私职级' value='"+ColumnValue["groupPerlevel"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupIndate' align='right'>入职日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupIndate' name='入职日期' value='"+ColumnValue["groupIndate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupType' align='right'>绩效员工类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupType' name='绩效员工类别' value='"+ColumnValue["groupType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupTypeFy' align='right'>费用员工类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupTypeFy' name='费用员工类别' value='"+ColumnValue["groupTypeFy"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupStatus' align='right'>转正标识：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupStatus' name='转正标识' value='"+ColumnValue["groupStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=userIncome.updateUserIncome&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformUserIncomeManageListView);
        }
    });

    return PlatformUserIncomeManageRouter;
});


/**
 * 客户关联比例申请
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
                    data:{id: $("#id").val(),reqNo: $("#reqNo").val(),accountNum: $("#accountNum").val(),setupDate: $("#setupDate").val(),loginid: $("#loginid").val(),name: $("#name").val(),trace: $("#trace").val(),status: $("#status").val()},
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
                    data:{id: $("#id").val(),reqNo: $("#reqNo").val(),accountNum: $("#accountNum").val(),setupDate: $("#setupDate").val(),loginid: $("#loginid").val(),name: $("#name").val(),trace: $("#trace").val(),status: $("#status").val()},
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
    
    var PlatformJxkhConTraceReqManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhConTraceReq_manage": "showPlatformJxkhConTraceReqManageList",  
            "basic_manage/platform_ckJxkhConTraceReq_manage": "showPlatformckJxkhConTraceReqManageList"
        },
        showPlatformckJxkhConTraceReqManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhConTraceReqManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhConTraceReqManageListView = new SimpleListView({
                id: "platform_jxkhConTraceReq_manage_list",
                title: "基础管理 > 客户关联比例申请",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("客户关联比例申请");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lreqNo' align='right'>申请单号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='reqNo' name='申请单号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>帐户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='帐户' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsetupDate' align='right'>帐户开户日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='setupDate' name='帐户开户日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lloginid' align='right'>员工编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='loginid' name='员工编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>员工姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='name' name='员工姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltrace' align='right'>关联比例：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='trace' name='关联比例' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstatus' align='right'>关联状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='status' name='关联状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhConTraceReq.createJxkhConTraceReq&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhConTraceReqManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhConTraceReqManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhConTraceReqManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhConTraceReq.deleteJxkhConTraceReq&v=1.0&format=json",
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
                        detailstr+="<label id='lreqNo' align='right'>申请单号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='reqNo' name='申请单号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>帐户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='帐户' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsetupDate' align='right'>帐户开户日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='setupDate' name='帐户开户日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lloginid' align='right'>员工编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='loginid' name='员工编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>员工姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='name' name='员工姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltrace' align='right'>关联比例：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='trace' name='关联比例' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstatus' align='right'>关联状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='status' name='关联状态' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhConTraceReq.selectJxkhConTraceReq&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhConTraceReq.selectJxkhConTraceReq&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },reqNo: { type: "string" },accountNum: { type: "string" },setupDate: { type: "string" },loginid: { type: "string" },name: { type: "string" },trace: { type: "string" },status: { type: "string" }
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
                            result = platformJxkhConTraceReqManageListView.appendColValue(result);
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

    						
                    		{field: "reqNo", title:"申请单号", align:"center", width: "100px"},

    						
                    		{field: "accountNum", title:"帐户", align:"center", width: "100px"},

    						
                    		{field: "setupDate", title:"帐户开户日期", align:"center", width: "100px"},

    						
                    		{field: "loginid", title:"员工编号", align:"center", width: "100px"},

    						
                    		{field: "name", title:"员工姓名", align:"center", width: "100px"},

    						
                    		{field: "trace", title:"关联比例", align:"center", width: "100px"},

    						
                    		{field: "status", title:"关联状态", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhConTraceReqManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhConTraceReqManageListView.get("columns");
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
                                detailstr+="<label id='lreqNo' align='right'>申请单号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='reqNo' name='申请单号' value='"+ColumnValue["reqNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountNum' align='right'>帐户：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountNum' name='帐户' value='"+ColumnValue["accountNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsetupDate' align='right'>帐户开户日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='setupDate' name='帐户开户日期' value='"+ColumnValue["setupDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lloginid' align='right'>员工编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='loginid' name='员工编号' value='"+ColumnValue["loginid"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lname' align='right'>员工姓名：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='name' name='员工姓名' value='"+ColumnValue["name"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltrace' align='right'>关联比例：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='trace' name='关联比例' value='"+ColumnValue["trace"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lstatus' align='right'>关联状态：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='status' name='关联状态' value='"+ColumnValue["status"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhConTraceReq.updateJxkhConTraceReq&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhConTraceReqManageListView);
        }
    });

    return PlatformJxkhConTraceReqManageRouter;
});


/**
 * IpfScheduleJob
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
                    data:{id: $("#id").val(),jobName: $("#jobName").val(),jobGroup: $("#jobGroup").val(),jobStatus: $("#jobStatus").val(),cronExpression: $("#cronExpression").val(),jobDesc: $("#jobDesc").val(),ruleNo: $("#ruleNo").val(),jobService: $("#jobService").val(),jobMethod: $("#jobMethod").val()},
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
                    data:{id: $("#id").val(),jobName: $("#jobName").val(),jobGroup: $("#jobGroup").val(),jobStatus: $("#jobStatus").val(),cronExpression: $("#cronExpression").val(),jobDesc: $("#jobDesc").val(),ruleNo: $("#ruleNo").val(),jobService: $("#jobService").val(),jobMethod: $("#jobMethod").val()},
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
    
    var PlatformIpfScheduleJobManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfScheduleJob_manage": "showPlatformIpfScheduleJobManageList",  
            "basic_manage/platform_ckIpfScheduleJob_manage": "showPlatformckIpfScheduleJobManageList"
        },
        showPlatformckIpfScheduleJobManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfScheduleJobManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfScheduleJobManageListView = new SimpleListView({
                id: "platform_ipfScheduleJob_manage_list",
                title: "基础管理 > IpfScheduleJob",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfScheduleJob");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobName' align='right'>任务名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobName' name='任务名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobGroup' align='right'>任务分组：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobGroup' name='任务分组' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobStatus' align='right'>任务状态：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobStatus' name='任务状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcronExpression' align='right'>执行频率：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cronExpression' name='执行频率' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobDesc' align='right'>任务描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobDesc' name='任务描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobService' align='right'>任务对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobService' name='任务对象' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobMethod' align='right'>任务方法：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobMethod' name='任务方法' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfScheduleJob.createIpfScheduleJob&v=1.0&format=json",$(detailstr),280);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfScheduleJobManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfScheduleJobManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfScheduleJobManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfScheduleJob.deleteIpfScheduleJob&v=1.0&format=json",
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
                        detailstr+="<label id='ljobName' align='right'>任务名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobName' name='任务名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobGroup' align='right'>任务分组：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobGroup' name='任务分组' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobStatus' align='right'>任务状态：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobStatus' name='任务状态' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcronExpression' align='right'>执行频率：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cronExpression' name='执行频率' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobDesc' align='right'>任务描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobDesc' name='任务描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobService' align='right'>任务对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobService' name='任务对象' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljobMethod' align='right'>任务方法：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jobMethod' name='任务方法' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfScheduleJob.selectIpfScheduleJob&v=1.0&format=json",$(detailstr),280);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfScheduleJob.selectIpfScheduleJob&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },jobName: { type: "string" },jobGroup: { type: "string" },jobStatus: { type: "string" },cronExpression: { type: "string" },jobDesc: { type: "string" },ruleNo: { type: "string" },jobService: { type: "string" },jobMethod: { type: "string" }
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
                            result = platformIpfScheduleJobManageListView.appendColValue(result);
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
                    		{field: "jobName", title:"任务名称", align:"center", width: "100px"},
                    		{field: "jobGroup", title:"任务分组", align:"center", width: "100px"},
                    		{field: "jobStatus", title:"任务状态", align:"center", width: "100px"},
                    		{field: "cronExpression", title:"执行频率", align:"center", width: "100px"},
                    		{field: "jobDesc", title:"任务描述", align:"center", width: "100px"},
                    		{field: "ruleNo", title:"规则号", align:"center", width: "100px"},
                    		{field: "jobService", title:"任务对象", align:"center", width: "100px"},
                    		{field: "jobMethod", title:"任务方法", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfScheduleJobManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfScheduleJobManageListView.get("columns");
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
                                detailstr+="<label id='ljobName' align='right'>任务名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jobName' name='任务名称' value='"+ColumnValue["jobName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljobGroup' align='right'>任务分组：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jobGroup' name='任务分组' value='"+ColumnValue["jobGroup"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljobStatus' align='right'>任务状态：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jobStatus' name='任务状态' value='"+ColumnValue["jobStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcronExpression' align='right'>执行频率：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='cronExpression' name='执行频率' value='"+ColumnValue["cronExpression"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljobDesc' align='right'>任务描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jobDesc' name='任务描述' value='"+ColumnValue["jobDesc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleNo' name='规则号' value='"+ColumnValue["ruleNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljobService' align='right'>任务对象：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jobService' name='任务对象' value='"+ColumnValue["jobService"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljobMethod' align='right'>任务方法：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jobMethod' name='任务方法' value='"+ColumnValue["jobMethod"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfScheduleJob.updateIpfScheduleJob&v=1.0&format=json", $(detailstr),280);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfScheduleJobManageListView);
        }
    });

    return PlatformIpfScheduleJobManageRouter;
});

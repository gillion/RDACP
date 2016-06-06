
/**
 * GroupAction
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
                    data:{id: $("#id").val(),name: $("#name").val(),begintime: $("#begintime").val(),endtime: $("#endtime").val(),addr: $("#addr").val(),leadings: $("#leadings").val(),memoinfo: $("#memoinfo").val(),mincount: $("#mincount").val(),budget: $("#budget").val(),spending: $("#spending").val()},
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
                    data:{id: $("#id").val(),name: $("#name").val(),begintime: $("#begintime").val(),endtime: $("#endtime").val(),addr: $("#addr").val(),leadings: $("#leadings").val(),memoinfo: $("#memoinfo").val(),mincount: $("#mincount").val(),budget: $("#budget").val(),spending: $("#spending").val()},
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

        if (tp==1){
        	$("#begintime").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss", value:new Date()});
        } else {
        	$("#begintime").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss"});
        }
        if (tp==1){
        	$("#endtime").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss", value:new Date()});
        } else {
        	$("#endtime").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss"});
        }
        
    }
    
    var PlatformGroupActionManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_GroupAction_manage": "showPlatformGroupActionManageList",  
            "basic_manage/platform_ckGroupAction_manage": "showPlatformckGroupActionManageList"
        },
        showPlatformckGroupActionManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformGroupActionManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformGroupActionManageListView = new SimpleListView({
                id: "platform_groupAction_manage_list",
                title: "基础管理 > GroupAction",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("GroupAction");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='活动编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>活动名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='name' name='活动名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbegintime' align='right'>开始时间：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='begintime' name='开始时间' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lendtime' align='right'>结束时间：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='endtime' name='结束时间' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laddr' align='right'>活动地址：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='addr' name='活动地址' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lleadings' align='right'>活动负责：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='leadings' name='活动负责' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmemoinfo' align='right'>活动备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='memoinfo' name='活动备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmincount' align='right'>最少人数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='mincount' name='最少人数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbudget' align='right'>人均预算：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='budget' name='人均预算' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lspending' align='right'>结算总额：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='spending' name='结算总额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=groupAction.createGroupAction&v=1.0&format=json",$(detailstr),310);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformGroupActionManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformGroupActionManageListView.getGridObject().select().get(i);
                            var id = SimpleListUtil.getColumnValue(platformGroupActionManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=groupAction.deleteGroupAction&v=1.0&format=json",
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
                        detailstr+="<input id='id' name='活动编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>活动名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='name' name='活动名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbegintime' align='right'>开始时间：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='begintime' name='开始时间' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lendtime' align='right'>结束时间：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='endtime' name='结束时间' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laddr' align='right'>活动地址：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='addr' name='活动地址' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lleadings' align='right'>活动负责：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='leadings' name='活动负责' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmemoinfo' align='right'>活动备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='memoinfo' name='活动备注' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmincount' align='right'>最少人数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='mincount' name='最少人数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbudget' align='right'>人均预算：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='budget' name='人均预算' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lspending' align='right'>结算总额：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='spending' name='结算总额' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=groupAction.selectGroupAction&v=1.0&format=json",$(detailstr),310);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=groupAction.selectGroupAction&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },name: { type: "string" },begintime: { type: "string" },endtime: { type: "string" },addr: { type: "string" },leadings: { type: "string" },memoinfo: { type: "string" },mincount: { type: "string" },budget: { type: "string" },spending: { type: "string" }
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
                            result = platformGroupActionManageListView.appendColValue(result);
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
                          {field: "id", title:"活动编号", hidden:"true", align:"center", width: "100px"},
                    		{field: "name", title:"活动名称", align:"center", width: "100px"},
                    		{field: "begintime", title:"开始时间", align:"center", width: "100px"},
                    		{field: "endtime", title:"结束时间", align:"center", width: "100px"},
                    		{field: "addr", title:"活动地址", align:"center", width: "100px"},
                    		{field: "leadings", title:"活动负责", align:"center", width: "100px"},
                    		{field: "memoinfo", title:"活动备注", align:"center", width: "100px"},
                    		{field: "mincount", title:"最少人数", align:"center", width: "100px"},
                    		{field: "budget", title:"人均预算", align:"center", width: "100px"},
                    		{field: "spending", title:"结算总额", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformGroupActionManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformGroupActionManageListView.get("columns");
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
                                detailstr+="<input id='id' name='活动编号' hidden='true' value='"+ColumnValue["id"]+"' style='...'/>";

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lname' align='right'>活动名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='name' name='活动名称' value='"+ColumnValue["name"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbegintime' align='right'>开始时间：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='begintime' name='开始时间' value='"+ColumnValue["begintime"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lendtime' align='right'>结束时间：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='endtime' name='结束时间' value='"+ColumnValue["endtime"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laddr' align='right'>活动地址：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='addr' name='活动地址' value='"+ColumnValue["addr"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lleadings' align='right'>活动负责：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='leadings' name='活动负责' value='"+ColumnValue["leadings"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmemoinfo' align='right'>活动备注：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='memoinfo' name='活动备注' value='"+ColumnValue["memoinfo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmincount' align='right'>最少人数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='mincount' name='最少人数' value='"+ColumnValue["mincount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbudget' align='right'>人均预算：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='budget' name='人均预算' value='"+ColumnValue["budget"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lspending' align='right'>结算总额：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='spending' name='结算总额' value='"+ColumnValue["spending"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=groupAction.updateGroupAction&v=1.0&format=json", $(detailstr),310);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformGroupActionManageListView);
        }
    });

    return PlatformGroupActionManageRouter;
});

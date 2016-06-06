
/**
 * 任务指标
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
                    data:{id: $("#id").val(),tasktype: $("#tasktype").val(),bstype: $("#bstype").val(),syear: $("#syear").val(),smonth: $("#smonth").val(),projectNo: $("#projectNo").val(),projectName: $("#projectName").val(),monthTask: $("#monthTask").val()},
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
                    data:{id: $("#id").val(),tasktype: $("#tasktype").val(),bstype: $("#bstype").val(),syear: $("#syear").val(),smonth: $("#smonth").val(),projectNo: $("#projectNo").val(),projectName: $("#projectName").val(),monthTask: $("#monthTask").val()},
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
    
    var PlatformJxkhTaskManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhTask_manage": "showPlatformJxkhTaskManageList",  
            "basic_manage/platform_ckJxkhTask_manage": "showPlatformckJxkhTaskManageList"
        },
        showPlatformckJxkhTaskManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhTaskManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhTaskManageListView = new SimpleListView({
                id: "platform_jxkhTask_manage_list",
                title: "基础管理 > 任务指标",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("任务指标");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltasktype' align='right'>指标类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='tasktype' name='指标类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbstype' align='right'>业务类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bstype' name='业务类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsyear' align='right'>年：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='syear' name='年' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsmonth' align='right'>月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='smonth' name='月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectNo' align='right'>指标编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='projectNo' name='指标编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectName' align='right'>指标名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='projectName' name='指标名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonthTask' align='right'>指标值：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='monthTask' name='指标值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTask.createJxkhTask&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhTaskManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhTaskManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhTaskManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTask.deleteJxkhTask&v=1.0&format=json",
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
                        detailstr+="<label id='ltasktype' align='right'>指标类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='tasktype' name='指标类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbstype' align='right'>业务类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bstype' name='业务类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsyear' align='right'>年：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='syear' name='年' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsmonth' align='right'>月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='smonth' name='月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectNo' align='right'>指标编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='projectNo' name='指标编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectName' align='right'>指标名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='projectName' name='指标名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonthTask' align='right'>指标值：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='monthTask' name='指标值' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTask.selectJxkhTask&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTask.selectJxkhTask&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },tasktype: { type: "string" },bstype: { type: "string" },syear: { type: "string" },smonth: { type: "string" },projectNo: { type: "string" },projectName: { type: "string" },monthTask: { type: "string" }
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
                            result = platformJxkhTaskManageListView.appendColValue(result);
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

    						
                    		{field: "tasktype", title:"指标类别", align:"center", width: "100px"},

    						
                    		{field: "bstype", title:"业务类别", align:"center", width: "100px"},

    						
                    		{field: "syear", title:"年", align:"center", width: "100px"},

    						
                    		{field: "smonth", title:"月", align:"center", width: "100px"},

    						
                    		{field: "projectNo", title:"指标编号", align:"center", width: "100px"},

    						
                    		{field: "projectName", title:"指标名称", align:"center", width: "100px"},

    						
                    		{field: "monthTask", title:"指标值", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhTaskManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhTaskManageListView.get("columns");
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
                                detailstr+="<label id='ltasktype' align='right'>指标类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='tasktype' name='指标类别' value='"+ColumnValue["tasktype"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbstype' align='right'>业务类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='bstype' name='业务类别' value='"+ColumnValue["bstype"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsyear' align='right'>年：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='syear' name='年' value='"+ColumnValue["syear"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsmonth' align='right'>月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='smonth' name='月' value='"+ColumnValue["smonth"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprojectNo' align='right'>指标编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='projectNo' name='指标编号' value='"+ColumnValue["projectNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprojectName' align='right'>指标名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='projectName' name='指标名称' value='"+ColumnValue["projectName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonthTask' align='right'>指标值：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='monthTask' name='指标值' value='"+ColumnValue["monthTask"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTask.updateJxkhTask&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhTaskManageListView);
        }
    });

    return PlatformJxkhTaskManageRouter;
});


/**
 * 员工客户关联金额调整
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
                    data:{id: $("#id").val(),reqNo: $("#reqNo").val(),reqType: $("#reqType").val(),conType: $("#conType").val(),cusCode: $("#cusCode").val(),cusName: $("#cusName").val(),dataDate: $("#dataDate").val(),prvStatus: $("#prvStatus").val(),reqUser: $("#reqUser").val(),reqDate: $("#reqDate").val(),prvUser: $("#prvUser").val(),prvDate: $("#prvDate").val(),remark: $("#remark").val()},
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
                    data:{id: $("#id").val(),reqNo: $("#reqNo").val(),reqType: $("#reqType").val(),conType: $("#conType").val(),cusCode: $("#cusCode").val(),cusName: $("#cusName").val(),dataDate: $("#dataDate").val(),prvStatus: $("#prvStatus").val(),reqUser: $("#reqUser").val(),reqDate: $("#reqDate").val(),prvUser: $("#prvUser").val(),prvDate: $("#prvDate").val(),remark: $("#remark").val()},
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
    
    var PlatformPerConMoneyChgManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_PerConMoneyChg_manage": "showPlatformPerConMoneyChgManageList",  
            "basic_manage/platform_ckPerConMoneyChg_manage": "showPlatformckPerConMoneyChgManageList"
        },
        showPlatformckPerConMoneyChgManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformPerConMoneyChgManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformPerConMoneyChgManageListView = new SimpleListView({
                id: "platform_perConMoneyChg_manage_list",
                title: "基础管理 > 员工客户关联金额调整",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("员工客户关联金额调整");
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
                        detailstr+="<label id='lreqType' align='right'>申请类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='reqType' name='申请类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconType' align='right'>关联类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conType' name='关联类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusCode' align='right'>客户代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusCode' name='客户代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusName' align='right'>客户名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusName' name='客户名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataDate' align='right'>生效日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='生效日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprvStatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prvStatus' name='状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lreqUser' align='right'>申请人：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='reqUser' name='申请人' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lreqDate' align='right'>申请时间：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='reqDate' name='申请时间' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprvUser' align='right'>撤销人：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prvUser' name='撤销人' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprvDate' align='right'>撤销日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prvDate' name='撤销日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyChg.createPerConMoneyChg&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformPerConMoneyChgManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformPerConMoneyChgManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformPerConMoneyChgManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyChg.deletePerConMoneyChg&v=1.0&format=json",
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
                        detailstr+="<label id='lreqType' align='right'>申请类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='reqType' name='申请类型' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconType' align='right'>关联类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conType' name='关联类型' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusCode' align='right'>客户代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusCode' name='客户代码' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusName' align='right'>客户名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusName' name='客户名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataDate' align='right'>生效日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='生效日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprvStatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prvStatus' name='状态' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lreqUser' align='right'>申请人：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='reqUser' name='申请人' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lreqDate' align='right'>申请时间：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='reqDate' name='申请时间' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprvUser' align='right'>撤销人：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prvUser' name='撤销人' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprvDate' align='right'>撤销日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prvDate' name='撤销日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyChg.selectPerConMoneyChg&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyChg.selectPerConMoneyChg&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },reqNo: { type: "string" },reqType: { type: "string" },conType: { type: "string" },cusCode: { type: "string" },cusName: { type: "string" },dataDate: { type: "string" },prvStatus: { type: "string" },reqUser: { type: "string" },reqDate: { type: "string" },prvUser: { type: "string" },prvDate: { type: "string" },remark: { type: "string" }
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
                            result = platformPerConMoneyChgManageListView.appendColValue(result);
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

    						
                    		{field: "reqType", title:"申请类型", align:"center", width: "100px"},

    						
                    		{field: "conType", title:"关联类型", align:"center", width: "100px"},

    						
                    		{field: "cusCode", title:"客户代码", align:"center", width: "100px"},

    						
                    		{field: "cusName", title:"客户名称", align:"center", width: "100px"},

    						
                    		{field: "dataDate", title:"生效日期", align:"center", width: "100px"},

    						
                    		{field: "prvStatus", title:"状态", align:"center", width: "100px"},

    						
                    		{field: "reqUser", title:"申请人", align:"center", width: "100px"},

    						
                    		{field: "reqDate", title:"申请时间", align:"center", width: "100px"},

    						
                    		{field: "prvUser", title:"撤销人", align:"center", width: "100px"},

    						
                    		{field: "prvDate", title:"撤销日期", align:"center", width: "100px"},

    						
                    		{field: "remark", title:"备注", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformPerConMoneyChgManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformPerConMoneyChgManageListView.get("columns");
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
                                detailstr+="<label id='lreqType' align='right'>申请类型：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='reqType' name='申请类型' value='"+ColumnValue["reqType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconType' align='right'>关联类型：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='conType' name='关联类型' value='"+ColumnValue["conType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcusCode' align='right'>客户代码：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cusCode' name='客户代码' value='"+ColumnValue["cusCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcusName' align='right'>客户名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cusName' name='客户名称' value='"+ColumnValue["cusName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldataDate' align='right'>生效日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dataDate' name='生效日期' value='"+ColumnValue["dataDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprvStatus' align='right'>状态：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='prvStatus' name='状态' value='"+ColumnValue["prvStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lreqUser' align='right'>申请人：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='reqUser' name='申请人' value='"+ColumnValue["reqUser"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lreqDate' align='right'>申请时间：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='reqDate' name='申请时间' value='"+ColumnValue["reqDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprvUser' align='right'>撤销人：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='prvUser' name='撤销人' value='"+ColumnValue["prvUser"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprvDate' align='right'>撤销日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='prvDate' name='撤销日期' value='"+ColumnValue["prvDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='remark' name='备注' value='"+ColumnValue["remark"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyChg.updatePerConMoneyChg&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformPerConMoneyChgManageListView);
        }
    });

    return PlatformPerConMoneyChgManageRouter;
});

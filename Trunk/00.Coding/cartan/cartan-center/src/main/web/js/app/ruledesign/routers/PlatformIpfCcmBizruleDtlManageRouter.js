
/**
 * IpfCcmBizruleDtl
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
                    data:{id: $("#id").val(),ipfCcmBizruleId: $("#ipfCcmBizruleId").val(),ipfCcmStrategyId: $("#ipfCcmStrategyId").val(),strategyCode: $("#strategyCode").val(),strategyName: $("#strategyName").val(),remark: $("#remark").val(),ruleDetailIndex: $("#ruleDetailIndex").val()},
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
                    data:{id: $("#id").val(),ipfCcmBizruleId: $("#ipfCcmBizruleId").val(),ipfCcmStrategyId: $("#ipfCcmStrategyId").val(),strategyCode: $("#strategyCode").val(),strategyName: $("#strategyName").val(),remark: $("#remark").val(),ruleDetailIndex: $("#ruleDetailIndex").val()},
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
    
    var PlatformIpfCcmBizruleDtlManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBizruleDtl_manage": "showPlatformIpfCcmBizruleDtlManageList",  
            "basic_manage/platform_ckIpfCcmBizruleDtl_manage": "showPlatformckIpfCcmBizruleDtlManageList"
        },
        showPlatformckIpfCcmBizruleDtlManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBizruleDtlManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBizruleDtlManageListView = new SimpleListView({
                id: "platform_ipfCcmBizruleDtl_manage_list",
                title: "基础管理 > IpfCcmBizruleDtl",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBizruleDtl");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBizruleId' align='right'>规则：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBizruleId' name='规则' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmStrategyId' align='right'>策略ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmStrategyId' name='策略ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstrategyCode' align='right'>策略代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='strategyCode' name='策略代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstrategyName' align='right'>策略名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='strategyName' name='策略名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleDetailIndex' align='right'>序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleDetailIndex' name='序号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBizruleDtl.createIpfCcmBizruleDtl&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBizruleDtlManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBizruleDtlManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBizruleDtlManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBizruleDtl.deleteIpfCcmBizruleDtl&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcmBizruleId' align='right'>规则：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBizruleId' name='规则' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmStrategyId' align='right'>策略ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmStrategyId' name='策略ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstrategyCode' align='right'>策略代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='strategyCode' name='策略代码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstrategyName' align='right'>策略名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='strategyName' name='策略名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleDetailIndex' align='right'>序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleDetailIndex' name='序号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBizruleDtl.selectIpfCcmBizruleDtl&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBizruleDtl.selectIpfCcmBizruleDtl&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBizruleId: { type: "string" },ipfCcmStrategyId: { type: "string" },strategyCode: { type: "string" },strategyName: { type: "string" },remark: { type: "string" },ruleDetailIndex: { type: "string" }
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
                            result = platformIpfCcmBizruleDtlManageListView.appendColValue(result);
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
                    		{field: "ipfCcmBizruleId", title:"规则", align:"center", width: "100px"},
                    		{field: "ipfCcmStrategyId", title:"策略ID", align:"center", width: "100px"},
                    		{field: "strategyCode", title:"策略代码", align:"center", width: "100px"},
                    		{field: "strategyName", title:"策略名称", align:"center", width: "100px"},
                    		{field: "remark", title:"备注", align:"center", width: "100px"},
                    		{field: "ruleDetailIndex", title:"序号", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBizruleDtlManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBizruleDtlManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcmBizruleId' align='right'>规则：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmBizruleId' name='规则' value='"+ColumnValue["ipfCcmBizruleId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lipfCcmStrategyId' align='right'>策略ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmStrategyId' name='策略ID' value='"+ColumnValue["ipfCcmStrategyId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lstrategyCode' align='right'>策略代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='strategyCode' name='策略代码' value='"+ColumnValue["strategyCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lstrategyName' align='right'>策略名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='strategyName' name='策略名称' value='"+ColumnValue["strategyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='remark' name='备注' value='"+ColumnValue["remark"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleDetailIndex' align='right'>序号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleDetailIndex' name='序号' value='"+ColumnValue["ruleDetailIndex"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBizruleDtl.updateIpfCcmBizruleDtl&v=1.0&format=json", $(detailstr),220);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBizruleDtlManageListView);
        }
    });

    return PlatformIpfCcmBizruleDtlManageRouter;
});


/**
 * IpfCcmBizruleDtlParam
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
                    data:{id: $("#id").val(),ipfCcmBizruleId: $("#ipfCcmBizruleId").val(),ipfCcmStrategyId: $("#ipfCcmStrategyId").val(),ipfCcmStrategyParamId: $("#ipfCcmStrategyParamId").val(),paramName: $("#paramName").val(),paramDes: $("#paramDes").val(),paramValue: $("#paramValue").val(),paramValueDes: $("#paramValueDes").val()},
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
                    data:{id: $("#id").val(),ipfCcmBizruleId: $("#ipfCcmBizruleId").val(),ipfCcmStrategyId: $("#ipfCcmStrategyId").val(),ipfCcmStrategyParamId: $("#ipfCcmStrategyParamId").val(),paramName: $("#paramName").val(),paramDes: $("#paramDes").val(),paramValue: $("#paramValue").val(),paramValueDes: $("#paramValueDes").val()},
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
    
    var PlatformIpfCcmBizruleDtlParamManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBizruleDtlParam_manage": "showPlatformIpfCcmBizruleDtlParamManageList",  
            "basic_manage/platform_ckIpfCcmBizruleDtlParam_manage": "showPlatformckIpfCcmBizruleDtlParamManageList"
        },
        showPlatformckIpfCcmBizruleDtlParamManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBizruleDtlParamManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBizruleDtlParamManageListView = new SimpleListView({
                id: "platform_ipfCcmBizruleDtlParam_manage_list",
                title: "基础管理 > IpfCcmBizruleDtlParam",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBizruleDtlParam");
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
                        detailstr+="<label id='lipfCcmStrategyParamId' align='right'>策略参数ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmStrategyParamId' name='策略参数ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamName' align='right'>参数名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramName' name='参数名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamDes' align='right'>参数描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramDes' name='参数描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamValue' align='right'>参数值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramValue' name='参数值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamValueDes' align='right'>参数值说明：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramValueDes' name='参数值说明' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBizruleDtlParam.createIpfCcmBizruleDtlParam&v=1.0&format=json",$(detailstr),250);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBizruleDtlParamManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBizruleDtlParamManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBizruleDtlParamManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBizruleDtlParam.deleteIpfCcmBizruleDtlParam&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcmStrategyParamId' align='right'>策略参数ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmStrategyParamId' name='策略参数ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamName' align='right'>参数名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramName' name='参数名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamDes' align='right'>参数描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramDes' name='参数描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamValue' align='right'>参数值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramValue' name='参数值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamValueDes' align='right'>参数值说明：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramValueDes' name='参数值说明' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBizruleDtlParam.selectIpfCcmBizruleDtlParam&v=1.0&format=json",$(detailstr),250);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBizruleDtlParam.selectIpfCcmBizruleDtlParam&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBizruleId: { type: "string" },ipfCcmStrategyId: { type: "string" },ipfCcmStrategyParamId: { type: "string" },paramName: { type: "string" },paramDes: { type: "string" },paramValue: { type: "string" },paramValueDes: { type: "string" }
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
                            result = platformIpfCcmBizruleDtlParamManageListView.appendColValue(result);
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
                    		{field: "ipfCcmStrategyParamId", title:"策略参数ID", align:"center", width: "100px"},
                    		{field: "paramName", title:"参数名", align:"center", width: "100px"},
                    		{field: "paramDes", title:"参数描述", align:"center", width: "100px"},
                    		{field: "paramValue", title:"参数值", align:"center", width: "100px"},
                    		{field: "paramValueDes", title:"参数值说明", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBizruleDtlParamManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBizruleDtlParamManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcmStrategyParamId' align='right'>策略参数ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmStrategyParamId' name='策略参数ID' value='"+ColumnValue["ipfCcmStrategyParamId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparamName' align='right'>参数名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='paramName' name='参数名' value='"+ColumnValue["paramName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparamDes' align='right'>参数描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='paramDes' name='参数描述' value='"+ColumnValue["paramDes"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparamValue' align='right'>参数值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='paramValue' name='参数值' value='"+ColumnValue["paramValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparamValueDes' align='right'>参数值说明：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='paramValueDes' name='参数值说明' value='"+ColumnValue["paramValueDes"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBizruleDtlParam.updateIpfCcmBizruleDtlParam&v=1.0&format=json", $(detailstr),250);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBizruleDtlParamManageListView);
        }
    });

    return PlatformIpfCcmBizruleDtlParamManageRouter;
});

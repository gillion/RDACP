
/**
 * IpfCcmStrategyParam
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
                    data:{id: $("#id").val(),ipfCcmStrategyId: $("#ipfCcmStrategyId").val(),paramType: $("#paramType").val(),paramName: $("#paramName").val(),paramDes: $("#paramDes").val(),rtmConfigCode: $("#rtmConfigCode").val()},
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
                    data:{id: $("#id").val(),ipfCcmStrategyId: $("#ipfCcmStrategyId").val(),paramType: $("#paramType").val(),paramName: $("#paramName").val(),paramDes: $("#paramDes").val(),rtmConfigCode: $("#rtmConfigCode").val()},
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
    
    var PlatformIpfCcmStrategyParamManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmStrategyParam_manage": "showPlatformIpfCcmStrategyParamManageList",  
            "basic_manage/platform_ckIpfCcmStrategyParam_manage": "showPlatformckIpfCcmStrategyParamManageList"
        },
        showPlatformckIpfCcmStrategyParamManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmStrategyParamManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmStrategyParamManageListView = new SimpleListView({
                id: "platform_ipfCcmStrategyParam_manage_list",
                title: "基础管理 > IpfCcmStrategyParam",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmStrategyParam");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmStrategyId' align='right'>策略：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmStrategyId' name='策略' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamType' align='right'>参数类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramType' name='参数类型' style='...'/>";
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
                        detailstr+="<label id='lrtmConfigCode' align='right'>运行期配置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rtmConfigCode' name='运行期配置' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmStrategyParam.createIpfCcmStrategyParam&v=1.0&format=json",$(detailstr),190);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmStrategyParamManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmStrategyParamManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmStrategyParamManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmStrategyParam.deleteIpfCcmStrategyParam&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcmStrategyId' align='right'>策略：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmStrategyId' name='策略' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamType' align='right'>参数类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramType' name='参数类型' style='...'/>";
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
                        detailstr+="<label id='lrtmConfigCode' align='right'>运行期配置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rtmConfigCode' name='运行期配置' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmStrategyParam.selectIpfCcmStrategyParam&v=1.0&format=json",$(detailstr),190);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmStrategyParam.selectIpfCcmStrategyParam&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmStrategyId: { type: "string" },paramType: { type: "string" },paramName: { type: "string" },paramDes: { type: "string" },rtmConfigCode: { type: "string" }
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
                            result = platformIpfCcmStrategyParamManageListView.appendColValue(result);
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
                    		{field: "ipfCcmStrategyId", title:"策略", align:"center", width: "100px"},
                    		{field: "paramType", title:"参数类型", align:"center", width: "100px"},
                    		{field: "paramName", title:"参数名", align:"center", width: "100px"},
                    		{field: "paramDes", title:"参数描述", align:"center", width: "100px"},
                    		{field: "rtmConfigCode", title:"运行期配置", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmStrategyParamManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmStrategyParamManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcmStrategyId' align='right'>策略：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmStrategyId' name='策略' value='"+ColumnValue["ipfCcmStrategyId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparamType' align='right'>参数类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='paramType' name='参数类型' value='"+ColumnValue["paramType"]+"' style='...'/>";
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
                                detailstr+="<label id='lrtmConfigCode' align='right'>运行期配置：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='rtmConfigCode' name='运行期配置' value='"+ColumnValue["rtmConfigCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmStrategyParam.updateIpfCcmStrategyParam&v=1.0&format=json", $(detailstr),190);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmStrategyParamManageListView);
        }
    });

    return PlatformIpfCcmStrategyParamManageRouter;
});


/**
 * IpfCcmBoMethodParam
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
                    data:{id: $("#id").val(),ipfCcmBoMethodId: $("#ipfCcmBoMethodId").val(),constantValue: $("#constantValue").val(),isCondition: $("#isCondition").val(),methodName: $("#methodName").val(),paramName: $("#paramName").val(),paramRef: $("#paramRef").val(),paramType: $("#paramType").val(),boNameRef: $("#boNameRef").val()},
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
                    data:{id: $("#id").val(),ipfCcmBoMethodId: $("#ipfCcmBoMethodId").val(),constantValue: $("#constantValue").val(),isCondition: $("#isCondition").val(),methodName: $("#methodName").val(),paramName: $("#paramName").val(),paramRef: $("#paramRef").val(),paramType: $("#paramType").val(),boNameRef: $("#boNameRef").val()},
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
    
    var PlatformIpfCcmBoMethodParamManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoMethodParam_manage": "showPlatformIpfCcmBoMethodParamManageList",  
            "basic_manage/platform_ckIpfCcmBoMethodParam_manage": "showPlatformckIpfCcmBoMethodParamManageList"
        },
        showPlatformckIpfCcmBoMethodParamManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoMethodParamManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoMethodParamManageListView = new SimpleListView({
                id: "platform_ipfCcmBoMethodParam_manage_list",
                title: "基础管理 > IpfCcmBoMethodParam",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoMethodParam");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoMethodId' align='right'>方法：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoMethodId' name='方法' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconstantValue' align='right'>常量值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='constantValue' name='常量值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCondition' align='right'>查询条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCondition' name='查询条件' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>方法名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='方法名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamName' align='right'>参数名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramName' name='参数名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamRef' align='right'>属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramRef' name='属性名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamType' align='right'>参数值来源类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramType' name='参数值来源类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboNameRef' align='right'>业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boNameRef' name='业务对象名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoMethodParam.createIpfCcmBoMethodParam&v=1.0&format=json",$(detailstr),280);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoMethodParamManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoMethodParamManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoMethodParamManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoMethodParam.deleteIpfCcmBoMethodParam&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcmBoMethodId' align='right'>方法：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoMethodId' name='方法' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconstantValue' align='right'>常量值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='constantValue' name='常量值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCondition' align='right'>查询条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCondition' name='查询条件' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>方法名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='方法名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamName' align='right'>参数名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramName' name='参数名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamRef' align='right'>属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramRef' name='属性名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparamType' align='right'>参数值来源类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='paramType' name='参数值来源类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboNameRef' align='right'>业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boNameRef' name='业务对象名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoMethodParam.selectIpfCcmBoMethodParam&v=1.0&format=json",$(detailstr),280);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoMethodParam.selectIpfCcmBoMethodParam&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBoMethodId: { type: "string" },constantValue: { type: "string" },isCondition: { type: "string" },methodName: { type: "string" },paramName: { type: "string" },paramRef: { type: "string" },paramType: { type: "string" },boNameRef: { type: "string" }
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
                            result = platformIpfCcmBoMethodParamManageListView.appendColValue(result);
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
                    		{field: "ipfCcmBoMethodId", title:"方法", align:"center", width: "100px"},
                    		{field: "constantValue", title:"常量值", align:"center", width: "100px"},
                    		{field: "isCondition", title:"查询条件", align:"center", width: "100px"},
                    		{field: "methodName", title:"方法名", align:"center", width: "100px"},
                    		{field: "paramName", title:"参数名", align:"center", width: "100px"},
                    		{field: "paramRef", title:"属性名", align:"center", width: "100px"},
                    		{field: "paramType", title:"参数值来源类型", align:"center", width: "100px"},
                    		{field: "boNameRef", title:"业务对象名", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoMethodParamManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoMethodParamManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcmBoMethodId' align='right'>方法：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmBoMethodId' name='方法' value='"+ColumnValue["ipfCcmBoMethodId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconstantValue' align='right'>常量值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='constantValue' name='常量值' value='"+ColumnValue["constantValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisCondition' align='right'>查询条件：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isCondition' name='查询条件' value='"+ColumnValue["isCondition"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodName' align='right'>方法名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodName' name='方法名' value='"+ColumnValue["methodName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparamName' align='right'>参数名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='paramName' name='参数名' value='"+ColumnValue["paramName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparamRef' align='right'>属性名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='paramRef' name='属性名' value='"+ColumnValue["paramRef"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparamType' align='right'>参数值来源类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='paramType' name='参数值来源类型' value='"+ColumnValue["paramType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lboNameRef' align='right'>业务对象名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boNameRef' name='业务对象名' value='"+ColumnValue["boNameRef"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoMethodParam.updateIpfCcmBoMethodParam&v=1.0&format=json", $(detailstr),280);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoMethodParamManageListView);
        }
    });

    return PlatformIpfCcmBoMethodParamManageRouter;
});

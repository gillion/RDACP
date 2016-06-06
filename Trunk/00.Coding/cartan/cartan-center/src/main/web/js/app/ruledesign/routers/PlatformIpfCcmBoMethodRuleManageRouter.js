
/**
 * IpfCcmBoMethodRule
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
                    data:{id: $("#id").val(),ipfCcbBoMethodId: $("#ipfCcbBoMethodId").val(),ruleNo: $("#ruleNo").val(),ruleName: $("#ruleName").val(),invokePoint: $("#invokePoint").val(),invokeOrder: $("#invokeOrder").val(),ruleId: $("#ruleId").val()},
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
                    data:{id: $("#id").val(),ipfCcbBoMethodId: $("#ipfCcbBoMethodId").val(),ruleNo: $("#ruleNo").val(),ruleName: $("#ruleName").val(),invokePoint: $("#invokePoint").val(),invokeOrder: $("#invokeOrder").val(),ruleId: $("#ruleId").val()},
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
    
    var PlatformIpfCcmBoMethodRuleManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoMethodRule_manage": "showPlatformIpfCcmBoMethodRuleManageList",  
            "basic_manage/platform_ckIpfCcmBoMethodRule_manage": "showPlatformckIpfCcmBoMethodRuleManageList"
        },
        showPlatformckIpfCcmBoMethodRuleManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoMethodRuleManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoMethodRuleManageListView = new SimpleListView({
                id: "platform_ipfCcmBoMethodRule_manage_list",
                title: "基础管理 > IpfCcmBoMethodRule",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoMethodRule");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcbBoMethodId' align='right'>方法：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcbBoMethodId' name='方法' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleName' align='right'>规则名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleName' name='规则名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linvokePoint' align='right'>调用时机：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='invokePoint' name='调用时机' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linvokeOrder' align='right'>调用顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='invokeOrder' name='调用顺序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleId' align='right'>规则ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleId' name='规则ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoMethodRule.createIpfCcmBoMethodRule&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoMethodRuleManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoMethodRuleManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoMethodRuleManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoMethodRule.deleteIpfCcmBoMethodRule&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcbBoMethodId' align='right'>方法：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcbBoMethodId' name='方法' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleName' align='right'>规则名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleName' name='规则名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linvokePoint' align='right'>调用时机：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='invokePoint' name='调用时机' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linvokeOrder' align='right'>调用顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='invokeOrder' name='调用顺序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleId' align='right'>规则ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleId' name='规则ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoMethodRule.selectIpfCcmBoMethodRule&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoMethodRule.selectIpfCcmBoMethodRule&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcbBoMethodId: { type: "string" },ruleNo: { type: "string" },ruleName: { type: "string" },invokePoint: { type: "string" },invokeOrder: { type: "string" },ruleId: { type: "string" }
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
                            result = platformIpfCcmBoMethodRuleManageListView.appendColValue(result);
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
                    		{field: "ipfCcbBoMethodId", title:"方法", align:"center", width: "100px"},
                    		{field: "ruleNo", title:"规则号", align:"center", width: "100px"},
                    		{field: "ruleName", title:"规则名称", align:"center", width: "100px"},
                    		{field: "invokePoint", title:"调用时机", align:"center", width: "100px"},
                    		{field: "invokeOrder", title:"调用顺序", align:"center", width: "100px"},
                    		{field: "ruleId", title:"规则ID", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoMethodRuleManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoMethodRuleManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcbBoMethodId' align='right'>方法：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcbBoMethodId' name='方法' value='"+ColumnValue["ipfCcbBoMethodId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleNo' name='规则号' value='"+ColumnValue["ruleNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleName' align='right'>规则名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleName' name='规则名称' value='"+ColumnValue["ruleName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linvokePoint' align='right'>调用时机：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='invokePoint' name='调用时机' value='"+ColumnValue["invokePoint"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linvokeOrder' align='right'>调用顺序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='invokeOrder' name='调用顺序' value='"+ColumnValue["invokeOrder"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleId' align='right'>规则ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleId' name='规则ID' value='"+ColumnValue["ruleId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoMethodRule.updateIpfCcmBoMethodRule&v=1.0&format=json", $(detailstr),220);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoMethodRuleManageListView);
        }
    });

    return PlatformIpfCcmBoMethodRuleManageRouter;
});

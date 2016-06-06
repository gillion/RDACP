
/**
 * IpfCcmNumrule
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
                    data:{id: $("#id").val(),ruleCode: $("#ruleCode").val(),ruleName: $("#ruleName").val(),ruleExpression: $("#ruleExpression").val(),ruleStatus: $("#ruleStatus").val(),initialValue: $("#initialValue").val(),maxValue: $("#maxValue").val(),growth: $("#growth").val(),remark: $("#remark").val(),isActive: $("#isActive").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boName: $("#boName").val(),ipfCcmBoPropertyId: $("#ipfCcmBoPropertyId").val(),propertyName: $("#propertyName").val()},
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
                    data:{id: $("#id").val(),ruleCode: $("#ruleCode").val(),ruleName: $("#ruleName").val(),ruleExpression: $("#ruleExpression").val(),ruleStatus: $("#ruleStatus").val(),initialValue: $("#initialValue").val(),maxValue: $("#maxValue").val(),growth: $("#growth").val(),remark: $("#remark").val(),isActive: $("#isActive").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boName: $("#boName").val(),ipfCcmBoPropertyId: $("#ipfCcmBoPropertyId").val(),propertyName: $("#propertyName").val()},
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
    
    var PlatformIpfCcmNumruleManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmNumrule_manage": "showPlatformIpfCcmNumruleManageList",  
            "basic_manage/platform_ckIpfCcmNumrule_manage": "showPlatformckIpfCcmNumruleManageList"
        },
        showPlatformckIpfCcmNumruleManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmNumruleManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmNumruleManageListView = new SimpleListView({
                id: "platform_ipfCcmNumrule_manage_list",
                title: "基础管理 > IpfCcmNumrule",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmNumrule");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleCode' align='right'>单号规则代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleCode' name='单号规则代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleName' align='right'>单号规则名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleName' name='单号规则名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleExpression' align='right'>单号生成规则：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleExpression' name='单号生成规则' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleStatus' align='right'>单号规则状态：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleStatus' name='单号规则状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linitialValue' align='right'>初始值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='initialValue' name='初始值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmaxValue' align='right'>最大值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='maxValue' name='最大值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgrowth' align='right'>增长值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='growth' name='增长值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisActive' align='right'>有效：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='有效' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoId' align='right'>业务对象ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoId' name='业务对象ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboName' align='right'>业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boName' name='业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoPropertyId' align='right'>属性ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoPropertyId' name='属性ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmNumrule.createIpfCcmNumrule&v=1.0&format=json",$(detailstr),430);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmNumruleManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmNumruleManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmNumruleManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmNumrule.deleteIpfCcmNumrule&v=1.0&format=json",
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
                        detailstr+="<label id='lruleCode' align='right'>单号规则代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleCode' name='单号规则代码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleName' align='right'>单号规则名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleName' name='单号规则名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleExpression' align='right'>单号生成规则：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleExpression' name='单号生成规则' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleStatus' align='right'>单号规则状态：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleStatus' name='单号规则状态' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linitialValue' align='right'>初始值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='initialValue' name='初始值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmaxValue' align='right'>最大值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='maxValue' name='最大值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgrowth' align='right'>增长值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='growth' name='增长值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisActive' align='right'>有效：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='有效' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoId' align='right'>业务对象ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoId' name='业务对象ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboName' align='right'>业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boName' name='业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoPropertyId' align='right'>属性ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoPropertyId' name='属性ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmNumrule.selectIpfCcmNumrule&v=1.0&format=json",$(detailstr),430);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmNumrule.selectIpfCcmNumrule&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ruleCode: { type: "string" },ruleName: { type: "string" },ruleExpression: { type: "string" },ruleStatus: { type: "string" },initialValue: { type: "string" },maxValue: { type: "string" },growth: { type: "string" },remark: { type: "string" },isActive: { type: "string" },ipfCcmBoId: { type: "string" },boName: { type: "string" },ipfCcmBoPropertyId: { type: "string" },propertyName: { type: "string" }
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
                            result = platformIpfCcmNumruleManageListView.appendColValue(result);
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
                    		{field: "ruleCode", title:"单号规则代码", align:"center", width: "100px"},
                    		{field: "ruleName", title:"单号规则名称", align:"center", width: "100px"},
                    		{field: "ruleExpression", title:"单号生成规则", align:"center", width: "100px"},
                    		{field: "ruleStatus", title:"单号规则状态", align:"center", width: "100px"},
                    		{field: "initialValue", title:"初始值", align:"center", width: "100px"},
                    		{field: "maxValue", title:"最大值", align:"center", width: "100px"},
                    		{field: "growth", title:"增长值", align:"center", width: "100px"},
                    		{field: "remark", title:"备注", align:"center", width: "100px"},
                    		{field: "isActive", title:"有效", align:"center", width: "100px"},
                    		{field: "ipfCcmBoId", title:"业务对象ID", align:"center", width: "100px"},
                    		{field: "boName", title:"业务对象名称", align:"center", width: "100px"},
                    		{field: "ipfCcmBoPropertyId", title:"属性ID", align:"center", width: "100px"},
                    		{field: "propertyName", title:"属性名称", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmNumruleManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmNumruleManageListView.get("columns");
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
                                detailstr+="<label id='lruleCode' align='right'>单号规则代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleCode' name='单号规则代码' value='"+ColumnValue["ruleCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleName' align='right'>单号规则名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleName' name='单号规则名称' value='"+ColumnValue["ruleName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleExpression' align='right'>单号生成规则：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleExpression' name='单号生成规则' value='"+ColumnValue["ruleExpression"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleStatus' align='right'>单号规则状态：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleStatus' name='单号规则状态' value='"+ColumnValue["ruleStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linitialValue' align='right'>初始值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='initialValue' name='初始值' value='"+ColumnValue["initialValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmaxValue' align='right'>最大值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='maxValue' name='最大值' value='"+ColumnValue["maxValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgrowth' align='right'>增长值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='growth' name='增长值' value='"+ColumnValue["growth"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='remark' name='备注' value='"+ColumnValue["remark"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisActive' align='right'>有效：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isActive' name='有效' value='"+ColumnValue["isActive"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lipfCcmBoId' align='right'>业务对象ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmBoId' name='业务对象ID' value='"+ColumnValue["ipfCcmBoId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lboName' align='right'>业务对象名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boName' name='业务对象名称' value='"+ColumnValue["boName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lipfCcmBoPropertyId' align='right'>属性ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmBoPropertyId' name='属性ID' value='"+ColumnValue["ipfCcmBoPropertyId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyName' align='right'>属性名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyName' name='属性名称' value='"+ColumnValue["propertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmNumrule.updateIpfCcmNumrule&v=1.0&format=json", $(detailstr),430);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmNumruleManageListView);
        }
    });

    return PlatformIpfCcmNumruleManageRouter;
});


/**
 * IpfReqRule
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
    "js/app/ruledesign/routers/PlatformIpfCcmBoSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfCcmBoSelDialog,
		AjaxEngine){    
	
    function showIpfCcmBoSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfCcmBogrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfCcmBoSelDialog.showGridData($("#IpfCcmBogrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.boName;
            $("#ipfCcmBoId").val(Id);
            $("#IpfCcmBoName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 730, height, titles);
        
    	
        
        
        var IpfCcmBoviewModel = kendo.observable({
            id: $("#ipfCcmBoId").val(),
            name: $("#IpfCcmBoName").val(),
            displayGreeting: function() {
            showIpfCcmBoSelDialog();
            }
        });
        kendo.bind($("#viewIpfCcmBo"), IpfCcmBoviewModel);

        var isDecisionTableModel = kendo.observable({
            isChecked: $("#isDecisionTable").val()=="1"
        });
        kendo.bind($("#isDecisionTable"), isDecisionTableModel);
        var isDecisionTableval="0";
		
        if (tp==1){
        $("#submitBtn").click(function(){    	
            if (isDecisionTableModel.isChecked){
            	isDecisionTableval="1";
            } else {
            	isDecisionTableval="0";
            }
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ruleName: $("#ruleName").val(),ruleNo: $("#ruleNo").val(),ruleType: $("#ruleType").val(),ruleStatus: $("#ruleStatus").val(),triggerType: $("#triggerType").val(),physicalLocation: $("#physicalLocation").val(),actionType: $("#actionType").val(),businessLocation: $("#businessLocation").val(),businessModule: $("#businessModule").val(),droolsAttribute: $("#droolsAttribute").val(),ruleDesc: $("#ruleDesc").val(),isDecisionTable: isDecisionTableval,publicType: $("#publicType").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),importDesc: $("#importDesc").val(),droolsWhen: $("#droolsWhen").val(),droolsThen: $("#droolsThen").val(),remark: $("#remark").val()},
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
                if (isDecisionTableModel.isChecked){
                	isDecisionTableval="1";
                } else {
                	isDecisionTableval="";
                }
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),ruleName: $("#ruleName").val(),ruleNo: $("#ruleNo").val(),ruleType: $("#ruleType").val(),ruleStatus: $("#ruleStatus").val(),triggerType: $("#triggerType").val(),physicalLocation: $("#physicalLocation").val(),actionType: $("#actionType").val(),businessLocation: $("#businessLocation").val(),businessModule: $("#businessModule").val(),droolsAttribute: $("#droolsAttribute").val(),ruleDesc: $("#ruleDesc").val(),isDecisionTable:isDecisionTableval,publicType: $("#publicType").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),importDesc: $("#importDesc").val(),droolsWhen: $("#droolsWhen").val(),droolsThen: $("#droolsThen").val(),remark: $("#remark").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfCcmBoName"] = PlatformIpfCcmBoSelDialog.codetodes(data["ipfCcmBoId"]);

                        		data["triggerTypeName"] = SimpleListUtil.getSelectDes("T009", data["triggerType"]);
                        		data["actionTypeName"] = SimpleListUtil.getSelectDes("T010", data["actionType"]);
                        		data["ruleTypeName"] = SimpleListUtil.getSelectDes("T008", data["ruleType"]);
                        		data["ruleStatusName"] = SimpleListUtil.getSelectDes("T006", data["ruleStatus"]);
                        		data["publicTypeName"] = SimpleListUtil.getSelectDes("T007", data["publicType"]);
        						
        						
                        		data["isDecisionTableName"] = SimpleListUtil.getSelectDes("T014", data["isDecisionTable"]);
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
    
    var PlatformIpfReqRuleManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfReqRule_manage": "showPlatformIpfReqRuleManageList",  
            "basic_manage/platform_ckIpfReqRule_manage": "showPlatformckIpfReqRuleManageList"
        },
        showPlatformckIpfReqRuleManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfReqRuleManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfReqRuleManageListView = new SimpleListView({
                id: "platform_ipfReqRule_manage_list",
                title: "项目管理 > 规则需求",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("规则需求");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lruleName' align='right'>规则名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleName' name='规则名称' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lruleType' align='right'>规则类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='规则类型' id='ruleType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T008","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lruleStatus' align='right'>规则状态：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='规则状态' id='ruleStatus' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T006","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltriggerType' align='right'>触发类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='触发类型' id='triggerType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T009","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lphysicalLocation' align='right'>所处物理位置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='physicalLocation' name='所处物理位置' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lactionType' align='right'>动作类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='动作类型' id='actionType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T010","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lbusinessLocation' align='right'>所处业务位置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='businessLocation' name='所处业务位置' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lbusinessModule' align='right'>业务模块：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='businessModule' name='业务模块' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ldroolsAttribute' align='right'>规则属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='droolsAttribute' name='规则属性' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lruleDesc' align='right'>规则描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleDesc' name='规则描述' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lisDecisionTable' align='right'>是否使用决策表：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isDecisionTable' name='是否使用决策表' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lpublicType' align='right'>共享类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='共享类型' id='publicType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T007","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lipfCcmBoId' align='right'>业务对象：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfCcmBo'>";                        
                        detailstr+="<input id='ipfCcmBoId' name='ipfCcmBoId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfCcmBoName' name='IpfCcmBoName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='limportDesc' align='right'>传参说明：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='importDesc' name='传参说明' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ldroolsWhen' align='right'>DROOLS条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='droolsWhen' name='DROOLS条件' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldroolsThen' align='right'>DROOLS动作：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='droolsThen' name='DROOLS动作' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfReqRule.createIpfReqRule&v=1.0&format=json",$(detailstr),332);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfReqRuleManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfReqRuleManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfReqRuleManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfReqRule.deleteIpfReqRule&v=1.0&format=json",
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
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lruleName' align='right'>规则名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleName' name='规则名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lruleType' align='right'>规则类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='规则类型' id='ruleType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T008","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lruleStatus' align='right'>规则状态：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='规则状态' id='ruleStatus' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T006","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltriggerType' align='right'>触发类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='触发类型' id='triggerType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T009","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lphysicalLocation' align='right'>所处物理位置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='physicalLocation' name='所处物理位置' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lactionType' align='right'>动作类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='动作类型' id='actionType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T010","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lbusinessLocation' align='right'>所处业务位置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='businessLocation' name='所处业务位置' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lbusinessModule' align='right'>业务模块：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='businessModule' name='业务模块' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='ldroolsAttribute' align='right'>规则属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='droolsAttribute' name='规则属性' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lruleDesc' align='right'>规则描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleDesc' name='规则描述' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lisDecisionTable' align='right'>是否使用决策表：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isDecisionTable' name='是否使用决策表' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lpublicType' align='right'>共享类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='共享类型' id='publicType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T007","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lipfCcmBoId' align='right'>业务对象：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfCcmBo'>";                        
                        detailstr+="<input id='ipfCcmBoId' name='ipfCcmBoId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfCcmBoName' name='IpfCcmBoName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='limportDesc' align='right'>传参说明：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='importDesc' name='传参说明' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='ldroolsWhen' align='right'>DROOLS条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='droolsWhen' name='DROOLS条件' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldroolsThen' align='right'>DROOLS动作：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='droolsThen' name='DROOLS动作' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfReqRule.selectIpfReqRule&v=1.0&format=json",$(detailstr),332);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfReqRule.selectIpfReqRule&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ruleName: { type: "string" },ruleNo: { type: "string" },ruleType: { type: "string" },ruleStatus: { type: "string" },triggerType: { type: "string" },physicalLocation: { type: "string" },actionType: { type: "string" },businessLocation: { type: "string" },businessModule: { type: "string" },droolsAttribute: { type: "string" },ruleDesc: { type: "string" },isDecisionTable: { type: "string" },publicType: { type: "string" },ipfCcmBoId: { type: "string" },importDesc: { type: "string" },droolsWhen: { type: "string" },droolsThen: { type: "string" },remark: { type: "string" }
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
                                    data["IpfCcmBoName"] = PlatformIpfCcmBoSelDialog.codetodes(data["ipfCcmBoId"]);
                            		data["triggerTypeName"] = SimpleListUtil.getSelectDes("T009", data["triggerType"]);
                            		data["actionTypeName"] = SimpleListUtil.getSelectDes("T010", data["actionType"]);
                            		data["ruleTypeName"] = SimpleListUtil.getSelectDes("T008", data["ruleType"]);
                            		data["ruleStatusName"] = SimpleListUtil.getSelectDes("T006", data["ruleStatus"]);
                            		data["publicTypeName"] = SimpleListUtil.getSelectDes("T007", data["publicType"]);
                            		data["isDecisionTableName"] = SimpleListUtil.getSelectDes("T014", data["isDecisionTable"]);
                                }
                            }
                            result = platformIpfReqRuleManageListView.appendColValue(result);
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
                    		{field: "ruleName", title:"规则名称", align:"center", width: "100px"},
                    		{field: "ruleNo", title:"规则号", align:"center", width: "100px"},
                    		{field: "ruleType", title:"规则类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "ruleTypeName", title:"规则类型", align:"center", width: "100px"},
                    		{field: "ruleStatus", title:"规则状态", hidden:"true", align:"center", width: "100px"},
                    		{field: "ruleStatusName", title:"规则状态", align:"center", width: "100px"},
                    		{field: "triggerType", title:"触发类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "triggerTypeName", title:"触发类型", align:"center", width: "100px"},
                    		{field: "physicalLocation", title:"所处物理位置", align:"center", width: "100px"},
                    		{field: "actionType", title:"动作类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "actionTypeName", title:"动作类型", align:"center", width: "100px"},
                    		{field: "businessLocation", title:"所处业务位置", align:"center", width: "100px"},
                    		{field: "businessModule", title:"业务模块", align:"center", width: "100px"},
                    		{field: "droolsAttribute", title:"规则属性", align:"center", width: "100px"},
                    		{field: "ruleDesc", title:"规则描述", align:"center", width: "100px"},
                    		{field: "isDecisionTable", title:"是否使用决策表", hidden:"true", align:"center", width: "100px"},
                    		{field: "isDecisionTableName", title:"是否使用决策表", align:"center", width: "100px"},
                    		{field: "publicType", title:"共享类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "publicTypeName", title:"共享类型", align:"center", width: "100px"},
                    		{field: "ipfCcmBoId", title:"业务对象", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfCcmBoName", title:"业务对象", align:"center", width: "100px"},
                    		{field: "importDesc", title:"传参说明", align:"center", width: "100px"},
                    		{field: "droolsWhen", title:"DROOLS条件", align:"center", width: "100px"},
                    		{field: "droolsThen", title:"DROOLS动作", align:"center", width: "100px"},
                    		{field: "remark", title:"备注", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfReqRuleManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfReqRuleManageListView.get("columns");
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
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lruleName' align='right'>规则名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleName' name='规则名称' value='"+ColumnValue["ruleName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleNo' name='规则号' value='"+ColumnValue["ruleNo"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lruleType' align='right'>规则类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='规则类型' id='ruleType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T008", ColumnValue["ruleType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lruleStatus' align='right'>规则状态：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='规则状态' id='ruleStatus' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T006", ColumnValue["ruleStatus"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ltriggerType' align='right'>触发类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='触发类型' id='triggerType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T009", ColumnValue["triggerType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lphysicalLocation' align='right'>所处物理位置：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='physicalLocation' name='所处物理位置' value='"+ColumnValue["physicalLocation"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lactionType' align='right'>动作类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='动作类型' id='actionType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T010", ColumnValue["actionType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lbusinessLocation' align='right'>所处业务位置：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='businessLocation' name='所处业务位置' value='"+ColumnValue["businessLocation"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lbusinessModule' align='right'>业务模块：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='businessModule' name='业务模块' value='"+ColumnValue["businessModule"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldroolsAttribute' align='right'>规则属性：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='droolsAttribute' name='规则属性' value='"+ColumnValue["droolsAttribute"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lruleDesc' align='right'>规则描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleDesc' name='规则描述' value='"+ColumnValue["ruleDesc"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lisDecisionTable' align='right'>是否使用决策表：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='isDecisionTable' name='是否使用决策表' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isDecisionTable"]+"' style='...'/>";
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lpublicType' align='right'>共享类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='共享类型' id='publicType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T007", ColumnValue["publicType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lipfCcmBoId' align='right'>业务对象：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfCcmBo'>";                        
                                detailstr+="<input id='ipfCcmBoId' name='ipfCcmBoId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfCcmBoId"]+"' style='...'/>";
                                detailstr+="<input id='IpfCcmBoName' name='IpfCcmBoName' data-bind='value: name' value='"+PlatformIpfCcmBoSelDialog.codetodes(ColumnValue["ipfCcmBoId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='limportDesc' align='right'>传参说明：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='importDesc' name='传参说明' value='"+ColumnValue["importDesc"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldroolsWhen' align='right'>DROOLS条件：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='droolsWhen' name='DROOLS条件' value='"+ColumnValue["droolsWhen"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldroolsThen' align='right'>DROOLS动作：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='droolsThen' name='DROOLS动作' value='"+ColumnValue["droolsThen"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='remark' name='备注' value='"+ColumnValue["remark"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfReqRule.updateIpfReqRule&v=1.0&format=json", $(detailstr),332);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfReqRuleManageListView);
        }
    });

    return PlatformIpfReqRuleManageRouter;
});

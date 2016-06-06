
/**
 * 规则
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
    "js/app/ruledesign/routers/PlatformRulesetSelDialog",
    "rpc/AjaxEngine",
    "text!js/app/ruledesign/templates/rulediv.html"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformRulesetSelDialog,
		AjaxEngine,ruleViewTemplate){
	
    function showRulesetSelDialog(){
        var detailstr="";
        detailstr+="<div id='Rulesetgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformRulesetSelDialog.showGridData($("#Rulesetgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.rulesetName;
            $("#rulesetId").val(Id);
            $("#RulesetName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, height, titles);
    	
        var RulesetviewModel = kendo.observable({
            id: $("#rulesetId").val(),
            name: $("#RulesetName").val(),
            displayGreeting: function() {
            showRulesetSelDialog();
            }
        });
        kendo.bind($("#viewRuleset"), RulesetviewModel);

        var isUsedModel = kendo.observable({
            isChecked: $("#isUsed").val()=="1"
        });
        kendo.bind($("#isUsed"), isUsedModel);
        var isUsedval="0";
		
        if (tp==1){
        $("#submitBtn").click(function(){    	
            if (isUsedModel.isChecked){
            	isUsedval="1";
            } else {
            	isUsedval="0";
            }
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ruleName: $("#ruleName").val(),rulesetId: $("#rulesetId").val(),isUsed: isUsedval,priLevel: $("#priLevel").val(),contentType: $("#contentType").val(),effectDate: $("#effectDate").val(),invalidDate: $("#invalidDate").val(),creator: $("#creator").val(),createDate: $("#createDate").val(),modifyDate: $("#modifyDate").val(),modifyed: $("#modifyed").val(),owner: $("#owner").val(),locked: $("#locked").val()},
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
                if (isUsedModel.isChecked){
                	isUsedval="1";
                } else {
                	isUsedval="";
                }
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),ruleName: $("#ruleName").val(),rulesetId: $("#rulesetId").val(),isUsed:isUsedval,priLevel: $("#priLevel").val(),contentType: $("#contentType").val(),effectDate: $("#effectDate").val(),invalidDate: $("#invalidDate").val(),creator: $("#creator").val(),createDate: $("#createDate").val(),modifyDate: $("#modifyDate").val(),modifyed: $("#modifyed").val(),owner: $("#owner").val(),locked: $("#locked").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["RulesetName"] = PlatformRulesetSelDialog.codetodes(data["rulesetId"]);

                        		data["contentTypeName"] = SimpleListUtil.getSelectDes("106", data["contentType"]);
        						
                        		data["isUsedName"] = SimpleListUtil.getSelectDes("109", data["isUsed"]);
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
        	$("#effectDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss", value:new Date()});
        } else {
        	$("#effectDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss"});
        }
        if (tp==1){
        	$("#invalidDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss", value:new Date()});
        } else {
        	$("#invalidDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss"});
        }
        if (tp==1){
        	$("#modifyDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss", value:new Date()});
        } else {
        	$("#modifyDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss"});
        }
        if (tp==1){
        	$("#createDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss", value:new Date()});
        } else {
        	$("#createDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss"});
        }
        
    }
    
    var PlatformRuleManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_Rule_manage": "showPlatformRuleManageList",  
            "basic_manage/platform_ckRule_manage": "showPlatformckRuleManageList",
            "basic_manage/platform_Rule_manage_edit": "showPlatformRuleManageEdit"
        },
        showPlatformRuleManageEdit: function(){
            var ruleView = new BaseView({id: "ruledefine", title: "规则定义", viewTemplate: ruleViewTemplate, data: {}});
            this.changePage(ruleView);
        },
        showPlatformckRuleManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformRuleManageList: function(){
            var rulesetId=SimpleListUtil.GetQueryString("id");
            var RulesetName=decodeURI(SimpleListUtil.GetQueryString("name"));
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformRuleManageListView = new SimpleListView({
                id: "platform_rule_manage_list",
                title: "基础管理 > 规则/规则集 > 规则",
                buttonCount:5,

                ready: function(){
                    this.setSimpleListHeader("规则/规则集 > 规则");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleName' align='right'>规则：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleName' name='规则' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrulesetId' align='right'>规则集：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewRuleset'>";                        
                        detailstr+="<input id='rulesetId' name='rulesetId' hidden='true' data-bind='value: id' value='"+rulesetId+"' style='...'/>";
                        detailstr+="<input id='RulesetName' name='RulesetName' data-bind='value: name' value='"+RulesetName+"' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisUsed' align='right'>是否有效：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isUsed' name='是否有效' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpriLevel' align='right'>优先级：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='priLevel' name='优先级' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontentType' align='right'>内容类别：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='内容类别' id='contentType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("106","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='leffectDate' align='right'>生效日期：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='effectDate' name='生效日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linvalidDate' align='right'>失效日期：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='invalidDate' name='失效日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreator' align='right'>创建人：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='creator' name='创建人' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreateDate' align='right'>创建日期：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='createDate' name='创建日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmodifyDate' align='right'>修改日期：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='modifyDate' name='修改日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmodifyed' align='right'>修改人：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='modifyed' name='修改人' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lowner' align='right'>所有人：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='owner' name='所有人' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llocked' align='right'>锁定人：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='locked' name='锁定人' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=rule.createRule&v=1.0&format=json",$(detailstr),430);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformRuleManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformRuleManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformRuleManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=rule.deleteRule&v=1.0&format=json",
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
                        detailstr+="<label id='lruleName' align='right'>规则：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleName' name='规则' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrulesetId' align='right'>规则集：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewRuleset'>";                        
                        detailstr+="<input id='rulesetId' name='rulesetId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='RulesetName' name='RulesetName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisUsed' align='right'>是否有效：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isUsed' name='是否有效' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpriLevel' align='right'>优先级：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='priLevel' name='优先级' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontentType' align='right'>内容类别：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='内容类别' id='contentType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("106","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='leffectDate' align='right'>生效日期：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='effectDate' name='生效日期' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linvalidDate' align='right'>失效日期：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='invalidDate' name='失效日期' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreator' align='right'>创建人：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='creator' name='创建人' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreateDate' align='right'>创建日期：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='createDate' name='创建日期' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmodifyDate' align='right'>修改日期：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='modifyDate' name='修改日期' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmodifyed' align='right'>修改人：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='modifyed' name='修改人' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lowner' align='right'>所有人：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='owner' name='所有人' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llocked' align='right'>锁定人：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='locked' name='锁定人' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=rule.selectRule&v=1.0&format=json",$(detailstr),430);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("rulesetBtn", "规则集", function(){
                        window.location.href ="ruledesign.html#basic_manage/platform_Ruleset_manage";
                    }, "createLink");
                    this.addToolbarBtn("ruledefineBtn", "规则定义", function(){
                        var rowCount = platformRuleManageListView.getGridObject().select().length;
                        if (rowCount>0){
                            rowEl = platformRuleManageListView.getGridObject().select().get(0);
                            var ID = SimpleListUtil.getColumnValue(platformRuleManageListView.getGridObject(),rowEl, "id");
                            var NAME = SimpleListUtil.getColumnValue(platformRuleManageListView.getGridObject(),rowEl, "ruleName");
                            // window.location.href ="ruletree.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_RuleTreeOutput_manage";
                           /*sss
                            var detailstr="";
                            detailstr+="<div id='content' align='center'>";
                            detailstr+="</div>";
                            detailstr+="<div id='display' align='center'>";
                            detailstr+="</div>";
                            var rdefineWindow = SimpleListUtil.showkdDialog(3, $(detailstr), 350, 500, "规则定义");

                            $("#content").load("ruledefine.html",function(responseText,textStatus){
                                $("#display").append("<hr>responseText:"+responseText);
                                $("#display").append("<hr>textStatus:"+textStatus);
                            });    */
                            $.window.showModalDialog("规则定义", "ruledefine.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_Rule_manage_edit", null, null, null, {top:0, left:0, width:0})
                            //window.open("ruledefine.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_Rule_manage_edit");
                        } else {
                            alert("请先选择记录！");
                        }
                    }, "edit");
                },

                dataSource: {
                    serverPaging: false,
                    serverSorting: false,             //排序
                    serverGrouping: false,            //分组
                    group: { field: "RulesetName" },
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=rule.selectRule&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ruleName: { type: "string" },rulesetId: { type: "string" },isUsed: { type: "string" },priLevel: { type: "string" },contentType: { type: "string" },effectDate: { type: "string" },invalidDate: { type: "string" },creator: { type: "string" },createDate: { type: "string" },modifyDate: { type: "string" },modifyed: { type: "string" },owner: { type: "string" },locked: { type: "string" }
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
                                    data["RulesetName"] = PlatformRulesetSelDialog.codetodes(data["rulesetId"]);
                            		data["contentTypeName"] = SimpleListUtil.getSelectDes("106", data["contentType"]);
                            		data["isUsedName"] = SimpleListUtil.getSelectDes("109", data["isUsed"]);
                                }
                            }
                            result = platformRuleManageListView.appendColValue(result);
                            return result;
                        },
                        //记录条数
                        total: function(response) {
                            var result = response["total"] || response["resultJson"].length;
                            return result;
                        }
                    }
                },
                sortable: true,
                groupable: true,
                columns: [
                          {field: "chk", type:"chk", title: "&nbsp;", value:"ID"},
                          {field: "id", title:"主键", hidden:"true", align:"center", width: "100px"},
                    		{field: "ruleName", title:"规则", align:"center", width: "100px"},
                    		{field: "rulesetId", title:"规则集", hidden:"true", align:"center", width: "100px"},
                    		{field: "RulesetName", title:"规则集", align:"center", width: "100px"},
                    		{field: "isUsed", title:"是否有效", hidden:"true", align:"center", width: "100px"},
                    		{field: "isUsedName", title:"是否有效", align:"center", width: "100px"},
                    		{field: "priLevel", title:"优先级", align:"center", width: "100px"},
                    		{field: "contentType", title:"内容类别", hidden:"true", align:"center", width: "100px"},
                    		{field: "contentTypeName", title:"内容类别", align:"center", width: "100px"},
                    		{field: "effectDate", title:"生效日期", align:"center", width: "100px"},
                    		{field: "invalidDate", title:"失效日期", align:"center", width: "100px"},
                    		{field: "creator", title:"创建人", align:"center", width: "100px"},
                    		{field: "createDate", title:"创建日期", align:"center", width: "100px"},
                    		{field: "modifyDate", title:"修改日期", align:"center", width: "100px"},
                    		{field: "modifyed", title:"修改人", align:"center", width: "100px"},
                    		{field: "owner", title:"所有人", align:"center", width: "100px"},
                    		{field: "locked", title:"锁定人", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            "text" :{ edit:"修改", cancel: "取消", update: "保存" } ,
                            name: "edit",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformRuleManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformRuleManageListView.get("columns");
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
                                detailstr+="<label id='lruleName' align='right'>规则：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='ruleName' name='规则' value='"+ColumnValue["ruleName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrulesetId' align='right'>规则集：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewRuleset'>";                        
                                detailstr+="<input id='rulesetId' name='rulesetId' hidden='true' data-bind='value: id' value='"+ColumnValue["rulesetId"]+"' style='...'/>";
                                detailstr+="<input id='RulesetName' name='RulesetName' data-bind='value: name' value='"+PlatformRulesetSelDialog.codetodes(ColumnValue["rulesetId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisUsed' align='right'>是否有效：</label>";
                                detailstr+="</td><td>";
          						
        						
                        		detailstr+="<input id='isUsed' name='是否有效' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isUsed"]+"' style='...'/>";
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpriLevel' align='right'>优先级：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='priLevel' name='优先级' value='"+ColumnValue["priLevel"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcontentType' align='right'>内容类别：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='内容类别' id='contentType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("106", ColumnValue["contentType"]);
                                detailstr+="</select>";
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='leffectDate' align='right'>生效日期：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='effectDate' name='生效日期' value='"+ColumnValue["effectDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linvalidDate' align='right'>失效日期：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='invalidDate' name='失效日期' value='"+ColumnValue["invalidDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreator' align='right'>创建人：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='creator' name='创建人' value='"+ColumnValue["creator"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreateDate' align='right'>创建日期：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='createDate' name='创建日期' value='"+ColumnValue["createDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmodifyDate' align='right'>修改日期：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='modifyDate' name='修改日期' value='"+ColumnValue["modifyDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmodifyed' align='right'>修改人：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='modifyed' name='修改人' value='"+ColumnValue["modifyed"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lowner' align='right'>所有人：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='owner' name='所有人' value='"+ColumnValue["owner"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llocked' align='right'>锁定人：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='locked' name='锁定人' value='"+ColumnValue["locked"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=rule.updateRule&v=1.0&format=json", $(detailstr),430);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformRuleManageListView);
        }
    });

    return PlatformRuleManageRouter;
});

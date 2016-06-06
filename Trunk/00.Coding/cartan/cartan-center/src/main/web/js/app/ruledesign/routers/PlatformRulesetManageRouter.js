
/**
 * 规则集
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

        var statusModel = kendo.observable({
            isChecked:  $("*[name='status']").attr("curdata")
        });
        kendo.bind($("*[name='status']"), statusModel);


        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),rulesetName: $("#rulesetName").val(),version: $("#version").val(),status: statusModel.isChecked,modifyDate: $("#modifyDate").val(),modifyed: $("#modifyed").val(),owner: $("#owner").val(),locked: $("#locked").val()},
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
                    data:{id: $("#id").val(),rulesetName: $("#rulesetName").val(),version: $("#version").val(),status: statusModel.isChecked,modifyDate: $("#modifyDate").val(),modifyed: $("#modifyed").val(),owner: $("#owner").val(),locked: $("#locked").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];

                        		data["statusName"] = SimpleListUtil.getSelectDes("102", data["status"]);
        						
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
        	$("#modifyDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss", value:new Date()});
        } else {
        	$("#modifyDate").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss"});
        }
        
    }
    
    var PlatformRulesetManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_Ruleset_manage": "showPlatformRulesetManageList",  
            "basic_manage/platform_ckRuleset_manage": "showPlatformckRulesetManageList"
        },
        showPlatformckRulesetManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformRulesetManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformRulesetManageListView = new SimpleListView({
                id: "platform_ruleset_manage_list",
                title: "基础管理 > 规则集",
                buttonCount:5,

                ready: function(){
                    this.setSimpleListHeader("规则集");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrulesetName' align='right'>规则集：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rulesetName' name='规则集' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lversion' align='right'>版本：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='version' name='版本' style='...'/>";
                        detailstr+="</td></tr>"
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<input id='status'  hidden='true'  curdata='101' name='状态' style='...'/>";
                        detailstr+="&nbsp;&nbsp;<input type='radio' curdata='101' value='101' name='status' checked style='...'/>正常";
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
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ruleset.createRuleset&v=1.0&format=json",$(detailstr),250);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformRulesetManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformRulesetManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformRulesetManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ruleset.deleteRuleset&v=1.0&format=json",
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
                        detailstr+="<label id='lrulesetName' align='right'>规则集：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rulesetName' name='规则集' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lversion' align='right'>版本：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='version' name='版本' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";
                        detailstr+= SimpleListUtil.getRadioCode("102", "status", "");
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
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ruleset.selectRuleset&v=1.0&format=json",$(detailstr),250);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("roleBtn", "授 权", function(){
                        var rowCount = platformRulesetManageListView.getGridObject().select().length;
                        if (rowCount>0){
                            rowEl = platformRulesetManageListView.getGridObject().select().get(0);
                            var ID = SimpleListUtil.getColumnValue(platformRulesetManageListView.getGridObject(),rowEl, "id");
                            var status = SimpleListUtil.getColumnValue(platformRulesetManageListView.getGridObject(),rowEl, "status");
                            var locked = SimpleListUtil.getColumnValue(platformRulesetManageListView.getGridObject(),rowEl, "locked");
                            // window.location.href ="ruletree.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_RuleTreeOutput_manage";
                            // $.window.showModalDialog("节点定义", "ruletree.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_RuleTree_manage_edit", null, null, null, {top:50, left:50, width:1200});

                            var detailstr="";
                            detailstr+="<div id='content' align='center'>";
                            detailstr+="<table>";
                            detailstr+="<input id='id' name='主键' hidden='true'  value='"+ID+"' style='...'/>";
                            detailstr+="<tr><td>";
                            detailstr+="<label id='lstatus' align='right'>状态：</label>";
                            detailstr+="</td><td>";
                            detailstr+= SimpleListUtil.getRadioCode("102", "status", status);
                            detailstr+="</td></tr>";
                            detailstr+="</table>";
                            detailstr+="</div>";
                            detailstr+="<div align='center'>";
                            detailstr+="<input id='submitBtn'  name='QueryBtn' type='button' value='确 定'  />";
                            detailstr+="</div>";
                            var dialogId = "detail_edit_dialog_" + ID;
                            showEditDetilDialog(1,"授权",dialogId,"router?appKey=000001&method=ruleset.updateRuleset&v=1.0&format=json", $(detailstr),70);
                            dialogId = null;

                        } else {
                            alert("请先选择记录！");
                        }
                    }, "edit");
                    this.addToolbarBtn("varBtn", "规则", function(){
                        var rowCount = platformRulesetManageListView.getGridObject().select().length;
                        if (rowCount>0){
                            rowEl = platformRulesetManageListView.getGridObject().select().get(0);
                            var ID = SimpleListUtil.getColumnValue(platformRulesetManageListView.getGridObject(),rowEl, "id");
                            var NAME = SimpleListUtil.getColumnValue(platformRulesetManageListView.getGridObject(),rowEl, "rulesetName");
                            window.location.href ="ruledesign.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_Rule_manage";
                        } else {
                            alert("请先选择记录！");
                        }
                    }, "createLink");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ruleset.selectRuleset&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },rulesetName: { type: "string" },version: { type: "string" },status: { type: "string" },modifyDate: { type: "string" },modifyed: { type: "string" },owner: { type: "string" },locked: { type: "string" }
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
                            		data["statusName"] = SimpleListUtil.getSelectDes("102", data["status"]);
                                }
                            }
                            result = platformRulesetManageListView.appendColValue(result);
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
                    		{field: "rulesetName", title:"规则集", align:"center", width: "100px"},
                    		{field: "version", title:"版本", align:"center", width: "100px"},
                    		{field: "status", title:"状态", hidden:"true", align:"center", width: "100px"},
                    		{field: "statusName", title:"状态", align:"center", width: "100px"},
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
                                platformRulesetManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformRulesetManageListView.get("columns");
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
                                detailstr+="<label id='lrulesetName' align='right'>规则集：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='rulesetName' name='规则集' value='"+ColumnValue["rulesetName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lversion' align='right'>版本：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='version' name='版本' value='"+ColumnValue["version"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lstatus' align='right'>状态：</label>";
                                detailstr+="</td><td>";

                                detailstr+="<label id='status' align='left'>"+SimpleListUtil.getSelectDes("102", ColumnValue["status"])+"</label>";

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
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ruleset.updateRuleset&v=1.0&format=json", $(detailstr),250);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformRulesetManageListView);
        }
    });

    return PlatformRulesetManageRouter;
});

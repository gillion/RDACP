
/**
 * 条件细分
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
    "rpc/AjaxEngine",
    "text!js/app/ruledesign/templates/ConditionPartitionVar.html"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		AjaxEngine,conditionPartitionViewTemplate){
	
    
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
                    data:{id: $("#id").val(),conditionName: $("#conditionName").val(),status: statusModel.isChecked,modifyDate: $("#modifyDate").val(),modifyed: $("#modifyed").val(),owner: $("#owner").val(),locked: $("#locked").val()},
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
                    data:{id: $("#id").val(),conditionName: $("#conditionName").val(),status: statusModel.isChecked,modifyDate: $("#modifyDate").val(),modifyed: $("#modifyed").val(),owner: $("#owner").val(),locked: $("#locked").val()},
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
    
    var PlatformConditionPartitionManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_ConditionPartition_manage": "showPlatformConditionPartitionManageList",  
            "basic_manage/platform_ckConditionPartition_manage": "showPlatformckConditionPartitionManageList",
            "basic_manage/platform_ConditionPartition_manage_edit": "showPlatformConditionPartitionManageEdit"
        },
        showPlatformConditionPartitionManageEdit: function(){
            var conditionPartition = new BaseView({id: "conditionPartitionVar", title: "条件节点", viewTemplate: conditionPartitionViewTemplate, data: {}});

            this.changePage(conditionPartition);
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            $("#selectAll").bind("click", selectAll);
        },
        showPlatformckConditionPartitionManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformConditionPartitionManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformConditionPartitionManageListView = new SimpleListView({
                id: "platform_conditionPartition_manage_list",
                title: "基础管理 > 条件细分",
                buttonCount:5,

                ready: function(){
                    this.setSimpleListHeader("条件细分");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconditionName' align='right'>条件模型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conditionName' name='条件模型' style='...'/>";
                        detailstr+="</td></tr>";
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
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=conditionPartition.createConditionPartition&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformConditionPartitionManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformConditionPartitionManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformConditionPartitionManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=conditionPartition.deleteConditionPartition&v=1.0&format=json",
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
                        detailstr+="<label id='lconditionName' align='right'>条件模型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conditionName' name='条件模型' style='...'/>";
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
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=conditionPartition.selectConditionPartition&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("roleBtn", "授 权", function(){
                        var rowCount = platformConditionPartitionManageListView.getGridObject().select().length;
                        if (rowCount>0){
                            rowEl = platformConditionPartitionManageListView.getGridObject().select().get(0);
                            var ID = SimpleListUtil.getColumnValue(platformConditionPartitionManageListView.getGridObject(),rowEl, "id");
                            var status = SimpleListUtil.getColumnValue(platformConditionPartitionManageListView.getGridObject(),rowEl, "status");
                            var locked = SimpleListUtil.getColumnValue(platformConditionPartitionManageListView.getGridObject(),rowEl, "locked");
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
                            showEditDetilDialog(1,"授权",dialogId,"router?appKey=000001&method=conditionPartition.updateConditionPartition&v=1.0&format=json", $(detailstr),70);
                            dialogId = null;

                        } else {
                            alert("请先选择记录！");
                        }
                    }, "edit");
                    this.addToolbarBtn("varBtn", "节点定义", function(){
                        var rowCount = platformConditionPartitionManageListView.getGridObject().select().length;
                        if (rowCount>0){
                            rowEl = platformConditionPartitionManageListView.getGridObject().select().get(0);
                            var ID = SimpleListUtil.getColumnValue(platformConditionPartitionManageListView.getGridObject(),rowEl, "id");
                            var NAME = SimpleListUtil.getColumnValue(platformConditionPartitionManageListView.getGridObject(),rowEl, "conditionName");
                            //window.location.href ="ruledesign.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_ConditionPartitionNode_manage";
                            window.location.href ="ruletree.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_ConditionPartition_manage_edit";


                        } else {
                            alert("请先选择记录！");
                        }
                    }, "createLink");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=conditionPartition.selectConditionPartition&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },conditionName: { type: "string" },status: { type: "string" },modifyDate: { type: "string" },modifyed: { type: "string" },owner: { type: "string" },locked: { type: "string" }
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
                            result = platformConditionPartitionManageListView.appendColValue(result);
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
                    		{field: "conditionName", title:"条件模型", align:"center", width: "100px"},
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
                                platformConditionPartitionManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformConditionPartitionManageListView.get("columns");
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
                                detailstr+="<label id='lconditionName' align='right'>条件模型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='conditionName' name='条件模型' value='"+ColumnValue["conditionName"]+"' style='...'/>";
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
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=conditionPartition.updateConditionPartition&v=1.0&format=json", $(detailstr),220);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformConditionPartitionManageListView);
        }
    });

    return PlatformConditionPartitionManageRouter;
});

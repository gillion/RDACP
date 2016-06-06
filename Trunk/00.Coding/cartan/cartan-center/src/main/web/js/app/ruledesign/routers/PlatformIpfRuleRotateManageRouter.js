
/**
 * IpfRuleRotate
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
                    data:{id: $("#id").val(),warehouseOfficeId: $("#warehouseOfficeId").val(),ruleCode: $("#ruleCode").val(),ruleDesc: $("#ruleDesc").val(),isActive: $("#isActive").val(),isSystemCreate: $("#isSystemCreate").val(),rotateExpress: $("#rotateExpress").val()},
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
                    data:{id: $("#id").val(),warehouseOfficeId: $("#warehouseOfficeId").val(),ruleCode: $("#ruleCode").val(),ruleDesc: $("#ruleDesc").val(),isActive: $("#isActive").val(),isSystemCreate: $("#isSystemCreate").val(),rotateExpress: $("#rotateExpress").val()},
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
    
    var PlatformIpfRuleRotateManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfRuleRotate_manage": "showPlatformIpfRuleRotateManageList",  
            "basic_manage/platform_ckIpfRuleRotate_manage": "showPlatformckIpfRuleRotateManageList"
        },
        showPlatformckIpfRuleRotateManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfRuleRotateManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfRuleRotateManageListView = new SimpleListView({
                id: "platform_ipfRuleRotate_manage_list",
                title: "基础管理 > IpfRuleRotate",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfRuleRotate");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lwarehouseOfficeId' align='right'>周转单位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='warehouseOfficeId' name='周转单位' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleCode' align='right'>周转规则代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleCode' name='周转规则代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleDesc' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleDesc' name='描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisActive' align='right'>启用：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='启用' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSystemCreate' align='right'>系统创建：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSystemCreate' name='系统创建' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrotateExpress' align='right'>周转规则表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rotateExpress' name='周转规则表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfRuleRotate.createIpfRuleRotate&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfRuleRotateManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfRuleRotateManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfRuleRotateManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfRuleRotate.deleteIpfRuleRotate&v=1.0&format=json",
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
                        detailstr+="<label id='lwarehouseOfficeId' align='right'>周转单位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='warehouseOfficeId' name='周转单位' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleCode' align='right'>周转规则代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleCode' name='周转规则代码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleDesc' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleDesc' name='描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisActive' align='right'>启用：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='启用' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSystemCreate' align='right'>系统创建：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSystemCreate' name='系统创建' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrotateExpress' align='right'>周转规则表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rotateExpress' name='周转规则表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfRuleRotate.selectIpfRuleRotate&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfRuleRotate.selectIpfRuleRotate&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },warehouseOfficeId: { type: "string" },ruleCode: { type: "string" },ruleDesc: { type: "string" },isActive: { type: "string" },isSystemCreate: { type: "string" },rotateExpress: { type: "string" }
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
                            result = platformIpfRuleRotateManageListView.appendColValue(result);
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
                    		{field: "warehouseOfficeId", title:"周转单位", align:"center", width: "100px"},
                    		{field: "ruleCode", title:"周转规则代码", align:"center", width: "100px"},
                    		{field: "ruleDesc", title:"描述", align:"center", width: "100px"},
                    		{field: "isActive", title:"启用", align:"center", width: "100px"},
                    		{field: "isSystemCreate", title:"系统创建", align:"center", width: "100px"},
                    		{field: "rotateExpress", title:"周转规则表达式", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfRuleRotateManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfRuleRotateManageListView.get("columns");
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
                                detailstr+="<label id='lwarehouseOfficeId' align='right'>周转单位：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='warehouseOfficeId' name='周转单位' value='"+ColumnValue["warehouseOfficeId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleCode' align='right'>周转规则代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleCode' name='周转规则代码' value='"+ColumnValue["ruleCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleDesc' align='right'>描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleDesc' name='描述' value='"+ColumnValue["ruleDesc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisActive' align='right'>启用：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isActive' name='启用' value='"+ColumnValue["isActive"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisSystemCreate' align='right'>系统创建：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isSystemCreate' name='系统创建' value='"+ColumnValue["isSystemCreate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrotateExpress' align='right'>周转规则表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='rotateExpress' name='周转规则表达式' value='"+ColumnValue["rotateExpress"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfRuleRotate.updateIpfRuleRotate&v=1.0&format=json", $(detailstr),220);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfRuleRotateManageListView);
        }
    });

    return PlatformIpfRuleRotateManageRouter;
});

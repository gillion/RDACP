
/**
 * IpfRuleFilterDetail
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
                    data:{id: $("#id").val(),ipfRuleFilterId: $("#ipfRuleFilterId").val(),lineId: $("#lineId").val(),attribute: $("#attribute").val(),operand: $("#operand").val(),literalValue: $("#literalValue").val(),andOr: $("#andOr").val(),leftParen: $("#leftParen").val(),rightParen: $("#rightParen").val()},
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
                    data:{id: $("#id").val(),ipfRuleFilterId: $("#ipfRuleFilterId").val(),lineId: $("#lineId").val(),attribute: $("#attribute").val(),operand: $("#operand").val(),literalValue: $("#literalValue").val(),andOr: $("#andOr").val(),leftParen: $("#leftParen").val(),rightParen: $("#rightParen").val()},
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
    
    var PlatformIpfRuleFilterDetailManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfRuleFilterDetail_manage": "showPlatformIpfRuleFilterDetailManageList",  
            "basic_manage/platform_ckIpfRuleFilterDetail_manage": "showPlatformckIpfRuleFilterDetailManageList"
        },
        showPlatformckIpfRuleFilterDetailManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfRuleFilterDetailManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfRuleFilterDetailManageListView = new SimpleListView({
                id: "platform_ipfRuleFilterDetail_manage_list",
                title: "基础管理 > IpfRuleFilterDetail",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfRuleFilterDetail");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfRuleFilterId' align='right'>筛选条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRuleFilterId' name='筛选条件' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llineId' align='right'>行号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lineId' name='行号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lattribute' align='right'>表属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='attribute' name='表属性' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperand' align='right'>运算符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='operand' name='运算符' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lliteralValue' align='right'>值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='literalValue' name='值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='landOr' align='right'>AND或者OR：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='andOr' name='AND或者OR' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lleftParen' align='right'>左括号数量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='leftParen' name='左括号数量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrightParen' align='right'>右括号数量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rightParen' name='右括号数量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfRuleFilterDetail.createIpfRuleFilterDetail&v=1.0&format=json",$(detailstr),280);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfRuleFilterDetailManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfRuleFilterDetailManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfRuleFilterDetailManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfRuleFilterDetail.deleteIpfRuleFilterDetail&v=1.0&format=json",
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
                        detailstr+="<label id='lipfRuleFilterId' align='right'>筛选条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRuleFilterId' name='筛选条件' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llineId' align='right'>行号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lineId' name='行号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lattribute' align='right'>表属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='attribute' name='表属性' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperand' align='right'>运算符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='operand' name='运算符' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lliteralValue' align='right'>值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='literalValue' name='值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='landOr' align='right'>AND或者OR：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='andOr' name='AND或者OR' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lleftParen' align='right'>左括号数量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='leftParen' name='左括号数量' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrightParen' align='right'>右括号数量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rightParen' name='右括号数量' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfRuleFilterDetail.selectIpfRuleFilterDetail&v=1.0&format=json",$(detailstr),280);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfRuleFilterDetail.selectIpfRuleFilterDetail&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfRuleFilterId: { type: "string" },lineId: { type: "string" },attribute: { type: "string" },operand: { type: "string" },literalValue: { type: "string" },andOr: { type: "string" },leftParen: { type: "string" },rightParen: { type: "string" }
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
                            result = platformIpfRuleFilterDetailManageListView.appendColValue(result);
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
                    		{field: "ipfRuleFilterId", title:"筛选条件", align:"center", width: "100px"},
                    		{field: "lineId", title:"行号", align:"center", width: "100px"},
                    		{field: "attribute", title:"表属性", align:"center", width: "100px"},
                    		{field: "operand", title:"运算符", align:"center", width: "100px"},
                    		{field: "literalValue", title:"值", align:"center", width: "100px"},
                    		{field: "andOr", title:"AND或者OR", align:"center", width: "100px"},
                    		{field: "leftParen", title:"左括号数量", align:"center", width: "100px"},
                    		{field: "rightParen", title:"右括号数量", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfRuleFilterDetailManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfRuleFilterDetailManageListView.get("columns");
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
                                detailstr+="<label id='lipfRuleFilterId' align='right'>筛选条件：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfRuleFilterId' name='筛选条件' value='"+ColumnValue["ipfRuleFilterId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llineId' align='right'>行号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='lineId' name='行号' value='"+ColumnValue["lineId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lattribute' align='right'>表属性：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='attribute' name='表属性' value='"+ColumnValue["attribute"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loperand' align='right'>运算符：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='operand' name='运算符' value='"+ColumnValue["operand"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lliteralValue' align='right'>值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='literalValue' name='值' value='"+ColumnValue["literalValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='landOr' align='right'>AND或者OR：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='andOr' name='AND或者OR' value='"+ColumnValue["andOr"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lleftParen' align='right'>左括号数量：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='leftParen' name='左括号数量' value='"+ColumnValue["leftParen"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrightParen' align='right'>右括号数量：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='rightParen' name='右括号数量' value='"+ColumnValue["rightParen"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfRuleFilterDetail.updateIpfRuleFilterDetail&v=1.0&format=json", $(detailstr),280);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfRuleFilterDetailManageListView);
        }
    });

    return PlatformIpfRuleFilterDetailManageRouter;
});

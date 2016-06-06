
/**
 * 设备代码
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
	
    
    function showEditDetilDialog(tp, titles, id, url, content){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, 190, titles);
    	
        
        if (tp==1){
        $("#submitBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),codeType: $("#codeType").val(),codeTypeDesc: $("#codeTypeDesc").val(),codeNo: $("#codeNo").val(),codeName: $("#codeName").val(),isUsed: $("#isUsed").val(),operatorId: $("#operatorId").val()},
                    dataType: 'json',
                    complete: function(transport){
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("操作成功！");
                        kendoUIWindow.close();
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                    }
                }
            );
        });
    	} else{
        $("#QueryBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),codeType: $("#codeType").val(),codeTypeDesc: $("#codeTypeDesc").val(),codeNo: $("#codeNo").val(),codeName: $("#codeName").val(),isUsed: $("#isUsed").val(),operatorId: $("#operatorId").val()},
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
                        kendoUIWindow.close();
                    }
                }
            );
        });
    	}
        SimpleListUtil.setDataTimeCn();

        
    }
    
    var PlatformMcpubCodeManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_McpubCode_manage": "showPlatformMcpubCodeManageList",  
            "basic_manage/platform_ckMcpubCode_manage": "showPlatformckMcpubCodeManageList"
        },
        showPlatformckMcpubCodeManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformMcpubCodeManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformMcpubCodeManageListView = new SimpleListView({
                id: "platform_mcpubCode_manage_list",
                title: "基础管理 > 设备代码",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("设备代码");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeType' align='right'>代码类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='codeType' name='代码类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeTypeDesc' align='right'>代码类别描述：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='codeTypeDesc' name='代码类别描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeNo' align='right'>代码编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='codeNo' name='代码编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeName' align='right'>代码描述：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='codeName' name='代码描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisUsed' align='right'>是否使用：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='isUsed' name='是否使用' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperatorId' align='right'>操作人员：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='operatorId' name='操作人员' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=mcpubCode.createMcpubCode&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformMcpubCodeManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformMcpubCodeManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformMcpubCodeManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=mcpubCode.deleteMcpubCode&v=1.0&format=json",
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
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeType' align='right'>代码类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='codeType' name='代码类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeTypeDesc' align='right'>代码类别描述：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='codeTypeDesc' name='代码类别描述' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeNo' align='right'>代码编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='codeNo' name='代码编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeName' align='right'>代码描述：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='codeName' name='代码描述' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisUsed' align='right'>是否使用：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='isUsed' name='是否使用' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperatorId' align='right'>操作人员：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='operatorId' name='操作人员' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=mcpubCode.selectMcpubCode&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=mcpubCode.selectMcpubCode&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },codeType: { type: "string" },codeTypeDesc: { type: "string" },codeNo: { type: "string" },codeName: { type: "string" },isUsed: { type: "string" },operatorId: { type: "string" }
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
                            result = platformMcpubCodeManageListView.appendColValue(result);
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
                          {field: "id", title:"编号", hidden:"true", align:"center", width: "100px"},

    						
                    		{field: "codeType", title:"代码类别", align:"center", width: "100px"},

    						
                    		{field: "codeTypeDesc", title:"代码类别描述", align:"center", width: "100px"},

    						
                    		{field: "codeNo", title:"代码编号", align:"center", width: "100px"},

    						
                    		{field: "codeName", title:"代码描述", align:"center", width: "100px"},

    						
                    		{field: "isUsed", title:"是否使用", align:"center", width: "100px"},

    						
                    		{field: "operatorId", title:"操作人员", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformMcpubCodeManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformMcpubCodeManageListView.get("columns");
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
                                detailstr+="<input id='id' name='编号' hidden='true' value='"+ColumnValue["id"]+"' style='...'/>";

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcodeType' align='right'>代码类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='codeType' name='代码类别' value='"+ColumnValue["codeType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcodeTypeDesc' align='right'>代码类别描述：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='codeTypeDesc' name='代码类别描述' value='"+ColumnValue["codeTypeDesc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcodeNo' align='right'>代码编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='codeNo' name='代码编号' value='"+ColumnValue["codeNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcodeName' align='right'>代码描述：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='codeName' name='代码描述' value='"+ColumnValue["codeName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisUsed' align='right'>是否使用：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='isUsed' name='是否使用' value='"+ColumnValue["isUsed"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loperatorId' align='right'>操作人员：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='operatorId' name='操作人员' value='"+ColumnValue["operatorId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=mcpubCode.updateMcpubCode&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformMcpubCodeManageListView);
        }
    });

    return PlatformMcpubCodeManageRouter;
});

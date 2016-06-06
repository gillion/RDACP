
/**
 * 三方存管数据
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
                    data:{id: $("#id").val(),dataDate: $("#dataDate").val(),accountName: $("#accountName").val(),accountNum: $("#accountNum").val(),securities: $("#securities").val(),cusManager: $("#cusManager").val(),remarks: $("#remarks").val()},
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
                    data:{id: $("#id").val(),dataDate: $("#dataDate").val(),accountName: $("#accountName").val(),accountNum: $("#accountNum").val(),securities: $("#securities").val(),cusManager: $("#cusManager").val(),remarks: $("#remarks").val()},
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
    
    var PlatformJxkhThreeDepositoryManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhThreeDepository_manage": "showPlatformJxkhThreeDepositoryManageList",  
            "basic_manage/platform_ckJxkhThreeDepository_manage": "showPlatformckJxkhThreeDepositoryManageList"
        },
        showPlatformckJxkhThreeDepositoryManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhThreeDepositoryManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhThreeDepositoryManageListView = new SimpleListView({
                id: "platform_jxkhThreeDepository_manage_list",
                title: "基础管理 > 三方存管数据",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("三方存管数据");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataDate' align='right'>日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountName' align='right'>姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountName' name='姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>帐户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='帐户' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsecurities' align='right'>证券公司：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='securities' name='证券公司' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusManager' align='right'>客户经理：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusManager' name='客户经理' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremarks' align='right'>备注：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remarks' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhThreeDepository.createJxkhThreeDepository&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhThreeDepositoryManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhThreeDepositoryManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhThreeDepositoryManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhThreeDepository.deleteJxkhThreeDepository&v=1.0&format=json",
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
                        detailstr+="<label id='ldataDate' align='right'>日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountName' align='right'>姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountName' name='姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>帐户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='帐户' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsecurities' align='right'>证券公司：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='securities' name='证券公司' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusManager' align='right'>客户经理：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusManager' name='客户经理' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremarks' align='right'>备注：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remarks' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhThreeDepository.selectJxkhThreeDepository&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhThreeDepository.selectJxkhThreeDepository&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },dataDate: { type: "string" },accountName: { type: "string" },accountNum: { type: "string" },securities: { type: "string" },cusManager: { type: "string" },remarks: { type: "string" }
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
                            result = platformJxkhThreeDepositoryManageListView.appendColValue(result);
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

    						
                    		{field: "dataDate", title:"日期", align:"center", width: "100px"},

    						
                    		{field: "accountName", title:"姓名", align:"center", width: "100px"},

    						
                    		{field: "accountNum", title:"帐户", align:"center", width: "100px"},

    						
                    		{field: "securities", title:"证券公司", align:"center", width: "100px"},

    						
                    		{field: "cusManager", title:"客户经理", align:"center", width: "100px"},

    						
                    		{field: "remarks", title:"备注", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhThreeDepositoryManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhThreeDepositoryManageListView.get("columns");
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
                                detailstr+="<label id='ldataDate' align='right'>日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dataDate' name='日期' value='"+ColumnValue["dataDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountName' align='right'>姓名：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountName' name='姓名' value='"+ColumnValue["accountName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountNum' align='right'>帐户：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountNum' name='帐户' value='"+ColumnValue["accountNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsecurities' align='right'>证券公司：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='securities' name='证券公司' value='"+ColumnValue["securities"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcusManager' align='right'>客户经理：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cusManager' name='客户经理' value='"+ColumnValue["cusManager"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremarks' align='right'>备注：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='remarks' name='备注' value='"+ColumnValue["remarks"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhThreeDepository.updateJxkhThreeDepository&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhThreeDepositoryManageListView);
        }
    });

    return PlatformJxkhThreeDepositoryManageRouter;
});

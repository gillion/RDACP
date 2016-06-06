
/**
 * 设备清单
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
                    data:{id: $("#id").val(),billNo: $("#billNo").val(),type: $("#type").val(),productName: $("#productName").val(),productSn: $("#productSn").val(),buyDate: $("#buyDate").val(),naming: $("#naming").val(),productCode: $("#productCode").val(),setup: $("#setup").val(),price: $("#price").val(),vnd: $("#vnd").val(),prepairDate: $("#prepairDate").val(),status: $("#status").val()},
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
                    data:{id: $("#id").val(),billNo: $("#billNo").val(),type: $("#type").val(),productName: $("#productName").val(),productSn: $("#productSn").val(),buyDate: $("#buyDate").val(),naming: $("#naming").val(),productCode: $("#productCode").val(),setup: $("#setup").val(),price: $("#price").val(),vnd: $("#vnd").val(),prepairDate: $("#prepairDate").val(),status: $("#status").val()},
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
    
    var PlatformProductListManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_ProductList_manage": "showPlatformProductListManageList",  
            "basic_manage/platform_ckProductList_manage": "showPlatformckProductListManageList"
        },
        showPlatformckProductListManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformProductListManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformProductListManageListView = new SimpleListView({
                id: "platform_productList_manage_list",
                title: "基础管理 > 设备清单",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("设备清单");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbillNo' align='right'>单据编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billNo' name='单据编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltype' align='right'>类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='type' name='类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductName' align='right'>名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productName' name='名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductSn' align='right'>序列号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productSn' name='序列号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbuyDate' align='right'>购买日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='buyDate' name='购买日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnaming' align='right'>品牌：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='naming' name='品牌' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductCode' align='right'>型号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productCode' name='型号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsetup' align='right'>配置：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='setup' name='配置' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprice' align='right'>单价：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='price' name='单价' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvnd' align='right'>供应商：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='vnd' name='供应商' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprepairDate' align='right'>保修期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prepairDate' name='保修期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='status' name='状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productList.createProductList&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformProductListManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformProductListManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformProductListManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productList.deleteProductList&v=1.0&format=json",
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
                        detailstr+="<label id='lbillNo' align='right'>单据编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billNo' name='单据编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltype' align='right'>类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='type' name='类型' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductName' align='right'>名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productName' name='名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductSn' align='right'>序列号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productSn' name='序列号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbuyDate' align='right'>购买日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='buyDate' name='购买日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnaming' align='right'>品牌：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='naming' name='品牌' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductCode' align='right'>型号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productCode' name='型号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsetup' align='right'>配置：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='setup' name='配置' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprice' align='right'>单价：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='price' name='单价' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvnd' align='right'>供应商：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='vnd' name='供应商' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprepairDate' align='right'>保修期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prepairDate' name='保修期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='status' name='状态' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productList.selectProductList&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productList.selectProductList&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },billNo: { type: "string" },type: { type: "string" },productName: { type: "string" },productSn: { type: "string" },buyDate: { type: "string" },naming: { type: "string" },productCode: { type: "string" },setup: { type: "string" },price: { type: "string" },vnd: { type: "string" },prepairDate: { type: "string" },status: { type: "string" }
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
                            result = platformProductListManageListView.appendColValue(result);
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

    						
                    		{field: "billNo", title:"单据编号", align:"center", width: "100px"},

    						
                    		{field: "type", title:"类型", align:"center", width: "100px"},

    						
                    		{field: "productName", title:"名称", align:"center", width: "100px"},

    						
                    		{field: "productSn", title:"序列号", align:"center", width: "100px"},

    						
                    		{field: "buyDate", title:"购买日期", align:"center", width: "100px"},

    						
                    		{field: "naming", title:"品牌", align:"center", width: "100px"},

    						
                    		{field: "productCode", title:"型号", align:"center", width: "100px"},

    						
                    		{field: "setup", title:"配置", align:"center", width: "100px"},

    						
                    		{field: "price", title:"单价", align:"center", width: "100px"},

    						
                    		{field: "vnd", title:"供应商", align:"center", width: "100px"},

    						
                    		{field: "prepairDate", title:"保修期", align:"center", width: "100px"},

    						
                    		{field: "status", title:"状态", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformProductListManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformProductListManageListView.get("columns");
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
                                detailstr+="<label id='lbillNo' align='right'>单据编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='billNo' name='单据编号' value='"+ColumnValue["billNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltype' align='right'>类型：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='type' name='类型' value='"+ColumnValue["type"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lproductName' align='right'>名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='productName' name='名称' value='"+ColumnValue["productName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lproductSn' align='right'>序列号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='productSn' name='序列号' value='"+ColumnValue["productSn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbuyDate' align='right'>购买日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='buyDate' name='购买日期' value='"+ColumnValue["buyDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lnaming' align='right'>品牌：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='naming' name='品牌' value='"+ColumnValue["naming"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lproductCode' align='right'>型号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='productCode' name='型号' value='"+ColumnValue["productCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsetup' align='right'>配置：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='setup' name='配置' value='"+ColumnValue["setup"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprice' align='right'>单价：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='price' name='单价' value='"+ColumnValue["price"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvnd' align='right'>供应商：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='vnd' name='供应商' value='"+ColumnValue["vnd"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprepairDate' align='right'>保修期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='prepairDate' name='保修期' value='"+ColumnValue["prepairDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lstatus' align='right'>状态：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='status' name='状态' value='"+ColumnValue["status"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productList.updateProductList&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformProductListManageListView);
        }
    });

    return PlatformProductListManageRouter;
});

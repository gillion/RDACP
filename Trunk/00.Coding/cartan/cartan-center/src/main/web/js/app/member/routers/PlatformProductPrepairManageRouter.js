
/**
 * 设备维护记录
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
                    data:{id: $("#id").val(),billNo: $("#billNo").val(),productName: $("#productName").val(),productSn: $("#productSn").val(),userDept: $("#userDept").val(),sendDate: $("#sendDate").val(),prepairMan: $("#prepairMan").val(),prepairDate: $("#prepairDate").val(),prepairStatus: $("#prepairStatus").val(),remark1: $("#remark1").val(),remark2: $("#remark2").val()},
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
                    data:{id: $("#id").val(),billNo: $("#billNo").val(),productName: $("#productName").val(),productSn: $("#productSn").val(),userDept: $("#userDept").val(),sendDate: $("#sendDate").val(),prepairMan: $("#prepairMan").val(),prepairDate: $("#prepairDate").val(),prepairStatus: $("#prepairStatus").val(),remark1: $("#remark1").val(),remark2: $("#remark2").val()},
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
    
    var PlatformProductPrepairManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_ProductPrepair_manage": "showPlatformProductPrepairManageList",  
            "basic_manage/platform_ckProductPrepair_manage": "showPlatformckProductPrepairManageList"
        },
        showPlatformckProductPrepairManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformProductPrepairManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformProductPrepairManageListView = new SimpleListView({
                id: "platform_productPrepair_manage_list",
                title: "基础管理 > 设备维护记录",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("设备维护记录");
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
                        detailstr+="<label id='lproductName' align='right'>设备名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productName' name='设备名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductSn' align='right'>序列号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productSn' name='序列号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luserDept' align='right'>使用部门：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='userDept' name='使用部门' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsendDate' align='right'>报修日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sendDate' name='报修日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprepairMan' align='right'>维修工程师：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prepairMan' name='维修工程师' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprepairDate' align='right'>完工日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prepairDate' name='完工日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprepairStatus' align='right'>维护状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prepairStatus' name='维护状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark1' align='right'>故障描述：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remark1' name='故障描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark2' align='right'>处理过程描述：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remark2' name='处理过程描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productPrepair.createProductPrepair&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformProductPrepairManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformProductPrepairManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformProductPrepairManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productPrepair.deleteProductPrepair&v=1.0&format=json",
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
                        detailstr+="<label id='lproductName' align='right'>设备名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productName' name='设备名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproductSn' align='right'>序列号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='productSn' name='序列号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='luserDept' align='right'>使用部门：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='userDept' name='使用部门' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsendDate' align='right'>报修日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sendDate' name='报修日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprepairMan' align='right'>维修工程师：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prepairMan' name='维修工程师' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprepairDate' align='right'>完工日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prepairDate' name='完工日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprepairStatus' align='right'>维护状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='prepairStatus' name='维护状态' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark1' align='right'>故障描述：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remark1' name='故障描述' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark2' align='right'>处理过程描述：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remark2' name='处理过程描述' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productPrepair.selectProductPrepair&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productPrepair.selectProductPrepair&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },billNo: { type: "string" },productName: { type: "string" },productSn: { type: "string" },userDept: { type: "string" },sendDate: { type: "string" },prepairMan: { type: "string" },prepairDate: { type: "string" },prepairStatus: { type: "string" },remark1: { type: "string" },remark2: { type: "string" }
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
                            result = platformProductPrepairManageListView.appendColValue(result);
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

    						
                    		{field: "productName", title:"设备名称", align:"center", width: "100px"},

    						
                    		{field: "productSn", title:"序列号", align:"center", width: "100px"},

    						
                    		{field: "userDept", title:"使用部门", align:"center", width: "100px"},

    						
                    		{field: "sendDate", title:"报修日期", align:"center", width: "100px"},

    						
                    		{field: "prepairMan", title:"维修工程师", align:"center", width: "100px"},

    						
                    		{field: "prepairDate", title:"完工日期", align:"center", width: "100px"},

    						
                    		{field: "prepairStatus", title:"维护状态", align:"center", width: "100px"},

    						
                    		{field: "remark1", title:"故障描述", align:"center", width: "100px"},

    						
                    		{field: "remark2", title:"处理过程描述", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformProductPrepairManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformProductPrepairManageListView.get("columns");
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
                                detailstr+="<label id='lproductName' align='right'>设备名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='productName' name='设备名称' value='"+ColumnValue["productName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lproductSn' align='right'>序列号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='productSn' name='序列号' value='"+ColumnValue["productSn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luserDept' align='right'>使用部门：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='userDept' name='使用部门' value='"+ColumnValue["userDept"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsendDate' align='right'>报修日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='sendDate' name='报修日期' value='"+ColumnValue["sendDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprepairMan' align='right'>维修工程师：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='prepairMan' name='维修工程师' value='"+ColumnValue["prepairMan"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprepairDate' align='right'>完工日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='prepairDate' name='完工日期' value='"+ColumnValue["prepairDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprepairStatus' align='right'>维护状态：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='prepairStatus' name='维护状态' value='"+ColumnValue["prepairStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark1' align='right'>故障描述：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='remark1' name='故障描述' value='"+ColumnValue["remark1"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark2' align='right'>处理过程描述：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='remark2' name='处理过程描述' value='"+ColumnValue["remark2"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productPrepair.updateProductPrepair&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformProductPrepairManageListView);
        }
    });

    return PlatformProductPrepairManageRouter;
});

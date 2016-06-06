
/**
 * 对公中间业务数据
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
                    data:{id: $("#id").val(),accountCode: $("#accountCode").val(),accountName: $("#accountName").val(),incomeMoney: $("#incomeMoney").val(),dataDate: $("#dataDate").val(),temp1: $("#temp1").val(),temp2: $("#temp2").val(),temp3: $("#temp3").val(),accountNum: $("#accountNum").val(),sremark: $("#sremark").val()},
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
                    data:{id: $("#id").val(),accountCode: $("#accountCode").val(),accountName: $("#accountName").val(),incomeMoney: $("#incomeMoney").val(),dataDate: $("#dataDate").val(),temp1: $("#temp1").val(),temp2: $("#temp2").val(),temp3: $("#temp3").val(),accountNum: $("#accountNum").val(),sremark: $("#sremark").val()},
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
    
    var PlatformJxkhMidDataManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhMidData_manage": "showPlatformJxkhMidDataManageList",  
            "basic_manage/platform_ckJxkhMidData_manage": "showPlatformckJxkhMidDataManageList"
        },
        showPlatformckJxkhMidDataManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhMidDataManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhMidDataManageListView = new SimpleListView({
                id: "platform_jxkhMidData_manage_list",
                title: "基础管理 > 对公中间业务数据",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("对公中间业务数据");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountCode' align='right'>客户编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountCode' name='客户编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountName' align='right'>户名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountName' name='户名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincomeMoney' align='right'>手续费收入：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incomeMoney' name='手续费收入' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataDate' align='right'>日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp1' align='right'>字段一：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp1' name='字段一' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp2' align='right'>字段二：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp2' name='字段二' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp3' align='right'>字段三：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp3' name='字段三' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>账号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='账号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sremark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMidData.createJxkhMidData&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhMidDataManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhMidDataManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhMidDataManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMidData.deleteJxkhMidData&v=1.0&format=json",
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
                        detailstr+="<label id='laccountCode' align='right'>客户编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountCode' name='客户编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountName' align='right'>户名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountName' name='户名' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincomeMoney' align='right'>手续费收入：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incomeMoney' name='手续费收入' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataDate' align='right'>日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp1' align='right'>字段一：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp1' name='字段一' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp2' align='right'>字段二：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp2' name='字段二' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp3' align='right'>字段三：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp3' name='字段三' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>账号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='账号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sremark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMidData.selectJxkhMidData&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMidData.selectJxkhMidData&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },accountCode: { type: "string" },accountName: { type: "string" },incomeMoney: { type: "string" },dataDate: { type: "string" },temp1: { type: "string" },temp2: { type: "string" },temp3: { type: "string" },accountNum: { type: "string" },sremark: { type: "string" }
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
                            result = platformJxkhMidDataManageListView.appendColValue(result);
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

    						
                    		{field: "accountCode", title:"客户编号", align:"center", width: "100px"},

    						
                    		{field: "accountName", title:"户名", align:"center", width: "100px"},

    						
                    		{field: "incomeMoney", title:"手续费收入", align:"center", width: "100px"},

    						
                    		{field: "dataDate", title:"日期", align:"center", width: "100px"},

    						
                    		{field: "temp1", title:"字段一", align:"center", width: "100px"},

    						
                    		{field: "temp2", title:"字段二", align:"center", width: "100px"},

    						
                    		{field: "temp3", title:"字段三", align:"center", width: "100px"},

    						
                    		{field: "accountNum", title:"账号", align:"center", width: "100px"},

    						
                    		{field: "sremark", title:"备注", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhMidDataManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhMidDataManageListView.get("columns");
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
                                detailstr+="<label id='laccountCode' align='right'>客户编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountCode' name='客户编号' value='"+ColumnValue["accountCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountName' align='right'>户名：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountName' name='户名' value='"+ColumnValue["accountName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lincomeMoney' align='right'>手续费收入：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='incomeMoney' name='手续费收入' value='"+ColumnValue["incomeMoney"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldataDate' align='right'>日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dataDate' name='日期' value='"+ColumnValue["dataDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltemp1' align='right'>字段一：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='temp1' name='字段一' value='"+ColumnValue["temp1"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltemp2' align='right'>字段二：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='temp2' name='字段二' value='"+ColumnValue["temp2"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltemp3' align='right'>字段三：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='temp3' name='字段三' value='"+ColumnValue["temp3"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountNum' align='right'>账号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountNum' name='账号' value='"+ColumnValue["accountNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='sremark' name='备注' value='"+ColumnValue["sremark"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMidData.updateJxkhMidData&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhMidDataManageListView);
        }
    });

    return PlatformJxkhMidDataManageRouter;
});

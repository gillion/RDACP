
/**
 * 信用卡数据
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
                    data:{id: $("#id").val(),turnNo: $("#turnNo").val(),userLoginid: $("#userLoginid").val(),userName: $("#userName").val(),cusName: $("#cusName").val(),cardType: $("#cardType").val(),cardId: $("#cardId").val(),idCardNum: $("#idCardNum").val(),isnewcus: $("#isnewcus").val(),insertDate: $("#insertDate").val()},
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
                    data:{id: $("#id").val(),turnNo: $("#turnNo").val(),userLoginid: $("#userLoginid").val(),userName: $("#userName").val(),cusName: $("#cusName").val(),cardType: $("#cardType").val(),cardId: $("#cardId").val(),idCardNum: $("#idCardNum").val(),isnewcus: $("#isnewcus").val(),insertDate: $("#insertDate").val()},
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
    
    var PlatformJxkhCreditCardManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhCreditCard_manage": "showPlatformJxkhCreditCardManageList",  
            "basic_manage/platform_ckJxkhCreditCard_manage": "showPlatformckJxkhCreditCardManageList"
        },
        showPlatformckJxkhCreditCardManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhCreditCardManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhCreditCardManageListView = new SimpleListView({
                id: "platform_jxkhCreditCard_manage_list",
                title: "基础管理 > 信用卡数据",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("信用卡数据");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lturnNo' align='right'>交换号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='turnNo' name='交换号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luserLoginid' align='right'>员工号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='userLoginid' name='员工号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luserName' align='right'>员工姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='userName' name='员工姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusName' align='right'>客户姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusName' name='客户姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardType' align='right'>卡种：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardType' name='卡种' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardId' align='right'>主/附卡：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardId' name='主/附卡' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidCardNum' align='right'>客户证件号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='idCardNum' name='客户证件号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisnewcus' align='right'>是否新户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='isnewcus' name='是否新户' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linsertDate' align='right'>加载日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='insertDate' name='加载日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCreditCard.createJxkhCreditCard&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhCreditCardManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhCreditCardManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhCreditCardManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCreditCard.deleteJxkhCreditCard&v=1.0&format=json",
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
                        detailstr+="<label id='lturnNo' align='right'>交换号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='turnNo' name='交换号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='luserLoginid' align='right'>员工号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='userLoginid' name='员工号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='luserName' align='right'>员工姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='userName' name='员工姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusName' align='right'>客户姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusName' name='客户姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardType' align='right'>卡种：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardType' name='卡种' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardId' align='right'>主/附卡：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardId' name='主/附卡' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidCardNum' align='right'>客户证件号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='idCardNum' name='客户证件号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisnewcus' align='right'>是否新户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='isnewcus' name='是否新户' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='linsertDate' align='right'>加载日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='insertDate' name='加载日期' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCreditCard.selectJxkhCreditCard&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCreditCard.selectJxkhCreditCard&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },turnNo: { type: "string" },userLoginid: { type: "string" },userName: { type: "string" },cusName: { type: "string" },cardType: { type: "string" },cardId: { type: "string" },idCardNum: { type: "string" },isnewcus: { type: "string" },insertDate: { type: "string" }
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
                            result = platformJxkhCreditCardManageListView.appendColValue(result);
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

    						
                    		{field: "turnNo", title:"交换号", align:"center", width: "100px"},

    						
                    		{field: "userLoginid", title:"员工号", align:"center", width: "100px"},

    						
                    		{field: "userName", title:"员工姓名", align:"center", width: "100px"},

    						
                    		{field: "cusName", title:"客户姓名", align:"center", width: "100px"},

    						
                    		{field: "cardType", title:"卡种", align:"center", width: "100px"},

    						
                    		{field: "cardId", title:"主/附卡", align:"center", width: "100px"},

    						
                    		{field: "idCardNum", title:"客户证件号", align:"center", width: "100px"},

    						
                    		{field: "isnewcus", title:"是否新户", align:"center", width: "100px"},

    						
                    		{field: "insertDate", title:"加载日期", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhCreditCardManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhCreditCardManageListView.get("columns");
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
                                detailstr+="<label id='lturnNo' align='right'>交换号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='turnNo' name='交换号' value='"+ColumnValue["turnNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luserLoginid' align='right'>员工号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='userLoginid' name='员工号' value='"+ColumnValue["userLoginid"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luserName' align='right'>员工姓名：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='userName' name='员工姓名' value='"+ColumnValue["userName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcusName' align='right'>客户姓名：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cusName' name='客户姓名' value='"+ColumnValue["cusName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcardType' align='right'>卡种：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cardType' name='卡种' value='"+ColumnValue["cardType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcardId' align='right'>主/附卡：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cardId' name='主/附卡' value='"+ColumnValue["cardId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lidCardNum' align='right'>客户证件号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='idCardNum' name='客户证件号' value='"+ColumnValue["idCardNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisnewcus' align='right'>是否新户：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='isnewcus' name='是否新户' value='"+ColumnValue["isnewcus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linsertDate' align='right'>加载日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='insertDate' name='加载日期' value='"+ColumnValue["insertDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCreditCard.updateJxkhCreditCard&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhCreditCardManageListView);
        }
    });

    return PlatformJxkhCreditCardManageRouter;
});

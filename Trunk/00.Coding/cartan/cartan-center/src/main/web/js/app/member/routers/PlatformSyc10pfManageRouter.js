
/**
 * 保函子户登记
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
                    data:{id: $("#id").val(),dellBank: $("#dellBank").val(),parentBank: $("#parentBank").val(),moneyCode: $("#moneyCode").val(),proposerAcc: $("#proposerAcc").val(),accountType: $("#accountType").val(),bailAccount: $("#bailAccount").val(),bailBalance: $("#bailBalance").val(),statusSign: $("#statusSign").val(),sign: $("#sign").val(),loanSn: $("#loanSn").val(),remark: $("#remark").val(),insertDate: $("#insertDate").val()},
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
                    data:{id: $("#id").val(),dellBank: $("#dellBank").val(),parentBank: $("#parentBank").val(),moneyCode: $("#moneyCode").val(),proposerAcc: $("#proposerAcc").val(),accountType: $("#accountType").val(),bailAccount: $("#bailAccount").val(),bailBalance: $("#bailBalance").val(),statusSign: $("#statusSign").val(),sign: $("#sign").val(),loanSn: $("#loanSn").val(),remark: $("#remark").val(),insertDate: $("#insertDate").val()},
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
    
    var PlatformSyc10pfManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_Syc10pf_manage": "showPlatformSyc10pfManageList",  
            "basic_manage/platform_ckSyc10pf_manage": "showPlatformckSyc10pfManageList"
        },
        showPlatformckSyc10pfManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformSyc10pfManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformSyc10pfManageListView = new SimpleListView({
                id: "platform_syc10pf_manage_list",
                title: "基础管理 > 保函子户登记",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("保函子户登记");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldellBank' align='right'>发生网点：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dellBank' name='发生网点' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparentBank' align='right'>归属网点：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='parentBank' name='归属网点' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmoneyCode' align='right'>币种：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='moneyCode' name='币种' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproposerAcc' align='right'>申请人帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='proposerAcc' name='申请人帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountType' align='right'>帐户性质：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountType' name='帐户性质' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailAccount' align='right'>保证金帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailAccount' name='保证金帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailBalance' align='right'>余额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailBalance' name='余额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstatusSign' align='right'>状态标志：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='statusSign' name='状态标志' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsign' align='right'>标志位：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sign' name='标志位' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lloanSn' align='right'>信贷流水号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='loanSn' name='信贷流水号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>说明：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remark' name='说明' style='...'/>";
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
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=syc10pf.createSyc10pf&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformSyc10pfManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformSyc10pfManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformSyc10pfManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=syc10pf.deleteSyc10pf&v=1.0&format=json",
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
                        detailstr+="<label id='ldellBank' align='right'>发生网点：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dellBank' name='发生网点' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparentBank' align='right'>归属网点：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='parentBank' name='归属网点' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmoneyCode' align='right'>币种：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='moneyCode' name='币种' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lproposerAcc' align='right'>申请人帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='proposerAcc' name='申请人帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountType' align='right'>帐户性质：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountType' name='帐户性质' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailAccount' align='right'>保证金帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailAccount' name='保证金帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailBalance' align='right'>余额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailBalance' name='余额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstatusSign' align='right'>状态标志：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='statusSign' name='状态标志' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsign' align='right'>标志位：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sign' name='标志位' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lloanSn' align='right'>信贷流水号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='loanSn' name='信贷流水号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>说明：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='remark' name='说明' style='...'/>";
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
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=syc10pf.selectSyc10pf&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=syc10pf.selectSyc10pf&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },dellBank: { type: "string" },parentBank: { type: "string" },moneyCode: { type: "string" },proposerAcc: { type: "string" },accountType: { type: "string" },bailAccount: { type: "string" },bailBalance: { type: "string" },statusSign: { type: "string" },sign: { type: "string" },loanSn: { type: "string" },remark: { type: "string" },insertDate: { type: "string" }
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
                            result = platformSyc10pfManageListView.appendColValue(result);
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

    						
                    		{field: "dellBank", title:"发生网点", align:"center", width: "100px"},

    						
                    		{field: "parentBank", title:"归属网点", align:"center", width: "100px"},

    						
                    		{field: "moneyCode", title:"币种", align:"center", width: "100px"},

    						
                    		{field: "proposerAcc", title:"申请人帐号", align:"center", width: "100px"},

    						
                    		{field: "accountType", title:"帐户性质", align:"center", width: "100px"},

    						
                    		{field: "bailAccount", title:"保证金帐号", align:"center", width: "100px"},

    						
                    		{field: "bailBalance", title:"余额", align:"center", width: "100px"},

    						
                    		{field: "statusSign", title:"状态标志", align:"center", width: "100px"},

    						
                    		{field: "sign", title:"标志位", align:"center", width: "100px"},

    						
                    		{field: "loanSn", title:"信贷流水号", align:"center", width: "100px"},

    						
                    		{field: "remark", title:"说明", align:"center", width: "100px"},

    						
                    		{field: "insertDate", title:"加载日期", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformSyc10pfManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformSyc10pfManageListView.get("columns");
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
                                detailstr+="<label id='ldellBank' align='right'>发生网点：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dellBank' name='发生网点' value='"+ColumnValue["dellBank"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparentBank' align='right'>归属网点：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='parentBank' name='归属网点' value='"+ColumnValue["parentBank"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmoneyCode' align='right'>币种：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='moneyCode' name='币种' value='"+ColumnValue["moneyCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lproposerAcc' align='right'>申请人帐号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='proposerAcc' name='申请人帐号' value='"+ColumnValue["proposerAcc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountType' align='right'>帐户性质：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountType' name='帐户性质' value='"+ColumnValue["accountType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbailAccount' align='right'>保证金帐号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='bailAccount' name='保证金帐号' value='"+ColumnValue["bailAccount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbailBalance' align='right'>余额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='bailBalance' name='余额' value='"+ColumnValue["bailBalance"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lstatusSign' align='right'>状态标志：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='statusSign' name='状态标志' value='"+ColumnValue["statusSign"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsign' align='right'>标志位：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='sign' name='标志位' value='"+ColumnValue["sign"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lloanSn' align='right'>信贷流水号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='loanSn' name='信贷流水号' value='"+ColumnValue["loanSn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark' align='right'>说明：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='remark' name='说明' value='"+ColumnValue["remark"]+"' style='...'/>";
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
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=syc10pf.updateSyc10pf&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformSyc10pfManageListView);
        }
    });

    return PlatformSyc10pfManageRouter;
});

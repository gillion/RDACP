
/**
 * 对公子户分户帐
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
                    data:{id: $("#id").val(),dataDate: $("#dataDate").val(),accountNum: $("#accountNum").val(),secondaryCode: $("#secondaryCode").val(),accountId: $("#accountId").val(),accountStatus: $("#accountStatus").val(),subbranchNum: $("#subbranchNum").val(),balanceChangeRange: $("#balanceChangeRange").val(),balanceSide: $("#balanceSide").val(),realtimeBalance: $("#realtimeBalance").val(),tomorrowBalance: $("#tomorrowBalance").val(),overdraftLimt: $("#overdraftLimt").val(),interestCalCate: $("#interestCalCate").val(),interestCalMethod: $("#interestCalMethod").val(),sign: $("#sign").val(),frozenAmount: $("#frozenAmount").val(),valueDate: $("#valueDate").val(),endDate: $("#endDate").val(),natrualAggregate: $("#natrualAggregate").val(),natrualIntRate: $("#natrualIntRate").val(),intInOutSign: $("#intInOutSign").val(),specialSign: $("#specialSign").val(),isBasicAccount: $("#isBasicAccount").val(),isCheckAccount: $("#isCheckAccount").val(),insertDate: $("#insertDate").val()},
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
                    data:{id: $("#id").val(),dataDate: $("#dataDate").val(),accountNum: $("#accountNum").val(),secondaryCode: $("#secondaryCode").val(),accountId: $("#accountId").val(),accountStatus: $("#accountStatus").val(),subbranchNum: $("#subbranchNum").val(),balanceChangeRange: $("#balanceChangeRange").val(),balanceSide: $("#balanceSide").val(),realtimeBalance: $("#realtimeBalance").val(),tomorrowBalance: $("#tomorrowBalance").val(),overdraftLimt: $("#overdraftLimt").val(),interestCalCate: $("#interestCalCate").val(),interestCalMethod: $("#interestCalMethod").val(),sign: $("#sign").val(),frozenAmount: $("#frozenAmount").val(),valueDate: $("#valueDate").val(),endDate: $("#endDate").val(),natrualAggregate: $("#natrualAggregate").val(),natrualIntRate: $("#natrualIntRate").val(),intInOutSign: $("#intInOutSign").val(),specialSign: $("#specialSign").val(),isBasicAccount: $("#isBasicAccount").val(),isCheckAccount: $("#isCheckAccount").val(),insertDate: $("#insertDate").val()},
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
    
    var PlatformSub70pfManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_Sub70pf_manage": "showPlatformSub70pfManageList",  
            "basic_manage/platform_ckSub70pf_manage": "showPlatformckSub70pfManageList"
        },
        showPlatformckSub70pfManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformSub70pfManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformSub70pfManageListView = new SimpleListView({
                id: "platform_sub70pf_manage_list",
                title: "基础管理 > 对公子户分户帐",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("对公子户分户帐");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataDate' align='right'>数据日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='数据日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>主帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='主帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsecondaryCode' align='right'>分帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='secondaryCode' name='分帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountId' align='right'>帐户标识号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountId' name='帐户标识号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountStatus' align='right'>帐户状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountStatus' name='帐户状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubbranchNum' align='right'>开户网点：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranchNum' name='开户网点' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceChangeRange' align='right'>余额变化范围：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceChangeRange' name='余额变化范围' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceSide' align='right'>余额方向：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceSide' name='余额方向' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrealtimeBalance' align='right'>实时余额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='realtimeBalance' name='实时余额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltomorrowBalance' align='right'>昨日余额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='tomorrowBalance' name='昨日余额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loverdraftLimt' align='right'>透支限额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='overdraftLimt' name='透支限额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linterestCalCate' align='right'>计息种类：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='interestCalCate' name='计息种类' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linterestCalMethod' align='right'>计息方式：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='interestCalMethod' name='计息方式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsign' align='right'>标志位：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sign' name='标志位' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfrozenAmount' align='right'>冻结金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='frozenAmount' name='冻结金额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalueDate' align='right'>起息日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='valueDate' name='起息日' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lendDate' align='right'>到期日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='endDate' name='到期日' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnatrualAggregate' align='right'>正常积数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='natrualAggregate' name='正常积数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnatrualIntRate' align='right'>正常利率：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='natrualIntRate' name='正常利率' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lintInOutSign' align='right'>利息入帐扣帐标识：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='intInOutSign' name='利息入帐扣帐标识' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lspecialSign' align='right'>特殊标志：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='specialSign' name='特殊标志' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisBasicAccount' align='right'>是否为基本户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='isBasicAccount' name='是否为基本户' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCheckAccount' align='right'>是否为支票户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='isCheckAccount' name='是否为支票户' style='...'/>";
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
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=sub70pf.createSub70pf&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformSub70pfManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformSub70pfManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformSub70pfManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=sub70pf.deleteSub70pf&v=1.0&format=json",
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
                        detailstr+="<label id='ldataDate' align='right'>数据日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='数据日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>主帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='主帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsecondaryCode' align='right'>分帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='secondaryCode' name='分帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountId' align='right'>帐户标识号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountId' name='帐户标识号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountStatus' align='right'>帐户状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountStatus' name='帐户状态' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubbranchNum' align='right'>开户网点：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranchNum' name='开户网点' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceChangeRange' align='right'>余额变化范围：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceChangeRange' name='余额变化范围' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceSide' align='right'>余额方向：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceSide' name='余额方向' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrealtimeBalance' align='right'>实时余额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='realtimeBalance' name='实时余额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltomorrowBalance' align='right'>昨日余额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='tomorrowBalance' name='昨日余额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='loverdraftLimt' align='right'>透支限额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='overdraftLimt' name='透支限额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='linterestCalCate' align='right'>计息种类：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='interestCalCate' name='计息种类' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='linterestCalMethod' align='right'>计息方式：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='interestCalMethod' name='计息方式' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsign' align='right'>标志位：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sign' name='标志位' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfrozenAmount' align='right'>冻结金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='frozenAmount' name='冻结金额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalueDate' align='right'>起息日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='valueDate' name='起息日' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lendDate' align='right'>到期日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='endDate' name='到期日' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnatrualAggregate' align='right'>正常积数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='natrualAggregate' name='正常积数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnatrualIntRate' align='right'>正常利率：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='natrualIntRate' name='正常利率' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lintInOutSign' align='right'>利息入帐扣帐标识：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='intInOutSign' name='利息入帐扣帐标识' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lspecialSign' align='right'>特殊标志：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='specialSign' name='特殊标志' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisBasicAccount' align='right'>是否为基本户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='isBasicAccount' name='是否为基本户' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCheckAccount' align='right'>是否为支票户：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='isCheckAccount' name='是否为支票户' style='...'/>";
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
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=sub70pf.selectSub70pf&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=sub70pf.selectSub70pf&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },dataDate: { type: "string" },accountNum: { type: "string" },secondaryCode: { type: "string" },accountId: { type: "string" },accountStatus: { type: "string" },subbranchNum: { type: "string" },balanceChangeRange: { type: "string" },balanceSide: { type: "string" },realtimeBalance: { type: "string" },tomorrowBalance: { type: "string" },overdraftLimt: { type: "string" },interestCalCate: { type: "string" },interestCalMethod: { type: "string" },sign: { type: "string" },frozenAmount: { type: "string" },valueDate: { type: "string" },endDate: { type: "string" },natrualAggregate: { type: "string" },natrualIntRate: { type: "string" },intInOutSign: { type: "string" },specialSign: { type: "string" },isBasicAccount: { type: "string" },isCheckAccount: { type: "string" },insertDate: { type: "string" }
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
                            result = platformSub70pfManageListView.appendColValue(result);
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

    						
                    		{field: "dataDate", title:"数据日期", align:"center", width: "100px"},

    						
                    		{field: "accountNum", title:"主帐号", align:"center", width: "100px"},

    						
                    		{field: "secondaryCode", title:"分帐号", align:"center", width: "100px"},

    						
                    		{field: "accountId", title:"帐户标识号", align:"center", width: "100px"},

    						
                    		{field: "accountStatus", title:"帐户状态", align:"center", width: "100px"},

    						
                    		{field: "subbranchNum", title:"开户网点", align:"center", width: "100px"},

    						
                    		{field: "balanceChangeRange", title:"余额变化范围", align:"center", width: "100px"},

    						
                    		{field: "balanceSide", title:"余额方向", align:"center", width: "100px"},

    						
                    		{field: "realtimeBalance", title:"实时余额", align:"center", width: "100px"},

    						
                    		{field: "tomorrowBalance", title:"昨日余额", align:"center", width: "100px"},

    						
                    		{field: "overdraftLimt", title:"透支限额", align:"center", width: "100px"},

    						
                    		{field: "interestCalCate", title:"计息种类", align:"center", width: "100px"},

    						
                    		{field: "interestCalMethod", title:"计息方式", align:"center", width: "100px"},

    						
                    		{field: "sign", title:"标志位", align:"center", width: "100px"},

    						
                    		{field: "frozenAmount", title:"冻结金额", align:"center", width: "100px"},

    						
                    		{field: "valueDate", title:"起息日", align:"center", width: "100px"},

    						
                    		{field: "endDate", title:"到期日", align:"center", width: "100px"},

    						
                    		{field: "natrualAggregate", title:"正常积数", align:"center", width: "100px"},

    						
                    		{field: "natrualIntRate", title:"正常利率", align:"center", width: "100px"},

    						
                    		{field: "intInOutSign", title:"利息入帐扣帐标识", align:"center", width: "100px"},

    						
                    		{field: "specialSign", title:"特殊标志", align:"center", width: "100px"},

    						
                    		{field: "isBasicAccount", title:"是否为基本户", align:"center", width: "100px"},

    						
                    		{field: "isCheckAccount", title:"是否为支票户", align:"center", width: "100px"},

    						
                    		{field: "insertDate", title:"加载日期", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformSub70pfManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformSub70pfManageListView.get("columns");
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
                                detailstr+="<label id='ldataDate' align='right'>数据日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dataDate' name='数据日期' value='"+ColumnValue["dataDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountNum' align='right'>主帐号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountNum' name='主帐号' value='"+ColumnValue["accountNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsecondaryCode' align='right'>分帐号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='secondaryCode' name='分帐号' value='"+ColumnValue["secondaryCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountId' align='right'>帐户标识号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountId' name='帐户标识号' value='"+ColumnValue["accountId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountStatus' align='right'>帐户状态：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountStatus' name='帐户状态' value='"+ColumnValue["accountStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubbranchNum' align='right'>开户网点：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='subbranchNum' name='开户网点' value='"+ColumnValue["subbranchNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceChangeRange' align='right'>余额变化范围：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceChangeRange' name='余额变化范围' value='"+ColumnValue["balanceChangeRange"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceSide' align='right'>余额方向：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceSide' name='余额方向' value='"+ColumnValue["balanceSide"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrealtimeBalance' align='right'>实时余额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='realtimeBalance' name='实时余额' value='"+ColumnValue["realtimeBalance"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltomorrowBalance' align='right'>昨日余额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='tomorrowBalance' name='昨日余额' value='"+ColumnValue["tomorrowBalance"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loverdraftLimt' align='right'>透支限额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='overdraftLimt' name='透支限额' value='"+ColumnValue["overdraftLimt"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linterestCalCate' align='right'>计息种类：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='interestCalCate' name='计息种类' value='"+ColumnValue["interestCalCate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linterestCalMethod' align='right'>计息方式：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='interestCalMethod' name='计息方式' value='"+ColumnValue["interestCalMethod"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsign' align='right'>标志位：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='sign' name='标志位' value='"+ColumnValue["sign"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfrozenAmount' align='right'>冻结金额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='frozenAmount' name='冻结金额' value='"+ColumnValue["frozenAmount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvalueDate' align='right'>起息日：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='valueDate' name='起息日' value='"+ColumnValue["valueDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lendDate' align='right'>到期日：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='endDate' name='到期日' value='"+ColumnValue["endDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lnatrualAggregate' align='right'>正常积数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='natrualAggregate' name='正常积数' value='"+ColumnValue["natrualAggregate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lnatrualIntRate' align='right'>正常利率：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='natrualIntRate' name='正常利率' value='"+ColumnValue["natrualIntRate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lintInOutSign' align='right'>利息入帐扣帐标识：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='intInOutSign' name='利息入帐扣帐标识' value='"+ColumnValue["intInOutSign"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lspecialSign' align='right'>特殊标志：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='specialSign' name='特殊标志' value='"+ColumnValue["specialSign"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisBasicAccount' align='right'>是否为基本户：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='isBasicAccount' name='是否为基本户' value='"+ColumnValue["isBasicAccount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisCheckAccount' align='right'>是否为支票户：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='isCheckAccount' name='是否为支票户' value='"+ColumnValue["isCheckAccount"]+"' style='...'/>";
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
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=sub70pf.updateSub70pf&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformSub70pfManageListView);
        }
    });

    return PlatformSub70pfManageRouter;
});

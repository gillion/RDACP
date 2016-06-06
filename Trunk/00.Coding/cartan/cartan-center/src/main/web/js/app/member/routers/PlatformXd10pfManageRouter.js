
/**
 * 银行承兑汇票登记
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
                    data:{id: $("#id").val(),dataDate: $("#dataDate").val(),subbranchNum: $("#subbranchNum").val(),moneyCode: $("#moneyCode").val(),loanSn: $("#loanSn").val(),dealSubbranch: $("#dealSubbranch").val(),billCode: $("#billCode").val(),balance: $("#balance").val(),billPswd: $("#billPswd").val(),accountNum: $("#accountNum").val(),clientName: $("#clientName").val(),paySubbranchName: $("#paySubbranchName").val(),billStatus: $("#billStatus").val(),frontSn: $("#frontSn").val(),bailBalance: $("#bailBalance").val(),bailType: $("#bailType").val(),bailTerm: $("#bailTerm").val(),bailEndDate: $("#bailEndDate").val(),payeeAccount: $("#payeeAccount").val(),payeeName: $("#payeeName").val(),payeeBankNum: $("#payeeBankNum").val(),payeeBankName: $("#payeeBankName").val(),billEndDate: $("#billEndDate").val(),acceptAgreement: $("#acceptAgreement").val(),awardAgreement: $("#awardAgreement").val(),outTableAcc: $("#outTableAcc").val(),openAccBank: $("#openAccBank").val(),acceptDate: $("#acceptDate").val(),insertDate: $("#insertDate").val()},
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
                    data:{id: $("#id").val(),dataDate: $("#dataDate").val(),subbranchNum: $("#subbranchNum").val(),moneyCode: $("#moneyCode").val(),loanSn: $("#loanSn").val(),dealSubbranch: $("#dealSubbranch").val(),billCode: $("#billCode").val(),balance: $("#balance").val(),billPswd: $("#billPswd").val(),accountNum: $("#accountNum").val(),clientName: $("#clientName").val(),paySubbranchName: $("#paySubbranchName").val(),billStatus: $("#billStatus").val(),frontSn: $("#frontSn").val(),bailBalance: $("#bailBalance").val(),bailType: $("#bailType").val(),bailTerm: $("#bailTerm").val(),bailEndDate: $("#bailEndDate").val(),payeeAccount: $("#payeeAccount").val(),payeeName: $("#payeeName").val(),payeeBankNum: $("#payeeBankNum").val(),payeeBankName: $("#payeeBankName").val(),billEndDate: $("#billEndDate").val(),acceptAgreement: $("#acceptAgreement").val(),awardAgreement: $("#awardAgreement").val(),outTableAcc: $("#outTableAcc").val(),openAccBank: $("#openAccBank").val(),acceptDate: $("#acceptDate").val(),insertDate: $("#insertDate").val()},
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
    
    var PlatformXd10pfManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_Xd10pf_manage": "showPlatformXd10pfManageList",  
            "basic_manage/platform_ckXd10pf_manage": "showPlatformckXd10pfManageList"
        },
        showPlatformckXd10pfManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformXd10pfManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformXd10pfManageListView = new SimpleListView({
                id: "platform_xd10pf_manage_list",
                title: "基础管理 > 银行承兑汇票登记",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("银行承兑汇票登记");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataDate' align='right'>登记日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='登记日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubbranchNum' align='right'>网点：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranchNum' name='网点' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmoneyCode' align='right'>币种：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='moneyCode' name='币种' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lloanSn' align='right'>信贷流水号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='loanSn' name='信贷流水号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldealSubbranch' align='right'>签发行：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dealSubbranch' name='签发行' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbillCode' align='right'>汇票号码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billCode' name='汇票号码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalance' align='right'>出票金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balance' name='出票金额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbillPswd' align='right'>汇票密押：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billPswd' name='汇票密押' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>出票人帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='出票人帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientName' align='right'>出票人名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientName' name='出票人名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpaySubbranchName' align='right'>付款行全称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='paySubbranchName' name='付款行全称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbillStatus' align='right'>汇票状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billStatus' name='汇票状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfrontSn' align='right'>前台流水号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='frontSn' name='前台流水号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailBalance' align='right'>保证金金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailBalance' name='保证金金额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailType' align='right'>保证金性质：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailType' name='保证金性质' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailTerm' align='right'>保证期限：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailTerm' name='保证期限' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailEndDate' align='right'>保证金到期日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailEndDate' name='保证金到期日' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpayeeAccount' align='right'>收款人帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='payeeAccount' name='收款人帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpayeeName' align='right'>票面收款人（收款人名称）：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='payeeName' name='票面收款人（收款人名称）' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpayeeBankNum' align='right'>收款人开户行：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='payeeBankNum' name='收款人开户行' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpayeeBankName' align='right'>收款人开户行名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='payeeBankName' name='收款人开户行名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbillEndDate' align='right'>汇票到期日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billEndDate' name='汇票到期日' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lacceptAgreement' align='right'>承兑协议编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='acceptAgreement' name='承兑协议编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lawardAgreement' align='right'>综合授信协议：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='awardAgreement' name='综合授信协议' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loutTableAcc' align='right'>表外承诺帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='outTableAcc' name='表外承诺帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lopenAccBank' align='right'>开户所号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='openAccBank' name='开户所号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lacceptDate' align='right'>承兑日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='acceptDate' name='承兑日期' style='...'/>";
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
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=xd10pf.createXd10pf&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformXd10pfManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformXd10pfManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformXd10pfManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=xd10pf.deleteXd10pf&v=1.0&format=json",
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
                        detailstr+="<label id='ldataDate' align='right'>登记日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='登记日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubbranchNum' align='right'>网点：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranchNum' name='网点' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmoneyCode' align='right'>币种：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='moneyCode' name='币种' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lloanSn' align='right'>信贷流水号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='loanSn' name='信贷流水号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldealSubbranch' align='right'>签发行：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dealSubbranch' name='签发行' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbillCode' align='right'>汇票号码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billCode' name='汇票号码' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalance' align='right'>出票金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balance' name='出票金额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbillPswd' align='right'>汇票密押：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billPswd' name='汇票密押' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laccountNum' align='right'>出票人帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='accountNum' name='出票人帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclientName' align='right'>出票人名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='clientName' name='出票人名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpaySubbranchName' align='right'>付款行全称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='paySubbranchName' name='付款行全称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbillStatus' align='right'>汇票状态：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billStatus' name='汇票状态' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfrontSn' align='right'>前台流水号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='frontSn' name='前台流水号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailBalance' align='right'>保证金金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailBalance' name='保证金金额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailType' align='right'>保证金性质：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailType' name='保证金性质' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailTerm' align='right'>保证期限：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailTerm' name='保证期限' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbailEndDate' align='right'>保证金到期日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bailEndDate' name='保证金到期日' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpayeeAccount' align='right'>收款人帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='payeeAccount' name='收款人帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpayeeName' align='right'>票面收款人（收款人名称）：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='payeeName' name='票面收款人（收款人名称）' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpayeeBankNum' align='right'>收款人开户行：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='payeeBankNum' name='收款人开户行' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpayeeBankName' align='right'>收款人开户行名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='payeeBankName' name='收款人开户行名' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbillEndDate' align='right'>汇票到期日：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='billEndDate' name='汇票到期日' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lacceptAgreement' align='right'>承兑协议编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='acceptAgreement' name='承兑协议编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lawardAgreement' align='right'>综合授信协议：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='awardAgreement' name='综合授信协议' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='loutTableAcc' align='right'>表外承诺帐号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='outTableAcc' name='表外承诺帐号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lopenAccBank' align='right'>开户所号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='openAccBank' name='开户所号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lacceptDate' align='right'>承兑日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='acceptDate' name='承兑日期' style='...'/>";
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
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=xd10pf.selectXd10pf&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=xd10pf.selectXd10pf&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },dataDate: { type: "string" },subbranchNum: { type: "string" },moneyCode: { type: "string" },loanSn: { type: "string" },dealSubbranch: { type: "string" },billCode: { type: "string" },balance: { type: "string" },billPswd: { type: "string" },accountNum: { type: "string" },clientName: { type: "string" },paySubbranchName: { type: "string" },billStatus: { type: "string" },frontSn: { type: "string" },bailBalance: { type: "string" },bailType: { type: "string" },bailTerm: { type: "string" },bailEndDate: { type: "string" },payeeAccount: { type: "string" },payeeName: { type: "string" },payeeBankNum: { type: "string" },payeeBankName: { type: "string" },billEndDate: { type: "string" },acceptAgreement: { type: "string" },awardAgreement: { type: "string" },outTableAcc: { type: "string" },openAccBank: { type: "string" },acceptDate: { type: "string" },insertDate: { type: "string" }
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
                            result = platformXd10pfManageListView.appendColValue(result);
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

    						
                    		{field: "dataDate", title:"登记日期", align:"center", width: "100px"},

    						
                    		{field: "subbranchNum", title:"网点", align:"center", width: "100px"},

    						
                    		{field: "moneyCode", title:"币种", align:"center", width: "100px"},

    						
                    		{field: "loanSn", title:"信贷流水号", align:"center", width: "100px"},

    						
                    		{field: "dealSubbranch", title:"签发行", align:"center", width: "100px"},

    						
                    		{field: "billCode", title:"汇票号码", align:"center", width: "100px"},

    						
                    		{field: "balance", title:"出票金额", align:"center", width: "100px"},

    						
                    		{field: "billPswd", title:"汇票密押", align:"center", width: "100px"},

    						
                    		{field: "accountNum", title:"出票人帐号", align:"center", width: "100px"},

    						
                    		{field: "clientName", title:"出票人名称", align:"center", width: "100px"},

    						
                    		{field: "paySubbranchName", title:"付款行全称", align:"center", width: "100px"},

    						
                    		{field: "billStatus", title:"汇票状态", align:"center", width: "100px"},

    						
                    		{field: "frontSn", title:"前台流水号", align:"center", width: "100px"},

    						
                    		{field: "bailBalance", title:"保证金金额", align:"center", width: "100px"},

    						
                    		{field: "bailType", title:"保证金性质", align:"center", width: "100px"},

    						
                    		{field: "bailTerm", title:"保证期限", align:"center", width: "100px"},

    						
                    		{field: "bailEndDate", title:"保证金到期日", align:"center", width: "100px"},

    						
                    		{field: "payeeAccount", title:"收款人帐号", align:"center", width: "100px"},

    						
                    		{field: "payeeName", title:"票面收款人（收款人名称）", align:"center", width: "100px"},

    						
                    		{field: "payeeBankNum", title:"收款人开户行", align:"center", width: "100px"},

    						
                    		{field: "payeeBankName", title:"收款人开户行名", align:"center", width: "100px"},

    						
                    		{field: "billEndDate", title:"汇票到期日", align:"center", width: "100px"},

    						
                    		{field: "acceptAgreement", title:"承兑协议编号", align:"center", width: "100px"},

    						
                    		{field: "awardAgreement", title:"综合授信协议", align:"center", width: "100px"},

    						
                    		{field: "outTableAcc", title:"表外承诺帐号", align:"center", width: "100px"},

    						
                    		{field: "openAccBank", title:"开户所号", align:"center", width: "100px"},

    						
                    		{field: "acceptDate", title:"承兑日期", align:"center", width: "100px"},

    						
                    		{field: "insertDate", title:"加载日期", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformXd10pfManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformXd10pfManageListView.get("columns");
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
                                detailstr+="<label id='ldataDate' align='right'>登记日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dataDate' name='登记日期' value='"+ColumnValue["dataDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubbranchNum' align='right'>网点：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='subbranchNum' name='网点' value='"+ColumnValue["subbranchNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmoneyCode' align='right'>币种：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='moneyCode' name='币种' value='"+ColumnValue["moneyCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lloanSn' align='right'>信贷流水号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='loanSn' name='信贷流水号' value='"+ColumnValue["loanSn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldealSubbranch' align='right'>签发行：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dealSubbranch' name='签发行' value='"+ColumnValue["dealSubbranch"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbillCode' align='right'>汇票号码：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='billCode' name='汇票号码' value='"+ColumnValue["billCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalance' align='right'>出票金额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balance' name='出票金额' value='"+ColumnValue["balance"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbillPswd' align='right'>汇票密押：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='billPswd' name='汇票密押' value='"+ColumnValue["billPswd"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laccountNum' align='right'>出票人帐号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='accountNum' name='出票人帐号' value='"+ColumnValue["accountNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclientName' align='right'>出票人名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='clientName' name='出票人名称' value='"+ColumnValue["clientName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpaySubbranchName' align='right'>付款行全称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='paySubbranchName' name='付款行全称' value='"+ColumnValue["paySubbranchName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbillStatus' align='right'>汇票状态：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='billStatus' name='汇票状态' value='"+ColumnValue["billStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfrontSn' align='right'>前台流水号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='frontSn' name='前台流水号' value='"+ColumnValue["frontSn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbailBalance' align='right'>保证金金额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='bailBalance' name='保证金金额' value='"+ColumnValue["bailBalance"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbailType' align='right'>保证金性质：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='bailType' name='保证金性质' value='"+ColumnValue["bailType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbailTerm' align='right'>保证期限：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='bailTerm' name='保证期限' value='"+ColumnValue["bailTerm"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbailEndDate' align='right'>保证金到期日：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='bailEndDate' name='保证金到期日' value='"+ColumnValue["bailEndDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpayeeAccount' align='right'>收款人帐号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='payeeAccount' name='收款人帐号' value='"+ColumnValue["payeeAccount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpayeeName' align='right'>票面收款人（收款人名称）：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='payeeName' name='票面收款人（收款人名称）' value='"+ColumnValue["payeeName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpayeeBankNum' align='right'>收款人开户行：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='payeeBankNum' name='收款人开户行' value='"+ColumnValue["payeeBankNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpayeeBankName' align='right'>收款人开户行名：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='payeeBankName' name='收款人开户行名' value='"+ColumnValue["payeeBankName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbillEndDate' align='right'>汇票到期日：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='billEndDate' name='汇票到期日' value='"+ColumnValue["billEndDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lacceptAgreement' align='right'>承兑协议编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='acceptAgreement' name='承兑协议编号' value='"+ColumnValue["acceptAgreement"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lawardAgreement' align='right'>综合授信协议：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='awardAgreement' name='综合授信协议' value='"+ColumnValue["awardAgreement"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loutTableAcc' align='right'>表外承诺帐号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='outTableAcc' name='表外承诺帐号' value='"+ColumnValue["outTableAcc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lopenAccBank' align='right'>开户所号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='openAccBank' name='开户所号' value='"+ColumnValue["openAccBank"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lacceptDate' align='right'>承兑日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='acceptDate' name='承兑日期' value='"+ColumnValue["acceptDate"]+"' style='...'/>";
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
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=xd10pf.updateXd10pf&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformXd10pfManageListView);
        }
    });

    return PlatformXd10pfManageRouter;
});

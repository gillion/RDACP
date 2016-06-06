/**
 * 选择窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "utils/Log",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log,AjaxEngine){	
    var PlatformXd10pfSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=xd10pf.selectXd10pf&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].name;
                            }
		                }
		            }
		        );
		        return resstr;
                }
		    },
    		showGridData: function(gridObject){
                var detailgrid= gridObject.kendoGrid({
                    dataSource: {
                        serverPaging: false,
                        transport: {
                            read: {
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=xd10pf.selectXd10pf&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
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
                                return result;
                            },
                            //记录条数
                            total: function(response) {
                                var result = response["total"] || response["resultJson"].length;
                                return result;
                            }
                        }
                    },
                    selectable: true,
                    pageable: {                     //是否支持分页，如果支持，其相关的配置信息
                        pageSizes: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
                        info: true,
                        messages: {
                            empty: "查询无记录！",
                            itemsPerPage: "行每页",
                            display: "共 {2} 条记录"
                        }
                    },
                    columns: [
    	                  {field: "id", title:"编号", hidden:"true", align:"center", width: "100px"}
    	                  ,{field: "dataDate", title:"登记日期", align:"center", width: "100px"}
    	                  ,{field: "subbranchNum", title:"网点", align:"center", width: "100px"}
    	                  ,{field: "moneyCode", title:"币种", align:"center", width: "100px"}
    	                  ,{field: "loanSn", title:"信贷流水号", align:"center", width: "100px"}
    	                  ,{field: "dealSubbranch", title:"签发行", align:"center", width: "100px"}
    	                  ,{field: "billCode", title:"汇票号码", align:"center", width: "100px"}
    	                  ,{field: "balance", title:"出票金额", align:"center", width: "100px"}
    	                  ,{field: "billPswd", title:"汇票密押", align:"center", width: "100px"}
    	                  ,{field: "accountNum", title:"出票人帐号", align:"center", width: "100px"}
    	                  ,{field: "clientName", title:"出票人名称", align:"center", width: "100px"}
    	                  ,{field: "paySubbranchName", title:"付款行全称", align:"center", width: "100px"}
    	                  ,{field: "billStatus", title:"汇票状态", align:"center", width: "100px"}
    	                  ,{field: "frontSn", title:"前台流水号", align:"center", width: "100px"}
    	                  ,{field: "bailBalance", title:"保证金金额", align:"center", width: "100px"}
    	                  ,{field: "bailType", title:"保证金性质", align:"center", width: "100px"}
    	                  ,{field: "bailTerm", title:"保证期限", align:"center", width: "100px"}
    	                  ,{field: "bailEndDate", title:"保证金到期日", align:"center", width: "100px"}
    	                  ,{field: "payeeAccount", title:"收款人帐号", align:"center", width: "100px"}
    	                  ,{field: "payeeName", title:"票面收款人（收款人名称）", align:"center", width: "100px"}
    	                  ,{field: "payeeBankNum", title:"收款人开户行", align:"center", width: "100px"}
    	                  ,{field: "payeeBankName", title:"收款人开户行名", align:"center", width: "100px"}
    	                  ,{field: "billEndDate", title:"汇票到期日", align:"center", width: "100px"}
    	                  ,{field: "acceptAgreement", title:"承兑协议编号", align:"center", width: "100px"}
    	                  ,{field: "awardAgreement", title:"综合授信协议", align:"center", width: "100px"}
    	                  ,{field: "outTableAcc", title:"表外承诺帐号", align:"center", width: "100px"}
    	                  ,{field: "openAccBank", title:"开户所号", align:"center", width: "100px"}
    	                  ,{field: "acceptDate", title:"承兑日期", align:"center", width: "100px"}
    	                  ,{field: "insertDate", title:"加载日期", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformXd10pfSelDialog;
})
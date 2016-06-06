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
    var PlatformSub70pfSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=sub70pf.selectSub70pf&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=sub70pf.selectSub70pf&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
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
    	                  ,{field: "dataDate", title:"数据日期", align:"center", width: "100px"}
    	                  ,{field: "accountNum", title:"主帐号", align:"center", width: "100px"}
    	                  ,{field: "secondaryCode", title:"分帐号", align:"center", width: "100px"}
    	                  ,{field: "accountId", title:"帐户标识号", align:"center", width: "100px"}
    	                  ,{field: "accountStatus", title:"帐户状态", align:"center", width: "100px"}
    	                  ,{field: "subbranchNum", title:"开户网点", align:"center", width: "100px"}
    	                  ,{field: "balanceChangeRange", title:"余额变化范围", align:"center", width: "100px"}
    	                  ,{field: "balanceSide", title:"余额方向", align:"center", width: "100px"}
    	                  ,{field: "realtimeBalance", title:"实时余额", align:"center", width: "100px"}
    	                  ,{field: "tomorrowBalance", title:"昨日余额", align:"center", width: "100px"}
    	                  ,{field: "overdraftLimt", title:"透支限额", align:"center", width: "100px"}
    	                  ,{field: "interestCalCate", title:"计息种类", align:"center", width: "100px"}
    	                  ,{field: "interestCalMethod", title:"计息方式", align:"center", width: "100px"}
    	                  ,{field: "sign", title:"标志位", align:"center", width: "100px"}
    	                  ,{field: "frozenAmount", title:"冻结金额", align:"center", width: "100px"}
    	                  ,{field: "valueDate", title:"起息日", align:"center", width: "100px"}
    	                  ,{field: "endDate", title:"到期日", align:"center", width: "100px"}
    	                  ,{field: "natrualAggregate", title:"正常积数", align:"center", width: "100px"}
    	                  ,{field: "natrualIntRate", title:"正常利率", align:"center", width: "100px"}
    	                  ,{field: "intInOutSign", title:"利息入帐扣帐标识", align:"center", width: "100px"}
    	                  ,{field: "specialSign", title:"特殊标志", align:"center", width: "100px"}
    	                  ,{field: "isBasicAccount", title:"是否为基本户", align:"center", width: "100px"}
    	                  ,{field: "isCheckAccount", title:"是否为支票户", align:"center", width: "100px"}
    	                  ,{field: "insertDate", title:"加载日期", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformSub70pfSelDialog;
})
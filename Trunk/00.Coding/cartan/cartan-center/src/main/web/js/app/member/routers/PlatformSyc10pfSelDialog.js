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
    var PlatformSyc10pfSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=syc10pf.selectSyc10pf&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=syc10pf.selectSyc10pf&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
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
    	                  ,{field: "dellBank", title:"发生网点", align:"center", width: "100px"}
    	                  ,{field: "parentBank", title:"归属网点", align:"center", width: "100px"}
    	                  ,{field: "moneyCode", title:"币种", align:"center", width: "100px"}
    	                  ,{field: "proposerAcc", title:"申请人帐号", align:"center", width: "100px"}
    	                  ,{field: "accountType", title:"帐户性质", align:"center", width: "100px"}
    	                  ,{field: "bailAccount", title:"保证金帐号", align:"center", width: "100px"}
    	                  ,{field: "bailBalance", title:"余额", align:"center", width: "100px"}
    	                  ,{field: "statusSign", title:"状态标志", align:"center", width: "100px"}
    	                  ,{field: "sign", title:"标志位", align:"center", width: "100px"}
    	                  ,{field: "loanSn", title:"信贷流水号", align:"center", width: "100px"}
    	                  ,{field: "remark", title:"说明", align:"center", width: "100px"}
    	                  ,{field: "insertDate", title:"加载日期", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformSyc10pfSelDialog;
})
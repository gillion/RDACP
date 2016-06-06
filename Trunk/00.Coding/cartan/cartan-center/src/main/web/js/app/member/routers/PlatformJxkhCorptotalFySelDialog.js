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
    var PlatformJxkhCorptotalFySelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalFy.selectJxkhCorptotalFy&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalFy.selectJxkhCorptotalFy&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },syear: { type: "string" },smonth: { type: "string" },dept: { type: "string" },cusManagerid: { type: "string" },cusManagername: { type: "string" },balanceavg: { type: "string" },changMoney: { type: "string" },changeMemo: { type: "string" },changeAfterAvg: { type: "string" },creditMoney: { type: "string" },creditDeposit: { type: "string" },discountDeposit: { type: "string" },depositTask: { type: "string" },depositHistory: { type: "string" },deposit: { type: "string" },incremental: { type: "string" },cost: { type: "string" },creditChangMoney: { type: "string" },creditChangMoneyReq: { type: "string" },creditAfterMoney: { type: "string" },creditChangDeposit: { type: "string" },creditAfterDeposit: { type: "string" }
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
    	                  ,{field: "syear", title:"年", align:"center", width: "100px"}
    	                  ,{field: "smonth", title:"月", align:"center", width: "100px"}
    	                  ,{field: "dept", title:"部门", align:"center", width: "100px"}
    	                  ,{field: "cusManagerid", title:"客户经理ID", align:"center", width: "100px"}
    	                  ,{field: "cusManagername", title:"客户经理名称", align:"center", width: "100px"}
    	                  ,{field: "balanceavg", title:"存款日均", align:"center", width: "100px"}
    	                  ,{field: "changMoney", title:"调整数", align:"center", width: "100px"}
    	                  ,{field: "changeMemo", title:"调整备注详情", align:"center", width: "100px"}
    	                  ,{field: "changeAfterAvg", title:"调整后日均", align:"center", width: "100px"}
    	                  ,{field: "creditMoney", title:"授信金额", align:"center", width: "100px"}
    	                  ,{field: "creditDeposit", title:"授信户存款", align:"center", width: "100px"}
    	                  ,{field: "discountDeposit", title:"折后存款", align:"center", width: "100px"}
    	                  ,{field: "depositTask", title:"存款任务", align:"center", width: "100px"}
    	                  ,{field: "depositHistory", title:"历史存量", align:"center", width: "100px"}
    	                  ,{field: "deposit", title:"存量", align:"center", width: "100px"}
    	                  ,{field: "incremental", title:"增量", align:"center", width: "100px"}
    	                  ,{field: "cost", title:"费用", align:"center", width: "100px"}
    	                  ,{field: "creditChangMoney", title:"授信调整金额", align:"center", width: "100px"}
    	                  ,{field: "creditChangMoneyReq", title:"授信调整数", align:"center", width: "100px"}
    	                  ,{field: "creditAfterMoney", title:"授信调整后金额", align:"center", width: "100px"}
    	                  ,{field: "creditChangDeposit", title:"授信户存款调整金额", align:"center", width: "100px"}
    	                  ,{field: "creditAfterDeposit", title:"授信户存款调整金额", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformJxkhCorptotalFySelDialog;
})
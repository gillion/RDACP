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
    var PlatformJxkhCorptotalJxSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalJx.selectJxkhCorptotalJx&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalJx.selectJxkhCorptotalJx&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },syear: { type: "string" },smonth: { type: "string" },stype: { type: "string" },dept: { type: "string" },cusManagerid: { type: "string" },cusManagername: { type: "string" },groupLevel: { type: "string" },incomeDate: { type: "string" },blanceavgBase: { type: "string" },blanceavgBaseChg: { type: "string" },blanceavgBaseFina: { type: "string" },balanceavgYear: { type: "string" },lcMoney: { type: "string" },addMoneyChg: { type: "string" },conMoneyChg: { type: "string" },balanceavgRmb: { type: "string" },balanceavgWb: { type: "string" },balanceavgWbChg: { type: "string" },balanceavgWbFina: { type: "string" },balanceavgAll: { type: "string" },baseResult: { type: "string" },balanceavgIncremental: { type: "string" },monthTask: { type: "string" },incrementalTime: { type: "string" },lastResult: { type: "string" },groupStatus: { type: "string" }
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
    	                  ,{field: "stype", title:"类别", align:"center", width: "100px"}
    	                  ,{field: "dept", title:"部门", align:"center", width: "100px"}
    	                  ,{field: "cusManagerid", title:"客户经理ID", align:"center", width: "100px"}
    	                  ,{field: "cusManagername", title:"客户经理名称", align:"center", width: "100px"}
    	                  ,{field: "groupLevel", title:"级别", align:"center", width: "100px"}
    	                  ,{field: "incomeDate", title:"入职日期", align:"center", width: "100px"}
    	                  ,{field: "blanceavgBase", title:"基数", align:"center", width: "100px"}
    	                  ,{field: "blanceavgBaseChg", title:"基数调整数", align:"center", width: "100px"}
    	                  ,{field: "blanceavgBaseFina", title:"调整后基数", align:"center", width: "100px"}
    	                  ,{field: "balanceavgYear", title:"人民币年日均", align:"center", width: "100px"}
    	                  ,{field: "lcMoney", title:"理财", align:"center", width: "100px"}
    	                  ,{field: "addMoneyChg", title:"结算调整", align:"center", width: "100px"}
    	                  ,{field: "conMoneyChg", title:"关联调整", align:"center", width: "100px"}
    	                  ,{field: "balanceavgRmb", title:"调整后人民币年日均", align:"center", width: "100px"}
    	                  ,{field: "balanceavgWb", title:"外币年日均", align:"center", width: "100px"}
    	                  ,{field: "balanceavgWbChg", title:"外币调整数", align:"center", width: "100px"}
    	                  ,{field: "balanceavgWbFina", title:"调整后外币日均", align:"center", width: "100px"}
    	                  ,{field: "balanceavgAll", title:"本外币年日均", align:"center", width: "100px"}
    	                  ,{field: "baseResult", title:"存量得分", align:"center", width: "100px"}
    	                  ,{field: "balanceavgIncremental", title:"增量", align:"center", width: "100px"}
    	                  ,{field: "monthTask", title:"本月任务", align:"center", width: "100px"}
    	                  ,{field: "incrementalTime", title:"增量倍数", align:"center", width: "100px"}
    	                  ,{field: "lastResult", title:"最终得分", align:"center", width: "100px"}
    	                  ,{field: "groupStatus", title:"转正标识", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformJxkhCorptotalJxSelDialog;
})
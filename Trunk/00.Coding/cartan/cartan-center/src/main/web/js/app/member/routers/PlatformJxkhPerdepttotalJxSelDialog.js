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
    var PlatformJxkhPerdepttotalJxSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhPerdepttotalJx.selectJxkhPerdepttotalJx&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhPerdepttotalJx.selectJxkhPerdepttotalJx&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },syear: { type: "string" },smonth: { type: "string" },senddate: { type: "string" },stype: { type: "string" },dept: { type: "string" },incomeDate: { type: "string" },blanceavgBase: { type: "string" },balanceavgAll: { type: "string" },balanceavgIncremental: { type: "string" },monthTask: { type: "string" },incrementalTime: { type: "string" },lastResult: { type: "string" }
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
    	                  ,{field: "senddate", title:"统计截止日期", align:"center", width: "100px"}
    	                  ,{field: "stype", title:"类别", align:"center", width: "100px"}
    	                  ,{field: "dept", title:"部门", align:"center", width: "100px"}
    	                  ,{field: "incomeDate", title:"成立日期", align:"center", width: "100px"}
    	                  ,{field: "blanceavgBase", title:"基数", align:"center", width: "100px"}
    	                  ,{field: "balanceavgAll", title:"本外币年日均", align:"center", width: "100px"}
    	                  ,{field: "balanceavgIncremental", title:"增量", align:"center", width: "100px"}
    	                  ,{field: "monthTask", title:"指标", align:"center", width: "100px"}
    	                  ,{field: "incrementalTime", title:"完成比", align:"center", width: "100px"}
    	                  ,{field: "lastResult", title:"得分", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformJxkhPerdepttotalJxSelDialog;
})
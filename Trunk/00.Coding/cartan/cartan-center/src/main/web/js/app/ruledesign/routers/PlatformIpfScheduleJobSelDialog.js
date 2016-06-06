








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
    var PlatformIpfScheduleJobSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfScheduleJob.selectIpfScheduleJob&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfScheduleJob;
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
                                url: "router?appKey=000001&method=ipfScheduleJob.selectIpfScheduleJob&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },jobName: { type: "string" },jobGroup: { type: "string" },jobStatus: { type: "string" },cronExpression: { type: "string" },jobDesc: { type: "string" },ruleNo: { type: "string" },jobService: { type: "string" },jobMethod: { type: "string" }
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
    	                  {field: "id", title:"主键", hidden:"true", align:"center", width: "100px"}
    	                  ,{field: "jobName", title:"任务名称", align:"center", width: "100px"}
    	                  ,{field: "jobGroup", title:"任务分组", align:"center", width: "100px"}
    	                  ,{field: "jobStatus", title:"任务状态", align:"center", width: "100px"}
    	                  ,{field: "cronExpression", title:"执行频率", align:"center", width: "100px"}
    	                  ,{field: "jobDesc", title:"任务描述", align:"center", width: "100px"}
    	                  ,{field: "ruleNo", title:"规则号", align:"center", width: "100px"}
    	                  ,{field: "jobService", title:"任务对象", align:"center", width: "100px"}
    	                  ,{field: "jobMethod", title:"任务方法", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfScheduleJobSelDialog;
})









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
    var PlatformIpfRuleFilterSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfRuleFilter.selectIpfRuleFilter&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfRuleFilter;
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
                                url: "router?appKey=000001&method=ipfRuleFilter.selectIpfRuleFilter&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },filterCode: { type: "string" },filterName: { type: "string" },filterDesc: { type: "string" },filterExpress: { type: "string" },isActive: { type: "string" },isSystemCreate: { type: "string" },ipfCcmBoId: { type: "string" },boName: { type: "string" }
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
    	                  ,{field: "filterCode", title:"筛选编号", align:"center", width: "100px"}
    	                  ,{field: "filterName", title:"筛选名称", align:"center", width: "100px"}
    	                  ,{field: "filterDesc", title:"描述", align:"center", width: "100px"}
    	                  ,{field: "filterExpress", title:"筛选条件表达式", align:"center", width: "100px"}
    	                  ,{field: "isActive", title:"有效", align:"center", width: "100px"}
    	                  ,{field: "isSystemCreate", title:"系统创建", align:"center", width: "100px"}
    	                  ,{field: "ipfCcmBoId", title:"业务对象ID", align:"center", width: "100px"}
    	                  ,{field: "boName", title:"业务对象名称", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfRuleFilterSelDialog;
})
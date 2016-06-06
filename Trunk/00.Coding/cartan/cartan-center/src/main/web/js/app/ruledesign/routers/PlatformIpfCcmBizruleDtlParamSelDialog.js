







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
    var PlatformIpfCcmBizruleDtlParamSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBizruleDtlParam.selectIpfCcmBizruleDtlParam&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBizruleDtlParam;
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
                                url: "router?appKey=000001&method=ipfCcmBizruleDtlParam.selectIpfCcmBizruleDtlParam&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmBizruleId: { type: "string" },ipfCcmStrategyId: { type: "string" },ipfCcmStrategyParamId: { type: "string" },paramName: { type: "string" },paramDes: { type: "string" },paramValue: { type: "string" },paramValueDes: { type: "string" }
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
    	                  ,{field: "ipfCcmBizruleId", title:"规则", align:"center", width: "100px"}
    	                  ,{field: "ipfCcmStrategyId", title:"策略ID", align:"center", width: "100px"}
    	                  ,{field: "ipfCcmStrategyParamId", title:"策略参数ID", align:"center", width: "100px"}
    	                  ,{field: "paramName", title:"参数名", align:"center", width: "100px"}
    	                  ,{field: "paramDes", title:"参数描述", align:"center", width: "100px"}
    	                  ,{field: "paramValue", title:"参数值", align:"center", width: "100px"}
    	                  ,{field: "paramValueDes", title:"参数值说明", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBizruleDtlParamSelDialog;
})
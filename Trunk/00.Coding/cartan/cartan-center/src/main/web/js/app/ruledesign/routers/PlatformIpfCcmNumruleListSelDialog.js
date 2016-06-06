








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
    var PlatformIpfCcmNumruleListSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmNumruleList.selectIpfCcmNumruleList&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmNumruleList;
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
                                url: "router?appKey=000001&method=ipfCcmNumruleList.selectIpfCcmNumruleList&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmNumruleId: { type: "string" },constExpression: { type: "string" },currentValue: { type: "string" },initialValue: { type: "string" },maxValue: { type: "string" },growth: { type: "string" },remark: { type: "string" },isActive: { type: "string" }
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
    	                  ,{field: "ipfCcmNumruleId", title:"单号生成规则", align:"center", width: "100px"}
    	                  ,{field: "constExpression", title:"规则内容", align:"center", width: "100px"}
    	                  ,{field: "currentValue", title:"当前值", align:"center", width: "100px"}
    	                  ,{field: "initialValue", title:"初始值", align:"center", width: "100px"}
    	                  ,{field: "maxValue", title:"最大值", align:"center", width: "100px"}
    	                  ,{field: "growth", title:"增长值", align:"center", width: "100px"}
    	                  ,{field: "remark", title:"备注", align:"center", width: "100px"}
    	                  ,{field: "isActive", title:"有效", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmNumruleListSelDialog;
})
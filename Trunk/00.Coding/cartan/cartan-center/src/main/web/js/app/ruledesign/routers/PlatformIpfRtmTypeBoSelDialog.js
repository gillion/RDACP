











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
    var PlatformIpfRtmTypeBoSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfRtmTypeBo.selectIpfRtmTypeBo&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfRtmTypeBo;
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
                                url: "router?appKey=000001&method=ipfRtmTypeBo.selectIpfRtmTypeBo&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfRtmTypeId: { type: "string" },ipfCcmBoId: { type: "string" },boName: { type: "string" },boDesc: { type: "string" },propertyName: { type: "string" },propertyUtility: { type: "string" },externalBoName: { type: "string" },externalMatchProperty: { type: "string" },externalResultProperty: { type: "string" },externalBoId: { type: "string" },triggerPropertyName: { type: "string" }
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
    	                  ,{field: "ipfRtmTypeId", title:"运行期配置类型", align:"center", width: "100px"}
    	                  ,{field: "ipfCcmBoId", title:"业务对象ID", align:"center", width: "100px"}
    	                  ,{field: "boName", title:"业务对象名称", align:"center", width: "100px"}
    	                  ,{field: "boDesc", title:"业务对象描述", align:"center", width: "100px"}
    	                  ,{field: "propertyName", title:"业务对象属性名称", align:"center", width: "100px"}
    	                  ,{field: "propertyUtility", title:"属性用途", align:"center", width: "100px"}
    	                  ,{field: "externalBoName", title:"外部业务对象名称", align:"center", width: "100px"}
    	                  ,{field: "externalMatchProperty", title:"查询匹配属性", align:"center", width: "100px"}
    	                  ,{field: "externalResultProperty", title:"结果属性", align:"center", width: "100px"}
    	                  ,{field: "externalBoId", title:"外部业务对象ID", align:"center", width: "100px"}
    	                  ,{field: "triggerPropertyName", title:"触发属性名", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfRtmTypeBoSelDialog;
})
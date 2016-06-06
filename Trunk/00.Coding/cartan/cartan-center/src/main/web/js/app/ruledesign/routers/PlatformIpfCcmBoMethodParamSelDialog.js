








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
    var PlatformIpfCcmBoMethodParamSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoMethodParam.selectIpfCcmBoMethodParam&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoMethodParam;
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
                                url: "router?appKey=000001&method=ipfCcmBoMethodParam.selectIpfCcmBoMethodParam&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmBoMethodId: { type: "string" },constantValue: { type: "string" },isCondition: { type: "string" },methodName: { type: "string" },paramName: { type: "string" },paramRef: { type: "string" },paramType: { type: "string" },boNameRef: { type: "string" }
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
    	                  ,{field: "ipfCcmBoMethodId", title:"方法", align:"center", width: "100px"}
    	                  ,{field: "constantValue", title:"常量值", align:"center", width: "100px"}
    	                  ,{field: "isCondition", title:"查询条件", align:"center", width: "100px"}
    	                  ,{field: "methodName", title:"方法名", align:"center", width: "100px"}
    	                  ,{field: "paramName", title:"参数名", align:"center", width: "100px"}
    	                  ,{field: "paramRef", title:"属性名", align:"center", width: "100px"}
    	                  ,{field: "paramType", title:"参数值来源类型", align:"center", width: "100px"}
    	                  ,{field: "boNameRef", title:"业务对象名", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoMethodParamSelDialog;
})
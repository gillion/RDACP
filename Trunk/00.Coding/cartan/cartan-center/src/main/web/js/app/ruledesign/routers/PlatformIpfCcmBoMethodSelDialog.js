

























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
    var PlatformIpfCcmBoMethodSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoMethod.selectIpfCcmBoMethod&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoMethod;
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
                                url: "router?appKey=000001&method=ipfCcmBoMethod.selectIpfCcmBoMethod&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmBoId: { type: "string" },boType: { type: "string" },boRefId: { type: "string" },icon: { type: "string" },remark: { type: "string" },methodDesc: { type: "string" },methodName: { type: "string" },methodType: { type: "string" },url: { type: "string" },isDefault: { type: "string" },isVisible: { type: "string" },refShlpName: { type: "string" },ruleNo: { type: "string" },jumpMethodId: { type: "string" },jumpMethodName: { type: "string" },jumpBoName: { type: "string" },width: { type: "string" },height: { type: "string" },groupName: { type: "string" },groupDesc: { type: "string" },isCache: { type: "string" },cacheType: { type: "string" },requestType: { type: "string" },jumpWindowTitle: { type: "string" },isRefreshParentBo: { type: "string" }
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
    	                  ,{field: "ipfCcmBoId", title:"业务对象", align:"center", width: "100px"}
    	                  ,{field: "boType", title:"对象类型", align:"center", width: "100px"}
    	                  ,{field: "boRefId", title:"业务对象引用ID", align:"center", width: "100px"}
    	                  ,{field: "icon", title:"图标", align:"center", width: "100px"}
    	                  ,{field: "remark", title:"备注", align:"center", width: "100px"}
    	                  ,{field: "methodDesc", title:"方法描述", align:"center", width: "100px"}
    	                  ,{field: "methodName", title:"方法名称", align:"center", width: "100px"}
    	                  ,{field: "methodType", title:"方法类型", align:"center", width: "100px"}
    	                  ,{field: "url", title:"调用的URL地址", align:"center", width: "100px"}
    	                  ,{field: "isDefault", title:"默认方法", align:"center", width: "100px"}
    	                  ,{field: "isVisible", title:"可见", align:"center", width: "100px"}
    	                  ,{field: "refShlpName", title:"搜索帮助名称", align:"center", width: "100px"}
    	                  ,{field: "ruleNo", title:"规则号", align:"center", width: "100px"}
    	                  ,{field: "jumpMethodId", title:"跳转方法ID", align:"center", width: "100px"}
    	                  ,{field: "jumpMethodName", title:"跳转方法名称", align:"center", width: "100px"}
    	                  ,{field: "jumpBoName", title:"跳转业务对象名", align:"center", width: "100px"}
    	                  ,{field: "width", title:"宽", align:"center", width: "100px"}
    	                  ,{field: "height", title:"高", align:"center", width: "100px"}
    	                  ,{field: "groupName", title:"校验分组名称", align:"center", width: "100px"}
    	                  ,{field: "groupDesc", title:"校验分组描述", align:"center", width: "100px"}
    	                  ,{field: "isCache", title:"是否缓存", align:"center", width: "100px"}
    	                  ,{field: "cacheType", title:"缓存类型", align:"center", width: "100px"}
    	                  ,{field: "requestType", title:"请求类型", align:"center", width: "100px"}
    	                  ,{field: "jumpWindowTitle", title:"弹窗标题", align:"center", width: "100px"}
    	                  ,{field: "isRefreshParentBo", title:"是否刷新主表", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoMethodSelDialog;
})
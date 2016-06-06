











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
    var PlatformIpfCcmBoFormToolbarSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoFormToolbar.selectIpfCcmBoFormToolbar&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoFormToolbar;
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
                                url: "router?appKey=000001&method=ipfCcmBoFormToolbar.selectIpfCcmBoFormToolbar&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcbBoId: { type: "string" },methodName: { type: "string" },methodDesc: { type: "string" },seqNo: { type: "string" },methodId: { type: "string" },buttonStyle: { type: "string" },disabledExpree: { type: "string" },isRefreshParentBo: { type: "string" },hotkeyType: { type: "string" },hotkeyValue: { type: "string" },isHide: { type: "string" }
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
    	                  ,{field: "ipfCcbBoId", title:"业务对象", align:"center", width: "100px"}
    	                  ,{field: "methodName", title:"调用方法名称", align:"center", width: "100px"}
    	                  ,{field: "methodDesc", title:"调用方法描述", align:"center", width: "100px"}
    	                  ,{field: "seqNo", title:"顺序号", align:"center", width: "100px"}
    	                  ,{field: "methodId", title:"方法ID", align:"center", width: "100px"}
    	                  ,{field: "buttonStyle", title:"按钮样式", align:"center", width: "100px"}
    	                  ,{field: "disabledExpree", title:"可编辑表达式", align:"center", width: "100px"}
    	                  ,{field: "isRefreshParentBo", title:"刷新主表", align:"center", width: "100px"}
    	                  ,{field: "hotkeyType", title:"热键类型", align:"center", width: "100px"}
    	                  ,{field: "hotkeyValue", title:"热键值", align:"center", width: "100px"}
    	                  ,{field: "isHide", title:"隐藏", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoFormToolbarSelDialog;
})
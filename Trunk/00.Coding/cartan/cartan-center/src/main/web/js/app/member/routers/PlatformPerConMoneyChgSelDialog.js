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
    var PlatformPerConMoneyChgSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyChg.selectPerConMoneyChg&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyChg.selectPerConMoneyChg&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },reqNo: { type: "string" },reqType: { type: "string" },conType: { type: "string" },cusCode: { type: "string" },cusName: { type: "string" },dataDate: { type: "string" },prvStatus: { type: "string" },reqUser: { type: "string" },reqDate: { type: "string" },prvUser: { type: "string" },prvDate: { type: "string" },remark: { type: "string" }
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
    	                  ,{field: "reqNo", title:"申请单号", align:"center", width: "100px"}
    	                  ,{field: "reqType", title:"申请类型", align:"center", width: "100px"}
    	                  ,{field: "conType", title:"关联类型", align:"center", width: "100px"}
    	                  ,{field: "cusCode", title:"客户代码", align:"center", width: "100px"}
    	                  ,{field: "cusName", title:"客户名称", align:"center", width: "100px"}
    	                  ,{field: "dataDate", title:"生效日期", align:"center", width: "100px"}
    	                  ,{field: "prvStatus", title:"状态", align:"center", width: "100px"}
    	                  ,{field: "reqUser", title:"申请人", align:"center", width: "100px"}
    	                  ,{field: "reqDate", title:"申请时间", align:"center", width: "100px"}
    	                  ,{field: "prvUser", title:"撤销人", align:"center", width: "100px"}
    	                  ,{field: "prvDate", title:"撤销日期", align:"center", width: "100px"}
    	                  ,{field: "remark", title:"备注", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformPerConMoneyChgSelDialog;
})
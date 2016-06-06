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
    var PlatformProductListSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productList.selectProductList&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=productList.selectProductList&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },billNo: { type: "string" },type: { type: "string" },productName: { type: "string" },productSn: { type: "string" },buyDate: { type: "string" },naming: { type: "string" },productCode: { type: "string" },setup: { type: "string" },price: { type: "string" },vnd: { type: "string" },prepairDate: { type: "string" },status: { type: "string" }
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
    	                  ,{field: "billNo", title:"单据编号", align:"center", width: "100px"}
    	                  ,{field: "type", title:"类型", align:"center", width: "100px"}
    	                  ,{field: "productName", title:"名称", align:"center", width: "100px"}
    	                  ,{field: "productSn", title:"序列号", align:"center", width: "100px"}
    	                  ,{field: "buyDate", title:"购买日期", align:"center", width: "100px"}
    	                  ,{field: "naming", title:"品牌", align:"center", width: "100px"}
    	                  ,{field: "productCode", title:"型号", align:"center", width: "100px"}
    	                  ,{field: "setup", title:"配置", align:"center", width: "100px"}
    	                  ,{field: "price", title:"单价", align:"center", width: "100px"}
    	                  ,{field: "vnd", title:"供应商", align:"center", width: "100px"}
    	                  ,{field: "prepairDate", title:"保修期", align:"center", width: "100px"}
    	                  ,{field: "status", title:"状态", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformProductListSelDialog;
})
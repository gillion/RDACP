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
    var PlatformPerConMoneySelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoney.selectPerConMoney&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoney.selectPerConMoney&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },reqNo: { type: "string" },linetype: { type: "string" },soperCd: { type: "string" },cusCode: { type: "string" },cusName: { type: "string" },cusManagerId: { type: "string" },cusManagerName: { type: "string" },traceMoney: { type: "string" }
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
    	                  ,{field: "linetype", title:"条线", align:"center", width: "100px"}
    	                  ,{field: "soperCd", title:"关联类型", align:"center", width: "100px"}
    	                  ,{field: "cusCode", title:"客户代码", align:"center", width: "100px"}
    	                  ,{field: "cusName", title:"客户名称", align:"center", width: "100px"}
    	                  ,{field: "cusManagerId", title:"客户经理ID", align:"center", width: "100px"}
    	                  ,{field: "cusManagerName", title:"客户经理名称", align:"center", width: "100px"}
    	                  ,{field: "traceMoney", title:"关联金额", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformPerConMoneySelDialog;
})
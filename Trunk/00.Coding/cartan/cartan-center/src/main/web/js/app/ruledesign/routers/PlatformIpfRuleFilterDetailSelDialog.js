








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
    var PlatformIpfRuleFilterDetailSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfRuleFilterDetail.selectIpfRuleFilterDetail&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfRuleFilterDetail;
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
                                url: "router?appKey=000001&method=ipfRuleFilterDetail.selectIpfRuleFilterDetail&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfRuleFilterId: { type: "string" },lineId: { type: "string" },attribute: { type: "string" },operand: { type: "string" },literalValue: { type: "string" },andOr: { type: "string" },leftParen: { type: "string" },rightParen: { type: "string" }
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
    	                  ,{field: "ipfRuleFilterId", title:"筛选条件", align:"center", width: "100px"}
    	                  ,{field: "lineId", title:"行号", align:"center", width: "100px"}
    	                  ,{field: "attribute", title:"表属性", align:"center", width: "100px"}
    	                  ,{field: "operand", title:"运算符", align:"center", width: "100px"}
    	                  ,{field: "literalValue", title:"值", align:"center", width: "100px"}
    	                  ,{field: "andOr", title:"AND或者OR", align:"center", width: "100px"}
    	                  ,{field: "leftParen", title:"左括号数量", align:"center", width: "100px"}
    	                  ,{field: "rightParen", title:"右括号数量", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfRuleFilterDetailSelDialog;
})
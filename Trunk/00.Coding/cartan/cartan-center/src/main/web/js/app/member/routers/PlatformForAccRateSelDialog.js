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
    var PlatformForAccRateSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=forAccRate.selectForAccRate&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=forAccRate.selectForAccRate&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },etlDate: { type: "string" },centerCus: { type: "string" },subbranch: { type: "string" },cardId: { type: "string" },moneyCode: { type: "string" },productCode: { type: "string" },sector: { type: "string" },productValue: { type: "string" },allShare: { type: "string" },allValue: { type: "string" },allValueRmb: { type: "string" },levMoneyCode: { type: "string" },cardSector: { type: "string" },begindate: { type: "string" },enddate: { type: "string" },rproductCode: { type: "string" },cardCenterCus: { type: "string" },accountNum: { type: "string" },cusName: { type: "string" },idCardType: { type: "string" },idCardNum: { type: "string" },insertDate: { type: "string" }
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
    	                  ,{field: "etlDate", title:"ETL日期", align:"center", width: "100px"}
    	                  ,{field: "centerCus", title:"核心客户号", align:"center", width: "100px"}
    	                  ,{field: "subbranch", title:"销售机构编号", align:"center", width: "100px"}
    	                  ,{field: "cardId", title:"卡号", align:"center", width: "100px"}
    	                  ,{field: "moneyCode", title:"币种代码", align:"center", width: "100px"}
    	                  ,{field: "productCode", title:"产品代码", align:"center", width: "100px"}
    	                  ,{field: "sector", title:"所属机构编号", align:"center", width: "100px"}
    	                  ,{field: "productValue", title:"产品净值", align:"center", width: "100px"}
    	                  ,{field: "allShare", title:"份额总数", align:"center", width: "100px"}
    	                  ,{field: "allValue", title:"净值总额", align:"center", width: "100px"}
    	                  ,{field: "allValueRmb", title:"净值总额折人民币", align:"center", width: "100px"}
    	                  ,{field: "levMoneyCode", title:"标准币种代码", align:"center", width: "100px"}
    	                  ,{field: "cardSector", title:"开卡机构编号", align:"center", width: "100px"}
    	                  ,{field: "begindate", title:"起息日", align:"center", width: "100px"}
    	                  ,{field: "enddate", title:"到期日", align:"center", width: "100px"}
    	                  ,{field: "rproductCode", title:"R产品编号", align:"center", width: "100px"}
    	                  ,{field: "cardCenterCus", title:"卡的核心客户号", align:"center", width: "100px"}
    	                  ,{field: "accountNum", title:"主帐号", align:"center", width: "100px"}
    	                  ,{field: "cusName", title:"客户姓名", align:"center", width: "100px"}
    	                  ,{field: "idCardType", title:"标准证件类型", align:"center", width: "100px"}
    	                  ,{field: "idCardNum", title:"标准证件号码", align:"center", width: "100px"}
    	                  ,{field: "insertDate", title:"加载日期", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformForAccRateSelDialog;
})
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
    var PlatformJxkhCreditCardSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCreditCard.selectJxkhCreditCard&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCreditCard.selectJxkhCreditCard&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },turnNo: { type: "string" },userLoginid: { type: "string" },userName: { type: "string" },cusName: { type: "string" },cardType: { type: "string" },cardId: { type: "string" },idCardNum: { type: "string" },isnewcus: { type: "string" },insertDate: { type: "string" }
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
    	                  ,{field: "turnNo", title:"交换号", align:"center", width: "100px"}
    	                  ,{field: "userLoginid", title:"员工号", align:"center", width: "100px"}
    	                  ,{field: "userName", title:"员工姓名", align:"center", width: "100px"}
    	                  ,{field: "cusName", title:"客户姓名", align:"center", width: "100px"}
    	                  ,{field: "cardType", title:"卡种", align:"center", width: "100px"}
    	                  ,{field: "cardId", title:"主/附卡", align:"center", width: "100px"}
    	                  ,{field: "idCardNum", title:"客户证件号", align:"center", width: "100px"}
    	                  ,{field: "isnewcus", title:"是否新户", align:"center", width: "100px"}
    	                  ,{field: "insertDate", title:"加载日期", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformJxkhCreditCardSelDialog;
})
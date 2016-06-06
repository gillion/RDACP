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
    var PlatformUserIncomeSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=userIncome.selectUserIncome&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=userIncome.selectUserIncome&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },groupLoginid: { type: "string" },groupName: { type: "string" },groupDept: { type: "string" },groupLevel: { type: "string" },groupPerlevel: { type: "string" },groupIndate: { type: "string" },groupType: { type: "string" },groupTypeFy: { type: "string" },groupStatus: { type: "string" }
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
    	                  ,{field: "groupLoginid", title:"用户ID", align:"center", width: "100px"}
    	                  ,{field: "groupName", title:"用户名称", align:"center", width: "100px"}
    	                  ,{field: "groupDept", title:"员工部门", align:"center", width: "100px"}
    	                  ,{field: "groupLevel", title:"对公职级", align:"center", width: "100px"}
    	                  ,{field: "groupPerlevel", title:"对私职级", align:"center", width: "100px"}
    	                  ,{field: "groupIndate", title:"入职日期", align:"center", width: "100px"}
    	                  ,{field: "groupType", title:"绩效员工类别", align:"center", width: "100px"}
    	                  ,{field: "groupTypeFy", title:"费用员工类别", align:"center", width: "100px"}
    	                  ,{field: "groupStatus", title:"转正标识", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformUserIncomeSelDialog;
})
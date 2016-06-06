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
    var PlatformFinTbtransmanagerSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=finTbtransmanager.selectFinTbtransmanager&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=finTbtransmanager.selectFinTbtransmanager&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },etlDate: { type: "string" },serialNo: { type: "string" },clientNo: { type: "string" },managerType: { type: "string" },taCode: { type: "string" },summary: { type: "string" },clientManager01: { type: "string" },managerRate01: { type: "string" },clientManager02: { type: "string" },managerRate02: { type: "string" },clientManager03: { type: "string" },managerRate03: { type: "string" },clientManager04: { type: "string" },managerRate04: { type: "string" },clientManager05: { type: "string" },managerRate05: { type: "string" },clientManager06: { type: "string" },managerRate06: { type: "string" },clientManager07: { type: "string" },managerRate07: { type: "string" },clientManager08: { type: "string" },managerRate08: { type: "string" },clientManager09: { type: "string" },managerRate09: { type: "string" },clientManager10: { type: "string" },managerRate10: { type: "string" },insertDate: { type: "string" }
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
    	                  ,{field: "serialNo", title:"流水号", align:"center", width: "100px"}
    	                  ,{field: "clientNo", title:"客户编号", align:"center", width: "100px"}
    	                  ,{field: "managerType", title:"客户经理类别", align:"center", width: "100px"}
    	                  ,{field: "taCode", title:"TA代码", align:"center", width: "100px"}
    	                  ,{field: "summary", title:"备注", align:"center", width: "100px"}
    	                  ,{field: "clientManager01", title:"客户经理编号01", align:"center", width: "100px"}
    	                  ,{field: "managerRate01", title:"客户经理比例01", align:"center", width: "100px"}
    	                  ,{field: "clientManager02", title:"客户经理编号02", align:"center", width: "100px"}
    	                  ,{field: "managerRate02", title:"客户经理比例02", align:"center", width: "100px"}
    	                  ,{field: "clientManager03", title:"客户经理编号03", align:"center", width: "100px"}
    	                  ,{field: "managerRate03", title:"客户经理比例03", align:"center", width: "100px"}
    	                  ,{field: "clientManager04", title:"客户经理编号04", align:"center", width: "100px"}
    	                  ,{field: "managerRate04", title:"客户经理编号04", align:"center", width: "100px"}
    	                  ,{field: "clientManager05", title:"客户经理编号05", align:"center", width: "100px"}
    	                  ,{field: "managerRate05", title:"客户经理编号05", align:"center", width: "100px"}
    	                  ,{field: "clientManager06", title:"客户经理编号06", align:"center", width: "100px"}
    	                  ,{field: "managerRate06", title:"客户经理编号06", align:"center", width: "100px"}
    	                  ,{field: "clientManager07", title:"客户经理编号07", align:"center", width: "100px"}
    	                  ,{field: "managerRate07", title:"客户经理编号07", align:"center", width: "100px"}
    	                  ,{field: "clientManager08", title:"客户经理编号08", align:"center", width: "100px"}
    	                  ,{field: "managerRate08", title:"客户经理编号08", align:"center", width: "100px"}
    	                  ,{field: "clientManager09", title:"客户经理编号09", align:"center", width: "100px"}
    	                  ,{field: "managerRate09", title:"客户经理编号09", align:"center", width: "100px"}
    	                  ,{field: "clientManager10", title:"客户经理编号10", align:"center", width: "100px"}
    	                  ,{field: "managerRate10", title:"客户经理编号10", align:"center", width: "100px"}
    	                  ,{field: "insertDate", title:"加载日期", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformFinTbtransmanagerSelDialog;
})
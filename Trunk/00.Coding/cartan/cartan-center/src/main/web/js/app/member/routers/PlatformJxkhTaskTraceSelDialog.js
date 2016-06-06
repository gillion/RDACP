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
    var PlatformJxkhTaskTraceSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTaskTrace.selectJxkhTaskTrace&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTaskTrace.selectJxkhTaskTrace&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },tasktype: { type: "string" },bstype: { type: "string" },syear: { type: "string" },month1: { type: "string" },month2: { type: "string" },month3: { type: "string" },month4: { type: "string" },month5: { type: "string" },month6: { type: "string" },month7: { type: "string" },month8: { type: "string" },month9: { type: "string" },month10: { type: "string" },month11: { type: "string" },month12: { type: "string" },projectNo: { type: "string" },projectName: { type: "string" },yearTask: { type: "string" }
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
    	                  ,{field: "tasktype", title:"指标类别", align:"center", width: "100px"}
    	                  ,{field: "bstype", title:"业务类别", align:"center", width: "100px"}
    	                  ,{field: "syear", title:"年", align:"center", width: "100px"}
    	                  ,{field: "month1", title:"1月", align:"center", width: "100px"}
    	                  ,{field: "month2", title:"2月", align:"center", width: "100px"}
    	                  ,{field: "month3", title:"3月", align:"center", width: "100px"}
    	                  ,{field: "month4", title:"4月", align:"center", width: "100px"}
    	                  ,{field: "month5", title:"5月", align:"center", width: "100px"}
    	                  ,{field: "month6", title:"6月", align:"center", width: "100px"}
    	                  ,{field: "month7", title:"7月", align:"center", width: "100px"}
    	                  ,{field: "month8", title:"8月", align:"center", width: "100px"}
    	                  ,{field: "month9", title:"9月", align:"center", width: "100px"}
    	                  ,{field: "month10", title:"10月", align:"center", width: "100px"}
    	                  ,{field: "month11", title:"11月", align:"center", width: "100px"}
    	                  ,{field: "month12", title:"12月", align:"center", width: "100px"}
    	                  ,{field: "projectNo", title:"指标编号", align:"center", width: "100px"}
    	                  ,{field: "projectName", title:"指标名称", align:"center", width: "100px"}
    	                  ,{field: "yearTask", title:"年指标", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformJxkhTaskTraceSelDialog;
})
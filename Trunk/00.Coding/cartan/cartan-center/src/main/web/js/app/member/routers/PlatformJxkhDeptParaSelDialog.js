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
    var PlatformJxkhDeptParaSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhDeptPara.selectJxkhDeptPara&v=1.0&format=json",
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
                                url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhDeptPara.selectJxkhDeptPara&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },dept: { type: "string" },bstype: { type: "string" },endMonth: { type: "string" },beginMonth: { type: "string" },baseResult: { type: "string" },incremental: { type: "string" },doubles: { type: "string" },incomeDate: { type: "string" }
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
    	                  ,{field: "dept", title:"部门", align:"center", width: "100px"}
    	                  ,{field: "bstype", title:"业务类别", align:"center", width: "100px"}
    	                  ,{field: "endMonth", title:"基数起始月份", align:"center", width: "100px"}
    	                  ,{field: "beginMonth", title:"基数终止月份", align:"center", width: "100px"}
    	                  ,{field: "baseResult", title:"存量得分", align:"center", width: "100px"}
    	                  ,{field: "incremental", title:"增量得分", align:"center", width: "100px"}
    	                  ,{field: "doubles", title:"倍数", align:"center", width: "100px"}
    	                  ,{field: "incomeDate", title:"成立日期", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformJxkhDeptParaSelDialog;
})
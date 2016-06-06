








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
    var PlatformIpfCcmEnvironmentSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmEnvironment.selectIpfCcmEnvironment&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmEnvironment;
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
                                url: "router?appKey=000001&method=ipfCcmEnvironment.selectIpfCcmEnvironment&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },userCode: { type: "string" },projectName: { type: "string" },projectPath: { type: "string" },srcPath: { type: "string" },templatePath: { type: "string" },webContentName: { type: "string" },targetProjectName: { type: "string" },targetProjectPath: { type: "string" }
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
    	                  ,{field: "userCode", title:"工程代码", align:"center", width: "100px"}
    	                  ,{field: "projectName", title:"工程名称", align:"center", width: "100px"}
    	                  ,{field: "projectPath", title:"工程路径", align:"center", width: "100px"}
    	                  ,{field: "srcPath", title:"原代码路径", align:"center", width: "100px"}
    	                  ,{field: "templatePath", title:"模板工程目录", align:"center", width: "100px"}
    	                  ,{field: "webContentName", title:"模板工程名称", align:"center", width: "100px"}
    	                  ,{field: "targetProjectName", title:"分支工程名称", align:"center", width: "100px"}
    	                  ,{field: "targetProjectPath", title:"分支工程路径", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmEnvironmentSelDialog;
})
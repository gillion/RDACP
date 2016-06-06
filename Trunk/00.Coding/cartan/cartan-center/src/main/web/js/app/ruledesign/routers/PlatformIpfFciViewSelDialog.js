
		

		

		

		

		

		

		

		

		

		
/**
 * 选择窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "utils/Log",
    "grid/SimpleListUtil",
        "js/app/ruledesign/routers/PlatformIpfFciProjectSelDialog",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log, SimpleListUtil,
		PlatformIpfFciProjectSelDialog,
		AjaxEngine){	
    var PlatformIpfFciViewSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfFciView.selectIpfFciView&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].viewName;
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
                                url: "router?appKey=000001&method=ipfFciView.selectIpfFciView&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },viewName: { type: "string" },projectName: { type: "string" },viewDesc: { type: "string" },svnBranchesPath: { type: "string" },isActive: { type: "string" },connectionString: { type: "string" },ipfFciProjectId: { type: "string" },sourceLabelId: { type: "string" },isPermissionPageOnly: { type: "string" }
                            }
                            },
                            parse: function(response) {
                                return response;
                            },
                            //返回的数据
                            data: function(response) {
                                var result = response["resultJson"];

                                if($.isArray(result)){
                                    var data = null;
                                    for(var i= 0, count=result.length; i<count; i++){
                                        data = result[i];
                                        data["IpfFciProjectName"] = PlatformIpfFciProjectSelDialog.codetodes(data["ipfFciProjectId"]);
                                		data["isActiveName"] = SimpleListUtil.getSelectDes("T014", data["isActive"]);
                                		data["isPermissionPageOnlyName"] = SimpleListUtil.getSelectDes("T014", data["isPermissionPageOnly"]);
                                    }
                                }
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

                      		,{field: "viewName", title:"视图名称", align:"center", width: "100px"}
    	                  

                      		,{field: "projectName", title:"项目名称", align:"center", width: "100px"}
    	                  

                      		,{field: "viewDesc", title:"视图描述", align:"center", width: "100px"}
    	                  

                      		,{field: "svnBranchesPath", title:"SVN路径", align:"center", width: "100px"}
    	                  

                      		,{field: "isActive", title:"启用", hidden:"true", align:"center", width: "100px"}
                      		,{field: "isActiveName", title:"启用", align:"center", width: "100px"}
    	                  

                      		,{field: "connectionString", title:"目标数据库连接", align:"center", width: "100px"}
    	                  

                      		,{field: "ipfFciProjectId", title:"所属项目", hidden:"true", align:"center", width: "100px"}
                      		,{field: "IpfFciProjectName", title:"所属项目", align:"center", width: "100px"}
    	                  

                      		,{field: "sourceLabelId", title:"基线名称", align:"center", width: "100px"}
    	                  

                      		,{field: "isPermissionPageOnly", title:"只生成页面权限", hidden:"true", align:"center", width: "100px"}
                      		,{field: "isPermissionPageOnlyName", title:"只生成页面权限", align:"center", width: "100px"}
    	                  
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfFciViewSelDialog;
})

		

		

		

		

		

		

		

		

		

		

		

		

		
/**
 * 选择窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "utils/Log",
    "grid/SimpleListUtil",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log, SimpleListUtil,
		AjaxEngine){	
    var PlatformIpfFciProjectSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfFciProject.selectIpfFciProject&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].projectDes;
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
                                url: "router?appKey=000001&method=ipfFciProject.selectIpfFciProject&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },projectName: { type: "string" },projectType: { type: "string" },projectDes: { type: "string" },defaultViewId: { type: "string" },svnRepositoryPath: { type: "string" },svnUser: { type: "string" },svnPassword: { type: "string" },maxRevisonNumber: { type: "string" },ddLanguage: { type: "string" },dbType: { type: "string" },dbVersion: { type: "string" },isActive: { type: "string" }
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
                                		data["projectTypeName"] = SimpleListUtil.getSelectDes("T002", data["projectType"]);
                                		data["ddLanguageName"] = SimpleListUtil.getSelectDes("T004", data["ddLanguage"]);
                                		data["dbTypeName"] = SimpleListUtil.getSelectDes("T004", data["dbType"]);
                                		data["isActiveName"] = SimpleListUtil.getSelectDes("T014", data["isActive"]);
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

                      		,{field: "projectName", title:"项目名称", align:"center", width: "100px"}
    	                  

                      		,{field: "projectType", title:"项目类型", hidden:"true", align:"center", width: "100px"}
                      		,{field: "projectTypeName", title:"项目类型", align:"center", width: "100px"}
    	                  

                      		,{field: "projectDes", title:"项目描述", align:"center", width: "100px"}
    	                  

                      		,{field: "defaultViewId", title:"默认视图", align:"center", width: "100px"}
    	                  

                      		,{field: "svnRepositoryPath", title:"SVN路径", align:"center", width: "100px"}
    	                  

                      		,{field: "svnUser", title:"SVN帐户", align:"center", width: "100px"}
    	                  

                      		,{field: "svnPassword", title:"SVN密码", align:"center", width: "100px"}
    	                  

                      		,{field: "maxRevisonNumber", title:"最大修订号", align:"center", width: "100px"}
    	                  

                      		,{field: "ddLanguage", title:"默认语言", hidden:"true", align:"center", width: "100px"}
                      		,{field: "ddLanguageName", title:"默认语言", align:"center", width: "100px"}
    	                  

                      		,{field: "dbType", title:"数据库类型", hidden:"true", align:"center", width: "100px"}
                      		,{field: "dbTypeName", title:"数据库类型", align:"center", width: "100px"}
    	                  

                      		,{field: "dbVersion", title:"数据库版本号", align:"center", width: "100px"}
    	                  

                      		,{field: "isActive", title:"启用", hidden:"true", align:"center", width: "100px"}
                      		,{field: "isActiveName", title:"启用", align:"center", width: "100px"}
    	                  
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfFciProjectSelDialog;
})
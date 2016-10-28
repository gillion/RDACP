
		

		

		

		

		

		

		
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
    var PlatformCodegenerSelDialog = {
    		codetodes: function(id,sid){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=codegener.selectCodegener&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id,sid:sid},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].setupName;
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
                                url: "router?appKey=000001&method=codegener.selectCodegener&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },setupName: { type: "string" },basePackage: { type: "string" },moduleName: { type: "string" },root: { type: "string" },output: { type: "string" },sysname: { type: "string" }
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

                      		,{field: "setupName", title:"配置名称", align:"center", width: "100px"}
    	                  

                      		,{field: "basePackage", title:"基础包", align:"center", width: "100px"}
    	                  

                      		,{field: "moduleName", title:"模块名", align:"center", width: "100px"}
    	                  

                      		,{field: "root", title:"根目录", align:"center", width: "100px"}
    	                  

                      		,{field: "output", title:"输出路径", align:"center", width: "100px"}
    	                  

                      		,{field: "sysname", title:"系统名称", align:"center", width: "100px"}
    	                  
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformCodegenerSelDialog;
})
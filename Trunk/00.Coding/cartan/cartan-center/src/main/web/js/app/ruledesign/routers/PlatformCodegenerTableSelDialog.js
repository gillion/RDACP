
		

		

		

		

		

		

		

		
/**
 * 选择窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "utils/Log",
    "grid/SimpleListUtil",
        "js/app/ruledesign/routers/PlatformCodegenerSelDialog",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log, SimpleListUtil,
		PlatformCodegenerSelDialog,
		AjaxEngine){	
    var PlatformCodegenerTableSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=codegenerTable.selectCodegenerTable&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].tableName;
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
                                url: "router?appKey=000001&method=codegenerTable.selectCodegenerTable&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },setupId: { type: "string" },tableName: { type: "string" },tableDes: { type: "string" },parentTableName: { type: "string" },noParent: { type: "string" },isNewBsclass: { type: "string" },pageSize: { type: "string" }
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
                                        data["CodegenerName"] = PlatformCodegenerSelDialog.codetodes(data["setupId"]);
                                		data["noParentName"] = SimpleListUtil.getSelectDes("109", data["noParent"]);
                                		data["isNewBsclassName"] = SimpleListUtil.getSelectDes("109", data["isNewBsclass"]);
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

                      		,{field: "setupId", title:"配置名称", hidden:"true", align:"center", width: "100px"}
                      		,{field: "CodegenerName", title:"配置名称", align:"center", width: "100px"}
    	                  

                      		,{field: "tableName", title:"表名", align:"center", width: "100px"}
    	                  

                      		,{field: "tableDes", title:"中文描述", align:"center", width: "100px"}
    	                  

                      		,{field: "parentTableName", title:"继承表名", align:"center", width: "100px"}
    	                  

                      		,{field: "noParent", title:"无公共字段", hidden:"true", align:"center", width: "100px"}
                      		,{field: "noParentName", title:"无公共字段", align:"center", width: "100px"}
    	                  

                      		,{field: "isNewBsclass", title:"是否新建业务类", hidden:"true", align:"center", width: "100px"}
                      		,{field: "isNewBsclassName", title:"是否新建业务类", align:"center", width: "100px"}
    	                  

                      		,{field: "pageSize", title:"编辑列数", align:"center", width: "100px"}
    	                  
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformCodegenerTableSelDialog;
})
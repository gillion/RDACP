





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
        "js/app/ruledesign/routers/PlatformCodegenerTableSelDialog",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log, SimpleListUtil,
		PlatformCodegenerSelDialog,
		PlatformCodegenerTableSelDialog,
		AjaxEngine){	
    var PlatformCodegenerSelectSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=codegenerSelect.selectCodegenerSelect&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].CodegenerSelect;
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
                                url: "router?appKey=000001&method=codegenerSelect.selectCodegenerSelect&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },setupId: { type: "string" },tableId: { type: "string" },selectField: { type: "string" },selectTable: { type: "string" },selectDes: { type: "string" }
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
                                        data["CodegenerTableName"] = PlatformCodegenerTableSelDialog.codetodes(data["tableId"]);
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

                      		,{field: "setupId", title:"基本配置", hidden:"true", align:"center", width: "100px"}
                      		,{field: "CodegenerName", title:"基本配置", align:"center", width: "100px"}
    	                  

                      		,{field: "tableId", title:"关联模型", hidden:"true", align:"center", width: "100px"}
                      		,{field: "CodegenerTableName", title:"关联模型", align:"center", width: "100px"}
    	                  

                      		,{field: "selectField", title:"弹出字段", align:"center", width: "100px"}
    	                  

                      		,{field: "selectTable", title:"取数模型", align:"center", width: "100px"}
    	                  

                      		,{field: "selectDes", title:"描述字段", align:"center", width: "100px"}
    	                  
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformCodegenerSelectSelDialog;
})
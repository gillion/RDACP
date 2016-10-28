




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
        "js/app/ruledesign/routers/PlatformComstyleSelDialog",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log, SimpleListUtil,
		PlatformCodegenerSelDialog,
		PlatformCodegenerTableSelDialog,
		PlatformComstyleSelDialog,
		AjaxEngine){	
    var PlatformCodegenerRadioSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=codegenerRadio.selectCodegenerRadio&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].CodegenerRadio;
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
                                url: "router?appKey=000001&method=codegenerRadio.selectCodegenerRadio&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },setupId: { type: "string" },tableId: { type: "string" },radioField: { type: "string" },codeType: { type: "string" }
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
                                        data["ComstyleName"] = PlatformComstyleSelDialog.codetodes(data["codeType"]);
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
    	                  

                      		,{field: "radioField", title:"单选字段", align:"center", width: "100px"}
    	                  

                      		,{field: "codeType", title:"代码类型", hidden:"true", align:"center", width: "100px"}
                      		,{field: "ComstyleName", title:"代码类型", align:"center", width: "100px"}
    	                  
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformCodegenerRadioSelDialog;
})
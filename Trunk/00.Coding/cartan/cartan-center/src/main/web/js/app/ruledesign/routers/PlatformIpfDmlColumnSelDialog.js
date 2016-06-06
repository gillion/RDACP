












/**
 * 选择窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "utils/Log",
    "grid/SimpleListUtil",
        "js/app/ruledesign/routers/PlatformIpfDmlTableSelDialog",
        "js/app/ruledesign/routers/PlatformIpfDmlElementSelDialog",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log, SimpleListUtil,
		PlatformIpfDmlTableSelDialog,
		PlatformIpfDmlElementSelDialog,
		AjaxEngine){	
    var PlatformIpfDmlColumnSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfDmlColumn.selectIpfDmlColumn&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfDmlColumn;
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
                                url: "router?appKey=000001&method=ipfDmlColumn.selectIpfDmlColumn&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfDmlTableId: { type: "string" },columnName: { type: "string" },ipfDmlElementId: { type: "string" },elementCode: { type: "string" },fieldText: { type: "string" },dataType: { type: "string" },fieldLength: { type: "string" },decimals: { type: "string" },isNotNull: { type: "string" },isPrimaryKey: { type: "string" },defaultValue: { type: "string" },initValue: { type: "string" }
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
                                        data["IpfDmlTableName"] = PlatformIpfDmlTableSelDialog.codetodes(data["ipfDmlTableId"]);
                                        data["IpfDmlElementName"] = PlatformIpfDmlElementSelDialog.codetodes(data["ipfDmlElementId"]);
                                		data["dataTypeName"] = SimpleListUtil.getSelectDes("T013", data["dataType"]);
                                		data["isNotNullName"] = SimpleListUtil.getSelectDes("T014", data["isNotNull"]);
                                		data["isPrimaryKeyName"] = SimpleListUtil.getSelectDes("T014", data["isPrimaryKey"]);
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

                      		,{field: "ipfDmlTableId", title:"表名", hidden:"true", align:"center", width: "100px"}
                      		,{field: "IpfDmlTableName", title:"表名", align:"center", width: "100px"}
    	                  

                      		,{field: "columnName", title:"字段名称", align:"center", width: "100px"}
    	                  

                      		,{field: "ipfDmlElementId", title:"数据元素ID", hidden:"true", align:"center", width: "100px"}
                      		,{field: "IpfDmlElementName", title:"数据元素ID", align:"center", width: "100px"}
    	                  

                      		,{field: "elementCode", title:"数据元素代码", align:"center", width: "100px"}
    	                  

                      		,{field: "fieldText", title:"显示文本", align:"center", width: "100px"}
    	                  

                      		,{field: "dataType", title:"数据类型", hidden:"true", align:"center", width: "100px"}
                      		,{field: "dataTypeName", title:"数据类型", align:"center", width: "100px"}
    	                  

                      		,{field: "fieldLength", title:"字段长度", align:"center", width: "100px"}
    	                  

                      		,{field: "decimals", title:"小数位", align:"center", width: "100px"}
    	                  

                      		,{field: "isNotNull", title:"非空", hidden:"true", align:"center", width: "100px"}
                      		,{field: "isNotNullName", title:"非空", align:"center", width: "100px"}
    	                  

                      		,{field: "isPrimaryKey", title:"主键", hidden:"true", align:"center", width: "100px"}
                      		,{field: "isPrimaryKeyName", title:"主键", align:"center", width: "100px"}
    	                  

                      		,{field: "defaultValue", title:"默认值", align:"center", width: "100px"}
    	                  

                      		,{field: "initValue", title:"初始值", align:"center", width: "100px"}
    	                  
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfDmlColumnSelDialog;
})














































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
    var PlatformIpfCcmBoPropertySelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoProperty.selectIpfCcmBoProperty&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoProperty;
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
                                url: "router?appKey=000001&method=ipfCcmBoProperty.selectIpfCcmBoProperty&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },propertyName: { type: "string" },columnName: { type: "string" },propertyType: { type: "string" },subBoLayoutType: { type: "string" },tableName: { type: "string" },maxValue: { type: "string" },minValue: { type: "string" },elementCode: { type: "string" },fieldText: { type: "string" },dataType: { type: "string" },fieldLength: { type: "string" },decimals: { type: "string" },isNotNull: { type: "string" },isKey: { type: "string" },subBoName: { type: "string" },subBoRelType: { type: "string" },subBoRelPro: { type: "string" },subBoOrderNo: { type: "string" },persistentSaveType: { type: "string" },relSubBoProName: { type: "string" },searchHelp: { type: "string" },refProName: { type: "string" },dictTableName: { type: "string" },dictGroupValue: { type: "string" },fetchWay: { type: "string" },fixValue: { type: "string" },valueExpression: { type: "string" },vlaueRuleNo: { type: "string" },preCondition: { type: "string" },optCondition: { type: "string" },isSurcharge: { type: "string" },isRealtimeCalculate: { type: "string" },rpType: { type: "string" },custIdPropertyName: { type: "string" },businessDatePropertyName: { type: "string" },ipfCcmBoId: { type: "string" },authField: { type: "string" },helpIndex: { type: "string" },numberObjectId: { type: "string" },relBoMethod: { type: "string" },relBoName: { type: "string" },shTable: { type: "string" },shValueColumn: { type: "string" },validactionType: { type: "string" },validactionRegex: { type: "string" }
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
    	                  ,{field: "propertyName", title:"属性名", align:"center", width: "100px"}
    	                  ,{field: "columnName", title:"字段名", align:"center", width: "100px"}
    	                  ,{field: "propertyType", title:"属性类型", align:"center", width: "100px"}
    	                  ,{field: "subBoLayoutType", title:"布局类型", align:"center", width: "100px"}
    	                  ,{field: "tableName", title:"表名", align:"center", width: "100px"}
    	                  ,{field: "maxValue", title:"最大值", align:"center", width: "100px"}
    	                  ,{field: "minValue", title:"最小值", align:"center", width: "100px"}
    	                  ,{field: "elementCode", title:"数据元素代码", align:"center", width: "100px"}
    	                  ,{field: "fieldText", title:"显示文本", align:"center", width: "100px"}
    	                  ,{field: "dataType", title:"数据类型", align:"center", width: "100px"}
    	                  ,{field: "fieldLength", title:"字段长度", align:"center", width: "100px"}
    	                  ,{field: "decimals", title:"小数位", align:"center", width: "100px"}
    	                  ,{field: "isNotNull", title:"非空", align:"center", width: "100px"}
    	                  ,{field: "isKey", title:"主键", align:"center", width: "100px"}
    	                  ,{field: "subBoName", title:"子业务对象名", align:"center", width: "100px"}
    	                  ,{field: "subBoRelType", title:"关联BO类型", align:"center", width: "100px"}
    	                  ,{field: "subBoRelPro", title:"关系对象属性", align:"center", width: "100px"}
    	                  ,{field: "subBoOrderNo", title:"子业务对象的排序号", align:"center", width: "100px"}
    	                  ,{field: "persistentSaveType", title:"子业务对象保存方式", align:"center", width: "100px"}
    	                  ,{field: "relSubBoProName", title:"关联子业务对象属性名称", align:"center", width: "100px"}
    	                  ,{field: "searchHelp", title:"搜索帮助名", align:"center", width: "100px"}
    	                  ,{field: "refProName", title:"搜索帮助关联属性", align:"center", width: "100px"}
    	                  ,{field: "dictTableName", title:"字典表", align:"center", width: "100px"}
    	                  ,{field: "dictGroupValue", title:"字典分组值", align:"center", width: "100px"}
    	                  ,{field: "fetchWay", title:"取数方式", align:"center", width: "100px"}
    	                  ,{field: "fixValue", title:"取数固定值", align:"center", width: "100px"}
    	                  ,{field: "valueExpression", title:"取数表达式", align:"center", width: "100px"}
    	                  ,{field: "vlaueRuleNo", title:"取数规则号", align:"center", width: "100px"}
    	                  ,{field: "preCondition", title:"前提条件", align:"center", width: "100px"}
    	                  ,{field: "optCondition", title:"选择条件", align:"center", width: "100px"}
    	                  ,{field: "isSurcharge", title:"附加费", align:"center", width: "100px"}
    	                  ,{field: "isRealtimeCalculate", title:"实时计算", align:"center", width: "100px"}
    	                  ,{field: "rpType", title:"收付类型", align:"center", width: "100px"}
    	                  ,{field: "custIdPropertyName", title:"客户代码属性名称", align:"center", width: "100px"}
    	                  ,{field: "businessDatePropertyName", title:"业务日期属性名称", align:"center", width: "100px"}
    	                  ,{field: "ipfCcmBoId", title:"所属业务对象", align:"center", width: "100px"}
    	                  ,{field: "authField", title:"授权字段", align:"center", width: "100px"}
    	                  ,{field: "helpIndex", title:"帮助索引号", align:"center", width: "100px"}
    	                  ,{field: "numberObjectId", title:"号码对象ID", align:"center", width: "100px"}
    	                  ,{field: "relBoMethod", title:"关联业务对象方法名", align:"center", width: "100px"}
    	                  ,{field: "relBoName", title:"关联业务对象名", align:"center", width: "100px"}
    	                  ,{field: "shTable", title:"搜索帮助表或视图", align:"center", width: "100px"}
    	                  ,{field: "shValueColumn", title:"值字段", align:"center", width: "100px"}
    	                  ,{field: "validactionType", title:"数据校验类型", align:"center", width: "100px"}
    	                  ,{field: "validactionRegex", title:"数据校验正则表达式", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoPropertySelDialog;
})
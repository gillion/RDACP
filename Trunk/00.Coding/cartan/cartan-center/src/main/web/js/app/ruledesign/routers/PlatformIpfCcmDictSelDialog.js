















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
    var PlatformIpfCcmDictSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmDict.selectIpfCcmDict&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmDict;
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
                                url: "router?appKey=000001&method=ipfCcmDict.selectIpfCcmDict&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },dictCode: { type: "string" },dictName: { type: "string" },dictType: { type: "string" },codeColumn: { type: "string" },nameColumn: { type: "string" },keyColumn: { type: "string" },tableName: { type: "string" },isGroup: { type: "string" },groupColumn: { type: "string" },remark: { type: "string" },orderColumn: { type: "string" },isSystem: { type: "string" },dataType: { type: "string" },fieldLength: { type: "string" },decimals: { type: "string" }
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
    	                  ,{field: "dictCode", title:"字典代码", align:"center", width: "100px"}
    	                  ,{field: "dictName", title:"字典名称", align:"center", width: "100px"}
    	                  ,{field: "dictType", title:"字典类型", align:"center", width: "100px"}
    	                  ,{field: "codeColumn", title:"字典代码字段", align:"center", width: "100px"}
    	                  ,{field: "nameColumn", title:"字典名称字段", align:"center", width: "100px"}
    	                  ,{field: "keyColumn", title:"字典ID字段", align:"center", width: "100px"}
    	                  ,{field: "tableName", title:"字典表名", align:"center", width: "100px"}
    	                  ,{field: "isGroup", title:"是否分组", align:"center", width: "100px"}
    	                  ,{field: "groupColumn", title:"分组字段", align:"center", width: "100px"}
    	                  ,{field: "remark", title:"备注", align:"center", width: "100px"}
    	                  ,{field: "orderColumn", title:"排序字段", align:"center", width: "100px"}
    	                  ,{field: "isSystem", title:"是否系统", align:"center", width: "100px"}
    	                  ,{field: "dataType", title:"数据类型", align:"center", width: "100px"}
    	                  ,{field: "fieldLength", title:"字段长度", align:"center", width: "100px"}
    	                  ,{field: "decimals", title:"小数位", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmDictSelDialog;
})
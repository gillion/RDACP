











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
    var PlatformDatasetVarSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=datasetVar.selectDatasetVar&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].DatasetVar;
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
                                url: "router?appKey=000001&method=datasetVar.selectDatasetVar&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },datasetId: { type: "string" },varName: { type: "string" },varDes: { type: "string" },isDerived: { type: "string" },isSet: { type: "string" },varType: { type: "string" },spanBegin: { type: "string" },spanEnd: { type: "string" },isOutput: { type: "string" },defValue: { type: "string" },remark: { type: "string" }
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
    	                  ,{field: "datasetId", title:"数据集", align:"center", width: "100px"}
    	                  ,{field: "varName", title:"变量", align:"center", width: "100px"}
    	                  ,{field: "varDes", title:"变量描述", align:"center", width: "100px"}
    	                  ,{field: "isDerived", title:"是否衍生", align:"center", width: "100px"}
    	                  ,{field: "isSet", title:"是否集合", align:"center", width: "100px"}
    	                  ,{field: "varType", title:"变量类型", align:"center", width: "100px"}
    	                  ,{field: "spanBegin", title:"取值起始", align:"center", width: "100px"}
    	                  ,{field: "spanEnd", title:"取值结束", align:"center", width: "100px"}
    	                  ,{field: "isOutput", title:"是否输出", align:"center", width: "100px"}
    	                  ,{field: "defValue", title:"缺省值", align:"center", width: "100px"}
    	                  ,{field: "remark", title:"备注", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformDatasetVarSelDialog;
})
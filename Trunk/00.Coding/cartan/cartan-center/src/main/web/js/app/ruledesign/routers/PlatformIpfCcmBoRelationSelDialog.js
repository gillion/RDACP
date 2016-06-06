










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
    var PlatformIpfCcmBoRelationSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoRelation.selectIpfCcmBoRelation&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoRelation;
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
                                url: "router?appKey=000001&method=ipfCcmBoRelation.selectIpfCcmBoRelation&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmBoId: { type: "string" },propertyName: { type: "string" },subBoName: { type: "string" },subBoRelType: { type: "string" },objectType: { type: "string" },description: { type: "string" },subBoOrderNo: { type: "string" },persistentSaveType: { type: "string" },gridEditType: { type: "string" },linkBoName: { type: "string" }
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
    	                  ,{field: "ipfCcmBoId", title:"业务对象", align:"center", width: "100px"}
    	                  ,{field: "propertyName", title:"属性名称", align:"center", width: "100px"}
    	                  ,{field: "subBoName", title:"子对象名称", align:"center", width: "100px"}
    	                  ,{field: "subBoRelType", title:"子对象关系类型", align:"center", width: "100px"}
    	                  ,{field: "objectType", title:"对象类型", align:"center", width: "100px"}
    	                  ,{field: "description", title:"描述", align:"center", width: "100px"}
    	                  ,{field: "subBoOrderNo", title:"子业务对象的排序号", align:"center", width: "100px"}
    	                  ,{field: "persistentSaveType", title:"子业务对象保存方式", align:"center", width: "100px"}
    	                  ,{field: "gridEditType", title:"表格维护方式", align:"center", width: "100px"}
    	                  ,{field: "linkBoName", title:"关联对象名称", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoRelationSelDialog;
})
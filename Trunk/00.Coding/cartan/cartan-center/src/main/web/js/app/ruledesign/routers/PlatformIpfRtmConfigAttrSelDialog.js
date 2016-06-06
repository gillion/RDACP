










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
    var PlatformIpfRtmConfigAttrSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfRtmConfigAttr.selectIpfRtmConfigAttr&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfRtmConfigAttr;
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
                                url: "router?appKey=000001&method=ipfRtmConfigAttr.selectIpfRtmConfigAttr&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfRtmConfigId: { type: "string" },seqNo: { type: "string" },displayLabel: { type: "string" },dataType: { type: "string" },uiType: { type: "string" },dictTableName: { type: "string" },dictGroupValue: { type: "string" },searchHelp: { type: "string" },shValueColumn: { type: "string" },shDisplayColumn: { type: "string" }
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
    	                  ,{field: "ipfRtmConfigId", title:"运行期配置", align:"center", width: "100px"}
    	                  ,{field: "seqNo", title:"序号", align:"center", width: "100px"}
    	                  ,{field: "displayLabel", title:"显示名称", align:"center", width: "100px"}
    	                  ,{field: "dataType", title:"数据类型", align:"center", width: "100px"}
    	                  ,{field: "uiType", title:"UI组件类型", align:"center", width: "100px"}
    	                  ,{field: "dictTableName", title:"字典表编码", align:"center", width: "100px"}
    	                  ,{field: "dictGroupValue", title:"字典表分组名", align:"center", width: "100px"}
    	                  ,{field: "searchHelp", title:"搜索帮助名", align:"center", width: "100px"}
    	                  ,{field: "shValueColumn", title:"搜索帮助值字段", align:"center", width: "100px"}
    	                  ,{field: "shDisplayColumn", title:"搜索帮助文本字段", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfRtmConfigAttrSelDialog;
})
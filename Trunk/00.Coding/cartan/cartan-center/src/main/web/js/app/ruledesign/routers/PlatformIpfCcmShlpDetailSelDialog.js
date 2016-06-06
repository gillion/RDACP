





















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
    var PlatformIpfCcmShlpDetailSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmShlpDetail.selectIpfCcmShlpDetail&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmShlpDetail;
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
                                url: "router?appKey=000001&method=ipfCcmShlpDetail.selectIpfCcmShlpDetail&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmShlpId: { type: "string" },shlpName: { type: "string" },fieldName: { type: "string" },fieldText: { type: "string" },listPosition: { type: "string" },isVisible: { type: "string" },isInput: { type: "string" },isOutput: { type: "string" },detailStatus: { type: "string" },dataType: { type: "string" },decimals: { type: "string" },defaultValue: { type: "string" },columnLength: { type: "string" },conditionPosition: { type: "string" },operation: { type: "string" },isRollChange: { type: "string" },isEditable: { type: "string" },ddtext: { type: "string" },isSort: { type: "string" },sortOrder: { type: "string" },sortType: { type: "string" }
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
    	                  ,{field: "ipfCcmShlpId", title:"搜索帮助", align:"center", width: "100px"}
    	                  ,{field: "shlpName", title:"搜索帮助名称", align:"center", width: "100px"}
    	                  ,{field: "fieldName", title:"字段名", align:"center", width: "100px"}
    	                  ,{field: "fieldText", title:"显示文本", align:"center", width: "100px"}
    	                  ,{field: "listPosition", title:"字段清单中的位置", align:"center", width: "100px"}
    	                  ,{field: "isVisible", title:"是否清单中显示", align:"center", width: "100px"}
    	                  ,{field: "isInput", title:"输入参数", align:"center", width: "100px"}
    	                  ,{field: "isOutput", title:"输出参数", align:"center", width: "100px"}
    	                  ,{field: "detailStatus", title:"状态", align:"center", width: "100px"}
    	                  ,{field: "dataType", title:"数据类型", align:"center", width: "100px"}
    	                  ,{field: "decimals", title:"小数位", align:"center", width: "100px"}
    	                  ,{field: "defaultValue", title:"默认值", align:"center", width: "100px"}
    	                  ,{field: "columnLength", title:"长度", align:"center", width: "100px"}
    	                  ,{field: "conditionPosition", title:"条件字段位置", align:"center", width: "100px"}
    	                  ,{field: "operation", title:"操作符", align:"center", width: "100px"}
    	                  ,{field: "isRollChange", title:"条件选择类型", align:"center", width: "100px"}
    	                  ,{field: "isEditable", title:"弹出窗表格中可编辑", align:"center", width: "100px"}
    	                  ,{field: "ddtext", title:"字段中文描述", align:"center", width: "100px"}
    	                  ,{field: "isSort", title:"排序", align:"center", width: "100px"}
    	                  ,{field: "sortOrder", title:"排序顺序", align:"center", width: "100px"}
    	                  ,{field: "sortType", title:"排序类型", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmShlpDetailSelDialog;
})
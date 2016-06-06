

















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
    var PlatformIpfCcmBoFormCellSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoFormCell.selectIpfCcmBoFormCell&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoFormCell;
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
                                url: "router?appKey=000001&method=ipfCcmBoFormCell.selectIpfCcmBoFormCell&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmBoId: { type: "string" },formType: { type: "string" },isDefault: { type: "string" },cellName: { type: "string" },cellType: { type: "string" },cellHeigh: { type: "string" },isShowGroup: { type: "string" },groupWidget: { type: "string" },elementCode: { type: "string" },groupTitle: { type: "string" },unitCount: { type: "string" },isParent: { type: "string" },childrenLineCount: { type: "string" },parentCellName: { type: "string" },rowNo: { type: "string" },columnNo: { type: "string" },labelUnitCount: { type: "string" }
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
    	                  ,{field: "formType", title:"界面类型", align:"center", width: "100px"}
    	                  ,{field: "isDefault", title:"默认FORM", align:"center", width: "100px"}
    	                  ,{field: "cellName", title:"栅格名称", align:"center", width: "100px"}
    	                  ,{field: "cellType", title:"栅格类型", align:"center", width: "100px"}
    	                  ,{field: "cellHeigh", title:"栅格高度", align:"center", width: "100px"}
    	                  ,{field: "isShowGroup", title:"显示分组", align:"center", width: "100px"}
    	                  ,{field: "groupWidget", title:"分组控件", align:"center", width: "100px"}
    	                  ,{field: "elementCode", title:"数据元素代码", align:"center", width: "100px"}
    	                  ,{field: "groupTitle", title:"分组标题", align:"center", width: "100px"}
    	                  ,{field: "unitCount", title:"包含栅格数", align:"center", width: "100px"}
    	                  ,{field: "isParent", title:"包含子栅格", align:"center", width: "100px"}
    	                  ,{field: "childrenLineCount", title:"子栅格行数", align:"center", width: "100px"}
    	                  ,{field: "parentCellName", title:"父栅格", align:"center", width: "100px"}
    	                  ,{field: "rowNo", title:"所属栅格行", align:"center", width: "100px"}
    	                  ,{field: "columnNo", title:"所属栅格列", align:"center", width: "100px"}
    	                  ,{field: "labelUnitCount", title:"标签占栅格数", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoFormCellSelDialog;
})
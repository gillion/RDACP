























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
    var PlatformIpfCcmBoPageLayoutSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoPageLayout.selectIpfCcmBoPageLayout&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoPageLayout;
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
                                url: "router?appKey=000001&method=ipfCcmBoPageLayout.selectIpfCcmBoPageLayout&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmBoPageId: { type: "string" },layoutType: { type: "string" },layoutContainerType: { type: "string" },layoutBoName: { type: "string" },styleClass: { type: "string" },style: { type: "string" },formType: { type: "string" },elementName: { type: "string" },height: { type: "string" },isShowGroup: { type: "string" },groupWidget: { type: "string" },groupMsgCode: { type: "string" },groupTitle: { type: "string" },unitCount: { type: "string" },isParent: { type: "string" },childrenLineCount: { type: "string" },cellName: { type: "string" },rowNo: { type: "string" },columnNo: { type: "string" },labelUnitCount: { type: "string" },seqNo: { type: "string" },controlConnector: { type: "string" },parentCellName: { type: "string" }
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
    	                  ,{field: "ipfCcmBoPageId", title:"页面", align:"center", width: "100px"}
    	                  ,{field: "layoutType", title:"页面布局类型", align:"center", width: "100px"}
    	                  ,{field: "layoutContainerType", title:"页面布局容器类型", align:"center", width: "100px"}
    	                  ,{field: "layoutBoName", title:"页面布局业务对象名称", align:"center", width: "100px"}
    	                  ,{field: "styleClass", title:"样式名称", align:"center", width: "100px"}
    	                  ,{field: "style", title:"样式", align:"center", width: "100px"}
    	                  ,{field: "formType", title:"表单类型", align:"center", width: "100px"}
    	                  ,{field: "elementName", title:"布局元素名称", align:"center", width: "100px"}
    	                  ,{field: "height", title:"栅格高度", align:"center", width: "100px"}
    	                  ,{field: "isShowGroup", title:"显示分组", align:"center", width: "100px"}
    	                  ,{field: "groupWidget", title:"分组控件", align:"center", width: "100px"}
    	                  ,{field: "groupMsgCode", title:"分组标题系统消息代码", align:"center", width: "100px"}
    	                  ,{field: "groupTitle", title:"分组标题", align:"center", width: "100px"}
    	                  ,{field: "unitCount", title:"包含栅格数", align:"center", width: "100px"}
    	                  ,{field: "isParent", title:"是否父栅格", align:"center", width: "100px"}
    	                  ,{field: "childrenLineCount", title:"子栅格行数", align:"center", width: "100px"}
    	                  ,{field: "cellName", title:"栅格名称", align:"center", width: "100px"}
    	                  ,{field: "rowNo", title:"行号", align:"center", width: "100px"}
    	                  ,{field: "columnNo", title:"列号", align:"center", width: "100px"}
    	                  ,{field: "labelUnitCount", title:"标签占栅格数", align:"center", width: "100px"}
    	                  ,{field: "seqNo", title:"序号", align:"center", width: "100px"}
    	                  ,{field: "controlConnector", title:"连接符号", align:"center", width: "100px"}
    	                  ,{field: "parentCellName", title:"父栅格", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoPageLayoutSelDialog;
})
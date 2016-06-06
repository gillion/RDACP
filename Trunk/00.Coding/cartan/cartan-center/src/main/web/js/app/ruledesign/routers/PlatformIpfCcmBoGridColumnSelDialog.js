




















































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
    var PlatformIpfCcmBoGridColumnSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoGridColumn.selectIpfCcmBoGridColumn&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoGridColumn;
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
                                url: "router?appKey=000001&method=ipfCcmBoGridColumn.selectIpfCcmBoGridColumn&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmBoId: { type: "string" },defaultValue: { type: "string" },isCondition: { type: "string" },isRange: { type: "string" },correctType: { type: "string" },isSum: { type: "string" },isNotNull: { type: "string" },isOrderBy: { type: "string" },propertyName: { type: "string" },propertyType: { type: "string" },uiType: { type: "string" },columnNo: { type: "string" },isReadOnly: { type: "string" },isVisible: { type: "string" },width: { type: "string" },propertyId: { type: "string" },cellRuleNo: { type: "string" },methodId: { type: "string" },methodName: { type: "string" },searchColumnNo: { type: "string" },searchRowNo: { type: "string" },operation: { type: "string" },conditionVisible: { type: "string" },shlpValueType: { type: "string" },isQuickSearch: { type: "string" },quickCellName: { type: "string" },quickTextFormHeight: { type: "string" },quickTextLineNum: { type: "string" },quickInlineWidth: { type: "string" },quickInlineOrderNo: { type: "string" },quickInlineConnector: { type: "string" },isQuickShowLabel: { type: "string" },isQuickRadioInline: { type: "string" },isAdvSearch: { type: "string" },advCellName: { type: "string" },advTextFormHeight: { type: "string" },advTextLineNum: { type: "string" },advInlineWidth: { type: "string" },advInlineOrderNo: { type: "string" },advInlineConnector: { type: "string" },isAdvShowLabel: { type: "string" },isAdvRadioInline: { type: "string" },tabIndex: { type: "string" },isCellEditable: { type: "string" },initValueType: { type: "string" },initValueType2: { type: "string" },defaultValue2: { type: "string" },fieldSort: { type: "string" },activeExpress: { type: "string" },lockColumnExpress: { type: "string" },unlockColumnExpress: { type: "string" },isShowSort: { type: "string" }
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
    	                  ,{field: "defaultValue", title:"初始值", align:"center", width: "100px"}
    	                  ,{field: "isCondition", title:"查询条件", align:"center", width: "100px"}
    	                  ,{field: "isRange", title:"区间查询条件", align:"center", width: "100px"}
    	                  ,{field: "correctType", title:"转换类型", align:"center", width: "100px"}
    	                  ,{field: "isSum", title:"汇总", align:"center", width: "100px"}
    	                  ,{field: "isNotNull", title:"非空", align:"center", width: "100px"}
    	                  ,{field: "isOrderBy", title:"排序", align:"center", width: "100px"}
    	                  ,{field: "propertyName", title:"属性名", align:"center", width: "100px"}
    	                  ,{field: "propertyType", title:"属性类型", align:"center", width: "100px"}
    	                  ,{field: "uiType", title:"组件类型", align:"center", width: "100px"}
    	                  ,{field: "columnNo", title:"列号", align:"center", width: "100px"}
    	                  ,{field: "isReadOnly", title:"只读", align:"center", width: "100px"}
    	                  ,{field: "isVisible", title:"显示", align:"center", width: "100px"}
    	                  ,{field: "width", title:"列宽", align:"center", width: "100px"}
    	                  ,{field: "propertyId", title:"属性ID", align:"center", width: "100px"}
    	                  ,{field: "cellRuleNo", title:"单元格处理规则号", align:"center", width: "100px"}
    	                  ,{field: "methodId", title:"调用方法ID", align:"center", width: "100px"}
    	                  ,{field: "methodName", title:"调用方法名称", align:"center", width: "100px"}
    	                  ,{field: "searchColumnNo", title:"查询条件列号", align:"center", width: "100px"}
    	                  ,{field: "searchRowNo", title:"查询条件行号", align:"center", width: "100px"}
    	                  ,{field: "operation", title:"查询操作符", align:"center", width: "100px"}
    	                  ,{field: "conditionVisible", title:"查询条件可见性", align:"center", width: "100px"}
    	                  ,{field: "shlpValueType", title:"值类型", align:"center", width: "100px"}
    	                  ,{field: "isQuickSearch", title:"快捷查询", align:"center", width: "100px"}
    	                  ,{field: "quickCellName", title:"快捷查询对应栅格", align:"center", width: "100px"}
    	                  ,{field: "quickTextFormHeight", title:"快捷查询多行文本控制高度", align:"center", width: "100px"}
    	                  ,{field: "quickTextLineNum", title:"快捷查询多行文本行数", align:"center", width: "100px"}
    	                  ,{field: "quickInlineWidth", title:"快捷查询控件高度", align:"center", width: "100px"}
    	                  ,{field: "quickInlineOrderNo", title:"快捷查询顺序", align:"center", width: "100px"}
    	                  ,{field: "quickInlineConnector", title:"快捷查询连接符", align:"center", width: "100px"}
    	                  ,{field: "isQuickShowLabel", title:"快捷查询显示标签", align:"center", width: "100px"}
    	                  ,{field: "isQuickRadioInline", title:"快捷查询内联", align:"center", width: "100px"}
    	                  ,{field: "isAdvSearch", title:"需高级查询", align:"center", width: "100px"}
    	                  ,{field: "advCellName", title:"高级查询对应栅格", align:"center", width: "100px"}
    	                  ,{field: "advTextFormHeight", title:"高级查询多行文本控制高度", align:"center", width: "100px"}
    	                  ,{field: "advTextLineNum", title:"高级查询多行文本行数", align:"center", width: "100px"}
    	                  ,{field: "advInlineWidth", title:"高级查询控件高度", align:"center", width: "100px"}
    	                  ,{field: "advInlineOrderNo", title:"高级查询顺序", align:"center", width: "100px"}
    	                  ,{field: "advInlineConnector", title:"高级查询连接符", align:"center", width: "100px"}
    	                  ,{field: "isAdvShowLabel", title:"高级查询显示标签", align:"center", width: "100px"}
    	                  ,{field: "isAdvRadioInline", title:"高级查询内联", align:"center", width: "100px"}
    	                  ,{field: "tabIndex", title:"Tab顺序", align:"center", width: "100px"}
    	                  ,{field: "isCellEditable", title:"表格可编辑", align:"center", width: "100px"}
    	                  ,{field: "initValueType", title:"初始值类型", align:"center", width: "100px"}
    	                  ,{field: "initValueType2", title:"初始值类型2", align:"center", width: "100px"}
    	                  ,{field: "defaultValue2", title:"初始值2", align:"center", width: "100px"}
    	                  ,{field: "fieldSort", title:"字段排序", align:"center", width: "100px"}
    	                  ,{field: "activeExpress", title:"可编辑表达式", align:"center", width: "100px"}
    	                  ,{field: "lockColumnExpress", title:"列锁定表达式", align:"center", width: "100px"}
    	                  ,{field: "unlockColumnExpress", title:"列解锁表达式", align:"center", width: "100px"}
    	                  ,{field: "isShowSort", title:"显示排序", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoGridColumnSelDialog;
})
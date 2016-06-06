































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
    var PlatformIpfCcmBoFormColumnSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoFormColumn.selectIpfCcmBoFormColumn&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoFormColumn;
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
                                url: "router?appKey=000001&method=ipfCcmBoFormColumn.selectIpfCcmBoFormColumn&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmBoId: { type: "string" },defaultValue: { type: "string" },isGroup: { type: "string" },groupName: { type: "string" },isCaNote: { type: "string" },isHeader: { type: "string" },isNotNull: { type: "string" },isReadOnly: { type: "string" },propertyName: { type: "string" },propertyType: { type: "string" },columnNo: { type: "string" },rowNo: { type: "string" },uiType: { type: "string" },isVisible: { type: "string" },propertyId: { type: "string" },ruleNo: { type: "string" },columnStyle: { type: "string" },displayLable: { type: "string" },lableStyle: { type: "string" },cellName: { type: "string" },textFormHeight: { type: "string" },textLineNum: { type: "string" },inlineWidth: { type: "string" },inlineOrderNo: { type: "string" },inlineConnector: { type: "string" },isShowLabel: { type: "string" },isRadioInline: { type: "string" },tabIndex: { type: "string" },initValueType: { type: "string" },correctType: { type: "string" },activeExpress: { type: "string" }
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
    	                  ,{field: "isGroup", title:"分组", align:"center", width: "100px"}
    	                  ,{field: "groupName", title:"分组名", align:"center", width: "100px"}
    	                  ,{field: "isCaNote", title:"是否管理标签页", align:"center", width: "100px"}
    	                  ,{field: "isHeader", title:"台头", align:"center", width: "100px"}
    	                  ,{field: "isNotNull", title:"非空", align:"center", width: "100px"}
    	                  ,{field: "isReadOnly", title:"只读", align:"center", width: "100px"}
    	                  ,{field: "propertyName", title:"属性名称", align:"center", width: "100px"}
    	                  ,{field: "propertyType", title:"属性类型", align:"center", width: "100px"}
    	                  ,{field: "columnNo", title:"列号", align:"center", width: "100px"}
    	                  ,{field: "rowNo", title:"行号", align:"center", width: "100px"}
    	                  ,{field: "uiType", title:"组件类型", align:"center", width: "100px"}
    	                  ,{field: "isVisible", title:"显示", align:"center", width: "100px"}
    	                  ,{field: "propertyId", title:"属性ID", align:"center", width: "100px"}
    	                  ,{field: "ruleNo", title:"规则号", align:"center", width: "100px"}
    	                  ,{field: "columnStyle", title:"列样式", align:"center", width: "100px"}
    	                  ,{field: "displayLable", title:"字段文本是否显示", align:"center", width: "100px"}
    	                  ,{field: "lableStyle", title:"标签样式", align:"center", width: "100px"}
    	                  ,{field: "cellName", title:"单元格名称", align:"center", width: "100px"}
    	                  ,{field: "textFormHeight", title:"多行文本控制高度", align:"center", width: "100px"}
    	                  ,{field: "textLineNum", title:"多行文本行数", align:"center", width: "100px"}
    	                  ,{field: "inlineWidth", title:"查询控件高度", align:"center", width: "100px"}
    	                  ,{field: "inlineOrderNo", title:"查询顺序", align:"center", width: "100px"}
    	                  ,{field: "inlineConnector", title:"查询连接符", align:"center", width: "100px"}
    	                  ,{field: "isShowLabel", title:"显示标签", align:"center", width: "100px"}
    	                  ,{field: "isRadioInline", title:"控件内联", align:"center", width: "100px"}
    	                  ,{field: "tabIndex", title:"Tab顺序", align:"center", width: "100px"}
    	                  ,{field: "initValueType", title:"初始值类型", align:"center", width: "100px"}
    	                  ,{field: "correctType", title:"转换类型", align:"center", width: "100px"}
    	                  ,{field: "activeExpress", title:"可编辑表达式", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoFormColumnSelDialog;
})
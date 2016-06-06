


























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
    var PlatformIpfCcmBoPgLoElementSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBoPgLoElement.selectIpfCcmBoPgLoElement&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBoPgLoElement;
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
                                url: "router?appKey=000001&method=ipfCcmBoPgLoElement.selectIpfCcmBoPgLoElement&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfCcmBoPageLayoutId: { type: "string" },seqNo: { type: "string" },layoutElementType: { type: "string" },layoutBoName: { type: "string" },controlHeight: { type: "string" },controlWidth: { type: "string" },textLineNum: { type: "string" },controlConnector: { type: "string" },isNotNull: { type: "string" },isReadOnly: { type: "string" },uiType: { type: "string" },isVisible: { type: "string" },columnStyle: { type: "string" },lableStyle: { type: "string" },isShowLable: { type: "string" },isInline: { type: "string" },tabIndex: { type: "string" },defaultValue: { type: "string" },initValueType: { type: "string" },correctType: { type: "string" },conditionType: { type: "string" },operation: { type: "string" },queryType: { type: "string" },rangeType: { type: "string" },methodName: { type: "string" },propertyName: { type: "string" }
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
    	                  ,{field: "ipfCcmBoPageLayoutId", title:"页面布局", align:"center", width: "100px"}
    	                  ,{field: "seqNo", title:"序号", align:"center", width: "100px"}
    	                  ,{field: "layoutElementType", title:"页面布局元素类型", align:"center", width: "100px"}
    	                  ,{field: "layoutBoName", title:"页面布局业务对象名称", align:"center", width: "100px"}
    	                  ,{field: "controlHeight", title:"控件高度", align:"center", width: "100px"}
    	                  ,{field: "controlWidth", title:"控件宽度", align:"center", width: "100px"}
    	                  ,{field: "textLineNum", title:"多行文本行数", align:"center", width: "100px"}
    	                  ,{field: "controlConnector", title:"连接符", align:"center", width: "100px"}
    	                  ,{field: "isNotNull", title:"非空", align:"center", width: "100px"}
    	                  ,{field: "isReadOnly", title:"只读", align:"center", width: "100px"}
    	                  ,{field: "uiType", title:"控件类型", align:"center", width: "100px"}
    	                  ,{field: "isVisible", title:"可见", align:"center", width: "100px"}
    	                  ,{field: "columnStyle", title:"列样式", align:"center", width: "100px"}
    	                  ,{field: "lableStyle", title:"标签样式", align:"center", width: "100px"}
    	                  ,{field: "isShowLable", title:"显示标签", align:"center", width: "100px"}
    	                  ,{field: "isInline", title:"控件内联", align:"center", width: "100px"}
    	                  ,{field: "tabIndex", title:"Tab顺序", align:"center", width: "100px"}
    	                  ,{field: "defaultValue", title:"默认值", align:"center", width: "100px"}
    	                  ,{field: "initValueType", title:"初始值类型", align:"center", width: "100px"}
    	                  ,{field: "correctType", title:"转换类型", align:"center", width: "100px"}
    	                  ,{field: "conditionType", title:"查询条件类型", align:"center", width: "100px"}
    	                  ,{field: "operation", title:"操作符", align:"center", width: "100px"}
    	                  ,{field: "queryType", title:"查询类型", align:"center", width: "100px"}
    	                  ,{field: "rangeType", title:"区间类型", align:"center", width: "100px"}
    	                  ,{field: "methodName", title:"方法名称", align:"center", width: "100px"}
    	                  ,{field: "propertyName", title:"属性名", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoPgLoElementSelDialog;
})
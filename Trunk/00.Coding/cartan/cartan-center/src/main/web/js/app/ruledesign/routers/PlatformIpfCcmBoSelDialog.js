

































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
    var PlatformIpfCcmBoSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfCcmBo.selectIpfCcmBo&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfCcmBo;
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
                                url: "router?appKey=000001&method=ipfCcmBo.selectIpfCcmBo&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },boName: { type: "string" },boType: { type: "string" },appModule: { type: "string" },serviceType: { type: "string" },javaPath: { type: "string" },serviceCategory: { type: "string" },tableName: { type: "string" },tableType: { type: "string" },description: { type: "string" },searchColumns: { type: "string" },searchMode: { type: "string" },pageSize: { type: "string" },ipfCcmUiLayoutId: { type: "string" },uiLayoutName: { type: "string" },formCellMode: { type: "string" },uiTemplate: { type: "string" },formColumns: { type: "string" },gridStyle: { type: "string" },gridAlign: { type: "string" },gridEditType: { type: "string" },generateOption: { type: "string" },lockRowExpress: { type: "string" },gridType: { type: "string" },isMainObject: { type: "string" },isInitDataBo: { type: "string" },isAutoLoad: { type: "string" },isNeedAdvSearch: { type: "string" },needPaging: { type: "string" },isGridFilter: { type: "string" },isGridCustom: { type: "string" },remark: { type: "string" },whereClause: { type: "string" },idGenerator: { type: "string" }
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
    	                  ,{field: "boName", title:"业务对象名", align:"center", width: "100px"}
    	                  ,{field: "boType", title:"对象类型", align:"center", width: "100px"}
    	                  ,{field: "appModule", title:"功能模块", align:"center", width: "100px"}
    	                  ,{field: "serviceType", title:"服务类型", align:"center", width: "100px"}
    	                  ,{field: "javaPath", title:"JAVA路径", align:"center", width: "100px"}
    	                  ,{field: "serviceCategory", title:"服务分类", align:"center", width: "100px"}
    	                  ,{field: "tableName", title:"表名", align:"center", width: "100px"}
    	                  ,{field: "tableType", title:"表类型", align:"center", width: "100px"}
    	                  ,{field: "description", title:"描述", align:"center", width: "100px"}
    	                  ,{field: "searchColumns", title:"查询条件列数", align:"center", width: "100px"}
    	                  ,{field: "searchMode", title:"查询模式", align:"center", width: "100px"}
    	                  ,{field: "pageSize", title:"每页记录", align:"center", width: "100px"}
    	                  ,{field: "ipfCcmUiLayoutId", title:"界面布局ID", align:"center", width: "100px"}
    	                  ,{field: "uiLayoutName", title:"界面布局名称", align:"center", width: "100px"}
    	                  ,{field: "formCellMode", title:"界面模式", align:"center", width: "100px"}
    	                  ,{field: "uiTemplate", title:"界面模板", align:"center", width: "100px"}
    	                  ,{field: "formColumns", title:"每行列数", align:"center", width: "100px"}
    	                  ,{field: "gridStyle", title:"表格样式", align:"center", width: "100px"}
    	                  ,{field: "gridAlign", title:"表格列对齐", align:"center", width: "100px"}
    	                  ,{field: "gridEditType", title:"表格维护方式", align:"center", width: "100px"}
    	                  ,{field: "generateOption", title:"代码生成选项", align:"center", width: "100px"}
    	                  ,{field: "lockRowExpress", title:"行锁定表达式", align:"center", width: "100px"}
    	                  ,{field: "gridType", title:"表格类型", align:"center", width: "100px"}
    	                  ,{field: "isMainObject", title:"主对象", align:"center", width: "100px"}
    	                  ,{field: "isInitDataBo", title:"初始化数据对象", align:"center", width: "100px"}
    	                  ,{field: "isAutoLoad", title:"自动查询", align:"center", width: "100px"}
    	                  ,{field: "isNeedAdvSearch", title:"需高级查询", align:"center", width: "100px"}
    	                  ,{field: "needPaging", title:"表格分页", align:"center", width: "100px"}
    	                  ,{field: "isGridFilter", title:"表格列筛选", align:"center", width: "100px"}
    	                  ,{field: "isGridCustom", title:"表格列定义", align:"center", width: "100px"}
    	                  ,{field: "remark", title:"备注", align:"center", width: "100px"}
    	                  ,{field: "whereClause", title:"WHERE条件", align:"center", width: "100px"}
    	                  ,{field: "idGenerator", title:"ID生成器名称", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfCcmBoSelDialog;
})
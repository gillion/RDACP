





















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
    var PlatformIpfPoiSettingSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfPoiSetting.selectIpfPoiSetting&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfPoiSetting;
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
                                url: "router?appKey=000001&method=ipfPoiSetting.selectIpfPoiSetting&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },boName: { type: "string" },poiType: { type: "string" },templateFileName: { type: "string" },templateUrl: { type: "string" },fileName: { type: "string" },sourceService: { type: "string" },className: { type: "string" },templateExtName: { type: "string" },ruleNo: { type: "string" },dictName: { type: "string" },dealService: { type: "string" },methodeName: { type: "string" },isAsync: { type: "string" },asyncPageSize: { type: "string" },template: { type: "string" },templateFileKey: { type: "string" },primaryColumns: { type: "string" },childrenTable: { type: "string" },sortExpress: { type: "string" },allowParameter: { type: "string" },ipfDefineColumn: { type: "string" }
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
    	                  ,{field: "boName", title:"业务对象名称", align:"center", width: "100px"}
    	                  ,{field: "poiType", title:"导入导出类型", align:"center", width: "100px"}
    	                  ,{field: "templateFileName", title:"模板文件名称", align:"center", width: "100px"}
    	                  ,{field: "templateUrl", title:"模板地址", align:"center", width: "100px"}
    	                  ,{field: "fileName", title:"导入导出文件名", align:"center", width: "100px"}
    	                  ,{field: "sourceService", title:"请求数据路径", align:"center", width: "100px"}
    	                  ,{field: "className", title:"POI对象全名", align:"center", width: "100px"}
    	                  ,{field: "templateExtName", title:"模板文件扩展名", align:"center", width: "100px"}
    	                  ,{field: "ruleNo", title:"导入规则号", align:"center", width: "100px"}
    	                  ,{field: "dictName", title:"数据字典路径", align:"center", width: "100px"}
    	                  ,{field: "dealService", title:"结果处理服务", align:"center", width: "100px"}
    	                  ,{field: "methodeName", title:"结果处理服务方法名", align:"center", width: "100px"}
    	                  ,{field: "isAsync", title:"是否异步下载", align:"center", width: "100px"}
    	                  ,{field: "asyncPageSize", title:"异步每页行数", align:"center", width: "100px"}
    	                  ,{field: "template", title:"模板内容", align:"center", width: "100px"}
    	                  ,{field: "templateFileKey", title:"模板文件KEY", align:"center", width: "100px"}
    	                  ,{field: "primaryColumns", title:"主键指定", align:"center", width: "100px"}
    	                  ,{field: "childrenTable", title:"子表信息定义类", align:"center", width: "100px"}
    	                  ,{field: "sortExpress", title:"排序表达式", align:"center", width: "100px"}
    	                  ,{field: "allowParameter", title:"是否接收参数", align:"center", width: "100px"}
    	                  ,{field: "ipfDefineColumn", title:"导入字段定义", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfPoiSettingSelDialog;
})
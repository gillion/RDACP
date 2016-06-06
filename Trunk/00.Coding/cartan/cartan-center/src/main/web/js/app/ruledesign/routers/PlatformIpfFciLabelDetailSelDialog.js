








/**
 * 选择窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "utils/Log",
    "grid/SimpleListUtil",
        "js/app/ruledesign/routers/PlatformIpfFciViewSelDialog",
        "js/app/ruledesign/routers/PlatformIpfFciLabelSelDialog",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log, SimpleListUtil,
		PlatformIpfFciViewSelDialog,
		PlatformIpfFciLabelSelDialog,
		AjaxEngine){	
    var PlatformIpfFciLabelDetailSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfFciLabelDetail.selectIpfFciLabelDetail&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfFciLabelDetail;
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
                                url: "router?appKey=000001&method=ipfFciLabelDetail.selectIpfFciLabelDetail&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ipfFciLabelId: { type: "string" },ipfFciViewId: { type: "string" },configItemType: { type: "string" },configItemCode: { type: "string" },configItemId: { type: "string" },revisionNumber: { type: "string" },relationMemberId: { type: "string" },isActive: { type: "string" }
                            }
                            },
                            parse: function(response) {
                                return response;
                            },
                            //返回的数据
                            data: function(response) {
                                var result = response["resultJson"];

                                if($.isArray(result)){
                                    var data = null;
                                    for(var i= 0, count=result.length; i<count; i++){
                                        data = result[i];
                                        data["IpfFciViewName"] = PlatformIpfFciViewSelDialog.codetodes(data["ipfFciViewId"]);
                                        data["IpfFciLabelName"] = PlatformIpfFciLabelSelDialog.codetodes(data["ipfFciLabelId"]);
                                		data["isActiveName"] = SimpleListUtil.getSelectDes("T014", data["isActive"]);
                                    }
                                }
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

                      		,{field: "ipfFciLabelId", title:"基线", hidden:"true", align:"center", width: "100px"}
                      		,{field: "IpfFciLabelName", title:"基线", align:"center", width: "100px"}
    	                  

                      		,{field: "ipfFciViewId", title:"视图", hidden:"true", align:"center", width: "100px"}
                      		,{field: "IpfFciViewName", title:"视图", align:"center", width: "100px"}
    	                  

                      		,{field: "configItemType", title:"配置项名称", align:"center", width: "100px"}
    	                  

                      		,{field: "configItemCode", title:"配置项代码", align:"center", width: "100px"}
    	                  

                      		,{field: "configItemId", title:"配置项ID", align:"center", width: "100px"}
    	                  

                      		,{field: "revisionNumber", title:"修订号", align:"center", width: "100px"}
    	                  

                      		,{field: "relationMemberId", title:"关联成员", align:"center", width: "100px"}
    	                  

                      		,{field: "isActive", title:"启用", hidden:"true", align:"center", width: "100px"}
                      		,{field: "isActiveName", title:"启用", align:"center", width: "100px"}
    	                  
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfFciLabelDetailSelDialog;
})
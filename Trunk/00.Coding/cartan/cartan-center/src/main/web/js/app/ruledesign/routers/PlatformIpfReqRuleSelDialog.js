


















/**
 * 选择窗口
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["jquery",
    "utils/Log",
    "grid/SimpleListUtil",
        "js/app/ruledesign/routers/PlatformIpfCcmBoSelDialog",
    "rpc/AjaxEngine",
    "utils/common"
], function($, Log, SimpleListUtil,
		PlatformIpfCcmBoSelDialog,
		AjaxEngine){	
    var PlatformIpfReqRuleSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=ipfReqRule.selectIpfReqRule&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].IpfReqRule;
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
                                url: "router?appKey=000001&method=ipfReqRule.selectIpfReqRule&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },ruleName: { type: "string" },ruleNo: { type: "string" },ruleType: { type: "string" },ruleStatus: { type: "string" },triggerType: { type: "string" },physicalLocation: { type: "string" },actionType: { type: "string" },businessLocation: { type: "string" },businessModule: { type: "string" },droolsAttribute: { type: "string" },ruleDesc: { type: "string" },isDecisionTable: { type: "string" },publicType: { type: "string" },ipfCcmBoId: { type: "string" },importDesc: { type: "string" },droolsWhen: { type: "string" },droolsThen: { type: "string" },remark: { type: "string" }
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
                                        data["IpfCcmBoName"] = PlatformIpfCcmBoSelDialog.codetodes(data["ipfCcmBoId"]);
                                		data["triggerTypeName"] = SimpleListUtil.getSelectDes("T009", data["triggerType"]);
                                		data["actionTypeName"] = SimpleListUtil.getSelectDes("T010", data["actionType"]);
                                		data["ruleTypeName"] = SimpleListUtil.getSelectDes("T008", data["ruleType"]);
                                		data["ruleStatusName"] = SimpleListUtil.getSelectDes("T006", data["ruleStatus"]);
                                		data["publicTypeName"] = SimpleListUtil.getSelectDes("T007", data["publicType"]);
                                		data["isDecisionTableName"] = SimpleListUtil.getSelectDes("T014", data["isDecisionTable"]);
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

                      		,{field: "ruleName", title:"规则名称", align:"center", width: "100px"}
    	                  

                      		,{field: "ruleNo", title:"规则号", align:"center", width: "100px"}
    	                  

                      		,{field: "ruleType", title:"规则类型", hidden:"true", align:"center", width: "100px"}
                      		,{field: "ruleTypeName", title:"规则类型", align:"center", width: "100px"}
    	                  

                      		,{field: "ruleStatus", title:"规则状态", hidden:"true", align:"center", width: "100px"}
                      		,{field: "ruleStatusName", title:"规则状态", align:"center", width: "100px"}
    	                  

                      		,{field: "triggerType", title:"触发类型", hidden:"true", align:"center", width: "100px"}
                      		,{field: "triggerTypeName", title:"触发类型", align:"center", width: "100px"}
    	                  

                      		,{field: "physicalLocation", title:"所处物理位置", align:"center", width: "100px"}
    	                  

                      		,{field: "actionType", title:"动作类型", hidden:"true", align:"center", width: "100px"}
                      		,{field: "actionTypeName", title:"动作类型", align:"center", width: "100px"}
    	                  

                      		,{field: "businessLocation", title:"所处业务位置", align:"center", width: "100px"}
    	                  

                      		,{field: "businessModule", title:"业务模块", align:"center", width: "100px"}
    	                  

                      		,{field: "droolsAttribute", title:"规则属性", align:"center", width: "100px"}
    	                  

                      		,{field: "ruleDesc", title:"规则描述", align:"center", width: "100px"}
    	                  

                      		,{field: "isDecisionTable", title:"是否使用决策表", hidden:"true", align:"center", width: "100px"}
                      		,{field: "isDecisionTableName", title:"是否使用决策表", align:"center", width: "100px"}
    	                  

                      		,{field: "publicType", title:"共享类型", hidden:"true", align:"center", width: "100px"}
                      		,{field: "publicTypeName", title:"共享类型", align:"center", width: "100px"}
    	                  

                      		,{field: "ipfCcmBoId", title:"业务对象", hidden:"true", align:"center", width: "100px"}
                      		,{field: "IpfCcmBoName", title:"业务对象", align:"center", width: "100px"}
    	                  

                      		,{field: "importDesc", title:"传参说明", align:"center", width: "100px"}
    	                  

                      		,{field: "droolsWhen", title:"DROOLS条件", align:"center", width: "100px"}
    	                  

                      		,{field: "droolsThen", title:"DROOLS动作", align:"center", width: "100px"}
    	                  

                      		,{field: "remark", title:"备注", align:"center", width: "100px"}
    	                  
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformIpfReqRuleSelDialog;
})
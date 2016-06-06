
		

		

		

		

		

		

		

		

		

		
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
    var PlatformGroupActionSelDialog = {
    		codetodes: function(id){
		        var result;
		        var resstr="";
                if (id==""){
                    return resstr;
                } else {
		        new AjaxEngine("router?appKey=000001&method=groupAction.selectGroupAction&v=1.0&format=json",
		            {
		                async: false,
		                data:{id: id},
		                dataType: 'json',
		                complete: function(transport){
		                    result = transport.responseText;
		                    result = $.parseJSON(result);
                            if (result.resultJson.length>0){
                                resstr = result.resultJson[0].name;
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
                                url: "router?appKey=000001&method=groupAction.selectGroupAction&v=1.0&format=json"
                            }
                        },
                        pageSize: 10,                     //默认分页是每页10条记录
                        schema: {
                            model: {
                                fields: {
                    		id: { type: "string" },name: { type: "string" },begintime: { type: "string" },endtime: { type: "string" },addr: { type: "string" },leadings: { type: "string" },memoinfo: { type: "string" },mincount: { type: "string" },budget: { type: "string" },spending: { type: "string" }
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
    	                  {field: "id", title:"活动编号", hidden:"true", align:"center", width: "100px"}
    	                  ,{field: "name", title:"活动名称", align:"center", width: "100px"}
    	                  ,{field: "begintime", title:"开始时间", align:"center", width: "100px"}
    	                  ,{field: "endtime", title:"结束时间", align:"center", width: "100px"}
    	                  ,{field: "addr", title:"活动地址", align:"center", width: "100px"}
    	                  ,{field: "leadings", title:"活动负责", align:"center", width: "100px"}
    	                  ,{field: "memoinfo", title:"活动备注", align:"center", width: "100px"}
    	                  ,{field: "mincount", title:"最少人数", align:"center", width: "100px"}
    	                  ,{field: "budget", title:"人均预算", align:"center", width: "100px"}
    	                  ,{field: "spending", title:"结算总额", align:"center", width: "100px"}
                    ]
                });
                return  detailgrid;
            }
    }
    return PlatformGroupActionSelDialog;
})

/**
 * 对公费用核算
 *
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
define(["types/Class",
    "utils/Log",
    "jquery",
    "base/BaseRouter",
    "base/BaseView",
    "grid/simplelist",
    "grid/SimpleListUtil",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		AjaxEngine){    
	
    
    function showEditDetilDialog(tp, titles, id, url, content){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, 190, titles);
    	
        
        if (tp==1){
        $("#submitBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),syear: $("#syear").val(),smonth: $("#smonth").val(),dept: $("#dept").val(),cusManagerid: $("#cusManagerid").val(),cusManagername: $("#cusManagername").val(),balanceavg: $("#balanceavg").val(),changMoney: $("#changMoney").val(),changeMemo: $("#changeMemo").val(),changeAfterAvg: $("#changeAfterAvg").val(),creditMoney: $("#creditMoney").val(),creditDeposit: $("#creditDeposit").val(),discountDeposit: $("#discountDeposit").val(),depositTask: $("#depositTask").val(),depositHistory: $("#depositHistory").val(),deposit: $("#deposit").val(),incremental: $("#incremental").val(),cost: $("#cost").val(),creditChangMoney: $("#creditChangMoney").val(),creditChangMoneyReq: $("#creditChangMoneyReq").val(),creditAfterMoney: $("#creditAfterMoney").val(),creditChangDeposit: $("#creditChangDeposit").val(),creditAfterDeposit: $("#creditAfterDeposit").val()},
                    dataType: 'json',
                    complete: function(transport){
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("操作成功！");
                        kendoUIWindow.close();
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                    }
                }
            );
        });
    	} else{
        $("#QueryBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),syear: $("#syear").val(),smonth: $("#smonth").val(),dept: $("#dept").val(),cusManagerid: $("#cusManagerid").val(),cusManagername: $("#cusManagername").val(),balanceavg: $("#balanceavg").val(),changMoney: $("#changMoney").val(),changeMemo: $("#changeMemo").val(),changeAfterAvg: $("#changeAfterAvg").val(),creditMoney: $("#creditMoney").val(),creditDeposit: $("#creditDeposit").val(),discountDeposit: $("#discountDeposit").val(),depositTask: $("#depositTask").val(),depositHistory: $("#depositHistory").val(),deposit: $("#deposit").val(),incremental: $("#incremental").val(),cost: $("#cost").val(),creditChangMoney: $("#creditChangMoney").val(),creditChangMoneyReq: $("#creditChangMoneyReq").val(),creditAfterMoney: $("#creditAfterMoney").val(),creditChangDeposit: $("#creditChangDeposit").val(),creditAfterDeposit: $("#creditAfterDeposit").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];

                            }
                        }
                        
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.data([]);
                        table0.dataSource.data(result.resultJson);
                        kendoUIWindow.close();
                    }
                }
            );
        });
    	}
        SimpleListUtil.setDataTimeCn();

        
    }
    
    var PlatformJxkhCorptotalFyManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhCorptotalFy_manage": "showPlatformJxkhCorptotalFyManageList",  
            "basic_manage/platform_ckJxkhCorptotalFy_manage": "showPlatformckJxkhCorptotalFyManageList"
        },
        showPlatformckJxkhCorptotalFyManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhCorptotalFyManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhCorptotalFyManageListView = new SimpleListView({
                id: "platform_jxkhCorptotalFy_manage_list",
                title: "基础管理 > 对公费用核算",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("对公费用核算");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsyear' align='right'>年：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='syear' name='年' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsmonth' align='right'>月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='smonth' name='月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldept' align='right'>部门：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dept' name='部门' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusManagerid' align='right'>客户经理ID：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusManagerid' name='客户经理ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusManagername' align='right'>客户经理名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusManagername' name='客户经理名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavg' align='right'>存款日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavg' name='存款日均' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchangMoney' align='right'>调整数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='changMoney' name='调整数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchangeMemo' align='right'>调整备注详情：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='changeMemo' name='调整备注详情' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchangeAfterAvg' align='right'>调整后日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='changeAfterAvg' name='调整后日均' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditMoney' align='right'>授信金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditMoney' name='授信金额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditDeposit' align='right'>授信户存款：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditDeposit' name='授信户存款' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldiscountDeposit' align='right'>折后存款：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='discountDeposit' name='折后存款' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldepositTask' align='right'>存款任务：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='depositTask' name='存款任务' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldepositHistory' align='right'>历史存量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='depositHistory' name='历史存量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldeposit' align='right'>存量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='deposit' name='存量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincremental' align='right'>增量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incremental' name='增量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcost' align='right'>费用：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cost' name='费用' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditChangMoney' align='right'>授信调整金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditChangMoney' name='授信调整金额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditChangMoneyReq' align='right'>授信调整数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditChangMoneyReq' name='授信调整数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditAfterMoney' align='right'>授信调整后金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditAfterMoney' name='授信调整后金额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditChangDeposit' align='right'>授信户存款调整金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditChangDeposit' name='授信户存款调整金额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditAfterDeposit' align='right'>授信户存款调整金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditAfterDeposit' name='授信户存款调整金额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalFy.createJxkhCorptotalFy&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhCorptotalFyManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhCorptotalFyManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhCorptotalFyManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalFy.deleteJxkhCorptotalFy&v=1.0&format=json",
                            {
                                async: false,
                                data:{id: ID},
                                dataType: 'json',
                                complete: function(transport){
                                    result = transport.responseText;
                                    result = $.parseJSON(result);
                                	}
                            	}
                            );
                        }
                        alert("删除成功！");
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                        } else {
                            alert("请先选择记录！");
                        }
                    }, "delete");
                    this.addToolbarBtn("queryBtn", "查 询", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsyear' align='right'>年：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='syear' name='年' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsmonth' align='right'>月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='smonth' name='月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldept' align='right'>部门：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dept' name='部门' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusManagerid' align='right'>客户经理ID：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusManagerid' name='客户经理ID' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusManagername' align='right'>客户经理名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusManagername' name='客户经理名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavg' align='right'>存款日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavg' name='存款日均' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchangMoney' align='right'>调整数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='changMoney' name='调整数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchangeMemo' align='right'>调整备注详情：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='changeMemo' name='调整备注详情' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchangeAfterAvg' align='right'>调整后日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='changeAfterAvg' name='调整后日均' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditMoney' align='right'>授信金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditMoney' name='授信金额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditDeposit' align='right'>授信户存款：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditDeposit' name='授信户存款' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldiscountDeposit' align='right'>折后存款：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='discountDeposit' name='折后存款' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldepositTask' align='right'>存款任务：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='depositTask' name='存款任务' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldepositHistory' align='right'>历史存量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='depositHistory' name='历史存量' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldeposit' align='right'>存量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='deposit' name='存量' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincremental' align='right'>增量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incremental' name='增量' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcost' align='right'>费用：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cost' name='费用' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditChangMoney' align='right'>授信调整金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditChangMoney' name='授信调整金额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditChangMoneyReq' align='right'>授信调整数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditChangMoneyReq' name='授信调整数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditAfterMoney' align='right'>授信调整后金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditAfterMoney' name='授信调整后金额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditChangDeposit' align='right'>授信户存款调整金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditChangDeposit' name='授信户存款调整金额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreditAfterDeposit' align='right'>授信户存款调整金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='creditAfterDeposit' name='授信户存款调整金额' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalFy.selectJxkhCorptotalFy&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalFy.selectJxkhCorptotalFy&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },syear: { type: "string" },smonth: { type: "string" },dept: { type: "string" },cusManagerid: { type: "string" },cusManagername: { type: "string" },balanceavg: { type: "string" },changMoney: { type: "string" },changeMemo: { type: "string" },changeAfterAvg: { type: "string" },creditMoney: { type: "string" },creditDeposit: { type: "string" },discountDeposit: { type: "string" },depositTask: { type: "string" },depositHistory: { type: "string" },deposit: { type: "string" },incremental: { type: "string" },cost: { type: "string" },creditChangMoney: { type: "string" },creditChangMoneyReq: { type: "string" },creditAfterMoney: { type: "string" },creditChangDeposit: { type: "string" },creditAfterDeposit: { type: "string" }
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


                                }
                            }
                            result = platformJxkhCorptotalFyManageListView.appendColValue(result);
                            return result;
                        },
                        //记录条数
                        total: function(response) {
                            var result = response["total"] || response["resultJson"].length;
                            return result;
                        }
                    }
                },
                columns: [
                          {field: "chk", type:"chk", title: "&nbsp;", value:"ID"},
                          {field: "id", title:"编号", hidden:"true", align:"center", width: "100px"},

    						
                    		{field: "syear", title:"年", align:"center", width: "100px"},

    						
                    		{field: "smonth", title:"月", align:"center", width: "100px"},

    						
                    		{field: "dept", title:"部门", align:"center", width: "100px"},

    						
                    		{field: "cusManagerid", title:"客户经理ID", align:"center", width: "100px"},

    						
                    		{field: "cusManagername", title:"客户经理名称", align:"center", width: "100px"},

    						
                    		{field: "balanceavg", title:"存款日均", align:"center", width: "100px"},

    						
                    		{field: "changMoney", title:"调整数", align:"center", width: "100px"},

    						
                    		{field: "changeMemo", title:"调整备注详情", align:"center", width: "100px"},

    						
                    		{field: "changeAfterAvg", title:"调整后日均", align:"center", width: "100px"},

    						
                    		{field: "creditMoney", title:"授信金额", align:"center", width: "100px"},

    						
                    		{field: "creditDeposit", title:"授信户存款", align:"center", width: "100px"},

    						
                    		{field: "discountDeposit", title:"折后存款", align:"center", width: "100px"},

    						
                    		{field: "depositTask", title:"存款任务", align:"center", width: "100px"},

    						
                    		{field: "depositHistory", title:"历史存量", align:"center", width: "100px"},

    						
                    		{field: "deposit", title:"存量", align:"center", width: "100px"},

    						
                    		{field: "incremental", title:"增量", align:"center", width: "100px"},

    						
                    		{field: "cost", title:"费用", align:"center", width: "100px"},

    						
                    		{field: "creditChangMoney", title:"授信调整金额", align:"center", width: "100px"},

    						
                    		{field: "creditChangMoneyReq", title:"授信调整数", align:"center", width: "100px"},

    						
                    		{field: "creditAfterMoney", title:"授信调整后金额", align:"center", width: "100px"},

    						
                    		{field: "creditChangDeposit", title:"授信户存款调整金额", align:"center", width: "100px"},

    						
                    		{field: "creditAfterDeposit", title:"授信户存款调整金额", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhCorptotalFyManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhCorptotalFyManageListView.get("columns");
                                var col = null;
                                var colName = null;
                                var value = null;
                                var ColumnValue = {};
                                for(var i= 0, colCount=columnArray.length; i<colCount; i++){
                                    col = columnArray[i];
                                    colName = col.field;
                                    value = SimpleListUtil.getSelectedColumnValue(this, colName);
                                    ColumnValue[colName] = value;
                                }

                                var detailstr="";
                                detailstr+="<div id='content' align='center'>";
                                detailstr+="<table>";
                                detailstr+="<input id='id' name='编号' hidden='true' value='"+ColumnValue["id"]+"' style='...'/>";

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsyear' align='right'>年：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='syear' name='年' value='"+ColumnValue["syear"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsmonth' align='right'>月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='smonth' name='月' value='"+ColumnValue["smonth"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldept' align='right'>部门：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dept' name='部门' value='"+ColumnValue["dept"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcusManagerid' align='right'>客户经理ID：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cusManagerid' name='客户经理ID' value='"+ColumnValue["cusManagerid"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcusManagername' align='right'>客户经理名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cusManagername' name='客户经理名称' value='"+ColumnValue["cusManagername"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceavg' align='right'>存款日均：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavg' name='存款日均' value='"+ColumnValue["balanceavg"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lchangMoney' align='right'>调整数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='changMoney' name='调整数' value='"+ColumnValue["changMoney"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lchangeMemo' align='right'>调整备注详情：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='changeMemo' name='调整备注详情' value='"+ColumnValue["changeMemo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lchangeAfterAvg' align='right'>调整后日均：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='changeAfterAvg' name='调整后日均' value='"+ColumnValue["changeAfterAvg"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreditMoney' align='right'>授信金额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='creditMoney' name='授信金额' value='"+ColumnValue["creditMoney"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreditDeposit' align='right'>授信户存款：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='creditDeposit' name='授信户存款' value='"+ColumnValue["creditDeposit"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldiscountDeposit' align='right'>折后存款：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='discountDeposit' name='折后存款' value='"+ColumnValue["discountDeposit"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldepositTask' align='right'>存款任务：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='depositTask' name='存款任务' value='"+ColumnValue["depositTask"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldepositHistory' align='right'>历史存量：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='depositHistory' name='历史存量' value='"+ColumnValue["depositHistory"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldeposit' align='right'>存量：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='deposit' name='存量' value='"+ColumnValue["deposit"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lincremental' align='right'>增量：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='incremental' name='增量' value='"+ColumnValue["incremental"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcost' align='right'>费用：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cost' name='费用' value='"+ColumnValue["cost"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreditChangMoney' align='right'>授信调整金额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='creditChangMoney' name='授信调整金额' value='"+ColumnValue["creditChangMoney"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreditChangMoneyReq' align='right'>授信调整数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='creditChangMoneyReq' name='授信调整数' value='"+ColumnValue["creditChangMoneyReq"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreditAfterMoney' align='right'>授信调整后金额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='creditAfterMoney' name='授信调整后金额' value='"+ColumnValue["creditAfterMoney"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreditChangDeposit' align='right'>授信户存款调整金额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='creditChangDeposit' name='授信户存款调整金额' value='"+ColumnValue["creditChangDeposit"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreditAfterDeposit' align='right'>授信户存款调整金额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='creditAfterDeposit' name='授信户存款调整金额' value='"+ColumnValue["creditAfterDeposit"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalFy.updateJxkhCorptotalFy&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhCorptotalFyManageListView);
        }
    });

    return PlatformJxkhCorptotalFyManageRouter;
});

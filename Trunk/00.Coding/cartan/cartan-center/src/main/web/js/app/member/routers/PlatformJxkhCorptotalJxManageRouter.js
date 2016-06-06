
/**
 * 对公绩效核算
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
                    data:{id: $("#id").val(),syear: $("#syear").val(),smonth: $("#smonth").val(),stype: $("#stype").val(),dept: $("#dept").val(),cusManagerid: $("#cusManagerid").val(),cusManagername: $("#cusManagername").val(),groupLevel: $("#groupLevel").val(),incomeDate: $("#incomeDate").val(),blanceavgBase: $("#blanceavgBase").val(),blanceavgBaseChg: $("#blanceavgBaseChg").val(),blanceavgBaseFina: $("#blanceavgBaseFina").val(),balanceavgYear: $("#balanceavgYear").val(),lcMoney: $("#lcMoney").val(),addMoneyChg: $("#addMoneyChg").val(),conMoneyChg: $("#conMoneyChg").val(),balanceavgRmb: $("#balanceavgRmb").val(),balanceavgWb: $("#balanceavgWb").val(),balanceavgWbChg: $("#balanceavgWbChg").val(),balanceavgWbFina: $("#balanceavgWbFina").val(),balanceavgAll: $("#balanceavgAll").val(),baseResult: $("#baseResult").val(),balanceavgIncremental: $("#balanceavgIncremental").val(),monthTask: $("#monthTask").val(),incrementalTime: $("#incrementalTime").val(),lastResult: $("#lastResult").val(),groupStatus: $("#groupStatus").val()},
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
                    data:{id: $("#id").val(),syear: $("#syear").val(),smonth: $("#smonth").val(),stype: $("#stype").val(),dept: $("#dept").val(),cusManagerid: $("#cusManagerid").val(),cusManagername: $("#cusManagername").val(),groupLevel: $("#groupLevel").val(),incomeDate: $("#incomeDate").val(),blanceavgBase: $("#blanceavgBase").val(),blanceavgBaseChg: $("#blanceavgBaseChg").val(),blanceavgBaseFina: $("#blanceavgBaseFina").val(),balanceavgYear: $("#balanceavgYear").val(),lcMoney: $("#lcMoney").val(),addMoneyChg: $("#addMoneyChg").val(),conMoneyChg: $("#conMoneyChg").val(),balanceavgRmb: $("#balanceavgRmb").val(),balanceavgWb: $("#balanceavgWb").val(),balanceavgWbChg: $("#balanceavgWbChg").val(),balanceavgWbFina: $("#balanceavgWbFina").val(),balanceavgAll: $("#balanceavgAll").val(),baseResult: $("#baseResult").val(),balanceavgIncremental: $("#balanceavgIncremental").val(),monthTask: $("#monthTask").val(),incrementalTime: $("#incrementalTime").val(),lastResult: $("#lastResult").val(),groupStatus: $("#groupStatus").val()},
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
    
    var PlatformJxkhCorptotalJxManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhCorptotalJx_manage": "showPlatformJxkhCorptotalJxManageList",  
            "basic_manage/platform_ckJxkhCorptotalJx_manage": "showPlatformckJxkhCorptotalJxManageList"
        },
        showPlatformckJxkhCorptotalJxManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhCorptotalJxManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhCorptotalJxManageListView = new SimpleListView({
                id: "platform_jxkhCorptotalJx_manage_list",
                title: "基础管理 > 对公绩效核算",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("对公绩效核算");
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
                        detailstr+="<label id='lstype' align='right'>类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='stype' name='类别' style='...'/>";
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
                        detailstr+="<label id='lgroupLevel' align='right'>级别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupLevel' name='级别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincomeDate' align='right'>入职日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incomeDate' name='入职日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lblanceavgBase' align='right'>基数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='blanceavgBase' name='基数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lblanceavgBaseChg' align='right'>基数调整数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='blanceavgBaseChg' name='基数调整数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lblanceavgBaseFina' align='right'>调整后基数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='blanceavgBaseFina' name='调整后基数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgYear' align='right'>人民币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgYear' name='人民币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llcMoney' align='right'>理财：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='lcMoney' name='理财' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laddMoneyChg' align='right'>结算调整：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='addMoneyChg' name='结算调整' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconMoneyChg' align='right'>关联调整：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conMoneyChg' name='关联调整' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgRmb' align='right'>调整后人民币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgRmb' name='调整后人民币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgWb' align='right'>外币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgWb' name='外币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgWbChg' align='right'>外币调整数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgWbChg' name='外币调整数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgWbFina' align='right'>调整后外币日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgWbFina' name='调整后外币日均' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgAll' align='right'>本外币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgAll' name='本外币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbaseResult' align='right'>存量得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='baseResult' name='存量得分' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgIncremental' align='right'>增量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgIncremental' name='增量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonthTask' align='right'>本月任务：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='monthTask' name='本月任务' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincrementalTime' align='right'>增量倍数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incrementalTime' name='增量倍数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llastResult' align='right'>最终得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='lastResult' name='最终得分' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupStatus' align='right'>转正标识：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupStatus' name='转正标识' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalJx.createJxkhCorptotalJx&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhCorptotalJxManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhCorptotalJxManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhCorptotalJxManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalJx.deleteJxkhCorptotalJx&v=1.0&format=json",
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
                        detailstr+="<label id='lstype' align='right'>类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='stype' name='类别' style='...'/>";
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
                        detailstr+="<label id='lgroupLevel' align='right'>级别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupLevel' name='级别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincomeDate' align='right'>入职日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incomeDate' name='入职日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lblanceavgBase' align='right'>基数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='blanceavgBase' name='基数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lblanceavgBaseChg' align='right'>基数调整数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='blanceavgBaseChg' name='基数调整数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lblanceavgBaseFina' align='right'>调整后基数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='blanceavgBaseFina' name='调整后基数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgYear' align='right'>人民币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgYear' name='人民币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='llcMoney' align='right'>理财：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='lcMoney' name='理财' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='laddMoneyChg' align='right'>结算调整：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='addMoneyChg' name='结算调整' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconMoneyChg' align='right'>关联调整：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conMoneyChg' name='关联调整' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgRmb' align='right'>调整后人民币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgRmb' name='调整后人民币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgWb' align='right'>外币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgWb' name='外币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgWbChg' align='right'>外币调整数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgWbChg' name='外币调整数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgWbFina' align='right'>调整后外币日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgWbFina' name='调整后外币日均' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgAll' align='right'>本外币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgAll' name='本外币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbaseResult' align='right'>存量得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='baseResult' name='存量得分' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgIncremental' align='right'>增量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgIncremental' name='增量' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonthTask' align='right'>本月任务：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='monthTask' name='本月任务' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincrementalTime' align='right'>增量倍数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incrementalTime' name='增量倍数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='llastResult' align='right'>最终得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='lastResult' name='最终得分' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupStatus' align='right'>转正标识：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='groupStatus' name='转正标识' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalJx.selectJxkhCorptotalJx&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalJx.selectJxkhCorptotalJx&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },syear: { type: "string" },smonth: { type: "string" },stype: { type: "string" },dept: { type: "string" },cusManagerid: { type: "string" },cusManagername: { type: "string" },groupLevel: { type: "string" },incomeDate: { type: "string" },blanceavgBase: { type: "string" },blanceavgBaseChg: { type: "string" },blanceavgBaseFina: { type: "string" },balanceavgYear: { type: "string" },lcMoney: { type: "string" },addMoneyChg: { type: "string" },conMoneyChg: { type: "string" },balanceavgRmb: { type: "string" },balanceavgWb: { type: "string" },balanceavgWbChg: { type: "string" },balanceavgWbFina: { type: "string" },balanceavgAll: { type: "string" },baseResult: { type: "string" },balanceavgIncremental: { type: "string" },monthTask: { type: "string" },incrementalTime: { type: "string" },lastResult: { type: "string" },groupStatus: { type: "string" }
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
                            result = platformJxkhCorptotalJxManageListView.appendColValue(result);
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

    						
                    		{field: "stype", title:"类别", align:"center", width: "100px"},

    						
                    		{field: "dept", title:"部门", align:"center", width: "100px"},

    						
                    		{field: "cusManagerid", title:"客户经理ID", align:"center", width: "100px"},

    						
                    		{field: "cusManagername", title:"客户经理名称", align:"center", width: "100px"},

    						
                    		{field: "groupLevel", title:"级别", align:"center", width: "100px"},

    						
                    		{field: "incomeDate", title:"入职日期", align:"center", width: "100px"},

    						
                    		{field: "blanceavgBase", title:"基数", align:"center", width: "100px"},

    						
                    		{field: "blanceavgBaseChg", title:"基数调整数", align:"center", width: "100px"},

    						
                    		{field: "blanceavgBaseFina", title:"调整后基数", align:"center", width: "100px"},

    						
                    		{field: "balanceavgYear", title:"人民币年日均", align:"center", width: "100px"},

    						
                    		{field: "lcMoney", title:"理财", align:"center", width: "100px"},

    						
                    		{field: "addMoneyChg", title:"结算调整", align:"center", width: "100px"},

    						
                    		{field: "conMoneyChg", title:"关联调整", align:"center", width: "100px"},

    						
                    		{field: "balanceavgRmb", title:"调整后人民币年日均", align:"center", width: "100px"},

    						
                    		{field: "balanceavgWb", title:"外币年日均", align:"center", width: "100px"},

    						
                    		{field: "balanceavgWbChg", title:"外币调整数", align:"center", width: "100px"},

    						
                    		{field: "balanceavgWbFina", title:"调整后外币日均", align:"center", width: "100px"},

    						
                    		{field: "balanceavgAll", title:"本外币年日均", align:"center", width: "100px"},

    						
                    		{field: "baseResult", title:"存量得分", align:"center", width: "100px"},

    						
                    		{field: "balanceavgIncremental", title:"增量", align:"center", width: "100px"},

    						
                    		{field: "monthTask", title:"本月任务", align:"center", width: "100px"},

    						
                    		{field: "incrementalTime", title:"增量倍数", align:"center", width: "100px"},

    						
                    		{field: "lastResult", title:"最终得分", align:"center", width: "100px"},

    						
                    		{field: "groupStatus", title:"转正标识", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhCorptotalJxManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhCorptotalJxManageListView.get("columns");
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
                                detailstr+="<label id='lstype' align='right'>类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='stype' name='类别' value='"+ColumnValue["stype"]+"' style='...'/>";
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
                                detailstr+="<label id='lgroupLevel' align='right'>级别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupLevel' name='级别' value='"+ColumnValue["groupLevel"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lincomeDate' align='right'>入职日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='incomeDate' name='入职日期' value='"+ColumnValue["incomeDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lblanceavgBase' align='right'>基数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='blanceavgBase' name='基数' value='"+ColumnValue["blanceavgBase"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lblanceavgBaseChg' align='right'>基数调整数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='blanceavgBaseChg' name='基数调整数' value='"+ColumnValue["blanceavgBaseChg"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lblanceavgBaseFina' align='right'>调整后基数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='blanceavgBaseFina' name='调整后基数' value='"+ColumnValue["blanceavgBaseFina"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceavgYear' align='right'>人民币年日均：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavgYear' name='人民币年日均' value='"+ColumnValue["balanceavgYear"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llcMoney' align='right'>理财：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='lcMoney' name='理财' value='"+ColumnValue["lcMoney"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laddMoneyChg' align='right'>结算调整：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='addMoneyChg' name='结算调整' value='"+ColumnValue["addMoneyChg"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconMoneyChg' align='right'>关联调整：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='conMoneyChg' name='关联调整' value='"+ColumnValue["conMoneyChg"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceavgRmb' align='right'>调整后人民币年日均：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavgRmb' name='调整后人民币年日均' value='"+ColumnValue["balanceavgRmb"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceavgWb' align='right'>外币年日均：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavgWb' name='外币年日均' value='"+ColumnValue["balanceavgWb"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceavgWbChg' align='right'>外币调整数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavgWbChg' name='外币调整数' value='"+ColumnValue["balanceavgWbChg"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceavgWbFina' align='right'>调整后外币日均：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavgWbFina' name='调整后外币日均' value='"+ColumnValue["balanceavgWbFina"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceavgAll' align='right'>本外币年日均：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavgAll' name='本外币年日均' value='"+ColumnValue["balanceavgAll"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbaseResult' align='right'>存量得分：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='baseResult' name='存量得分' value='"+ColumnValue["baseResult"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceavgIncremental' align='right'>增量：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavgIncremental' name='增量' value='"+ColumnValue["balanceavgIncremental"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonthTask' align='right'>本月任务：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='monthTask' name='本月任务' value='"+ColumnValue["monthTask"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lincrementalTime' align='right'>增量倍数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='incrementalTime' name='增量倍数' value='"+ColumnValue["incrementalTime"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llastResult' align='right'>最终得分：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='lastResult' name='最终得分' value='"+ColumnValue["lastResult"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupStatus' align='right'>转正标识：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='groupStatus' name='转正标识' value='"+ColumnValue["groupStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhCorptotalJx.updateJxkhCorptotalJx&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhCorptotalJxManageListView);
        }
    });

    return PlatformJxkhCorptotalJxManageRouter;
});


/**
 * 对私员工绩效核算
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
                    data:{id: $("#id").val(),syear: $("#syear").val(),smonth: $("#smonth").val(),senddate: $("#senddate").val(),stype: $("#stype").val(),dept: $("#dept").val(),cusManagerid: $("#cusManagerid").val(),cusManagername: $("#cusManagername").val(),groupLevel: $("#groupLevel").val(),incomeDate: $("#incomeDate").val(),blanceavgBase: $("#blanceavgBase").val(),balanceavgAll: $("#balanceavgAll").val(),balanceavgIncremental: $("#balanceavgIncremental").val(),monthTask: $("#monthTask").val(),incrementalTime: $("#incrementalTime").val(),lastResult: $("#lastResult").val()},
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
                    data:{id: $("#id").val(),syear: $("#syear").val(),smonth: $("#smonth").val(),senddate: $("#senddate").val(),stype: $("#stype").val(),dept: $("#dept").val(),cusManagerid: $("#cusManagerid").val(),cusManagername: $("#cusManagername").val(),groupLevel: $("#groupLevel").val(),incomeDate: $("#incomeDate").val(),blanceavgBase: $("#blanceavgBase").val(),balanceavgAll: $("#balanceavgAll").val(),balanceavgIncremental: $("#balanceavgIncremental").val(),monthTask: $("#monthTask").val(),incrementalTime: $("#incrementalTime").val(),lastResult: $("#lastResult").val()},
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
    
    var PlatformJxkhPertotalJxManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhPertotalJx_manage": "showPlatformJxkhPertotalJxManageList",  
            "basic_manage/platform_ckJxkhPertotalJx_manage": "showPlatformckJxkhPertotalJxManageList"
        },
        showPlatformckJxkhPertotalJxManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhPertotalJxManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhPertotalJxManageListView = new SimpleListView({
                id: "platform_jxkhPertotalJx_manage_list",
                title: "基础管理 > 对私员工绩效核算",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("对私员工绩效核算");
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
                        detailstr+="<label id='lsenddate' align='right'>统计截止日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='senddate' name='统计截止日期' style='...'/>";
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
                        detailstr+="<label id='lbalanceavgAll' align='right'>本外币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgAll' name='本外币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgIncremental' align='right'>增量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgIncremental' name='增量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonthTask' align='right'>指标：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='monthTask' name='指标' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincrementalTime' align='right'>完成比：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incrementalTime' name='完成比' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llastResult' align='right'>得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='lastResult' name='得分' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhPertotalJx.createJxkhPertotalJx&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhPertotalJxManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhPertotalJxManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhPertotalJxManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhPertotalJx.deleteJxkhPertotalJx&v=1.0&format=json",
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
                        detailstr+="<label id='lsenddate' align='right'>统计截止日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='senddate' name='统计截止日期' style='...'/>";
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
                        detailstr+="<label id='lbalanceavgAll' align='right'>本外币年日均：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgAll' name='本外币年日均' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbalanceavgIncremental' align='right'>增量：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='balanceavgIncremental' name='增量' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonthTask' align='right'>指标：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='monthTask' name='指标' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincrementalTime' align='right'>完成比：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incrementalTime' name='完成比' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='llastResult' align='right'>得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='lastResult' name='得分' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhPertotalJx.selectJxkhPertotalJx&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhPertotalJx.selectJxkhPertotalJx&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },syear: { type: "string" },smonth: { type: "string" },senddate: { type: "string" },stype: { type: "string" },dept: { type: "string" },cusManagerid: { type: "string" },cusManagername: { type: "string" },groupLevel: { type: "string" },incomeDate: { type: "string" },blanceavgBase: { type: "string" },balanceavgAll: { type: "string" },balanceavgIncremental: { type: "string" },monthTask: { type: "string" },incrementalTime: { type: "string" },lastResult: { type: "string" }
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
                            result = platformJxkhPertotalJxManageListView.appendColValue(result);
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

    						
                    		{field: "senddate", title:"统计截止日期", align:"center", width: "100px"},

    						
                    		{field: "stype", title:"类别", align:"center", width: "100px"},

    						
                    		{field: "dept", title:"部门", align:"center", width: "100px"},

    						
                    		{field: "cusManagerid", title:"客户经理ID", align:"center", width: "100px"},

    						
                    		{field: "cusManagername", title:"客户经理名称", align:"center", width: "100px"},

    						
                    		{field: "groupLevel", title:"级别", align:"center", width: "100px"},

    						
                    		{field: "incomeDate", title:"入职日期", align:"center", width: "100px"},

    						
                    		{field: "blanceavgBase", title:"基数", align:"center", width: "100px"},

    						
                    		{field: "balanceavgAll", title:"本外币年日均", align:"center", width: "100px"},

    						
                    		{field: "balanceavgIncremental", title:"增量", align:"center", width: "100px"},

    						
                    		{field: "monthTask", title:"指标", align:"center", width: "100px"},

    						
                    		{field: "incrementalTime", title:"完成比", align:"center", width: "100px"},

    						
                    		{field: "lastResult", title:"得分", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhPertotalJxManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhPertotalJxManageListView.get("columns");
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
                                detailstr+="<label id='lsenddate' align='right'>统计截止日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='senddate' name='统计截止日期' value='"+ColumnValue["senddate"]+"' style='...'/>";
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
                                detailstr+="<label id='lbalanceavgAll' align='right'>本外币年日均：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavgAll' name='本外币年日均' value='"+ColumnValue["balanceavgAll"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbalanceavgIncremental' align='right'>增量：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='balanceavgIncremental' name='增量' value='"+ColumnValue["balanceavgIncremental"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonthTask' align='right'>指标：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='monthTask' name='指标' value='"+ColumnValue["monthTask"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lincrementalTime' align='right'>完成比：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='incrementalTime' name='完成比' value='"+ColumnValue["incrementalTime"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llastResult' align='right'>得分：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='lastResult' name='得分' value='"+ColumnValue["lastResult"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhPertotalJx.updateJxkhPertotalJx&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhPertotalJxManageListView);
        }
    });

    return PlatformJxkhPertotalJxManageRouter;
});


/**
 * 任务指标比例
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
                    data:{id: $("#id").val(),tasktype: $("#tasktype").val(),bstype: $("#bstype").val(),syear: $("#syear").val(),month1: $("#month1").val(),month2: $("#month2").val(),month3: $("#month3").val(),month4: $("#month4").val(),month5: $("#month5").val(),month6: $("#month6").val(),month7: $("#month7").val(),month8: $("#month8").val(),month9: $("#month9").val(),month10: $("#month10").val(),month11: $("#month11").val(),month12: $("#month12").val(),projectNo: $("#projectNo").val(),projectName: $("#projectName").val(),yearTask: $("#yearTask").val()},
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
                    data:{id: $("#id").val(),tasktype: $("#tasktype").val(),bstype: $("#bstype").val(),syear: $("#syear").val(),month1: $("#month1").val(),month2: $("#month2").val(),month3: $("#month3").val(),month4: $("#month4").val(),month5: $("#month5").val(),month6: $("#month6").val(),month7: $("#month7").val(),month8: $("#month8").val(),month9: $("#month9").val(),month10: $("#month10").val(),month11: $("#month11").val(),month12: $("#month12").val(),projectNo: $("#projectNo").val(),projectName: $("#projectName").val(),yearTask: $("#yearTask").val()},
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
    
    var PlatformJxkhTaskTraceManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhTaskTrace_manage": "showPlatformJxkhTaskTraceManageList",  
            "basic_manage/platform_ckJxkhTaskTrace_manage": "showPlatformckJxkhTaskTraceManageList"
        },
        showPlatformckJxkhTaskTraceManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhTaskTraceManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhTaskTraceManageListView = new SimpleListView({
                id: "platform_jxkhTaskTrace_manage_list",
                title: "基础管理 > 任务指标比例",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("任务指标比例");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltasktype' align='right'>指标类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='tasktype' name='指标类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbstype' align='right'>业务类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bstype' name='业务类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsyear' align='right'>年：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='syear' name='年' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth1' align='right'>1月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month1' name='1月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth2' align='right'>2月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month2' name='2月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth3' align='right'>3月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month3' name='3月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth4' align='right'>4月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month4' name='4月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth5' align='right'>5月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month5' name='5月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth6' align='right'>6月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month6' name='6月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth7' align='right'>7月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month7' name='7月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth8' align='right'>8月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month8' name='8月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth9' align='right'>9月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month9' name='9月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth10' align='right'>10月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month10' name='10月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth11' align='right'>11月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month11' name='11月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth12' align='right'>12月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month12' name='12月' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectNo' align='right'>指标编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='projectNo' name='指标编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectName' align='right'>指标名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='projectName' name='指标名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lyearTask' align='right'>年指标：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='yearTask' name='年指标' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTaskTrace.createJxkhTaskTrace&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhTaskTraceManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhTaskTraceManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhTaskTraceManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTaskTrace.deleteJxkhTaskTrace&v=1.0&format=json",
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
                        detailstr+="<label id='ltasktype' align='right'>指标类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='tasktype' name='指标类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbstype' align='right'>业务类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bstype' name='业务类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsyear' align='right'>年：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='syear' name='年' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth1' align='right'>1月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month1' name='1月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth2' align='right'>2月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month2' name='2月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth3' align='right'>3月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month3' name='3月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth4' align='right'>4月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month4' name='4月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth5' align='right'>5月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month5' name='5月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth6' align='right'>6月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month6' name='6月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth7' align='right'>7月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month7' name='7月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth8' align='right'>8月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month8' name='8月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth9' align='right'>9月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month9' name='9月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth10' align='right'>10月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month10' name='10月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth11' align='right'>11月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month11' name='11月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmonth12' align='right'>12月：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='month12' name='12月' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectNo' align='right'>指标编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='projectNo' name='指标编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lprojectName' align='right'>指标名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='projectName' name='指标名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lyearTask' align='right'>年指标：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='yearTask' name='年指标' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTaskTrace.selectJxkhTaskTrace&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTaskTrace.selectJxkhTaskTrace&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },tasktype: { type: "string" },bstype: { type: "string" },syear: { type: "string" },month1: { type: "string" },month2: { type: "string" },month3: { type: "string" },month4: { type: "string" },month5: { type: "string" },month6: { type: "string" },month7: { type: "string" },month8: { type: "string" },month9: { type: "string" },month10: { type: "string" },month11: { type: "string" },month12: { type: "string" },projectNo: { type: "string" },projectName: { type: "string" },yearTask: { type: "string" }
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
                            result = platformJxkhTaskTraceManageListView.appendColValue(result);
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

    						
                    		{field: "tasktype", title:"指标类别", align:"center", width: "100px"},

    						
                    		{field: "bstype", title:"业务类别", align:"center", width: "100px"},

    						
                    		{field: "syear", title:"年", align:"center", width: "100px"},

    						
                    		{field: "month1", title:"1月", align:"center", width: "100px"},

    						
                    		{field: "month2", title:"2月", align:"center", width: "100px"},

    						
                    		{field: "month3", title:"3月", align:"center", width: "100px"},

    						
                    		{field: "month4", title:"4月", align:"center", width: "100px"},

    						
                    		{field: "month5", title:"5月", align:"center", width: "100px"},

    						
                    		{field: "month6", title:"6月", align:"center", width: "100px"},

    						
                    		{field: "month7", title:"7月", align:"center", width: "100px"},

    						
                    		{field: "month8", title:"8月", align:"center", width: "100px"},

    						
                    		{field: "month9", title:"9月", align:"center", width: "100px"},

    						
                    		{field: "month10", title:"10月", align:"center", width: "100px"},

    						
                    		{field: "month11", title:"11月", align:"center", width: "100px"},

    						
                    		{field: "month12", title:"12月", align:"center", width: "100px"},

    						
                    		{field: "projectNo", title:"指标编号", align:"center", width: "100px"},

    						
                    		{field: "projectName", title:"指标名称", align:"center", width: "100px"},

    						
                    		{field: "yearTask", title:"年指标", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhTaskTraceManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhTaskTraceManageListView.get("columns");
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
                                detailstr+="<label id='ltasktype' align='right'>指标类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='tasktype' name='指标类别' value='"+ColumnValue["tasktype"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbstype' align='right'>业务类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='bstype' name='业务类别' value='"+ColumnValue["bstype"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsyear' align='right'>年：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='syear' name='年' value='"+ColumnValue["syear"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth1' align='right'>1月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month1' name='1月' value='"+ColumnValue["month1"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth2' align='right'>2月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month2' name='2月' value='"+ColumnValue["month2"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth3' align='right'>3月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month3' name='3月' value='"+ColumnValue["month3"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth4' align='right'>4月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month4' name='4月' value='"+ColumnValue["month4"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth5' align='right'>5月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month5' name='5月' value='"+ColumnValue["month5"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth6' align='right'>6月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month6' name='6月' value='"+ColumnValue["month6"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth7' align='right'>7月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month7' name='7月' value='"+ColumnValue["month7"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth8' align='right'>8月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month8' name='8月' value='"+ColumnValue["month8"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth9' align='right'>9月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month9' name='9月' value='"+ColumnValue["month9"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth10' align='right'>10月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month10' name='10月' value='"+ColumnValue["month10"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth11' align='right'>11月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month11' name='11月' value='"+ColumnValue["month11"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmonth12' align='right'>12月：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='month12' name='12月' value='"+ColumnValue["month12"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprojectNo' align='right'>指标编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='projectNo' name='指标编号' value='"+ColumnValue["projectNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lprojectName' align='right'>指标名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='projectName' name='指标名称' value='"+ColumnValue["projectName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lyearTask' align='right'>年指标：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='yearTask' name='年指标' value='"+ColumnValue["yearTask"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTaskTrace.updateJxkhTaskTrace&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhTaskTraceManageListView);
        }
    });

    return PlatformJxkhTaskTraceManageRouter;
});

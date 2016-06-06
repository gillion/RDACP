
/**
 * 绩效考核参数
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
                    data:{id: $("#id").val(),dept: $("#dept").val(),bstype: $("#bstype").val(),endMonth: $("#endMonth").val(),beginMonth: $("#beginMonth").val(),baseResult: $("#baseResult").val(),incremental: $("#incremental").val(),doubles: $("#doubles").val(),incomeDate: $("#incomeDate").val()},
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
                    data:{id: $("#id").val(),dept: $("#dept").val(),bstype: $("#bstype").val(),endMonth: $("#endMonth").val(),beginMonth: $("#beginMonth").val(),baseResult: $("#baseResult").val(),incremental: $("#incremental").val(),doubles: $("#doubles").val(),incomeDate: $("#incomeDate").val()},
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
    
    var PlatformJxkhDeptParaManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhDeptPara_manage": "showPlatformJxkhDeptParaManageList",  
            "basic_manage/platform_ckJxkhDeptPara_manage": "showPlatformckJxkhDeptParaManageList"
        },
        showPlatformckJxkhDeptParaManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhDeptParaManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhDeptParaManageListView = new SimpleListView({
                id: "platform_jxkhDeptPara_manage_list",
                title: "基础管理 > 绩效考核参数",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("绩效考核参数");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldept' align='right'>部门：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dept' name='部门' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbstype' align='right'>业务类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bstype' name='业务类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lendMonth' align='right'>基数起始月份：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='endMonth' name='基数起始月份' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbeginMonth' align='right'>基数终止月份：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='beginMonth' name='基数终止月份' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbaseResult' align='right'>存量得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='baseResult' name='存量得分' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincremental' align='right'>增量得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incremental' name='增量得分' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldoubles' align='right'>倍数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='doubles' name='倍数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincomeDate' align='right'>成立日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incomeDate' name='成立日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhDeptPara.createJxkhDeptPara&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhDeptParaManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhDeptParaManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhDeptParaManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhDeptPara.deleteJxkhDeptPara&v=1.0&format=json",
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
                        detailstr+="<label id='ldept' align='right'>部门：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dept' name='部门' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbstype' align='right'>业务类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='bstype' name='业务类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lendMonth' align='right'>基数起始月份：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='endMonth' name='基数起始月份' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbeginMonth' align='right'>基数终止月份：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='beginMonth' name='基数终止月份' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbaseResult' align='right'>存量得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='baseResult' name='存量得分' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincremental' align='right'>增量得分：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incremental' name='增量得分' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldoubles' align='right'>倍数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='doubles' name='倍数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lincomeDate' align='right'>成立日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='incomeDate' name='成立日期' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhDeptPara.selectJxkhDeptPara&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhDeptPara.selectJxkhDeptPara&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },dept: { type: "string" },bstype: { type: "string" },endMonth: { type: "string" },beginMonth: { type: "string" },baseResult: { type: "string" },incremental: { type: "string" },doubles: { type: "string" },incomeDate: { type: "string" }
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
                            result = platformJxkhDeptParaManageListView.appendColValue(result);
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

    						
                    		{field: "dept", title:"部门", align:"center", width: "100px"},

    						
                    		{field: "bstype", title:"业务类别", align:"center", width: "100px"},

    						
                    		{field: "endMonth", title:"基数起始月份", align:"center", width: "100px"},

    						
                    		{field: "beginMonth", title:"基数终止月份", align:"center", width: "100px"},

    						
                    		{field: "baseResult", title:"存量得分", align:"center", width: "100px"},

    						
                    		{field: "incremental", title:"增量得分", align:"center", width: "100px"},

    						
                    		{field: "doubles", title:"倍数", align:"center", width: "100px"},

    						
                    		{field: "incomeDate", title:"成立日期", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhDeptParaManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhDeptParaManageListView.get("columns");
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
                                detailstr+="<label id='ldept' align='right'>部门：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dept' name='部门' value='"+ColumnValue["dept"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbstype' align='right'>业务类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='bstype' name='业务类别' value='"+ColumnValue["bstype"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lendMonth' align='right'>基数起始月份：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='endMonth' name='基数起始月份' value='"+ColumnValue["endMonth"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbeginMonth' align='right'>基数终止月份：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='beginMonth' name='基数终止月份' value='"+ColumnValue["beginMonth"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbaseResult' align='right'>存量得分：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='baseResult' name='存量得分' value='"+ColumnValue["baseResult"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lincremental' align='right'>增量得分：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='incremental' name='增量得分' value='"+ColumnValue["incremental"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldoubles' align='right'>倍数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='doubles' name='倍数' value='"+ColumnValue["doubles"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lincomeDate' align='right'>成立日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='incomeDate' name='成立日期' value='"+ColumnValue["incomeDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhDeptPara.updateJxkhDeptPara&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhDeptParaManageListView);
        }
    });

    return PlatformJxkhDeptParaManageRouter;
});


/**
 * 个贷计提利息
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
                    data:{id: $("#id").val(),putoutno: $("#putoutno").val(),sterm: $("#sterm").val(),orgid: $("#orgid").val(),paycalcdayinte: $("#paycalcdayinte").val(),acccalcdayintebase: $("#acccalcdayintebase").val(),actualcalcinte: $("#actualcalcinte").val(),calctype: $("#calctype").val()},
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
                    data:{id: $("#id").val(),putoutno: $("#putoutno").val(),sterm: $("#sterm").val(),orgid: $("#orgid").val(),paycalcdayinte: $("#paycalcdayinte").val(),acccalcdayintebase: $("#acccalcdayintebase").val(),actualcalcinte: $("#actualcalcinte").val(),calctype: $("#calctype").val()},
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
    
    var PlatformCalcDayinteManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_CalcDayinte_manage": "showPlatformCalcDayinteManageList",  
            "basic_manage/platform_ckCalcDayinte_manage": "showPlatformckCalcDayinteManageList"
        },
        showPlatformckCalcDayinteManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformCalcDayinteManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformCalcDayinteManageListView = new SimpleListView({
                id: "platform_calcDayinte_manage_list",
                title: "基础管理 > 个贷计提利息",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("个贷计提利息");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lputoutno' align='right'>单据号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='putoutno' name='单据号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsterm' align='right'>期次：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sterm' name='期次' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lorgid' align='right'>机构：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='orgid' name='机构' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpaycalcdayinte' align='right'>应计提利息：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='paycalcdayinte' name='应计提利息' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lacccalcdayintebase' align='right'>累积应还计提利息基数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='acccalcdayintebase' name='累积应还计提利息基数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lactualcalcinte' align='right'>实还利息：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='actualcalcinte' name='实还利息' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcalctype' align='right'>计算标志：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='calctype' name='计算标志' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=calcDayinte.createCalcDayinte&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformCalcDayinteManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformCalcDayinteManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformCalcDayinteManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=calcDayinte.deleteCalcDayinte&v=1.0&format=json",
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
                        detailstr+="<label id='lputoutno' align='right'>单据号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='putoutno' name='单据号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsterm' align='right'>期次：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='sterm' name='期次' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lorgid' align='right'>机构：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='orgid' name='机构' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpaycalcdayinte' align='right'>应计提利息：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='paycalcdayinte' name='应计提利息' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lacccalcdayintebase' align='right'>累积应还计提利息基数：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='acccalcdayintebase' name='累积应还计提利息基数' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lactualcalcinte' align='right'>实还利息：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='actualcalcinte' name='实还利息' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcalctype' align='right'>计算标志：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='calctype' name='计算标志' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=calcDayinte.selectCalcDayinte&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=calcDayinte.selectCalcDayinte&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },putoutno: { type: "string" },sterm: { type: "string" },orgid: { type: "string" },paycalcdayinte: { type: "string" },acccalcdayintebase: { type: "string" },actualcalcinte: { type: "string" },calctype: { type: "string" }
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
                            result = platformCalcDayinteManageListView.appendColValue(result);
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

    						
                    		{field: "putoutno", title:"单据号", align:"center", width: "100px"},

    						
                    		{field: "sterm", title:"期次", align:"center", width: "100px"},

    						
                    		{field: "orgid", title:"机构", align:"center", width: "100px"},

    						
                    		{field: "paycalcdayinte", title:"应计提利息", align:"center", width: "100px"},

    						
                    		{field: "acccalcdayintebase", title:"累积应还计提利息基数", align:"center", width: "100px"},

    						
                    		{field: "actualcalcinte", title:"实还利息", align:"center", width: "100px"},

    						
                    		{field: "calctype", title:"计算标志", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformCalcDayinteManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformCalcDayinteManageListView.get("columns");
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
                                detailstr+="<label id='lputoutno' align='right'>单据号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='putoutno' name='单据号' value='"+ColumnValue["putoutno"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsterm' align='right'>期次：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='sterm' name='期次' value='"+ColumnValue["sterm"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lorgid' align='right'>机构：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='orgid' name='机构' value='"+ColumnValue["orgid"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpaycalcdayinte' align='right'>应计提利息：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='paycalcdayinte' name='应计提利息' value='"+ColumnValue["paycalcdayinte"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lacccalcdayintebase' align='right'>累积应还计提利息基数：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='acccalcdayintebase' name='累积应还计提利息基数' value='"+ColumnValue["acccalcdayintebase"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lactualcalcinte' align='right'>实还利息：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='actualcalcinte' name='实还利息' value='"+ColumnValue["actualcalcinte"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcalctype' align='right'>计算标志：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='calctype' name='计算标志' value='"+ColumnValue["calctype"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=calcDayinte.updateCalcDayinte&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformCalcDayinteManageListView);
        }
    });

    return PlatformCalcDayinteManageRouter;
});

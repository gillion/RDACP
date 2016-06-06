
/**
 * 统计科目
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
                    data:{id: $("#id").val(),classtype: $("#classtype").val(),classNum: $("#classNum").val(),className: $("#className").val(),temp1: $("#temp1").val(),temp2: $("#temp2").val()},
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
                    data:{id: $("#id").val(),classtype: $("#classtype").val(),classNum: $("#classNum").val(),className: $("#className").val(),temp1: $("#temp1").val(),temp2: $("#temp2").val()},
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
    
    var PlatformJxkhTotalclassManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhTotalclass_manage": "showPlatformJxkhTotalclassManageList",  
            "basic_manage/platform_ckJxkhTotalclass_manage": "showPlatformckJxkhTotalclassManageList"
        },
        showPlatformckJxkhTotalclassManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhTotalclassManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhTotalclassManageListView = new SimpleListView({
                id: "platform_jxkhTotalclass_manage_list",
                title: "基础管理 > 统计科目",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("统计科目");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclasstype' align='right'>科目类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='classtype' name='科目类别' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclassNum' align='right'>科目编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='classNum' name='科目编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclassName' align='right'>科目名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='className' name='科目名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp1' align='right'>预留字段1：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp1' name='预留字段1' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp2' align='right'>预留字段2：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp2' name='预留字段2' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTotalclass.createJxkhTotalclass&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhTotalclassManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhTotalclassManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhTotalclassManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTotalclass.deleteJxkhTotalclass&v=1.0&format=json",
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
                        detailstr+="<label id='lclasstype' align='right'>科目类别：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='classtype' name='科目类别' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclassNum' align='right'>科目编号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='classNum' name='科目编号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclassName' align='right'>科目名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='className' name='科目名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp1' align='right'>预留字段1：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp1' name='预留字段1' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltemp2' align='right'>预留字段2：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='temp2' name='预留字段2' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTotalclass.selectJxkhTotalclass&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTotalclass.selectJxkhTotalclass&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },classtype: { type: "string" },classNum: { type: "string" },className: { type: "string" },temp1: { type: "string" },temp2: { type: "string" }
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
                            result = platformJxkhTotalclassManageListView.appendColValue(result);
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

    						
                    		{field: "classtype", title:"科目类别", align:"center", width: "100px"},

    						
                    		{field: "classNum", title:"科目编号", align:"center", width: "100px"},

    						
                    		{field: "className", title:"科目名称", align:"center", width: "100px"},

    						
                    		{field: "temp1", title:"预留字段1", align:"center", width: "100px"},

    						
                    		{field: "temp2", title:"预留字段2", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhTotalclassManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhTotalclassManageListView.get("columns");
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
                                detailstr+="<label id='lclasstype' align='right'>科目类别：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='classtype' name='科目类别' value='"+ColumnValue["classtype"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclassNum' align='right'>科目编号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='classNum' name='科目编号' value='"+ColumnValue["classNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclassName' align='right'>科目名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='className' name='科目名称' value='"+ColumnValue["className"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltemp1' align='right'>预留字段1：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='temp1' name='预留字段1' value='"+ColumnValue["temp1"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltemp2' align='right'>预留字段2：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='temp2' name='预留字段2' value='"+ColumnValue["temp2"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhTotalclass.updateJxkhTotalclass&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhTotalclassManageListView);
        }
    });

    return PlatformJxkhTotalclassManageRouter;
});

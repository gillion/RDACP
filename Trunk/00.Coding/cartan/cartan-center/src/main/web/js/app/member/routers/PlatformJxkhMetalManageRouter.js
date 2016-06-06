
/**
 * 贵金属数据
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
                    data:{id: $("#id").val(),subbranchNum: $("#subbranchNum").val(),subbranchName: $("#subbranchName").val(),cusName: $("#cusName").val(),idCardNum: $("#idCardNum").val(),cardId: $("#cardId").val(),dataDate: $("#dataDate").val(),cusManager: $("#cusManager").val()},
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
                    data:{id: $("#id").val(),subbranchNum: $("#subbranchNum").val(),subbranchName: $("#subbranchName").val(),cusName: $("#cusName").val(),idCardNum: $("#idCardNum").val(),cardId: $("#cardId").val(),dataDate: $("#dataDate").val(),cusManager: $("#cusManager").val()},
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
    
    var PlatformJxkhMetalManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_JxkhMetal_manage": "showPlatformJxkhMetalManageList",  
            "basic_manage/platform_ckJxkhMetal_manage": "showPlatformckJxkhMetalManageList"
        },
        showPlatformckJxkhMetalManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformJxkhMetalManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformJxkhMetalManageListView = new SimpleListView({
                id: "platform_jxkhMetal_manage_list",
                title: "基础管理 > 贵金属数据",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("贵金属数据");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubbranchNum' align='right'>网点号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranchNum' name='网点号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubbranchName' align='right'>网点名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranchName' name='网点名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusName' align='right'>客户姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusName' name='客户姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidCardNum' align='right'>身份证号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='idCardNum' name='身份证号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardId' align='right'>卡号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardId' name='卡号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataDate' align='right'>业务日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='业务日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusManager' align='right'>客户经理：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusManager' name='客户经理' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMetal.createJxkhMetal&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformJxkhMetalManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformJxkhMetalManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformJxkhMetalManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMetal.deleteJxkhMetal&v=1.0&format=json",
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
                        detailstr+="<label id='lsubbranchNum' align='right'>网点号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranchNum' name='网点号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubbranchName' align='right'>网点名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='subbranchName' name='网点名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusName' align='right'>客户姓名：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusName' name='客户姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidCardNum' align='right'>身份证号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='idCardNum' name='身份证号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcardId' align='right'>卡号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cardId' name='卡号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataDate' align='right'>业务日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='dataDate' name='业务日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcusManager' align='right'>客户经理：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='cusManager' name='客户经理' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMetal.selectJxkhMetal&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMetal.selectJxkhMetal&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },subbranchNum: { type: "string" },subbranchName: { type: "string" },cusName: { type: "string" },idCardNum: { type: "string" },cardId: { type: "string" },dataDate: { type: "string" },cusManager: { type: "string" }
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
                            result = platformJxkhMetalManageListView.appendColValue(result);
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

    						
                    		{field: "subbranchNum", title:"网点号", align:"center", width: "100px"},

    						
                    		{field: "subbranchName", title:"网点名称", align:"center", width: "100px"},

    						
                    		{field: "cusName", title:"客户姓名", align:"center", width: "100px"},

    						
                    		{field: "idCardNum", title:"身份证号", align:"center", width: "100px"},

    						
                    		{field: "cardId", title:"卡号", align:"center", width: "100px"},

    						
                    		{field: "dataDate", title:"业务日期", align:"center", width: "100px"},

    						
                    		{field: "cusManager", title:"客户经理", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformJxkhMetalManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformJxkhMetalManageListView.get("columns");
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
                                detailstr+="<label id='lsubbranchNum' align='right'>网点号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='subbranchNum' name='网点号' value='"+ColumnValue["subbranchNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubbranchName' align='right'>网点名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='subbranchName' name='网点名称' value='"+ColumnValue["subbranchName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcusName' align='right'>客户姓名：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cusName' name='客户姓名' value='"+ColumnValue["cusName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lidCardNum' align='right'>身份证号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='idCardNum' name='身份证号' value='"+ColumnValue["idCardNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcardId' align='right'>卡号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cardId' name='卡号' value='"+ColumnValue["cardId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldataDate' align='right'>业务日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='dataDate' name='业务日期' value='"+ColumnValue["dataDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcusManager' align='right'>客户经理：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='cusManager' name='客户经理' value='"+ColumnValue["cusManager"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=jxkhMetal.updateJxkhMetal&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformJxkhMetalManageListView);
        }
    });

    return PlatformJxkhMetalManageRouter;
});

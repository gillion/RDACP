
/**
 * IpfCcmShlp
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
	
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, height, titles);
        
    	
        
        

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),shlpName: $("#shlpName").val(),shlpStatus: $("#shlpStatus").val(),dataSource: $("#dataSource").val(),dataSourceType: $("#dataSourceType").val(),valueColumn: $("#valueColumn").val(),displayColumn: $("#displayColumn").val(),ruleNo: $("#ruleNo").val()},
                    dataType: 'json',
                    complete: function(transport){
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("操作成功！");
                        kendoUIWindow.close();
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                        $("#submitBtn").attr("disabled", false);
                    }
                }
            );
        });
    	} else{
        $("#QueryBtn").click(function(){
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),shlpName: $("#shlpName").val(),shlpStatus: $("#shlpStatus").val(),dataSource: $("#dataSource").val(),dataSourceType: $("#dataSourceType").val(),valueColumn: $("#valueColumn").val(),displayColumn: $("#displayColumn").val(),ruleNo: $("#ruleNo").val()},
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
                        $("#QueryBtn").attr("disabled", false);
                        kendoUIWindow.close();
                    }
                }
            );
        });
    	}
        SimpleListUtil.setDataTimeCn();

        
    }
    
    var PlatformIpfCcmShlpManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmShlp_manage": "showPlatformIpfCcmShlpManageList",  
            "basic_manage/platform_ckIpfCcmShlp_manage": "showPlatformckIpfCcmShlpManageList"
        },
        showPlatformckIpfCcmShlpManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmShlpManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmShlpManageListView = new SimpleListView({
                id: "platform_ipfCcmShlp_manage_list",
                title: "基础管理 > IpfCcmShlp",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmShlp");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpName' align='right'>名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpName' name='名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpStatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpStatus' name='状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataSource' align='right'>数据源：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataSource' name='数据源' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataSourceType' align='right'>数据源类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataSourceType' name='数据源类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalueColumn' align='right'>值字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='valueColumn' name='值字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldisplayColumn' align='right'>文本字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='displayColumn' name='文本字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>业务规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='业务规则号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmShlp.createIpfCcmShlp&v=1.0&format=json",$(detailstr),250);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmShlpManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmShlpManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmShlpManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmShlp.deleteIpfCcmShlp&v=1.0&format=json",
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
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpName' align='right'>名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpName' name='名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpStatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpStatus' name='状态' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataSource' align='right'>数据源：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataSource' name='数据源' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataSourceType' align='right'>数据源类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataSourceType' name='数据源类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalueColumn' align='right'>值字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='valueColumn' name='值字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldisplayColumn' align='right'>文本字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='displayColumn' name='文本字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>业务规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='业务规则号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmShlp.selectIpfCcmShlp&v=1.0&format=json",$(detailstr),250);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmShlp.selectIpfCcmShlp&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },shlpName: { type: "string" },shlpStatus: { type: "string" },dataSource: { type: "string" },dataSourceType: { type: "string" },valueColumn: { type: "string" },displayColumn: { type: "string" },ruleNo: { type: "string" }
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
                            result = platformIpfCcmShlpManageListView.appendColValue(result);
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
                          {field: "id", title:"主键", hidden:"true", align:"center", width: "100px"},
                    		{field: "shlpName", title:"名称", align:"center", width: "100px"},
                    		{field: "shlpStatus", title:"状态", align:"center", width: "100px"},
                    		{field: "dataSource", title:"数据源", align:"center", width: "100px"},
                    		{field: "dataSourceType", title:"数据源类型", align:"center", width: "100px"},
                    		{field: "valueColumn", title:"值字段", align:"center", width: "100px"},
                    		{field: "displayColumn", title:"文本字段", align:"center", width: "100px"},
                    		{field: "ruleNo", title:"业务规则号", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmShlpManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmShlpManageListView.get("columns");
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
                                detailstr+="<input id='id' name='主键' hidden='true' value='"+ColumnValue["id"]+"' style='...'/>";

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshlpName' align='right'>名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='shlpName' name='名称' value='"+ColumnValue["shlpName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshlpStatus' align='right'>状态：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='shlpStatus' name='状态' value='"+ColumnValue["shlpStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldataSource' align='right'>数据源：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dataSource' name='数据源' value='"+ColumnValue["dataSource"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldataSourceType' align='right'>数据源类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dataSourceType' name='数据源类型' value='"+ColumnValue["dataSourceType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvalueColumn' align='right'>值字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='valueColumn' name='值字段' value='"+ColumnValue["valueColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldisplayColumn' align='right'>文本字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='displayColumn' name='文本字段' value='"+ColumnValue["displayColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleNo' align='right'>业务规则号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleNo' name='业务规则号' value='"+ColumnValue["ruleNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmShlp.updateIpfCcmShlp&v=1.0&format=json", $(detailstr),250);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmShlpManageListView);
        }
    });

    return PlatformIpfCcmShlpManageRouter;
});

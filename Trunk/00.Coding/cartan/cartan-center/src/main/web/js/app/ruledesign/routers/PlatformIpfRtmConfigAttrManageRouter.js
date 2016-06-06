
/**
 * IpfRtmConfigAttr
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
                    data:{id: $("#id").val(),ipfRtmConfigId: $("#ipfRtmConfigId").val(),seqNo: $("#seqNo").val(),displayLabel: $("#displayLabel").val(),dataType: $("#dataType").val(),uiType: $("#uiType").val(),dictTableName: $("#dictTableName").val(),dictGroupValue: $("#dictGroupValue").val(),searchHelp: $("#searchHelp").val(),shValueColumn: $("#shValueColumn").val(),shDisplayColumn: $("#shDisplayColumn").val()},
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
                    data:{id: $("#id").val(),ipfRtmConfigId: $("#ipfRtmConfigId").val(),seqNo: $("#seqNo").val(),displayLabel: $("#displayLabel").val(),dataType: $("#dataType").val(),uiType: $("#uiType").val(),dictTableName: $("#dictTableName").val(),dictGroupValue: $("#dictGroupValue").val(),searchHelp: $("#searchHelp").val(),shValueColumn: $("#shValueColumn").val(),shDisplayColumn: $("#shDisplayColumn").val()},
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
    
    var PlatformIpfRtmConfigAttrManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfRtmConfigAttr_manage": "showPlatformIpfRtmConfigAttrManageList",  
            "basic_manage/platform_ckIpfRtmConfigAttr_manage": "showPlatformckIpfRtmConfigAttrManageList"
        },
        showPlatformckIpfRtmConfigAttrManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfRtmConfigAttrManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfRtmConfigAttrManageListView = new SimpleListView({
                id: "platform_ipfRtmConfigAttr_manage_list",
                title: "基础管理 > IpfRtmConfigAttr",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfRtmConfigAttr");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfRtmConfigId' align='right'>运行期配置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRtmConfigId' name='运行期配置' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lseqNo' align='right'>序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='seqNo' name='序号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldisplayLabel' align='right'>显示名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='displayLabel' name='显示名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataType' name='数据类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiType' align='right'>UI组件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiType' name='UI组件类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictTableName' align='right'>字典表编码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictTableName' name='字典表编码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictGroupValue' align='right'>字典表分组名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictGroupValue' name='字典表分组名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchHelp' align='right'>搜索帮助名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchHelp' name='搜索帮助名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshValueColumn' align='right'>搜索帮助值字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shValueColumn' name='搜索帮助值字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshDisplayColumn' align='right'>搜索帮助文本字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shDisplayColumn' name='搜索帮助文本字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfRtmConfigAttr.createIpfRtmConfigAttr&v=1.0&format=json",$(detailstr),340);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfRtmConfigAttrManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfRtmConfigAttrManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfRtmConfigAttrManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfRtmConfigAttr.deleteIpfRtmConfigAttr&v=1.0&format=json",
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
                        detailstr+="<label id='lipfRtmConfigId' align='right'>运行期配置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRtmConfigId' name='运行期配置' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lseqNo' align='right'>序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='seqNo' name='序号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldisplayLabel' align='right'>显示名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='displayLabel' name='显示名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataType' name='数据类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiType' align='right'>UI组件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiType' name='UI组件类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictTableName' align='right'>字典表编码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictTableName' name='字典表编码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictGroupValue' align='right'>字典表分组名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictGroupValue' name='字典表分组名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchHelp' align='right'>搜索帮助名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchHelp' name='搜索帮助名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshValueColumn' align='right'>搜索帮助值字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shValueColumn' name='搜索帮助值字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshDisplayColumn' align='right'>搜索帮助文本字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shDisplayColumn' name='搜索帮助文本字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfRtmConfigAttr.selectIpfRtmConfigAttr&v=1.0&format=json",$(detailstr),340);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfRtmConfigAttr.selectIpfRtmConfigAttr&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfRtmConfigId: { type: "string" },seqNo: { type: "string" },displayLabel: { type: "string" },dataType: { type: "string" },uiType: { type: "string" },dictTableName: { type: "string" },dictGroupValue: { type: "string" },searchHelp: { type: "string" },shValueColumn: { type: "string" },shDisplayColumn: { type: "string" }
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
                            result = platformIpfRtmConfigAttrManageListView.appendColValue(result);
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
                    		{field: "ipfRtmConfigId", title:"运行期配置", align:"center", width: "100px"},
                    		{field: "seqNo", title:"序号", align:"center", width: "100px"},
                    		{field: "displayLabel", title:"显示名称", align:"center", width: "100px"},
                    		{field: "dataType", title:"数据类型", align:"center", width: "100px"},
                    		{field: "uiType", title:"UI组件类型", align:"center", width: "100px"},
                    		{field: "dictTableName", title:"字典表编码", align:"center", width: "100px"},
                    		{field: "dictGroupValue", title:"字典表分组名", align:"center", width: "100px"},
                    		{field: "searchHelp", title:"搜索帮助名", align:"center", width: "100px"},
                    		{field: "shValueColumn", title:"搜索帮助值字段", align:"center", width: "100px"},
                    		{field: "shDisplayColumn", title:"搜索帮助文本字段", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfRtmConfigAttrManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfRtmConfigAttrManageListView.get("columns");
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
                                detailstr+="<label id='lipfRtmConfigId' align='right'>运行期配置：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfRtmConfigId' name='运行期配置' value='"+ColumnValue["ipfRtmConfigId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lseqNo' align='right'>序号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='seqNo' name='序号' value='"+ColumnValue["seqNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldisplayLabel' align='right'>显示名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='displayLabel' name='显示名称' value='"+ColumnValue["displayLabel"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dataType' name='数据类型' value='"+ColumnValue["dataType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luiType' align='right'>UI组件类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='uiType' name='UI组件类型' value='"+ColumnValue["uiType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldictTableName' align='right'>字典表编码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dictTableName' name='字典表编码' value='"+ColumnValue["dictTableName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldictGroupValue' align='right'>字典表分组名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dictGroupValue' name='字典表分组名' value='"+ColumnValue["dictGroupValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsearchHelp' align='right'>搜索帮助名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='searchHelp' name='搜索帮助名' value='"+ColumnValue["searchHelp"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshValueColumn' align='right'>搜索帮助值字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='shValueColumn' name='搜索帮助值字段' value='"+ColumnValue["shValueColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshDisplayColumn' align='right'>搜索帮助文本字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='shDisplayColumn' name='搜索帮助文本字段' value='"+ColumnValue["shDisplayColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfRtmConfigAttr.updateIpfRtmConfigAttr&v=1.0&format=json", $(detailstr),340);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfRtmConfigAttrManageListView);
        }
    });

    return PlatformIpfRtmConfigAttrManageRouter;
});


/**
 * IpfCcmBoFormToolbar
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
                    data:{id: $("#id").val(),ipfCcbBoId: $("#ipfCcbBoId").val(),methodName: $("#methodName").val(),methodDesc: $("#methodDesc").val(),seqNo: $("#seqNo").val(),methodId: $("#methodId").val(),buttonStyle: $("#buttonStyle").val(),disabledExpree: $("#disabledExpree").val(),isRefreshParentBo: $("#isRefreshParentBo").val(),hotkeyType: $("#hotkeyType").val(),hotkeyValue: $("#hotkeyValue").val(),isHide: $("#isHide").val()},
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
                    data:{id: $("#id").val(),ipfCcbBoId: $("#ipfCcbBoId").val(),methodName: $("#methodName").val(),methodDesc: $("#methodDesc").val(),seqNo: $("#seqNo").val(),methodId: $("#methodId").val(),buttonStyle: $("#buttonStyle").val(),disabledExpree: $("#disabledExpree").val(),isRefreshParentBo: $("#isRefreshParentBo").val(),hotkeyType: $("#hotkeyType").val(),hotkeyValue: $("#hotkeyValue").val(),isHide: $("#isHide").val()},
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
    
    var PlatformIpfCcmBoFormToolbarManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoFormToolbar_manage": "showPlatformIpfCcmBoFormToolbarManageList",  
            "basic_manage/platform_ckIpfCcmBoFormToolbar_manage": "showPlatformckIpfCcmBoFormToolbarManageList"
        },
        showPlatformckIpfCcmBoFormToolbarManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoFormToolbarManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoFormToolbarManageListView = new SimpleListView({
                id: "platform_ipfCcmBoFormToolbar_manage_list",
                title: "基础管理 > IpfCcmBoFormToolbar",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoFormToolbar");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcbBoId' align='right'>业务对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcbBoId' name='业务对象' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>调用方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='调用方法名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodDesc' align='right'>调用方法描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodDesc' name='调用方法描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lseqNo' align='right'>顺序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='seqNo' name='顺序号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodId' align='right'>方法ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodId' name='方法ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbuttonStyle' align='right'>按钮样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='buttonStyle' name='按钮样式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldisabledExpree' align='right'>可编辑表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='disabledExpree' name='可编辑表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRefreshParentBo' align='right'>刷新主表：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRefreshParentBo' name='刷新主表' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lhotkeyType' align='right'>热键类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='hotkeyType' name='热键类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lhotkeyValue' align='right'>热键值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='hotkeyValue' name='热键值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisHide' align='right'>隐藏：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isHide' name='隐藏' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoFormToolbar.createIpfCcmBoFormToolbar&v=1.0&format=json",$(detailstr),370);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoFormToolbarManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoFormToolbarManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoFormToolbarManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoFormToolbar.deleteIpfCcmBoFormToolbar&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcbBoId' align='right'>业务对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcbBoId' name='业务对象' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>调用方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='调用方法名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodDesc' align='right'>调用方法描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodDesc' name='调用方法描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lseqNo' align='right'>顺序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='seqNo' name='顺序号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodId' align='right'>方法ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodId' name='方法ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbuttonStyle' align='right'>按钮样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='buttonStyle' name='按钮样式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldisabledExpree' align='right'>可编辑表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='disabledExpree' name='可编辑表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRefreshParentBo' align='right'>刷新主表：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRefreshParentBo' name='刷新主表' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lhotkeyType' align='right'>热键类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='hotkeyType' name='热键类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lhotkeyValue' align='right'>热键值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='hotkeyValue' name='热键值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisHide' align='right'>隐藏：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isHide' name='隐藏' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoFormToolbar.selectIpfCcmBoFormToolbar&v=1.0&format=json",$(detailstr),370);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoFormToolbar.selectIpfCcmBoFormToolbar&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcbBoId: { type: "string" },methodName: { type: "string" },methodDesc: { type: "string" },seqNo: { type: "string" },methodId: { type: "string" },buttonStyle: { type: "string" },disabledExpree: { type: "string" },isRefreshParentBo: { type: "string" },hotkeyType: { type: "string" },hotkeyValue: { type: "string" },isHide: { type: "string" }
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
                            result = platformIpfCcmBoFormToolbarManageListView.appendColValue(result);
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
                    		{field: "ipfCcbBoId", title:"业务对象", align:"center", width: "100px"},
                    		{field: "methodName", title:"调用方法名称", align:"center", width: "100px"},
                    		{field: "methodDesc", title:"调用方法描述", align:"center", width: "100px"},
                    		{field: "seqNo", title:"顺序号", align:"center", width: "100px"},
                    		{field: "methodId", title:"方法ID", align:"center", width: "100px"},
                    		{field: "buttonStyle", title:"按钮样式", align:"center", width: "100px"},
                    		{field: "disabledExpree", title:"可编辑表达式", align:"center", width: "100px"},
                    		{field: "isRefreshParentBo", title:"刷新主表", align:"center", width: "100px"},
                    		{field: "hotkeyType", title:"热键类型", align:"center", width: "100px"},
                    		{field: "hotkeyValue", title:"热键值", align:"center", width: "100px"},
                    		{field: "isHide", title:"隐藏", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoFormToolbarManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoFormToolbarManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcbBoId' align='right'>业务对象：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcbBoId' name='业务对象' value='"+ColumnValue["ipfCcbBoId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodName' align='right'>调用方法名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodName' name='调用方法名称' value='"+ColumnValue["methodName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodDesc' align='right'>调用方法描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodDesc' name='调用方法描述' value='"+ColumnValue["methodDesc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lseqNo' align='right'>顺序号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='seqNo' name='顺序号' value='"+ColumnValue["seqNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodId' align='right'>方法ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodId' name='方法ID' value='"+ColumnValue["methodId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbuttonStyle' align='right'>按钮样式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='buttonStyle' name='按钮样式' value='"+ColumnValue["buttonStyle"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldisabledExpree' align='right'>可编辑表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='disabledExpree' name='可编辑表达式' value='"+ColumnValue["disabledExpree"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisRefreshParentBo' align='right'>刷新主表：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isRefreshParentBo' name='刷新主表' value='"+ColumnValue["isRefreshParentBo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lhotkeyType' align='right'>热键类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='hotkeyType' name='热键类型' value='"+ColumnValue["hotkeyType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lhotkeyValue' align='right'>热键值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='hotkeyValue' name='热键值' value='"+ColumnValue["hotkeyValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisHide' align='right'>隐藏：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isHide' name='隐藏' value='"+ColumnValue["isHide"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoFormToolbar.updateIpfCcmBoFormToolbar&v=1.0&format=json", $(detailstr),370);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoFormToolbarManageListView);
        }
    });

    return PlatformIpfCcmBoFormToolbarManageRouter;
});

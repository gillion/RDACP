
/**
 * IpfRuleFilter
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
                    data:{id: $("#id").val(),filterCode: $("#filterCode").val(),filterName: $("#filterName").val(),filterDesc: $("#filterDesc").val(),filterExpress: $("#filterExpress").val(),isActive: $("#isActive").val(),isSystemCreate: $("#isSystemCreate").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boName: $("#boName").val()},
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
                    data:{id: $("#id").val(),filterCode: $("#filterCode").val(),filterName: $("#filterName").val(),filterDesc: $("#filterDesc").val(),filterExpress: $("#filterExpress").val(),isActive: $("#isActive").val(),isSystemCreate: $("#isSystemCreate").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boName: $("#boName").val()},
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
    
    var PlatformIpfRuleFilterManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfRuleFilter_manage": "showPlatformIpfRuleFilterManageList",  
            "basic_manage/platform_ckIpfRuleFilter_manage": "showPlatformckIpfRuleFilterManageList"
        },
        showPlatformckIpfRuleFilterManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfRuleFilterManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfRuleFilterManageListView = new SimpleListView({
                id: "platform_ipfRuleFilter_manage_list",
                title: "基础管理 > IpfRuleFilter",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfRuleFilter");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfilterCode' align='right'>筛选编号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='filterCode' name='筛选编号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfilterName' align='right'>筛选名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='filterName' name='筛选名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfilterDesc' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='filterDesc' name='描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfilterExpress' align='right'>筛选条件表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='filterExpress' name='筛选条件表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisActive' align='right'>有效：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='有效' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSystemCreate' align='right'>系统创建：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSystemCreate' name='系统创建' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoId' align='right'>业务对象ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoId' name='业务对象ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboName' align='right'>业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boName' name='业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfRuleFilter.createIpfRuleFilter&v=1.0&format=json",$(detailstr),280);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfRuleFilterManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfRuleFilterManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfRuleFilterManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfRuleFilter.deleteIpfRuleFilter&v=1.0&format=json",
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
                        detailstr+="<label id='lfilterCode' align='right'>筛选编号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='filterCode' name='筛选编号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfilterName' align='right'>筛选名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='filterName' name='筛选名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfilterDesc' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='filterDesc' name='描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfilterExpress' align='right'>筛选条件表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='filterExpress' name='筛选条件表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisActive' align='right'>有效：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='有效' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSystemCreate' align='right'>系统创建：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSystemCreate' name='系统创建' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoId' align='right'>业务对象ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoId' name='业务对象ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboName' align='right'>业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boName' name='业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfRuleFilter.selectIpfRuleFilter&v=1.0&format=json",$(detailstr),280);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfRuleFilter.selectIpfRuleFilter&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },filterCode: { type: "string" },filterName: { type: "string" },filterDesc: { type: "string" },filterExpress: { type: "string" },isActive: { type: "string" },isSystemCreate: { type: "string" },ipfCcmBoId: { type: "string" },boName: { type: "string" }
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
                            result = platformIpfRuleFilterManageListView.appendColValue(result);
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
                    		{field: "filterCode", title:"筛选编号", align:"center", width: "100px"},
                    		{field: "filterName", title:"筛选名称", align:"center", width: "100px"},
                    		{field: "filterDesc", title:"描述", align:"center", width: "100px"},
                    		{field: "filterExpress", title:"筛选条件表达式", align:"center", width: "100px"},
                    		{field: "isActive", title:"有效", align:"center", width: "100px"},
                    		{field: "isSystemCreate", title:"系统创建", align:"center", width: "100px"},
                    		{field: "ipfCcmBoId", title:"业务对象ID", align:"center", width: "100px"},
                    		{field: "boName", title:"业务对象名称", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfRuleFilterManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfRuleFilterManageListView.get("columns");
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
                                detailstr+="<label id='lfilterCode' align='right'>筛选编号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='filterCode' name='筛选编号' value='"+ColumnValue["filterCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfilterName' align='right'>筛选名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='filterName' name='筛选名称' value='"+ColumnValue["filterName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfilterDesc' align='right'>描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='filterDesc' name='描述' value='"+ColumnValue["filterDesc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfilterExpress' align='right'>筛选条件表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='filterExpress' name='筛选条件表达式' value='"+ColumnValue["filterExpress"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisActive' align='right'>有效：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isActive' name='有效' value='"+ColumnValue["isActive"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisSystemCreate' align='right'>系统创建：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isSystemCreate' name='系统创建' value='"+ColumnValue["isSystemCreate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lipfCcmBoId' align='right'>业务对象ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmBoId' name='业务对象ID' value='"+ColumnValue["ipfCcmBoId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lboName' align='right'>业务对象名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boName' name='业务对象名称' value='"+ColumnValue["boName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfRuleFilter.updateIpfRuleFilter&v=1.0&format=json", $(detailstr),280);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfRuleFilterManageListView);
        }
    });

    return PlatformIpfRuleFilterManageRouter;
});


/**
 * IpfCcmUiLayoutList
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
    "js/app/ruledesign/routers/PlatformIpfCcmUiLayoutSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfCcmUiLayoutSelDialog,
		AjaxEngine){    
	
    function showIpfCcmUiLayoutSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfCcmUiLayoutgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfCcmUiLayoutSelDialog.showGridData($("#IpfCcmUiLayoutgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.uiLayoutName;
            $("#ipfCcmUiLayoutId").val(Id);
            $("#IpfCcmUiLayoutName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 380, height, titles);
        
    	
        
        
        var IpfCcmUiLayoutviewModel = kendo.observable({
            id: $("#ipfCcmUiLayoutId").val(),
            name: $("#IpfCcmUiLayoutName").val(),
            displayGreeting: function() {
            showIpfCcmUiLayoutSelDialog();
            }
        });
        kendo.bind($("#viewIpfCcmUiLayout"), IpfCcmUiLayoutviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ipfCcmUiLayoutId: $("#ipfCcmUiLayoutId").val(),pageName: $("#pageName").val(),description: $("#description").val(),imagePath: $("#imagePath").val()},
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
                    data:{id: $("#id").val(),ipfCcmUiLayoutId: $("#ipfCcmUiLayoutId").val(),pageName: $("#pageName").val(),description: $("#description").val(),imagePath: $("#imagePath").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfCcmUiLayoutName"] = PlatformIpfCcmUiLayoutSelDialog.codetodes(data["ipfCcmUiLayoutId"]);

        						
        						
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
    
    var PlatformIpfCcmUiLayoutListManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmUiLayoutList_manage": "showPlatformIpfCcmUiLayoutListManageList",  
            "basic_manage/platform_ckIpfCcmUiLayoutList_manage": "showPlatformckIpfCcmUiLayoutListManageList"
        },
        showPlatformckIpfCcmUiLayoutListManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmUiLayoutListManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmUiLayoutListManageListView = new SimpleListView({
                id: "platform_ipfCcmUiLayoutList_manage_list",
                title: "基础数据 > 界面布局列表",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("界面布局列表");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfCcmUiLayoutId' align='right'>界面布局：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfCcmUiLayout'>";                        
                        detailstr+="<input id='ipfCcmUiLayoutId' name='ipfCcmUiLayoutId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfCcmUiLayoutName' name='IpfCcmUiLayoutName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lpageName' align='right'>名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='pageName' name='名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldescription' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='description' name='描述' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='limagePath' align='right'>图片路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='imagePath' name='图片路径' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmUiLayoutList.createIpfCcmUiLayoutList&v=1.0&format=json",$(detailstr),182);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmUiLayoutListManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmUiLayoutListManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmUiLayoutListManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmUiLayoutList.deleteIpfCcmUiLayoutList&v=1.0&format=json",
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
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfCcmUiLayoutId' align='right'>界面布局：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfCcmUiLayout'>";                        
                        detailstr+="<input id='ipfCcmUiLayoutId' name='ipfCcmUiLayoutId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfCcmUiLayoutName' name='IpfCcmUiLayoutName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lpageName' align='right'>名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='pageName' name='名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldescription' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='description' name='描述' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='limagePath' align='right'>图片路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='imagePath' name='图片路径' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmUiLayoutList.selectIpfCcmUiLayoutList&v=1.0&format=json",$(detailstr),182);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmUiLayoutList.selectIpfCcmUiLayoutList&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmUiLayoutId: { type: "string" },pageName: { type: "string" },description: { type: "string" },imagePath: { type: "string" }
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
                                    data["IpfCcmUiLayoutName"] = PlatformIpfCcmUiLayoutSelDialog.codetodes(data["ipfCcmUiLayoutId"]);
                                }
                            }
                            result = platformIpfCcmUiLayoutListManageListView.appendColValue(result);
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
                    		{field: "ipfCcmUiLayoutId", title:"界面布局", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfCcmUiLayoutName", title:"界面布局", align:"center", width: "100px"},
                    		{field: "pageName", title:"名称", align:"center", width: "100px"},
                    		{field: "description", title:"描述", align:"center", width: "100px"},
                    		{field: "imagePath", title:"图片路径", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmUiLayoutListManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmUiLayoutListManageListView.get("columns");
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
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lipfCcmUiLayoutId' align='right'>界面布局：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfCcmUiLayout'>";                        
                                detailstr+="<input id='ipfCcmUiLayoutId' name='ipfCcmUiLayoutId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfCcmUiLayoutId"]+"' style='...'/>";
                                detailstr+="<input id='IpfCcmUiLayoutName' name='IpfCcmUiLayoutName' data-bind='value: name' value='"+PlatformIpfCcmUiLayoutSelDialog.codetodes(ColumnValue["ipfCcmUiLayoutId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lpageName' align='right'>名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='pageName' name='名称' value='"+ColumnValue["pageName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldescription' align='right'>描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='description' name='描述' value='"+ColumnValue["description"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='limagePath' align='right'>图片路径：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='imagePath' name='图片路径' value='"+ColumnValue["imagePath"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmUiLayoutList.updateIpfCcmUiLayoutList&v=1.0&format=json", $(detailstr),182);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmUiLayoutListManageListView);
        }
    });

    return PlatformIpfCcmUiLayoutListManageRouter;
});

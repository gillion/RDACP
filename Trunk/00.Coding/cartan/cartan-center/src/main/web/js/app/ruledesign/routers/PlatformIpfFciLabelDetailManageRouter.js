
/**
 * IpfFciLabelDetail
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
    "js/app/ruledesign/routers/PlatformIpfFciViewSelDialog",
    "js/app/ruledesign/routers/PlatformIpfFciLabelSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfFciViewSelDialog,
		PlatformIpfFciLabelSelDialog,
		AjaxEngine){    
	
    function showIpfFciViewSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfFciViewgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfFciViewSelDialog.showGridData($("#IpfFciViewgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.viewName;
            $("#ipfFciViewId").val(Id);
            $("#IpfFciViewName").val(Name);
            kendoUIWindow.close();
        });
    }
    function showIpfFciLabelSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfFciLabelgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfFciLabelSelDialog.showGridData($("#IpfFciLabelgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.labelName;
            $("#ipfFciLabelId").val(Id);
            $("#IpfFciLabelName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 730, height, titles);
        
    	
        
        
        var IpfFciViewviewModel = kendo.observable({
            id: $("#ipfFciViewId").val(),
            name: $("#IpfFciViewName").val(),
            displayGreeting: function() {
            showIpfFciViewSelDialog();
            }
        });
        kendo.bind($("#viewIpfFciView"), IpfFciViewviewModel);
        var IpfFciLabelviewModel = kendo.observable({
            id: $("#ipfFciLabelId").val(),
            name: $("#IpfFciLabelName").val(),
            displayGreeting: function() {
            showIpfFciLabelSelDialog();
            }
        });
        kendo.bind($("#viewIpfFciLabel"), IpfFciLabelviewModel);

        var isActiveModel = kendo.observable({
            isChecked: $("#isActive").val()=="1"
        });
        kendo.bind($("#isActive"), isActiveModel);
        var isActiveval="0";
		
        if (tp==1){
        $("#submitBtn").click(function(){    	
            if (isActiveModel.isChecked){
            	isActiveval="1";
            } else {
            	isActiveval="0";
            }
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ipfFciLabelId: $("#ipfFciLabelId").val(),ipfFciViewId: $("#ipfFciViewId").val(),configItemType: $("#configItemType").val(),configItemCode: $("#configItemCode").val(),configItemId: $("#configItemId").val(),revisionNumber: $("#revisionNumber").val(),relationMemberId: $("#relationMemberId").val(),isActive: isActiveval},
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
                if (isActiveModel.isChecked){
                	isActiveval="1";
                } else {
                	isActiveval="";
                }
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),ipfFciLabelId: $("#ipfFciLabelId").val(),ipfFciViewId: $("#ipfFciViewId").val(),configItemType: $("#configItemType").val(),configItemCode: $("#configItemCode").val(),configItemId: $("#configItemId").val(),revisionNumber: $("#revisionNumber").val(),relationMemberId: $("#relationMemberId").val(),isActive:isActiveval},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfFciViewName"] = PlatformIpfFciViewSelDialog.codetodes(data["ipfFciViewId"]);
                                data["IpfFciLabelName"] = PlatformIpfFciLabelSelDialog.codetodes(data["ipfFciLabelId"]);

        						
        						
                        		data["isActiveName"] = SimpleListUtil.getSelectDes("T014", data["isActive"]);
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
    
    var PlatformIpfFciLabelDetailManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfFciLabelDetail_manage": "showPlatformIpfFciLabelDetailManageList",  
            "basic_manage/platform_ckIpfFciLabelDetail_manage": "showPlatformckIpfFciLabelDetailManageList"
        },
        showPlatformckIpfFciLabelDetailManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfFciLabelDetailManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfFciLabelDetailManageListView = new SimpleListView({
                id: "platform_ipfFciLabelDetail_manage_list",
                title: "项目管理 > 基线明细",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("基线明细");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfFciLabelId' align='right'>基线：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciLabel'>";                        
                        detailstr+="<input id='ipfFciLabelId' name='ipfFciLabelId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciLabelName' name='IpfFciLabelName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lipfFciViewId' align='right'>视图：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciView'>";                        
                        detailstr+="<input id='ipfFciViewId' name='ipfFciViewId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciViewName' name='IpfFciViewName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lconfigItemType' align='right'>配置项名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='configItemType' name='配置项名称' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lconfigItemCode' align='right'>配置项代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='configItemCode' name='配置项代码' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lconfigItemId' align='right'>配置项ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='configItemId' name='配置项ID' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lrevisionNumber' align='right'>修订号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='revisionNumber' name='修订号' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lrelationMemberId' align='right'>关联成员：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='relationMemberId' name='关联成员' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lisActive' align='right'>启用：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='启用' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfFciLabelDetail.createIpfFciLabelDetail&v=1.0&format=json",$(detailstr),184);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfFciLabelDetailManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfFciLabelDetailManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfFciLabelDetailManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfFciLabelDetail.deleteIpfFciLabelDetail&v=1.0&format=json",
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
                        detailstr+="<label id='lipfFciLabelId' align='right'>基线：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciLabel'>";                        
                        detailstr+="<input id='ipfFciLabelId' name='ipfFciLabelId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciLabelName' name='IpfFciLabelName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lipfFciViewId' align='right'>视图：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfFciView'>";                        
                        detailstr+="<input id='ipfFciViewId' name='ipfFciViewId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfFciViewName' name='IpfFciViewName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lconfigItemType' align='right'>配置项名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='configItemType' name='配置项名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lconfigItemCode' align='right'>配置项代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='configItemCode' name='配置项代码' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lconfigItemId' align='right'>配置项ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='configItemId' name='配置项ID' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lrevisionNumber' align='right'>修订号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='revisionNumber' name='修订号' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lrelationMemberId' align='right'>关联成员：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='relationMemberId' name='关联成员' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lisActive' align='right'>启用：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isActive' name='启用' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfFciLabelDetail.selectIpfFciLabelDetail&v=1.0&format=json",$(detailstr),184);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfFciLabelDetail.selectIpfFciLabelDetail&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfFciLabelId: { type: "string" },ipfFciViewId: { type: "string" },configItemType: { type: "string" },configItemCode: { type: "string" },configItemId: { type: "string" },revisionNumber: { type: "string" },relationMemberId: { type: "string" },isActive: { type: "string" }
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
                                    data["IpfFciViewName"] = PlatformIpfFciViewSelDialog.codetodes(data["ipfFciViewId"]);
                                    data["IpfFciLabelName"] = PlatformIpfFciLabelSelDialog.codetodes(data["ipfFciLabelId"]);
                            		data["isActiveName"] = SimpleListUtil.getSelectDes("T014", data["isActive"]);
                                }
                            }
                            result = platformIpfFciLabelDetailManageListView.appendColValue(result);
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
                    		{field: "ipfFciLabelId", title:"基线", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfFciLabelName", title:"基线", align:"center", width: "100px"},
                    		{field: "ipfFciViewId", title:"视图", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfFciViewName", title:"视图", align:"center", width: "100px"},
                    		{field: "configItemType", title:"配置项名称", align:"center", width: "100px"},
                    		{field: "configItemCode", title:"配置项代码", align:"center", width: "100px"},
                    		{field: "configItemId", title:"配置项ID", align:"center", width: "100px"},
                    		{field: "revisionNumber", title:"修订号", align:"center", width: "100px"},
                    		{field: "relationMemberId", title:"关联成员", align:"center", width: "100px"},
                    		{field: "isActive", title:"启用", hidden:"true", align:"center", width: "100px"},
                    		{field: "isActiveName", title:"启用", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfFciLabelDetailManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfFciLabelDetailManageListView.get("columns");
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
                                detailstr+="<label id='lipfFciLabelId' align='right'>基线：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfFciLabel'>";                        
                                detailstr+="<input id='ipfFciLabelId' name='ipfFciLabelId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfFciLabelId"]+"' style='...'/>";
                                detailstr+="<input id='IpfFciLabelName' name='IpfFciLabelName' data-bind='value: name' value='"+PlatformIpfFciLabelSelDialog.codetodes(ColumnValue["ipfFciLabelId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lipfFciViewId' align='right'>视图：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfFciView'>";                        
                                detailstr+="<input id='ipfFciViewId' name='ipfFciViewId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfFciViewId"]+"' style='...'/>";
                                detailstr+="<input id='IpfFciViewName' name='IpfFciViewName' data-bind='value: name' value='"+PlatformIpfFciViewSelDialog.codetodes(ColumnValue["ipfFciViewId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lconfigItemType' align='right'>配置项名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='configItemType' name='配置项名称' value='"+ColumnValue["configItemType"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lconfigItemCode' align='right'>配置项代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='configItemCode' name='配置项代码' value='"+ColumnValue["configItemCode"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lconfigItemId' align='right'>配置项ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='configItemId' name='配置项ID' value='"+ColumnValue["configItemId"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lrevisionNumber' align='right'>修订号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='revisionNumber' name='修订号' value='"+ColumnValue["revisionNumber"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lrelationMemberId' align='right'>关联成员：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='relationMemberId' name='关联成员' value='"+ColumnValue["relationMemberId"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lisActive' align='right'>启用：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='isActive' name='启用' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isActive"]+"' style='...'/>";
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfFciLabelDetail.updateIpfFciLabelDetail&v=1.0&format=json", $(detailstr),184);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfFciLabelDetailManageListView);
        }
    });

    return PlatformIpfFciLabelDetailManageRouter;
});

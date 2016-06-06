
/**
 * 数据集变量
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
    "js/app/ruledesign/routers/PlatformDatasetSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformDatasetSelDialog,
		AjaxEngine){    
	
    function showDatasetSelDialog(){
        var detailstr="";
        detailstr+="<div id='Datasetgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformDatasetSelDialog.showGridData($("#Datasetgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.datasetDes;
            $("#datasetId").val(Id);
            $("#DatasetName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, height, titles);
    	
        var DatasetviewModel = kendo.observable({
            id: $("#datasetId").val(),
            name: $("#DatasetName").val(),
            displayGreeting: function() {
            showDatasetSelDialog();
            }
        });
        kendo.bind($("#viewDataset"), DatasetviewModel);

        var isDerivedModel = kendo.observable({
            isChecked: $("#isDerived").val()=="1"
        });
        kendo.bind($("#isDerived"), isDerivedModel);
        var isDerivedval="0";
		
        var isSetModel = kendo.observable({
            isChecked: $("#isSet").val()=="1"
        });
        kendo.bind($("#isSet"), isSetModel);
        var isSetval="0";
		
        var isOutputModel = kendo.observable({
            isChecked: $("#isOutput").val()=="1"
        });
        kendo.bind($("#isOutput"), isOutputModel);
        var isOutputval="0";
		
        if (tp==1){
        $("#submitBtn").click(function(){    	
            if (isDerivedModel.isChecked){
            	isDerivedval="1";
            } else {
            	isDerivedval="0";
            }
            if (isSetModel.isChecked){
            	isSetval="1";
            } else {
            	isSetval="0";
            }
            if (isOutputModel.isChecked){
            	isOutputval="1";
            } else {
            	isOutputval="0";
            }
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),datasetId: $("#datasetId").val(),varName: $("#varName").val(),varDes: $("#varDes").val(),isDerived: isDerivedval,isSet: isSetval,varType: $("#varType").val(),spanBegin: $("#spanBegin").val(),spanEnd: $("#spanEnd").val(),isOutput: isOutputval,defValue: $("#defValue").val(),remark: $("#remark").val()},
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
                if (isDerivedModel.isChecked){
                	isDerivedval="1";
                } else {
                	isDerivedval="";
                }
                if (isSetModel.isChecked){
                	isSetval="1";
                } else {
                	isSetval="";
                }
                if (isOutputModel.isChecked){
                	isOutputval="1";
                } else {
                	isOutputval="";
                }
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),datasetId: $("#datasetId").val(),varName: $("#varName").val(),varDes: $("#varDes").val(),isDerived:isDerivedval,isSet:isSetval,varType: $("#varType").val(),spanBegin: $("#spanBegin").val(),spanEnd: $("#spanEnd").val(),isOutput:isOutputval,defValue: $("#defValue").val(),remark: $("#remark").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["DatasetName"] = PlatformDatasetSelDialog.codetodes(data["datasetId"]);

                        		data["varTypeName"] = SimpleListUtil.getSelectDes("108", data["varType"]);
        						
                        		data["isDerivedName"] = SimpleListUtil.getSelectDes("109", data["isDerived"]);
                        		data["isSetName"] = SimpleListUtil.getSelectDes("109", data["isSet"]);
                        		data["isOutputName"] = SimpleListUtil.getSelectDes("109", data["isOutput"]);
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
    
    var PlatformDatasetVarManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_DatasetVar_manage": "showPlatformDatasetVarManageList",  
            "basic_manage/platform_ckDatasetVar_manage": "showPlatformckDatasetVarManageList"
        },
        showPlatformckDatasetVarManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformDatasetVarManageList: function(){
            var DatasetId=SimpleListUtil.GetQueryString("id");
            var DatasetName=decodeURI(SimpleListUtil.GetQueryString("name"));
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformDatasetVarManageListView = new SimpleListView({
                id: "platform_datasetVar_manage_list",
                title: "规则管理 > 数据模型 > 变量定义",
                buttonCount:4,

                ready: function(){
                    this.setSimpleListHeader("数据模型 > 变量定义");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldatasetId' align='right'>数据集：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewDataset'>";                        
                        detailstr+="<input id='datasetId' name='datasetId' hidden='true' data-bind='value: id'  value='"+DatasetId+"' style='...'/>";
                        detailstr+="<input id='DatasetName' name='DatasetName' data-bind='value: name'  value='"+DatasetName+"' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarName' align='right'>变量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='varName' name='变量' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarDes' align='right'>变量描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='varDes' name='变量描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisDerived' align='right'>是否衍生：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isDerived' name='是否衍生' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSet' align='right'>是否集合：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSet' name='是否集合' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarType' align='right'>变量类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='变量类型' id='varType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("108","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lspanBegin' align='right'>取值起始：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='spanBegin' name='取值起始' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lspanEnd' align='right'>取值结束：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='spanEnd' name='取值结束' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisOutput' align='right'>是否输出：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isOutput' name='是否输出' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefValue' align='right'>缺省值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defValue' name='缺省值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=datasetVar.createDatasetVar&v=1.0&format=json",$(detailstr),370);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformDatasetVarManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformDatasetVarManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformDatasetVarManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=datasetVar.deleteDatasetVar&v=1.0&format=json",
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
                        detailstr+="<label id='ldatasetId' align='right'>数据集：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewDataset'>";                        
                        detailstr+="<input id='datasetId' name='datasetId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='DatasetName' name='DatasetName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarName' align='right'>变量：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='varName' name='变量' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarDes' align='right'>变量描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='varDes' name='变量描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisDerived' align='right'>是否衍生：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isDerived' name='是否衍生' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSet' align='right'>是否集合：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSet' name='是否集合' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarType' align='right'>变量类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='变量类型' id='varType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("108","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lspanBegin' align='right'>取值起始：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='spanBegin' name='取值起始' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lspanEnd' align='right'>取值结束：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='spanEnd' name='取值结束' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisOutput' align='right'>是否输出：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isOutput' name='是否输出' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefValue' align='right'>缺省值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defValue' name='缺省值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=datasetVar.selectDatasetVar&v=1.0&format=json",$(detailstr),370);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("returnBtn", "数据集", function(){
                        window.location.href ="ruledesign.html#basic_manage/platform_Dataset_manage";
                    }, "createLink");
                },

                dataSource: {
                    serverPaging: false,
                    serverSorting: false,             //排序
                    serverGrouping: false,            //分组
                    group: { field: "DatasetName" },
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=datasetVar.selectDatasetVar&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },datasetId: { type: "string" },varName: { type: "string" },varDes: { type: "string" },isDerived: { type: "string" },isSet: { type: "string" },varType: { type: "string" },spanBegin: { type: "string" },spanEnd: { type: "string" },isOutput: { type: "string" },defValue: { type: "string" },remark: { type: "string" }
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
                                    data["DatasetName"] = PlatformDatasetSelDialog.codetodes(data["datasetId"]);
                            		data["varTypeName"] = SimpleListUtil.getSelectDes("108", data["varType"]);
                            		data["isDerivedName"] = SimpleListUtil.getSelectDes("109", data["isDerived"]);
                            		data["isSetName"] = SimpleListUtil.getSelectDes("109", data["isSet"]);
                            		data["isOutputName"] = SimpleListUtil.getSelectDes("109", data["isOutput"]);
                                }
                            }
                            result = platformDatasetVarManageListView.appendColValue(result);
                            return result;
                        },
                        //记录条数
                        total: function(response) {
                            var result = response["total"] || response["resultJson"].length;
                            return result;
                        }
                    }
                },
                sortable: true,
                groupable: true,
                columns: [
                          {field: "chk", type:"chk", title: "&nbsp;", value:"ID"},
                          {field: "id", title:"主键", hidden:"true", align:"center", width: "100px"},
                    		{field: "datasetId", title:"数据集", hidden:"true", align:"center", width: "100px"},
                    		{field: "DatasetName", title:"数据集", align:"center", width: "100px"},
                    		{field: "varName", title:"变量", align:"center", width: "100px"},
                    		{field: "varDes", title:"变量描述", align:"center", width: "100px"},
                    		{field: "isDerived", title:"是否衍生", hidden:"true", align:"center", width: "100px"},
                    		{field: "isDerivedName", title:"是否衍生", align:"center", width: "100px"},
                    		{field: "isSet", title:"是否集合", hidden:"true", align:"center", width: "100px"},
                    		{field: "isSetName", title:"是否集合", align:"center", width: "100px"},
                    		{field: "varType", title:"变量类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "varTypeName", title:"变量类型", align:"center", width: "100px"},
                    		{field: "spanBegin", title:"取值起始", align:"center", width: "100px"},
                    		{field: "spanEnd", title:"取值结束", align:"center", width: "100px"},
                    		{field: "isOutput", title:"是否输出", hidden:"true", align:"center", width: "100px"},
                    		{field: "isOutputName", title:"是否输出", align:"center", width: "100px"},
                    		{field: "defValue", title:"缺省值", align:"center", width: "100px"},
                    		{field: "remark", title:"备注", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            "text" :{ edit:"修改", cancel: "取消", update: "保存" } ,
                            name: "edit",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformDatasetVarManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformDatasetVarManageListView.get("columns");
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
                                detailstr+="<label id='ldatasetId' align='right'>数据集：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewDataset'>";                        
                                detailstr+="<input id='datasetId' name='datasetId' hidden='true' data-bind='value: id' value='"+ColumnValue["datasetId"]+"' style='...'/>";
                                detailstr+="<input id='DatasetName' name='DatasetName' data-bind='value: name' value='"+PlatformDatasetSelDialog.codetodes(ColumnValue["datasetId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvarName' align='right'>变量：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='varName' name='变量' value='"+ColumnValue["varName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvarDes' align='right'>变量描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='varDes' name='变量描述' value='"+ColumnValue["varDes"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisDerived' align='right'>是否衍生：</label>";
                                detailstr+="</td><td>";
          						
        						
                        		detailstr+="<input id='isDerived' name='是否衍生' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isDerived"]+"' style='...'/>";
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisSet' align='right'>是否集合：</label>";
                                detailstr+="</td><td>";
          						
        						
                        		detailstr+="<input id='isSet' name='是否集合' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isSet"]+"' style='...'/>";
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvarType' align='right'>变量类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='变量类型' id='varType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("108", ColumnValue["varType"]);
                                detailstr+="</select>";
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lspanBegin' align='right'>取值起始：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='spanBegin' name='取值起始' value='"+ColumnValue["spanBegin"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lspanEnd' align='right'>取值结束：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='spanEnd' name='取值结束' value='"+ColumnValue["spanEnd"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisOutput' align='right'>是否输出：</label>";
                                detailstr+="</td><td>";
          						
        						
                        		detailstr+="<input id='isOutput' name='是否输出' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isOutput"]+"' style='...'/>";
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldefValue' align='right'>缺省值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='defValue' name='缺省值' value='"+ColumnValue["defValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='remark' name='备注' value='"+ColumnValue["remark"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=datasetVar.updateDatasetVar&v=1.0&format=json", $(detailstr),370);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformDatasetVarManageListView);
        }
    });

    return PlatformDatasetVarManageRouter;
});

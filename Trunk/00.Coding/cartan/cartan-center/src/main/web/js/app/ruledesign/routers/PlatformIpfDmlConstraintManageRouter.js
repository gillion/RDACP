
/**
 * IpfDmlConstraint
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
    "js/app/ruledesign/routers/PlatformIpfDmlTableSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfDmlTableSelDialog,
		AjaxEngine){    
	
    function showIpfDmlTableSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfDmlTablegrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfDmlTableSelDialog.showGridData($("#IpfDmlTablegrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.tableName;
            $("#ipfDmlTableId").val(Id);
            $("#IpfDmlTableName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 380, height, titles);
        
    	
        
        
        var IpfDmlTableviewModel = kendo.observable({
            id: $("#ipfDmlTableId").val(),
            name: $("#IpfDmlTableName").val(),
            displayGreeting: function() {
            showIpfDmlTableSelDialog();
            }
        });
        kendo.bind($("#viewIpfDmlTable"), IpfDmlTableviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ipfDmlTableId: $("#ipfDmlTableId").val(),constraintName: $("#constraintName").val(),constraintType: $("#constraintType").val(),columnName: $("#columnName").val(),foreignTableName: $("#foreignTableName").val(),foreignColumnName: $("#foreignColumnName").val()},
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
                    data:{id: $("#id").val(),ipfDmlTableId: $("#ipfDmlTableId").val(),constraintName: $("#constraintName").val(),constraintType: $("#constraintType").val(),columnName: $("#columnName").val(),foreignTableName: $("#foreignTableName").val(),foreignColumnName: $("#foreignColumnName").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfDmlTableName"] = PlatformIpfDmlTableSelDialog.codetodes(data["ipfDmlTableId"]);

                        		data["constraintTypeName"] = SimpleListUtil.getSelectDes("T047", data["constraintType"]);
        						
        						
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
    
    var PlatformIpfDmlConstraintManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfDmlConstraint_manage": "showPlatformIpfDmlConstraintManageList",  
            "basic_manage/platform_ckIpfDmlConstraint_manage": "showPlatformckIpfDmlConstraintManageList"
        },
        showPlatformckIpfDmlConstraintManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfDmlConstraintManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfDmlConstraintManageListView = new SimpleListView({
                id: "platform_ipfDmlConstraint_manage_list",
                title: "数据建模 > 表约束",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("表约束");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfDmlTableId' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlTable'>";                        
                        detailstr+="<input id='ipfDmlTableId' name='ipfDmlTableId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlTableName' name='IpfDmlTableName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lconstraintName' align='right'>约束名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='constraintName' name='约束名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lconstraintType' align='right'>约束类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='约束类型' id='constraintType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T047","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lcolumnName' align='right'>字段名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnName' name='字段名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lforeignTableName' align='right'>外关联表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='foreignTableName' name='外关联表名' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lforeignColumnName' align='right'>外关联字段名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='foreignColumnName' name='外关联字段名' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfDmlConstraint.createIpfDmlConstraint&v=1.0&format=json",$(detailstr),242);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfDmlConstraintManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfDmlConstraintManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfDmlConstraintManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfDmlConstraint.deleteIpfDmlConstraint&v=1.0&format=json",
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
                        detailstr+="<label id='lipfDmlTableId' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlTable'>";                        
                        detailstr+="<input id='ipfDmlTableId' name='ipfDmlTableId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlTableName' name='IpfDmlTableName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lconstraintName' align='right'>约束名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='constraintName' name='约束名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lconstraintType' align='right'>约束类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='约束类型' id='constraintType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T047","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lcolumnName' align='right'>字段名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnName' name='字段名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lforeignTableName' align='right'>外关联表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='foreignTableName' name='外关联表名' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lforeignColumnName' align='right'>外关联字段名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='foreignColumnName' name='外关联字段名' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfDmlConstraint.selectIpfDmlConstraint&v=1.0&format=json",$(detailstr),242);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfDmlConstraint.selectIpfDmlConstraint&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfDmlTableId: { type: "string" },constraintName: { type: "string" },constraintType: { type: "string" },columnName: { type: "string" },foreignTableName: { type: "string" },foreignColumnName: { type: "string" }
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
                                    data["IpfDmlTableName"] = PlatformIpfDmlTableSelDialog.codetodes(data["ipfDmlTableId"]);
                            		data["constraintTypeName"] = SimpleListUtil.getSelectDes("T047", data["constraintType"]);
                                }
                            }
                            result = platformIpfDmlConstraintManageListView.appendColValue(result);
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
                    		{field: "ipfDmlTableId", title:"表名", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfDmlTableName", title:"表名", align:"center", width: "100px"},
                    		{field: "constraintName", title:"约束名称", align:"center", width: "100px"},
                    		{field: "constraintType", title:"约束类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "constraintTypeName", title:"约束类型", align:"center", width: "100px"},
                    		{field: "columnName", title:"字段名称", align:"center", width: "100px"},
                    		{field: "foreignTableName", title:"外关联表名", align:"center", width: "100px"},
                    		{field: "foreignColumnName", title:"外关联字段名", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfDmlConstraintManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfDmlConstraintManageListView.get("columns");
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
                                detailstr+="<label id='lipfDmlTableId' align='right'>表名：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfDmlTable'>";                        
                                detailstr+="<input id='ipfDmlTableId' name='ipfDmlTableId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfDmlTableId"]+"' style='...'/>";
                                detailstr+="<input id='IpfDmlTableName' name='IpfDmlTableName' data-bind='value: name' value='"+PlatformIpfDmlTableSelDialog.codetodes(ColumnValue["ipfDmlTableId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lconstraintName' align='right'>约束名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='constraintName' name='约束名称' value='"+ColumnValue["constraintName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lconstraintType' align='right'>约束类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='约束类型' id='constraintType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T047", ColumnValue["constraintType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lcolumnName' align='right'>字段名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnName' name='字段名称' value='"+ColumnValue["columnName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lforeignTableName' align='right'>外关联表名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='foreignTableName' name='外关联表名' value='"+ColumnValue["foreignTableName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lforeignColumnName' align='right'>外关联字段名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='foreignColumnName' name='外关联字段名' value='"+ColumnValue["foreignColumnName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfDmlConstraint.updateIpfDmlConstraint&v=1.0&format=json", $(detailstr),242);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfDmlConstraintManageListView);
        }
    });

    return PlatformIpfDmlConstraintManageRouter;
});

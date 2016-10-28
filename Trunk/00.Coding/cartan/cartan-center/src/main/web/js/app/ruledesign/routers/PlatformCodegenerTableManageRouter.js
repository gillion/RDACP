

/**
 * CodegenerTable
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
    "js/app/ruledesign/routers/PlatformCodegenerSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformCodegenerSelDialog,
		AjaxEngine){    
	
    function showCodegenerSelDialog(){
        var detailstr="";
        detailstr+="<div id='Codegenergrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformCodegenerSelDialog.showGridData($("#Codegenergrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.setupName;
            $("#setupId").val(Id);
            $("#CodegenerName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 380, height, titles);
        
    	
        
        
        var CodegenerviewModel = kendo.observable({
            id: $("#setupId").val(),
            name: $("#CodegenerName").val(),
            displayGreeting: function() {
            showCodegenerSelDialog();
            }
        });
        kendo.bind($("#viewCodegener"), CodegenerviewModel);

        var isNewBsclassModel = kendo.observable({
            isChecked: $("#isNewBsclass").val()=="1"
        });
        kendo.bind($("#isNewBsclass"), isNewBsclassModel);
        var isNewBsclassval="0";
		
        if (tp==1){
        $("#submitBtn").click(function(){
            if (isNewBsclassModel.isChecked){
            	isNewBsclassval="1";
            } else {
            	isNewBsclassval="0";
            }
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),setupId: $("#setupId").val(),tableName: $("#tableName").val(),tableDes: $("#tableDes").val(),parentTableName: $("#parentTableName").val(),noParent: $("#noParent").val(),isNewBsclass: isNewBsclassval,pageSize: $("#pageSize").val()},
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
                if (noParentModel.isChecked){
                	noParentval="1";
                } else {
                	noParentval="";
                }
                if (isNewBsclassModel.isChecked){
                	isNewBsclassval="1";
                } else {
                	isNewBsclassval="";
                }
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),setupId: $("#setupId").val(),tableName: $("#tableName").val(),tableDes: $("#tableDes").val(),parentTableName: $("#parentTableName").val(),noParent:$("#noParent").val(),isNewBsclass:isNewBsclassval,pageSize: $("#pageSize").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        var sid=SimpleListUtil.getSessionId();
                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["CodegenerName"] = PlatformCodegenerSelDialog.codetodes(data["setupId"],sid);

        						
        						
                        		data["noParentName"] = SimpleListUtil.getSelectDes("110", data["noParent"]);
                        		data["isNewBsclassName"] = SimpleListUtil.getSelectDes("109", data["isNewBsclass"]);
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
    
    var PlatformCodegenerTableManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_CodegenerTable_manage": "showPlatformCodegenerTableManageList",  
            "basic_manage/platform_ckCodegenerTable_manage": "showPlatformckCodegenerTableManageList"
        },
        showPlatformckCodegenerTableManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformCodegenerTableManageList: function(){
            var CodegenerTableId=SimpleListUtil.GetQueryString("id");
            var CodegenerTableName=decodeURI(SimpleListUtil.GetQueryString("name"));
            var sid=SimpleListUtil.getSessionId();

            //var sid=SimpleListUtil.getSessionId();
            var platformCodegenerTableManageListView = new SimpleListView({
                id: "platform_codegenerTable_manage_list",
                title: "基础数据 > 关联模型",
                buttonCount:4,
                
                ready: function(){
                    this.setSimpleListHeader("关联模型");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  

						
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsetupId' align='right'>配置名称：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewCodegener'>";                        
                        detailstr+="<input id='setupId' name='setupId' hidden='true' data-bind='value: id' value='"+CodegenerTableId+"' style='...'/>";
                        detailstr+="<input id='CodegenerName' name='CodegenerName' data-bind='value: name' value='"+CodegenerTableName+"' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltableName' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableName' name='表名' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltableDes' align='right'>中文描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableDes' name='中文描述' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lparentTableName' align='right'>继承表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='parentTableName' name='继承表名' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lnoParent' align='right'>模板类型：</label>";
                        detailstr+="</td><td>";

                        detailstr+="<select name='模板类型' id='noParent' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("110","");
                        detailstr+="</select>";
                		detailstr+="</td>";
                        detailstr+="</tr>";
                        

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisNewBsclass' align='right'>是否新建业务类：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNewBsclass' name='是否新建业务类' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lpageSize' align='right'>编辑列数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='pageSize' name='编辑列数' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=codegenerTable.createCodegenerTable&v=1.0&format=json",$(detailstr),272);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformCodegenerTableManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformCodegenerTableManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformCodegenerTableManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=codegenerTable.deleteCodegenerTable&v=1.0&format=json",
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
                        detailstr+="<label id='lsetupId' align='right'>配置名称：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewCodegener'>";                        
                        detailstr+="<input id='setupId' name='setupId' hidden='true' data-bind='value: id' value='"+CodegenerTableId+"'  style='...'/>";
                        detailstr+="<input id='CodegenerName' name='CodegenerName' data-bind='value: name' value='"+CodegenerTableName+"' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltableName' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableName' name='表名' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltableDes' align='right'>中文描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableDes' name='中文描述' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lparentTableName' align='right'>继承表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='parentTableName' name='继承表名' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lnoParent' align='right'>模板类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='模板类型' id='noParent' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("110","");
                        detailstr+="</select>";
                        detailstr+="</td>";
                        detailstr+="</tr>";

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisNewBsclass' align='right'>是否新建业务类：</label>";
                        detailstr+="</td><td>";

                		detailstr+="<input id='isNewBsclass' name='是否新建业务类' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";
                        detailstr+="</tr>";

						
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lpageSize' align='right'>编辑列数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='pageSize' name='编辑列数' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=codegenerTable.selectCodegenerTable&v=1.0&format=json",$(detailstr),272);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("returnBtn", "返回", function(){
                        window.location.href ="ruledesign.html#basic_manage/platform_Codegener_manage";
                    }, "createLink");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=codegenerTable.selectCodegenerTable&v=1.0&format=json&setupId="+CodegenerTableId+""
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },setupId: { type: "string" },tableName: { type: "string" },tableDes: { type: "string" },parentTableName: { type: "string" },noParent: { type: "string" },isNewBsclass: { type: "string" },pageSize: { type: "string" }
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
                                    data["CodegenerName"] = PlatformCodegenerSelDialog.codetodes(data["setupId"],sid);
                            		data["noParentName"] = SimpleListUtil.getSelectDes("110", data["noParent"]);
                            		data["isNewBsclassName"] = SimpleListUtil.getSelectDes("109", data["isNewBsclass"]);
                                }
                            }
                            result = platformCodegenerTableManageListView.appendColValue(result);
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


                    		{field: "setupId", title:"配置名称", hidden:"true", align:"center", width: "100px"},
                    		{field: "CodegenerName", title:"配置名称", align:"center", width: "100px"},


                    		{field: "tableName", title:"表名", align:"center", width: "100px"},


                    		{field: "tableDes", title:"中文描述", align:"center", width: "100px"},


                    		{field: "parentTableName", title:"继承表名", align:"center", width: "100px"},


                    		{field: "noParent", title:"模板类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "noParentName", title:"模板类型", align:"center", width: "100px"},


                    		{field: "isNewBsclass", title:"是否新建业务类", hidden:"true", align:"center", width: "100px"},
                    		{field: "isNewBsclassName", title:"是否新建业务类", align:"center", width: "100px"},


                    		{field: "pageSize", title:"编辑列数", align:"center", width: "100px"},

                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformCodegenerTableManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformCodegenerTableManageListView.get("columns");
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
                                detailstr+="<label id='lsetupId' align='right'>配置名称：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewCodegener'>";                        
                                detailstr+="<input id='setupId' name='setupId' hidden='true' data-bind='value: id' value='"+ColumnValue["setupId"]+"' style='...'/>";
                                detailstr+="<input id='CodegenerName' name='CodegenerName' data-bind='value: name' value='"+PlatformCodegenerSelDialog.codetodes(ColumnValue["setupId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";

                                
        						
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ltableName' align='right'>表名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tableName' name='表名' value='"+ColumnValue["tableName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";

                                
        						
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ltableDes' align='right'>中文描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tableDes' name='中文描述' value='"+ColumnValue["tableDes"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";

                                
        						
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lparentTableName' align='right'>继承表名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='parentTableName' name='继承表名' value='"+ColumnValue["parentTableName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";

                                
        						
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lnoParent' align='right'>模板类型：</label>";
                                detailstr+="</td><td>";


                                detailstr+="<select name='模板类型' id='noParent' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("110",ColumnValue["noParent"]);
                                detailstr+="</select>";

                                detailstr+="</td>";
                                detailstr+="</tr>";

                                
        						
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lisNewBsclass' align='right'>是否新建业务类：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='isNewBsclass' name='是否新建业务类' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isNewBsclass"]+"' style='...'/>";
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";

                                
        						
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lpageSize' align='right'>编辑列数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='pageSize' name='编辑列数' value='"+ColumnValue["pageSize"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";

				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=codegenerTable.updateCodegenerTable&v=1.0&format=json", $(detailstr),272);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformCodegenerTableManageListView);
            //SimpleListUtil.ckSession(sid);            
        }
    });

    return PlatformCodegenerTableManageRouter;
});

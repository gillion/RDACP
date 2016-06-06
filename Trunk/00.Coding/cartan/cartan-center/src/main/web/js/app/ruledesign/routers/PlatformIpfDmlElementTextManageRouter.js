
/**
 * IpfDmlElementText
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
    "js/app/ruledesign/routers/PlatformIpfDmlElementSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformIpfDmlElementSelDialog,
		AjaxEngine){    
	
    function showIpfDmlElementSelDialog(){
        var detailstr="";
        detailstr+="<div id='IpfDmlElementgrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformIpfDmlElementSelDialog.showGridData($("#IpfDmlElementgrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.fieldText;
            $("#ipfDmlElementId").val(Id);
            $("#IpfDmlElementName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 380, height, titles);
        
    	
        
        
        var IpfDmlElementviewModel = kendo.observable({
            id: $("#ipfDmlElementId").val(),
            name: $("#IpfDmlElementName").val(),
            displayGreeting: function() {
            showIpfDmlElementSelDialog();
            }
        });
        kendo.bind($("#viewIpfDmlElement"), IpfDmlElementviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),ipfDmlElementId: $("#ipfDmlElementId").val(),ddLanguage: $("#ddLanguage").val(),ddText: $("#ddText").val()},
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
                    data:{id: $("#id").val(),ipfDmlElementId: $("#ipfDmlElementId").val(),ddLanguage: $("#ddLanguage").val(),ddText: $("#ddText").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["IpfDmlElementName"] = PlatformIpfDmlElementSelDialog.codetodes(data["ipfDmlElementId"]);

                        		data["ddLanguageName"] = SimpleListUtil.getSelectDes("T004", data["ddLanguage"]);
        						
        						
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
    
    var PlatformIpfDmlElementTextManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfDmlElementText_manage": "showPlatformIpfDmlElementTextManageList",  
            "basic_manage/platform_ckIpfDmlElementText_manage": "showPlatformckIpfDmlElementTextManageList"
        },
        showPlatformckIpfDmlElementTextManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfDmlElementTextManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfDmlElementTextManageListView = new SimpleListView({
                id: "platform_ipfDmlElementText_manage_list",
                title: "数据建模 > 数据元素多语言",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("数据元素多语言");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfDmlElementId' align='right'>数据元素：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlElement'>";                        
                        detailstr+="<input id='ipfDmlElementId' name='ipfDmlElementId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlElementName' name='IpfDmlElementName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lddLanguage' align='right'>语言：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='语言' id='ddLanguage' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T004","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lddText' align='right'>文本描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ddText' name='文本描述' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfDmlElementText.createIpfDmlElementText&v=1.0&format=json",$(detailstr),152);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfDmlElementTextManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfDmlElementTextManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfDmlElementTextManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfDmlElementText.deleteIpfDmlElementText&v=1.0&format=json",
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
                        detailstr+="<label id='lipfDmlElementId' align='right'>数据元素：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewIpfDmlElement'>";                        
                        detailstr+="<input id='ipfDmlElementId' name='ipfDmlElementId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='IpfDmlElementName' name='IpfDmlElementName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lddLanguage' align='right'>语言：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='语言' id='ddLanguage' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T004","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lddText' align='right'>文本描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ddText' name='文本描述' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfDmlElementText.selectIpfDmlElementText&v=1.0&format=json",$(detailstr),152);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfDmlElementText.selectIpfDmlElementText&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfDmlElementId: { type: "string" },ddLanguage: { type: "string" },ddText: { type: "string" }
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
                                    data["IpfDmlElementName"] = PlatformIpfDmlElementSelDialog.codetodes(data["ipfDmlElementId"]);
                            		data["ddLanguageName"] = SimpleListUtil.getSelectDes("T004", data["ddLanguage"]);
                                }
                            }
                            result = platformIpfDmlElementTextManageListView.appendColValue(result);
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
                    		{field: "ipfDmlElementId", title:"数据元素", hidden:"true", align:"center", width: "100px"},
                    		{field: "IpfDmlElementName", title:"数据元素", align:"center", width: "100px"},
                    		{field: "ddLanguage", title:"语言", hidden:"true", align:"center", width: "100px"},
                    		{field: "ddLanguageName", title:"语言", align:"center", width: "100px"},
                    		{field: "ddText", title:"文本描述", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfDmlElementTextManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfDmlElementTextManageListView.get("columns");
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
                                detailstr+="<label id='lipfDmlElementId' align='right'>数据元素：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewIpfDmlElement'>";                        
                                detailstr+="<input id='ipfDmlElementId' name='ipfDmlElementId' hidden='true' data-bind='value: id' value='"+ColumnValue["ipfDmlElementId"]+"' style='...'/>";
                                detailstr+="<input id='IpfDmlElementName' name='IpfDmlElementName' data-bind='value: name' value='"+PlatformIpfDmlElementSelDialog.codetodes(ColumnValue["ipfDmlElementId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lddLanguage' align='right'>语言：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='语言' id='ddLanguage' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T004", ColumnValue["ddLanguage"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lddText' align='right'>文本描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ddText' name='文本描述' value='"+ColumnValue["ddText"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfDmlElementText.updateIpfDmlElementText&v=1.0&format=json", $(detailstr),152);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfDmlElementTextManageListView);
        }
    });

    return PlatformIpfDmlElementTextManageRouter;
});

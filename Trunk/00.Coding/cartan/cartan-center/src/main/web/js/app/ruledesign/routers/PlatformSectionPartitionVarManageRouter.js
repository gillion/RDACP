
/**
 * 分段细分变量
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
    "js/app/ruledesign/routers/PlatformSectionPartitionSelDialog",
    "rpc/AjaxEngine"
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, 
		PlatformSectionPartitionSelDialog,
		AjaxEngine){    
	
    function showSectionPartitionSelDialog(){
        var detailstr="";
        detailstr+="<div id='SectionPartitiongrid' style='height: 378px'></div>";
    	var kendoUIWindow = SimpleListUtil.showkdDialog("sel", $(detailstr), 850, 398,"选择");
    	var detailgrid = PlatformSectionPartitionSelDialog.showGridData($("#SectionPartitiongrid"));
    	
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
        });
        detailgrid.on('dblclick', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Id = data.id;
            var Name = data.sectionName;
            $("#sectionParitionId").val(Id);
            $("#SectionPartitionName").val(Name);
            kendoUIWindow.close();
        });
    }
    
    function showEditDetilDialog(tp, titles, id, url, content, height){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, height, titles);
    	
        var SectionPartitionviewModel = kendo.observable({
            id: $("#sectionParitionId").val(),
            name: $("#SectionPartitionName").val(),
            displayGreeting: function() {
            showSectionPartitionSelDialog();
            }
        });
        kendo.bind($("#viewSectionPartition"), SectionPartitionviewModel);

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),sectionParitionId: $("#sectionParitionId").val(),varName: $("#varName").val(),sectionLowerMark: $("#sectionLowerMark").val(),sectionLowerLimit: $("#sectionLowerLimit").val(),sectionUpperMark: $("#sectionUpperMark").val(),sectionUpperLimit: $("#sectionUpperLimit").val()},
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
                    data:{id: $("#id").val(),sectionParitionId: $("#sectionParitionId").val(),varName: $("#varName").val(),sectionLowerMark: $("#sectionLowerMark").val(),sectionLowerLimit: $("#sectionLowerLimit").val(),sectionUpperMark: $("#sectionUpperMark").val(),sectionUpperLimit: $("#sectionUpperLimit").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];
                                data["SectionPartitionName"] = PlatformSectionPartitionSelDialog.codetodes(data["sectionParitionId"]);

                        		data["sectionLowerMarkName"] = SimpleListUtil.getSelectDes("104", data["sectionLowerMark"]);
                        		data["sectionUpperMarkName"] = SimpleListUtil.getSelectDes("104", data["sectionUpperMark"]);
        						
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
    
    var PlatformSectionPartitionVarManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_SectionPartitionVar_manage": "showPlatformSectionPartitionVarManageList",  
            "basic_manage/platform_ckSectionPartitionVar_manage": "showPlatformckSectionPartitionVarManageList"
        },
        showPlatformckSectionPartitionVarManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformSectionPartitionVarManageList: function(){
            var sectionParitionId=SimpleListUtil.GetQueryString("id");
            var SectionPartitionName=decodeURI(SimpleListUtil.GetQueryString("name"));
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformSectionPartitionVarManageListView = new SimpleListView({
                id: "platform_sectionPartitionVar_manage_list",
                title: "基础管理 > 分段细分 > 变量定义",
                buttonCount:4,

                ready: function(){
                    this.setSimpleListHeader("分段细分 > 变量定义");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsectionParitionId' align='right'>分段模型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewSectionPartition'>";                        
                        detailstr+="<input id='sectionParitionId' name='sectionParitionId' hidden='true' data-bind='value: id' value='"+sectionParitionId+"' style='...'/>";
                        detailstr+="<input id='SectionPartitionName' name='SectionPartitionName' data-bind='value: name' value='"+SectionPartitionName+"' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarName' align='right'>变量名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='varName' name='变量名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsectionLowerMark' align='right'>下限符号：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='下限符号' id='sectionLowerMark' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("104","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsectionLowerLimit' align='right'>下限：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sectionLowerLimit' name='下限' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsectionUpperMark' align='right'>上限符号：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='上限符号' id='sectionUpperMark' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("104","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsectionUpperLimit' align='right'>上限：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sectionUpperLimit' name='上限' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=sectionPartitionVar.createSectionPartitionVar&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformSectionPartitionVarManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformSectionPartitionVarManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformSectionPartitionVarManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=sectionPartitionVar.deleteSectionPartitionVar&v=1.0&format=json",
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
                        detailstr+="<label id='lsectionParitionId' align='right'>分段模型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<div id='viewSectionPartition'>";                        
                        detailstr+="<input id='sectionParitionId' name='sectionParitionId' hidden='true' data-bind='value: id' style='...'/>";
                        detailstr+="<input id='SectionPartitionName' name='SectionPartitionName' data-bind='value: name' style='...'/>";
                        detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                        detailstr+="</div>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvarName' align='right'>变量名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='varName' name='变量名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsectionLowerMark' align='right'>下限符号：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='下限符号' id='sectionLowerMark' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("104","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsectionLowerLimit' align='right'>下限：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sectionLowerLimit' name='下限' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsectionUpperMark' align='right'>上限符号：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='上限符号' id='sectionUpperMark' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("104","");
                        detailstr+="</select>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsectionUpperLimit' align='right'>上限：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sectionUpperLimit' name='上限' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=sectionPartitionVar.selectSectionPartitionVar&v=1.0&format=json",$(detailstr),220);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("returnBtn", "返回", function(){
                       // window.location.href ="ruledesign.html#basic_manage/platform_SectionPartition_manage";
                        window.location.href ="ruletree.html#basic_manage/platform_SectionPartition_manage_edit";

                    }, "createLink");
                },

                dataSource: {
                    serverSorting: false,             //排序
                    serverGrouping: false,            //分组
                    group: { field: "SectionPartitionName" },
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=sectionPartitionVar.selectSectionPartitionVar&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },sectionParitionId: { type: "string" },varName: { type: "string" },sectionLowerMark: { type: "string" },sectionLowerLimit: { type: "string" },sectionUpperMark: { type: "string" },sectionUpperLimit: { type: "string" }
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
                                    data["SectionPartitionName"] = PlatformSectionPartitionSelDialog.codetodes(data["sectionParitionId"]);
                            		data["sectionLowerMarkName"] = SimpleListUtil.getSelectDes("104", data["sectionLowerMark"]);
                            		data["sectionUpperMarkName"] = SimpleListUtil.getSelectDes("104", data["sectionUpperMark"]);
                                }
                            }
                            result = platformSectionPartitionVarManageListView.appendColValue(result);
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
                    		{field: "sectionParitionId", title:"分段模型", hidden:"true", align:"center", width: "100px"},
                    		{field: "SectionPartitionName", title:"分段模型", align:"center", width: "100px"},
                    		{field: "varName", title:"变量名称", align:"center", width: "100px"},
                    		{field: "sectionLowerMark", title:"下限符号", hidden:"true", align:"center", width: "100px"},
                    		{field: "sectionLowerMarkName", title:"下限符号", align:"center", width: "100px"},
                    		{field: "sectionLowerLimit", title:"下限", align:"center", width: "100px"},
                    		{field: "sectionUpperMark", title:"上限符号", hidden:"true", align:"center", width: "100px"},
                    		{field: "sectionUpperMarkName", title:"上限符号", align:"center", width: "100px"},
                    		{field: "sectionUpperLimit", title:"上限", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            "text" :{ edit:"修改", cancel: "取消", update: "保存" } ,
                            name: "edit",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformSectionPartitionVarManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformSectionPartitionVarManageListView.get("columns");
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
                                detailstr+="<label id='lsectionParitionId' align='right'>分段模型：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<div id='viewSectionPartition'>";                        
                                detailstr+="<input id='sectionParitionId' name='sectionParitionId' hidden='true' data-bind='value: id' value='"+ColumnValue["sectionParitionId"]+"' style='...'/>";
                                detailstr+="<input id='SectionPartitionName' name='SectionPartitionName' data-bind='value: name' value='"+PlatformSectionPartitionSelDialog.codetodes(ColumnValue["sectionParitionId"])+"' style='...'/>";
                                detailstr+="<button data-bind='click: displayGreeting'>...</button>";
                                detailstr+="</div>";
          						
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvarName' align='right'>变量名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='varName' name='变量名称' value='"+ColumnValue["varName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsectionLowerMark' align='right'>下限符号：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='下限符号' id='sectionLowerMark' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("104", ColumnValue["sectionLowerMark"]);
                                detailstr+="</select>";
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsectionLowerLimit' align='right'>下限：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='sectionLowerLimit' name='下限' value='"+ColumnValue["sectionLowerLimit"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsectionUpperMark' align='right'>上限符号：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='上限符号' id='sectionUpperMark' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("104", ColumnValue["sectionUpperMark"]);
                                detailstr+="</select>";
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsectionUpperLimit' align='right'>上限：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='sectionUpperLimit' name='上限' value='"+ColumnValue["sectionUpperLimit"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=sectionPartitionVar.updateSectionPartitionVar&v=1.0&format=json", $(detailstr),220);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformSectionPartitionVarManageListView);
        }
    });

    return PlatformSectionPartitionVarManageRouter;
});

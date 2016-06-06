
/**
 * 数据集
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
                    data:{id: $("#id").val(),datasetName: $("#datasetName").val(),datasetDes: $("#datasetDes").val(),datasetType: $("#datasetType").val(),remark: $("#remark").val()},
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
                    data:{id: $("#id").val(),datasetName: $("#datasetName").val(),datasetDes: $("#datasetDes").val(),datasetType: $("#datasetType").val(),remark: $("#remark").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];

                        		data["datasetTypeName"] = SimpleListUtil.getSelectDes("103", data["datasetType"]);
        						
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
    
    var PlatformDatasetManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_Dataset_manage": "showPlatformDatasetManageList",  
            "basic_manage/platform_ckDataset_manage": "showPlatformckDatasetManageList"
        },
        showPlatformckDatasetManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformDatasetManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformDatasetManageListView = new SimpleListView({
                id: "platform_dataset_manage_list",
                title: "基础管理 > 数据集",
                buttonCount:4,

                ready: function(){
                    this.setSimpleListHeader("数据集");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldatasetName' align='right'>数据集：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='datasetName' name='数据集' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldatasetDes' align='right'>数据集描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='datasetDes' name='数据集描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldatasetType' align='right'>类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='类型' id='datasetType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("103","");
                        detailstr+="</select>";
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
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=dataset.createDataset&v=1.0&format=json",$(detailstr),160);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformDatasetManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformDatasetManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformDatasetManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=dataset.deleteDataset&v=1.0&format=json",
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
                        detailstr+="<label id='ldatasetName' align='right'>数据集：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='datasetName' name='数据集' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldatasetDes' align='right'>数据集描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='datasetDes' name='数据集描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldatasetType' align='right'>类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='类型' id='datasetType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("103","");
                        detailstr+="</select>";
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
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=dataset.selectDataset&v=1.0&format=json",$(detailstr),160);
                        dialogId = null;
                    }, "filter");

                    this.addToolbarBtn("varBtn", "变量定义", function(){
                       var rowCount = platformDatasetManageListView.getGridObject().select().length;
                       if (rowCount>0){
                           rowEl = platformDatasetManageListView.getGridObject().select().get(0);
                           var ID = SimpleListUtil.getColumnValue(platformDatasetManageListView.getGridObject(),rowEl, "id");
                           var NAME = SimpleListUtil.getColumnValue(platformDatasetManageListView.getGridObject(),rowEl, "datasetDes");
                           window.location.href ="ruledesign.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_DatasetVar_manage";
                       } else {
                        alert("请先选择记录！");
                        }
                    }, "createLink");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=dataset.selectDataset&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },datasetName: { type: "string" },datasetDes: { type: "string" },datasetType: { type: "string" },remark: { type: "string" }
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
                            		data["datasetTypeName"] = SimpleListUtil.getSelectDes("103", data["datasetType"]);
                                }
                            }
                            result = platformDatasetManageListView.appendColValue(result);
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
                    		{field: "datasetName", title:"数据集", align:"center", width: "100px"},
                    		{field: "datasetDes", title:"数据集描述", align:"center", width: "100px"},
                    		{field: "datasetType", title:"类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "datasetTypeName", title:"类型", align:"center", width: "100px"},
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
                                platformDatasetManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformDatasetManageListView.get("columns");
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
                                detailstr+="<label id='ldatasetName' align='right'>数据集：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='datasetName' name='数据集' value='"+ColumnValue["datasetName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldatasetDes' align='right'>数据集描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='datasetDes' name='数据集描述' value='"+ColumnValue["datasetDes"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldatasetType' align='right'>类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='类型' id='datasetType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("103", ColumnValue["datasetType"]);
                                detailstr+="</select>";
        						
        						
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
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=dataset.updateDataset&v=1.0&format=json", $(detailstr),160);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformDatasetManageListView);
        }
    });

    return PlatformDatasetManageRouter;
});

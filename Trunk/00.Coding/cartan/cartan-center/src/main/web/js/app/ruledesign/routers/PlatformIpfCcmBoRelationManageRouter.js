
/**
 * IpfCcmBoRelation
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),propertyName: $("#propertyName").val(),subBoName: $("#subBoName").val(),subBoRelType: $("#subBoRelType").val(),objectType: $("#objectType").val(),description: $("#description").val(),subBoOrderNo: $("#subBoOrderNo").val(),persistentSaveType: $("#persistentSaveType").val(),gridEditType: $("#gridEditType").val(),linkBoName: $("#linkBoName").val()},
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),propertyName: $("#propertyName").val(),subBoName: $("#subBoName").val(),subBoRelType: $("#subBoRelType").val(),objectType: $("#objectType").val(),description: $("#description").val(),subBoOrderNo: $("#subBoOrderNo").val(),persistentSaveType: $("#persistentSaveType").val(),gridEditType: $("#gridEditType").val(),linkBoName: $("#linkBoName").val()},
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
    
    var PlatformIpfCcmBoRelationManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoRelation_manage": "showPlatformIpfCcmBoRelationManageList",  
            "basic_manage/platform_ckIpfCcmBoRelation_manage": "showPlatformckIpfCcmBoRelationManageList"
        },
        showPlatformckIpfCcmBoRelationManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoRelationManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoRelationManageListView = new SimpleListView({
                id: "platform_ipfCcmBoRelation_manage_list",
                title: "基础管理 > IpfCcmBoRelation",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoRelation");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoId' align='right'>业务对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoId' name='业务对象' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoName' align='right'>子对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoName' name='子对象名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoRelType' align='right'>子对象关系类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoRelType' name='子对象关系类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lobjectType' align='right'>对象类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='objectType' name='对象类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldescription' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='description' name='描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoOrderNo' align='right'>子业务对象的排序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoOrderNo' name='子业务对象的排序号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpersistentSaveType' align='right'>子业务对象保存方式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='persistentSaveType' name='子业务对象保存方式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridEditType' align='right'>表格维护方式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridEditType' name='表格维护方式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llinkBoName' align='right'>关联对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='linkBoName' name='关联对象名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoRelation.createIpfCcmBoRelation&v=1.0&format=json",$(detailstr),340);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoRelationManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoRelationManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoRelationManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoRelation.deleteIpfCcmBoRelation&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcmBoId' align='right'>业务对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoId' name='业务对象' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoName' align='right'>子对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoName' name='子对象名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoRelType' align='right'>子对象关系类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoRelType' name='子对象关系类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lobjectType' align='right'>对象类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='objectType' name='对象类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldescription' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='description' name='描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoOrderNo' align='right'>子业务对象的排序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoOrderNo' name='子业务对象的排序号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpersistentSaveType' align='right'>子业务对象保存方式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='persistentSaveType' name='子业务对象保存方式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridEditType' align='right'>表格维护方式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridEditType' name='表格维护方式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llinkBoName' align='right'>关联对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='linkBoName' name='关联对象名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoRelation.selectIpfCcmBoRelation&v=1.0&format=json",$(detailstr),340);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoRelation.selectIpfCcmBoRelation&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBoId: { type: "string" },propertyName: { type: "string" },subBoName: { type: "string" },subBoRelType: { type: "string" },objectType: { type: "string" },description: { type: "string" },subBoOrderNo: { type: "string" },persistentSaveType: { type: "string" },gridEditType: { type: "string" },linkBoName: { type: "string" }
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
                            result = platformIpfCcmBoRelationManageListView.appendColValue(result);
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
                    		{field: "ipfCcmBoId", title:"业务对象", align:"center", width: "100px"},
                    		{field: "propertyName", title:"属性名称", align:"center", width: "100px"},
                    		{field: "subBoName", title:"子对象名称", align:"center", width: "100px"},
                    		{field: "subBoRelType", title:"子对象关系类型", align:"center", width: "100px"},
                    		{field: "objectType", title:"对象类型", align:"center", width: "100px"},
                    		{field: "description", title:"描述", align:"center", width: "100px"},
                    		{field: "subBoOrderNo", title:"子业务对象的排序号", align:"center", width: "100px"},
                    		{field: "persistentSaveType", title:"子业务对象保存方式", align:"center", width: "100px"},
                    		{field: "gridEditType", title:"表格维护方式", align:"center", width: "100px"},
                    		{field: "linkBoName", title:"关联对象名称", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoRelationManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoRelationManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcmBoId' align='right'>业务对象：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmBoId' name='业务对象' value='"+ColumnValue["ipfCcmBoId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyName' align='right'>属性名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyName' name='属性名称' value='"+ColumnValue["propertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubBoName' align='right'>子对象名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='subBoName' name='子对象名称' value='"+ColumnValue["subBoName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubBoRelType' align='right'>子对象关系类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='subBoRelType' name='子对象关系类型' value='"+ColumnValue["subBoRelType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lobjectType' align='right'>对象类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='objectType' name='对象类型' value='"+ColumnValue["objectType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldescription' align='right'>描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='description' name='描述' value='"+ColumnValue["description"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubBoOrderNo' align='right'>子业务对象的排序号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='subBoOrderNo' name='子业务对象的排序号' value='"+ColumnValue["subBoOrderNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpersistentSaveType' align='right'>子业务对象保存方式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='persistentSaveType' name='子业务对象保存方式' value='"+ColumnValue["persistentSaveType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgridEditType' align='right'>表格维护方式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='gridEditType' name='表格维护方式' value='"+ColumnValue["gridEditType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llinkBoName' align='right'>关联对象名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='linkBoName' name='关联对象名称' value='"+ColumnValue["linkBoName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoRelation.updateIpfCcmBoRelation&v=1.0&format=json", $(detailstr),340);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoRelationManageListView);
        }
    });

    return PlatformIpfCcmBoRelationManageRouter;
});

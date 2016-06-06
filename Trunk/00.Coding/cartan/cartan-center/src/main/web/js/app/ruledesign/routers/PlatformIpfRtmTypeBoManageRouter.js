
/**
 * IpfRtmTypeBo
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
                    data:{id: $("#id").val(),ipfRtmTypeId: $("#ipfRtmTypeId").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boName: $("#boName").val(),boDesc: $("#boDesc").val(),propertyName: $("#propertyName").val(),propertyUtility: $("#propertyUtility").val(),externalBoName: $("#externalBoName").val(),externalMatchProperty: $("#externalMatchProperty").val(),externalResultProperty: $("#externalResultProperty").val(),externalBoId: $("#externalBoId").val(),triggerPropertyName: $("#triggerPropertyName").val()},
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
                    data:{id: $("#id").val(),ipfRtmTypeId: $("#ipfRtmTypeId").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boName: $("#boName").val(),boDesc: $("#boDesc").val(),propertyName: $("#propertyName").val(),propertyUtility: $("#propertyUtility").val(),externalBoName: $("#externalBoName").val(),externalMatchProperty: $("#externalMatchProperty").val(),externalResultProperty: $("#externalResultProperty").val(),externalBoId: $("#externalBoId").val(),triggerPropertyName: $("#triggerPropertyName").val()},
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
    
    var PlatformIpfRtmTypeBoManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfRtmTypeBo_manage": "showPlatformIpfRtmTypeBoManageList",  
            "basic_manage/platform_ckIpfRtmTypeBo_manage": "showPlatformckIpfRtmTypeBoManageList"
        },
        showPlatformckIpfRtmTypeBoManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfRtmTypeBoManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfRtmTypeBoManageListView = new SimpleListView({
                id: "platform_ipfRtmTypeBo_manage_list",
                title: "基础管理 > IpfRtmTypeBo",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfRtmTypeBo");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfRtmTypeId' align='right'>运行期配置类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRtmTypeId' name='运行期配置类型' style='...'/>";
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
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboDesc' align='right'>业务对象描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boDesc' name='业务对象描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>业务对象属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='业务对象属性名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyUtility' align='right'>属性用途：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyUtility' name='属性用途' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lexternalBoName' align='right'>外部业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='externalBoName' name='外部业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lexternalMatchProperty' align='right'>查询匹配属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='externalMatchProperty' name='查询匹配属性' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lexternalResultProperty' align='right'>结果属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='externalResultProperty' name='结果属性' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lexternalBoId' align='right'>外部业务对象ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='externalBoId' name='外部业务对象ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltriggerPropertyName' align='right'>触发属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='triggerPropertyName' name='触发属性名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfRtmTypeBo.createIpfRtmTypeBo&v=1.0&format=json",$(detailstr),370);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfRtmTypeBoManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfRtmTypeBoManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfRtmTypeBoManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfRtmTypeBo.deleteIpfRtmTypeBo&v=1.0&format=json",
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
                        detailstr+="<label id='lipfRtmTypeId' align='right'>运行期配置类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRtmTypeId' name='运行期配置类型' style='...'/>";
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
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboDesc' align='right'>业务对象描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boDesc' name='业务对象描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>业务对象属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='业务对象属性名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyUtility' align='right'>属性用途：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyUtility' name='属性用途' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lexternalBoName' align='right'>外部业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='externalBoName' name='外部业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lexternalMatchProperty' align='right'>查询匹配属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='externalMatchProperty' name='查询匹配属性' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lexternalResultProperty' align='right'>结果属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='externalResultProperty' name='结果属性' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lexternalBoId' align='right'>外部业务对象ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='externalBoId' name='外部业务对象ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltriggerPropertyName' align='right'>触发属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='triggerPropertyName' name='触发属性名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfRtmTypeBo.selectIpfRtmTypeBo&v=1.0&format=json",$(detailstr),370);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfRtmTypeBo.selectIpfRtmTypeBo&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfRtmTypeId: { type: "string" },ipfCcmBoId: { type: "string" },boName: { type: "string" },boDesc: { type: "string" },propertyName: { type: "string" },propertyUtility: { type: "string" },externalBoName: { type: "string" },externalMatchProperty: { type: "string" },externalResultProperty: { type: "string" },externalBoId: { type: "string" },triggerPropertyName: { type: "string" }
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
                            result = platformIpfRtmTypeBoManageListView.appendColValue(result);
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
                    		{field: "ipfRtmTypeId", title:"运行期配置类型", align:"center", width: "100px"},
                    		{field: "ipfCcmBoId", title:"业务对象ID", align:"center", width: "100px"},
                    		{field: "boName", title:"业务对象名称", align:"center", width: "100px"},
                    		{field: "boDesc", title:"业务对象描述", align:"center", width: "100px"},
                    		{field: "propertyName", title:"业务对象属性名称", align:"center", width: "100px"},
                    		{field: "propertyUtility", title:"属性用途", align:"center", width: "100px"},
                    		{field: "externalBoName", title:"外部业务对象名称", align:"center", width: "100px"},
                    		{field: "externalMatchProperty", title:"查询匹配属性", align:"center", width: "100px"},
                    		{field: "externalResultProperty", title:"结果属性", align:"center", width: "100px"},
                    		{field: "externalBoId", title:"外部业务对象ID", align:"center", width: "100px"},
                    		{field: "triggerPropertyName", title:"触发属性名", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfRtmTypeBoManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfRtmTypeBoManageListView.get("columns");
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
                                detailstr+="<label id='lipfRtmTypeId' align='right'>运行期配置类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfRtmTypeId' name='运行期配置类型' value='"+ColumnValue["ipfRtmTypeId"]+"' style='...'/>";
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
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lboDesc' align='right'>业务对象描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boDesc' name='业务对象描述' value='"+ColumnValue["boDesc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyName' align='right'>业务对象属性名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyName' name='业务对象属性名称' value='"+ColumnValue["propertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyUtility' align='right'>属性用途：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyUtility' name='属性用途' value='"+ColumnValue["propertyUtility"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lexternalBoName' align='right'>外部业务对象名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='externalBoName' name='外部业务对象名称' value='"+ColumnValue["externalBoName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lexternalMatchProperty' align='right'>查询匹配属性：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='externalMatchProperty' name='查询匹配属性' value='"+ColumnValue["externalMatchProperty"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lexternalResultProperty' align='right'>结果属性：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='externalResultProperty' name='结果属性' value='"+ColumnValue["externalResultProperty"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lexternalBoId' align='right'>外部业务对象ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='externalBoId' name='外部业务对象ID' value='"+ColumnValue["externalBoId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltriggerPropertyName' align='right'>触发属性名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='triggerPropertyName' name='触发属性名' value='"+ColumnValue["triggerPropertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfRtmTypeBo.updateIpfRtmTypeBo&v=1.0&format=json", $(detailstr),370);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfRtmTypeBoManageListView);
        }
    });

    return PlatformIpfRtmTypeBoManageRouter;
});


/**
 * IpfRtmConfigAttrBo
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
                    data:{id: $("#id").val(),ipfRtmConfigAttrId: $("#ipfRtmConfigAttrId").val(),ipfRtmConfigId: $("#ipfRtmConfigId").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boName: $("#boName").val(),boDesc: $("#boDesc").val(),boAttributeName: $("#boAttributeName").val(),isVisible: $("#isVisible").val(),isRequired: $("#isRequired").val(),defaultValue: $("#defaultValue").val(),shlpValueFiled: $("#shlpValueFiled").val()},
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
                    data:{id: $("#id").val(),ipfRtmConfigAttrId: $("#ipfRtmConfigAttrId").val(),ipfRtmConfigId: $("#ipfRtmConfigId").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boName: $("#boName").val(),boDesc: $("#boDesc").val(),boAttributeName: $("#boAttributeName").val(),isVisible: $("#isVisible").val(),isRequired: $("#isRequired").val(),defaultValue: $("#defaultValue").val(),shlpValueFiled: $("#shlpValueFiled").val()},
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
    
    var PlatformIpfRtmConfigAttrBoManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfRtmConfigAttrBo_manage": "showPlatformIpfRtmConfigAttrBoManageList",  
            "basic_manage/platform_ckIpfRtmConfigAttrBo_manage": "showPlatformckIpfRtmConfigAttrBoManageList"
        },
        showPlatformckIpfRtmConfigAttrBoManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfRtmConfigAttrBoManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfRtmConfigAttrBoManageListView = new SimpleListView({
                id: "platform_ipfRtmConfigAttrBo_manage_list",
                title: "基础管理 > IpfRtmConfigAttrBo",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfRtmConfigAttrBo");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfRtmConfigAttrId' align='right'>运行期配置明细：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRtmConfigAttrId' name='运行期配置明细' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfRtmConfigId' align='right'>运行期配置明细：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRtmConfigId' name='运行期配置明细' style='...'/>";
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
                        detailstr+="<label id='lboAttributeName' align='right'>属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boAttributeName' name='属性名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>可见：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='可见' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRequired' align='right'>必输：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRequired' name='必输' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefaultValue' align='right'>默认值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue' name='默认值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpValueFiled' align='right'>搜索帮助值字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpValueFiled' name='搜索帮助值字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfRtmConfigAttrBo.createIpfRtmConfigAttrBo&v=1.0&format=json",$(detailstr),340);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfRtmConfigAttrBoManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfRtmConfigAttrBoManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfRtmConfigAttrBoManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfRtmConfigAttrBo.deleteIpfRtmConfigAttrBo&v=1.0&format=json",
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
                        detailstr+="<label id='lipfRtmConfigAttrId' align='right'>运行期配置明细：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRtmConfigAttrId' name='运行期配置明细' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfRtmConfigId' align='right'>运行期配置明细：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfRtmConfigId' name='运行期配置明细' style='...'/>";
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
                        detailstr+="<label id='lboAttributeName' align='right'>属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boAttributeName' name='属性名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>可见：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='可见' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRequired' align='right'>必输：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRequired' name='必输' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefaultValue' align='right'>默认值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue' name='默认值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpValueFiled' align='right'>搜索帮助值字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpValueFiled' name='搜索帮助值字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfRtmConfigAttrBo.selectIpfRtmConfigAttrBo&v=1.0&format=json",$(detailstr),340);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfRtmConfigAttrBo.selectIpfRtmConfigAttrBo&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfRtmConfigAttrId: { type: "string" },ipfRtmConfigId: { type: "string" },ipfCcmBoId: { type: "string" },boName: { type: "string" },boDesc: { type: "string" },boAttributeName: { type: "string" },isVisible: { type: "string" },isRequired: { type: "string" },defaultValue: { type: "string" },shlpValueFiled: { type: "string" }
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
                            result = platformIpfRtmConfigAttrBoManageListView.appendColValue(result);
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
                    		{field: "ipfRtmConfigAttrId", title:"运行期配置明细", align:"center", width: "100px"},
                    		{field: "ipfRtmConfigId", title:"运行期配置明细", align:"center", width: "100px"},
                    		{field: "ipfCcmBoId", title:"业务对象ID", align:"center", width: "100px"},
                    		{field: "boName", title:"业务对象名称", align:"center", width: "100px"},
                    		{field: "boDesc", title:"业务对象描述", align:"center", width: "100px"},
                    		{field: "boAttributeName", title:"属性名称", align:"center", width: "100px"},
                    		{field: "isVisible", title:"可见", align:"center", width: "100px"},
                    		{field: "isRequired", title:"必输", align:"center", width: "100px"},
                    		{field: "defaultValue", title:"默认值", align:"center", width: "100px"},
                    		{field: "shlpValueFiled", title:"搜索帮助值字段", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfRtmConfigAttrBoManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfRtmConfigAttrBoManageListView.get("columns");
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
                                detailstr+="<label id='lipfRtmConfigAttrId' align='right'>运行期配置明细：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfRtmConfigAttrId' name='运行期配置明细' value='"+ColumnValue["ipfRtmConfigAttrId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lipfRtmConfigId' align='right'>运行期配置明细：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfRtmConfigId' name='运行期配置明细' value='"+ColumnValue["ipfRtmConfigId"]+"' style='...'/>";
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
                                detailstr+="<label id='lboAttributeName' align='right'>属性名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boAttributeName' name='属性名称' value='"+ColumnValue["boAttributeName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisVisible' align='right'>可见：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isVisible' name='可见' value='"+ColumnValue["isVisible"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisRequired' align='right'>必输：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isRequired' name='必输' value='"+ColumnValue["isRequired"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldefaultValue' align='right'>默认值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='defaultValue' name='默认值' value='"+ColumnValue["defaultValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshlpValueFiled' align='right'>搜索帮助值字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='shlpValueFiled' name='搜索帮助值字段' value='"+ColumnValue["shlpValueFiled"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfRtmConfigAttrBo.updateIpfRtmConfigAttrBo&v=1.0&format=json", $(detailstr),340);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfRtmConfigAttrBoManageListView);
        }
    });

    return PlatformIpfRtmConfigAttrBoManageRouter;
});


/**
 * IpfPoiSetting
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
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 730, height, titles);
        
    	
        
        

        var isAsyncModel = kendo.observable({
            isChecked: $("#isAsync").val()=="1"
        });
        kendo.bind($("#isAsync"), isAsyncModel);
        var isAsyncval="0";
		
        if (tp==1){
        $("#submitBtn").click(function(){    	
            if (isAsyncModel.isChecked){
            	isAsyncval="1";
            } else {
            	isAsyncval="0";
            }
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),boName: $("#boName").val(),poiType: $("#poiType").val(),templateFileName: $("#templateFileName").val(),templateUrl: $("#templateUrl").val(),fileName: $("#fileName").val(),sourceService: $("#sourceService").val(),className: $("#className").val(),templateExtName: $("#templateExtName").val(),ruleNo: $("#ruleNo").val(),dictName: $("#dictName").val(),dealService: $("#dealService").val(),methodeName: $("#methodeName").val(),isAsync: isAsyncval,asyncPageSize: $("#asyncPageSize").val(),template: $("#template").val(),templateFileKey: $("#templateFileKey").val(),primaryColumns: $("#primaryColumns").val(),childrenTable: $("#childrenTable").val(),sortExpress: $("#sortExpress").val(),allowParameter: $("#allowParameter").val(),ipfDefineColumn: $("#ipfDefineColumn").val()},
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
                if (isAsyncModel.isChecked){
                	isAsyncval="1";
                } else {
                	isAsyncval="";
                }
            $("#QueryBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),boName: $("#boName").val(),poiType: $("#poiType").val(),templateFileName: $("#templateFileName").val(),templateUrl: $("#templateUrl").val(),fileName: $("#fileName").val(),sourceService: $("#sourceService").val(),className: $("#className").val(),templateExtName: $("#templateExtName").val(),ruleNo: $("#ruleNo").val(),dictName: $("#dictName").val(),dealService: $("#dealService").val(),methodeName: $("#methodeName").val(),isAsync:isAsyncval,asyncPageSize: $("#asyncPageSize").val(),template: $("#template").val(),templateFileKey: $("#templateFileKey").val(),primaryColumns: $("#primaryColumns").val(),childrenTable: $("#childrenTable").val(),sortExpress: $("#sortExpress").val(),allowParameter: $("#allowParameter").val(),ipfDefineColumn: $("#ipfDefineColumn").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];

                        		data["poiTypeName"] = SimpleListUtil.getSelectDes("T001", data["poiType"]);
        						
        						
                        		data["isAsyncName"] = SimpleListUtil.getSelectDes("T014", data["isAsync"]);
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
    
    var PlatformIpfPoiSettingManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfPoiSetting_manage": "showPlatformIpfPoiSettingManageList",  
            "basic_manage/platform_ckIpfPoiSetting_manage": "showPlatformckIpfPoiSettingManageList"
        },
        showPlatformckIpfPoiSettingManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfPoiSettingManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfPoiSettingManageListView = new SimpleListView({
                id: "platform_ipfPoiSetting_manage_list",
                title: "基础管理 > POI配置管理",
                buttonCount:3,
                
                ready: function(){
                    this.setSimpleListHeader("POI配置管理");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lboName' align='right'>业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boName' name='业务对象名称' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lpoiType' align='right'>导入导出类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='导入导出类型' id='poiType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T001","");
                        detailstr+="</select>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplateFileName' align='right'>模板文件名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templateFileName' name='模板文件名称' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplateUrl' align='right'>模板地址：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templateUrl' name='模板地址' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lfileName' align='right'>导入导出文件名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fileName' name='导入导出文件名' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lsourceService' align='right'>请求数据路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sourceService' name='请求数据路径' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lclassName' align='right'>POI对象全名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='className' name='POI对象全名' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplateExtName' align='right'>模板文件扩展名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templateExtName' name='模板文件扩展名' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lruleNo' align='right'>导入规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='导入规则号' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ldictName' align='right'>数据字典路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictName' name='数据字典路径' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldealService' align='right'>结果处理服务：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dealService' name='结果处理服务' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lmethodeName' align='right'>结果处理服务方法名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodeName' name='结果处理服务方法名' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisAsync' align='right'>是否异步下载：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAsync' name='是否异步下载' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lasyncPageSize' align='right'>异步每页行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='asyncPageSize' name='异步每页行数' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplate' align='right'>模板内容：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='template' name='模板内容' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplateFileKey' align='right'>模板文件KEY：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templateFileKey' name='模板文件KEY' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lprimaryColumns' align='right'>主键指定：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='primaryColumns' name='主键指定' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lchildrenTable' align='right'>子表信息定义类：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='childrenTable' name='子表信息定义类' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsortExpress' align='right'>排序表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sortExpress' name='排序表达式' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="<td>";
                        detailstr+="<label id='lallowParameter' align='right'>是否接收参数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='allowParameter' name='是否接收参数' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";
                        
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfDefineColumn' align='right'>导入字段定义：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfDefineColumn' name='导入字段定义' style='...'/>";
                        detailstr+="</td>";                        
                        
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfPoiSetting.createIpfPoiSetting&v=1.0&format=json",$(detailstr),390);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfPoiSettingManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfPoiSettingManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfPoiSettingManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfPoiSetting.deleteIpfPoiSetting&v=1.0&format=json",
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
                        detailstr+="<label id='lboName' align='right'>业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boName' name='业务对象名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lpoiType' align='right'>导入导出类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select name='导入导出类型' id='poiType' style='...'>";
                        detailstr+="    <option value=''>请选择...</option>";
                        detailstr+= SimpleListUtil.getSelectCode("T001","");
                        detailstr+="</select>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplateFileName' align='right'>模板文件名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templateFileName' name='模板文件名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplateUrl' align='right'>模板地址：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templateUrl' name='模板地址' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lfileName' align='right'>导入导出文件名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fileName' name='导入导出文件名' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lsourceService' align='right'>请求数据路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sourceService' name='请求数据路径' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lclassName' align='right'>POI对象全名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='className' name='POI对象全名' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplateExtName' align='right'>模板文件扩展名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templateExtName' name='模板文件扩展名' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lruleNo' align='right'>导入规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='导入规则号' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='ldictName' align='right'>数据字典路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictName' name='数据字典路径' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ldealService' align='right'>结果处理服务：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dealService' name='结果处理服务' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lmethodeName' align='right'>结果处理服务方法名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodeName' name='结果处理服务方法名' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lisAsync' align='right'>是否异步下载：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAsync' name='是否异步下载' type='checkbox' data-bind='checked: isChecked' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lasyncPageSize' align='right'>异步每页行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='asyncPageSize' name='异步每页行数' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplate' align='right'>模板内容：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='template' name='模板内容' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='ltemplateFileKey' align='right'>模板文件KEY：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='templateFileKey' name='模板文件KEY' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lprimaryColumns' align='right'>主键指定：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='primaryColumns' name='主键指定' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lchildrenTable' align='right'>子表信息定义类：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='childrenTable' name='子表信息定义类' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsortExpress' align='right'>排序表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sortExpress' name='排序表达式' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="<td>";
                        detailstr+="<label id='lallowParameter' align='right'>是否接收参数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='allowParameter' name='是否接收参数' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lipfDefineColumn' align='right'>导入字段定义：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfDefineColumn' name='导入字段定义' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfPoiSetting.selectIpfPoiSetting&v=1.0&format=json",$(detailstr),390);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("commitBtn", "批量提交", function(){}, "update");
                    this.addToolbarBtn("undoBtn", "批量撤销", function(){}, "update");
                    this.addToolbarBtn("lockBtn", "批量锁定", function(){}, "update");
                    this.addToolbarBtn("unlockBtn", "批量解锁", function(){}, "update");
                    this.addToolbarBtn("lookupdelBtn", "查看删除", function(){}, "update");
                    this.addToolbarBtn("lookuphisBtn", "查看历史", function(){}, "update");
                    this.addToolbarBtn("exportsetupBtn", "导出配置数据", function(){}, "update");
                    this.addToolbarBtn("copytodestdbBtn", "同步到目标数据库", function(){}, "update");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfPoiSetting.selectIpfPoiSetting&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },boName: { type: "string" },poiType: { type: "string" },templateFileName: { type: "string" },templateUrl: { type: "string" },fileName: { type: "string" },sourceService: { type: "string" },className: { type: "string" },templateExtName: { type: "string" },ruleNo: { type: "string" },dictName: { type: "string" },dealService: { type: "string" },methodeName: { type: "string" },isAsync: { type: "string" },asyncPageSize: { type: "string" },template: { type: "string" },templateFileKey: { type: "string" },primaryColumns: { type: "string" },childrenTable: { type: "string" },sortExpress: { type: "string" },allowParameter: { type: "string" },ipfDefineColumn: { type: "string" }
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
                            		data["poiTypeName"] = SimpleListUtil.getSelectDes("T001", data["poiType"]);
                            		data["isAsyncName"] = SimpleListUtil.getSelectDes("T014", data["isAsync"]);
                                }
                            }
                            result = platformIpfPoiSettingManageListView.appendColValue(result);
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
                    		{field: "boName", title:"业务对象名称", align:"center", width: "100px"},
                    		{field: "poiType", title:"导入导出类型", hidden:"true", align:"center", width: "100px"},
                    		{field: "poiTypeName", title:"导入导出类型", align:"center", width: "100px"},
                    		{field: "templateFileName", title:"模板文件名称", align:"center", width: "100px"},
                    		{field: "templateUrl", title:"模板地址", align:"center", width: "100px"},
                    		{field: "fileName", title:"导入导出文件名", align:"center", width: "100px"},
                    		{field: "sourceService", title:"请求数据路径", align:"center", width: "100px"},
                    		{field: "className", title:"POI对象全名", align:"center", width: "100px"},
                    		{field: "templateExtName", title:"模板文件扩展名", align:"center", width: "100px"},
                    		{field: "ruleNo", title:"导入规则号", align:"center", width: "100px"},
                    		{field: "dictName", title:"数据字典路径", align:"center", width: "100px"},
                    		{field: "dealService", title:"结果处理服务", align:"center", width: "100px"},
                    		{field: "methodeName", title:"结果处理服务方法名", align:"center", width: "100px"},
                    		{field: "isAsync", title:"是否异步下载", hidden:"true", align:"center", width: "100px"},
                    		{field: "isAsyncName", title:"是否异步下载", align:"center", width: "100px"},
                    		{field: "asyncPageSize", title:"异步每页行数", align:"center", width: "100px"},
                    		{field: "template", title:"模板内容", align:"center", width: "100px"},
                    		{field: "templateFileKey", title:"模板文件KEY", align:"center", width: "100px"},
                    		{field: "primaryColumns", title:"主键指定", align:"center", width: "100px"},
                    		{field: "childrenTable", title:"子表信息定义类", align:"center", width: "100px"},
                    		{field: "sortExpress", title:"排序表达式", align:"center", width: "100px"},
                    		{field: "allowParameter", title:"是否接收参数", align:"center", width: "100px"},
                    		{field: "ipfDefineColumn", title:"导入字段定义", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfPoiSettingManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfPoiSettingManageListView.get("columns");
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
                                detailstr+="<label id='lboName' align='right'>业务对象名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boName' name='业务对象名称' value='"+ColumnValue["boName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lpoiType' align='right'>导入导出类型：</label>";
                                detailstr+="</td><td>";
          						
                                detailstr+="<select name='导入导出类型' id='poiType' style='...'>";
                                detailstr+="    <option value=''>请选择...</option>";
                                detailstr+= SimpleListUtil.getSelectCode("T001", ColumnValue["poiType"]);
                                detailstr+="</select>";
        						
        						
        						
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ltemplateFileName' align='right'>模板文件名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='templateFileName' name='模板文件名称' value='"+ColumnValue["templateFileName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='ltemplateUrl' align='right'>模板地址：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='templateUrl' name='模板地址' value='"+ColumnValue["templateUrl"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lfileName' align='right'>导入导出文件名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fileName' name='导入导出文件名' value='"+ColumnValue["fileName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lsourceService' align='right'>请求数据路径：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='sourceService' name='请求数据路径' value='"+ColumnValue["sourceService"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lclassName' align='right'>POI对象全名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='className' name='POI对象全名' value='"+ColumnValue["className"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='ltemplateExtName' align='right'>模板文件扩展名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='templateExtName' name='模板文件扩展名' value='"+ColumnValue["templateExtName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lruleNo' align='right'>导入规则号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleNo' name='导入规则号' value='"+ColumnValue["ruleNo"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldictName' align='right'>数据字典路径：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dictName' name='数据字典路径' value='"+ColumnValue["dictName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ldealService' align='right'>结果处理服务：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dealService' name='结果处理服务' value='"+ColumnValue["dealService"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lmethodeName' align='right'>结果处理服务方法名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodeName' name='结果处理服务方法名' value='"+ColumnValue["methodeName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lisAsync' align='right'>是否异步下载：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
                        		detailstr+="<input id='isAsync' name='是否异步下载' type='checkbox' data-bind='checked: isChecked' value='"+ColumnValue["isAsync"]+"' style='...'/>";
        						
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lasyncPageSize' align='right'>异步每页行数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='asyncPageSize' name='异步每页行数' value='"+ColumnValue["asyncPageSize"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='ltemplate' align='right'>模板内容：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='template' name='模板内容' value='"+ColumnValue["template"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='ltemplateFileKey' align='right'>模板文件KEY：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='templateFileKey' name='模板文件KEY' value='"+ColumnValue["templateFileKey"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lprimaryColumns' align='right'>主键指定：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='primaryColumns' name='主键指定' value='"+ColumnValue["primaryColumns"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lchildrenTable' align='right'>子表信息定义类：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='childrenTable' name='子表信息定义类' value='"+ColumnValue["childrenTable"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lsortExpress' align='right'>排序表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='sortExpress' name='排序表达式' value='"+ColumnValue["sortExpress"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='lallowParameter' align='right'>是否接收参数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='allowParameter' name='是否接收参数' value='"+ColumnValue["allowParameter"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lipfDefineColumn' align='right'>导入字段定义：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfDefineColumn' name='导入字段定义' value='"+ColumnValue["ipfDefineColumn"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfPoiSetting.updateIpfPoiSetting&v=1.0&format=json", $(detailstr),390);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfPoiSettingManageListView);
        }
    });

    return PlatformIpfPoiSettingManageRouter;
});

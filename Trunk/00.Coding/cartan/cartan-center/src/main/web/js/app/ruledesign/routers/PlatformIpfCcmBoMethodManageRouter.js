
/**
 * IpfCcmBoMethod
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boType: $("#boType").val(),boRefId: $("#boRefId").val(),icon: $("#icon").val(),remark: $("#remark").val(),methodDesc: $("#methodDesc").val(),methodName: $("#methodName").val(),methodType: $("#methodType").val(),url: $("#url").val(),isDefault: $("#isDefault").val(),isVisible: $("#isVisible").val(),refShlpName: $("#refShlpName").val(),ruleNo: $("#ruleNo").val(),jumpMethodId: $("#jumpMethodId").val(),jumpMethodName: $("#jumpMethodName").val(),jumpBoName: $("#jumpBoName").val(),width: $("#width").val(),height: $("#height").val(),groupName: $("#groupName").val(),groupDesc: $("#groupDesc").val(),isCache: $("#isCache").val(),cacheType: $("#cacheType").val(),requestType: $("#requestType").val(),jumpWindowTitle: $("#jumpWindowTitle").val(),isRefreshParentBo: $("#isRefreshParentBo").val()},
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),boType: $("#boType").val(),boRefId: $("#boRefId").val(),icon: $("#icon").val(),remark: $("#remark").val(),methodDesc: $("#methodDesc").val(),methodName: $("#methodName").val(),methodType: $("#methodType").val(),url: $("#url").val(),isDefault: $("#isDefault").val(),isVisible: $("#isVisible").val(),refShlpName: $("#refShlpName").val(),ruleNo: $("#ruleNo").val(),jumpMethodId: $("#jumpMethodId").val(),jumpMethodName: $("#jumpMethodName").val(),jumpBoName: $("#jumpBoName").val(),width: $("#width").val(),height: $("#height").val(),groupName: $("#groupName").val(),groupDesc: $("#groupDesc").val(),isCache: $("#isCache").val(),cacheType: $("#cacheType").val(),requestType: $("#requestType").val(),jumpWindowTitle: $("#jumpWindowTitle").val(),isRefreshParentBo: $("#isRefreshParentBo").val()},
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
    
    var PlatformIpfCcmBoMethodManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoMethod_manage": "showPlatformIpfCcmBoMethodManageList",  
            "basic_manage/platform_ckIpfCcmBoMethod_manage": "showPlatformckIpfCcmBoMethodManageList"
        },
        showPlatformckIpfCcmBoMethodManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoMethodManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoMethodManageListView = new SimpleListView({
                id: "platform_ipfCcmBoMethod_manage_list",
                title: "基础管理 > IpfCcmBoMethod",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoMethod");
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
                        detailstr+="<label id='lboType' align='right'>对象类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boType' name='对象类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboRefId' align='right'>业务对象引用ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boRefId' name='业务对象引用ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='licon' align='right'>图标：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='icon' name='图标' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodDesc' align='right'>方法描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodDesc' name='方法描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='方法名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodType' align='right'>方法类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodType' name='方法类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lurl' align='right'>调用的URL地址：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='url' name='调用的URL地址' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisDefault' align='right'>默认方法：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isDefault' name='默认方法' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>可见：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='可见' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrefShlpName' align='right'>搜索帮助名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='refShlpName' name='搜索帮助名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljumpMethodId' align='right'>跳转方法ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jumpMethodId' name='跳转方法ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljumpMethodName' align='right'>跳转方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jumpMethodName' name='跳转方法名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljumpBoName' align='right'>跳转业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jumpBoName' name='跳转业务对象名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lwidth' align='right'>宽：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='width' name='宽' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lheight' align='right'>高：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='height' name='高' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupName' align='right'>校验分组名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupName' name='校验分组名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupDesc' align='right'>校验分组描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupDesc' name='校验分组描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCache' align='right'>是否缓存：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCache' name='是否缓存' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcacheType' align='right'>缓存类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cacheType' name='缓存类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrequestType' align='right'>请求类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='requestType' name='请求类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljumpWindowTitle' align='right'>弹窗标题：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jumpWindowTitle' name='弹窗标题' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRefreshParentBo' align='right'>是否刷新主表：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRefreshParentBo' name='是否刷新主表' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoMethod.createIpfCcmBoMethod&v=1.0&format=json",$(detailstr),790);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoMethodManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoMethodManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoMethodManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoMethod.deleteIpfCcmBoMethod&v=1.0&format=json",
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
                        detailstr+="<label id='lboType' align='right'>对象类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boType' name='对象类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboRefId' align='right'>业务对象引用ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boRefId' name='业务对象引用ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='licon' align='right'>图标：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='icon' name='图标' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodDesc' align='right'>方法描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodDesc' name='方法描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='方法名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodType' align='right'>方法类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodType' name='方法类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lurl' align='right'>调用的URL地址：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='url' name='调用的URL地址' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisDefault' align='right'>默认方法：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isDefault' name='默认方法' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>可见：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='可见' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrefShlpName' align='right'>搜索帮助名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='refShlpName' name='搜索帮助名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljumpMethodId' align='right'>跳转方法ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jumpMethodId' name='跳转方法ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljumpMethodName' align='right'>跳转方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jumpMethodName' name='跳转方法名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljumpBoName' align='right'>跳转业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jumpBoName' name='跳转业务对象名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lwidth' align='right'>宽：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='width' name='宽' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lheight' align='right'>高：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='height' name='高' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupName' align='right'>校验分组名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupName' name='校验分组名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupDesc' align='right'>校验分组描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupDesc' name='校验分组描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCache' align='right'>是否缓存：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCache' name='是否缓存' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcacheType' align='right'>缓存类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cacheType' name='缓存类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrequestType' align='right'>请求类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='requestType' name='请求类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljumpWindowTitle' align='right'>弹窗标题：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='jumpWindowTitle' name='弹窗标题' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRefreshParentBo' align='right'>是否刷新主表：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRefreshParentBo' name='是否刷新主表' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoMethod.selectIpfCcmBoMethod&v=1.0&format=json",$(detailstr),790);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoMethod.selectIpfCcmBoMethod&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBoId: { type: "string" },boType: { type: "string" },boRefId: { type: "string" },icon: { type: "string" },remark: { type: "string" },methodDesc: { type: "string" },methodName: { type: "string" },methodType: { type: "string" },url: { type: "string" },isDefault: { type: "string" },isVisible: { type: "string" },refShlpName: { type: "string" },ruleNo: { type: "string" },jumpMethodId: { type: "string" },jumpMethodName: { type: "string" },jumpBoName: { type: "string" },width: { type: "string" },height: { type: "string" },groupName: { type: "string" },groupDesc: { type: "string" },isCache: { type: "string" },cacheType: { type: "string" },requestType: { type: "string" },jumpWindowTitle: { type: "string" },isRefreshParentBo: { type: "string" }
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
                            result = platformIpfCcmBoMethodManageListView.appendColValue(result);
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
                    		{field: "boType", title:"对象类型", align:"center", width: "100px"},
                    		{field: "boRefId", title:"业务对象引用ID", align:"center", width: "100px"},
                    		{field: "icon", title:"图标", align:"center", width: "100px"},
                    		{field: "remark", title:"备注", align:"center", width: "100px"},
                    		{field: "methodDesc", title:"方法描述", align:"center", width: "100px"},
                    		{field: "methodName", title:"方法名称", align:"center", width: "100px"},
                    		{field: "methodType", title:"方法类型", align:"center", width: "100px"},
                    		{field: "url", title:"调用的URL地址", align:"center", width: "100px"},
                    		{field: "isDefault", title:"默认方法", align:"center", width: "100px"},
                    		{field: "isVisible", title:"可见", align:"center", width: "100px"},
                    		{field: "refShlpName", title:"搜索帮助名称", align:"center", width: "100px"},
                    		{field: "ruleNo", title:"规则号", align:"center", width: "100px"},
                    		{field: "jumpMethodId", title:"跳转方法ID", align:"center", width: "100px"},
                    		{field: "jumpMethodName", title:"跳转方法名称", align:"center", width: "100px"},
                    		{field: "jumpBoName", title:"跳转业务对象名", align:"center", width: "100px"},
                    		{field: "width", title:"宽", align:"center", width: "100px"},
                    		{field: "height", title:"高", align:"center", width: "100px"},
                    		{field: "groupName", title:"校验分组名称", align:"center", width: "100px"},
                    		{field: "groupDesc", title:"校验分组描述", align:"center", width: "100px"},
                    		{field: "isCache", title:"是否缓存", align:"center", width: "100px"},
                    		{field: "cacheType", title:"缓存类型", align:"center", width: "100px"},
                    		{field: "requestType", title:"请求类型", align:"center", width: "100px"},
                    		{field: "jumpWindowTitle", title:"弹窗标题", align:"center", width: "100px"},
                    		{field: "isRefreshParentBo", title:"是否刷新主表", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoMethodManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoMethodManageListView.get("columns");
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
                                detailstr+="<label id='lboType' align='right'>对象类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boType' name='对象类型' value='"+ColumnValue["boType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lboRefId' align='right'>业务对象引用ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boRefId' name='业务对象引用ID' value='"+ColumnValue["boRefId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='licon' align='right'>图标：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='icon' name='图标' value='"+ColumnValue["icon"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='remark' name='备注' value='"+ColumnValue["remark"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodDesc' align='right'>方法描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodDesc' name='方法描述' value='"+ColumnValue["methodDesc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodName' align='right'>方法名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodName' name='方法名称' value='"+ColumnValue["methodName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodType' align='right'>方法类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodType' name='方法类型' value='"+ColumnValue["methodType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lurl' align='right'>调用的URL地址：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='url' name='调用的URL地址' value='"+ColumnValue["url"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisDefault' align='right'>默认方法：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isDefault' name='默认方法' value='"+ColumnValue["isDefault"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisVisible' align='right'>可见：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isVisible' name='可见' value='"+ColumnValue["isVisible"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrefShlpName' align='right'>搜索帮助名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='refShlpName' name='搜索帮助名称' value='"+ColumnValue["refShlpName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleNo' name='规则号' value='"+ColumnValue["ruleNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljumpMethodId' align='right'>跳转方法ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jumpMethodId' name='跳转方法ID' value='"+ColumnValue["jumpMethodId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljumpMethodName' align='right'>跳转方法名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jumpMethodName' name='跳转方法名称' value='"+ColumnValue["jumpMethodName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljumpBoName' align='right'>跳转业务对象名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jumpBoName' name='跳转业务对象名' value='"+ColumnValue["jumpBoName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lwidth' align='right'>宽：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='width' name='宽' value='"+ColumnValue["width"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lheight' align='right'>高：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='height' name='高' value='"+ColumnValue["height"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupName' align='right'>校验分组名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='groupName' name='校验分组名称' value='"+ColumnValue["groupName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupDesc' align='right'>校验分组描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='groupDesc' name='校验分组描述' value='"+ColumnValue["groupDesc"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisCache' align='right'>是否缓存：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isCache' name='是否缓存' value='"+ColumnValue["isCache"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcacheType' align='right'>缓存类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='cacheType' name='缓存类型' value='"+ColumnValue["cacheType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrequestType' align='right'>请求类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='requestType' name='请求类型' value='"+ColumnValue["requestType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljumpWindowTitle' align='right'>弹窗标题：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='jumpWindowTitle' name='弹窗标题' value='"+ColumnValue["jumpWindowTitle"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisRefreshParentBo' align='right'>是否刷新主表：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isRefreshParentBo' name='是否刷新主表' value='"+ColumnValue["isRefreshParentBo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoMethod.updateIpfCcmBoMethod&v=1.0&format=json", $(detailstr),790);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoMethodManageListView);
        }
    });

    return PlatformIpfCcmBoMethodManageRouter;
});

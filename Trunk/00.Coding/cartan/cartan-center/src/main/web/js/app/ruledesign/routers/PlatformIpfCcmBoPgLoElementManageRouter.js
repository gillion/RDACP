
/**
 * IpfCcmBoPgLoElement
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
                    data:{id: $("#id").val(),ipfCcmBoPageLayoutId: $("#ipfCcmBoPageLayoutId").val(),seqNo: $("#seqNo").val(),layoutElementType: $("#layoutElementType").val(),layoutBoName: $("#layoutBoName").val(),controlHeight: $("#controlHeight").val(),controlWidth: $("#controlWidth").val(),textLineNum: $("#textLineNum").val(),controlConnector: $("#controlConnector").val(),isNotNull: $("#isNotNull").val(),isReadOnly: $("#isReadOnly").val(),uiType: $("#uiType").val(),isVisible: $("#isVisible").val(),columnStyle: $("#columnStyle").val(),lableStyle: $("#lableStyle").val(),isShowLable: $("#isShowLable").val(),isInline: $("#isInline").val(),tabIndex: $("#tabIndex").val(),defaultValue: $("#defaultValue").val(),initValueType: $("#initValueType").val(),correctType: $("#correctType").val(),conditionType: $("#conditionType").val(),operation: $("#operation").val(),queryType: $("#queryType").val(),rangeType: $("#rangeType").val(),methodName: $("#methodName").val(),propertyName: $("#propertyName").val()},
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
                    data:{id: $("#id").val(),ipfCcmBoPageLayoutId: $("#ipfCcmBoPageLayoutId").val(),seqNo: $("#seqNo").val(),layoutElementType: $("#layoutElementType").val(),layoutBoName: $("#layoutBoName").val(),controlHeight: $("#controlHeight").val(),controlWidth: $("#controlWidth").val(),textLineNum: $("#textLineNum").val(),controlConnector: $("#controlConnector").val(),isNotNull: $("#isNotNull").val(),isReadOnly: $("#isReadOnly").val(),uiType: $("#uiType").val(),isVisible: $("#isVisible").val(),columnStyle: $("#columnStyle").val(),lableStyle: $("#lableStyle").val(),isShowLable: $("#isShowLable").val(),isInline: $("#isInline").val(),tabIndex: $("#tabIndex").val(),defaultValue: $("#defaultValue").val(),initValueType: $("#initValueType").val(),correctType: $("#correctType").val(),conditionType: $("#conditionType").val(),operation: $("#operation").val(),queryType: $("#queryType").val(),rangeType: $("#rangeType").val(),methodName: $("#methodName").val(),propertyName: $("#propertyName").val()},
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
    
    var PlatformIpfCcmBoPgLoElementManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoPgLoElement_manage": "showPlatformIpfCcmBoPgLoElementManageList",  
            "basic_manage/platform_ckIpfCcmBoPgLoElement_manage": "showPlatformckIpfCcmBoPgLoElementManageList"
        },
        showPlatformckIpfCcmBoPgLoElementManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoPgLoElementManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoPgLoElementManageListView = new SimpleListView({
                id: "platform_ipfCcmBoPgLoElement_manage_list",
                title: "基础管理 > IpfCcmBoPgLoElement",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoPgLoElement");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoPageLayoutId' align='right'>页面布局：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoPageLayoutId' name='页面布局' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lseqNo' align='right'>序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='seqNo' name='序号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutElementType' align='right'>页面布局元素类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutElementType' name='页面布局元素类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutBoName' align='right'>页面布局业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutBoName' name='页面布局业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontrolHeight' align='right'>控件高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='controlHeight' name='控件高度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontrolWidth' align='right'>控件宽度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='controlWidth' name='控件宽度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltextLineNum' align='right'>多行文本行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='textLineNum' name='多行文本行数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontrolConnector' align='right'>连接符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='controlConnector' name='连接符' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNotNull' name='非空' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisReadOnly' align='right'>只读：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isReadOnly' name='只读' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiType' align='right'>控件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiType' name='控件类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>可见：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='可见' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnStyle' align='right'>列样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnStyle' name='列样式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llableStyle' align='right'>标签样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lableStyle' name='标签样式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisShowLable' align='right'>显示标签：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isShowLable' name='显示标签' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisInline' align='right'>控件内联：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isInline' name='控件内联' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltabIndex' align='right'>Tab顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tabIndex' name='Tab顺序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefaultValue' align='right'>默认值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue' name='默认值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linitValueType' align='right'>初始值类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='initValueType' name='初始值类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcorrectType' align='right'>转换类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='correctType' name='转换类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconditionType' align='right'>查询条件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conditionType' name='查询条件类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperation' align='right'>操作符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='operation' name='操作符' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lqueryType' align='right'>查询类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='queryType' name='查询类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrangeType' align='right'>区间类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rangeType' name='区间类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='方法名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoPgLoElement.createIpfCcmBoPgLoElement&v=1.0&format=json",$(detailstr),820);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoPgLoElementManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoPgLoElementManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoPgLoElementManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoPgLoElement.deleteIpfCcmBoPgLoElement&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcmBoPageLayoutId' align='right'>页面布局：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoPageLayoutId' name='页面布局' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lseqNo' align='right'>序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='seqNo' name='序号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutElementType' align='right'>页面布局元素类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutElementType' name='页面布局元素类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutBoName' align='right'>页面布局业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutBoName' name='页面布局业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontrolHeight' align='right'>控件高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='controlHeight' name='控件高度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontrolWidth' align='right'>控件宽度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='controlWidth' name='控件宽度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltextLineNum' align='right'>多行文本行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='textLineNum' name='多行文本行数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontrolConnector' align='right'>连接符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='controlConnector' name='连接符' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNotNull' name='非空' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisReadOnly' align='right'>只读：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isReadOnly' name='只读' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiType' align='right'>控件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiType' name='控件类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>可见：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='可见' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnStyle' align='right'>列样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnStyle' name='列样式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llableStyle' align='right'>标签样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lableStyle' name='标签样式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisShowLable' align='right'>显示标签：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isShowLable' name='显示标签' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisInline' align='right'>控件内联：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isInline' name='控件内联' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltabIndex' align='right'>Tab顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tabIndex' name='Tab顺序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefaultValue' align='right'>默认值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue' name='默认值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linitValueType' align='right'>初始值类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='initValueType' name='初始值类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcorrectType' align='right'>转换类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='correctType' name='转换类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconditionType' align='right'>查询条件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conditionType' name='查询条件类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperation' align='right'>操作符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='operation' name='操作符' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lqueryType' align='right'>查询类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='queryType' name='查询类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrangeType' align='right'>区间类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rangeType' name='区间类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='方法名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoPgLoElement.selectIpfCcmBoPgLoElement&v=1.0&format=json",$(detailstr),820);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoPgLoElement.selectIpfCcmBoPgLoElement&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBoPageLayoutId: { type: "string" },seqNo: { type: "string" },layoutElementType: { type: "string" },layoutBoName: { type: "string" },controlHeight: { type: "string" },controlWidth: { type: "string" },textLineNum: { type: "string" },controlConnector: { type: "string" },isNotNull: { type: "string" },isReadOnly: { type: "string" },uiType: { type: "string" },isVisible: { type: "string" },columnStyle: { type: "string" },lableStyle: { type: "string" },isShowLable: { type: "string" },isInline: { type: "string" },tabIndex: { type: "string" },defaultValue: { type: "string" },initValueType: { type: "string" },correctType: { type: "string" },conditionType: { type: "string" },operation: { type: "string" },queryType: { type: "string" },rangeType: { type: "string" },methodName: { type: "string" },propertyName: { type: "string" }
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
                            result = platformIpfCcmBoPgLoElementManageListView.appendColValue(result);
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
                    		{field: "ipfCcmBoPageLayoutId", title:"页面布局", align:"center", width: "100px"},
                    		{field: "seqNo", title:"序号", align:"center", width: "100px"},
                    		{field: "layoutElementType", title:"页面布局元素类型", align:"center", width: "100px"},
                    		{field: "layoutBoName", title:"页面布局业务对象名称", align:"center", width: "100px"},
                    		{field: "controlHeight", title:"控件高度", align:"center", width: "100px"},
                    		{field: "controlWidth", title:"控件宽度", align:"center", width: "100px"},
                    		{field: "textLineNum", title:"多行文本行数", align:"center", width: "100px"},
                    		{field: "controlConnector", title:"连接符", align:"center", width: "100px"},
                    		{field: "isNotNull", title:"非空", align:"center", width: "100px"},
                    		{field: "isReadOnly", title:"只读", align:"center", width: "100px"},
                    		{field: "uiType", title:"控件类型", align:"center", width: "100px"},
                    		{field: "isVisible", title:"可见", align:"center", width: "100px"},
                    		{field: "columnStyle", title:"列样式", align:"center", width: "100px"},
                    		{field: "lableStyle", title:"标签样式", align:"center", width: "100px"},
                    		{field: "isShowLable", title:"显示标签", align:"center", width: "100px"},
                    		{field: "isInline", title:"控件内联", align:"center", width: "100px"},
                    		{field: "tabIndex", title:"Tab顺序", align:"center", width: "100px"},
                    		{field: "defaultValue", title:"默认值", align:"center", width: "100px"},
                    		{field: "initValueType", title:"初始值类型", align:"center", width: "100px"},
                    		{field: "correctType", title:"转换类型", align:"center", width: "100px"},
                    		{field: "conditionType", title:"查询条件类型", align:"center", width: "100px"},
                    		{field: "operation", title:"操作符", align:"center", width: "100px"},
                    		{field: "queryType", title:"查询类型", align:"center", width: "100px"},
                    		{field: "rangeType", title:"区间类型", align:"center", width: "100px"},
                    		{field: "methodName", title:"方法名称", align:"center", width: "100px"},
                    		{field: "propertyName", title:"属性名", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoPgLoElementManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoPgLoElementManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcmBoPageLayoutId' align='right'>页面布局：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmBoPageLayoutId' name='页面布局' value='"+ColumnValue["ipfCcmBoPageLayoutId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lseqNo' align='right'>序号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='seqNo' name='序号' value='"+ColumnValue["seqNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llayoutElementType' align='right'>页面布局元素类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='layoutElementType' name='页面布局元素类型' value='"+ColumnValue["layoutElementType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llayoutBoName' align='right'>页面布局业务对象名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='layoutBoName' name='页面布局业务对象名称' value='"+ColumnValue["layoutBoName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcontrolHeight' align='right'>控件高度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='controlHeight' name='控件高度' value='"+ColumnValue["controlHeight"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcontrolWidth' align='right'>控件宽度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='controlWidth' name='控件宽度' value='"+ColumnValue["controlWidth"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltextLineNum' align='right'>多行文本行数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='textLineNum' name='多行文本行数' value='"+ColumnValue["textLineNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcontrolConnector' align='right'>连接符：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='controlConnector' name='连接符' value='"+ColumnValue["controlConnector"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isNotNull' name='非空' value='"+ColumnValue["isNotNull"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisReadOnly' align='right'>只读：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isReadOnly' name='只读' value='"+ColumnValue["isReadOnly"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luiType' align='right'>控件类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='uiType' name='控件类型' value='"+ColumnValue["uiType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisVisible' align='right'>可见：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isVisible' name='可见' value='"+ColumnValue["isVisible"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcolumnStyle' align='right'>列样式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnStyle' name='列样式' value='"+ColumnValue["columnStyle"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llableStyle' align='right'>标签样式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='lableStyle' name='标签样式' value='"+ColumnValue["lableStyle"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisShowLable' align='right'>显示标签：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isShowLable' name='显示标签' value='"+ColumnValue["isShowLable"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisInline' align='right'>控件内联：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isInline' name='控件内联' value='"+ColumnValue["isInline"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltabIndex' align='right'>Tab顺序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tabIndex' name='Tab顺序' value='"+ColumnValue["tabIndex"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldefaultValue' align='right'>默认值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='defaultValue' name='默认值' value='"+ColumnValue["defaultValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linitValueType' align='right'>初始值类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='initValueType' name='初始值类型' value='"+ColumnValue["initValueType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcorrectType' align='right'>转换类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='correctType' name='转换类型' value='"+ColumnValue["correctType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconditionType' align='right'>查询条件类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='conditionType' name='查询条件类型' value='"+ColumnValue["conditionType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loperation' align='right'>操作符：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='operation' name='操作符' value='"+ColumnValue["operation"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lqueryType' align='right'>查询类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='queryType' name='查询类型' value='"+ColumnValue["queryType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrangeType' align='right'>区间类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='rangeType' name='区间类型' value='"+ColumnValue["rangeType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodName' align='right'>方法名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodName' name='方法名称' value='"+ColumnValue["methodName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyName' align='right'>属性名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyName' name='属性名' value='"+ColumnValue["propertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoPgLoElement.updateIpfCcmBoPgLoElement&v=1.0&format=json", $(detailstr),820);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoPgLoElementManageListView);
        }
    });

    return PlatformIpfCcmBoPgLoElementManageRouter;
});

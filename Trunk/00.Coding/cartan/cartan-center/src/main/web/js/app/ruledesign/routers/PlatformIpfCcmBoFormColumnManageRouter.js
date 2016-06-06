
/**
 * IpfCcmBoFormColumn
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),defaultValue: $("#defaultValue").val(),isGroup: $("#isGroup").val(),groupName: $("#groupName").val(),isCaNote: $("#isCaNote").val(),isHeader: $("#isHeader").val(),isNotNull: $("#isNotNull").val(),isReadOnly: $("#isReadOnly").val(),propertyName: $("#propertyName").val(),propertyType: $("#propertyType").val(),columnNo: $("#columnNo").val(),rowNo: $("#rowNo").val(),uiType: $("#uiType").val(),isVisible: $("#isVisible").val(),propertyId: $("#propertyId").val(),ruleNo: $("#ruleNo").val(),columnStyle: $("#columnStyle").val(),displayLable: $("#displayLable").val(),lableStyle: $("#lableStyle").val(),cellName: $("#cellName").val(),textFormHeight: $("#textFormHeight").val(),textLineNum: $("#textLineNum").val(),inlineWidth: $("#inlineWidth").val(),inlineOrderNo: $("#inlineOrderNo").val(),inlineConnector: $("#inlineConnector").val(),isShowLabel: $("#isShowLabel").val(),isRadioInline: $("#isRadioInline").val(),tabIndex: $("#tabIndex").val(),initValueType: $("#initValueType").val(),correctType: $("#correctType").val(),activeExpress: $("#activeExpress").val()},
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),defaultValue: $("#defaultValue").val(),isGroup: $("#isGroup").val(),groupName: $("#groupName").val(),isCaNote: $("#isCaNote").val(),isHeader: $("#isHeader").val(),isNotNull: $("#isNotNull").val(),isReadOnly: $("#isReadOnly").val(),propertyName: $("#propertyName").val(),propertyType: $("#propertyType").val(),columnNo: $("#columnNo").val(),rowNo: $("#rowNo").val(),uiType: $("#uiType").val(),isVisible: $("#isVisible").val(),propertyId: $("#propertyId").val(),ruleNo: $("#ruleNo").val(),columnStyle: $("#columnStyle").val(),displayLable: $("#displayLable").val(),lableStyle: $("#lableStyle").val(),cellName: $("#cellName").val(),textFormHeight: $("#textFormHeight").val(),textLineNum: $("#textLineNum").val(),inlineWidth: $("#inlineWidth").val(),inlineOrderNo: $("#inlineOrderNo").val(),inlineConnector: $("#inlineConnector").val(),isShowLabel: $("#isShowLabel").val(),isRadioInline: $("#isRadioInline").val(),tabIndex: $("#tabIndex").val(),initValueType: $("#initValueType").val(),correctType: $("#correctType").val(),activeExpress: $("#activeExpress").val()},
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
    
    var PlatformIpfCcmBoFormColumnManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoFormColumn_manage": "showPlatformIpfCcmBoFormColumnManageList",  
            "basic_manage/platform_ckIpfCcmBoFormColumn_manage": "showPlatformckIpfCcmBoFormColumnManageList"
        },
        showPlatformckIpfCcmBoFormColumnManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoFormColumnManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoFormColumnManageListView = new SimpleListView({
                id: "platform_ipfCcmBoFormColumn_manage_list",
                title: "基础管理 > IpfCcmBoFormColumn",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoFormColumn");
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
                        detailstr+="<label id='ldefaultValue' align='right'>初始值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue' name='初始值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisGroup' align='right'>分组：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isGroup' name='分组' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupName' align='right'>分组名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupName' name='分组名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCaNote' align='right'>是否管理标签页：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCaNote' name='是否管理标签页' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisHeader' align='right'>台头：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isHeader' name='台头' style='...'/>";
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
                        detailstr+="<label id='lpropertyName' align='right'>属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyType' align='right'>属性类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyType' name='属性类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnNo' align='right'>列号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnNo' name='列号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrowNo' align='right'>行号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rowNo' name='行号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiType' align='right'>组件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiType' name='组件类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>显示：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='显示' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyId' align='right'>属性ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyId' name='属性ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnStyle' align='right'>列样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnStyle' name='列样式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldisplayLable' align='right'>字段文本是否显示：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='displayLable' name='字段文本是否显示' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llableStyle' align='right'>标签样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lableStyle' name='标签样式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellName' align='right'>单元格名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellName' name='单元格名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltextFormHeight' align='right'>多行文本控制高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='textFormHeight' name='多行文本控制高度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltextLineNum' align='right'>多行文本行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='textLineNum' name='多行文本行数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linlineWidth' align='right'>查询控件高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inlineWidth' name='查询控件高度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linlineOrderNo' align='right'>查询顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inlineOrderNo' name='查询顺序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linlineConnector' align='right'>查询连接符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inlineConnector' name='查询连接符' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisShowLabel' align='right'>显示标签：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isShowLabel' name='显示标签' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRadioInline' align='right'>控件内联：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRadioInline' name='控件内联' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltabIndex' align='right'>Tab顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tabIndex' name='Tab顺序' style='...'/>";
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
                        detailstr+="<label id='lactiveExpress' align='right'>可编辑表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='activeExpress' name='可编辑表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoFormColumn.createIpfCcmBoFormColumn&v=1.0&format=json",$(detailstr),970);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoFormColumnManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoFormColumnManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoFormColumnManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoFormColumn.deleteIpfCcmBoFormColumn&v=1.0&format=json",
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
                        detailstr+="<label id='ldefaultValue' align='right'>初始值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue' name='初始值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisGroup' align='right'>分组：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isGroup' name='分组' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupName' align='right'>分组名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupName' name='分组名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCaNote' align='right'>是否管理标签页：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCaNote' name='是否管理标签页' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisHeader' align='right'>台头：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isHeader' name='台头' style='...'/>";
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
                        detailstr+="<label id='lpropertyName' align='right'>属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyType' align='right'>属性类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyType' name='属性类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnNo' align='right'>列号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnNo' name='列号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrowNo' align='right'>行号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rowNo' name='行号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiType' align='right'>组件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiType' name='组件类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>显示：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='显示' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyId' align='right'>属性ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyId' name='属性ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ruleNo' name='规则号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnStyle' align='right'>列样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnStyle' name='列样式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldisplayLable' align='right'>字段文本是否显示：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='displayLable' name='字段文本是否显示' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llableStyle' align='right'>标签样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lableStyle' name='标签样式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellName' align='right'>单元格名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellName' name='单元格名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltextFormHeight' align='right'>多行文本控制高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='textFormHeight' name='多行文本控制高度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltextLineNum' align='right'>多行文本行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='textLineNum' name='多行文本行数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linlineWidth' align='right'>查询控件高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inlineWidth' name='查询控件高度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linlineOrderNo' align='right'>查询顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inlineOrderNo' name='查询顺序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linlineConnector' align='right'>查询连接符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='inlineConnector' name='查询连接符' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisShowLabel' align='right'>显示标签：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isShowLabel' name='显示标签' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRadioInline' align='right'>控件内联：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRadioInline' name='控件内联' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltabIndex' align='right'>Tab顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tabIndex' name='Tab顺序' style='...'/>";
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
                        detailstr+="<label id='lactiveExpress' align='right'>可编辑表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='activeExpress' name='可编辑表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoFormColumn.selectIpfCcmBoFormColumn&v=1.0&format=json",$(detailstr),970);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoFormColumn.selectIpfCcmBoFormColumn&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBoId: { type: "string" },defaultValue: { type: "string" },isGroup: { type: "string" },groupName: { type: "string" },isCaNote: { type: "string" },isHeader: { type: "string" },isNotNull: { type: "string" },isReadOnly: { type: "string" },propertyName: { type: "string" },propertyType: { type: "string" },columnNo: { type: "string" },rowNo: { type: "string" },uiType: { type: "string" },isVisible: { type: "string" },propertyId: { type: "string" },ruleNo: { type: "string" },columnStyle: { type: "string" },displayLable: { type: "string" },lableStyle: { type: "string" },cellName: { type: "string" },textFormHeight: { type: "string" },textLineNum: { type: "string" },inlineWidth: { type: "string" },inlineOrderNo: { type: "string" },inlineConnector: { type: "string" },isShowLabel: { type: "string" },isRadioInline: { type: "string" },tabIndex: { type: "string" },initValueType: { type: "string" },correctType: { type: "string" },activeExpress: { type: "string" }
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
                            result = platformIpfCcmBoFormColumnManageListView.appendColValue(result);
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
                    		{field: "defaultValue", title:"初始值", align:"center", width: "100px"},
                    		{field: "isGroup", title:"分组", align:"center", width: "100px"},
                    		{field: "groupName", title:"分组名", align:"center", width: "100px"},
                    		{field: "isCaNote", title:"是否管理标签页", align:"center", width: "100px"},
                    		{field: "isHeader", title:"台头", align:"center", width: "100px"},
                    		{field: "isNotNull", title:"非空", align:"center", width: "100px"},
                    		{field: "isReadOnly", title:"只读", align:"center", width: "100px"},
                    		{field: "propertyName", title:"属性名称", align:"center", width: "100px"},
                    		{field: "propertyType", title:"属性类型", align:"center", width: "100px"},
                    		{field: "columnNo", title:"列号", align:"center", width: "100px"},
                    		{field: "rowNo", title:"行号", align:"center", width: "100px"},
                    		{field: "uiType", title:"组件类型", align:"center", width: "100px"},
                    		{field: "isVisible", title:"显示", align:"center", width: "100px"},
                    		{field: "propertyId", title:"属性ID", align:"center", width: "100px"},
                    		{field: "ruleNo", title:"规则号", align:"center", width: "100px"},
                    		{field: "columnStyle", title:"列样式", align:"center", width: "100px"},
                    		{field: "displayLable", title:"字段文本是否显示", align:"center", width: "100px"},
                    		{field: "lableStyle", title:"标签样式", align:"center", width: "100px"},
                    		{field: "cellName", title:"单元格名称", align:"center", width: "100px"},
                    		{field: "textFormHeight", title:"多行文本控制高度", align:"center", width: "100px"},
                    		{field: "textLineNum", title:"多行文本行数", align:"center", width: "100px"},
                    		{field: "inlineWidth", title:"查询控件高度", align:"center", width: "100px"},
                    		{field: "inlineOrderNo", title:"查询顺序", align:"center", width: "100px"},
                    		{field: "inlineConnector", title:"查询连接符", align:"center", width: "100px"},
                    		{field: "isShowLabel", title:"显示标签", align:"center", width: "100px"},
                    		{field: "isRadioInline", title:"控件内联", align:"center", width: "100px"},
                    		{field: "tabIndex", title:"Tab顺序", align:"center", width: "100px"},
                    		{field: "initValueType", title:"初始值类型", align:"center", width: "100px"},
                    		{field: "correctType", title:"转换类型", align:"center", width: "100px"},
                    		{field: "activeExpress", title:"可编辑表达式", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoFormColumnManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoFormColumnManageListView.get("columns");
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
                                detailstr+="<label id='ldefaultValue' align='right'>初始值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='defaultValue' name='初始值' value='"+ColumnValue["defaultValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisGroup' align='right'>分组：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isGroup' name='分组' value='"+ColumnValue["isGroup"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupName' align='right'>分组名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='groupName' name='分组名' value='"+ColumnValue["groupName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisCaNote' align='right'>是否管理标签页：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isCaNote' name='是否管理标签页' value='"+ColumnValue["isCaNote"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisHeader' align='right'>台头：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isHeader' name='台头' value='"+ColumnValue["isHeader"]+"' style='...'/>";
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
                                detailstr+="<label id='lpropertyName' align='right'>属性名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyName' name='属性名称' value='"+ColumnValue["propertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyType' align='right'>属性类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyType' name='属性类型' value='"+ColumnValue["propertyType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcolumnNo' align='right'>列号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnNo' name='列号' value='"+ColumnValue["columnNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrowNo' align='right'>行号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='rowNo' name='行号' value='"+ColumnValue["rowNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luiType' align='right'>组件类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='uiType' name='组件类型' value='"+ColumnValue["uiType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisVisible' align='right'>显示：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isVisible' name='显示' value='"+ColumnValue["isVisible"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyId' align='right'>属性ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyId' name='属性ID' value='"+ColumnValue["propertyId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lruleNo' align='right'>规则号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ruleNo' name='规则号' value='"+ColumnValue["ruleNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcolumnStyle' align='right'>列样式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnStyle' name='列样式' value='"+ColumnValue["columnStyle"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldisplayLable' align='right'>字段文本是否显示：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='displayLable' name='字段文本是否显示' value='"+ColumnValue["displayLable"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llableStyle' align='right'>标签样式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='lableStyle' name='标签样式' value='"+ColumnValue["lableStyle"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcellName' align='right'>单元格名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='cellName' name='单元格名称' value='"+ColumnValue["cellName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltextFormHeight' align='right'>多行文本控制高度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='textFormHeight' name='多行文本控制高度' value='"+ColumnValue["textFormHeight"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltextLineNum' align='right'>多行文本行数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='textLineNum' name='多行文本行数' value='"+ColumnValue["textLineNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linlineWidth' align='right'>查询控件高度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='inlineWidth' name='查询控件高度' value='"+ColumnValue["inlineWidth"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linlineOrderNo' align='right'>查询顺序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='inlineOrderNo' name='查询顺序' value='"+ColumnValue["inlineOrderNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linlineConnector' align='right'>查询连接符：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='inlineConnector' name='查询连接符' value='"+ColumnValue["inlineConnector"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisShowLabel' align='right'>显示标签：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isShowLabel' name='显示标签' value='"+ColumnValue["isShowLabel"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisRadioInline' align='right'>控件内联：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isRadioInline' name='控件内联' value='"+ColumnValue["isRadioInline"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltabIndex' align='right'>Tab顺序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tabIndex' name='Tab顺序' value='"+ColumnValue["tabIndex"]+"' style='...'/>";
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
                                detailstr+="<label id='lactiveExpress' align='right'>可编辑表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='activeExpress' name='可编辑表达式' value='"+ColumnValue["activeExpress"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoFormColumn.updateIpfCcmBoFormColumn&v=1.0&format=json", $(detailstr),970);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoFormColumnManageListView);
        }
    });

    return PlatformIpfCcmBoFormColumnManageRouter;
});

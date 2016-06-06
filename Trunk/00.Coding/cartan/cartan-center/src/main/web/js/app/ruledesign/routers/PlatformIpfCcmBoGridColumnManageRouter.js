
/**
 * IpfCcmBoGridColumn
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),defaultValue: $("#defaultValue").val(),isCondition: $("#isCondition").val(),isRange: $("#isRange").val(),correctType: $("#correctType").val(),isSum: $("#isSum").val(),isNotNull: $("#isNotNull").val(),isOrderBy: $("#isOrderBy").val(),propertyName: $("#propertyName").val(),propertyType: $("#propertyType").val(),uiType: $("#uiType").val(),columnNo: $("#columnNo").val(),isReadOnly: $("#isReadOnly").val(),isVisible: $("#isVisible").val(),width: $("#width").val(),propertyId: $("#propertyId").val(),cellRuleNo: $("#cellRuleNo").val(),methodId: $("#methodId").val(),methodName: $("#methodName").val(),searchColumnNo: $("#searchColumnNo").val(),searchRowNo: $("#searchRowNo").val(),operation: $("#operation").val(),conditionVisible: $("#conditionVisible").val(),shlpValueType: $("#shlpValueType").val(),isQuickSearch: $("#isQuickSearch").val(),quickCellName: $("#quickCellName").val(),quickTextFormHeight: $("#quickTextFormHeight").val(),quickTextLineNum: $("#quickTextLineNum").val(),quickInlineWidth: $("#quickInlineWidth").val(),quickInlineOrderNo: $("#quickInlineOrderNo").val(),quickInlineConnector: $("#quickInlineConnector").val(),isQuickShowLabel: $("#isQuickShowLabel").val(),isQuickRadioInline: $("#isQuickRadioInline").val(),isAdvSearch: $("#isAdvSearch").val(),advCellName: $("#advCellName").val(),advTextFormHeight: $("#advTextFormHeight").val(),advTextLineNum: $("#advTextLineNum").val(),advInlineWidth: $("#advInlineWidth").val(),advInlineOrderNo: $("#advInlineOrderNo").val(),advInlineConnector: $("#advInlineConnector").val(),isAdvShowLabel: $("#isAdvShowLabel").val(),isAdvRadioInline: $("#isAdvRadioInline").val(),tabIndex: $("#tabIndex").val(),isCellEditable: $("#isCellEditable").val(),initValueType: $("#initValueType").val(),initValueType2: $("#initValueType2").val(),defaultValue2: $("#defaultValue2").val(),fieldSort: $("#fieldSort").val(),activeExpress: $("#activeExpress").val(),lockColumnExpress: $("#lockColumnExpress").val(),unlockColumnExpress: $("#unlockColumnExpress").val(),isShowSort: $("#isShowSort").val()},
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),defaultValue: $("#defaultValue").val(),isCondition: $("#isCondition").val(),isRange: $("#isRange").val(),correctType: $("#correctType").val(),isSum: $("#isSum").val(),isNotNull: $("#isNotNull").val(),isOrderBy: $("#isOrderBy").val(),propertyName: $("#propertyName").val(),propertyType: $("#propertyType").val(),uiType: $("#uiType").val(),columnNo: $("#columnNo").val(),isReadOnly: $("#isReadOnly").val(),isVisible: $("#isVisible").val(),width: $("#width").val(),propertyId: $("#propertyId").val(),cellRuleNo: $("#cellRuleNo").val(),methodId: $("#methodId").val(),methodName: $("#methodName").val(),searchColumnNo: $("#searchColumnNo").val(),searchRowNo: $("#searchRowNo").val(),operation: $("#operation").val(),conditionVisible: $("#conditionVisible").val(),shlpValueType: $("#shlpValueType").val(),isQuickSearch: $("#isQuickSearch").val(),quickCellName: $("#quickCellName").val(),quickTextFormHeight: $("#quickTextFormHeight").val(),quickTextLineNum: $("#quickTextLineNum").val(),quickInlineWidth: $("#quickInlineWidth").val(),quickInlineOrderNo: $("#quickInlineOrderNo").val(),quickInlineConnector: $("#quickInlineConnector").val(),isQuickShowLabel: $("#isQuickShowLabel").val(),isQuickRadioInline: $("#isQuickRadioInline").val(),isAdvSearch: $("#isAdvSearch").val(),advCellName: $("#advCellName").val(),advTextFormHeight: $("#advTextFormHeight").val(),advTextLineNum: $("#advTextLineNum").val(),advInlineWidth: $("#advInlineWidth").val(),advInlineOrderNo: $("#advInlineOrderNo").val(),advInlineConnector: $("#advInlineConnector").val(),isAdvShowLabel: $("#isAdvShowLabel").val(),isAdvRadioInline: $("#isAdvRadioInline").val(),tabIndex: $("#tabIndex").val(),isCellEditable: $("#isCellEditable").val(),initValueType: $("#initValueType").val(),initValueType2: $("#initValueType2").val(),defaultValue2: $("#defaultValue2").val(),fieldSort: $("#fieldSort").val(),activeExpress: $("#activeExpress").val(),lockColumnExpress: $("#lockColumnExpress").val(),unlockColumnExpress: $("#unlockColumnExpress").val(),isShowSort: $("#isShowSort").val()},
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
    
    var PlatformIpfCcmBoGridColumnManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoGridColumn_manage": "showPlatformIpfCcmBoGridColumnManageList",  
            "basic_manage/platform_ckIpfCcmBoGridColumn_manage": "showPlatformckIpfCcmBoGridColumnManageList"
        },
        showPlatformckIpfCcmBoGridColumnManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoGridColumnManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoGridColumnManageListView = new SimpleListView({
                id: "platform_ipfCcmBoGridColumn_manage_list",
                title: "基础管理 > IpfCcmBoGridColumn",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoGridColumn");
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
                        detailstr+="<label id='lisCondition' align='right'>查询条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCondition' name='查询条件' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRange' align='right'>区间查询条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRange' name='区间查询条件' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcorrectType' align='right'>转换类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='correctType' name='转换类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSum' align='right'>汇总：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSum' name='汇总' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNotNull' name='非空' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisOrderBy' align='right'>排序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isOrderBy' name='排序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyType' align='right'>属性类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyType' name='属性类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiType' align='right'>组件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiType' name='组件类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnNo' align='right'>列号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnNo' name='列号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisReadOnly' align='right'>只读：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isReadOnly' name='只读' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>显示：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='显示' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lwidth' align='right'>列宽：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='width' name='列宽' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyId' align='right'>属性ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyId' name='属性ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellRuleNo' align='right'>单元格处理规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellRuleNo' name='单元格处理规则号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodId' align='right'>调用方法ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodId' name='调用方法ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>调用方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='调用方法名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchColumnNo' align='right'>查询条件列号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchColumnNo' name='查询条件列号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchRowNo' align='right'>查询条件行号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchRowNo' name='查询条件行号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperation' align='right'>查询操作符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='operation' name='查询操作符' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconditionVisible' align='right'>查询条件可见性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conditionVisible' name='查询条件可见性' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpValueType' align='right'>值类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpValueType' name='值类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisQuickSearch' align='right'>快捷查询：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isQuickSearch' name='快捷查询' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickCellName' align='right'>快捷查询对应栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickCellName' name='快捷查询对应栅格' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickTextFormHeight' align='right'>快捷查询多行文本控制高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickTextFormHeight' name='快捷查询多行文本控制高度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickTextLineNum' align='right'>快捷查询多行文本行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickTextLineNum' name='快捷查询多行文本行数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickInlineWidth' align='right'>快捷查询控件高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickInlineWidth' name='快捷查询控件高度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickInlineOrderNo' align='right'>快捷查询顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickInlineOrderNo' name='快捷查询顺序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickInlineConnector' align='right'>快捷查询连接符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickInlineConnector' name='快捷查询连接符' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisQuickShowLabel' align='right'>快捷查询显示标签：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isQuickShowLabel' name='快捷查询显示标签' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisQuickRadioInline' align='right'>快捷查询内联：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isQuickRadioInline' name='快捷查询内联' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisAdvSearch' align='right'>需高级查询：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAdvSearch' name='需高级查询' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvCellName' align='right'>高级查询对应栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advCellName' name='高级查询对应栅格' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvTextFormHeight' align='right'>高级查询多行文本控制高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advTextFormHeight' name='高级查询多行文本控制高度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvTextLineNum' align='right'>高级查询多行文本行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advTextLineNum' name='高级查询多行文本行数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvInlineWidth' align='right'>高级查询控件高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advInlineWidth' name='高级查询控件高度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvInlineOrderNo' align='right'>高级查询顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advInlineOrderNo' name='高级查询顺序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvInlineConnector' align='right'>高级查询连接符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advInlineConnector' name='高级查询连接符' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisAdvShowLabel' align='right'>高级查询显示标签：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAdvShowLabel' name='高级查询显示标签' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisAdvRadioInline' align='right'>高级查询内联：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAdvRadioInline' name='高级查询内联' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltabIndex' align='right'>Tab顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tabIndex' name='Tab顺序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCellEditable' align='right'>表格可编辑：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCellEditable' name='表格可编辑' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linitValueType' align='right'>初始值类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='initValueType' name='初始值类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linitValueType2' align='right'>初始值类型2：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='initValueType2' name='初始值类型2' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefaultValue2' align='right'>初始值2：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue2' name='初始值2' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldSort' align='right'>字段排序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldSort' name='字段排序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lactiveExpress' align='right'>可编辑表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='activeExpress' name='可编辑表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llockColumnExpress' align='right'>列锁定表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lockColumnExpress' name='列锁定表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lunlockColumnExpress' align='right'>列解锁表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='unlockColumnExpress' name='列解锁表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisShowSort' align='right'>显示排序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isShowSort' name='显示排序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoGridColumn.createIpfCcmBoGridColumn&v=1.0&format=json",$(detailstr),1600);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoGridColumnManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoGridColumnManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoGridColumnManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoGridColumn.deleteIpfCcmBoGridColumn&v=1.0&format=json",
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
                        detailstr+="<label id='lisCondition' align='right'>查询条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCondition' name='查询条件' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRange' align='right'>区间查询条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRange' name='区间查询条件' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcorrectType' align='right'>转换类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='correctType' name='转换类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSum' align='right'>汇总：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSum' name='汇总' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNotNull' name='非空' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisOrderBy' align='right'>排序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isOrderBy' name='排序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyType' align='right'>属性类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyType' name='属性类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiType' align='right'>组件类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiType' name='组件类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnNo' align='right'>列号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnNo' name='列号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisReadOnly' align='right'>只读：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isReadOnly' name='只读' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>显示：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='显示' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lwidth' align='right'>列宽：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='width' name='列宽' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyId' align='right'>属性ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyId' name='属性ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellRuleNo' align='right'>单元格处理规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellRuleNo' name='单元格处理规则号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodId' align='right'>调用方法ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodId' name='调用方法ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmethodName' align='right'>调用方法名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='methodName' name='调用方法名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchColumnNo' align='right'>查询条件列号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchColumnNo' name='查询条件列号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchRowNo' align='right'>查询条件行号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchRowNo' name='查询条件行号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperation' align='right'>查询操作符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='operation' name='查询操作符' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconditionVisible' align='right'>查询条件可见性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conditionVisible' name='查询条件可见性' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpValueType' align='right'>值类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpValueType' name='值类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisQuickSearch' align='right'>快捷查询：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isQuickSearch' name='快捷查询' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickCellName' align='right'>快捷查询对应栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickCellName' name='快捷查询对应栅格' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickTextFormHeight' align='right'>快捷查询多行文本控制高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickTextFormHeight' name='快捷查询多行文本控制高度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickTextLineNum' align='right'>快捷查询多行文本行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickTextLineNum' name='快捷查询多行文本行数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickInlineWidth' align='right'>快捷查询控件高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickInlineWidth' name='快捷查询控件高度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickInlineOrderNo' align='right'>快捷查询顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickInlineOrderNo' name='快捷查询顺序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lquickInlineConnector' align='right'>快捷查询连接符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='quickInlineConnector' name='快捷查询连接符' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisQuickShowLabel' align='right'>快捷查询显示标签：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isQuickShowLabel' name='快捷查询显示标签' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisQuickRadioInline' align='right'>快捷查询内联：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isQuickRadioInline' name='快捷查询内联' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisAdvSearch' align='right'>需高级查询：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAdvSearch' name='需高级查询' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvCellName' align='right'>高级查询对应栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advCellName' name='高级查询对应栅格' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvTextFormHeight' align='right'>高级查询多行文本控制高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advTextFormHeight' name='高级查询多行文本控制高度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvTextLineNum' align='right'>高级查询多行文本行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advTextLineNum' name='高级查询多行文本行数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvInlineWidth' align='right'>高级查询控件高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advInlineWidth' name='高级查询控件高度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvInlineOrderNo' align='right'>高级查询顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advInlineOrderNo' name='高级查询顺序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ladvInlineConnector' align='right'>高级查询连接符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='advInlineConnector' name='高级查询连接符' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisAdvShowLabel' align='right'>高级查询显示标签：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAdvShowLabel' name='高级查询显示标签' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisAdvRadioInline' align='right'>高级查询内联：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAdvRadioInline' name='高级查询内联' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltabIndex' align='right'>Tab顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tabIndex' name='Tab顺序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisCellEditable' align='right'>表格可编辑：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isCellEditable' name='表格可编辑' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linitValueType' align='right'>初始值类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='initValueType' name='初始值类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='linitValueType2' align='right'>初始值类型2：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='initValueType2' name='初始值类型2' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefaultValue2' align='right'>初始值2：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue2' name='初始值2' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldSort' align='right'>字段排序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldSort' name='字段排序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lactiveExpress' align='right'>可编辑表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='activeExpress' name='可编辑表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llockColumnExpress' align='right'>列锁定表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lockColumnExpress' name='列锁定表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lunlockColumnExpress' align='right'>列解锁表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='unlockColumnExpress' name='列解锁表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisShowSort' align='right'>显示排序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isShowSort' name='显示排序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoGridColumn.selectIpfCcmBoGridColumn&v=1.0&format=json",$(detailstr),1600);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoGridColumn.selectIpfCcmBoGridColumn&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBoId: { type: "string" },defaultValue: { type: "string" },isCondition: { type: "string" },isRange: { type: "string" },correctType: { type: "string" },isSum: { type: "string" },isNotNull: { type: "string" },isOrderBy: { type: "string" },propertyName: { type: "string" },propertyType: { type: "string" },uiType: { type: "string" },columnNo: { type: "string" },isReadOnly: { type: "string" },isVisible: { type: "string" },width: { type: "string" },propertyId: { type: "string" },cellRuleNo: { type: "string" },methodId: { type: "string" },methodName: { type: "string" },searchColumnNo: { type: "string" },searchRowNo: { type: "string" },operation: { type: "string" },conditionVisible: { type: "string" },shlpValueType: { type: "string" },isQuickSearch: { type: "string" },quickCellName: { type: "string" },quickTextFormHeight: { type: "string" },quickTextLineNum: { type: "string" },quickInlineWidth: { type: "string" },quickInlineOrderNo: { type: "string" },quickInlineConnector: { type: "string" },isQuickShowLabel: { type: "string" },isQuickRadioInline: { type: "string" },isAdvSearch: { type: "string" },advCellName: { type: "string" },advTextFormHeight: { type: "string" },advTextLineNum: { type: "string" },advInlineWidth: { type: "string" },advInlineOrderNo: { type: "string" },advInlineConnector: { type: "string" },isAdvShowLabel: { type: "string" },isAdvRadioInline: { type: "string" },tabIndex: { type: "string" },isCellEditable: { type: "string" },initValueType: { type: "string" },initValueType2: { type: "string" },defaultValue2: { type: "string" },fieldSort: { type: "string" },activeExpress: { type: "string" },lockColumnExpress: { type: "string" },unlockColumnExpress: { type: "string" },isShowSort: { type: "string" }
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
                            result = platformIpfCcmBoGridColumnManageListView.appendColValue(result);
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
                    		{field: "isCondition", title:"查询条件", align:"center", width: "100px"},
                    		{field: "isRange", title:"区间查询条件", align:"center", width: "100px"},
                    		{field: "correctType", title:"转换类型", align:"center", width: "100px"},
                    		{field: "isSum", title:"汇总", align:"center", width: "100px"},
                    		{field: "isNotNull", title:"非空", align:"center", width: "100px"},
                    		{field: "isOrderBy", title:"排序", align:"center", width: "100px"},
                    		{field: "propertyName", title:"属性名", align:"center", width: "100px"},
                    		{field: "propertyType", title:"属性类型", align:"center", width: "100px"},
                    		{field: "uiType", title:"组件类型", align:"center", width: "100px"},
                    		{field: "columnNo", title:"列号", align:"center", width: "100px"},
                    		{field: "isReadOnly", title:"只读", align:"center", width: "100px"},
                    		{field: "isVisible", title:"显示", align:"center", width: "100px"},
                    		{field: "width", title:"列宽", align:"center", width: "100px"},
                    		{field: "propertyId", title:"属性ID", align:"center", width: "100px"},
                    		{field: "cellRuleNo", title:"单元格处理规则号", align:"center", width: "100px"},
                    		{field: "methodId", title:"调用方法ID", align:"center", width: "100px"},
                    		{field: "methodName", title:"调用方法名称", align:"center", width: "100px"},
                    		{field: "searchColumnNo", title:"查询条件列号", align:"center", width: "100px"},
                    		{field: "searchRowNo", title:"查询条件行号", align:"center", width: "100px"},
                    		{field: "operation", title:"查询操作符", align:"center", width: "100px"},
                    		{field: "conditionVisible", title:"查询条件可见性", align:"center", width: "100px"},
                    		{field: "shlpValueType", title:"值类型", align:"center", width: "100px"},
                    		{field: "isQuickSearch", title:"快捷查询", align:"center", width: "100px"},
                    		{field: "quickCellName", title:"快捷查询对应栅格", align:"center", width: "100px"},
                    		{field: "quickTextFormHeight", title:"快捷查询多行文本控制高度", align:"center", width: "100px"},
                    		{field: "quickTextLineNum", title:"快捷查询多行文本行数", align:"center", width: "100px"},
                    		{field: "quickInlineWidth", title:"快捷查询控件高度", align:"center", width: "100px"},
                    		{field: "quickInlineOrderNo", title:"快捷查询顺序", align:"center", width: "100px"},
                    		{field: "quickInlineConnector", title:"快捷查询连接符", align:"center", width: "100px"},
                    		{field: "isQuickShowLabel", title:"快捷查询显示标签", align:"center", width: "100px"},
                    		{field: "isQuickRadioInline", title:"快捷查询内联", align:"center", width: "100px"},
                    		{field: "isAdvSearch", title:"需高级查询", align:"center", width: "100px"},
                    		{field: "advCellName", title:"高级查询对应栅格", align:"center", width: "100px"},
                    		{field: "advTextFormHeight", title:"高级查询多行文本控制高度", align:"center", width: "100px"},
                    		{field: "advTextLineNum", title:"高级查询多行文本行数", align:"center", width: "100px"},
                    		{field: "advInlineWidth", title:"高级查询控件高度", align:"center", width: "100px"},
                    		{field: "advInlineOrderNo", title:"高级查询顺序", align:"center", width: "100px"},
                    		{field: "advInlineConnector", title:"高级查询连接符", align:"center", width: "100px"},
                    		{field: "isAdvShowLabel", title:"高级查询显示标签", align:"center", width: "100px"},
                    		{field: "isAdvRadioInline", title:"高级查询内联", align:"center", width: "100px"},
                    		{field: "tabIndex", title:"Tab顺序", align:"center", width: "100px"},
                    		{field: "isCellEditable", title:"表格可编辑", align:"center", width: "100px"},
                    		{field: "initValueType", title:"初始值类型", align:"center", width: "100px"},
                    		{field: "initValueType2", title:"初始值类型2", align:"center", width: "100px"},
                    		{field: "defaultValue2", title:"初始值2", align:"center", width: "100px"},
                    		{field: "fieldSort", title:"字段排序", align:"center", width: "100px"},
                    		{field: "activeExpress", title:"可编辑表达式", align:"center", width: "100px"},
                    		{field: "lockColumnExpress", title:"列锁定表达式", align:"center", width: "100px"},
                    		{field: "unlockColumnExpress", title:"列解锁表达式", align:"center", width: "100px"},
                    		{field: "isShowSort", title:"显示排序", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoGridColumnManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoGridColumnManageListView.get("columns");
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
                                detailstr+="<label id='lisCondition' align='right'>查询条件：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isCondition' name='查询条件' value='"+ColumnValue["isCondition"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisRange' align='right'>区间查询条件：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isRange' name='区间查询条件' value='"+ColumnValue["isRange"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcorrectType' align='right'>转换类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='correctType' name='转换类型' value='"+ColumnValue["correctType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisSum' align='right'>汇总：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isSum' name='汇总' value='"+ColumnValue["isSum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isNotNull' name='非空' value='"+ColumnValue["isNotNull"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisOrderBy' align='right'>排序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isOrderBy' name='排序' value='"+ColumnValue["isOrderBy"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyName' align='right'>属性名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyName' name='属性名' value='"+ColumnValue["propertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyType' align='right'>属性类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyType' name='属性类型' value='"+ColumnValue["propertyType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luiType' align='right'>组件类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='uiType' name='组件类型' value='"+ColumnValue["uiType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcolumnNo' align='right'>列号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnNo' name='列号' value='"+ColumnValue["columnNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisReadOnly' align='right'>只读：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isReadOnly' name='只读' value='"+ColumnValue["isReadOnly"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisVisible' align='right'>显示：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isVisible' name='显示' value='"+ColumnValue["isVisible"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lwidth' align='right'>列宽：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='width' name='列宽' value='"+ColumnValue["width"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyId' align='right'>属性ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyId' name='属性ID' value='"+ColumnValue["propertyId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcellRuleNo' align='right'>单元格处理规则号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='cellRuleNo' name='单元格处理规则号' value='"+ColumnValue["cellRuleNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodId' align='right'>调用方法ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodId' name='调用方法ID' value='"+ColumnValue["methodId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmethodName' align='right'>调用方法名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='methodName' name='调用方法名称' value='"+ColumnValue["methodName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsearchColumnNo' align='right'>查询条件列号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='searchColumnNo' name='查询条件列号' value='"+ColumnValue["searchColumnNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsearchRowNo' align='right'>查询条件行号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='searchRowNo' name='查询条件行号' value='"+ColumnValue["searchRowNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loperation' align='right'>查询操作符：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='operation' name='查询操作符' value='"+ColumnValue["operation"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconditionVisible' align='right'>查询条件可见性：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='conditionVisible' name='查询条件可见性' value='"+ColumnValue["conditionVisible"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshlpValueType' align='right'>值类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='shlpValueType' name='值类型' value='"+ColumnValue["shlpValueType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisQuickSearch' align='right'>快捷查询：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isQuickSearch' name='快捷查询' value='"+ColumnValue["isQuickSearch"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lquickCellName' align='right'>快捷查询对应栅格：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='quickCellName' name='快捷查询对应栅格' value='"+ColumnValue["quickCellName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lquickTextFormHeight' align='right'>快捷查询多行文本控制高度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='quickTextFormHeight' name='快捷查询多行文本控制高度' value='"+ColumnValue["quickTextFormHeight"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lquickTextLineNum' align='right'>快捷查询多行文本行数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='quickTextLineNum' name='快捷查询多行文本行数' value='"+ColumnValue["quickTextLineNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lquickInlineWidth' align='right'>快捷查询控件高度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='quickInlineWidth' name='快捷查询控件高度' value='"+ColumnValue["quickInlineWidth"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lquickInlineOrderNo' align='right'>快捷查询顺序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='quickInlineOrderNo' name='快捷查询顺序' value='"+ColumnValue["quickInlineOrderNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lquickInlineConnector' align='right'>快捷查询连接符：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='quickInlineConnector' name='快捷查询连接符' value='"+ColumnValue["quickInlineConnector"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisQuickShowLabel' align='right'>快捷查询显示标签：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isQuickShowLabel' name='快捷查询显示标签' value='"+ColumnValue["isQuickShowLabel"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisQuickRadioInline' align='right'>快捷查询内联：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isQuickRadioInline' name='快捷查询内联' value='"+ColumnValue["isQuickRadioInline"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisAdvSearch' align='right'>需高级查询：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isAdvSearch' name='需高级查询' value='"+ColumnValue["isAdvSearch"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ladvCellName' align='right'>高级查询对应栅格：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='advCellName' name='高级查询对应栅格' value='"+ColumnValue["advCellName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ladvTextFormHeight' align='right'>高级查询多行文本控制高度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='advTextFormHeight' name='高级查询多行文本控制高度' value='"+ColumnValue["advTextFormHeight"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ladvTextLineNum' align='right'>高级查询多行文本行数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='advTextLineNum' name='高级查询多行文本行数' value='"+ColumnValue["advTextLineNum"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ladvInlineWidth' align='right'>高级查询控件高度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='advInlineWidth' name='高级查询控件高度' value='"+ColumnValue["advInlineWidth"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ladvInlineOrderNo' align='right'>高级查询顺序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='advInlineOrderNo' name='高级查询顺序' value='"+ColumnValue["advInlineOrderNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ladvInlineConnector' align='right'>高级查询连接符：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='advInlineConnector' name='高级查询连接符' value='"+ColumnValue["advInlineConnector"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisAdvShowLabel' align='right'>高级查询显示标签：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isAdvShowLabel' name='高级查询显示标签' value='"+ColumnValue["isAdvShowLabel"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisAdvRadioInline' align='right'>高级查询内联：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isAdvRadioInline' name='高级查询内联' value='"+ColumnValue["isAdvRadioInline"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltabIndex' align='right'>Tab顺序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tabIndex' name='Tab顺序' value='"+ColumnValue["tabIndex"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisCellEditable' align='right'>表格可编辑：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isCellEditable' name='表格可编辑' value='"+ColumnValue["isCellEditable"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linitValueType' align='right'>初始值类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='initValueType' name='初始值类型' value='"+ColumnValue["initValueType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='linitValueType2' align='right'>初始值类型2：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='initValueType2' name='初始值类型2' value='"+ColumnValue["initValueType2"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldefaultValue2' align='right'>初始值2：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='defaultValue2' name='初始值2' value='"+ColumnValue["defaultValue2"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfieldSort' align='right'>字段排序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fieldSort' name='字段排序' value='"+ColumnValue["fieldSort"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lactiveExpress' align='right'>可编辑表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='activeExpress' name='可编辑表达式' value='"+ColumnValue["activeExpress"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llockColumnExpress' align='right'>列锁定表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='lockColumnExpress' name='列锁定表达式' value='"+ColumnValue["lockColumnExpress"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lunlockColumnExpress' align='right'>列解锁表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='unlockColumnExpress' name='列解锁表达式' value='"+ColumnValue["unlockColumnExpress"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisShowSort' align='right'>显示排序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isShowSort' name='显示排序' value='"+ColumnValue["isShowSort"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoGridColumn.updateIpfCcmBoGridColumn&v=1.0&format=json", $(detailstr),1600);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoGridColumnManageListView);
        }
    });

    return PlatformIpfCcmBoGridColumnManageRouter;
});


/**
 * IpfCcmBoProperty
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
                    data:{id: $("#id").val(),propertyName: $("#propertyName").val(),columnName: $("#columnName").val(),propertyType: $("#propertyType").val(),subBoLayoutType: $("#subBoLayoutType").val(),tableName: $("#tableName").val(),maxValue: $("#maxValue").val(),minValue: $("#minValue").val(),elementCode: $("#elementCode").val(),fieldText: $("#fieldText").val(),dataType: $("#dataType").val(),fieldLength: $("#fieldLength").val(),decimals: $("#decimals").val(),isNotNull: $("#isNotNull").val(),isKey: $("#isKey").val(),subBoName: $("#subBoName").val(),subBoRelType: $("#subBoRelType").val(),subBoRelPro: $("#subBoRelPro").val(),subBoOrderNo: $("#subBoOrderNo").val(),persistentSaveType: $("#persistentSaveType").val(),relSubBoProName: $("#relSubBoProName").val(),searchHelp: $("#searchHelp").val(),refProName: $("#refProName").val(),dictTableName: $("#dictTableName").val(),dictGroupValue: $("#dictGroupValue").val(),fetchWay: $("#fetchWay").val(),fixValue: $("#fixValue").val(),valueExpression: $("#valueExpression").val(),vlaueRuleNo: $("#vlaueRuleNo").val(),preCondition: $("#preCondition").val(),optCondition: $("#optCondition").val(),isSurcharge: $("#isSurcharge").val(),isRealtimeCalculate: $("#isRealtimeCalculate").val(),rpType: $("#rpType").val(),custIdPropertyName: $("#custIdPropertyName").val(),businessDatePropertyName: $("#businessDatePropertyName").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),authField: $("#authField").val(),helpIndex: $("#helpIndex").val(),numberObjectId: $("#numberObjectId").val(),relBoMethod: $("#relBoMethod").val(),relBoName: $("#relBoName").val(),shTable: $("#shTable").val(),shValueColumn: $("#shValueColumn").val(),validactionType: $("#validactionType").val(),validactionRegex: $("#validactionRegex").val()},
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
                    data:{id: $("#id").val(),propertyName: $("#propertyName").val(),columnName: $("#columnName").val(),propertyType: $("#propertyType").val(),subBoLayoutType: $("#subBoLayoutType").val(),tableName: $("#tableName").val(),maxValue: $("#maxValue").val(),minValue: $("#minValue").val(),elementCode: $("#elementCode").val(),fieldText: $("#fieldText").val(),dataType: $("#dataType").val(),fieldLength: $("#fieldLength").val(),decimals: $("#decimals").val(),isNotNull: $("#isNotNull").val(),isKey: $("#isKey").val(),subBoName: $("#subBoName").val(),subBoRelType: $("#subBoRelType").val(),subBoRelPro: $("#subBoRelPro").val(),subBoOrderNo: $("#subBoOrderNo").val(),persistentSaveType: $("#persistentSaveType").val(),relSubBoProName: $("#relSubBoProName").val(),searchHelp: $("#searchHelp").val(),refProName: $("#refProName").val(),dictTableName: $("#dictTableName").val(),dictGroupValue: $("#dictGroupValue").val(),fetchWay: $("#fetchWay").val(),fixValue: $("#fixValue").val(),valueExpression: $("#valueExpression").val(),vlaueRuleNo: $("#vlaueRuleNo").val(),preCondition: $("#preCondition").val(),optCondition: $("#optCondition").val(),isSurcharge: $("#isSurcharge").val(),isRealtimeCalculate: $("#isRealtimeCalculate").val(),rpType: $("#rpType").val(),custIdPropertyName: $("#custIdPropertyName").val(),businessDatePropertyName: $("#businessDatePropertyName").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),authField: $("#authField").val(),helpIndex: $("#helpIndex").val(),numberObjectId: $("#numberObjectId").val(),relBoMethod: $("#relBoMethod").val(),relBoName: $("#relBoName").val(),shTable: $("#shTable").val(),shValueColumn: $("#shValueColumn").val(),validactionType: $("#validactionType").val(),validactionRegex: $("#validactionRegex").val()},
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
    
    var PlatformIpfCcmBoPropertyManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoProperty_manage": "showPlatformIpfCcmBoPropertyManageList",  
            "basic_manage/platform_ckIpfCcmBoProperty_manage": "showPlatformckIpfCcmBoPropertyManageList"
        },
        showPlatformckIpfCcmBoPropertyManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoPropertyManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoPropertyManageListView = new SimpleListView({
                id: "platform_ipfCcmBoProperty_manage_list",
                title: "基础管理 > IpfCcmBoProperty",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoProperty");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyName' align='right'>属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnName' align='right'>字段名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnName' name='字段名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyType' align='right'>属性类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyType' name='属性类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoLayoutType' align='right'>布局类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoLayoutType' name='布局类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltableName' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableName' name='表名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmaxValue' align='right'>最大值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='maxValue' name='最大值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lminValue' align='right'>最小值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='minValue' name='最小值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lelementCode' align='right'>数据元素代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='elementCode' name='数据元素代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldText' align='right'>显示文本：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldText' name='显示文本' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataType' name='数据类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldLength' align='right'>字段长度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldLength' name='字段长度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldecimals' align='right'>小数位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='decimals' name='小数位' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNotNull' name='非空' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisKey' align='right'>主键：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isKey' name='主键' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoName' align='right'>子业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoName' name='子业务对象名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoRelType' align='right'>关联BO类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoRelType' name='关联BO类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoRelPro' align='right'>关系对象属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoRelPro' name='关系对象属性' style='...'/>";
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
                        detailstr+="<label id='lrelSubBoProName' align='right'>关联子业务对象属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='relSubBoProName' name='关联子业务对象属性名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchHelp' align='right'>搜索帮助名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchHelp' name='搜索帮助名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrefProName' align='right'>搜索帮助关联属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='refProName' name='搜索帮助关联属性' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictTableName' align='right'>字典表：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictTableName' name='字典表' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictGroupValue' align='right'>字典分组值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictGroupValue' name='字典分组值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfetchWay' align='right'>取数方式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fetchWay' name='取数方式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfixValue' align='right'>取数固定值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fixValue' name='取数固定值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalueExpression' align='right'>取数表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='valueExpression' name='取数表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvlaueRuleNo' align='right'>取数规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='vlaueRuleNo' name='取数规则号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpreCondition' align='right'>前提条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='preCondition' name='前提条件' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loptCondition' align='right'>选择条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='optCondition' name='选择条件' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSurcharge' align='right'>附加费：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSurcharge' name='附加费' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRealtimeCalculate' align='right'>实时计算：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRealtimeCalculate' name='实时计算' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrpType' align='right'>收付类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rpType' name='收付类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcustIdPropertyName' align='right'>客户代码属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='custIdPropertyName' name='客户代码属性名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbusinessDatePropertyName' align='right'>业务日期属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='businessDatePropertyName' name='业务日期属性名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoId' align='right'>所属业务对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoId' name='所属业务对象' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lauthField' align='right'>授权字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='authField' name='授权字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lhelpIndex' align='right'>帮助索引号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='helpIndex' name='帮助索引号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnumberObjectId' align='right'>号码对象ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='numberObjectId' name='号码对象ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrelBoMethod' align='right'>关联业务对象方法名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='relBoMethod' name='关联业务对象方法名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrelBoName' align='right'>关联业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='relBoName' name='关联业务对象名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshTable' align='right'>搜索帮助表或视图：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shTable' name='搜索帮助表或视图' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshValueColumn' align='right'>值字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shValueColumn' name='值字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalidactionType' align='right'>数据校验类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='validactionType' name='数据校验类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalidactionRegex' align='right'>数据校验正则表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='validactionRegex' name='数据校验正则表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoProperty.createIpfCcmBoProperty&v=1.0&format=json",$(detailstr),1390);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoPropertyManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoPropertyManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoPropertyManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoProperty.deleteIpfCcmBoProperty&v=1.0&format=json",
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
                        detailstr+="<label id='lpropertyName' align='right'>属性名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyName' name='属性名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnName' align='right'>字段名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnName' name='字段名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpropertyType' align='right'>属性类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='propertyType' name='属性类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoLayoutType' align='right'>布局类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoLayoutType' name='布局类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltableName' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableName' name='表名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmaxValue' align='right'>最大值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='maxValue' name='最大值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lminValue' align='right'>最小值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='minValue' name='最小值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lelementCode' align='right'>数据元素代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='elementCode' name='数据元素代码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldText' align='right'>显示文本：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldText' name='显示文本' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataType' name='数据类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldLength' align='right'>字段长度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldLength' name='字段长度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldecimals' align='right'>小数位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='decimals' name='小数位' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNotNull' name='非空' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisKey' align='right'>主键：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isKey' name='主键' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoName' align='right'>子业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoName' name='子业务对象名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoRelType' align='right'>关联BO类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoRelType' name='关联BO类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsubBoRelPro' align='right'>关系对象属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='subBoRelPro' name='关系对象属性' style='...'/>";
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
                        detailstr+="<label id='lrelSubBoProName' align='right'>关联子业务对象属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='relSubBoProName' name='关联子业务对象属性名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchHelp' align='right'>搜索帮助名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchHelp' name='搜索帮助名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrefProName' align='right'>搜索帮助关联属性：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='refProName' name='搜索帮助关联属性' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictTableName' align='right'>字典表：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictTableName' name='字典表' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictGroupValue' align='right'>字典分组值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictGroupValue' name='字典分组值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfetchWay' align='right'>取数方式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fetchWay' name='取数方式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfixValue' align='right'>取数固定值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fixValue' name='取数固定值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalueExpression' align='right'>取数表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='valueExpression' name='取数表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvlaueRuleNo' align='right'>取数规则号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='vlaueRuleNo' name='取数规则号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpreCondition' align='right'>前提条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='preCondition' name='前提条件' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loptCondition' align='right'>选择条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='optCondition' name='选择条件' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSurcharge' align='right'>附加费：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSurcharge' name='附加费' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRealtimeCalculate' align='right'>实时计算：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRealtimeCalculate' name='实时计算' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrpType' align='right'>收付类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rpType' name='收付类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcustIdPropertyName' align='right'>客户代码属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='custIdPropertyName' name='客户代码属性名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lbusinessDatePropertyName' align='right'>业务日期属性名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='businessDatePropertyName' name='业务日期属性名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoId' align='right'>所属业务对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoId' name='所属业务对象' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lauthField' align='right'>授权字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='authField' name='授权字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lhelpIndex' align='right'>帮助索引号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='helpIndex' name='帮助索引号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnumberObjectId' align='right'>号码对象ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='numberObjectId' name='号码对象ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrelBoMethod' align='right'>关联业务对象方法名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='relBoMethod' name='关联业务对象方法名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrelBoName' align='right'>关联业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='relBoName' name='关联业务对象名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshTable' align='right'>搜索帮助表或视图：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shTable' name='搜索帮助表或视图' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshValueColumn' align='right'>值字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shValueColumn' name='值字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalidactionType' align='right'>数据校验类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='validactionType' name='数据校验类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lvalidactionRegex' align='right'>数据校验正则表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='validactionRegex' name='数据校验正则表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoProperty.selectIpfCcmBoProperty&v=1.0&format=json",$(detailstr),1390);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoProperty.selectIpfCcmBoProperty&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },propertyName: { type: "string" },columnName: { type: "string" },propertyType: { type: "string" },subBoLayoutType: { type: "string" },tableName: { type: "string" },maxValue: { type: "string" },minValue: { type: "string" },elementCode: { type: "string" },fieldText: { type: "string" },dataType: { type: "string" },fieldLength: { type: "string" },decimals: { type: "string" },isNotNull: { type: "string" },isKey: { type: "string" },subBoName: { type: "string" },subBoRelType: { type: "string" },subBoRelPro: { type: "string" },subBoOrderNo: { type: "string" },persistentSaveType: { type: "string" },relSubBoProName: { type: "string" },searchHelp: { type: "string" },refProName: { type: "string" },dictTableName: { type: "string" },dictGroupValue: { type: "string" },fetchWay: { type: "string" },fixValue: { type: "string" },valueExpression: { type: "string" },vlaueRuleNo: { type: "string" },preCondition: { type: "string" },optCondition: { type: "string" },isSurcharge: { type: "string" },isRealtimeCalculate: { type: "string" },rpType: { type: "string" },custIdPropertyName: { type: "string" },businessDatePropertyName: { type: "string" },ipfCcmBoId: { type: "string" },authField: { type: "string" },helpIndex: { type: "string" },numberObjectId: { type: "string" },relBoMethod: { type: "string" },relBoName: { type: "string" },shTable: { type: "string" },shValueColumn: { type: "string" },validactionType: { type: "string" },validactionRegex: { type: "string" }
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
                            result = platformIpfCcmBoPropertyManageListView.appendColValue(result);
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
                    		{field: "propertyName", title:"属性名", align:"center", width: "100px"},
                    		{field: "columnName", title:"字段名", align:"center", width: "100px"},
                    		{field: "propertyType", title:"属性类型", align:"center", width: "100px"},
                    		{field: "subBoLayoutType", title:"布局类型", align:"center", width: "100px"},
                    		{field: "tableName", title:"表名", align:"center", width: "100px"},
                    		{field: "maxValue", title:"最大值", align:"center", width: "100px"},
                    		{field: "minValue", title:"最小值", align:"center", width: "100px"},
                    		{field: "elementCode", title:"数据元素代码", align:"center", width: "100px"},
                    		{field: "fieldText", title:"显示文本", align:"center", width: "100px"},
                    		{field: "dataType", title:"数据类型", align:"center", width: "100px"},
                    		{field: "fieldLength", title:"字段长度", align:"center", width: "100px"},
                    		{field: "decimals", title:"小数位", align:"center", width: "100px"},
                    		{field: "isNotNull", title:"非空", align:"center", width: "100px"},
                    		{field: "isKey", title:"主键", align:"center", width: "100px"},
                    		{field: "subBoName", title:"子业务对象名", align:"center", width: "100px"},
                    		{field: "subBoRelType", title:"关联BO类型", align:"center", width: "100px"},
                    		{field: "subBoRelPro", title:"关系对象属性", align:"center", width: "100px"},
                    		{field: "subBoOrderNo", title:"子业务对象的排序号", align:"center", width: "100px"},
                    		{field: "persistentSaveType", title:"子业务对象保存方式", align:"center", width: "100px"},
                    		{field: "relSubBoProName", title:"关联子业务对象属性名称", align:"center", width: "100px"},
                    		{field: "searchHelp", title:"搜索帮助名", align:"center", width: "100px"},
                    		{field: "refProName", title:"搜索帮助关联属性", align:"center", width: "100px"},
                    		{field: "dictTableName", title:"字典表", align:"center", width: "100px"},
                    		{field: "dictGroupValue", title:"字典分组值", align:"center", width: "100px"},
                    		{field: "fetchWay", title:"取数方式", align:"center", width: "100px"},
                    		{field: "fixValue", title:"取数固定值", align:"center", width: "100px"},
                    		{field: "valueExpression", title:"取数表达式", align:"center", width: "100px"},
                    		{field: "vlaueRuleNo", title:"取数规则号", align:"center", width: "100px"},
                    		{field: "preCondition", title:"前提条件", align:"center", width: "100px"},
                    		{field: "optCondition", title:"选择条件", align:"center", width: "100px"},
                    		{field: "isSurcharge", title:"附加费", align:"center", width: "100px"},
                    		{field: "isRealtimeCalculate", title:"实时计算", align:"center", width: "100px"},
                    		{field: "rpType", title:"收付类型", align:"center", width: "100px"},
                    		{field: "custIdPropertyName", title:"客户代码属性名称", align:"center", width: "100px"},
                    		{field: "businessDatePropertyName", title:"业务日期属性名称", align:"center", width: "100px"},
                    		{field: "ipfCcmBoId", title:"所属业务对象", align:"center", width: "100px"},
                    		{field: "authField", title:"授权字段", align:"center", width: "100px"},
                    		{field: "helpIndex", title:"帮助索引号", align:"center", width: "100px"},
                    		{field: "numberObjectId", title:"号码对象ID", align:"center", width: "100px"},
                    		{field: "relBoMethod", title:"关联业务对象方法名", align:"center", width: "100px"},
                    		{field: "relBoName", title:"关联业务对象名", align:"center", width: "100px"},
                    		{field: "shTable", title:"搜索帮助表或视图", align:"center", width: "100px"},
                    		{field: "shValueColumn", title:"值字段", align:"center", width: "100px"},
                    		{field: "validactionType", title:"数据校验类型", align:"center", width: "100px"},
                    		{field: "validactionRegex", title:"数据校验正则表达式", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoPropertyManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoPropertyManageListView.get("columns");
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
                                detailstr+="<label id='lpropertyName' align='right'>属性名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyName' name='属性名' value='"+ColumnValue["propertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcolumnName' align='right'>字段名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnName' name='字段名' value='"+ColumnValue["columnName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpropertyType' align='right'>属性类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='propertyType' name='属性类型' value='"+ColumnValue["propertyType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubBoLayoutType' align='right'>布局类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='subBoLayoutType' name='布局类型' value='"+ColumnValue["subBoLayoutType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltableName' align='right'>表名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tableName' name='表名' value='"+ColumnValue["tableName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmaxValue' align='right'>最大值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='maxValue' name='最大值' value='"+ColumnValue["maxValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lminValue' align='right'>最小值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='minValue' name='最小值' value='"+ColumnValue["minValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lelementCode' align='right'>数据元素代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='elementCode' name='数据元素代码' value='"+ColumnValue["elementCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfieldText' align='right'>显示文本：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fieldText' name='显示文本' value='"+ColumnValue["fieldText"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dataType' name='数据类型' value='"+ColumnValue["dataType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfieldLength' align='right'>字段长度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fieldLength' name='字段长度' value='"+ColumnValue["fieldLength"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldecimals' align='right'>小数位：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='decimals' name='小数位' value='"+ColumnValue["decimals"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisNotNull' align='right'>非空：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isNotNull' name='非空' value='"+ColumnValue["isNotNull"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisKey' align='right'>主键：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isKey' name='主键' value='"+ColumnValue["isKey"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubBoName' align='right'>子业务对象名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='subBoName' name='子业务对象名' value='"+ColumnValue["subBoName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubBoRelType' align='right'>关联BO类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='subBoRelType' name='关联BO类型' value='"+ColumnValue["subBoRelType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsubBoRelPro' align='right'>关系对象属性：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='subBoRelPro' name='关系对象属性' value='"+ColumnValue["subBoRelPro"]+"' style='...'/>";
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
                                detailstr+="<label id='lrelSubBoProName' align='right'>关联子业务对象属性名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='relSubBoProName' name='关联子业务对象属性名称' value='"+ColumnValue["relSubBoProName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsearchHelp' align='right'>搜索帮助名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='searchHelp' name='搜索帮助名' value='"+ColumnValue["searchHelp"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrefProName' align='right'>搜索帮助关联属性：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='refProName' name='搜索帮助关联属性' value='"+ColumnValue["refProName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldictTableName' align='right'>字典表：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dictTableName' name='字典表' value='"+ColumnValue["dictTableName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldictGroupValue' align='right'>字典分组值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dictGroupValue' name='字典分组值' value='"+ColumnValue["dictGroupValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfetchWay' align='right'>取数方式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fetchWay' name='取数方式' value='"+ColumnValue["fetchWay"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfixValue' align='right'>取数固定值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fixValue' name='取数固定值' value='"+ColumnValue["fixValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvalueExpression' align='right'>取数表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='valueExpression' name='取数表达式' value='"+ColumnValue["valueExpression"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvlaueRuleNo' align='right'>取数规则号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='vlaueRuleNo' name='取数规则号' value='"+ColumnValue["vlaueRuleNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpreCondition' align='right'>前提条件：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='preCondition' name='前提条件' value='"+ColumnValue["preCondition"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loptCondition' align='right'>选择条件：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='optCondition' name='选择条件' value='"+ColumnValue["optCondition"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisSurcharge' align='right'>附加费：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isSurcharge' name='附加费' value='"+ColumnValue["isSurcharge"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisRealtimeCalculate' align='right'>实时计算：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isRealtimeCalculate' name='实时计算' value='"+ColumnValue["isRealtimeCalculate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrpType' align='right'>收付类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='rpType' name='收付类型' value='"+ColumnValue["rpType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcustIdPropertyName' align='right'>客户代码属性名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='custIdPropertyName' name='客户代码属性名称' value='"+ColumnValue["custIdPropertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lbusinessDatePropertyName' align='right'>业务日期属性名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='businessDatePropertyName' name='业务日期属性名称' value='"+ColumnValue["businessDatePropertyName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lipfCcmBoId' align='right'>所属业务对象：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmBoId' name='所属业务对象' value='"+ColumnValue["ipfCcmBoId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lauthField' align='right'>授权字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='authField' name='授权字段' value='"+ColumnValue["authField"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lhelpIndex' align='right'>帮助索引号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='helpIndex' name='帮助索引号' value='"+ColumnValue["helpIndex"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lnumberObjectId' align='right'>号码对象ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='numberObjectId' name='号码对象ID' value='"+ColumnValue["numberObjectId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrelBoMethod' align='right'>关联业务对象方法名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='relBoMethod' name='关联业务对象方法名' value='"+ColumnValue["relBoMethod"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrelBoName' align='right'>关联业务对象名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='relBoName' name='关联业务对象名' value='"+ColumnValue["relBoName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshTable' align='right'>搜索帮助表或视图：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='shTable' name='搜索帮助表或视图' value='"+ColumnValue["shTable"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshValueColumn' align='right'>值字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='shValueColumn' name='值字段' value='"+ColumnValue["shValueColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvalidactionType' align='right'>数据校验类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='validactionType' name='数据校验类型' value='"+ColumnValue["validactionType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lvalidactionRegex' align='right'>数据校验正则表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='validactionRegex' name='数据校验正则表达式' value='"+ColumnValue["validactionRegex"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoProperty.updateIpfCcmBoProperty&v=1.0&format=json", $(detailstr),1390);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoPropertyManageListView);
        }
    });

    return PlatformIpfCcmBoPropertyManageRouter;
});

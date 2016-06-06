
/**
 * IpfCcmShlpDetail
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
                    data:{id: $("#id").val(),ipfCcmShlpId: $("#ipfCcmShlpId").val(),shlpName: $("#shlpName").val(),fieldName: $("#fieldName").val(),fieldText: $("#fieldText").val(),listPosition: $("#listPosition").val(),isVisible: $("#isVisible").val(),isInput: $("#isInput").val(),isOutput: $("#isOutput").val(),detailStatus: $("#detailStatus").val(),dataType: $("#dataType").val(),decimals: $("#decimals").val(),defaultValue: $("#defaultValue").val(),columnLength: $("#columnLength").val(),conditionPosition: $("#conditionPosition").val(),operation: $("#operation").val(),isRollChange: $("#isRollChange").val(),isEditable: $("#isEditable").val(),ddtext: $("#ddtext").val(),isSort: $("#isSort").val(),sortOrder: $("#sortOrder").val(),sortType: $("#sortType").val()},
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
                    data:{id: $("#id").val(),ipfCcmShlpId: $("#ipfCcmShlpId").val(),shlpName: $("#shlpName").val(),fieldName: $("#fieldName").val(),fieldText: $("#fieldText").val(),listPosition: $("#listPosition").val(),isVisible: $("#isVisible").val(),isInput: $("#isInput").val(),isOutput: $("#isOutput").val(),detailStatus: $("#detailStatus").val(),dataType: $("#dataType").val(),decimals: $("#decimals").val(),defaultValue: $("#defaultValue").val(),columnLength: $("#columnLength").val(),conditionPosition: $("#conditionPosition").val(),operation: $("#operation").val(),isRollChange: $("#isRollChange").val(),isEditable: $("#isEditable").val(),ddtext: $("#ddtext").val(),isSort: $("#isSort").val(),sortOrder: $("#sortOrder").val(),sortType: $("#sortType").val()},
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
    
    var PlatformIpfCcmShlpDetailManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmShlpDetail_manage": "showPlatformIpfCcmShlpDetailManageList",  
            "basic_manage/platform_ckIpfCcmShlpDetail_manage": "showPlatformckIpfCcmShlpDetailManageList"
        },
        showPlatformckIpfCcmShlpDetailManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmShlpDetailManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmShlpDetailManageListView = new SimpleListView({
                id: "platform_ipfCcmShlpDetail_manage_list",
                title: "基础管理 > IpfCcmShlpDetail",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmShlpDetail");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmShlpId' align='right'>搜索帮助：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmShlpId' name='搜索帮助' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpName' align='right'>搜索帮助名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpName' name='搜索帮助名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldName' align='right'>字段名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldName' name='字段名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldText' align='right'>显示文本：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldText' name='显示文本' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llistPosition' align='right'>字段清单中的位置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='listPosition' name='字段清单中的位置' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>是否清单中显示：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='是否清单中显示' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisInput' align='right'>输入参数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isInput' name='输入参数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisOutput' align='right'>输出参数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isOutput' name='输出参数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldetailStatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='detailStatus' name='状态' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataType' name='数据类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldecimals' align='right'>小数位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='decimals' name='小数位' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefaultValue' align='right'>默认值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue' name='默认值' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnLength' align='right'>长度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnLength' name='长度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconditionPosition' align='right'>条件字段位置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conditionPosition' name='条件字段位置' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperation' align='right'>操作符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='operation' name='操作符' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRollChange' align='right'>条件选择类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRollChange' name='条件选择类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisEditable' align='right'>弹出窗表格中可编辑：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isEditable' name='弹出窗表格中可编辑' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lddtext' align='right'>字段中文描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ddtext' name='字段中文描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSort' align='right'>排序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSort' name='排序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsortOrder' align='right'>排序顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sortOrder' name='排序顺序' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsortType' align='right'>排序类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sortType' name='排序类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmShlpDetail.createIpfCcmShlpDetail&v=1.0&format=json",$(detailstr),670);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmShlpDetailManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmShlpDetailManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmShlpDetailManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmShlpDetail.deleteIpfCcmShlpDetail&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcmShlpId' align='right'>搜索帮助：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmShlpId' name='搜索帮助' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lshlpName' align='right'>搜索帮助名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='shlpName' name='搜索帮助名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldName' align='right'>字段名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldName' name='字段名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lfieldText' align='right'>显示文本：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='fieldText' name='显示文本' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llistPosition' align='right'>字段清单中的位置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='listPosition' name='字段清单中的位置' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisVisible' align='right'>是否清单中显示：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isVisible' name='是否清单中显示' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisInput' align='right'>输入参数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isInput' name='输入参数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisOutput' align='right'>输出参数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isOutput' name='输出参数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldetailStatus' align='right'>状态：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='detailStatus' name='状态' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dataType' name='数据类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldecimals' align='right'>小数位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='decimals' name='小数位' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldefaultValue' align='right'>默认值：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='defaultValue' name='默认值' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnLength' align='right'>长度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnLength' name='长度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconditionPosition' align='right'>条件字段位置：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='conditionPosition' name='条件字段位置' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='loperation' align='right'>操作符：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='operation' name='操作符' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisRollChange' align='right'>条件选择类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isRollChange' name='条件选择类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisEditable' align='right'>弹出窗表格中可编辑：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isEditable' name='弹出窗表格中可编辑' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lddtext' align='right'>字段中文描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ddtext' name='字段中文描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSort' align='right'>排序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSort' name='排序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsortOrder' align='right'>排序顺序：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sortOrder' name='排序顺序' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsortType' align='right'>排序类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='sortType' name='排序类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmShlpDetail.selectIpfCcmShlpDetail&v=1.0&format=json",$(detailstr),670);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmShlpDetail.selectIpfCcmShlpDetail&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmShlpId: { type: "string" },shlpName: { type: "string" },fieldName: { type: "string" },fieldText: { type: "string" },listPosition: { type: "string" },isVisible: { type: "string" },isInput: { type: "string" },isOutput: { type: "string" },detailStatus: { type: "string" },dataType: { type: "string" },decimals: { type: "string" },defaultValue: { type: "string" },columnLength: { type: "string" },conditionPosition: { type: "string" },operation: { type: "string" },isRollChange: { type: "string" },isEditable: { type: "string" },ddtext: { type: "string" },isSort: { type: "string" },sortOrder: { type: "string" },sortType: { type: "string" }
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
                            result = platformIpfCcmShlpDetailManageListView.appendColValue(result);
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
                    		{field: "ipfCcmShlpId", title:"搜索帮助", align:"center", width: "100px"},
                    		{field: "shlpName", title:"搜索帮助名称", align:"center", width: "100px"},
                    		{field: "fieldName", title:"字段名", align:"center", width: "100px"},
                    		{field: "fieldText", title:"显示文本", align:"center", width: "100px"},
                    		{field: "listPosition", title:"字段清单中的位置", align:"center", width: "100px"},
                    		{field: "isVisible", title:"是否清单中显示", align:"center", width: "100px"},
                    		{field: "isInput", title:"输入参数", align:"center", width: "100px"},
                    		{field: "isOutput", title:"输出参数", align:"center", width: "100px"},
                    		{field: "detailStatus", title:"状态", align:"center", width: "100px"},
                    		{field: "dataType", title:"数据类型", align:"center", width: "100px"},
                    		{field: "decimals", title:"小数位", align:"center", width: "100px"},
                    		{field: "defaultValue", title:"默认值", align:"center", width: "100px"},
                    		{field: "columnLength", title:"长度", align:"center", width: "100px"},
                    		{field: "conditionPosition", title:"条件字段位置", align:"center", width: "100px"},
                    		{field: "operation", title:"操作符", align:"center", width: "100px"},
                    		{field: "isRollChange", title:"条件选择类型", align:"center", width: "100px"},
                    		{field: "isEditable", title:"弹出窗表格中可编辑", align:"center", width: "100px"},
                    		{field: "ddtext", title:"字段中文描述", align:"center", width: "100px"},
                    		{field: "isSort", title:"排序", align:"center", width: "100px"},
                    		{field: "sortOrder", title:"排序顺序", align:"center", width: "100px"},
                    		{field: "sortType", title:"排序类型", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmShlpDetailManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmShlpDetailManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcmShlpId' align='right'>搜索帮助：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmShlpId' name='搜索帮助' value='"+ColumnValue["ipfCcmShlpId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lshlpName' align='right'>搜索帮助名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='shlpName' name='搜索帮助名称' value='"+ColumnValue["shlpName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfieldName' align='right'>字段名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fieldName' name='字段名' value='"+ColumnValue["fieldName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lfieldText' align='right'>显示文本：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='fieldText' name='显示文本' value='"+ColumnValue["fieldText"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llistPosition' align='right'>字段清单中的位置：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='listPosition' name='字段清单中的位置' value='"+ColumnValue["listPosition"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisVisible' align='right'>是否清单中显示：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isVisible' name='是否清单中显示' value='"+ColumnValue["isVisible"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisInput' align='right'>输入参数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isInput' name='输入参数' value='"+ColumnValue["isInput"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisOutput' align='right'>输出参数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isOutput' name='输出参数' value='"+ColumnValue["isOutput"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldetailStatus' align='right'>状态：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='detailStatus' name='状态' value='"+ColumnValue["detailStatus"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldataType' align='right'>数据类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dataType' name='数据类型' value='"+ColumnValue["dataType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldecimals' align='right'>小数位：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='decimals' name='小数位' value='"+ColumnValue["decimals"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldefaultValue' align='right'>默认值：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='defaultValue' name='默认值' value='"+ColumnValue["defaultValue"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcolumnLength' align='right'>长度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnLength' name='长度' value='"+ColumnValue["columnLength"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconditionPosition' align='right'>条件字段位置：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='conditionPosition' name='条件字段位置' value='"+ColumnValue["conditionPosition"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='loperation' align='right'>操作符：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='operation' name='操作符' value='"+ColumnValue["operation"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisRollChange' align='right'>条件选择类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isRollChange' name='条件选择类型' value='"+ColumnValue["isRollChange"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisEditable' align='right'>弹出窗表格中可编辑：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isEditable' name='弹出窗表格中可编辑' value='"+ColumnValue["isEditable"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lddtext' align='right'>字段中文描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ddtext' name='字段中文描述' value='"+ColumnValue["ddtext"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisSort' align='right'>排序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isSort' name='排序' value='"+ColumnValue["isSort"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsortOrder' align='right'>排序顺序：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='sortOrder' name='排序顺序' value='"+ColumnValue["sortOrder"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsortType' align='right'>排序类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='sortType' name='排序类型' value='"+ColumnValue["sortType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmShlpDetail.updateIpfCcmShlpDetail&v=1.0&format=json", $(detailstr),670);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmShlpDetailManageListView);
        }
    });

    return PlatformIpfCcmShlpDetailManageRouter;
});

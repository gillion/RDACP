
/**
 * IpfCcmDict
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
                    data:{id: $("#id").val(),dictCode: $("#dictCode").val(),dictName: $("#dictName").val(),dictType: $("#dictType").val(),codeColumn: $("#codeColumn").val(),nameColumn: $("#nameColumn").val(),keyColumn: $("#keyColumn").val(),tableName: $("#tableName").val(),isGroup: $("#isGroup").val(),groupColumn: $("#groupColumn").val(),remark: $("#remark").val(),orderColumn: $("#orderColumn").val(),isSystem: $("#isSystem").val(),dataType: $("#dataType").val(),fieldLength: $("#fieldLength").val(),decimals: $("#decimals").val()},
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
                    data:{id: $("#id").val(),dictCode: $("#dictCode").val(),dictName: $("#dictName").val(),dictType: $("#dictType").val(),codeColumn: $("#codeColumn").val(),nameColumn: $("#nameColumn").val(),keyColumn: $("#keyColumn").val(),tableName: $("#tableName").val(),isGroup: $("#isGroup").val(),groupColumn: $("#groupColumn").val(),remark: $("#remark").val(),orderColumn: $("#orderColumn").val(),isSystem: $("#isSystem").val(),dataType: $("#dataType").val(),fieldLength: $("#fieldLength").val(),decimals: $("#decimals").val()},
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
    
    var PlatformIpfCcmDictManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmDict_manage": "showPlatformIpfCcmDictManageList",  
            "basic_manage/platform_ckIpfCcmDict_manage": "showPlatformckIpfCcmDictManageList"
        },
        showPlatformckIpfCcmDictManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmDictManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmDictManageListView = new SimpleListView({
                id: "platform_ipfCcmDict_manage_list",
                title: "基础管理 > IpfCcmDict",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmDict");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictCode' align='right'>字典代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictCode' name='字典代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictName' align='right'>字典名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictName' name='字典名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictType' align='right'>字典类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictType' name='字典类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeColumn' align='right'>字典代码字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='codeColumn' name='字典代码字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnameColumn' align='right'>字典名称字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='nameColumn' name='字典名称字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lkeyColumn' align='right'>字典ID字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='keyColumn' name='字典ID字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltableName' align='right'>字典表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableName' name='字典表名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisGroup' align='right'>是否分组：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isGroup' name='是否分组' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupColumn' align='right'>分组字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupColumn' name='分组字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lorderColumn' align='right'>排序字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='orderColumn' name='排序字段' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSystem' align='right'>是否系统：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSystem' name='是否系统' style='...'/>";
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
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmDict.createIpfCcmDict&v=1.0&format=json",$(detailstr),490);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmDictManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmDictManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmDictManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmDict.deleteIpfCcmDict&v=1.0&format=json",
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
                        detailstr+="<label id='ldictCode' align='right'>字典代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictCode' name='字典代码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictName' align='right'>字典名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictName' name='字典名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldictType' align='right'>字典类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='dictType' name='字典类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcodeColumn' align='right'>字典代码字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='codeColumn' name='字典代码字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lnameColumn' align='right'>字典名称字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='nameColumn' name='字典名称字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lkeyColumn' align='right'>字典ID字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='keyColumn' name='字典ID字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltableName' align='right'>字典表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableName' name='字典表名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisGroup' align='right'>是否分组：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isGroup' name='是否分组' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupColumn' align='right'>分组字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupColumn' name='分组字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lorderColumn' align='right'>排序字段：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='orderColumn' name='排序字段' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisSystem' align='right'>是否系统：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isSystem' name='是否系统' style='...'/>";
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
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmDict.selectIpfCcmDict&v=1.0&format=json",$(detailstr),490);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmDict.selectIpfCcmDict&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },dictCode: { type: "string" },dictName: { type: "string" },dictType: { type: "string" },codeColumn: { type: "string" },nameColumn: { type: "string" },keyColumn: { type: "string" },tableName: { type: "string" },isGroup: { type: "string" },groupColumn: { type: "string" },remark: { type: "string" },orderColumn: { type: "string" },isSystem: { type: "string" },dataType: { type: "string" },fieldLength: { type: "string" },decimals: { type: "string" }
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
                            result = platformIpfCcmDictManageListView.appendColValue(result);
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
                    		{field: "dictCode", title:"字典代码", align:"center", width: "100px"},
                    		{field: "dictName", title:"字典名称", align:"center", width: "100px"},
                    		{field: "dictType", title:"字典类型", align:"center", width: "100px"},
                    		{field: "codeColumn", title:"字典代码字段", align:"center", width: "100px"},
                    		{field: "nameColumn", title:"字典名称字段", align:"center", width: "100px"},
                    		{field: "keyColumn", title:"字典ID字段", align:"center", width: "100px"},
                    		{field: "tableName", title:"字典表名", align:"center", width: "100px"},
                    		{field: "isGroup", title:"是否分组", align:"center", width: "100px"},
                    		{field: "groupColumn", title:"分组字段", align:"center", width: "100px"},
                    		{field: "remark", title:"备注", align:"center", width: "100px"},
                    		{field: "orderColumn", title:"排序字段", align:"center", width: "100px"},
                    		{field: "isSystem", title:"是否系统", align:"center", width: "100px"},
                    		{field: "dataType", title:"数据类型", align:"center", width: "100px"},
                    		{field: "fieldLength", title:"字段长度", align:"center", width: "100px"},
                    		{field: "decimals", title:"小数位", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmDictManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmDictManageListView.get("columns");
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
                                detailstr+="<label id='ldictCode' align='right'>字典代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dictCode' name='字典代码' value='"+ColumnValue["dictCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldictName' align='right'>字典名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dictName' name='字典名称' value='"+ColumnValue["dictName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldictType' align='right'>字典类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='dictType' name='字典类型' value='"+ColumnValue["dictType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcodeColumn' align='right'>字典代码字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='codeColumn' name='字典代码字段' value='"+ColumnValue["codeColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lnameColumn' align='right'>字典名称字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='nameColumn' name='字典名称字段' value='"+ColumnValue["nameColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lkeyColumn' align='right'>字典ID字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='keyColumn' name='字典ID字段' value='"+ColumnValue["keyColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltableName' align='right'>字典表名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tableName' name='字典表名' value='"+ColumnValue["tableName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisGroup' align='right'>是否分组：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isGroup' name='是否分组' value='"+ColumnValue["isGroup"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupColumn' align='right'>分组字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='groupColumn' name='分组字段' value='"+ColumnValue["groupColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='remark' name='备注' value='"+ColumnValue["remark"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lorderColumn' align='right'>排序字段：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='orderColumn' name='排序字段' value='"+ColumnValue["orderColumn"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisSystem' align='right'>是否系统：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isSystem' name='是否系统' value='"+ColumnValue["isSystem"]+"' style='...'/>";
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
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmDict.updateIpfCcmDict&v=1.0&format=json", $(detailstr),490);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmDictManageListView);
        }
    });

    return PlatformIpfCcmDictManageRouter;
});

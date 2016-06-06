
/**
 * IpfCcmBoFormCell
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),formType: $("#formType").val(),isDefault: $("#isDefault").val(),cellName: $("#cellName").val(),cellType: $("#cellType").val(),cellHeigh: $("#cellHeigh").val(),isShowGroup: $("#isShowGroup").val(),groupWidget: $("#groupWidget").val(),elementCode: $("#elementCode").val(),groupTitle: $("#groupTitle").val(),unitCount: $("#unitCount").val(),isParent: $("#isParent").val(),childrenLineCount: $("#childrenLineCount").val(),parentCellName: $("#parentCellName").val(),rowNo: $("#rowNo").val(),columnNo: $("#columnNo").val(),labelUnitCount: $("#labelUnitCount").val()},
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
                    data:{id: $("#id").val(),ipfCcmBoId: $("#ipfCcmBoId").val(),formType: $("#formType").val(),isDefault: $("#isDefault").val(),cellName: $("#cellName").val(),cellType: $("#cellType").val(),cellHeigh: $("#cellHeigh").val(),isShowGroup: $("#isShowGroup").val(),groupWidget: $("#groupWidget").val(),elementCode: $("#elementCode").val(),groupTitle: $("#groupTitle").val(),unitCount: $("#unitCount").val(),isParent: $("#isParent").val(),childrenLineCount: $("#childrenLineCount").val(),parentCellName: $("#parentCellName").val(),rowNo: $("#rowNo").val(),columnNo: $("#columnNo").val(),labelUnitCount: $("#labelUnitCount").val()},
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
    
    var PlatformIpfCcmBoFormCellManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoFormCell_manage": "showPlatformIpfCcmBoFormCellManageList",  
            "basic_manage/platform_ckIpfCcmBoFormCell_manage": "showPlatformckIpfCcmBoFormCellManageList"
        },
        showPlatformckIpfCcmBoFormCellManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoFormCellManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoFormCellManageListView = new SimpleListView({
                id: "platform_ipfCcmBoFormCell_manage_list",
                title: "基础管理 > IpfCcmBoFormCell",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoFormCell");
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
                        detailstr+="<label id='lformType' align='right'>界面类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='formType' name='界面类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisDefault' align='right'>默认FORM：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isDefault' name='默认FORM' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellName' align='right'>栅格名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellName' name='栅格名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellType' align='right'>栅格类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellType' name='栅格类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellHeigh' align='right'>栅格高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellHeigh' name='栅格高度' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisShowGroup' align='right'>显示分组：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isShowGroup' name='显示分组' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupWidget' align='right'>分组控件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupWidget' name='分组控件' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lelementCode' align='right'>数据元素代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='elementCode' name='数据元素代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupTitle' align='right'>分组标题：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupTitle' name='分组标题' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lunitCount' align='right'>包含栅格数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='unitCount' name='包含栅格数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisParent' align='right'>包含子栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isParent' name='包含子栅格' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchildrenLineCount' align='right'>子栅格行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='childrenLineCount' name='子栅格行数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparentCellName' align='right'>父栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='parentCellName' name='父栅格' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrowNo' align='right'>所属栅格行：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rowNo' name='所属栅格行' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnNo' align='right'>所属栅格列：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnNo' name='所属栅格列' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llabelUnitCount' align='right'>标签占栅格数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='labelUnitCount' name='标签占栅格数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoFormCell.createIpfCcmBoFormCell&v=1.0&format=json",$(detailstr),550);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoFormCellManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoFormCellManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoFormCellManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoFormCell.deleteIpfCcmBoFormCell&v=1.0&format=json",
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
                        detailstr+="<label id='lformType' align='right'>界面类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='formType' name='界面类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisDefault' align='right'>默认FORM：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isDefault' name='默认FORM' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellName' align='right'>栅格名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellName' name='栅格名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellType' align='right'>栅格类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellType' name='栅格类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellHeigh' align='right'>栅格高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellHeigh' name='栅格高度' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisShowGroup' align='right'>显示分组：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isShowGroup' name='显示分组' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupWidget' align='right'>分组控件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupWidget' name='分组控件' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lelementCode' align='right'>数据元素代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='elementCode' name='数据元素代码' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupTitle' align='right'>分组标题：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupTitle' name='分组标题' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lunitCount' align='right'>包含栅格数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='unitCount' name='包含栅格数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisParent' align='right'>包含子栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isParent' name='包含子栅格' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchildrenLineCount' align='right'>子栅格行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='childrenLineCount' name='子栅格行数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparentCellName' align='right'>父栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='parentCellName' name='父栅格' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrowNo' align='right'>所属栅格行：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rowNo' name='所属栅格行' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnNo' align='right'>所属栅格列：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnNo' name='所属栅格列' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llabelUnitCount' align='right'>标签占栅格数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='labelUnitCount' name='标签占栅格数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoFormCell.selectIpfCcmBoFormCell&v=1.0&format=json",$(detailstr),550);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoFormCell.selectIpfCcmBoFormCell&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBoId: { type: "string" },formType: { type: "string" },isDefault: { type: "string" },cellName: { type: "string" },cellType: { type: "string" },cellHeigh: { type: "string" },isShowGroup: { type: "string" },groupWidget: { type: "string" },elementCode: { type: "string" },groupTitle: { type: "string" },unitCount: { type: "string" },isParent: { type: "string" },childrenLineCount: { type: "string" },parentCellName: { type: "string" },rowNo: { type: "string" },columnNo: { type: "string" },labelUnitCount: { type: "string" }
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
                            result = platformIpfCcmBoFormCellManageListView.appendColValue(result);
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
                    		{field: "formType", title:"界面类型", align:"center", width: "100px"},
                    		{field: "isDefault", title:"默认FORM", align:"center", width: "100px"},
                    		{field: "cellName", title:"栅格名称", align:"center", width: "100px"},
                    		{field: "cellType", title:"栅格类型", align:"center", width: "100px"},
                    		{field: "cellHeigh", title:"栅格高度", align:"center", width: "100px"},
                    		{field: "isShowGroup", title:"显示分组", align:"center", width: "100px"},
                    		{field: "groupWidget", title:"分组控件", align:"center", width: "100px"},
                    		{field: "elementCode", title:"数据元素代码", align:"center", width: "100px"},
                    		{field: "groupTitle", title:"分组标题", align:"center", width: "100px"},
                    		{field: "unitCount", title:"包含栅格数", align:"center", width: "100px"},
                    		{field: "isParent", title:"包含子栅格", align:"center", width: "100px"},
                    		{field: "childrenLineCount", title:"子栅格行数", align:"center", width: "100px"},
                    		{field: "parentCellName", title:"父栅格", align:"center", width: "100px"},
                    		{field: "rowNo", title:"所属栅格行", align:"center", width: "100px"},
                    		{field: "columnNo", title:"所属栅格列", align:"center", width: "100px"},
                    		{field: "labelUnitCount", title:"标签占栅格数", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoFormCellManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoFormCellManageListView.get("columns");
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
                                detailstr+="<label id='lformType' align='right'>界面类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='formType' name='界面类型' value='"+ColumnValue["formType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisDefault' align='right'>默认FORM：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isDefault' name='默认FORM' value='"+ColumnValue["isDefault"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcellName' align='right'>栅格名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='cellName' name='栅格名称' value='"+ColumnValue["cellName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcellType' align='right'>栅格类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='cellType' name='栅格类型' value='"+ColumnValue["cellType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcellHeigh' align='right'>栅格高度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='cellHeigh' name='栅格高度' value='"+ColumnValue["cellHeigh"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisShowGroup' align='right'>显示分组：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isShowGroup' name='显示分组' value='"+ColumnValue["isShowGroup"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupWidget' align='right'>分组控件：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='groupWidget' name='分组控件' value='"+ColumnValue["groupWidget"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lelementCode' align='right'>数据元素代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='elementCode' name='数据元素代码' value='"+ColumnValue["elementCode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupTitle' align='right'>分组标题：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='groupTitle' name='分组标题' value='"+ColumnValue["groupTitle"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lunitCount' align='right'>包含栅格数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='unitCount' name='包含栅格数' value='"+ColumnValue["unitCount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisParent' align='right'>包含子栅格：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isParent' name='包含子栅格' value='"+ColumnValue["isParent"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lchildrenLineCount' align='right'>子栅格行数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='childrenLineCount' name='子栅格行数' value='"+ColumnValue["childrenLineCount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparentCellName' align='right'>父栅格：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='parentCellName' name='父栅格' value='"+ColumnValue["parentCellName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrowNo' align='right'>所属栅格行：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='rowNo' name='所属栅格行' value='"+ColumnValue["rowNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcolumnNo' align='right'>所属栅格列：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnNo' name='所属栅格列' value='"+ColumnValue["columnNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llabelUnitCount' align='right'>标签占栅格数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='labelUnitCount' name='标签占栅格数' value='"+ColumnValue["labelUnitCount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoFormCell.updateIpfCcmBoFormCell&v=1.0&format=json", $(detailstr),550);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoFormCellManageListView);
        }
    });

    return PlatformIpfCcmBoFormCellManageRouter;
});

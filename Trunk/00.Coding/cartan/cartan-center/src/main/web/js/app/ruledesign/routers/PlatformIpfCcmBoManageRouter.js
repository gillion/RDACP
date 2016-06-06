
/**
 * IpfCcmBo
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
                    data:{id: $("#id").val(),boName: $("#boName").val(),boType: $("#boType").val(),appModule: $("#appModule").val(),serviceType: $("#serviceType").val(),javaPath: $("#javaPath").val(),serviceCategory: $("#serviceCategory").val(),tableName: $("#tableName").val(),tableType: $("#tableType").val(),description: $("#description").val(),searchColumns: $("#searchColumns").val(),searchMode: $("#searchMode").val(),pageSize: $("#pageSize").val(),ipfCcmUiLayoutId: $("#ipfCcmUiLayoutId").val(),uiLayoutName: $("#uiLayoutName").val(),formCellMode: $("#formCellMode").val(),uiTemplate: $("#uiTemplate").val(),formColumns: $("#formColumns").val(),gridStyle: $("#gridStyle").val(),gridAlign: $("#gridAlign").val(),gridEditType: $("#gridEditType").val(),generateOption: $("#generateOption").val(),lockRowExpress: $("#lockRowExpress").val(),gridType: $("#gridType").val(),isMainObject: $("#isMainObject").val(),isInitDataBo: $("#isInitDataBo").val(),isAutoLoad: $("#isAutoLoad").val(),isNeedAdvSearch: $("#isNeedAdvSearch").val(),needPaging: $("#needPaging").val(),isGridFilter: $("#isGridFilter").val(),isGridCustom: $("#isGridCustom").val(),remark: $("#remark").val(),whereClause: $("#whereClause").val(),idGenerator: $("#idGenerator").val()},
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
                    data:{id: $("#id").val(),boName: $("#boName").val(),boType: $("#boType").val(),appModule: $("#appModule").val(),serviceType: $("#serviceType").val(),javaPath: $("#javaPath").val(),serviceCategory: $("#serviceCategory").val(),tableName: $("#tableName").val(),tableType: $("#tableType").val(),description: $("#description").val(),searchColumns: $("#searchColumns").val(),searchMode: $("#searchMode").val(),pageSize: $("#pageSize").val(),ipfCcmUiLayoutId: $("#ipfCcmUiLayoutId").val(),uiLayoutName: $("#uiLayoutName").val(),formCellMode: $("#formCellMode").val(),uiTemplate: $("#uiTemplate").val(),formColumns: $("#formColumns").val(),gridStyle: $("#gridStyle").val(),gridAlign: $("#gridAlign").val(),gridEditType: $("#gridEditType").val(),generateOption: $("#generateOption").val(),lockRowExpress: $("#lockRowExpress").val(),gridType: $("#gridType").val(),isMainObject: $("#isMainObject").val(),isInitDataBo: $("#isInitDataBo").val(),isAutoLoad: $("#isAutoLoad").val(),isNeedAdvSearch: $("#isNeedAdvSearch").val(),needPaging: $("#needPaging").val(),isGridFilter: $("#isGridFilter").val(),isGridCustom: $("#isGridCustom").val(),remark: $("#remark").val(),whereClause: $("#whereClause").val(),idGenerator: $("#idGenerator").val()},
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
    
    var PlatformIpfCcmBoManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBo_manage": "showPlatformIpfCcmBoManageList",  
            "basic_manage/platform_ckIpfCcmBo_manage": "showPlatformckIpfCcmBoManageList"
        },
        showPlatformckIpfCcmBoManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoManageListView = new SimpleListView({
                id: "platform_ipfCcmBo_manage_list",
                title: "基础管理 > IpfCcmBo",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBo");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboName' align='right'>业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boName' name='业务对象名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboType' align='right'>对象类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boType' name='对象类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lappModule' align='right'>功能模块：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='appModule' name='功能模块' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lserviceType' align='right'>服务类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='serviceType' name='服务类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljavaPath' align='right'>JAVA路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='javaPath' name='JAVA路径' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lserviceCategory' align='right'>服务分类：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='serviceCategory' name='服务分类' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltableName' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableName' name='表名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltableType' align='right'>表类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableType' name='表类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldescription' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='description' name='描述' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchColumns' align='right'>查询条件列数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchColumns' name='查询条件列数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchMode' align='right'>查询模式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchMode' name='查询模式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpageSize' align='right'>每页记录：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='pageSize' name='每页记录' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmUiLayoutId' align='right'>界面布局ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmUiLayoutId' name='界面布局ID' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiLayoutName' align='right'>界面布局名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiLayoutName' name='界面布局名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lformCellMode' align='right'>界面模式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='formCellMode' name='界面模式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiTemplate' align='right'>界面模板：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiTemplate' name='界面模板' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lformColumns' align='right'>每行列数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='formColumns' name='每行列数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridStyle' align='right'>表格样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridStyle' name='表格样式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridAlign' align='right'>表格列对齐：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridAlign' name='表格列对齐' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridEditType' align='right'>表格维护方式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridEditType' name='表格维护方式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgenerateOption' align='right'>代码生成选项：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='generateOption' name='代码生成选项' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llockRowExpress' align='right'>行锁定表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lockRowExpress' name='行锁定表达式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridType' align='right'>表格类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridType' name='表格类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisMainObject' align='right'>主对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isMainObject' name='主对象' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisInitDataBo' align='right'>初始化数据对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isInitDataBo' name='初始化数据对象' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisAutoLoad' align='right'>自动查询：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAutoLoad' name='自动查询' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisNeedAdvSearch' align='right'>需高级查询：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNeedAdvSearch' name='需高级查询' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lneedPaging' align='right'>表格分页：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='needPaging' name='表格分页' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisGridFilter' align='right'>表格列筛选：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isGridFilter' name='表格列筛选' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisGridCustom' align='right'>表格列定义：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isGridCustom' name='表格列定义' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lwhereClause' align='right'>WHERE条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='whereClause' name='WHERE条件' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidGenerator' align='right'>ID生成器名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='idGenerator' name='ID生成器名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBo.createIpfCcmBo&v=1.0&format=json",$(detailstr),1030);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBo.deleteIpfCcmBo&v=1.0&format=json",
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
                        detailstr+="<label id='lboName' align='right'>业务对象名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boName' name='业务对象名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lboType' align='right'>对象类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='boType' name='对象类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lappModule' align='right'>功能模块：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='appModule' name='功能模块' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lserviceType' align='right'>服务类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='serviceType' name='服务类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ljavaPath' align='right'>JAVA路径：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='javaPath' name='JAVA路径' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lserviceCategory' align='right'>服务分类：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='serviceCategory' name='服务分类' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltableName' align='right'>表名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableName' name='表名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltableType' align='right'>表类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tableType' name='表类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldescription' align='right'>描述：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='description' name='描述' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchColumns' align='right'>查询条件列数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchColumns' name='查询条件列数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsearchMode' align='right'>查询模式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='searchMode' name='查询模式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lpageSize' align='right'>每页记录：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='pageSize' name='每页记录' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmUiLayoutId' align='right'>界面布局ID：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmUiLayoutId' name='界面布局ID' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiLayoutName' align='right'>界面布局名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiLayoutName' name='界面布局名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lformCellMode' align='right'>界面模式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='formCellMode' name='界面模式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luiTemplate' align='right'>界面模板：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='uiTemplate' name='界面模板' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lformColumns' align='right'>每行列数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='formColumns' name='每行列数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridStyle' align='right'>表格样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridStyle' name='表格样式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridAlign' align='right'>表格列对齐：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridAlign' name='表格列对齐' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridEditType' align='right'>表格维护方式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridEditType' name='表格维护方式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgenerateOption' align='right'>代码生成选项：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='generateOption' name='代码生成选项' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llockRowExpress' align='right'>行锁定表达式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='lockRowExpress' name='行锁定表达式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgridType' align='right'>表格类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='gridType' name='表格类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisMainObject' align='right'>主对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isMainObject' name='主对象' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisInitDataBo' align='right'>初始化数据对象：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isInitDataBo' name='初始化数据对象' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisAutoLoad' align='right'>自动查询：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isAutoLoad' name='自动查询' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisNeedAdvSearch' align='right'>需高级查询：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isNeedAdvSearch' name='需高级查询' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lneedPaging' align='right'>表格分页：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='needPaging' name='表格分页' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisGridFilter' align='right'>表格列筛选：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isGridFilter' name='表格列筛选' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lisGridCustom' align='right'>表格列定义：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isGridCustom' name='表格列定义' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lremark' align='right'>备注：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='remark' name='备注' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lwhereClause' align='right'>WHERE条件：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='whereClause' name='WHERE条件' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lidGenerator' align='right'>ID生成器名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='idGenerator' name='ID生成器名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBo.selectIpfCcmBo&v=1.0&format=json",$(detailstr),1030);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBo.selectIpfCcmBo&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },boName: { type: "string" },boType: { type: "string" },appModule: { type: "string" },serviceType: { type: "string" },javaPath: { type: "string" },serviceCategory: { type: "string" },tableName: { type: "string" },tableType: { type: "string" },description: { type: "string" },searchColumns: { type: "string" },searchMode: { type: "string" },pageSize: { type: "string" },ipfCcmUiLayoutId: { type: "string" },uiLayoutName: { type: "string" },formCellMode: { type: "string" },uiTemplate: { type: "string" },formColumns: { type: "string" },gridStyle: { type: "string" },gridAlign: { type: "string" },gridEditType: { type: "string" },generateOption: { type: "string" },lockRowExpress: { type: "string" },gridType: { type: "string" },isMainObject: { type: "string" },isInitDataBo: { type: "string" },isAutoLoad: { type: "string" },isNeedAdvSearch: { type: "string" },needPaging: { type: "string" },isGridFilter: { type: "string" },isGridCustom: { type: "string" },remark: { type: "string" },whereClause: { type: "string" },idGenerator: { type: "string" }
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
                            result = platformIpfCcmBoManageListView.appendColValue(result);
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
                    		{field: "boName", title:"业务对象名", align:"center", width: "100px"},
                    		{field: "boType", title:"对象类型", align:"center", width: "100px"},
                    		{field: "appModule", title:"功能模块", align:"center", width: "100px"},
                    		{field: "serviceType", title:"服务类型", align:"center", width: "100px"},
                    		{field: "javaPath", title:"JAVA路径", align:"center", width: "100px"},
                    		{field: "serviceCategory", title:"服务分类", align:"center", width: "100px"},
                    		{field: "tableName", title:"表名", align:"center", width: "100px"},
                    		{field: "tableType", title:"表类型", align:"center", width: "100px"},
                    		{field: "description", title:"描述", align:"center", width: "100px"},
                    		{field: "searchColumns", title:"查询条件列数", align:"center", width: "100px"},
                    		{field: "searchMode", title:"查询模式", align:"center", width: "100px"},
                    		{field: "pageSize", title:"每页记录", align:"center", width: "100px"},
                    		{field: "ipfCcmUiLayoutId", title:"界面布局ID", align:"center", width: "100px"},
                    		{field: "uiLayoutName", title:"界面布局名称", align:"center", width: "100px"},
                    		{field: "formCellMode", title:"界面模式", align:"center", width: "100px"},
                    		{field: "uiTemplate", title:"界面模板", align:"center", width: "100px"},
                    		{field: "formColumns", title:"每行列数", align:"center", width: "100px"},
                    		{field: "gridStyle", title:"表格样式", align:"center", width: "100px"},
                    		{field: "gridAlign", title:"表格列对齐", align:"center", width: "100px"},
                    		{field: "gridEditType", title:"表格维护方式", align:"center", width: "100px"},
                    		{field: "generateOption", title:"代码生成选项", align:"center", width: "100px"},
                    		{field: "lockRowExpress", title:"行锁定表达式", align:"center", width: "100px"},
                    		{field: "gridType", title:"表格类型", align:"center", width: "100px"},
                    		{field: "isMainObject", title:"主对象", align:"center", width: "100px"},
                    		{field: "isInitDataBo", title:"初始化数据对象", align:"center", width: "100px"},
                    		{field: "isAutoLoad", title:"自动查询", align:"center", width: "100px"},
                    		{field: "isNeedAdvSearch", title:"需高级查询", align:"center", width: "100px"},
                    		{field: "needPaging", title:"表格分页", align:"center", width: "100px"},
                    		{field: "isGridFilter", title:"表格列筛选", align:"center", width: "100px"},
                    		{field: "isGridCustom", title:"表格列定义", align:"center", width: "100px"},
                    		{field: "remark", title:"备注", align:"center", width: "100px"},
                    		{field: "whereClause", title:"WHERE条件", align:"center", width: "100px"},
                    		{field: "idGenerator", title:"ID生成器名称", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoManageListView.get("columns");
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
                                detailstr+="<label id='lboName' align='right'>业务对象名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boName' name='业务对象名' value='"+ColumnValue["boName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lboType' align='right'>对象类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='boType' name='对象类型' value='"+ColumnValue["boType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lappModule' align='right'>功能模块：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='appModule' name='功能模块' value='"+ColumnValue["appModule"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lserviceType' align='right'>服务类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='serviceType' name='服务类型' value='"+ColumnValue["serviceType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ljavaPath' align='right'>JAVA路径：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='javaPath' name='JAVA路径' value='"+ColumnValue["javaPath"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lserviceCategory' align='right'>服务分类：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='serviceCategory' name='服务分类' value='"+ColumnValue["serviceCategory"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltableName' align='right'>表名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tableName' name='表名' value='"+ColumnValue["tableName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltableType' align='right'>表类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tableType' name='表类型' value='"+ColumnValue["tableType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldescription' align='right'>描述：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='description' name='描述' value='"+ColumnValue["description"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsearchColumns' align='right'>查询条件列数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='searchColumns' name='查询条件列数' value='"+ColumnValue["searchColumns"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsearchMode' align='right'>查询模式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='searchMode' name='查询模式' value='"+ColumnValue["searchMode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lpageSize' align='right'>每页记录：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='pageSize' name='每页记录' value='"+ColumnValue["pageSize"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lipfCcmUiLayoutId' align='right'>界面布局ID：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmUiLayoutId' name='界面布局ID' value='"+ColumnValue["ipfCcmUiLayoutId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luiLayoutName' align='right'>界面布局名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='uiLayoutName' name='界面布局名称' value='"+ColumnValue["uiLayoutName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lformCellMode' align='right'>界面模式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='formCellMode' name='界面模式' value='"+ColumnValue["formCellMode"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='luiTemplate' align='right'>界面模板：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='uiTemplate' name='界面模板' value='"+ColumnValue["uiTemplate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lformColumns' align='right'>每行列数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='formColumns' name='每行列数' value='"+ColumnValue["formColumns"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgridStyle' align='right'>表格样式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='gridStyle' name='表格样式' value='"+ColumnValue["gridStyle"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgridAlign' align='right'>表格列对齐：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='gridAlign' name='表格列对齐' value='"+ColumnValue["gridAlign"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgridEditType' align='right'>表格维护方式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='gridEditType' name='表格维护方式' value='"+ColumnValue["gridEditType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgenerateOption' align='right'>代码生成选项：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='generateOption' name='代码生成选项' value='"+ColumnValue["generateOption"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llockRowExpress' align='right'>行锁定表达式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='lockRowExpress' name='行锁定表达式' value='"+ColumnValue["lockRowExpress"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgridType' align='right'>表格类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='gridType' name='表格类型' value='"+ColumnValue["gridType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisMainObject' align='right'>主对象：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isMainObject' name='主对象' value='"+ColumnValue["isMainObject"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisInitDataBo' align='right'>初始化数据对象：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isInitDataBo' name='初始化数据对象' value='"+ColumnValue["isInitDataBo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisAutoLoad' align='right'>自动查询：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isAutoLoad' name='自动查询' value='"+ColumnValue["isAutoLoad"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisNeedAdvSearch' align='right'>需高级查询：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isNeedAdvSearch' name='需高级查询' value='"+ColumnValue["isNeedAdvSearch"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lneedPaging' align='right'>表格分页：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='needPaging' name='表格分页' value='"+ColumnValue["needPaging"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisGridFilter' align='right'>表格列筛选：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isGridFilter' name='表格列筛选' value='"+ColumnValue["isGridFilter"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lisGridCustom' align='right'>表格列定义：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isGridCustom' name='表格列定义' value='"+ColumnValue["isGridCustom"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lremark' align='right'>备注：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='remark' name='备注' value='"+ColumnValue["remark"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lwhereClause' align='right'>WHERE条件：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='whereClause' name='WHERE条件' value='"+ColumnValue["whereClause"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lidGenerator' align='right'>ID生成器名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='idGenerator' name='ID生成器名称' value='"+ColumnValue["idGenerator"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBo.updateIpfCcmBo&v=1.0&format=json", $(detailstr),1030);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoManageListView);
        }
    });

    return PlatformIpfCcmBoManageRouter;
});

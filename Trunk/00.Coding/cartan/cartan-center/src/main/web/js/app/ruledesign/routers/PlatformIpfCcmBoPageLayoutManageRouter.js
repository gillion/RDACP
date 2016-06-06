
/**
 * IpfCcmBoPageLayout
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
                    data:{id: $("#id").val(),ipfCcmBoPageId: $("#ipfCcmBoPageId").val(),layoutType: $("#layoutType").val(),layoutContainerType: $("#layoutContainerType").val(),layoutBoName: $("#layoutBoName").val(),styleClass: $("#styleClass").val(),style: $("#style").val(),formType: $("#formType").val(),elementName: $("#elementName").val(),height: $("#height").val(),isShowGroup: $("#isShowGroup").val(),groupWidget: $("#groupWidget").val(),groupMsgCode: $("#groupMsgCode").val(),groupTitle: $("#groupTitle").val(),unitCount: $("#unitCount").val(),isParent: $("#isParent").val(),childrenLineCount: $("#childrenLineCount").val(),cellName: $("#cellName").val(),rowNo: $("#rowNo").val(),columnNo: $("#columnNo").val(),labelUnitCount: $("#labelUnitCount").val(),seqNo: $("#seqNo").val(),controlConnector: $("#controlConnector").val(),parentCellName: $("#parentCellName").val()},
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
                    data:{id: $("#id").val(),ipfCcmBoPageId: $("#ipfCcmBoPageId").val(),layoutType: $("#layoutType").val(),layoutContainerType: $("#layoutContainerType").val(),layoutBoName: $("#layoutBoName").val(),styleClass: $("#styleClass").val(),style: $("#style").val(),formType: $("#formType").val(),elementName: $("#elementName").val(),height: $("#height").val(),isShowGroup: $("#isShowGroup").val(),groupWidget: $("#groupWidget").val(),groupMsgCode: $("#groupMsgCode").val(),groupTitle: $("#groupTitle").val(),unitCount: $("#unitCount").val(),isParent: $("#isParent").val(),childrenLineCount: $("#childrenLineCount").val(),cellName: $("#cellName").val(),rowNo: $("#rowNo").val(),columnNo: $("#columnNo").val(),labelUnitCount: $("#labelUnitCount").val(),seqNo: $("#seqNo").val(),controlConnector: $("#controlConnector").val(),parentCellName: $("#parentCellName").val()},
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
    
    var PlatformIpfCcmBoPageLayoutManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_IpfCcmBoPageLayout_manage": "showPlatformIpfCcmBoPageLayoutManageList",  
            "basic_manage/platform_ckIpfCcmBoPageLayout_manage": "showPlatformckIpfCcmBoPageLayoutManageList"
        },
        showPlatformckIpfCcmBoPageLayoutManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformIpfCcmBoPageLayoutManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformIpfCcmBoPageLayoutManageListView = new SimpleListView({
                id: "platform_ipfCcmBoPageLayout_manage_list",
                title: "基础管理 > IpfCcmBoPageLayout",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("IpfCcmBoPageLayout");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lipfCcmBoPageId' align='right'>页面：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoPageId' name='页面' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutType' align='right'>页面布局类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutType' name='页面布局类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutContainerType' align='right'>页面布局容器类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutContainerType' name='页面布局容器类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutBoName' align='right'>页面布局业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutBoName' name='页面布局业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstyleClass' align='right'>样式名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='styleClass' name='样式名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstyle' align='right'>样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='style' name='样式' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lformType' align='right'>表单类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='formType' name='表单类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lelementName' align='right'>布局元素名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='elementName' name='布局元素名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lheight' align='right'>栅格高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='height' name='栅格高度' style='...'/>";
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
                        detailstr+="<label id='lgroupMsgCode' align='right'>分组标题系统消息代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupMsgCode' name='分组标题系统消息代码' style='...'/>";
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
                        detailstr+="<label id='lisParent' align='right'>是否父栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isParent' name='是否父栅格' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchildrenLineCount' align='right'>子栅格行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='childrenLineCount' name='子栅格行数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellName' align='right'>栅格名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellName' name='栅格名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrowNo' align='right'>行号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rowNo' name='行号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnNo' align='right'>列号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnNo' name='列号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llabelUnitCount' align='right'>标签占栅格数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='labelUnitCount' name='标签占栅格数' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lseqNo' align='right'>序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='seqNo' name='序号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontrolConnector' align='right'>连接符号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='controlConnector' name='连接符号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparentCellName' align='right'>父栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='parentCellName' name='父栅格' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=ipfCcmBoPageLayout.createIpfCcmBoPageLayout&v=1.0&format=json",$(detailstr),730);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformIpfCcmBoPageLayoutManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformIpfCcmBoPageLayoutManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformIpfCcmBoPageLayoutManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=ipfCcmBoPageLayout.deleteIpfCcmBoPageLayout&v=1.0&format=json",
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
                        detailstr+="<label id='lipfCcmBoPageId' align='right'>页面：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='ipfCcmBoPageId' name='页面' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutType' align='right'>页面布局类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutType' name='页面布局类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutContainerType' align='right'>页面布局容器类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutContainerType' name='页面布局容器类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llayoutBoName' align='right'>页面布局业务对象名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='layoutBoName' name='页面布局业务对象名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstyleClass' align='right'>样式名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='styleClass' name='样式名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lstyle' align='right'>样式：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='style' name='样式' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lformType' align='right'>表单类型：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='formType' name='表单类型' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lelementName' align='right'>布局元素名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='elementName' name='布局元素名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lheight' align='right'>栅格高度：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='height' name='栅格高度' style='...'/>";
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
                        detailstr+="<label id='lgroupMsgCode' align='right'>分组标题系统消息代码：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupMsgCode' name='分组标题系统消息代码' style='...'/>";
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
                        detailstr+="<label id='lisParent' align='right'>是否父栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='isParent' name='是否父栅格' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lchildrenLineCount' align='right'>子栅格行数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='childrenLineCount' name='子栅格行数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcellName' align='right'>栅格名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='cellName' name='栅格名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lrowNo' align='right'>行号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='rowNo' name='行号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcolumnNo' align='right'>列号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='columnNo' name='列号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='llabelUnitCount' align='right'>标签占栅格数：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='labelUnitCount' name='标签占栅格数' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lseqNo' align='right'>序号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='seqNo' name='序号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcontrolConnector' align='right'>连接符号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='controlConnector' name='连接符号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lparentCellName' align='right'>父栅格：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='parentCellName' name='父栅格' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=ipfCcmBoPageLayout.selectIpfCcmBoPageLayout&v=1.0&format=json",$(detailstr),730);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=ipfCcmBoPageLayout.selectIpfCcmBoPageLayout&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },ipfCcmBoPageId: { type: "string" },layoutType: { type: "string" },layoutContainerType: { type: "string" },layoutBoName: { type: "string" },styleClass: { type: "string" },style: { type: "string" },formType: { type: "string" },elementName: { type: "string" },height: { type: "string" },isShowGroup: { type: "string" },groupWidget: { type: "string" },groupMsgCode: { type: "string" },groupTitle: { type: "string" },unitCount: { type: "string" },isParent: { type: "string" },childrenLineCount: { type: "string" },cellName: { type: "string" },rowNo: { type: "string" },columnNo: { type: "string" },labelUnitCount: { type: "string" },seqNo: { type: "string" },controlConnector: { type: "string" },parentCellName: { type: "string" }
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
                            result = platformIpfCcmBoPageLayoutManageListView.appendColValue(result);
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
                    		{field: "ipfCcmBoPageId", title:"页面", align:"center", width: "100px"},
                    		{field: "layoutType", title:"页面布局类型", align:"center", width: "100px"},
                    		{field: "layoutContainerType", title:"页面布局容器类型", align:"center", width: "100px"},
                    		{field: "layoutBoName", title:"页面布局业务对象名称", align:"center", width: "100px"},
                    		{field: "styleClass", title:"样式名称", align:"center", width: "100px"},
                    		{field: "style", title:"样式", align:"center", width: "100px"},
                    		{field: "formType", title:"表单类型", align:"center", width: "100px"},
                    		{field: "elementName", title:"布局元素名称", align:"center", width: "100px"},
                    		{field: "height", title:"栅格高度", align:"center", width: "100px"},
                    		{field: "isShowGroup", title:"显示分组", align:"center", width: "100px"},
                    		{field: "groupWidget", title:"分组控件", align:"center", width: "100px"},
                    		{field: "groupMsgCode", title:"分组标题系统消息代码", align:"center", width: "100px"},
                    		{field: "groupTitle", title:"分组标题", align:"center", width: "100px"},
                    		{field: "unitCount", title:"包含栅格数", align:"center", width: "100px"},
                    		{field: "isParent", title:"是否父栅格", align:"center", width: "100px"},
                    		{field: "childrenLineCount", title:"子栅格行数", align:"center", width: "100px"},
                    		{field: "cellName", title:"栅格名称", align:"center", width: "100px"},
                    		{field: "rowNo", title:"行号", align:"center", width: "100px"},
                    		{field: "columnNo", title:"列号", align:"center", width: "100px"},
                    		{field: "labelUnitCount", title:"标签占栅格数", align:"center", width: "100px"},
                    		{field: "seqNo", title:"序号", align:"center", width: "100px"},
                    		{field: "controlConnector", title:"连接符号", align:"center", width: "100px"},
                    		{field: "parentCellName", title:"父栅格", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformIpfCcmBoPageLayoutManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformIpfCcmBoPageLayoutManageListView.get("columns");
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
                                detailstr+="<label id='lipfCcmBoPageId' align='right'>页面：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='ipfCcmBoPageId' name='页面' value='"+ColumnValue["ipfCcmBoPageId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llayoutType' align='right'>页面布局类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='layoutType' name='页面布局类型' value='"+ColumnValue["layoutType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llayoutContainerType' align='right'>页面布局容器类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='layoutContainerType' name='页面布局容器类型' value='"+ColumnValue["layoutContainerType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llayoutBoName' align='right'>页面布局业务对象名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='layoutBoName' name='页面布局业务对象名称' value='"+ColumnValue["layoutBoName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lstyleClass' align='right'>样式名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='styleClass' name='样式名称' value='"+ColumnValue["styleClass"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lstyle' align='right'>样式：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='style' name='样式' value='"+ColumnValue["style"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lformType' align='right'>表单类型：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='formType' name='表单类型' value='"+ColumnValue["formType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lelementName' align='right'>布局元素名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='elementName' name='布局元素名称' value='"+ColumnValue["elementName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lheight' align='right'>栅格高度：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='height' name='栅格高度' value='"+ColumnValue["height"]+"' style='...'/>";
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
                                detailstr+="<label id='lgroupMsgCode' align='right'>分组标题系统消息代码：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='groupMsgCode' name='分组标题系统消息代码' value='"+ColumnValue["groupMsgCode"]+"' style='...'/>";
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
                                detailstr+="<label id='lisParent' align='right'>是否父栅格：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='isParent' name='是否父栅格' value='"+ColumnValue["isParent"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lchildrenLineCount' align='right'>子栅格行数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='childrenLineCount' name='子栅格行数' value='"+ColumnValue["childrenLineCount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcellName' align='right'>栅格名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='cellName' name='栅格名称' value='"+ColumnValue["cellName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lrowNo' align='right'>行号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='rowNo' name='行号' value='"+ColumnValue["rowNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcolumnNo' align='right'>列号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='columnNo' name='列号' value='"+ColumnValue["columnNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='llabelUnitCount' align='right'>标签占栅格数：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='labelUnitCount' name='标签占栅格数' value='"+ColumnValue["labelUnitCount"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lseqNo' align='right'>序号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='seqNo' name='序号' value='"+ColumnValue["seqNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcontrolConnector' align='right'>连接符号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='controlConnector' name='连接符号' value='"+ColumnValue["controlConnector"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lparentCellName' align='right'>父栅格：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='parentCellName' name='父栅格' value='"+ColumnValue["parentCellName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=ipfCcmBoPageLayout.updateIpfCcmBoPageLayout&v=1.0&format=json", $(detailstr),730);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformIpfCcmBoPageLayoutManageListView);
        }
    });

    return PlatformIpfCcmBoPageLayoutManageRouter;
});

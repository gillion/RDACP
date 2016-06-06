
/**
 * 员工客户关联金额明细
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
	
    
    function showEditDetilDialog(tp, titles, id, url, content){
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 350, 190, titles);
    	
        
        if (tp==1){
        $("#submitBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),conNo: $("#conNo").val(),conType: $("#conType").val(),conDate: $("#conDate").val(),traceMoney: $("#traceMoney").val(),conCorpName: $("#conCorpName").val(),conLoginid: $("#conLoginid").val(),updateUser: $("#updateUser").val(),updateDate: $("#updateDate").val(),updateOrgCd: $("#updateOrgCd").val(),soperCd: $("#soperCd").val()},
                    dataType: 'json',
                    complete: function(transport){
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("操作成功！");
                        kendoUIWindow.close();
                        var table0=$("#simplelist_list").data("kendoGrid");
                        table0.dataSource.read();
                        table0.refresh();
                    }
                }
            );
        });
    	} else{
        $("#QueryBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,
                    data:{id: $("#id").val(),conNo: $("#conNo").val(),conType: $("#conType").val(),conDate: $("#conDate").val(),traceMoney: $("#traceMoney").val(),conCorpName: $("#conCorpName").val(),conLoginid: $("#conLoginid").val(),updateUser: $("#updateUser").val(),updateDate: $("#updateDate").val(),updateOrgCd: $("#updateOrgCd").val(),soperCd: $("#soperCd").val()},
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
                        kendoUIWindow.close();
                    }
                }
            );
        });
    	}
        SimpleListUtil.setDataTimeCn();

        
    }
    
    var PlatformPerConMoneyDetailManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_PerConMoneyDetail_manage": "showPlatformPerConMoneyDetailManageList",  
            "basic_manage/platform_ckPerConMoneyDetail_manage": "showPlatformckPerConMoneyDetailManageList"
        },
        showPlatformckPerConMoneyDetailManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformPerConMoneyDetailManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformPerConMoneyDetailManageListView = new SimpleListView({
                id: "platform_perConMoneyDetail_manage_list",
                title: "基础管理 > 员工客户关联金额明细",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("员工客户关联金额明细");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";                       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconNo' align='right'>关联号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conNo' name='关联号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconType' align='right'>关联类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conType' name='关联类型' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconDate' align='right'>关联日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conDate' name='关联日期' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltraceMoney' align='right'>关联金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='traceMoney' name='关联金额' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconCorpName' align='right'>公司名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conCorpName' name='公司名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconLoginid' align='right'>客户经理：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conLoginid' name='客户经理' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lupdateUser' align='right'>操作人：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='updateUser' name='操作人' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lupdateDate' align='right'>操作时间：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='updateDate' name='操作时间' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lupdateOrgCd' align='right'>操作机构：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='updateOrgCd' name='操作机构' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsoperCd' align='right'>操作代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='soperCd' name='操作代码' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyDetail.createPerConMoneyDetail&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformPerConMoneyDetailManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformPerConMoneyDetailManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformPerConMoneyDetailManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyDetail.deletePerConMoneyDetail&v=1.0&format=json",
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
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconNo' align='right'>关联号：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conNo' name='关联号' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconType' align='right'>关联类型：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conType' name='关联类型' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconDate' align='right'>关联日期：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conDate' name='关联日期' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltraceMoney' align='right'>关联金额：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='traceMoney' name='关联金额' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconCorpName' align='right'>公司名称：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conCorpName' name='公司名称' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lconLoginid' align='right'>客户经理：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='conLoginid' name='客户经理' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lupdateUser' align='right'>操作人：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='updateUser' name='操作人' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lupdateDate' align='right'>操作时间：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='updateDate' name='操作时间' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lupdateOrgCd' align='right'>操作机构：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='updateOrgCd' name='操作机构' style='...'/>";
                        detailstr+="</td></tr>";
                        

                        detailstr+="<tr><td>";
                        detailstr+="<label id='lsoperCd' align='right'>操作代码：</label>";
                        detailstr+="</td><td>";

						
                		detailstr+="<input id='soperCd' name='操作代码' style='...'/>";
                        detailstr+="</td></tr>";
                        
                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyDetail.selectPerConMoneyDetail&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    });
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyDetail.selectPerConMoneyDetail&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },conNo: { type: "string" },conType: { type: "string" },conDate: { type: "string" },traceMoney: { type: "string" },conCorpName: { type: "string" },conLoginid: { type: "string" },updateUser: { type: "string" },updateDate: { type: "string" },updateOrgCd: { type: "string" },soperCd: { type: "string" }
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
                            result = platformPerConMoneyDetailManageListView.appendColValue(result);
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
                          {field: "id", title:"编号", hidden:"true", align:"center", width: "100px"},

    						
                    		{field: "conNo", title:"关联号", align:"center", width: "100px"},

    						
                    		{field: "conType", title:"关联类型", align:"center", width: "100px"},

    						
                    		{field: "conDate", title:"关联日期", align:"center", width: "100px"},

    						
                    		{field: "traceMoney", title:"关联金额", align:"center", width: "100px"},

    						
                    		{field: "conCorpName", title:"公司名称", align:"center", width: "100px"},

    						
                    		{field: "conLoginid", title:"客户经理", align:"center", width: "100px"},

    						
                    		{field: "updateUser", title:"操作人", align:"center", width: "100px"},

    						
                    		{field: "updateDate", title:"操作时间", align:"center", width: "100px"},

    						
                    		{field: "updateOrgCd", title:"操作机构", align:"center", width: "100px"},

    						
                    		{field: "soperCd", title:"操作代码", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformPerConMoneyDetailManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformPerConMoneyDetailManageListView.get("columns");
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
                                detailstr+="<input id='id' name='编号' hidden='true' value='"+ColumnValue["id"]+"' style='...'/>";

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconNo' align='right'>关联号：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='conNo' name='关联号' value='"+ColumnValue["conNo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconType' align='right'>关联类型：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='conType' name='关联类型' value='"+ColumnValue["conType"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconDate' align='right'>关联日期：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='conDate' name='关联日期' value='"+ColumnValue["conDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltraceMoney' align='right'>关联金额：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='traceMoney' name='关联金额' value='"+ColumnValue["traceMoney"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconCorpName' align='right'>公司名称：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='conCorpName' name='公司名称' value='"+ColumnValue["conCorpName"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lconLoginid' align='right'>客户经理：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='conLoginid' name='客户经理' value='"+ColumnValue["conLoginid"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lupdateUser' align='right'>操作人：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='updateUser' name='操作人' value='"+ColumnValue["updateUser"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lupdateDate' align='right'>操作时间：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='updateDate' name='操作时间' value='"+ColumnValue["updateDate"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lupdateOrgCd' align='right'>操作机构：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='updateOrgCd' name='操作机构' value='"+ColumnValue["updateOrgCd"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lsoperCd' align='right'>操作代码：</label>";
                                detailstr+="</td><td>";

        						
                        		detailstr+="<input id='soperCd' name='操作代码' value='"+ColumnValue["soperCd"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"http://liuxibin.vicp.cc:8088/router?appKey=000001&method=perConMoneyDetail.updatePerConMoneyDetail&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformPerConMoneyDetailManageListView);
        }
    });

    return PlatformPerConMoneyDetailManageRouter;
});

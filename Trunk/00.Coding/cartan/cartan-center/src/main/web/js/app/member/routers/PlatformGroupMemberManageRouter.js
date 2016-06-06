
/**
 * GroupMember
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
                    data:{id: $("#id").val(),user: $("#user").val(),groupInfoId: $("#groupInfoId").val(),area: $("#area").val(),name: $("#name").val(),tel: $("#tel").val(),unit: $("#unit").val(),addr: $("#addr").val()},
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
                    data:{id: $("#id").val(),user: $("#user").val(),groupInfoId: $("#groupInfoId").val(),area: $("#area").val(),name: $("#name").val(),tel: $("#tel").val(),unit: $("#unit").val(),addr: $("#addr").val()},
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
    
    var PlatformGroupMemberManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_GroupMember_manage": "showPlatformGroupMemberManageList",  
            "basic_manage/platform_ckGroupMember_manage": "showPlatformckGroupMemberManageList"
        },
        showPlatformckGroupMemberManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformGroupMemberManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformGroupMemberManageListView = new SimpleListView({
                id: "platform_groupMember_manage_list",
                title: "基础管理 > GroupMember",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("GroupMember");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luser' align='right'>账号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='user' name='账号' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupInfoId' align='right'>团体：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupInfoId' name='团体' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='larea' align='right'>地区：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='area' name='地区' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>姓名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='name' name='姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltel' align='right'>电话：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tel' name='电话' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lunit' align='right'>单位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='unit' name='单位' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laddr' align='right'>住址：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='addr' name='住址' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=groupMember.createGroupMember&v=1.0&format=json",$(detailstr),250);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformGroupMemberManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformGroupMemberManageListView.getGridObject().select().get(i);
                            var id = SimpleListUtil.getColumnValue(platformGroupMemberManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=groupMember.deleteGroupMember&v=1.0&format=json",
                            {
                                async: false,
                                data:{id: id},
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
                        detailstr+="<label id='luser' align='right'>账号：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='user' name='账号' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lgroupInfoId' align='right'>团体：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='groupInfoId' name='团体' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='larea' align='right'>地区：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='area' name='地区' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>姓名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='name' name='姓名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltel' align='right'>电话：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='tel' name='电话' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lunit' align='right'>单位：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='unit' name='单位' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='laddr' align='right'>住址：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='addr' name='住址' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=groupMember.selectGroupMember&v=1.0&format=json",$(detailstr),250);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=groupMember.selectGroupMember&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },user: { type: "string" },groupInfoId: { type: "string" },area: { type: "string" },name: { type: "string" },tel: { type: "string" },unit: { type: "string" },addr: { type: "string" }
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
                            result = platformGroupMemberManageListView.appendColValue(result);
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
                          {field: "chk", type:"chk", title: "&nbsp;", value:"id"},
                          {field: "id", title:"编号", hidden:"true", align:"center", width: "100px"},
                    		{field: "user", title:"账号", align:"center", width: "100px"},
                    		{field: "groupInfoId", title:"团体", align:"center", width: "100px"},
                    		{field: "area", title:"地区", align:"center", width: "100px"},
                    		{field: "name", title:"姓名", align:"center", width: "100px"},
                    		{field: "tel", title:"电话", align:"center", width: "100px"},
                    		{field: "unit", title:"单位", align:"center", width: "100px"},
                    		{field: "addr", title:"住址", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformGroupMemberManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformGroupMemberManageListView.get("columns");
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
                                detailstr+="<label id='luser' align='right'>账号：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='user' name='账号' value='"+ColumnValue["user"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lgroupInfoId' align='right'>团体：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='groupInfoId' name='团体' value='"+ColumnValue["groupInfoId"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='larea' align='right'>地区：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='area' name='地区' value='"+ColumnValue["area"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lname' align='right'>姓名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='name' name='姓名' value='"+ColumnValue["name"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ltel' align='right'>电话：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='tel' name='电话' value='"+ColumnValue["tel"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lunit' align='right'>单位：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='unit' name='单位' value='"+ColumnValue["unit"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='laddr' align='right'>住址：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='addr' name='住址' value='"+ColumnValue["addr"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=groupMember.updateGroupMember&v=1.0&format=json", $(detailstr),250);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformGroupMemberManageListView);
        }
    });

    return PlatformGroupMemberManageRouter;
});

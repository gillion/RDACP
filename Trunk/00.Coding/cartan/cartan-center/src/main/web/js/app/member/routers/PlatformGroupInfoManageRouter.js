
/**
 * GroupInfo
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
        
        var typeModel = kendo.observable({
            isChecked:  $("*[name='type']").attr("curdata")
        });
        kendo.bind($("*[name='type']"), typeModel);        
    	
        
        

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),type:typeModel.isChecked,name: $("#name").val(),createtime: $("#createtime").val(),creator: $("#creator").val(),memoinfo: $("#memoinfo").val()},
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
                    data:{id: $("#id").val(),type:typeModel.isChecked,name: $("#name").val(),createtime: $("#createtime").val(),creator: $("#creator").val(),memoinfo: $("#memoinfo").val()},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];

        						
                        		data["typeName"] = SimpleListUtil.getSelectDes("110", data["type"]);
        						
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

        if (tp==1){
        	$("#createtime").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss", value:new Date()});
        } else {
        	$("#createtime").kendoDateTimePicker({culture:"zh-CN",format:"yyyy-MM-dd HH:mm:ss"});
        }
        
    }
    
    var PlatformGroupInfoManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_GroupInfo_manage": "showPlatformGroupInfoManageList",  
            "basic_manage/platform_ckGroupInfo_manage": "showPlatformckGroupInfoManageList"
        },
        showPlatformckGroupInfoManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformGroupInfoManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformGroupInfoManageListView = new SimpleListView({
                id: "platform_groupInfo_manage_list",
                title: "基础管理 > GroupInfo",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("GroupInfo");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ltype' align='right'>类别：</label>";
                        detailstr+="</td><td>";
                        detailstr+= SimpleListUtil.getRadioCode("110", "type", "");
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='name' name='名称' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreatetime' align='right'>创建时间：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='createtime' name='创建时间' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreator' align='right'>创建成员：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='creator' name='创建成员' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmemoinfo' align='right'>说明：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='memoinfo' name='说明' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=groupInfo.createGroupInfo&v=1.0&format=json",$(detailstr),190);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformGroupInfoManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformGroupInfoManageListView.getGridObject().select().get(i);
                            var id = SimpleListUtil.getColumnValue(platformGroupInfoManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=groupInfo.deleteGroupInfo&v=1.0&format=json",
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
                        detailstr+="<label id='ltype' align='right'>类别：</label>";
                        detailstr+="</td><td>";
                        detailstr+= SimpleListUtil.getRadioCode("110", "type", "");
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='name' name='名称' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreatetime' align='right'>创建时间：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='createtime' name='创建时间' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lcreator' align='right'>创建成员：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='creator' name='创建成员' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lmemoinfo' align='right'>说明：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='memoinfo' name='说明' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=groupInfo.selectGroupInfo&v=1.0&format=json",$(detailstr),190);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=groupInfo.selectGroupInfo&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },type: { type: "string" },name: { type: "string" },createtime: { type: "string" },creator: { type: "string" },memoinfo: { type: "string" }
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
                            		data["typeName"] = SimpleListUtil.getSelectDes("110", data["type"]);
                                }
                            }
                            result = platformGroupInfoManageListView.appendColValue(result);
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
                    		{field: "type", title:"类别", hidden:"true", align:"center", width: "100px"},
                    		{field: "typeName", title:"类别", align:"center", width: "100px"},
                    		{field: "name", title:"名称", align:"center", width: "100px"},
                    		{field: "createtime", title:"创建时间", align:"center", width: "100px"},
                    		{field: "creator", title:"创建成员", align:"center", width: "100px"},
                    		{field: "memoinfo", title:"说明", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformGroupInfoManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformGroupInfoManageListView.get("columns");
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
                                detailstr+="<label id='ltype' align='right'>类别：</label>";
                                detailstr+="</td><td>";
          						
        						
                                detailstr+= SimpleListUtil.getRadioCode("110", "type", ColumnValue["type"]);
        						
        						
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lname' align='right'>名称：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='name' name='名称' value='"+ColumnValue["name"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreatetime' align='right'>创建时间：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='createtime' name='创建时间' value='"+ColumnValue["createtime"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lcreator' align='right'>创建成员：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='creator' name='创建成员' value='"+ColumnValue["creator"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lmemoinfo' align='right'>说明：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='memoinfo' name='说明' value='"+ColumnValue["memoinfo"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=groupInfo.updateGroupInfo&v=1.0&format=json", $(detailstr),190);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformGroupInfoManageListView);
        }
    });

    return PlatformGroupInfoManageRouter;
});

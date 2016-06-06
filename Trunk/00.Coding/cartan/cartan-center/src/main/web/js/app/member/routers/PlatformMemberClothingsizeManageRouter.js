
/**
 * MemberClothingsize
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
        
        var clothingSizeModel = kendo.observable({
            isChecked:  $("*[name='clothingSize']").attr("curdata")
        });
        kendo.bind($("*[name='clothingSize']"), clothingSizeModel);        
    	
        
        

        if (tp==1){
        $("#submitBtn").click(function(){    	
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{id: $("#id").val(),name: $("#name").val(),depart: $("#depart").val(),height: $("#height").val(),weight: $("#weight").val(),clothingSize:clothingSizeModel.isChecked},
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
                    data:{id: $("#id").val(),name: $("#name").val(),depart: $("#depart").val(),height: $("#height").val(),weight: $("#weight").val(),clothingSize:clothingSizeModel.isChecked},
                    dataType: 'json',
                    complete: function(transport){
                        var result = transport.responseText;
                        result = $.parseJSON(result);


                        if($.isArray(result.resultJson)){
                            var data = null;
                            for(var i= 0, count=result.resultJson.length; i<count; i++){
                                data = result.resultJson[i];

        						
                        		data["clothingSizeName"] = SimpleListUtil.getSelectDes("102", data["clothingSize"]);
        						
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
    
    var PlatformMemberClothingsizeManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_MemberClothingsize_manage": "showPlatformMemberClothingsizeManageList",  
            "basic_manage/platform_ckMemberClothingsize_manage": "showPlatformckMemberClothingsizeManageList"
        },
        showPlatformckMemberClothingsizeManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformMemberClothingsizeManageList: function(){
            //var sid=SimpleListUtil.getSessionId();
            //SimpleListUtil.ckSession(sid);            
            var platformMemberClothingsizeManageListView = new SimpleListView({
                id: "platform_memberClothingsize_manage_list",
                title: "基础管理 > MemberClothingsize",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("MemberClothingsize");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";       
                        detailstr+="<input id='id' name='编号' hidden='true' style='...'/>";                          
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lname' align='right'>姓名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='name' name='姓名' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldepart' align='right'>部门：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='depart' name='部门' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lheight' align='right'>身高：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='height' name='身高' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lweight' align='right'>体重：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='weight' name='体重' style='...'/>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclothingSize' align='right'>尺码：</label>";
                        detailstr+="</td><td>";
                        detailstr+= SimpleListUtil.getRadioCode("102", "clothingSize", "");
                        detailstr+="</td></tr>";
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=memberClothingsize.createMemberClothingsize&v=1.0&format=json",$(detailstr),190);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformMemberClothingsizeManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformMemberClothingsizeManageListView.getGridObject().select().get(i);
                            var id = SimpleListUtil.getColumnValue(platformMemberClothingsizeManageListView.getGridObject(),rowEl, "id");
                            new AjaxEngine("router?appKey=000001&method=memberClothingsize.deleteMemberClothingsize&v=1.0&format=json",
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
                        detailstr+="<label id='lname' align='right'>姓名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='name' name='姓名' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='ldepart' align='right'>部门：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='depart' name='部门' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lheight' align='right'>身高：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='height' name='身高' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lweight' align='right'>体重：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='weight' name='体重' style='...'/>";
                        detailstr+="</td></tr>";                        
                        detailstr+="<tr><td>";
                        detailstr+="<label id='lclothingSize' align='right'>尺码：</label>";
                        detailstr+="</td><td>";
                        detailstr+= SimpleListUtil.getRadioCode("102", "clothingSize", "");
                        detailstr+="</td></tr>";                        
                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=memberClothingsize.selectMemberClothingsize&v=1.0&format=json",$(detailstr),190);
                        dialogId = null;
                    }, "filter");
                },

                dataSource: {
                    serverPaging: false,
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=memberClothingsize.selectMemberClothingsize&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },name: { type: "string" },depart: { type: "string" },height: { type: "string" },weight: { type: "string" },clothingSize: { type: "string" }
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
                            		data["clothingSizeName"] = SimpleListUtil.getSelectDes("102", data["clothingSize"]);
                                }
                            }
                            result = platformMemberClothingsizeManageListView.appendColValue(result);
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
                    		{field: "name", title:"姓名", align:"center", width: "100px"},
                    		{field: "depart", title:"部门", align:"center", width: "100px"},
                    		{field: "height", title:"身高", align:"center", width: "100px"},
                    		{field: "weight", title:"体重", align:"center", width: "100px"},
                    		{field: "clothingSize", title:"尺码", hidden:"true", align:"center", width: "100px"},
                    		{field: "clothingSizeName", title:"尺码", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformMemberClothingsizeManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformMemberClothingsizeManageListView.get("columns");
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
                                detailstr+="<label id='lname' align='right'>姓名：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='name' name='姓名' value='"+ColumnValue["name"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='ldepart' align='right'>部门：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='depart' name='部门' value='"+ColumnValue["depart"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lheight' align='right'>身高：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='height' name='身高' value='"+ColumnValue["height"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lweight' align='right'>体重：</label>";
                                detailstr+="</td><td>";
          						
        						
        						
        						
                        		detailstr+="<input id='weight' name='体重' value='"+ColumnValue["weight"]+"' style='...'/>";
                                detailstr+="</td></tr>";
                                

                                detailstr+="<tr><td>";
                                detailstr+="<label id='lclothingSize' align='right'>尺码：</label>";
                                detailstr+="</td><td>";
          						
        						
                                detailstr+= SimpleListUtil.getRadioCode("102", "clothingSize", ColumnValue["clothingSize"]);
        						
        						
                                detailstr+="</td></tr>";
                                
				                detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=memberClothingsize.updateMemberClothingsize&v=1.0&format=json", $(detailstr),190);
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformMemberClothingsizeManageListView);
        }
    });

    return PlatformMemberClothingsizeManageRouter;
});

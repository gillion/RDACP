

/**
 * Codegener
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
    	var kendoUIWindow = SimpleListUtil.showkdDialog(id, content, 380, height, titles);

        var statusModel = kendo.observable({
            isChecked:  $("*[name='status']").attr("curdata")
        });
        kendo.bind($("*[name='status']"), statusModel);

        if (tp==1){
        $("#submitBtn").click(function(){
        var sid=SimpleListUtil.getSessionId();
        $("#submitBtn").attr("disabled", true);
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{sessionId: sid,id: $("#id").val(),setupName: $("#setupName").val(),basePackage: $("#basePackage").val(),moduleName: $("#moduleName").val(),root: $("#root").val(),sysname: $("#sysname").val(),status: statusModel.isChecked},
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
                    data:{id: $("#id").val(),setupName: $("#setupName").val(),basePackage: $("#basePackage").val(),moduleName: $("#moduleName").val(),root: $("#root").val(),sysname: $("#sysname").val(),status: $("#status").val(),lockMan: $("#lockMan").val(),lockTime: $("#lockTime").val()},
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
    
    var PlatformCodegenerManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_Codegener_manage": "showPlatformCodegenerManageList",  
            "basic_manage/platform_ckCodegener_manage": "showPlatformckCodegenerManageList"
        },
        showPlatformckCodegenerManageList: function(){
            $("#Submit").click(function(){
                var sid=SimpleListUtil.getSessionId();
                if (SimpleListUtil.cklogin(sid)=="1"){
                	SimpleListUtil.addSession(sid);
                } else {
                	SimpleListUtil.removeSession(sid);
                }
            });
        },
        showPlatformCodegenerManageList: function(){
            var sid=SimpleListUtil.getSessionId();
            var userid=SimpleListUtil.getUserId(sid);

            var platformCodegenerManageListView = new SimpleListView({
                id: "platform_codegener_manage_list",
                title: "基础数据 > 基本配置",
                buttonCount:7,
                
                ready: function(){
                    this.setSimpleListHeader("基本配置");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";  
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsetupName' align='right'>配置名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='setupName' name='配置名称' style='...'/>";
                        detailstr+="</td>";                        
                        detailstr+="</tr>";


                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lbasePackage' align='right'>基础包：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<input id='basePackage' name='基础包' style='...'/>";
                        detailstr+="</td>";
                        detailstr+="</tr>";

                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lmoduleName' align='right'>模块名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='moduleName' name='模块名称' style='...'/>";
                        detailstr+="</td>";
                        detailstr+="</tr>";


                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lroot' align='right'>根目录：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<input id='root' name='根目录' style='...'/>";
                        detailstr+="</td>";
                        detailstr+="</tr>";


                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsysname' align='right'>系统名称：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<input id='sysname' name='系统名称' style='...'/>";
                        detailstr+="</td>";
                        detailstr+="</tr>";


                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</div>";
                        showEditDetilDialog(1,"新增","0" ,"router?appKey=000001&method=codegener.createCodegener&v=1.0&format=json",$(detailstr),180);
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformCodegenerManageListView.getGridObject().select().length;
                        if (rowCount>0){
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformCodegenerManageListView.getGridObject().select().get(i);
                            var ID = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "id");

                            var status = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "status");
                            if (status=="101"){
                            new AjaxEngine("router?appKey=000001&method=codegener.deleteCodegener&v=1.0&format=json",
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
                            } else {
                                alert("配置已锁定！");
                            }
                        }
                        if (status=="101"){
                            alert("删除成功！");
                            var table0=$("#simplelist_list").data("kendoGrid");
                            table0.dataSource.read();
                            table0.refresh();
                        }
                        } else {
                            alert("请先选择记录！");
                        }
                    }, "delete");
                    this.addToolbarBtn("queryBtn", "查 询", function(){
                        var detailstr="";
                        detailstr+="<div id='content' align='center'>";
                        detailstr+="<table>";
                        detailstr+="<input id='id' name='主键' hidden='true' style='...'/>";                          
                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsetupName' align='right'>配置名称：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='setupName' name='配置名称' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";

                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lbasePackage' align='right'>基础包：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<input id='basePackage' name='基础包' style='...'/>";
                        detailstr+="</td>";
                        detailstr+="</tr>";

                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lmoduleName' align='right'>模块名：</label>";
                        detailstr+="</td><td>";
                		detailstr+="<input id='moduleName' name='模块名' style='...'/>";
                        detailstr+="</td>";   
                        detailstr+="</tr>";


                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lroot' align='right'>根目录：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<input id='root' name='根目录' style='...'/>";
                        detailstr+="</td>";
                        detailstr+="</tr>";

                        detailstr+="<tr>";
                        detailstr+="<td>";
                        detailstr+="<label id='lsysname' align='right'>系统名称：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<input id='sysname' name='系统名称' style='...'/>";
                        detailstr+="</td>";
                        detailstr+="</tr>";

                        detailstr+="</table>";
                        detailstr+="</div>";
                        detailstr+="<div align='center'>";
                        detailstr+="<input id='QueryBtn'  name='QueryBtn' type='button' value='查 询'  />";
                        detailstr+="</div>";
                        showEditDetilDialog(2,"查询","2" ,"router?appKey=000001&method=codegener.selectCodegener&v=1.0&format=json&sid="+sid+"",$(detailstr),180);
                        dialogId = null;
                    }, "filter");
                    this.addToolbarBtn("tableBtn", "关联模型", function(){
                        var rowCount = platformCodegenerManageListView.getGridObject().select().length;
                        if (rowCount>0){
                            rowEl = platformCodegenerManageListView.getGridObject().select().get(0);
                            var ID = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "id");
                            var NAME = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "setupName");
                            var status = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "status");
                            window.location.href ="ruledesign.html?ID="+ID+"&NAME="+encodeURI(NAME)+"&status="+encodeURI(status)+"#basic_manage/platform_CodegenerTable_manage";
                        } else {
                            alert("请先选择记录！");
                        }
                    }, "createLink");

                    this.addToolbarBtn("roleBtn", "授 权", function(){
                        var rowCount = platformCodegenerManageListView.getGridObject().select().length;
                        if (rowCount>0){
                            rowEl = platformCodegenerManageListView.getGridObject().select().get(0);
                            var ID = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "id");
                            var status = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "status");
                            var lockMan = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "lockMan");

                            // window.location.href ="ruletree.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_RuleTreeOutput_manage";
                            // $.window.showModalDialog("节点定义", "ruletree.html?ID="+ID+"&NAME="+encodeURI(NAME)+"#basic_manage/platform_RuleTree_manage_edit", null, null, null, {top:50, left:50, width:1200});
                            //alert(userid);
                            if ((status=="102")&&(lockMan != userid)){
                                alert("配置已被"+lockMan+"锁定！");
                            } else {
                            var detailstr="";
                            detailstr+="<div id='content' align='center'>";
                            detailstr+="<table>";
                            detailstr+="<input id='id' name='主键' hidden='true'  value='"+ID+"' style='...'/>";
                            detailstr+="<tr><td>";
                            detailstr+="<label id='lstatus' align='right'>状态：</label>";
                            detailstr+="</td><td>";
                            detailstr+= SimpleListUtil.getRadioCode("102", "status", status);
                            detailstr+="</td></tr>";
                            detailstr+="</table>";
                            detailstr+="</div>";
                            detailstr+="<div align='center'>";
                            detailstr+="<input id='submitBtn'  name='QueryBtn' type='button' value='确 定'  />";
                            detailstr+="</div>";
                            var dialogId = "detail_edit_dialog_" + ID;
                            showEditDetilDialog(1,"授权",dialogId,"router?appKey=000001&method=codegener.updateCodegener&v=1.0&format=json", $(detailstr),70);
                            dialogId = null;
                        }
                        } else {
                            alert("请先选择记录！");
                        }
                    }, "edit");

                    this.addToolbarBtn("makePropertyBtn", "生成配置", function(){
                        var rowCount = platformCodegenerManageListView.getGridObject().select().length;
                        if (rowCount>0){
                            for(var i=0; i<rowCount; i++){
                                rowEl = platformCodegenerManageListView.getGridObject().select().get(i);
                                var ID = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "id");

                                var sid=SimpleListUtil.getSessionId();
                                new AjaxEngine("router?appKey=000001&method=codegener.makeProperty&v=1.0&format=json",
                                    {
                                        async: false,
                                        data:{sessionId: sid,id: ID},
                                        dataType: 'json',
                                        complete: function(transport){
                                            result = transport.responseText;
                                            result = $.parseJSON(result);
                                        }
                                    }
                                );
                            }
                            alert("生成配置成功！");
                        } else {
                            alert("请先选择记录！");
                        }


                    }, "edit");

                    this.addToolbarBtn("codeGenerBtn", "生成代码", function(){
                        var rowCount = platformCodegenerManageListView.getGridObject().select().length;
                        if (rowCount>0){
                            for(var i=0; i<rowCount; i++){
                                rowEl = platformCodegenerManageListView.getGridObject().select().get(i);
                                var ID = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "id");

                                var sid=SimpleListUtil.getSessionId();
                                new AjaxEngine("router?appKey=000001&method=codegener.runCodeGener&v=1.0&format=json",
                                    {
                                        async: false,
                                        data:{sessionId: sid,id: ID},
                                        dataType: 'json',
                                        complete: function(transport){
                                            result = transport.responseText;
                                            result = $.parseJSON(result);
                                        }
                                    }
                                );
                            }
                            alert("生成成功！");
                        } else {
                            alert("请先选择记录！");
                        }


                    }, "edit");

                },

                dataSource: {
                    serverPaging: false,
                    pageSize: 20,                     //默认分页是每页10条记录
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=codegener.selectCodegener&v=1.0&format=json&sid="+sid
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                        		id: { type: "string" },setupName: { type: "string" },basePackage: { type: "string" },moduleName: { type: "string" },root: { type: "string" },sysname: { type: "string" },status: { type: "string" },lockMan: { type: "string" },lockTime: { type: "string" }
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
                                    data["statusName"] = SimpleListUtil.getSelectDes("102", data["status"]);
                                }
                            }
                            result = platformCodegenerManageListView.appendColValue(result);
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
                    		{field: "setupName", title:"配置名称", align:"center", width: "100px"},
                            {field: "basePackage", title:"基础包", align:"center", width: "100px"},
                            {field: "moduleName", title:"模块名", align:"center", width: "100px"},
                            {field: "root", title:"根目录", align:"center", width: "100px"},
                            {field: "sysname", title:"系统名称", align:"center", width: "100px"},
                            {field: "status", title:"状态", hidden:"true", align:"center", width: "100px"},
                            {field: "statusName", title:"状态", align:"center", width: "100px"},
                            {field: "lockMan", title:"锁定人", align:"center", width: "100px"},
                            {field: "lockTime", title:"锁定时间", align:"center", width: "100px"},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformCodegenerManageListView.selectRow(rowEl);
                                var Id = SimpleListUtil.getSelectedColumnValue(this, "id");
                                var status = SimpleListUtil.getColumnValue(platformCodegenerManageListView.getGridObject(),rowEl, "status");
                                if (status=="101"){
                                var dialogId = "detail_edit_dialog_" + Id;
                                var columnArray = platformCodegenerManageListView.get("columns");
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
                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lsetupName' align='right'>配置名称：</label>";
                                detailstr+="</td><td>";


                                detailstr+="<input id='setupName' name='配置名称' value='"+ColumnValue["setupName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";


                                    detailstr+="<tr>";
                                    detailstr+="<td>";
                                    detailstr+="<label id='lbasePackage' align='right'>基础包：</label>";
                                    detailstr+="</td><td>";




                                    detailstr+="<input id='basePackage' name='基础包' value='"+ColumnValue["basePackage"]+"' style='...'/>";
                                    detailstr+="</td>";
                                    detailstr+="</tr>";


                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lmoduleName' align='right'>模块名：</label>";
                                detailstr+="</td><td>";



        						
                        		detailstr+="<input id='moduleName' name='模块名' value='"+ColumnValue["moduleName"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";

                                detailstr+="<tr>";
                                detailstr+="<td>";
                                detailstr+="<label id='lroot' align='right'>根目录：</label>";
                                detailstr+="</td><td>";

                                detailstr+="<input id='root' name='根目录' value='"+ColumnValue["root"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="</tr>";

                                    detailstr+="<tr>";
                                    detailstr+="<td>";
                                    detailstr+="<label id='lsysname' align='right'>系统名称：</label>";
                                    detailstr+="</td><td>";




                                    detailstr+="<input id='sysname' name='系统名称' value='"+ColumnValue["sysname"]+"' style='...'/>";
                                    detailstr+="</td>";
                                    detailstr+="</tr>";


                                    detailstr+="</table>";
				                detailstr+="</div>";
				                detailstr+="<div align='center'>";
				                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
				                detailstr+="</div>";
                                showEditDetilDialog(1,"修改",dialogId ,"router?appKey=000001&method=codegener.updateCodegener&v=1.0&format=json", $(detailstr),180);
                                dialogId = null;
                                } else {
                                    alert("配置已锁定！");
                                }
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformCodegenerManageListView);
            SimpleListUtil.ckSession(sid);
        }
    });

    return PlatformCodegenerManageRouter;
});

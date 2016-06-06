
/**
 * 平台系统用户表,保存平台管理员用户,开发人员用户的信息.
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
], function(Class, Log, $, BaseRouter, BaseView, SimpleListView, SimpleListUtil, AjaxEngine){
    function showEditDetilDialog(id, url, content){
        var dialogEl = document.getElementById(id);
        if(dialogEl != null)
            return;
        var documentWindow = $(window);
        var kendoUIWindow = $("<div id='" + id + "'  />").kendoWindow({
            title: "明细",
            width: "650px",
            height: "250px",
            modal: false,
            actions: [
                "Pin",
                "Minimize",
                "Maximize",
                "Close"],
            open: function (e) {
            },
            close: function(e){
                kendoUIWindow.destroy();         //销毁窗口，将窗口相关代码从界面中移除
                kendoUIWindow = null;
            }
        }).data("kendoWindow").content(content);
        $("#submitBtn").click(function(){
            new AjaxEngine(url,
                {
                    async: false,                              
                    data:{userId: $("#userId").val(),userName: $("#userName").val(),password: $("#password").val(),userType: $("#userType").val(),lastLogonTime: $("#lastLogonTime").val(),lastLogonIp: $("#lastLogonIp").val(),status: $("#status").val(),createTime: $("#createTime").val()},
                    dataType: 'json',
                    complete: function(transport){
                        result = transport.responseText;
                        result = $.parseJSON(result);
                        alert("操作成功！");
                        kendoUIWindow.close();
                        location.reload();
                    }
                }
            );
        });
        kendoUIWindow.center().open();
    }
    var PlatformSysUserManageRouter = BaseRouter.extend({
        routes: {
            "basic_manage/platform_sysUser_manage": "showPlatformSysUserManageList"  //基础管理-基础用户管理
        },

        showPlatformSysUserManageList: function(){
            var platformSysUserManageListView = new SimpleListView({
                id: "platform_sysUser_manage_list",
                title: "基础管理 > 平台用户管理",
                buttonCount:3,

                ready: function(){
                    this.setSimpleListHeader("平台用户管理列表");
                    this.addToolbarBtn("addBtn", "新 增", function(){
                        var detailstr="";
                        detailstr+="<div id='content'>";
                        detailstr+="<table>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luserId' align='right'>用户ID：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<input id='userId' name='用户ID' style='...'/>";
                        detailstr+="</td>";
                        detailstr+="<td>";
                        detailstr+="<label id='luserType' align='right'>&nbsp;&nbsp;用户类型：</label>";
                        detailstr+="</td><td>";
                        detailstr+="<select id='userType' name='用户类型'><option value='1'>系统管理员</option><option value='2'>开发者</option></select>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>";
                        detailstr+="<label id='luserName' align='right'>用户名：</label>";
                        detailstr+="</td><td>"
                        detailstr+="<input id='userName' name='用户名' style='...'/>";
                        detailstr+="</td>"
                        detailstr+="<td>"
                        detailstr+="<label id='lstatus' align='right'>&nbsp;&nbsp;用户状态：</label>";
                        detailstr+="</td><td>"
                        detailstr+="<select id='status' name='用户状态'><option value='1'>正常</option><option value='2'>锁定</option></select>";
                        detailstr+="</td></tr>";
                        detailstr+="<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
                        detailstr+="<tr><td></td><td></td>";
                        detailstr+="<td align='center'>";
                        detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                        detailstr+="</td></tr>";
                        detailstr+="</div>";                         
                        showEditDetilDialog("0" ,"router?appKey=000001&method=sysUser.createSysUser&v=1.0&format=json",$(detailstr));
                        dialogId = null;
                    }, "add");
                    this.addToolbarBtn("deleteBtn", "删 除",function(){
                        var rowCount = platformSysUserManageListView.getGridObject().select().length;
                        for(var i=0; i<rowCount; i++){
                            rowEl = platformSysUserManageListView.getGridObject().select().get(i);
                            var userId = SimpleListUtil.getColumnValue(platformSysUserManageListView.getGridObject(),rowEl, "userId");
                        }
                        new AjaxEngine("router?appKey=000001&method=sysUser.deleteSysUser&v=1.0&format=json",
                            {
                                async: false,
                                data:{userId: userId},
                                dataType: 'json',
                                complete: function(transport){
                                    result = transport.responseText;
                                    result = $.parseJSON(result);
                                    alert("删除成功！");
                                    location.reload();
                                }
                            }
                        );
                    }, "delete");
                    this.addMoreQueryConditionBtn();   //添加“高级查询”按钮
                },

                dataSource: {
                    transport: {
                        read: {
                            url: "router?appKey=000001&method=sysUser.selectSysUser&v=1.0&format=json"
                        }
                    },
                    schema: {
                        model: {
                            fields: {
                                userId: { type: "string" },
                                userName: { type: "string" },
                                userType: { type: "string" },
                                status: { type: "string" },
                                lastLogonTime: { type: "string" },
                                lastLogonIp: { type: "string" },
                                createTime: { type: "string" }
                            }
                        },
                        parse: function(response) {
                            return response;
                        },
                        //返回的数据
                        data: function(response) {
                            var result = response["resultJson"];

                            result = platformSysUserManageListView.appendColValue(result);
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
                    {field: "seq", type:"seq", title: "序号", width: "50px"},
                    {field: "chk", type:"chk", title: "&nbsp;", value:"#=userId#"},
                    {field: "userId", hidden:true, title: "", primary: true},
                    {field: "userName", title:"用户名"},
                    {field: "userType", title:"用户类型", width: "100px", align:"center",  values: [{ text: "系统管理员", value: "1" }, { text: "开发者", value: "2" } ]},
                    {field: "status", title:"用户状态", width: "100px", align:"center",  values: [{ text: "正常", value: "1" }, { text: "锁定", value: "2" } ]},
                    {field: "lastLogonTime", title:"最后登录时间", align:"center", width: "200px", template: '#= kendo.toString(kendo.parseDate(lastLogonTime, "yyyyMMddHHmmss"),"yyyy-MM-dd HH:mm:ss") #'},
                    {field: "lastLogonIp", title:"最后登录IP", align:"center", width: "150px"},
                    {field: "createTime", title:"创建时间", align:"center", width: "200px", template: '#= kendo.toString(kendo.parseDate(createTime, "yyyyMMddHHmmss"),"yyyy-MM-dd HH:mm:ss") #'},
                    {
                        width: 100,
                        title: "操作列",
                        align: "center",
                        command: [ {
                            name: "修 改",
                            click: function(e) {
                                var rowEl = SimpleListUtil.getCurrentRow(e.target);
                                platformSysUserManageListView.selectRow(rowEl);
                                var userId = SimpleListUtil.getSelectedColumnValue(this, "userId");
                                var dialogId = "detail_edit_dialog_" + userId;
                                var columnArray = platformSysUserManageListView.get("columns");
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
                                detailstr+="<div id='content'>";
                                detailstr+="<table>";
                                detailstr+="<tr><td>";
                                detailstr+="<label id='luserId' align='right'>用户ID：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<input id='userId' name='用户ID' value='"+ColumnValue["userId"]+"' style='...'/>";
                                detailstr+="</td>";
                                detailstr+="<td>";
                                detailstr+="<label id='luserType' align='right'>&nbsp;&nbsp;用户类型：</label>";
                                detailstr+="</td><td>";
                                detailstr+="<select id='userType' name='用户类型'><option value='1'";
                                if (ColumnValue["userType"]=="1")
                                    detailstr+="selected='selected'";
                                detailstr+=" >系统管理员</option><option value='2'";
                                if (ColumnValue["userType"]=="2")
                                    detailstr+="selected='selected'";
                                detailstr+=">开发者</option></select>";
                                detailstr+="</td></tr>";
                                detailstr+="<tr><td>";
                                detailstr+="<label id='luserName' align='right'>用户名：</label>";
                                detailstr+="</td><td>"
                                detailstr+="<input id='userName' name='用户名' value='"+ColumnValue["userName"]+"' style='...'/>";
                                detailstr+="</td>"
                                detailstr+="<td>"
                                detailstr+="<label id='lstatus' align='right'>&nbsp;&nbsp;用户状态：</label>";
                                detailstr+="</td><td>"
                                detailstr+="<select id='status' name='用户状态'><option value='1'";
                                if (ColumnValue["status"]=="1")
                                    detailstr+="selected='selected'";
                                detailstr+=">正常</option><option value='2'";
                                if (ColumnValue["status"]=="2")
                                    detailstr+="selected='selected'";
                                detailstr+=">锁定</option></select>";
                                detailstr+="</td></tr>";
                                detailstr+="<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
                                detailstr+="<tr><td></td><td></td>";
                                detailstr+="<td align='center'>";
                                detailstr+="<input id='submitBtn'  name='submitBtn' type='button' value='保 存' />";
                                detailstr+="</td></tr>";
                                detailstr+="</div>";
                                showEditDetilDialog(dialogId ,"router?appKey=000001&method=sysUser.updateSysUser&v=1.0&format=json", $(detailstr));
                                dialogId = null;
                            }

                        }]
                    }
                ]
            });

            this.changePage(platformSysUserManageListView);
        }
    });

    return PlatformSysUserManageRouter;
});

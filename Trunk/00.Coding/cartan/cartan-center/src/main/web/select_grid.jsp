<%--
  Created by IntelliJ IDEA.
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">--%>


    <link rel="stylesheet" type="text/css" href="core/js/lib/bootstrap/2.3.2/css/bootstrap.css">
    <%--<link rel="stylesheet" href="core/js/lib/famfamfamicons/css/fam-icons.css" type="text/css" />--%>
    <link rel="stylesheet" type="text/css" href="resources/themes/default/theme.css">
    <link href="core/js/lib/kendoui/kendo.common.min.css" rel="stylesheet">
    <link href="core/js/lib/kendoui/kendo.default.min.css" rel="stylesheet">

    <script src="core/js/lib/jquery/1.9.1/jquery.min.js"></script>
    <script src="core/js/lib/kendoui/kendo.web.min.js"></script>
    <script src="core/js/lib/kendoui/content/people.js"></script>

</head>
<body>
<input id='selid' name='selid' hidden='true'/>";
<div id="grid" style="height: 378px"></div>
<script>
    $(document).ready(function() {
         var detailgrid= $("#grid").kendoGrid({
            dataSource: {
                serverPaging: false,
                transport: {
                    read: {
                        url: "router?appKey=000001&method=groupMember.selectGroupMember&v=1.0&format=json"
                    }
                },
                pageSize: 10,                     //默认分页是每页10条记录
                schema: {
                    model: {
                        fields: {
                            id: { type: "string" },accountno: { type: "string" },groupid: { type: "string" },area: { type: "string" },name: { type: "string" },tel: { type: "string" },unit: { type: "string" },addr: { type: "string" }
                        }
                    },
                    parse: function(response) {
                        return response;
                    },
                    //返回的数据
                    data: function(response) {
                        var result = response["resultJson"];
                       // alert(result);
                        //result = platformGroupMemberManageListView.appendColValue(result);
                        return result;
                    },
                    //记录条数
                    total: function(response) {
                        var result = response["total"] || response["resultJson"].length;
                        return result;
                    }
                }
            },
            selectable: true,
            pageable: {                     //是否支持分页，如果支持，其相关的配置信息
                pageSizes: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
                info: true,
                messages: {
                    empty: "查询无记录！",
                    itemsPerPage: "行每页",
                    display: "共 {2} 条记录"
                }
            },
            columns: [
                {field: "id", title:"编号", hidden:"true", align:"center", width: "50px"},
                {field: "accountno", title:"账号", align:"center", width: "50px"},
                {field: "groupid", title:"团体", align:"center", width: "50px"},
                {field: "area", title:"地区", align:"center", width: "50px"},
                {field: "name", title:"姓名", align:"center", width: "50px"},
                {field: "tel", title:"电话", align:"center", width: "50px"},
                {field: "unit", title:"单位", align:"center", width: "50px"},
                {field: "addr", title:"住址", align:"center", width: "50px"}
            ]
        });
        detailgrid.on('click', '.k-grid-content tr', function () {
            var row = detailgrid.data("kendoGrid").select();
            var data = detailgrid.data("kendoGrid").dataItem(row);
            var Name = data.name;
            if (window.opener != null) {
                window.opener.returnValue = Name ;
            }
            else {
               window.returnValue = Name;
            }
            window.selid.value=Name;
            alert(window.selid.value);
        });


    });
</script>

</body>
</html>
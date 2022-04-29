<#assign className = table.className> <#assign classNameLower =
className?uncap_first> <#assign leftbit = "${">
<#assign rightbit = "}">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>test</title>
<%@include file="/common/inc.jsp"%>
<script src="js/common.js"></script>
<script src="js/Utils.js"></script>
</head>
<body>
	<div>
		<table id="testGrid">
		</table>
	</div>
	<script>
        var TestURL = {
            // queryListGrid: '${leftbit}ctx${rightbit}/customer_info/href/shop_info_shop_center',
            // 用于后台查询整个页面的数据表格URL
            queryListGrid: '${leftbit}ctx${rightbit}/${classNameLower}/findListsByParams',
            // 根据ID查询数据URL
            queryById: '${leftbit}ctx${rightbit}/${classNameLower}/getById',
            // 新增和修改的提交按钮URL
            commit: '${leftbit}ctx${rightbit}/${classNameLower}/update',
            // 新增和修改的弹出窗口URL
            addAndEdit: './${className}Add.jsp',

            addCommit:'${leftbit}ctx${rightbit}/${classNameLower}/save',
            // 用于删除的URL
            deletes: '${leftbit}ctx${rightbit}/${classNameLower}/delete'
        };
        (function($, window) {
            window.Test = {};

            Test.init = function() {
                var _this = this;

                var gridOpts = {
                    url: TestURL.queryListGrid,
                    // method: 'POST',
                    singleSelect: true,
                    toolbar: [{
                        iconCls: 'icon-add',
                        text: '新增',
                        handler: function() {
                            CommonMethods.add('新增', 500, 400, TestURL.addAndEdit);
                        }
                    },'-',{
                        iconCls: 'icon-edit',
                        text: '修改',
                        handler: function() {

                            CommonMethods.edit('修改', 500, 400, TestURL.addAndEdit , $('#testGrid'), 'onloadFun');
                        }
                    },'-',{
                        iconCls: 'icon-remove',
                        text: '删除',
                        handler: function() {
                            CommonMethods.deletes(TestURL.deletes, $('#testGrid'));
                        }
                    }],
                    pagination: true,
                    fitColumns: true,
                    columns: [[
                        <@generateMajorFileld/>
                        {field: 'id',hidden:true, width: 100, align: 'center'}
                    ]]
                };
                //console.log(gridOpts);
                $('#testGrid').datagrid(gridOpts);

                //Utils.createGrid($('#testGrid'), gridOpts);
            }
        })(jQuery, window);
        $(function() {
            Test.init();
        })
    </script>
</body>
</html>
<#macro generateMajorFileld> 
<#list table.columns as column> 
<#assign isComm = 0> 
<#list commonfieldList as prop> 
<#if column.columnNameLower == prop.name> 
<#assign isComm = 1> 
</#if> 
</#list> 
<#if !column.sqlName?starts_with("DEFINE") && !column.pk && isComm == 0 && column.javaType=="String"> 
			{field: '${column.columnName?uncap_first}', title: '${column.columnAlias}', width: 100, align: 'center'}, 
</#if>
</#list> 
</#macro>
 

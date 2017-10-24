<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign leftbit = "${">
<#assign rightbit = "}">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<form id="exportForm" method = "post" style="display:none;"></form>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false,height:'auto'">
        <form class="search" id="${classNameLower}sForm">
            <ul>
                <@generateMajorFileld/>
            </ul>
            <a class="searchButton" data-options="iconCls:'icon-search-orange',plain:true" onclick="PageObject.queryList();">搜索</a>
        </form>
    </div>
    <div data-options="region:'center',border:false">
        <table id="${classNameLower}sGrid"></table>
    </div>
</div>
<div id="${classNameLower}sBtn" class="displayNone clearfix">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add-brown',plain:true" onclick="CommonObject.add('新增', 600, 500, PageObject.url.addDialog);">新增</a>
    <a class="datagrid-btn-separator"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit-brown',plain:true" onclick="CommonObject.edit('编辑', 600, 500, PageObject.url.editDialog, $('#${classNameLower}sGrid'))">编辑</a>
    <a class="datagrid-btn-separator"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-view-brown',plain:true" onclick="CommonObject.view('查看', 600,500, PageObject.url.viewDialog, $('#${classNameLower}sGrid'));">查看</a>
    <a class="datagrid-btn-separator"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-export-brown',plain:true" onclick="CommonObject.exportExel( PageObject.url.exportUrl, PageObject.exportParams, $('#exportForm'));">导出</a>
    <a class="datagrid-btn-separator"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-del-brown',plain:true" onclick="CommonObject.deletes(PageObject.url.deletes, $('#${classNameLower}sGrid'))">删除</a>
</div>
<script type="text/javascript">


    (function($,window,PageObject) {

        // 页面列表初始化方法
        PageObject.init = function () {
            var _self = this;
            _self.url = {

                // 页面表格加载url
                queryListGrid: '${leftbit}ctx${rightbit}/${classNameLower}/findListsByParams',
                // 新增 href
                addDialog: '${leftbit}ctx${rightbit}/${classNameLower}/toSavePage',
                // 新增提交url
                addCommit: '${leftbit}ctx${rightbit}/${classNameLower}/save',
                // 编辑 href 
                editDialog: '${leftbit}ctx${rightbit}/${classNameLower}/toUpdatePage',
                // 编辑提交url
                editCommit:  '${leftbit}ctx${rightbit}/${classNameLower}/update',
                // 编辑 href 
                viewDialog: '${leftbit}ctx${rightbit}/${classNameLower}/toViewPage',
                // 删除 url
                deletes: '${leftbit}ctx${rightbit}/${classNameLower}/deleteIds',
                // 导出Exel url :form表单提交
                exportUrl:'${leftbit}ctx${rightbit}/${classNameLower}/exportPage'
            };

            var params = Utils.getFormObj($('#${classNameLower}sForm'));
            _self.exportParams = params;

            // 创建 datagrid
            var gridOpts = {
                url: PageObject.url.queryListGrid,
                toolbar: '#${classNameLower}sBtn',
                singleSelect: false,
                fitColumns: true,
                ctrlSelect :true,
                columns: [[
                    {field: 'id', hidden: true}
                    <@generateMajorColumnFileld/>
                ]]
            };
            Utils.createGrid($('#${classNameLower}sGrid'), gridOpts, params);

            // Enter键搜索
            Utils.keyEnter.on(0, _self.queryList);
        };

        // 页面列搜索方法
        PageObject.queryList = function () {
            var params = Utils.getFormObj($('#${classNameLower}sForm'));
            PageObject.exportParams = params;
            $("#${classNameLower}sGrid").datagrid("load", params);
        };

    })(jQuery,window,window.PageObject = {});

    $(function () {
        PageObject.init();
    });
</script>


    <#macro generateMajorFileld>
        <#list table.columns as column>
            <#assign isComm = 0>
                <#list commonfieldList as prop>
                    <#if column.columnNameLower == prop.name>
                        <#assign isComm = 1>
                    </#if>
                </#list>
                <#if !column.sqlName?starts_with("DEFINE") && !column.pk && isComm == 0>
                    <li>
                        <label>${column.columnAlias}:</label>
                        <input class="base-input" id="${column.columnName?uncap_first}" name="${column.columnName?uncap_first}" />
                    </li>
                </#if>
        </#list>
    </#macro>
    <#macro generateMajorColumnFileld>
        <#list table.columns as column>
            <#assign isComm = 0>
                <#list commonfieldList as prop>
                    <#if column.columnNameLower == prop.name>
                        <#assign isComm = 1>
                    </#if>
                </#list>
                <#if !column.sqlName?starts_with("DEFINE") && !column.pk && isComm == 0>
                    ,{field: '${column.columnName?uncap_first}', title: '${column.columnAlias} ', width: 100, align: 'center'}
                </#if>
        </#list>
    </#macro>

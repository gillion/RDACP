<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign leftbit = "${">
<#assign rightbit = "}">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp" %>                 .

    <div id="economicDetail" class="formElems">
        <input name="id" value="${leftbit}${classNameLower}.id${rightbit}" type="hidden">
        <ul>
            <@generateMajorFileld/>
        </ul>
    </div>

    <script type="text/javascript">
        (function($,window,DialogObject) {

            DialogObject.init = function (id,row) {

            };

            DialogObject.addCommit = function () {
                var commitData =  Utils.getFormObj($('#economicDetail'));
                if (!$("#economicDetail").form("validate")) {return false;}
                var  url = CommonObject.type == 0 ? PageObject.url.addCommit:PageObject.url.editCommit;
                var $dialog = CommonObject.type == 0 ? $('#addDialog'):$('#editDialog');
                var opts = {
                    method: 'post',
                    url: url,
                    data: commitData,
                    messager: function (data) {
                        if (data) {
                            $("#${classNameLower}sGrid").datagrid("load");
                            $dialog.dialog('close');
                        }
                    },
                    skip: false
                };
                Utils.doAjax(opts);

            };

            DialogObject.editCommit = function () {

                DialogObject.addCommit();

                // 测试
               // $.messager.alert('提示信息', '编辑存储成功！', 'info');
                $('#editDialog').dialog('close');
            };

        })(jQuery,window,window.DialogObject = {});
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
                            <input class="base-input easyui-validatebox"  name="${column.columnName?uncap_first}"  value="${leftbit}${classNameLower}.${column.columnName?uncap_first}${rightbit}" data-options="validType:'length[1,${column.size}]'"/>
                        </li>
                    </#if>
            </#list>
        </#macro>
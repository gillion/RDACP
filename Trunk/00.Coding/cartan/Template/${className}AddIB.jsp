<#assign className = table.className> <#assign classNameLower =
className?uncap_first> <#assign leftbit = "${">
<#assign rightbit = "}">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

<div id="testDetail" class="formElems">
    <input name="id" value="${leftbit}${classNameLower}.id${rightbit}" type="hidden">
    <ul>
        <@generateMajorFileld/>
    </ul>
</div>
<script>
    (function($,window){
        window.DialogForm = {};

        DialogForm.init = function(id) {
            DialogForm.loadDatas(id);
        };

        DialogForm.loadDatas = function(id) {
            
            var url = PageObject.url.viewDialog;
            var opts = {
                url: url,
                type: "POST",
                dataType: 'json',
                data: {
                    id: id
                },
                callback: function(data) {
                    $('[name=id]').val(data.data.id);
                    <@generateMajorFileld1/>
                }
            };
            Utils.doAjax(opts);
        };

        DialogForm.addCommit = function () {
            var commitData =  Utils.getFormObj($('#testDetail'));
            if(!commitData) {
                return false;
            }
            var opts = {
                type: 'post',
                url: TestURL.commit,
                data: commitData,
                callback: function(data) {
                    if(data.status === 1 && data.code === 200) {
                        commitData.id ? $('#editDialog').dialog('close') : $('#addDialog').dialog('close');
                        $('#testGrid').datagrid('reload');
                    }
                },
                skip: false
            };
            //if(validPID() && $('#testDetail').form('enableValidation').form('validate')) {
            //console.info(opts);
                Utils.doAjax(opts);
            //}
        };

        DialogForm.editCommit = function () {
            var commitData =  Utils.getFormObj($('#testDetail'));
            if(!commitData) {
                return false;
            }
            var opts = {
                type: 'post',
                url: TestURL.commitUpdate,
                data: commitData,
                callback: function(data) {
                    if(data.status === 1 && data.code === 200) {
                        commitData.id ? $('#editDialog').dialog('close') : $('#addDialog').dialog('close');
                        $('#testGrid').datagrid('reload');
                    }
                },
                skip: false
            };
            Utils.doAjax(opts);
        };

    })(jQuery,window);
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

<#macro generateMajorFileld1> 
<#list table.columns as column> 
<#assign isComm = 0> 
<#list commonfieldList as prop> 
<#if column.columnNameLower == prop.name> 
<#assign isComm = 1>
</#if> 
</#list> 
<#if !column.sqlName?starts_with("DEFINE") && !column.pk && isComm == 0 && column.javaType=="String">
				$('[name = ${column.columnName?uncap_first}]').attr('value', data.data.${column.columnName?uncap_first});
</#if> 
</#list> 
</#macro>
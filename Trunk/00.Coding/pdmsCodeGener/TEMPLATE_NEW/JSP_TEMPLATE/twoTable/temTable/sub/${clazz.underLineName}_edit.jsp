<#include "common_var.include"/>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="${basepackage}.data.bo.${moduleName}.*" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<%@include file="/common/include_dialogs.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		//校验
		//setEmptyCheck('txtIdName:txtIdCode:txtIdLevel:txtIdSeq');
		//setIntegeCheck('txtIdSeq');
	});
	function doAction(act){
		if(act=='save'){
			submitForm('editFormId');
		}
 	 	else if(act=='close'){$.dialog.close();}
	} 
</script>
</head>
<body>
  <div class="x-toolbar-small">
	<ul class="toolbar-btn_small">
	<s:if test="'ADD' eq func or 'EDIT' eq func ">
	<li><p><a class="icon-add-big" href="#" id="hrQry" onclick="javascript:doAction('save');">保存</a></p></li>
	<li class="toolbar-sprit"></li>
	</s:if>
	<li><p><a class="icon-disable-big" href="#" target="_self" onclick="javascript:doAction('close');">关闭</a></p></li>		
	</ul>
 </div>

 	<div class="contant">
   	<form action="${classNameLower}Action!save.action" id="editFormId" method="post">
		<input type="hidden"  name="operSerialNo" value="<@jspEl "operSerialNo"/>" />
		<input type="hidden"  name="recordId" value="<@jspEl "recordId"/>" />
		<input type="hidden"  name="func" value="<@jspEl "func"/>" />
		<input type="hidden"  name="parentId" value="<@jspEl "parentId"/>" />
		
		<input type="hidden"  name="entity.${mainClazzId}" value="<@jspEl "entity.${mainClazzId}"/>" />
		<fieldset>
		<legend>主信息</legend>
		<#assign porpNo = 0>
		<table class="formTable">
		<#list clazz.properties as prop>
		<#if (prop.name != clazz.pkProperty.name)&&(!prop.name?ends_with("remark"))&&prop.name != "versionNo" && prop.name != "class" && prop.name != "updateUser" && prop.name != "updateTime" && prop.name != "createTime" && prop.name != "createUser">
		<#assign porpNo=porpNo+1><#if (porpNo==1 || (porpNo-1) % 3 ==0)><tr></#if>
		<td class="labelStyle"><label>${prop.cnName}<span>*</span></label></td>
	    <#if prop.asType == 'Date'>	
	    <td>
	    	<input id="eId${prop.name?cap_first}" name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>"  type="text" style="width:120px;" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
	    </td>
	    <#elseif prop.name?ends_with("Id")>
	   	<td>
	    	<input id='qId${prop.name?cap_first}Name' name="conditionMap.${prop.name}Name" value="<@jspEl 'conditionMap.${prop.name}Name'/>" class="inputStyle" type="text" />	
	   		<a id="menuBtn" href="#" onclick="open${prop.name?cap_first}Dialog();">选择</a>
	    	<input id='qId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>" type="hidden"/>	
	   	</td>
	    <#elseif prop.asType =='Number'>
	   	<td>
	    	<input id='eId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>"  class="inputStyle" type="text" />	
	   	</td>
	    <#else>
	   	<td>
	    	<input id='eId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>" class="inputStyle" type="text" />
	    </td>
	    </#if>
	    <#if (porpNo!=1 && porpNo % 3 ==0)></tr></#if>
		</#if>
		<#if (porpNo%3 !=0 && !prop_has_next)></tr></#if>
		</#list>
	
	<#--备注单独一行显示 -->
		<#list clazz.properties as prop>
    	<#if prop.name?ends_with("remark")>
		<tr>
		<td class="labelStyle"><label>${prop.cnName}</label></td>
		<td style="width:320px;" colspan="5">
	   		<textarea id="eId${prop.name?cap_first}" cols="75" rows="5" name="entity.${prop.name}"><@jspEl "entity.${prop.name}"/></textarea>
		</td>
		</tr>	
		</#if>
		</#list>

		</table>
		</fieldset>
	</form>
   	</div>
   	<jsp:include page="/common/show_action_message.jsp" >
 		<jsp:param name="showMessageType" value="DIV" /> 
  	</jsp:include>  
</body>
</html>
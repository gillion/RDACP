<#assign classNameLower = clazz.className?uncap_first>
<#macro jspEl value>${r"${"}${value}}</#macro> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<%@include file="/common/gridheader.jsp" %>

</head>

<script type="text/javascript">
	$(document).ready(function() {
	    setEmptyCheck('<#list inputfieldList as prop><#if prop.checkNull == "1">eId${prop.name?cap_first}:</#if></#list>');
	    setIntegeCheck('<#list inputfieldList as prop><#if prop.checkType =="0">eId${prop.name?cap_first}:</#if></#list>');
	    setMoneyCheck('<#list inputfieldList as prop><#if prop.checkType =="1">eId${prop.name?cap_first}:</#if></#list>');
	    setFloatCheck('<#list inputfieldList as prop><#if prop.checkType =="2">eId${prop.name?cap_first}:</#if></#list>');
	    setMailCheck('<#list inputfieldList as prop><#if prop.checkType =="3">eId${prop.name?cap_first}:</#if></#list>');
	    setZipcodeCheck('<#list inputfieldList as prop><#if prop.checkType =="4">eId${prop.name?cap_first}:</#if></#list>');
	    setMobileCheck('<#list inputfieldList as prop><#if prop.checkType =="5">eId${prop.name?cap_first}:</#if></#list>');
	    setIDCheck('<#list inputfieldList as prop><#if prop.checkType =="6">eId${prop.name?cap_first}:</#if></#list>');
	    setChineseCheck('<#list inputfieldList as prop><#if prop.checkType =="7">eId${prop.name?cap_first}:</#if></#list>');
	    setURLCheck('<#list inputfieldList as prop><#if prop.checkType =="8">eId${prop.name?cap_first}:</#if></#list>');
	    setTell('<#list inputfieldList as prop><#if prop.checkType =="9">eId${prop.name?cap_first}:</#if></#list>');
	    setIP('<#list inputfieldList as prop><#if prop.checkType =="10">eId${prop.name?cap_first}:</#if></#list>');
		//校验//setEmptyCheck('txtIdName:txtIdCode:txtIdLevel:txtIdSeq');//setIntegeCheck('txtIdSeq');
	});
	function doAction(act){
		if(act=='return'){
			location.href='${classNameLower}Action.action';
		}else if(act=='save'){
			$("#editFormId").attr('action','${classNameLower}Action!save.action');
			submitForm('editFormId');
		}else if(act=='close'){
			$.dialog.close();
		}
	}
</script>

<body>
	<div class="topnav"><p>模块 &gt;资源 &gt;资源&gt;${entityCnName} 编辑</p></div>
 	
 	<div class="x-toolbar-small">
	<ul class="toolbar-btn_small">
	<li><p><a class="icon-disable-big" href="#" target="_self" onclick="javascript:doAction('close');">关闭</a></p></li>
	<li class="toolbar-sprit"></li>
	
	<s:if test="'ADD' == func or 'EDIT' == func ">
		<li><p><a class="icon-add-big" href="#" id="hrQry" onclick="javascript:doAction('save');">保存</a></p></li>
	<li class="toolbar-sprit"></li>
	</s:if>
			
	</ul>
 	</div>

 	<div class="contant">
   	<form action="${classNameLower}Action!save.action" id="editFormId" method="post">
		<input type="hidden"  name="recordId" value="<@jspEl "recordId"/>" />
		<input type="hidden"  name="func" value="<@jspEl "func"/>" />
		<input type="hidden"  name="entity.${tableid}" value="<@jspEl "entity.${tableid}"/>" />
		<#list inputfieldList as prop>
    	<#if prop.name = "versionNo">
		<input type="hidden"  name="entity.versionNo" value="<@jspEl "entity.versionNo"/>" />
		</#if>
		</#list>
		<fieldset>
		<legend>主信息</legend>
		<#assign porpNo = 0>
		<table class="formTable">
		<#list inputfieldList as prop>
		<#if (prop.name != tableid)&&(!prop.name?ends_with("remark"))&&prop.name != "versionNo" && prop.name != "class" && prop.name != "updateUser" && prop.name != "updateTime" && prop.name != "createTime" && prop.name != "createUser">
		<#assign porpNo=porpNo+1><#if (porpNo==1 || (porpNo-1) % 3 ==0)><tr></#if>		
	    <#if prop.asType == 'Date'>	
		<td class="labelStyle"><label>${prop.cnName}<span>*</span></label></td>
	    <td>
	    	<input id="eId${prop.name?cap_first}" name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>"  type="text" style="width:120px;" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
	    </td>
	    <#elseif prop.name?ends_with("id")>
	   	<td class="labelStyle"><label>${prop.cnName}名称<span>*</span></label></td>
	    <td>
	    	<input id='eId${prop.name?cap_first}Name' name="${prop.name}Name" value="<@jspEl '${prop.name}Name'/>" class="inputStyle" type="text" />	
	   		<a id="menuBtn" class="selectedIco"  href="#" onclick="open${prop.name?cap_first}Dialog('eId${prop.name?cap_first}','eId${prop.name?cap_first}Name');"></a>
	    	<input id='eId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>" type="text"/>	
	   	</td>
	    <#elseif prop.asType =='Number'>
	   	<td class="labelStyle"><label>${prop.cnName}<span>*</span></label></td>
	    <td>
	    	<input id='eId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>"  class="inputStyle" type="text" check="2"/>	
	   	</td>
	   	<#elseif prop.uiType !=''>
	   	<td class="labelStyle"><label>${prop.cnName}<span>*</span></label></td>
	    <td>	    
	    	<#if prop.checkNull =='1'>	
	    	<s:select cssClass="inputStyle" list="${prop.name}Map" id="eId${prop.name?cap_first}" name="entity.${prop.name}" headerKey="" headerValue="请选择"  check="2"></s:select>
		    <#else>
	    		<s:select cssClass="inputStyle" list="${prop.name}Map" id="eId${prop.name?cap_first}" name="entity.${prop.name}" headerKey="" headerValue="请选择"  ></s:select>
			</#if>
	   	</td>
	   	<#elseif prop.checkNull =='1'>
	   	<td class="labelStyle"><label>${prop.cnName}<span>*</span></label></td>
	    <td>
	    	<input id='eId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>" class="inputStyle" type="text" check="2"/>
	   	</td>
	   	<#elseif prop.checkType !='-1'>
	   	<td class="labelStyle"><label>${prop.cnName}<span>*</span></label></td>
	    <td>
	    	<input id='eId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>" class="inputStyle" type="text" check="2"/>
	   	</td>
	    <#else>
	   	<td class="labelStyle"><label>${prop.cnName}<span>*</span></label></td>
	    <td>
	    	<input id='eId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>" class="inputStyle" type="text" />
	    </td>
	    </#if>
	    <#if (porpNo!=1 && porpNo % 3 ==0)></tr></#if>
		</#if>
		<#if (porpNo%3 !=0 && !prop_has_next)></tr></#if>
		</#list>
	
		<#--备注单独一行显示 -->
		<#list inputfieldList as prop>
    	<#if prop.name?ends_with("remark")>
		<tr>
		<td class="labelStyle"><label>${prop.cnName}</label></td>
		<td style="width:320px;" colspan="5">
	   		<textarea id="eId${prop.name?cap_first}" cols="72" rows="3" name="entity.${prop.name}"><@jspEl "entity.${prop.name}"/></textarea>
		</td>
		</tr>
		</#if>
		</#list>

		</table>
		</fieldset>
		
	</form>
   	</div>


<jsp:include page="/common/show_action_message.jsp"></jsp:include>  
</body>
</html>
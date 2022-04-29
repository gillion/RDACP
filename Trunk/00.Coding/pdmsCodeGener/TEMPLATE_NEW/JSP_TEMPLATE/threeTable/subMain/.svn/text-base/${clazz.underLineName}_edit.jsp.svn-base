<#assign classNameLower = clazz.className?uncap_first>
<#macro jspEl value>${r"${"}${value}}</#macro> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<%@include file="/common/gridheader.jsp" %>
<#if (subClazzes?size > 1)>
<link rel="stylesheet" type="text/css" href="<@jspEl 'ctx'/>/scripts/TabPanel/TabPanel.css"/>
<script type="text/javascript" src="<@jspEl 'ctx'/>/scripts/TabPanel/Fader.js"></script>
<script type="text/javascript" src="<@jspEl 'ctx'/>/scripts/TabPanel/TabPanel.js"></script>
</#if>
<script type="text/javascript">
	$(document).ready(function() {
		//校验//setEmptyCheck('txtIdName:txtIdCode:txtIdLevel:txtIdSeq');//setIntegeCheck('txtIdSeq');
	});
	function doAction(act){
		if(act=='return'||act=='close'){
			art.dialog.close();
		}else if(act=='save'){
			$("#editFormId").attr('action','${classNameLower}Action!save.action');
			<#if (subClazzes?size > 0)>
			var flag = true;
			<#list subClazzes as subClazz> 
			flag = flag&&validateGrid(${subClazz.className?uncap_first}Grid,true,true)
			</#list>
			
			if(true===flag){
			<#list subClazzes as subClazz> 
				setGridValueToForm(${subClazz.className?uncap_first}Grid);
			</#list>
				submitForm('editFormId');
			} 
			<#else>
			submitForm('editFormId');
			</#if>
		}
	}
	//表格按钮事件
	<#list subClazzes as subClazz>
	function do${subClazz.className}GridAction(act,selRecords){
		if('add' == act){return true;}
		if('del' == act){return true;}
	}
	</#list>
</script>
</head>

<body>
	
	<fktag:toolbar>
 		<fktag:toolItem isSaveItem="true" cssClass="icon-save-back-big" onclick="doAction('save')"
 			editAble="<@jspEl "func == 'ADD' || func == 'EDIT'"/>" title="确定">
 		</fktag:toolItem>
 		<fktag:toolItem cssClass="icon-cancel-big" onclick="doAction('return')" title="关闭"></fktag:toolItem>
 	</fktag:toolbar>
	

 	<div class="contant">
   	<form action="${classNameLower}Action!save.action" id="editFormId" method="post">
		<input type="hidden"  name="recordId" value="<@jspEl "recordId"/>" />
		<input type="hidden"  name="func" value="<@jspEl "func"/>" />
		<input type="hidden"  name="operSerialNo" value="<@jspEl "operSerialNo"/>" />
		<input type="hidden"  name="entity.${clazz.pkProperty.name}" value="<@jspEl "entity.${clazz.pkProperty.name}"/>" />
		<input type="hidden" name="entity.${mainClazzId}" value="<@jspEl "entity.${mainClazzId}"/>" />
		<fieldset>
		<legend>主信息</legend>
		<#assign porpNo = 0>
		<table class="formTable">
		<#list clazz.properties as prop>
		<#if (prop.name != clazz.pkProperty.name)&&(!prop.name?ends_with("remark"))&&prop.name != "versionNo" && prop.name != "class" && prop.name != "updateUser" && prop.name != "updateTime" && prop.name != "createTime" && prop.name != "createUser">
		<#assign porpNo=porpNo+1><#if (porpNo==1 || (porpNo-1) % 3 ==0)><tr></#if>
	    <#if prop.asType == 'Date'>	
		<td class="labelStyle"><label>${prop.cnName}<span>*</span></label></td>
	    <td>
	    	<input id="eId${prop.name?cap_first}" name="entity.${prop.name}" value="<fmt:formatDate value='<@jspEl 'entity.${prop.name}'/>' pattern='yyyy-MM-dd HH:mm'/>"  type="text" style="width:120px;" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
	    </td>
	    <#elseif prop.name?ends_with("Id")>
	   	<td class="labelStyle"><label>${prop.cnName}名称<span>*</span></label></td>
	    <td>
	    	<input id='eId${prop.name?cap_first}Name' name="${prop.name}Name" value="<@jspEl '${prop.name}Name'/>" class="inputStyle" type="text" />	
	   		<a class="selectedIco" href="#" onclick="open${prop.name?cap_first}Dialog('eId${prop.name?cap_first}','eId${prop.name?cap_first}Name');"></a>
	    	<input id='eId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>" type="text"/>	
	   	</td>
	    <#elseif prop.asType =='Number'>
	   	<td class="labelStyle"><label>${prop.cnName}<span>*</span></label></td>
	    <td>
	    	<input id='eId${prop.name?cap_first}' name="entity.${prop.name}" value="<@jspEl 'entity.${prop.name}'/>"  class="inputStyle" type="text" />	
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
		<#list clazz.properties as prop>
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
   	


<!--  -->
<#list subClazzes as subClazz>
<#if (subClazzes?size == 1)>
<div class="wrapper" id="domdiv_gridId${subClazz.className}">
<div class="title">明细信息</div>
<div id='dom_gridId${subClazz.className}'></div>
</#if>
<sg:grid id="${subClazz.className?uncap_first}Grid"  container="dom_gridId${subClazz.className}"  uniqueField="${r"${"}(func =='ADD'||func =='EDIT')?'keyNum':'${subClazz.pkProperty.name}'}"
	editable="${r"${"}(func =='ADD'||func =='EDIT')?'true':'false'}" 
	gridData="<@jspEl '${subClazz.className?uncap_first}GridInfo'/>"
	defaultRecord="<@jspEl '${subClazz.className?uncap_first}GridInfo.defVO'/>"
	toolbarAction="do${subClazz.className}GridAction"
	submitForm="editFormId"
>
<#list subClazz.properties as prop>
<#if prop.name != "class">
	<#if prop.name = subClazz.pkProperty.name >	
	<sg:column id="${subClazz.pkProperty.name}" fieldName="${subClazz.pkProperty.name}" fieldType="int" header="ID" editable="false" hidden="true"></sg:column>
	<#else>
	<sg:column  header="${prop.cnName}" id="${prop.name}" fieldName="${prop.name}"
		<#if prop.asType == 'Date'>	
			fieldType="date" format="dateTime" editType="date"></sg:column>	
		<#elseif prop.name?ends_with("Id")>
			fieldType="int" editType="" ></sg:column>
		<#elseif prop.asType =='Number'>   	
			fieldType="float" editType="NumText(12,3)" format="0.000" validRule="['F']"></sg:column>
		<#elseif prop.name?ends_with("remark")>
			editType="textarea"></sg:column>
		<#else>
			editType="text(30)"></sg:column>
		</#if>
	</#if>
</#if>
</#list>

</sg:grid>
</#list>
<!-- end  -->
</div>

<#if (subClazzes?size > 1)>
<div id="tab"></div>
<script type="text/javascript">
var jcTabs = [<#list subClazzes as subClazz>
'<div class="wrapper" id="domdiv_gridId${subClazz.className}"><div class="title">明细信息</div><div id="dom_gridId${subClazz.className}"></div>'<#if subClazz_has_next>,</#if>
</#list>];

var tabpanel = new TabPanel({  
    renderTo:'tab',  
    height:'300px',  
   	border:'2',  
    autoResizable:true,
    active : 0,
    items : [<#list subClazzes as subClazz>
             {id:'tabId${subClazz.className}',title:'明细${subClazz_index+1}',html:jcTabs[${subClazz_index}],closable: false}<#if subClazz_has_next>,</#if>
	</#list>]
});
</script>
</#if>

  
<jsp:include page="/common/show_action_message.jsp"></jsp:include>  
</body>
</html>
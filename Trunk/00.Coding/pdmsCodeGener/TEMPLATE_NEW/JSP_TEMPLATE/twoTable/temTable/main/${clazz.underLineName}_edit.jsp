<#include "common_var.include"/>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<@jspEl 'ctx'/>/scripts/TabPanel/TabPanel.css"/>
<script type="text/javascript" src="<@jspEl 'ctx'/>/scripts/TabPanel/Fader.js"></script>
<script type="text/javascript" src="<@jspEl 'ctx'/>/scripts/TabPanel/TabPanel.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//校验//setEmptyCheck('txtIdName:txtIdCode:txtIdLevel:txtIdSeq');//setIntegeCheck('txtIdSeq');
	});
	function doAction(act){
		var recordId = $(":input[name='recordId']").val();
		if('return'==act||'close'==act){
			art.dialog.close();
		}else if(act=='save'){
			$("#editFormId").attr('action','${classNameLower}Action!save.action');
			submitForm('editFormId');
		}else if(act=='audit'&&confirm('是否验收')){
	 		$("#editFormId").attr('action','${classNameLower}Action!audit.action');
	 		submitForm('editFormId');
		}else if(act=='cancelAudit'&&confirm('是否取消验收')){
	 		$("#editFormId").attr('action','${classNameLower}Action!cacelAudit.action');
	 		submitForm('editFormId');
	 	}else if("del"==act&&confirmDlg('是否删除该记录')){
			showWaitDialog();
			$.post('${classNameLower}Action!delete.action',{'recordId':recordId},
					function(data){
							hideWaitDialog();
							alertDlg(data);
							art.dialog.close();
					});
		}else if("edit"==act){
			var url = '${classNameLower}Action!input.action';
			$("#editFormId").attr('action',url);
 			submitForm('editFormId');
		}
	}
</script>
</head>

<body>
	<div class="topnav"><p>模块 &gt;资源 &gt;资源&gt;${entityCnName} 编辑</p></div>
 	
 	<fktag:toolbar>
 		<fktag:toolItem cssClass="icon-back-big" onclick="doAction('return')" title="返回列表"></fktag:toolItem>
 		<fktag:toolItem isSaveItem="true" cssClass="icon-save-big" onclick="doAction('save')"
 			editAble="<@jspEl "func == 'ADD' || func == 'EDIT'"/>" title="保存">
 		</fktag:toolItem>
 		<fktag:toolItem cssClass="icon-edit-big" editAble="<@jspEl "func == 'VIEW'"/>" onclick="doAction('edit')" title="修改"></fktag:toolItem>
 		<fktag:toolItem cssClass="icon-delete-big" editAble="<@jspEl "func == 'VIEW'"/>" onclick="doAction('del')" title="删除"></fktag:toolItem>
 		<fktag:toolItem cssClass="icon-audit-big" editAble="<@jspEl "func == 'VIEW' && entity.state == '0'"/>" onclick="doAction('audit')" title="审核"></fktag:toolItem>
 	</fktag:toolbar>
 	

 	<div class="contant">
   	<form action="${classNameLower}Action!save.action" id="editFormId" method="post">
		<input type="hidden"  name="operSerialNo" value="<@jspEl "operSerialNo"/>" />
		<input type="hidden"  name="recordId" value="<@jspEl "recordId"/>" />
		<input type="hidden"  name="func" value="<@jspEl "func"/>" />
		<input type="hidden"  name="entity.${clazz.pkProperty.name}" value="<@jspEl "entity.${clazz.pkProperty.name}"/>" />
		<#list clazz.properties as prop>
    	<#if prop.name = "versionNo">
		<input type="hidden"  name="entity.versionNo" value="<@jspEl "entity.versionNo"/>" />
		</#if>
		</#list>
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
	    	<input id="eId${prop.name?cap_first}" name="entity.${prop.name}" value="<fmt:formatDate value='<@jspEl 'entity.${prop.name}'/>' pattern ='yyyy-MM-dd HH:mm'/>"  type="text" style="width:120px;" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
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
	   		<textarea id="eId${prop.name?cap_first}" cols="72" rows="2" name="entity.${prop.name}"><@jspEl "entity.${prop.name}"/></textarea>
		</td>
		</tr>	
		</#if>
		</#list>
		</table>
		</fieldset>
	</form>
   	</div>
   	
   <div id="tab"></div>
   <script type="text/javascript">
	<s:if test="'ADD' eq func or 'EDIT' eq func ">
	var jcTabs = [<#list subClazzes as subClazz>
				'<iframe width="100%" height="100%" frameborder="0" src="${subClazz.className?uncap_first}Action!list.action?operSerialNo=<@jspEl "operSerialNo"/>&func=<@jspEl "func"/>" />'<#if subClazz_has_next>,</#if>
				</#list>];
	</s:if>
	<s:else>
	
	var jcTabs = [<#list subClazzes as subClazz>
				'<iframe width="100%" height="100%" frameborder="0" src="${subClazz.className?uncap_first}Action!listReal.action?parentId=<@jspEl "recordId"/>&func=<@jspEl "func"/>" />'<#if subClazz_has_next>,</#if>
				</#list>];
	</s:else>
	
	var tabpanel = new TabPanel({renderTo:'tab',height:'300px',border:'2',autoResizable:true,active : 0,
    	items : [<#list subClazzes as subClazz>
				{id:'tabId${subClazz.className}',title:'明细${subClazz_index+1}',html:jcTabs[${subClazz_index}],closable: false}<#if subClazz_has_next>,</#if>
		</#list>]
	});
	
	</script>
<jsp:include page="/common/show_action_message.jsp"></jsp:include> 
</body>
</html>
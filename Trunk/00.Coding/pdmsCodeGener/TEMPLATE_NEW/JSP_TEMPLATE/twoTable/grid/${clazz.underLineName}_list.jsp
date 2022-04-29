<#include "common_var.include"/> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	//校验//setEmptyCheck('txtIdName:txtIdCode:txtIdLevel:txtIdSeq');//setIntegeCheck('txtIdSeq');
}); 
function doSearch(pageNo){
	if(pageNo){
		$("#currentPage").val(pageNo);
	}
	submitForm('qryFormId');
}
//增加、修改、删除动作
function doAction(atn,recordId) {
	if(atn == 'add'){
		var url = '${classNameLower}Action!input.action';
		art.dialog.open(url,{
			width: '100%',height: '100%',left: '0%',top: '0%',fixed: true,resize: false,drag: false,lock:true,
			title:false,
			closeFn:function(){
				doSearch();
			}
		});
		return ;
	}else if(atn == 'view') {
		var url = '${classNameLower}Action!toView.action?recordId='+recordId;
		art.dialog.open(url,{
			width: '100%',height: '100%',left: '0%',top: '0%',fixed: true,resize: false,drag: false,lock:true,
			title:false,
			closeFn:function(){
				doSearch();
			}
		});
		return ;
	}
} 
</script>
</head>
<body>
<div class="topnav"><p>xx模块  &gt; xx  &gt; XX管理 &gt; ${entityCnName}列表</p></div>

<!--动作,增加修改删除,必须-->
<div class="x-toolbar-small">
	<ul class="toolbar-btn_small">
		<li><p><a class="icon-search-big" href="#" id="hrQry" onclick="javascript:doSearch(1);">查找</a></p></li>
		<li class="toolbar-sprit"></li>
		<li><p><a class="icon-add-big" href="#" target="_self" onclick="javascript:doAction('add');">新增${entityCnName}</a></p></li>
		<li class="toolbar-sprit"></li>
		<li><p><a class="icon_reset-big" href="#" onclick="resetCondition();">重置</a></p></li> 
	</ul>
</div>

<!-- 查询 -->
<div class="wrapper">
	<div class="title"><p>查询</p></div>
	<div class="contant">
	<form action="${classNameLower}Action.action" method="post" id="qryFormId">
	<input type="hidden" name="currentPage"  id="currentPage" value="<@jspEl 'currentPage'/>" />
	
	<#assign porpNo = 0>
	<table class="formTable">
	<#list clazz.properties as prop>
	    <#if (!prop.name?ends_with("remark")) && prop.name != "versionNo" && prop.name != "class" && prop.name != "updateUser" && prop.name != "updateTime" && prop.name != "createTime" && prop.name != "createUser">
	<#assign porpNo=porpNo+1><#if (porpNo==1 || (porpNo-1) % 3 ==0)><tr></#if>
	    <#if prop.name = "state">
	    <td class="labelStyle"><label>${prop.aliasName}</label></td>
	    <td>
	    	<s:select cssStyle="width:100px" id='qIdState' name="conditionMap.state"  headerKey="" headerValue="" list="${r"#{'1':'已验收','0':'未验收'}"}" />
	    </td>
	    <#elseif prop.asType == 'Date'>	
		<td class="labelStyle"><label>${prop.cnName} 从</label></td>
	    <td>
	    	<input id="qId${prop.name?cap_first}_start" name="conditionMap.${prop.name}_start" value="<@jspEl 'conditionMap.${prop.name}_start'/>"  type="text" style="width:120px;" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'qId${prop.name?cap_first}_end\')}'})"/>
	    </td>
	   <#if (porpNo!=1 && porpNo % 3 ==0)></tr></#if>
	   <#assign porpNo=porpNo+1><#if (porpNo==1 || (porpNo-1) % 3 ==0)><tr></#if>
	    <td class="labelStyle"><label>${prop.cnName} 止</label></td>
	    <td>
	    	<input id="qId${prop.name?cap_first}_end" name="conditionMap.${prop.name}_end" value="<@jspEl 'conditionMap.${prop.name}_end'/>"  type="text" style="width:120px;" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'qId${prop.name?cap_first}_start\')}'})"/>
	    </td>
	   <#elseif prop.name?ends_with("Id")>
	   	<td class="labelStyle"><label>${prop.cnName} 名称</label></td>
	    <td>
	    	<input id='qId${prop.name?cap_first}Name' name="conditionMap.${prop.name}Name" value="<@jspEl 'conditionMap.${prop.name}Name'/>"  class="inputStyle" type="text" />	
	   		<a class="selectedIco" href="#" onclick="open${prop.name?cap_first}Dialog('qId${prop.name?cap_first}','qId${prop.name?cap_first}Name');"></a>
	    	<input id='qId${prop.name?cap_first}' name="conditionMap.${prop.name}" value="<@jspEl 'conditionMap.${prop.name}'/>" type="hidden"/>	
	   	</td>
	   <#elseif prop.asType =='Number'>
	   	<td class="labelStyle"><label>${prop.cnName}</label></td>
	    <td>
	    	<input id='qId${prop.name?cap_first}' name="conditionMap.${prop.name}" value="<@jspEl 'conditionMap.${prop.name}'/>"  class="inputStyle" type="text" />	
	   	</td>
	    <#else>
	   	<td class="labelStyle"><label>${prop.cnName}</label></td>
	    <td>
	    	<input id='qId${prop.name?cap_first}' name="conditionMap.${prop.name}" value="<@jspEl 'conditionMap.${prop.name}'/>" class="inputStyle" type="text" />
	    </td>
	    </#if>
	<#if (porpNo!=1 && porpNo % 3 ==0)></tr></#if>
	</#if>
	<#if (porpNo%3 !=0 && !prop_has_next)></tr></#if>
	</#list>
	</table>
	
	</form>
	</div>
</div>

<!-- 表格 -->
<div class="wrapper" id="tableDivId">
<div class="title"> 查询列表 </div>
<table class="grid">
<tbody>
	<tr>
	<th width="20px" ></th>     
	<#list clazz.properties as prop>
    <#if prop.name != "versionNo" && prop.name != "class" && prop.name != "updateUser" && prop.name != "updateTime">
	<th>${prop.cnName}</th>        
	</#if>
	</#list>
	<th width="60px">操作</th>
	</tr>
<s:iterator value="%{pageData.datals}" id='vo' status='st'>
	<tr <s:if test="#st.even">class="spritTr"</s:if>>
	<td align="center"><s:property value="#st.count+(pageData.currentPage-1) * (pageData.pageSize)" /></td>
	<#list clazz.properties as prop>    
    <#if prop.name != "versionNo" && prop.name != "class" && prop.name != "updateUser" && prop.name != "updateTime">
	<#if prop.asType == 'Date'>	
	<td><fmt:formatDate value="<@jspEl 'vo.${prop.name}'/>"/></td>
	<#elseif prop.asType =='Number'>
	<td><@jspEl 'vo.${prop.name}'/></td>
	<#else>
	<td><@jspEl 'vo.${prop.name}'/></td>
	</#if>
	</#if>
	</#list> 
    <td>
    <a href="#" target="_self" onclick="javascript:doAction('view','<@jspEl 'vo.${clazz.pkProperty.name}'/>');return false;" >查看</a> 	
    </td>
    </tr>			
</s:iterator>       
</tbody>
<tfoot></tfoot>	
</table>
<s:if test="pageData.totalPageNum > 1"><s:include value="/common/pager.jsp"/></s:if>
</div>
<jsp:include page="/common/show_action_message.jsp"></jsp:include>
</body>
</html>
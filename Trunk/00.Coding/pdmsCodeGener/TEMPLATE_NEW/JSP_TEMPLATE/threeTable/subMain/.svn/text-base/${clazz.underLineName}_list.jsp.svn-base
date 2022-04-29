<#include "common_var.include"/> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
function reloadPage(){submitForm('qryFormId');}

var seriaNo='<@jspEl "operSerialNo"/>';
var func = '<@jspEl "func"/>';
var parentId='<@jspEl "parentId"/>';

//增加、修改、删除动作
function doAction(atn, recordId) {
	var params='operSerialNo='+seriaNo+'&func='+func+'&parentId='+parentId;;

	if (atn == 'del'&&confirm('是否删除该记录')) {
		$.post('${classNameLower}Action!delete.action', {'recordId':recordId}, function(data){
			alertDlg(data);
			reloadPage();
		}) ;
	}
	if(atn == 'add'){
		$.dialog.open('${classNameLower}Action!input.action?'+params,{
			 title:false,
			 lock:true,width: '100%',height: '100%', left: '0%',top: '0%',fixed: true,resize: false,drag: false,
			 closeFn:function(){
			 	reloadPage();
			 }
		});
	}
	if (atn == 'edit') {
		$.dialog.open('${classNameLower}Action!input.action?recordId='+recordId+'&'+params,{
			 title:false,
			 lock:true,width: '100%',height: '100%', left: '0%',top: '0%',fixed: true,resize: false,drag: false,
			 closeFn:function(){
				reloadPage();
			 }
		});
	}
	if (atn == 'viewReal') {
		$.dialog.open('${classNameLower}Action!viewReal.action?recordId='+recordId+'&'+params,{
			 title:false, 
			 lock:true,width: '100%',height: '100%', left: '0%',top: '0%',fixed: true,resize: false,drag: false
		});
	}			
} 
</script>
</head>

<body>
<!--动作,增加修改删除,必须-->
<s:if test="'ADD' eq func or 'EDIT' eq func">
<div class="x-toolbar-small">
	<ul class="toolbar-btn_small">
		<li><p><a class="icon-add-big" href="#" target="_self" onclick="return doAction('add');">新增</a></p></li>
		</s:if>
	</ul>
</div>

<!-- 表格 -->
<div class="wrapper" id="tableDivId">
<div class="title">明细列表 </div>
<table class="grid">
	<tfoot></tfoot>	
<tbody>
	<tr>
	<th width="30px"></th>
	<#list clazz.properties as prop>
    <#if prop.name != "versionNo" && prop.name != "class" && prop.name != "updateUser" && prop.name != "updateTime">
	<th>${prop.cnName}</th>        
	</#if>
	</#list>
	<th width="130px">操作</th>
	</tr>
<s:iterator value="%{entityList}" id='vo' status='st'>
	<s:if test="rowStauts!=-1">
	<tr <s:if test="#st.even">class="spritTr"</s:if>>
	<td align="center"><s:property value="#st.count" /></td>
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
    
    <#if (subClazzes?size > 0)>
    <#list subClazzes as subClazz>
    <!-- 明细表 -->
    <#list subClazz.properties as prop>    
    <#if prop.name != "versionNo" && prop.name != "class" && prop.name != "updateUser" && prop.name != "updateTime">
	<td>
	<table class="subgrid">
	<s:iterator value="%{${subClazz.className?uncap_first}ListMap[#vo.${clazz.pkProperty.name} eq null?#vo.keyNum:#vo.${clazz.pkProperty.name}]}" id='dvo'>
	<tr><td><@jspEl 'dvo.${prop.name}'/></td></tr>
	</s:iterator>
	</table>
	</td>
	</#if>
	</#list> 
	<!-- end 明细表 -->
	</#list>
    </#if>
    <td>
    	<s:if test="'EDIT' eq func or 'ADD' eq func">
    	<a href="#" target="_self" onclick="return doAction('edit','<@jspEl 'vo.keyNum'/>');" >修改</a> | 	
    	<a href="#" target="_self" onclick="return doAction('del','<@jspEl 'vo.keyNum'/>');" >删除</a>
    	</s:if>	
    	<s:else>
    	<a href="#" target="_self" onclick="return doAction('viewReal','<@jspEl 'vo.detailId'/>');" >查看</a>	
    	</s:else>
    </td>
    </tr>
    </s:if>			
</s:iterator>       
</tbody>
</table>
</div>
<form action="#" method="post" id="qryFormId"></form>
<jsp:include page="/common/show_action_message.jsp"></jsp:include>
</body>
</html>
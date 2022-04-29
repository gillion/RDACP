<#include "common_var.include"/> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="${basepackage}.data.bo.${moduleName}.*" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
//页面查询和切换
function gotoPage(atn) {
	if (atn == 'first') {$("#currentPage").val(1);}
	else if (atn == 'prev') {$("#currentPage").val(<s:property value="%{pageData.prePage}"/>);}
	else if (atn == 'next') {$("#currentPage").val(<s:property value="%{pageData.nextPage}"/>);}
	else if (atn == 'last') {$("#currentPage").val(<s:property value="%{pageData.totalPageNum}"/>);}
	doSearch($("#currentPage").val());
} 

function doSearch(pageNo){
	if(pageNo){
		$("#currentPageId").val(pageNo);
	}
	submitForm('qryFormId');
}
function reloadPage(){
	submitForm('qryFormId');
}
var seriaNo='<@jspEl "operSerialNo"/>';
var func = '<@jspEl "func"/>';
var parentId='<@jspEl "parentId"/>';

//增加、修改、删除动作
function doAction(atn, recordId) {
	var params='operSerialNo='+seriaNo+'&func='+func+'&parentId='+parentId;;

	if (atn == 'del'&&confirm('是否删除该记录')) {
		$.post('${classNameLower}Action!delete.action', {'recordId':recordId}, function(data){
			alert(data);
			reloadPage()
			}) ;
	}
	if(atn == 'add'){
		$.dialog.open('${classNameLower}Action!input.action?'+params,{
			 title:'新增明细',lock:true,width:850,height:400,
			 closeFn:function(){
			 	reloadPage();
			 }
		});
	}
	if (atn == 'edit') {
		$.dialog.open('${classNameLower}Action!input.action?recordId='+recordId+'&'+params,{
			 title:'编辑明细',lock:true,width:850,height:400,
			 closeFn:function(){
				reloadPage();
			 }
		});
	}
	if (atn == 'viewReal') {
		$.dialog.open('${classNameLower}Action!viewReal.action?recordId='+recordId+'&'+params,{
			 title:'查看明细',lock:true,width:850,height:400,
			 closeFn:function(){
				reloadPage();
			 }
		});
	}			
} 
</script>
</head>
<body>
<!--动作,增加修改删除,必须-->
<div class="x-toolbar-small">
	<ul class="toolbar-btn_small">
		<s:if test="'ADD' eq func or 'EDIT' eq func">
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
	<th width="20px" ></th>
	<#list clazz.properties as prop>
    <#if prop.name != "versionNo" && prop.name != "class" && prop.name != "updateUser" && prop.name != "updateTime">
	<th>${prop.cnName}</th>        
	</#if>
	</#list>
	<th>操作</th>
	</tr>
<s:iterator value="%{details}" id='vo' status='st'>
	<s:if test="rowStauts!=-1">
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
    	<s:if test="'EDIT' eq func or 'ADD' eq func">
    	<a href="#" target="_self" onclick="return doAction('edit','<@jspEl 'vo.keyNum'/>');" >编辑</a> | 	
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
<!--分页-->
<s:if test="pageData.totalPageNum > 1">
	<s:include value="/common/pager.jsp"/>
</s:if>
</div>
<form action="#" method="post" id="qryFormId">
 	<input type="hidden" name="currentPage"  id="currentPageId" value="<@jspEl 'currentPage'/>" />
</form>
<jsp:include page="/common/show_action_message.jsp"></jsp:include>
</body>
</html>
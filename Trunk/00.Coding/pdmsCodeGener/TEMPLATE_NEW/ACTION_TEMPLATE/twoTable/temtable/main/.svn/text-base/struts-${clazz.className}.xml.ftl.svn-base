<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>

	<!-- begin ${entityCnName} -->
  	<action name="${classNameLower}Action" class="${basepackage}.action.${moduleName}.${className}Action">
   		<result>${clazz.underLineName}_list.jsp</result>
 		<result name="input">${clazz.underLineName}_edit.jsp</result>
   		<result name="reload" type="redirect">${classNameLower}Action.action</result>
   	</action>
   	<!-- end of ${entityCnName}  -->
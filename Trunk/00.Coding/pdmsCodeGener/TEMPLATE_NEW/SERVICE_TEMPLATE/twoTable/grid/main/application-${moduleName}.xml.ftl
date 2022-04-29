<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<!-- ${entityCnName}-->
<bean id="${classNameLower}BS" class="${basepackage}.service.impl.${moduleName}.${className}BSImpl" parent="baseBS">
<#list subClazzes as subClazz>
	<property name="${subClazz.className?uncap_first}BS" ref="${subClazz.className?uncap_first}BS" />
</#list>
</bean>
<!-- end of ${entityCnName}-->
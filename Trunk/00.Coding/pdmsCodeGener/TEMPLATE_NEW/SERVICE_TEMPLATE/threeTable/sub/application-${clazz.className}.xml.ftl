<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<!-- ${entityCnName}-->
<bean id="${classNameLower}BS" class="${basepackage}.service.impl.${moduleName}.${className}BSImpl" parent="baseBS">
	<property name="tempOrderBS" ref="tempOrderBS" />
</bean>
<!-- end of ${entityCnName}-->
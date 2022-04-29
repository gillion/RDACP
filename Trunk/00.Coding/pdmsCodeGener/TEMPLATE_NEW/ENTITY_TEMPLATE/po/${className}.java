<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${classNameLower}.domain;
import java.io.Serializable;


/**
 * ${table.tableAlias}
 */
public class ${className} implements Serializable<#list table.columns as column><#if column.sqlName == "UPDATE_TIME">,RecordUserAndTimeAble</#if></#list>{
	<@generateFields/>
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	<@generatePkProperties/>
	<@generateNotPkProperties/>

}
<#macro generateFields>
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	private ${column.javaType} ${column.sqlName};//${column.columnAlias}
	</#if>
	</#list>
</#macro>


<#macro generateConstructor>
	public ${className}(){}
</#macro>

<#macro generatePkProperties>
	<#list table.columns as column>
	<#if column.pk>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.sqlName};
	}
	
	public void set${column.columnName}(${column.javaType} ${column.columnName}) {
		this.${column.sqlName} = ${column.columnName};
	}
	
	</#if>
	</#list>
</#macro>



<#macro generateNotPkProperties>
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	<#if !column.pk>

	public ${column.javaType} get${column.columnName}() {
		return this.${column.sqlName};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.sqlName} = value;
	}
	
	</#if>
	</#if>
	</#list>
</#macro>
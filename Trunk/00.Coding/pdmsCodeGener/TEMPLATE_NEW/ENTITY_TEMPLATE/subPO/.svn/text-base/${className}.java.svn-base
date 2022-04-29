<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.data.bo.${moduleName};
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.fkframe.persist.RecordUserAndTimeAble;
/**
 * ${table.tableAlias}
 *
 */
@Entity
@Table(name = "${table.sqlName}")
public class ${className} implements Serializable<#list table.columns as column><#if column.sqlName == "UPDATE_TIME">,RecordUserAndTimeAble</#if></#list>{
	private static final long serialVersionUID = 1L;
	<@generateConstructor/>
	
	//属性
	<@generateFields/>
	
	<@generatePkProperties/>
	<@generateNotPkProperties/>
	
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	public static final String ALIAS_${column.columnName} = "${column.columnAlias}";
	</#if>
	</#list>
	
	
	//hql 可以使用 
	public static final String CLAZZ_FULL_NAME = "${basepackage}.data.bo.${moduleName}.${className}";
	<#list table.columns as column>
	<#--public static final String ALIAS_${column.constantName} = "${column.columnAlias}";-->
	<#if !column.sqlName?starts_with("DEFINE")>
	public static final String PROP_${column.constantName} ="${column.columnNameLower}";
	</#if>
	</#list>
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		<#list table.columns as column>
		<#if !column.sqlName?starts_with("DEFINE")>
			<#if !table.compositeId>
			.append("${column.columnName}",get${column.columnName}())
			</#if>
		</#if>
		</#list>
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
		<#list table.pkColumns as column>
			<#if !table.compositeId>
			.append(get${column.columnName}())
			</#if>
		</#list>
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ${className} == false) return false;
		if(this == obj) return true;
		${className} other = (${className})obj;
		return new EqualsBuilder()
			<#list table.pkColumns as column>
				<#if !table.compositeId>
			.append(get${column.columnName}(),other.get${column.columnName}())
				</#if>
			</#list>
			.isEquals();
	}
}

<#macro generateFields>
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	private ${column.javaType} ${column.columnNameLower};//${column.columnAlias}
	</#if>
	</#list>
</#macro>


<#macro generateConstructor>
	public ${className}(){}
</#macro>

<#macro generatePkProperties>
	<#list table.columns as column>
	<#if column.pk>
	@Id
	@Column(name = "${column.sqlName}", unique = ${column.unique?string}, nullable = ${column.nullable?string},length = ${column.size})
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} ${column.columnName}) {
		this.${column.columnNameLower} = ${column.columnName};
	}
	
	</#if>
	</#list>
</#macro>



<#macro generateNotPkProperties>
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	<#if !column.pk>
	<#if column.sqlName == "VERSION_NO">
	@Version
	@Column(name = "${column.sqlName}")
	<#elseif column.javaType == "BigDecimal" >
	@Column(name = "${column.sqlName}",precision=${column.size},scale = ${column.decimalDigits},unique = ${column.unique?string},nullable = ${column.nullable?string})
	<#else>
	@Column(name = "${column.sqlName}",unique = ${column.unique?string},nullable = ${column.nullable?string},length = ${column.size})
	</#if>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	</#if>
	</#if>
	</#list>
</#macro>
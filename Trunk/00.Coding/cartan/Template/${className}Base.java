<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.pojo.${moduleName}.base;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */

@MappedSuperclass
public class ${className}Base implements Serializable  {

<@generateFields/>
<#if noparent == "0">
<#list table.columns as column>
<#if column.pk >
protected <#if column.sqlTypeName=="VARCHAR2"||column.sqlTypeName=="NVARCHAR2"||column.sqlTypeName=="CHAR" >String<#else>Long</#if> id;
@Id
@Column(name="ID", nullable=false<#if column.sqlTypeName=="VARCHAR2"||column.sqlTypeName=="NVARCHAR2"||column.sqlTypeName=="CHAR" >, length=32</#if>)
public <#if column.sqlTypeName=="VARCHAR2"||column.sqlTypeName=="NVARCHAR2"||column.sqlTypeName=="CHAR" >String<#else>Long</#if> getId() {
        return this.id;
}

public void setId(<#if column.sqlTypeName=="VARCHAR2"||column.sqlTypeName=="NVARCHAR2"||column.sqlTypeName=="CHAR" >String<#else>Long</#if> id) {
        this.id = id;
}
</#if>
</#list>
</#if>

<@generateNotPkProperties/>
}
<#macro generateFields>
<#list table.columns as column>
<#assign isComm = 0>
<#list commonfieldList as prop>
<#if column.columnNameLower == prop.name>
<#assign isComm = 1>
</#if>
</#list>
<#if noparent == "1">
<#if !column.sqlName?starts_with("DEFINE") && isComm == 0>
<#if column.sqlName=="RECORD_VERSION" >
private Integer ${column.columnName?uncap_first};//${column.columnAlias}
<#else>
private ${column.javaType} ${column.columnName?uncap_first};//${column.columnAlias}
</#if>
</#if>
<#else>
<#if !column.sqlName?starts_with("DEFINE") && !column.pk >
<#if column.sqlName=="RECORD_VERSION" >
private Integer ${column.columnName?uncap_first};//${column.columnAlias}
<#else>
private ${column.javaType} ${column.columnName?uncap_first};//${column.columnAlias}
</#if>
</#if>
</#if>
</#list>
</#macro>
<#macro generateConstructor>
/** default constructor */
public ${className}Base(){

}
</#macro>
<#macro generateNotPkProperties>
<#list table.columns as column>
<#assign isComm = 0>
<#list commonfieldList as prop>
<#if column.columnNameLower == prop.name>
<#assign isComm = 1>
</#if>
</#list>
<#if noparent == "0">
<#if !column.sqlName?starts_with("DEFINE") && !column.pk >
<#if column.sqlName=="RECORD_VERSION" >
@Column(name="${column.sqlName}"<#if column.javaType == "String">, length=${column.size}</#if>)
public Integer get${column.columnName}() {
        return this.${column.columnName?uncap_first};
}

public void set${column.columnName}(Integer ${column.columnName?uncap_first}) {
        this.${column.columnName?uncap_first} = ${column.columnName?uncap_first};
}
<#else>
@Column(name="${column.sqlName}"<#if column.javaType == "String">, length=${column.size}</#if>)
public ${column.javaType} get${column.columnName}() {
        return this.${column.columnName?uncap_first};
}

public void set${column.columnName}(${column.javaType} ${column.columnName?uncap_first}) {
        this.${column.columnName?uncap_first} = ${column.columnName?uncap_first};
}
</#if>
</#if>
<#else>
<#if !column.sqlName?starts_with("DEFINE") && isComm == 0>
<#if column.sqlName=="ID" >
@Id
</#if>
<#if column.sqlName=="RECORD_VERSION" >
@Column(name="${column.sqlName}"<#if column.javaType == "String">, length=${column.size}</#if>)
public Integer get${column.columnName}() {
        return this.${column.columnName?uncap_first};
}

public void set${column.columnName}(Integer ${column.columnName?uncap_first}) {
        this.${column.columnName?uncap_first} = ${column.columnName?uncap_first};
}
<#else>
@Column(name="${column.sqlName}"<#if column.javaType == "String">, length=${column.size}</#if>)
public ${column.javaType} get${column.columnName}() {
        return this.${column.columnName?uncap_first};
}

public void set${column.columnName}(${column.javaType} ${column.columnName?uncap_first}) {
        this.${column.columnName?uncap_first} = ${column.columnName?uncap_first};
}
</#if>
</#if>
</#if>
</#list>
</#macro>

<#macro generatePkProperties>
<#list table.columns as column>
<#if column.pk >
<#if column.sqlTypeName=="VARCHAR2"||column.sqlTypeName=="NVARCHAR2"||column.sqlTypeName=="CHAR" >String<#else>Long</#if> ${column.columnName?uncap_first};//${column.columnAlias}
public <#if column.sqlTypeName=="VARCHAR2"||column.sqlTypeName=="NVARCHAR2"||column.sqlTypeName=="CHAR" >String<#else>Long</#if> get${column.columnName}(){
	return this.${column.columnName?uncap_first};
}
public void set${column.columnName}(<#if column.sqlTypeName=="VARCHAR2"||column.sqlTypeName=="NVARCHAR2"||column.sqlTypeName=="CHAR" >String<#else>Long</#if> ${column.columnName?uncap_first}){
	this.${column.columnName?uncap_first} =${column.columnName?uncap_first};
}
</#if>
</#list>
</#macro>
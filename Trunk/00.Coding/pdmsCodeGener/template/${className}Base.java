<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.pojo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */

@MappedSuperclass
public class ${className}Base implements Serializable  {

<@generateFields/>
<#if noparent == "0"||noparent == "2">
protected String id;
@Id
/**
@GenericGenerator(name="uuid", strategy="uuid")
@GeneratedValue(generator="uuid")
 */
@Column(name="ID", nullable=false, length=32)
public String getId() {
        return this.id;
}

public void setId(String id) {
        this.id = id;
}
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
<#if !column.sqlName?starts_with("DEFINE") && !column.pk && column.sqlName!="ID" >
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
<#if noparent == "0"||noparent == "2">

<#if !column.sqlName?starts_with("DEFINE") && !column.pk && column.sqlName!="ID">

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

<#if !column.sqlName?starts_with("DEFINE")   && isComm == 0>
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

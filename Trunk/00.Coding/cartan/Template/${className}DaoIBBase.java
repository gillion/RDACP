<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign bigger = "&gt;">
<#assign smaller = "&lt;">
<#assign leftbit = "#{">
<#assign rightbit = "}">
<#assign leftsit = "#{">
<#assign rightsit = "}">
<#assign leftbracket = "#{">
<#assign rightbracket = "}">
<#assign prikey = "ID">
<#assign pricolumn = "id">
<#assign priSqlType = "Long">
<#assign prijavaType = "Long">
<#assign firstprikey = "ID">
<#assign firstpricolumn = "id">
<#assign firstpriSqlType = "Long">
<#assign firstprijavaType = "Long">
<#assign isHasKey = 0>
<#assign keycount = 0>
<#list table.columns as column>
<#assign keycount = keycount+1>
<#if keycount==1>
<#assign firstpricolumn = column.columnName?uncap_first>
<#assign firstprikey = column.sqlName>
<#assign firstpriSqlType = column.sqlTypeName>
<#assign firstprijavaType = column.sqlTypeName>
</#if>
<#if column.pk>
<#assign pricolumn = column.columnName?uncap_first>
<#assign prikey = column.sqlName>
<#assign priSqlType = column.sqlTypeName>
<#assign prijavaType = column.javaType>
<#assign isHasKey = 1>
</#if>
</#list>
package ${basepackage}.common.dao.${moduleName}.base;

import cn.com.xcs.framework.persist.Page;

import cn.ibm.dao.BaseDao;

import ${basepackage}.common.pojo.${moduleName}.${className};

import java.util.List;


/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public interface ${className}DaoIBBase extends BaseDao<${className},String>{

    /**
     * 根据ID获取对象
     * @param id  主键id
     * @return
     */
    public ${className} get${className}ById(<#if priSqlType=="NUMBER">Long<#else>String</#if> id);

    /**
     * 分页查询${table.tableAlias}对象
     * @param page
     * @return
     */
    public Page get${className}Page(Page page,${className} ${classNameLower});

    /**
     * 列表查询${table.tableAlias}对象
     * @param
     * @return
     */
    public List<${className}> get${className}List(${className} ${classNameLower});

    <#if noparent == "0"||noparent == "2">
    /**
     * 根据ID删除对象
     * @param id  主键id
     */
    public int delete${className}ById(<#if priSqlType=="NUMBER">Long<#else>String</#if> id);

    /**
     * 新增${table.tableAlias}
     * @param ${classNameLower}   ${table.tableAlias}对象
     */
    public void save${className}(${className} ${classNameLower});

    /**
     * 更新${table.tableAlias}
     * @param ${classNameLower}     ${table.tableAlias}对象
     * @return
     */
    public int update${className}(${className} ${classNameLower});
    </#if>


}

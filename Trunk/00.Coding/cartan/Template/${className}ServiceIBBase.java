<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign bigger = "&gt;">
<#assign smaller = "&lt;">
<#assign leftbit = "#{">
<#assign rightbit = "}">
<#assign prikey = "ID">
<#assign pricolumn = "id">
<#assign priSqlType = "Long">
<#list table.columns as column>
<#if column.pk>
<#assign pricolumnUp = column.columnName>
<#assign pricolumn = column.columnName?uncap_first>
<#assign prikey = column.sqlName>
<#assign priSqlType = column.sqlTypeName>
</#if>	
</#list>
package ${basepackage}.common.service.${moduleName}.base;

import cn.com.xcs.framework.persist.Page;

import cn.ibm.service.BaseService;

import ${basepackage}.common.pojo.${moduleName}.${className};

import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-13
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public interface ${className}ServiceIBBase extends BaseService {
<#if noparent == "0"||noparent == "2">
    /**
     * 新增${table.tableAlias}
     * @param ${classNameLower}
     */
    public void save${className}(${className} ${classNameLower});

    /**
     * 通过ID删除${table.tableAlias}
     * @param id
     * @return
     */
    public int delete${className}ById(<#if priSqlType=="NUMBER">Long<#else>String</#if> id);

    /**
     * 更新${table.tableAlias}
     * @param ${classNameLower}
     * @return
     */
    public int update${className}(${className} ${classNameLower});
</#if>
    /**
     * 通过id查找${table.tableAlias}对象
     * @param id
     * @return
     */
    public ${className} get${className}ById(<#if priSqlType=="NUMBER">Long<#else>String</#if> id);

    /**
     * 分页查询${table.tableAlias}
     * @param page
     * @param ${classNameLower}
     * @return
     */
    public Page get${className}Page(Page page,${className} ${classNameLower});

    /**
     * 列表查询${table.tableAlias}
     * @param ${classNameLower}
     * @return
     */
    public List<${className}> get${className}List(${className} ${classNameLower});
}

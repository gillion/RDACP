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
 * Date: 16-7-12
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public interface ${className}ServiceBase<T> extends BaseService {

    /**
     * 分页模糊查找${table.tableAlias}列表信息
     * @param page		分页对象
     * @param obj ${table.tableAlias}
     * @return
     */
    public Page findByParams(Page page, T obj);
    <#if noparent == "0"||noparent == "2">
    /**
     * 保存${table.tableAlias}信息
     * @param obj ${table.tableAlias}
     * @param saveParam 1:不生成主键， 0或其他（2,3,4,5,6……）：生成主键
     */
    public void save(T obj,int ... saveParam);

    /**
     * 修改${table.tableAlias}信息
     * @param obj ${table.tableAlias}
     */
    public void update(T obj);

    /**
     * 删除${table.tableAlias}信息
     * @param id
     */
    public void delete(<#if priSqlType=="NUMBER">Long<#else>String</#if> id);
    /**
     * 删除${table.tableAlias}信息
     * @param ids
     */
    public void deleteIds( String ids);
    </#if>

    /**
     * 根据id${table.tableAlias}信息
     * @param id
     */
    public T getObject(<#if priSqlType=="NUMBER">Long<#else>String</#if> id);

    /**
     * 根据${classNameLower}获取${table.tableAlias}对象列表信息
     * @param obj
     */
    public List<T> listByParams(T obj);
    /**
     * 根据${classNameLower}获取${table.tableAlias}对象列表信息
     * @param obj
     */
    public List<T> listEquals(T obj);
}


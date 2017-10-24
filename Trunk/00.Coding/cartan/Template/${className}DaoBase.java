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
package ${basepackage}.common.dao.${moduleName}.base;

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.persist.orm.HibernateDao;

import cn.ibm.dao.BaseDao;

import ${basepackage}.common.pojo.${moduleName}.${className};

import org.jsoup.helper.Validate;

import java.util.List;


/**
 * ${table.tableAlias}Dao
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午3:08
 */
public interface ${className}DaoBase<T> extends BaseDao<${className},String> {

    /**
     * 根据${classNameLower}分页模糊查找${table.tableAlias}列表信息
     * @param page		分页对象
     * @param obj ${table.tableAlias}
     * @return
     */
    public Page findByParams(Page page, T obj);

    <#if noparent == "0"||noparent == "2"||noparent == "3">
    /**
     * 保存${table.tableAlias}信息
     * @param obj ${table.tableAlias}
     */
    public void saveObject(T obj);

    /**
     * 修改${table.tableAlias}信息
     * @param obj ${table.tableAlias}
     */
    public void update(T obj);

    /**
     * 删除${table.tableAlias}信息
     * @param id
     */
    public void delete(<#if priSqlType=="NUMBER">Long<#else>String</#if> id );
    /**
     * 批量删除${table.tableAlias}信息
     * @param ids 主键列表,用逗号分隔
     */
    public void deleteIds(String ids );
    </#if>
    /**
     * 根据id${table.tableAlias}信息
     * @param id
     */
    public T getObject(<#if priSqlType=="NUMBER">Long<#else>String</#if> id );

    /**
     * 根据${classNameLower}获取${table.tableAlias}对象列表信息
     * @param obj
     */
    public List<T> listByParams(T obj);

    /**
     * 根据${classNameLower}获取${table.tableAlias}对象列表信息(精确匹配)
     * @param obj
     */
    public List<T> listEquals(T obj);
}

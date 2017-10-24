<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign inherittableLower = inherittable?uncap_first>
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
package ${basepackage}.common.dao.${moduleName}.impl.base;

import cn.com.xcs.framework.persist.Page;

import cn.ibm.dao.impl.BaseDaoImpl;

import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.common.dao.${moduleName}.base.${className}DaoBase;

import org.apache.commons.lang.StringUtils;

import org.jsoup.helper.Validate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import cn.ibm.utils.UNID;
import cn.com.xcs.framework.utils.UUIDUtils;

<#if noparent == "3">
import ${basepackage}.common.utils.BeanUtils;
import ${basepackage}.common.pojo.${moduleName}.${inherittable};
import java.lan.reflect.InvocationTargetException;
</#if>
/**
 * ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午3:12
 */
@Repository
public class ${className}DaoImplBase<T> extends BaseDaoImpl<${className}, String> implements ${className}DaoBase<T> {

    @Override
    public Page findByParams(Page page, T obj) {
        ${className} ${classNameLower}= (${className})obj;
        StringBuffer hql=new StringBuffer("from ${className} p where 1=1 ");
        Map<String,String> params=new HashMap<String,String>();
        <@generateDecide/>
        hql.append(" order by p.createtime desc ");
        
        return this.findByPage(page, hql.toString(), params);
    }

    <#if noparent == "0"||noparent == "2"||noparent == "3">
    public void saveObject(T obj) {
        ${className} ${classNameLower}= (${className})obj;
      if (${classNameLower}.get${pricolumnUp}()==null){
<#if priSqlType=="NUMBER">
        Long nextVal=UNID.next();
        ${classNameLower}.set${pricolumnUp}(nextVal);
<#else>
        ${classNameLower}.set${pricolumnUp}(UUIDUtils.creatUUID());
</#if>
      }
<@generateNullField/>
        this.getHibernateTemplate().save(${classNameLower});
<#if noparent == "3">
        this.save${inherittable}(${classNameLower});
</#if>
    }


<#if noparent == "3">
    public void save${inherittable}(T obj) {
        ${className} ${classNameLower}= (${className})obj;
        ${inherittable} ${inherittableLower} = new ${inherittable}();
        try{
          BeanUtils.copyNoNullProperties(${inherittableLower},${classNameLower});
        } catch (IllegalAcessException e) {
          e.printStackTrace();
        } catch (InvocationTargetException e){
          e.printStackTrace();
        }
        
<#if priSqlType=="NUMBER">
        Long nextVal=UNID.next();
        ${inherittableLower}.set${pricolumnUp}(nextVal);
<#else>
         ${inherittableLower}.setId(UUIDUtils.creatUUID());
</#if>
        if (null!=${inherittableLower}.getId()){
           ${inherittableLower}.setSid(${classNameLower}.getId());
         }
        this.getHibernateTemplate().save(${inherittableLower});

    }
</#if>

    public void update(T obj) {
        ${className} ${classNameLower}= (${className})obj;
        this.save(${classNameLower});
<#if noparent == "3">
        this.save${inherittable}(${classNameLower});
</#if>
    }

    public void delete(<#if priSqlType=="NUMBER">Long<#else>String</#if> id) {
        ${className} ${classNameLower} = (${className})getObject(id);
        Validate.notNull(${classNameLower});
        this.delete(${classNameLower});
    }

    public void deleteIds(String ids) {
    	StringBuffer sql= new StringBuffer("update ${table.sqlName} t set t.deleteState=1,t.record_version = t.record_version + 1 where ");
    	Map<String,Object> params = new HashMap<String,Object>();
    	
    	String[] str= ids.split(",");
    	for (String s: str){
    		sql.append(" t.id ='" + s + "' or");
    	}
    	this.update(sql.toString().substring(0, sql.toString().lastIndexOf("or")),params);
<#if noparent == "3">
        for (String s: str){
            ${className} ${classNameLower} = get${className}(s);
            this.save${inherittable}(${classNameLower});
        }
</#if>
    }
    
    </#if>
    public T getObject(<#if priSqlType=="NUMBER">Long<#else>String</#if> id) {
        if (id == null){<#if priSqlType=="NUMBER">id=0l;<#else>id="";</#if>}
        String hql=new StringBuffer("from ${className} p where 1=1 and p.id = :id ").toString();
        Map<String,<#if priSqlType=="NUMBER">Long<#else>String</#if>> params=new HashMap<String,<#if priSqlType=="NUMBER">Long<#else>String</#if>>();
        params.put("id", id);
        List<${className}> list = this.find(hql,params);
        return list==null?null: (T) (list.isEmpty()?null:list.get(0));
    }

    public List<T> listByParams(T obj) {
        ${className} ${classNameLower}= (${className})obj;
        StringBuffer hql=new StringBuffer("from ${className} p where 1=1 ");
        Map<String,String> params=new HashMap<String,String>();
        <@generateDecide/>
        hql.append("order by p.createtime desc");
        return this.find(hql.toString(), params);
    }


    public List<T> listEquals(T obj) {
        ${className} ${classNameLower}= (${className})obj;
        StringBuffer hql=new StringBuffer("from ${className} p where 1=1 ");
        Map<String,String> params=new HashMap<String,String>();
        <@generateEquals/>
        hql.append("order by p.createtime desc");
        return this.find(hql.toString(), params);
    }
}
<#macro generateDecide>
	<#list table.columns as column>
		<#if !column.sqlName?starts_with("DEFINE") && !column.pk && column.javaType=="String">
        if(!StringUtils.isEmpty(${classNameLower}.get${column.columnName}())){
            hql.append(" and p.${column.columnName?uncap_first} like :${column.columnName?uncap_first} ");
            params.put("${column.columnName?uncap_first}", '%'+${classNameLower}.get${column.columnName}()+'%');
        }
		</#if>
	</#list>
</#macro>

<#macro generateNullField>
<#list table.columns as column>
<#if !column.pk>
        if (null==${classNameLower}.get${column.columnName}()){
        <#if column.javaType == "String">
            ${classNameLower}.set${column.columnName}("");
        <#elseif column.javaType == "BigDecimal">
        <#if column.sqlName == "RECORD_VERSION">
            ${classNameLower}.set${column.columnName}(0);
        <#else>
            ${classNameLower}.set${column.columnName}(BigDecimal.valueOf(0));
        </#if>
        <#elseif column.javaType == "Long">
        <#if column.sqlName == "RECORD_VERSION">
            ${classNameLower}.set${column.columnName}(0);
        <#else>
            ${classNameLower}.set${column.columnName}(0L);
        </#if>
        <#elseif column.javaType == "Boolean">
            ${classNameLower}.set${column.columnName}(false);
        </#if>
         }
</#if>
</#list>
</#macro>

<#macro generateEquals>
<#list table.columns as column>
<#if !column.sqlName?starts_with("DEFINE") && !column.pk >
    <#if column.javaType=="String">
        if(!StringUtils.isEmpty(${classNameLower}.get${column.columnName}())){
            hql.append(" and p.${column.columnName?uncap_first} = :${column.columnName?uncap_first} ");
            params.put("${column.columnName?uncap_first}", ${classNameLower}.get${column.columnName}());
        }
    </#if>
</#if>
</#list>
</#macro>
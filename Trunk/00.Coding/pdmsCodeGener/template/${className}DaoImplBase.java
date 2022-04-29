<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.dao.${moduleName}.impl;

import cn.com.xcs.framework.persist.Page;

import cn.cst.kcgl.common.dao.impl.BaseDaoImpl;

import ${basepackage}.common.pojo.${className};
import ${basepackage}.common.dao.${moduleName}.${className}DaoBase;

import org.apache.commons.lang.StringUtils;

import org.jsoup.helper.Validate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
/**
 * ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 下午3:12
 */
@Repository
public class ${className}DaoImplBase extends BaseDaoImpl<${className}, String> implements ${className}DaoBase {

    @Override
    public Page find${className}sByParams(Page page, ${className} ${classNameLower}) {
        
        StringBuffer hql=new StringBuffer("from ${className} p where 1=1 ");
        Map<String,String> params=new HashMap<String,String>();
        
        <@generateDecide/>
        hql.append(" order by p.createTime desc ");
        
        return this.findByPage(page, hql.toString(), params);
    }

    <#if noparent == "0"||noparent == "2">
    @Override
    public void save${className}(${className} ${classNameLower} ) {
        this.getHibernateTemplate().save(${classNameLower});
    }

    @Override
    public void update${className}(${className} ${classNameLower} ) {
        this.save(${classNameLower});
    }

    @Override
    public void delete${className}( String id ) {
        ${className} ${classNameLower} = get${className}(id);
        Validate.notNull(${classNameLower});
        this.delete(${classNameLower});
    }
    @Override
    public void deleteIds(String ids) {
    	StringBuffer sql= new StringBuffer("update ${table.sqlName} t set t.deleted='1',t.record_version = t.record_version + 1 where ");
    	Map<String,Object> params = new HashMap<String,Object>();
    	
    	String[] str= ids.split(",");
    	for (String s: str){
    		sql.append(" t.id ='" + s + "' or");
    	}
    	this.update(sql.toString().substring(0, sql.toString().lastIndexOf("or")),params);
    	
    }
    
    </#if>
    @Override
    public ${className} get${className}( String id ) {
        String hql=new StringBuffer("from ${className} p where 1=1 and p.id = :id ").toString();
        Map<String,String> params=new HashMap<String,String>();
        params.put("id", id);
        List<${className}> list = this.find(hql,params);
        return list==null?null:(list.isEmpty()?null:list.get(0));
    }

    @Override
    public List<${className}> ${classNameLower}sByParams(${className} ${classNameLower}) {

        StringBuffer hql=new StringBuffer("from ${className} p where 1=1 ");
        Map<String,String> params=new HashMap<String,String>();
        
        <@generateDecide/>
        hql.append("order by p.createTime desc");
        return this.find(hql.toString(), params);

    }
}
<#macro generateDecide>
	<#list table.columns as column>
	<#assign isComm = 0>	
		<#list commonfieldList as prop>        
			<#if column.columnNameLower == prop.name> 
				<#assign isComm = 1>      
			</#if>                  
		</#list>
		<#if !column.sqlName?starts_with("DEFINE") && !column.pk && isComm == 0 && column.javaType=="String">
	        if(!StringUtils.isEmpty(${classNameLower}.get${column.columnName}())){
	            hql.append(" and p.${column.columnName?uncap_first} like :${column.columnName?uncap_first} ");
	            params.put("${column.columnName?uncap_first}", '%'+${classNameLower}.get${column.columnName}()+'%');
	        }
	        
		</#if>
	</#list>
</#macro>

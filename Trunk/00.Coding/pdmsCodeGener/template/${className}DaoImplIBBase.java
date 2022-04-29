<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.dao.${moduleName}.impl;

import cn.com.xcs.framework.persist.Page;

import cn.cst.kcgl.common.dao.impl.BaseDaoImpl;

import ${basepackage}.common.pojo.${className};
import ${basepackage}.common.dao.${moduleName}.${className}DaoIBBase;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: wangjf
 * Date: 16-7-12
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ${className}DaoImplIBBase extends BaseDaoImpl<${className},String> implements ${className}DaoIBBase{
    /**
     * 根据ID获取对象
     * @param id  主键id
     * @return
     */
    public ${className} get${className}ById(String id){
    	Map<String,String> params=new HashMap<String,String>();
        params.put("id", id);
       return (${className}) this.queryOneBySql("${basepackage}.common.pojo.${classNameLower}Mapper.get${className}ById",params);
    }

    /**
     * 分页查询${table.tableAlias}对象
     * @param page
     * @return
     */
    public Page get${className}Page(Page page,${className} ${classNameLower}){
    	<@generate/>
        return this.queryForPage("${basepackage}.common.pojo.${classNameLower}Mapper.get${className}Page",params,page);
    }

    /**
     * 列表查询${table.tableAlias}对象
     * @param
     * @return
     */
    public List<${className}> get${className}List(${className} ${classNameLower}){
    	<@generate/>
        return (List<${className}>) this.queryBySql("${basepackage}.common.pojo.${classNameLower}Mapper.get${className}Page",params);
    }

    <#if noparent == "0"||noparent == "2">
    /**
     * 根据ID删除对象
     * @param id  主键id
     */
    public int delete${className}ById(String id){
    	Map<String,String> params=new HashMap<String,String>();
        params.put("id", id);
        return this.deleteBySql("${basepackage}.common.pojo.${classNameLower}Mapper.delete${className}ById",params);
    }

    /**
     * 新增${table.tableAlias}
     * @param ${classNameLower}   ${table.tableAlias}对象
     */
    public void save${className}(${className} ${classNameLower}){
    	<@generate/>
        this.createBySql("${basepackage}.common.pojo.${classNameLower}Mapper.save${className}",params);
    }

    /**
     * 更新${table.tableAlias}
     * @param ${classNameLower}     ${table.tableAlias}对象
     * @return
     */
    public int update${className}(${className} ${classNameLower}){
        <@generateUpdate/>
        return this.updateBySql("${basepackage}.common.pojo.${classNameLower}Mapper.update${className}",params);
    }
    </#if>
}
<#macro generate>
		Map<String,Object> params = new HashMap<String,Object>();
<#list table.columns as column>
		params.put("${column.columnName?uncap_first}",${classNameLower}.get${column.columnName}());//${column.columnAlias}
</#list>
</#macro>
<#macro generateUpdate>
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("id", ${classNameLower}.getId());
			
<#list table.columns as column>
		<#if !column.pk>
		if(null == ${classNameLower}.get${column.columnName}()){
			<#if column.javaType == "String">
			params.put("${column.columnName?uncap_first}", "");//${column.columnAlias}
			<#else>
			params.put("${column.columnName?uncap_first}", 0);//${column.columnAlias}
			</#if>
		}else{
			params.put("${column.columnName?uncap_first}",${classNameLower}.get${column.columnName}());//${column.columnAlias}
		}
		</#if>
</#list>
</#macro>

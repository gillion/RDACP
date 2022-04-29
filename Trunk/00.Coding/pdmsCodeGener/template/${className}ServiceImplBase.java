<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.service.${moduleName}.impl;

import cn.com.xcs.framework.persist.Page;

import cn.cst.kcgl.common.shiro.BusinessShiroUtils;
import cn.cst.kcgl.common.service.impl.BaseServiceImpl;

import ${basepackage}.common.pojo.${className};
import ${basepackage}.common.dao.${moduleName}.${className}Dao;
import ${basepackage}.common.service.${moduleName}.${className}ServiceBase;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import cn.com.xcs.framework.utils.UUIDUtils;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ${className}ServiceImplBase extends BaseServiceImpl implements ${className}ServiceBase {

    @Resource
    private ${className}Dao ${classNameLower}Dao;
    /**
     * 分页模糊查找${table.tableAlias}列表信息

     * @param page		分页对象
     * @param ${classNameLower} ${table.tableAlias}
     * @return
     */
    public Page find${className}sByParams(Page page, ${className} ${classNameLower}){
        <#if noparent == "0">
        ${classNameLower}.setDeleted("0");
        </#if>
        return this.${classNameLower}Dao.find${className}sByParams(page,${classNameLower});
    }

    <#if noparent == "0"||noparent == "2">
    /**
     * 保存${table.tableAlias}信息
     * @param ${classNameLower} ${table.tableAlias}
     */
    public void save${className}(${className} ${classNameLower},int ... noMakeId){
        <#if noparent == "0">
        if ((noMakeId.length>0)&&(noMakeId[0]==1)){  	
        	
        } else {
        	${classNameLower}.setId(UUIDUtils.creatUUID());// 添加主键              	
        }
        ${classNameLower}.setDeleted("0");
        ${classNameLower}.setCreateTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        ${classNameLower}.setRecordVersion(1);
        ${classNameLower}.setCreator(BusinessShiroUtils.getUserId());
        ${classNameLower}.setCreateOffice(BusinessShiroUtils.getOrgId());
        </#if>
        this.${classNameLower}Dao.save${className}(${classNameLower});
    }

    /**
     * 修改${table.tableAlias}信息
     * @param ${classNameLower} ${table.tableAlias}
     */
    public void update${className}(${className} ${classNameLower} ){
        <#if noparent == "0">
        ${className} ${classNameLower}1 = null;
        ${classNameLower}1 = this.get${className}(${classNameLower}.getId());
        while (${classNameLower}1.getRecordVersion() != ${classNameLower}.getRecordVersion()){
            ${classNameLower}.setRecordVersion(${classNameLower}1.getRecordVersion());
            ${classNameLower}1 = this.get${className}(${classNameLower}.getId());
            if(${classNameLower}1.getRecordVersion() == ${classNameLower}.getRecordVersion()){
                break;
            }
        }
        if(${classNameLower}1.getRecordVersion() == ${classNameLower}.getRecordVersion()){
        	if(${classNameLower}.getId()!=null){
                ${classNameLower}1.setId(${classNameLower}.getId());
            }
            if(${classNameLower}.getRecordVersion()!=null){
                ${classNameLower}1.setRecordVersion(${classNameLower}.getRecordVersion()+1);//当前数据版本号加1
            }
            ${classNameLower}1.setLastModifyTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));//修改时间

            if(BusinessShiroUtils.getUserId()!=null){
                ${classNameLower}1.setLastModifyor(BusinessShiroUtils.getUserId());//用户
            }
            if(BusinessShiroUtils.getOrgId()!=null){
                ${classNameLower}1.setLastModifyOffice(BusinessShiroUtils.getOrgId()); //修改组织
            }
            
            <@generateDecide/>
            
            this.${classNameLower}Dao.update${className}(${classNameLower}1);
        }
        
        <#else>
        	this.${classNameLower}Dao.update${className}(${classNameLower});        
        </#if>

    }
    
    /**
     * 删除${table.tableAlias}信息
     * @param id
     */
    public void delete${className}( String id ){
<#if noparent == "0">
        ${className} ${classNameLower} = null;
        ${classNameLower} = this.get${className}(id);
        ${classNameLower}.setDeleted("1");
        update${className}(${classNameLower});
</#if>
<#if noparent == "2">
        this.${classNameLower}Dao.delete${className}(id);
</#if>
    }

    /**
     * 删除${table.tableAlias}信息
     * @param id
     */
    public void deleteIds( String ids){
<#if noparent == "0">
		this.${classNameLower}Dao.deleteIds(ids);		
</#if>
<#if noparent == "2">
	String[] split = ids.split(",");
	for (String id: split){
        this.${classNameLower}Dao.delete${className}(id);		
	}
</#if>
    }
    </#if>

    /**
     * 根据id$获取{table.tableAlias}信息
     * @param id
     */
    public ${className} get${className}( String id ){
        return this.${classNameLower}Dao.get${className}(id);
    }

    /**
     * 根据${classNameLower}获取${table.tableAlias}对象列表信息
     * @param ${classNameLower}
     */
    public List<${className}> ${classNameLower}sByParams(${className} ${classNameLower}){
        return this.${classNameLower}Dao.${classNameLower}sByParams(${classNameLower});
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
	<#if !column.sqlName?starts_with("DEFINE") && !column.pk && isComm == 0>
			if(null != ${classNameLower}.get${column.columnName}()){
		        ${classNameLower}1.set${column.columnName}(${classNameLower}.get${column.columnName}());
		    }
	</#if>
</#list>
</#macro>

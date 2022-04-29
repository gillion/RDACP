<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.service.${moduleName}.impl;

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.utils.UUIDUtils;

import cn.cst.kcgl.common.shiro.BusinessShiroUtils;
import cn.cst.kcgl.common.service.impl.BaseServiceImpl;

import ${basepackage}.common.pojo.${className};
import ${basepackage}.common.dao.${moduleName}.${className}DaoIB;
import ${basepackage}.common.service.${moduleName}.${className}ServiceIBBase;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-7-13
 * Time: 下午2:32
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ${className}ServiceImplIBBase extends BaseServiceImpl implements ${className}ServiceIBBase {

    @Resource
    private ${className}DaoIB ${classNameLower}DaoIB;

    <#if noparent == "0"||noparent == "2">
    /**
     * 新增${table.tableAlias}
     * @param ${classNameLower}
     */
    @Override
    public void save${className}(${className} ${classNameLower}) {
    	${classNameLower}.setId(UUIDUtils.creatUUID());// 添加主键
        <#if noparent == "0">
        ${classNameLower}.setDeleted("0");
    	${classNameLower}.setCreateTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        ${classNameLower}.setRecordVersion(1);
        ${classNameLower}.setCreator(BusinessShiroUtils.getUserId());
        ${classNameLower}.setCreateOffice(BusinessShiroUtils.getOrgId());
        </#if>
        this.${classNameLower}DaoIB.save${className}(${classNameLower});
    }

    /**
     * 通过ID删除${table.tableAlias}
     * @param id
     * @return
     */
    @Override
    public int delete${className}ById(String id) {
<#if noparent == "0">
        ${className} ${classNameLower} = null;
        ${classNameLower} = this.get${className}ById(id);
        ${classNameLower}.setDeleted("1");
        return update${className}(${classNameLower});
</#if>
<#if noparent == "2">
        return this.${classNameLower}DaoIB.delete${className}ById(id);
</#if>
    }

    /**
     * 更新${table.tableAlias}
     * @param ${classNameLower}
     * @return
     */
    @Override
    public int update${className}(${className} ${classNameLower}) {
        <#if noparent == "0">
        ${className} ${classNameLower}1 = null;
        ${classNameLower}1 = this.${classNameLower}DaoIB.get${className}ById(${classNameLower}.getId());
        while (${classNameLower}1.getRecordVersion() != ${classNameLower}.getRecordVersion()){
            ${classNameLower}.setRecordVersion(${classNameLower}1.getRecordVersion());
            ${classNameLower}1 = this.${classNameLower}DaoIB.get${className}ById(${classNameLower}.getId());
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
            
            return this.${classNameLower}DaoIB.update${className}(${classNameLower}1);
        }
        <#else>
    		this.${classNameLower}DaoIB.update${className}(${classNameLower});        
    	</#if>
        
        return 0;
    }
    
	</#if>
    @Override
    public ${className} get${className}ById(String id) {
        return this.${classNameLower}DaoIB.get${className}ById(id);
    }

    /**
     * 分页查询${table.tableAlias}
     * @param page
     * @param ${classNameLower}
     * @return
     */
    @Override
    public Page get${className}Page(Page page, ${className} ${classNameLower}) {
        <#if noparent == "0">
        ${classNameLower}.setDeleted("0");
        </#if>
        return this.${classNameLower}DaoIB.get${className}Page(page,${classNameLower});
    }

    /**
     * 列表查询${table.tableAlias}
     * @param ${classNameLower}
     * @return
     */
    @Override
    public List<${className}> get${className}List(${className} ${classNameLower}) {
        <#if noparent == "0">
        ${classNameLower}.setDeleted("0");
        </#if>
        return this.${classNameLower}DaoIB.get${className}List(${classNameLower});
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
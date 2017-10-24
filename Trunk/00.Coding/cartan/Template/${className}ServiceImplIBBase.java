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
package ${basepackage}.common.service.${moduleName}.impl.base;

import cn.com.xcs.framework.persist.Page;
import cn.ibm.utils.UNID;
import cn.com.xcs.framework.utils.UUIDUtils;

import cn.ibm.shiro.BusinessShiroUtils;
import cn.ibm.service.impl.BaseServiceImpl;

import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.common.dao.${moduleName}.${className}DaoIB;
import ${basepackage}.common.service.${moduleName}.base.${className}ServiceIBBase;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-13
 * Time: 下午2:32
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ${className}ServiceImplIBBase extends BaseServiceImpl implements ${className}ServiceIBBase {

    @Resource
    private ${className}DaoIB ${classNameLower}DaoIB;

    <#if noparent == "0">
    /**
     * 新增${table.tableAlias}
     * @param ${classNameLower}
     */
    @Override
    public void save${className}(${className} ${classNameLower}) {    	
<#if priSqlType=="NUMBER">
      Long nextVal=UNID.next();
      ${classNameLower}.set${pricolumnUp}(nextVal);
<#else>
      ${classNameLower}.set${pricolumnUp}(UUIDUtils.creatUUID());
</#if>
        <#if noparent == "0">
        ${classNameLower}.setDeletestate("0");
    	${classNameLower}.setCreatetime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        ${classNameLower}.setRecordVersion(1);
        ${classNameLower}.setCreater(BusinessShiroUtils.getUserId());
        </#if>
        this.${classNameLower}DaoIB.save${className}(${classNameLower});
    }

    /**
     * 通过ID删除${table.tableAlias}
     * @param id
     * @return
     */
    @Override
    public int delete${className}ById(<#if priSqlType=="NUMBER">Long<#else>String</#if> id) {
        ${className} ${classNameLower} = null;
        ${classNameLower} = this.get${className}ById(id);
        ${classNameLower}.setDeletestate("1");
        return update${className}(${classNameLower});
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
            ${classNameLower}1.setEdittime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));//修改时间

            if(BusinessShiroUtils.getUserId()!=null){
                ${classNameLower}1.setEditer(BusinessShiroUtils.getUserId());//用户
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
    public ${className} get${className}ById(<#if priSqlType=="NUMBER">Long<#else>String</#if> id) {
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
        ${classNameLower}.setDeletestate("0");
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
        ${classNameLower}.setDeletestate("0");
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
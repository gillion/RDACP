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
package ${basepackage}.common.service.${moduleName}.impl.base;

import cn.com.xcs.framework.persist.Page;

import cn.ibm.shiro.BusinessShiroUtils;
import cn.ibm.service.impl.BaseServiceImpl;

import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.common.dao.${moduleName}.${className}Dao;
import ${basepackage}.common.service.${moduleName}.base.${className}ServiceBase;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import cn.ibm.utils.UNID;
import cn.com.xcs.framework.utils.UUIDUtils;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ${className}ServiceImplBase<T> extends BaseServiceImpl implements ${className}ServiceBase<T> {

    @Resource
    private ${className}Dao<T> ${classNameLower}Dao;
    /**
     * 分页模糊查找${table.tableAlias}列表信息

     * @param page		分页对象
     * @param obj ${table.tableAlias}
     * @return
     */
    public Page findByParams(Page page, T obj){
        ${className} ${classNameLower}= (${className})obj;
        <#if noparent == "0">
        ${classNameLower}.setDeletestate("0");
        </#if>
        return this.${classNameLower}Dao.findByParams(page,(T) ${classNameLower});
    }

    <#if noparent == "0"||noparent == "2">
    /**
     * 保存${table.tableAlias}信息
     * @param obj ${table.tableAlias}
     * @param saveParam 1:不生成主键， 0或其他（2,3,4,5,6……）：生成主键
     */
    public void save(T obj,int ... saveParam){
        ${className} ${classNameLower}= (${className})obj;
        <#if noparent == "0"||noparent == "3">
        if ((saveParam.length>0)&&(saveParam[0]==1)){
        	
        } else {
        	
<#if priSqlType=="NUMBER">
          Long nextVal=UNID.next();
          ${classNameLower}.set${pricolumnUp}(nextVal);
<#else>
          ${classNameLower}.set${pricolumnUp}(UUIDUtils.creatUUID());
</#if>           	
        }
        ${classNameLower}.setDeletestate("0");
        ${classNameLower}.setCreatetime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        ${classNameLower}.setRecordVersion(1);
        ${classNameLower}.setCreater(BusinessShiroUtils.getUserId());
        </#if>
        this.${classNameLower}Dao.saveObject((T) ${classNameLower});
    }

    /**
     * 修改${table.tableAlias}信息
     * @param obj ${table.tableAlias}
     */
    public void update(T obj){
        <#if noparent == "0">
        ${className} ${classNameLower}= (${className})obj;
        ${className} ${classNameLower}1 = null;
        ${classNameLower}1 = (${className})this.getObject(${classNameLower}.getId());
        while (${classNameLower}1.getRecordVersion() != ${classNameLower}.getRecordVersion()){
            ${classNameLower}.setRecordVersion(${classNameLower}1.getRecordVersion());
            ${classNameLower}1 = (${className})this.getObject(${classNameLower}.getId());
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
            
            this.${classNameLower}Dao.update((T) ${classNameLower}1);
        }
        
        <#else>
        	this.${classNameLower}Dao.update((T) ${classNameLower});
        </#if>

    }
    
    /**
     * 删除${table.tableAlias}信息
     * @param id
     */
    public void delete( <#if priSqlType=="NUMBER">Long<#else>String</#if> id ){
<#if noparent == "0">
        ${className} ${classNameLower} = null;
        ${classNameLower} = (${className})this.getObject(id);
        ${classNameLower}.setDeletestate("1");
        update((T) ${classNameLower});
</#if>
<#if noparent == "2">
        this.${classNameLower}Dao.delete(id);
</#if>
    }

    /**
     * 删除${table.tableAlias}信息
     * @param ids
     */
    public void deleteIds( String ids){
<#if noparent == "0">
		this.${classNameLower}Dao.deleteIds(ids);		
</#if>
<#if noparent == "2">
	String[] split = ids.split(",");
	for (String id: split){
        this.${classNameLower}Dao.delete(id);
	}
</#if>
    }
    </#if>

    /**
     * 根据id$获取{table.tableAlias}信息
     * @param id
     */
    public T getObject(<#if priSqlType=="NUMBER">Long<#else>String</#if> id){
        return this.${classNameLower}Dao.getObject(id);
    }

    /**
     * 根据${classNameLower}获取${table.tableAlias}对象列表信息
     * @param obj
     */
    public List<T> listByParams(T obj){
        return this.${classNameLower}Dao.listByParams(obj);
    }
    /**
     * 根据${classNameLower}获取${table.tableAlias}对象列表信息(精确匹配)
     * @param obj
     */
    public List<T> listEquals(T obj){
            return this.${classNameLower}Dao.listEquals(obj);
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

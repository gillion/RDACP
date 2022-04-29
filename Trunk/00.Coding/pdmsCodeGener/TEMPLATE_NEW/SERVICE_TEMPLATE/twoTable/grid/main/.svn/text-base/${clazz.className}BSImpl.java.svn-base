<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.service.impl.${moduleName};

import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.service.common.BaseBSImpl;
import ${basepackage}.service.${moduleName}.${className}BS;
<#list subClazzes as subClazz>
import ${basepackage}.data.bo.${moduleName}.${subClazz.className};
import ${basepackage}.service.${moduleName}.${subClazz.className}BS;
</#list>
import com.fkframe.query.PageData;
import com.fkframe.query.SqlBuilder;
import com.fkframe.query.SqlBuilder.ParameType;
import com.fkframe.utils.Util;
import com.fkframe.exception.ValidateRuntimeException;
import org.slf4j.Logger;
import ${basepackage}.common.Globals;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/**
*
*${entityCnName} SERVICE接口 实现类
*
*/
public class ${className}BSImpl extends BaseBSImpl implements ${className}BS{
	/*******子表service*********/
	<#list subClazzes as subClazz>
	private ${subClazz.className}BS ${subClazz.className?uncap_first}BS;
	
	public void set${subClazz.className}BS(${subClazz.className}BS ${subClazz.className?uncap_first}BS) {
		this.${subClazz.className?uncap_first}BS = ${subClazz.className?uncap_first}BS;
	}
	
	</#list>
	
	/*******查询*****************************************/
	protected String SQL_QUERY_VO = ${className}VO.QUERY_SQL;
	@Override
	public Long generateId() {
		return super.getNextSequence("SEQ_${clazz.underLineName?upper_case}");
	}
	
	@Override
	public ${className}VO queryVOById(Long id){
		String sql = SQL_QUERY_VO+ " where obj.${clazz.pkProperty.columnName?lower_case}  = ? ";
		return queryForBean(${className}VO.class,sql ,new Object[]{id});
	}
	
	@Override
	public PageData queryVOPage(Map<String,?> queryParams,Integer pageNo){
		SqlBuilder builder = new SqlBuilder(${className}VO.class,SQL_QUERY_VO,queryParams);
		builder.setPageNo(pageNo);
		
		<#list clazz.properties as prop>
		 <#if (!prop.name?ends_with("remark")) && prop.name != "versionNo" && prop.name != "class">
		 <#if prop.asType == 'Date'>	
		 builder.addDateInCondition("${prop.name}_start","${prop.name}_end", "obj.${prop.columnName?lower_case}",ParameType.DATE);
		 <#elseif prop.name?ends_with("Id")>
		 builder.addCondition("${prop.name}", "obj.${prop.columnName?lower_case}",ParameType.LONG);
		 <#else>
		 builder.addCondition("${prop.name}", "obj.${prop.columnName?lower_case}");
		 </#if>
		 </#if>
		</#list>
		return (PageData)super.queryBySqlBuilder(builder);
	}
	
	
	/*******edit*****************************************/
	@Override
	public ${className} add${className}(${className} entity<#list subClazzes as subClazz>,List<${subClazz.className}> ${subClazz.className?uncap_first}AddList</#list>) throws Exception{
		//1保存主表
		super.saveObject(entity);
		//2保存明细
		Long orderId= entity.get${clazz.pkProperty.name?cap_first}();
		<#list subClazzes as subClazz>
		//${subClazz.className}
		if(${subClazz.className?uncap_first}AddList!=null&&!${subClazz.className?uncap_first}AddList.isEmpty()){
			for(${subClazz.className} po : ${subClazz.className?uncap_first}AddList){
				po.set${subClazz.fkProperty.name?cap_first}(orderId);
			}
			${subClazz.className?uncap_first}BS.saveOrUpdate${subClazz.className}s(${subClazz.className?uncap_first}AddList,null,null);
		}
		
		</#list>
		return entity;
	}
	
	@Override
	public ${className} modify${className}(${className} entity<#list subClazzes as subClazz>,List<${subClazz.className}>[] ${subClazz.className?uncap_first}Lists</#list>)throws Exception{
		//1保存主表
		super.updateObject(entity);
		
		Long orderId= entity.get${clazz.pkProperty.name?cap_first}();
		<#list subClazzes as subClazz>
		//保存${subClazz.className}
		if(${subClazz.className?uncap_first}Lists!=null&&${subClazz.className?uncap_first}Lists.length>0){
			List<${subClazz.className}> addList =${subClazz.className?uncap_first}Lists[0];
			List<${subClazz.className}> updList =${subClazz.className?uncap_first}Lists.length > 1?${subClazz.className?uncap_first}Lists[1]:null;
			List<${subClazz.className}> delList =${subClazz.className?uncap_first}Lists.length > 2?${subClazz.className?uncap_first}Lists[2]:null;
			if(addList!=null&&!addList.isEmpty()){
				for(${subClazz.className} po : addList){
					po.set${subClazz.fkProperty.name?cap_first}(orderId);
				}
			}
			${subClazz.className?uncap_first}BS.saveOrUpdate${subClazz.className}s(addList,updList,delList);
			addList.clear();addList = null;
			updList.clear();updList = null;
			delList.clear();delList = null;
		}
		</#list>
		return entity;
	}
	
	@Override
	public void del${className}(${className} entity) throws Exception{
		//1主表删除
		deleteObject(entity);
		//2 明细表
		<#list subClazzes as subClazz>
		${subClazz.className?uncap_first}BS.deleteByParentId(entity.get${clazz.pkProperty.name?cap_first}());
		</#list>
	}
	
	@Override
	public void del${className}ByIds(Long... ids) throws Exception{
		for(Long id:ids){
			${className} entity = getById(${className}.class,id);
			if(entity!=null)del${className}(entity);
		}
	}
	
	@Override
	public ${className} audit${className}(Long id,boolean auditFlag) throws Exception{
		${className} obj = getById(${className}.class,id);
		if(auditFlag){
			obj.setState(Globals.STATE_AUDITED);
		}else{
			obj.setState(Globals.STATE_AUDITED_UNDO);
		}
		updateObject(obj);
		return obj;
	}
	
	@Override
	protected void validateAdd(Object obj) throws ValidateRuntimeException{}
	@Override
	protected void validateModify(Object obj) throws ValidateRuntimeException{}
	@Override
	protected void validateDelete(Object obj) throws ValidateRuntimeException{}
}
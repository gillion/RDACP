<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.service.impl.${moduleName};
import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.service.common.BaseBSImpl;
import ${basepackage}.service.${moduleName}.${className}BS;
import ${basepackage}.common.Globals;
import com.fkframe.query.PageData;
import com.fkframe.query.SqlBuilder;
import com.fkframe.exception.ValidateRuntimeException;
<#list subClazzes as subClazz>
import ${basepackage}.service.${moduleName}.${subClazz.className}BS;
</#list>
import java.util.Map;

import com.fkframe.persist.TempOrderBS;

/**
 *${entityCnName} SERVICE接口 实现类
 *
 */
public class ${className}BSImpl extends BaseBSImpl implements ${className}BS{
	
	protected String SQL_QUERY_VO = ${className}VO.QUERY_SQL;
	
	//临时表
	private TempOrderBS tempOrderBS;
	public void setTempOrderBS(TempOrderBS tempOrderBS) {
		this.tempOrderBS = tempOrderBS;
	}
	
	<#list subClazzes as subClazz>
	private ${subClazz.className}BS ${subClazz.className?uncap_first}BS;
	public void set${subClazz.className}BS(${subClazz.className}BS ${subClazz.className?uncap_first}BS) {
		this.${subClazz.className?uncap_first}BS = ${subClazz.className?uncap_first}BS;
	}
	
	</#list>
	@Override
	public Long generateId() {
		return super.getNextSequence("SEQ_${clazz.underLineName?upper_case}");
	}
	@Override
	public ${className}VO queryVOById(Long id){
		String sql = SQL_QUERY_VO;
		SqlBuilder builder = new SqlBuilder(${className}VO.class,sql,null);
		builder.addSqlCondition(" obj.${clazz.pkProperty.columnName?lower_case}  = ?  ", id);
		return (${className}VO)queryUnique(builder);
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
	
	@Override
	public void del${className}(${className} entity) throws Exception{
		deleteObject(entity);
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
	public ${className} add${className}(${className} entity,Long operSeriaNo) throws Exception{
		saveObject(entity);
		saveOrUpdateChildren(entity,operSeriaNo);
		tempOrderBS.deleteBySerialNo(operSeriaNo);
		return entity;
	}
	
	@Override
	public ${className} modify${className}(${className} entity,Long operSeriaNo) throws Exception{
		updateObject(entity);
		saveOrUpdateChildren(entity,operSeriaNo);
		tempOrderBS.deleteBySerialNo(operSeriaNo);
		return entity;
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
	
	private void saveOrUpdateChildren(${className} entity,Long operSeriaNo) throws Exception {
		<#list subClazzes as subClazz>
		${subClazz.className?uncap_first}BS.saveOrUpdateByParent(entity,operSeriaNo);
		</#list>
	}
	
	@Override
	public void copyDetailsToTemp(Long orderId,Long operSeriaNo) throws Exception{
		<#list subClazzes as subClazz>
		${subClazz.className?uncap_first}BS.copyToTemp(orderId, operSeriaNo);
		</#list>
	}
	
	
	@Override
	protected void validateAdd(Object obj) throws ValidateRuntimeException{}
	@Override
	protected void validateModify(Object obj) throws ValidateRuntimeException{}
	@Override
	protected void validateDelete(Object obj) throws ValidateRuntimeException{}
}
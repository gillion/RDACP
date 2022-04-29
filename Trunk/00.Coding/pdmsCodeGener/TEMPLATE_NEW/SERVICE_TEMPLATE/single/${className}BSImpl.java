<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.service.impl.${moduleName};
import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.service.common.BaseBSImpl;
import ${basepackage}.service.${moduleName}.${className}BS;
import com.fkframe.query.PageData;
import com.fkframe.query.SqlBuilder;
import com.fkframe.query.SqlBuilder.ParameType;
import com.fkframe.exception.ValidateRuntimeException;

import java.util.List;
import java.util.Map;

/**
 *${entityCnName} SERVICE接口 实现类
 *
 */
public class ${className}BSImpl extends BaseBSImpl implements ${className}BS{
	
	public  final String SQL_QUERY_VO = ${className}VO.QUERY_SQL;
	
	public ${className}VO queryVOById(Long id){
		String sql = SQL_QUERY_VO+
			" where obj.${tableid?lower_case}  = ? ";
		return super.queryForBean(${className}VO.class,sql ,new Object[]{id});
	}
	
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
	
	public List<${className}VO> queryVOByParam(Map<String,?> queryParams){
		SqlBuilder builder = new SqlBuilder(${className}VO.class,SQL_QUERY_VO,queryParams);
		builder.setListType(SqlBuilder.LIST_TYPE_LIST);
		
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
		return (List<${className}VO>)super.queryBySqlBuilder(builder);
	}

	
	@Override
	public void validateAdd(Object obj) throws ValidateRuntimeException{}
	@Override
	public void validateModify(Object entity) throws ValidateRuntimeException{}
	@Override
	public void validateDelete(Object entity) throws ValidateRuntimeException{}

}


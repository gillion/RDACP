<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign fatherClassName = fatherClazz.className>   
<#assign fatherClassNameLower = fatherClassName?uncap_first>
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
import com.fkframe.query.SqlBuilder.ParameType;
import com.fkframe.utils.Util;
import com.fkframe.exception.ValidateRuntimeException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;

public class ${className}BSImpl extends BaseBSImpl implements ${className}BS{
	//查询
	protected String SQL_QUERY_VO = ${className}VO.QUERY_SQL;
	
	@Override
	public Long generateId() {
		return super.getNextSequence("SEQ_${clazz.underLineName?upper_case}");
	}
	
	@Override
	public ${className}VO queryVOById(Long id){
		String sql = SQL_QUERY_VO+" where obj.${clazz.pkProperty.columnName?lower_case} = ? ";
		return queryForBean(${className}VO.class, sql, new Object[]{id});
	}
	
	@Override
	public List<${className}VO> queryVOByParentId(Long orderId) {
		String sql = SQL_QUERY_VO ;
		SqlBuilder builder = new SqlBuilder(${className}VO.class,sql,null);
		builder.setListType(SqlBuilder.LIST_TYPE_LIST);
		<#list clazz.properties as prop>
		<#if prop.name = mainClazzId >
		builder.addSqlCondition(" obj.${prop.columnName?lower_case} = ?", orderId);
		</#if>
		</#list>
		return (List<${className}VO>)queryBySqlBuilder(builder);
	}
	
	@Override
	public PageData queryVOPageByParentId(Long orderId,Integer pageNo) {
		String sql = SQL_QUERY_VO ;
		SqlBuilder builder = new SqlBuilder(${className}VO.class,sql,null);
		builder.setPageNo(pageNo);
		<#list clazz.properties as prop>
		<#if prop.name = mainClazzId >
		builder.addSqlCondition(" obj.${prop.columnName?lower_case} = ?", orderId);
		</#if>
		</#list>
		builder.setOrderSql("order by obj.${clazz.pkProperty.columnName?lower_case} desc");
		return (PageData)queryBySqlBuilder(builder);
	}
	//8888888888888888888888888888end 查询8888888888888888888888888888//
	
	
	/*************************************edit**************************/
	/**
	 * 根据主表id删除数据
	 */
	@Override
	public void deleteByParentId(Long ${mainClazzId}) throws Exception{
		String delHql = "delete from ${basepackage}.data.bo.${moduleName}.${className} obj where obj.${mainClazzId} = ? ";
		int debugnum =super.executeHql(delHql, new Object[]{${mainClazzId}});
		logger.debug("删除了"+debugnum);
	}
	
	/**
	 * 
	 * @param addList新增的数据
	 * @param updList修改的数据
	 * @param delList删除的数据
	 * @throws Exception
	 */
	public void saveOrUpdate${className}s(List<${className}> addList,List<${className}> updList,List<${className}> delList) throws Exception{
		if(addList!=null&&!addList.isEmpty()){//新增
			for(${className} po : addList){
				add${className}(po);
			}
		}
		if(updList!=null&&!updList.isEmpty()){//编辑
			for(${className} po : updList){
				 modify${className}(po);
			}
		}
		if(delList!=null&&!delList.isEmpty()){//删除
			for(${className} po : delList){
				del${className}(po);
			}
		}
	}
	
	public ${className} add${className}(${className} entity) throws Exception{
		super.saveObject(entity);
		return entity;
	}
	
	public ${className} modify${className}(${className} entity)throws Exception{
		 super.updateObject(entity);
		 return entity;
	}
	
	public void del${className}ByIds(Long... ids)throws Exception{
		for(Long id:ids){
			${className} entity = getById(${className}.class,id);
			if(entity!=null)del${className}(entity);
		}
	}
	
	public void del${className}(${className} entity)throws Exception{
		super.deleteObject(entity);
	}
}
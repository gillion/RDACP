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
<#list subClazzes as subClazz>
import ${basepackage}.data.bo.${moduleName}.${subClazz.className};
import ${basepackage}.service.${moduleName}.${subClazz.className}BS;
</#list>

import com.fkframe.persist.po.TempOrder;
import com.fkframe.persist.TempOrderBS;
import com.fkframe.query.PageData;
import com.fkframe.query.SqlBuilder;
import com.pdms.data.vo.tobacco.TcPickInStockDtlVO;

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
	
	protected String SQL_QUERY_VO = ${className}VO.QUERY_SQL;
	
	//临时表
	private TempOrderBS tempOrderBS;
	public void setTempOrderBS(TempOrderBS tempOrderBS) {
		this.tempOrderBS = tempOrderBS;
	}
	
	/*******子表service*********/
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
	//复制临时表到正式表
	@Override
	public void copyToTemp(Long ${mainClazzId},Long operSerialNo) throws Exception {
		copyToTempByHibernate(${mainClazzId},operSerialNo);
	}
	private void copyToTempByHibernate(Long ${mainClazzId},Long operSerialNo) throws Exception {
		List<${className}VO> result = queryVOByParentId(${mainClazzId});
		for(${className}VO vo :result){
			vo.setRowStauts(TempOrder.ROW_UNCHANGED);
			vo.setOperSerialNbr(operSerialNo);
			vo.setDetailType(${className}VO.DETAIL_TYPE);
			<#list subClazzes as subClazz>
			${subClazz.className?uncap_first}BS.copyToTemp(vo.get${clazz.pkProperty.name?cap_first}(), operSerialNo);
			</#list>
		}
		tempOrderBS.saveTempOrders(result);
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
	public ${className}VO queryVOById(Long id){
		String sql = SQL_QUERY_VO;
		SqlBuilder builder = new SqlBuilder(${className}VO.class,sql,null);
		builder.addSqlCondition(" obj.${clazz.pkProperty.columnName?lower_case} = ? ", id);
		return (${className}VO)queryUnique(builder);
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
	
	
	@Override
	public void saveOrUpdateByParent(${fatherClassName} ${fatherClassNameLower}, Long operSeriaNo) throws Exception{
		saveOrUpdateByHibernate(${fatherClassNameLower},operSeriaNo);
	}
	
	private void saveOrUpdateByHibernate(${fatherClassName} ${fatherClassNameLower}, Long operSeriaNo) throws Exception {
		//根据主表ID和操作序列号查出临时表数据
		Long ${mainClazzId}= ${fatherClassNameLower}.get${fatherClazz.pkProperty.name?cap_first}();
		List<${className}VO> vos = 
				tempOrderBS.queryBySerialNo(operSeriaNo, ${className}VO.class,${className}VO.DETAIL_TYPE,false);
		//根据临时表数据更新真实表数据
		if(vos!=null&&!vos.isEmpty()){
			for(${className}VO vo : vos){
				if(vo.getRowStauts().equals(TempOrder.ROW_ADDED)){
					${className} addPO = vo.cloneBO();
					addPO.set${mainClazzId?cap_first}(${mainClazzId});
					addPO.set${clazz.pkProperty.name?cap_first}(null);
					add${className}(addPO,operSeriaNo,vo.getKeyNum());
				}else if(vo.getRowStauts().equals(TempOrder.ROW_DELETED)){
					del${className}ByIds(vo.get${clazz.pkProperty.name?cap_first}());
				}else if(vo.getRowStauts().equals(TempOrder.ROW_MODIFYED)){
					${className} updPO = getById(${className}.class,vo.get${clazz.pkProperty.name?cap_first}());
					vo.copyValueTo(updPO);
					modify${className}(updPO,operSeriaNo);
				}
			}
		}
	}
	
	/**
	 * 根据主表id删除数据
	 */
	@Override
	public void deleteByParentId(Long ${mainClazzId}) throws Exception{
		/*String delHql = "delete from ${basepackage}.data.bo.${moduleName}.${className} obj where obj.${mainClazzId} = ? ";
		int debugnum =super.executeHql(delHql, new Object[]{${mainClazzId}});
		logger.debug("删除了"+debugnum);
		String hql = "${basepackage}.data.bo.${moduleName}.${className} obj where obj.${mainClazzId} = ?";
		List<${className}> objs = super.findByHql(hql,new Object[]{${mainClazzId}});
		for(${className} bo : objs){
			del${className}(bo);
		}
		*/
		List<${className}VO> entityList = queryVOByParentId(${mainClazzId});
		for (${className}VO entity:entityList){
			${className} delPO = entity.cloneBO();
			del${className}(delPO);
		}
	}
	
	private void del${className}(${className} entity) throws Exception{
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
	public ${className} add${className}(${className} entity,Long operSeriaNo,Long keyNum) throws Exception{
		saveObject(entity);
		<#if (subClazzes?size > 0)>
		saveOrUpdateChildren(entity,operSeriaNo,keyNum);
		</#if>
		return entity;
	}
	
	@Override
	public ${className} modify${className}(${className} entity,Long operSeriaNo) throws Exception{
		updateObject(entity);
		<#if (subClazzes?size > 0)>
		saveOrUpdateChildren(entity,operSeriaNo,entity.get${clazz.pkProperty.name?cap_first}());
		</#if>
		return entity;
	}
	
	<#if (subClazzes?size > 0)>
	private void saveOrUpdateChildren(${className} entity,Long operSeriaNo,Long id) throws Exception {
		<#list subClazzes as subClazz>
		${subClazz.className?uncap_first}BS.saveOrUpdateByParent(entity,operSeriaNo,id);
		</#list>
	}
	</#if>
}
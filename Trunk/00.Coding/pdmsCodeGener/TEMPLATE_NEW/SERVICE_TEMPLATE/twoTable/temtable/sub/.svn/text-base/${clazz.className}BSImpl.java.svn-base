<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign fatherClassName = fatherClazz.className>   
<#assign fatherClassNameLower = fatherClassName?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.service.impl.${moduleName};
import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.bo.${moduleName}.${fatherClassName};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.service.common.BaseBSImpl;
import ${basepackage}.service.${moduleName}.${className}BS;


import com.fkframe.query.PageData;
import com.fkframe.query.SqlBuilder;
import com.fkframe.persist.TempOrderBS;
import com.fkframe.persist.po.TempOrder;

import java.util.List;

public class ${className}BSImpl extends BaseBSImpl implements ${className}BS{
	//查询
	protected String SQL_QUERY_VO = ${className}VO.QUERY_SQL;
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
			${subClazz.className?uncap_first}BS.copyToTemp(vo.get${clazz.pkProperty.columnName?lower_case}(), operSerialNo);
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
		String sql = SQL_QUERY_VO + " where obj.${clazz.pkProperty.columnName?lower_case} = ?   ";
		return queryForBean(${className}VO.class, sql, new Object[]{id});
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
		List<${className}VO> vos = tempOrderBS.queryBySerialNo(operSeriaNo, ${className}VO.class,${className}VO.DETAIL_TYPE,false);
		//根据临时表数据更新真实表数据
		if(vos!=null&&!vos.isEmpty()){
			for(${className}VO vo : vos){
				if(vo.getRowStauts().equals(TempOrder.ROW_ADDED)){
					${className} addPO = vo.cloneBO();
					//由于临时表实际是存储orderId（实际主键）和detailId（明细id）而不是映射的字段（被设置为不存储，取值相应从order和detailI的取值）
					//这里需要赋值
					addPO.set${mainClazzId?cap_first}(${mainClazzId});
					addPO.set${clazz.pkProperty.name?cap_first}(null);
					add${className}(addPO,operSeriaNo);
				}else if(vo.getRowStauts().equals(TempOrder.ROW_DELETED)){
					del${className}ByIds(vo.getDetailId());
				}else if(vo.getRowStauts().equals(TempOrder.ROW_MODIFYED)){
					${className} updPO = getById(${className}.class,vo.getDetailId());
					vo.copyValueTo(updPO);
					modify${className}(updPO,operSeriaNo);
				}
			}
		}
	}
	
	
	public void saveOrUpdateTemList(List<${className}VO>[] lists) throws Exception{
		if(lists!=null&&lists.length>0){
			<#list subClazzes as subClazz>
			List<${subClazz.className}VO> addList =lists[0];
			List<${subClazz.className}VO> updList =lists.length > 1?lists[1]:null;
			List<${subClazz.className}VO> delList =lists.length > 2?lists[2]:null;
			
			if(addList!=null&&!addList.isEmpty()){//新增
				tempOrderBS.addInvOrderDetails(addList);
			}
			if(updList!=null&&!updList.isEmpty()){//编辑
				tempOrderBS.modifyInvOrderDetails(objList) 
			}
			if(delList!=null&&!delList.isEmpty()){//删除
				for(${className}VO vo : delList){
					tempOrderBS.delOrdersByIds(${className}VO.class,vo.getKeyNum());
				}
			}
			addList.clear();addList = null;
			updList.clear();updList = null;
			delList.clear();delList = null;
			</#list>
		}
	}
	
	
	/**
	 * 根据主表id删除数据
	 */
	@Override
	public void deleteByParentId(Long ${mainClazzId}) throws Exception{
		String delHql = "delete from ${basepackage}.data.bo.${moduleName}.${className} obj where obj.${mainClazzId} = ? ";
		int debugnum =super.executeHql(delHql, new Object[]{${mainClazzId}});
		logger.debug("删除了"+debugnum);
	}
	
	@Override
	public void del${className}(${className} entity) throws Exception{
		super.deleteObject(entity);
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
		<#if (subClazzes?size > 0)>
		saveOrUpdateChildren(entity,operSeriaNo);
		</#if>
		return entity;
	}
	
	@Override
	public ${className} modify${className}(${className} entity,Long operSeriaNo) throws Exception{
		updateObject(entity);
		<#if (subClazzes?size > 0)>
		saveOrUpdateChildren(entity,operSeriaNo);
		</#if>
		return entity;
	}
	
	<#if (subClazzes?size > 0)>
	private void saveOrUpdateChildren(${className} entity,Long operSeriaNo) throws Exception {
		<#list subClazzes as subClazz>
		${subClazz.className?uncap_first}BS.saveOrUpdateByParent(entity,operSeriaNo);
		</#list>
	}
	
	</#if>
}

<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.action.${moduleName};

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.fkframe.persist.TempOrderBS;
import com.fkframe.struts2.Struts2Utils;
import com.fkframe.tags.ui.grid.GridInfo;
import com.fkframe.tags.ui.grid.GridServerHandler;
import com.fkframe.utils.Util;
import com.fkframe.web.ScriptMessageUtil;
import ${basepackage}.action.common.BaseAction;
import ${basepackage}.data.vo.${moduleName}.${className}VO;
<#list subClazzes as subClazz>
import ${basepackage}.data.vo.${moduleName}.${subClazz.className}VO;
</#list>
import ${basepackage}.service.${moduleName}.${className}BS;
<#list subClazzes as subClazz>
import ${basepackage}.service.${moduleName}.${subClazz.className}BS;
</#list>

public class ${className}Action extends BaseAction  {
	
	private ${className}BS ${classNameLower}BS;
	public void set${className}BS(${className}BS ${classNameLower}BS) {this.${classNameLower}BS = ${classNameLower}BS;}
	//临时表
	private TempOrderBS tempOrderBS;
	public void setTempOrderBS(TempOrderBS tempOrderBS) {
		this.tempOrderBS = tempOrderBS;
	}
	<#if (subClazzes?size > 0)>
	<#list subClazzes as subClazz>
	private ${subClazz.className}BS ${subClazz.className?uncap_first}BS;
	public void set${subClazz.className}BS(${subClazz.className}BS ${subClazz.className?uncap_first}BS) {
		this.${subClazz.className?uncap_first}BS = ${subClazz.className?uncap_first}BS;
	}
	</#list>
	</#if>
	
	/**
	 *-- 页面属性  -- 
	 */
	private Long parentId;
	private ${className}VO entity;
	private List<${className}VO> entityList = new ArrayList();//页面列表显示
	<#if (subClazzes?size > 0)>
	<#list subClazzes as subClazz>
	private List<${subClazz.className}VO> ${subClazz.className?uncap_first}List = new ArrayList();
	private Map<Long,List<${subClazz.className}VO>> ${subClazz.className?uncap_first}ListMap = new HashMap();
	private GridInfo<${subClazz.className}VO> ${subClazz.className?uncap_first}GridInfo = null;
	</#list>
	</#if>
	
	
	//主表查询界面或者编辑界面需要关联查询的控件数据集（需要自己添加）
	private void initControllData(){};
	<#if (subClazzes?size > 0)>
	private void initGridInfo(){
		<#list subClazzes as subClazz>
		${subClazz.className}VO ${subClazz.className?uncap_first}VO = new ${subClazz.className}VO();
		${subClazz.className?uncap_first}GridInfo = new GridInfo<${subClazz.className}VO>(${subClazz.className?uncap_first}VO);
		</#list>
	}
	</#if>
	private void initNewVO(${className}VO vo){}//新增记录可以在这里赋值默认值,用于页面暂时
	private void initSaveVO(${className}VO vo){}//新增记录可以在这里赋值默认保存值（界面没有）
	
	/**
	 * -- 页面跳转--
	 */
	//TO 列表界面
	@Override
	public String list() throws Exception{
		try{
			entityList = tempOrderBS.queryBySerialNo(operSerialNo,${className}VO.class,${className}VO.DETAIL_TYPE,true);
			<#if (subClazzes?size > 0)>
			<#list subClazzes as subClazz>
			${subClazz.className?uncap_first}List = tempOrderBS.queryBySerialNo(operSerialNo,${subClazz.className}VO.class,${subClazz.className}VO.DETAIL_TYPE,true);
			${subClazz.className?uncap_first}ListMap = Util.createListMap(${subClazz.className?uncap_first}List, "orderId");//"${clazz.pkProperty.name}"
			</#list>
			</#if>
		}catch(Exception e){
			logger.error(e.getMessage(),e);//e.printStackTrace();
			addScriptMessage(ScriptMessageUtil.alertErro("查询失败: "+e.getMessage()));
		}finally{
			initControllData();
		}
		return SUCCESS;
	}
	/**
	 * 转到正式表的查看界面（不可编辑）
	 * @return
	 */
	public String listReal() {
		try{	
			entityList =${classNameLower}BS.queryVOByParentId(parentId);
			<#if (subClazzes?size > 0)>
			if(entityList!=null&&!entityList.isEmpty()){
				List<Long> orderIds = new ArrayList<Long>(entityList.size());
				for(${className}VO order : entityList){
					orderIds.add(order.get${clazz.pkProperty.name?cap_first}());
				}
				<#list subClazzes as subClazz> 
				${subClazz.className?uncap_first}List = ${subClazz.className?uncap_first}BS.queryVOByParentId(orderIds);
				${subClazz.className?uncap_first}ListMap = Util.createListMap(${subClazz.className?uncap_first}List, "${clazz.pkProperty.name}");
				</#list>
			}
			</#if>
		}catch(Exception e){
			logger.error(e.getMessage(),e);//e.printStackTrace();
			addScriptMessage(ScriptMessageUtil.alertErro("查询失败: "+e.getMessage()));
		}finally{
			initControllData();
		}
		return SUCCESS;
	}
	
	/**
	 * 正式表查看界面（不可编辑）
	 * @return
	 */
	public String viewReal(){
		try{
			if(StringUtils.isNotBlank(recordId)){
				entity = ${classNameLower}BS.queryVOById(Long.valueOf(recordId));
				<#if (subClazzes?size > 0)>
				if(entity!=null){
				<#list subClazzes as subClazz> 
					${subClazz.className?uncap_first}List = ${subClazz.className?uncap_first}BS.queryVOByParentId(entity.get${clazz.pkProperty.name?cap_first}());
					${subClazz.className?uncap_first}GridInfo = new GridInfo<${subClazz.className}VO>(${subClazz.className}VO.class);
					${subClazz.className?uncap_first}GridInfo.setData(${subClazz.className?uncap_first}List);
				</#list>
				}
				</#if>
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);//e.printStackTrace();
			addScriptMessage(ScriptMessageUtil.alertErro("查询失败: "+e.getMessage()));
			return listReal();
		}
		setPageEditable(false);
		initControllData();
		return INPUT;
	}
	
	//TO 新增货编辑界面（根据recordId判断）
	@Override
	public String input() throws Exception{
		if(StringUtils.isBlank(recordId)){//新增
			try{
				entity = new ${className}VO();
				entity.setOperSerialNbr(getOperSerialNo());
				entity.set${mainClazzId?cap_first}(parentId);//父节点id
				initNewVO(entity);
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
			}finally{
				func=FUNCTION_ADD;
				initControllData();
			}
		}else{//编辑
			try{
				Long rid = Long.valueOf(recordId);
				entity = tempOrderBS.queryByKeyNum(rid,${className}VO.class);
				entity.setOperSerialNbr(getOperSerialNo());
				<#if (subClazzes?size > 0)>
				initGridInfo();
				<#list subClazzes as subClazz> 
				${subClazz.className?uncap_first}List = tempOrderBS.queryBySerialNoAndParent(entity,operSerialNo,${subClazz.className}VO.class,${subClazz.className}VO.DETAIL_TYPE,true);
				${subClazz.className?uncap_first}GridInfo.setData(${subClazz.className?uncap_first}List);
				</#list>
				</#if>
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
			}finally{
				func=FUNCTION_EDIT;
				initControllData();	
			}
		}
		return INPUT;
	}
	
	/**
	 * --功能方法--
	 */
	//save()保存前调用
	@Override
	public void prepareSave() throws Exception{
		if(StringUtils.isNotBlank(recordId)){
			entity = tempOrderBS.queryByKeyNum(Long.valueOf(recordId), ${className}VO.class); 
		}else{
			if(entity == null){
				entity = new ${className}VO();
			}
		}
		entity.setOperSerialNbr(operSerialNo);
	}
	
	//保存新增或编辑的对象(recordId判断)
	@Override
	public String save() throws Exception{
		if(StringUtils.isBlank(recordId)){
			try{
				List[] paramList = null;
				<#if (subClazzes?size > 0)>
				<#list subClazzes as subClazz> 
				${subClazz.className?uncap_first}GridInfo=GridServerHandler.createGridInfo(request,"${subClazz.className?uncap_first}Grid",${subClazz.className}VO.class);
				</#list>
				paramList = new List[]{
				<#list subClazzes as subClazz> 
				${subClazz.className?uncap_first}GridInfo.getInsertedRecords()<#if subClazz_has_next>,</#if>
				</#list>
				};
				</#if>
				tempOrderBS.addOrderAndDtls(entity,paramList);
				addScriptMessage("alert('操作成功！');doAction('close');");
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
			}
		}else{
			try{
				List dtlsList = new ArrayList();
				<#if (subClazzes?size > 0)>
				<#list subClazzes as subClazz> 
				${subClazz.className?uncap_first}GridInfo=GridServerHandler.createGridInfo(request,"${subClazz.className?uncap_first}Grid",${subClazz.className}VO.class);
				List<${subClazz.className}VO>[] ${subClazz.className?uncap_first}gridList =  new List[]{
				${subClazz.className?uncap_first}GridInfo.getInsertedRecords(),${subClazz.className?uncap_first}GridInfo.getUpdatedRecords(),${subClazz.className?uncap_first}GridInfo.getDeletedRecords()};
				dtlsList.add(${subClazz.className?uncap_first}gridList);
				</#list>
				</#if>
				tempOrderBS.modifyOrderAndDtls(entity,dtlsList);
				addScriptMessage("alert('操作成功！');doAction('close');");
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
			}
		}
		initControllData();	
		return input();
	}
	
	//删除功能
	@Override
	public String delete() throws Exception{
		try{
			tempOrderBS.delByKeyNum(${className}VO.class,Long.valueOf(getRecordId()));
			Struts2Utils.renderText("删除成功！");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			Struts2Utils.renderText("操作失败:"+e.getMessage());
		}
		return null;
	}
	
	
	/**----getter and setter ----**/
	public ${className}VO getEntity() {
		return entity;
	}
	
	public void setEntity(${className}VO entity) {
		this.entity = entity;
	}
	
	public List<${clazz.className}VO> getEntityList() {
		return entityList;
	}
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	
	
	<#if (subClazzes?size > 0)>
	<#list subClazzes as subClazz> 
	public GridInfo<${subClazz.className}VO> get${subClazz.className}GridInfo() {
		return ${subClazz.className?uncap_first}GridInfo;
	}
	
	public List<${subClazz.className}VO> get${subClazz.className}List() {
		return ${subClazz.className?uncap_first}List;
	}
	
	public Map<Long, List<${subClazz.className}VO>> get${subClazz.className}ListMap() {
		return ${subClazz.className?uncap_first}ListMap;
	}
	</#list>
	</#if>
}
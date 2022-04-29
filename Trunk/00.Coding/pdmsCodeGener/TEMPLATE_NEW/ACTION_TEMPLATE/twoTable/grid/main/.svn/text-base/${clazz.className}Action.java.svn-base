<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.action.${moduleName};

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import ${basepackage}.action.common.BaseAction;

import com.fkframe.tags.right.RightManager;
import com.fkframe.tags.ui.grid.GridInfo;
import com.fkframe.utils.CollectionUtil;
import com.fkframe.exception.IcsshsException;
import com.fkframe.web.ScriptMessageUtil;
import com.fkframe.exception.ValidateRuntimeException;
import com.fkframe.struts2.Struts2Utils;
import com.fkframe.query.PageData;

import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.service.${moduleName}.${className}BS;
<#list subClazzes as subClazz>
import ${basepackage}.data.bo.${moduleName}.${subClazz.className};
import ${basepackage}.data.vo.${moduleName}.${subClazz.className}VO;
import ${basepackage}.service.${moduleName}.${subClazz.className}BS;
import com.fkframe.tags.ui.grid.GridServerHandler;
</#list>

/**
*
*${entityCnName} Action 
*
*/
public class ${className}Action extends BaseAction  {
	private static final String RESOURCE_CODE="";//R1上定义的资源code
	public ${className}Action(){
		RightManager.rightAble(RESOURCE_CODE,request);
	}
	
	
	//-- 页面应用到的属性  --//
	private ${className}VO entity;
	
	<#list subClazzes as subClazz>
	private GridInfo<${subClazz.className}VO> ${subClazz.className?uncap_first}GridInfo = new GridInfo<${subClazz.className}VO>(${subClazz.className}VO.class);
	</#list>
	//主表查询界面或者编辑界面需要关联查询的控件数据集（需要自己添加）
	private void initControllData(){}
	private void initNewVO(${className}VO vo){}//新增记录可以在这里赋值默认值,用于页面暂时
	private void initSaveVO(${className}VO vo){}//新增记录可以在这里赋值默认保存值（界面没有）
	
	//service注入
	private ${className}BS  ${classNameLower}BS;
	<#list subClazzes as subClazz>
	private ${subClazz.className}BS ${subClazz.className?uncap_first}BS;
	</#list>
	
	
	/****************************************页面跳转*********************************/
	/** 默认进入查询页面 **/
	@Override
	public String list() throws Exception {
		try{
			pageData = ${classNameLower}BS.queryVOPage(getConditionMap(),getCurrentPage());
			setCurrentPage(pageData.getCurrentPage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);//e.printStackTrace();
			addScriptMessage(ScriptMessageUtil.alertErro("查询失败: "+e.getMessage()));
		}
		return SUCCESS;
	}
	
	/** 进入新增/编辑页面*/
	@Override
	public String input() throws Exception {
		if(StringUtils.isBlank(recordId)){//新增
			try{
				entity = new ${className}VO();
				initNewVO(entity);
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
			}finally{
				func=FUNCTION_ADD;
				initControllData();
			}
			return INPUT;
		}else{//编辑
			try{
				Long rid = Long.valueOf(recordId);
				loadEntity(rid);
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
			}finally{
				func=FUNCTION_EDIT;
				initControllData();	
			}
			return INPUT;
		}
	}
	
	//TO 查看界面
	public String toView() throws Exception{
		if(StringUtils.isBlank(recordId))throw new IcsshsException("id 为空");
		try{
			Long rid = Long.valueOf(recordId);
			loadEntity(rid);
		}catch(Exception e){
			logger.error(e.getMessage(),e);//e.printStackTrace();
			addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
		}finally{
			setPageEditable(false);
			func=FUNCTION_VIEW;
			initControllData();	
		}
		return INPUT;
	}
	
	//TO 验收界面
	public String toAudit() throws Exception{
		if(StringUtils.isBlank(recordId))throw new IcsshsException("id 为空");
		try{
			Long rid = Long.valueOf(recordId);
			loadEntity(rid);
		}catch(Exception e){
			logger.error(e.getMessage(),e);//e.printStackTrace();
			addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
		}finally{
			setPageEditable(false);
			func =FUNCTION_AUDIT;
			initControllData();	
		}
		return INPUT;
	}
	

	/**
	 * --功能方法--
	 */
	//save()保存前调用
	@Override
	public void prepareSave() throws Exception {
		if(StringUtils.isNotBlank(recordId)){
			entity = ${classNameLower}BS.queryVOById(Long.valueOf(recordId));
		}else{
			entity = new ${className}VO();
		}
	}
	//保存新增或编辑的对象(recordId判断)
	@Override
	public String save() throws Exception {
		if(StringUtils.isBlank(recordId)){//新增
			try{
				//保存
				initSaveVO(entity);
				${className} po = entity.cloneBO();
				<#list subClazzes as subClazz>
				${subClazz.className?uncap_first}GridInfo = GridServerHandler.createGridInfo(request,"${subClazz.className?uncap_first}Grid",${subClazz.className}VO.class);
				List<${subClazz.className}> ${subClazz.className?uncap_first}AddPOList = ${subClazz.className}VO.cloneBOList(${subClazz.className?uncap_first}GridInfo.getInsertedRecords());
				</#list>
				${classNameLower}BS.add${className}(po<#list subClazzes as subClazz>,${subClazz.className?uncap_first}AddPOList</#list>);
				//转向
				recordId = String.valueOf(po.get${clazz.pkProperty.name?cap_first}());
				addScriptMessage(ScriptMessageUtil.alertSucceed());
				return toView();
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
				func= FUNCTION_ADD;
				return INPUT;
			}finally{
				initControllData();
			}
		}else{//编辑
			try{
				${className} po = entity.cloneBO();
				<#list subClazzes as subClazz>
				${subClazz.className?uncap_first}GridInfo = GridServerHandler.createGridInfo(request,"${subClazz.className?uncap_first}Grid",${subClazz.className}VO.class);
				List<${subClazz.className}>[] ${subClazz.className?uncap_first}Lists = new List[3];
				${subClazz.className?uncap_first}Lists[0]=${subClazz.className}VO.cloneBOList(${subClazz.className?uncap_first}GridInfo.getInsertedRecords());
				${subClazz.className?uncap_first}Lists[1]=${subClazz.className}VO.cloneBOList(${subClazz.className?uncap_first}GridInfo.getUpdatedRecords());
				${subClazz.className?uncap_first}Lists[2]=${subClazz.className}VO.cloneBOList(${subClazz.className?uncap_first}GridInfo.getDeletedRecords());
				</#list>
				${classNameLower}BS.modify${className}(po<#list subClazzes as subClazz>,${subClazz.className?uncap_first}Lists</#list>);
				addScriptMessage(ScriptMessageUtil.alertSucceed());
				return toView();
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
				func=FUNCTION_EDIT;
				return INPUT;
			}finally{
				initControllData();
			}
		}
	}
	//验收功能
	public String audit() throws Exception{
		return doAudit(true);
	}
	
	//取消验收
	public String cacelAudit() throws Exception{
		return doAudit(false);
	}
	
	private String doAudit(boolean flag) throws Exception{
		try{
			if(StringUtils.isBlank(recordId))throw new IcsshsException("id 为空");
			${classNameLower}BS.audit${className}(Long.valueOf(recordId),flag);
			addScriptMessage(ScriptMessageUtil.alertSucceed("操作完成！"));
		}catch(Exception e){
			logger.error(e.getMessage(),e);//e.printStackTrace();
			addScriptMessage(ScriptMessageUtil.alertSucceed("操作完成！"));
		}finally{
			initControllData();			
		}
		return toAudit();
	}
	
	//删除功能
	@Override
	public String delete() throws Exception {
		try{
			${classNameLower}BS.del${className}ByIds(Long.valueOf(getRecordId()));
			Struts2Utils.renderText("删除成功!");
		}catch(Exception e){
			Struts2Utils.renderText("删除失败："+e.getMessage());
		}
		return null;
	}
	
	private void loadEntity(Long id) throws Exception{
		entity = ${classNameLower}BS.queryVOById(id);
		<#list subClazzes as subClazz>
		List<${subClazz.className}VO> ${subClazz.className?uncap_first}s = ${subClazz.className?uncap_first}BS.queryVOByParentId(id);
		${subClazz.className?uncap_first}GridInfo.setData(${subClazz.className?uncap_first}s);
		</#list>
	}
	
	//getter and setter 
	public ${className}VO getEntity() {
		return entity;
	}
	public void setEntity(${className}VO entity) {
		this.entity = entity;
	}
	<#list subClazzes as subClazz>
	public  GridInfo<${subClazz.className}VO> get${subClazz.className}GridInfo(){
		return this.${subClazz.className?uncap_first}GridInfo;
	}
	</#list>
	
	public void set${className}BS(${className}BS ${classNameLower}BS) {
		this.${classNameLower}BS = ${classNameLower}BS;
	}
	<#list subClazzes as subClazz>
	public void set${subClazz.className}BS(${subClazz.className}BS ${subClazz.className?uncap_first}BS) {
		this.${subClazz.className?uncap_first}BS = ${subClazz.className?uncap_first}BS;
	}
	</#list>
}
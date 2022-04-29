<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.action.${moduleName};


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ${basepackage}.action.common.BaseAction;

import com.fkframe.exception.IcsshsException;
import com.fkframe.web.ScriptMessageUtil;

import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.service.${moduleName}.${className}BS;
import com.fkframe.struts2.Struts2Utils;
import com.fkframe.tags.right.RightManager;
import com.pdms.common.BaseConstant;
import com.pdms.common.CmdUtils;


/**
*
*${entityCnName} Action 
*
*/
public class ${className}Action extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final String RESOURCE_CODE="";//R1上定义的资源code
	
	public ${className}Action(){
		RightManager.rightAble(RESOURCE_CODE,request);
		<#list inputfieldList as prop>
			<#if prop.uiType != ''>
		${prop.name}Map = CmdUtils.getCodeDefineMap("${prop.uiType}");
			</#if>
		</#list>
	}
	
	private ${className}BS ${classNameLower}BS;
	
	//-- 页面应用到的属性  --//
	private ${className}VO entity;
	
	
	<#list inputfieldList as prop>    	
		<#if prop.uiType != ''>
	private Map<String, String> ${prop.name}Map  = new HashMap<String, String>();
	public Map<String, String> get${prop.name?cap_first}Map() {
		return ${prop.name}Map;
	}
	public void set${prop.name?cap_first}Map(Map<String, String> ${prop.name}Map) {
		this.${prop.name}Map = ${prop.name}Map;
	}
		</#if>
	</#list>

	//主表查询界面或者编辑界面需要关联查询的控件数据集（需要自己添加）
	private void initControllData(){};
	
	private void initNewVO(${className}VO vo){};//新增记录可以在这里赋值默认值,用于页面暂时
	private void initSaveVO(${className}VO vo){};//新增记录可以在这里赋值默认保存值（界面没有）
	
	/****************************************页面跳转*********************************/
	
	
	/** 进入新增/编辑页面*/
	@Override
	public String input() throws Exception {
	try{
		if(StringUtils.isNotBlank(recordId)){
			func=FUNCTION_EDIT;
			entity = ${classNameLower}BS.queryVOById(Long.valueOf(recordId));
		}else{
			func=FUNCTION_ADD;
			entity = new ${className}VO();
			initNewVO(entity);
		}
	}catch(Exception e){
		logger.error(e.getMessage(),e);
		addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
	}finally{
		initControllData();		
	}
		
		return INPUT;
	}
	
	//TO 查看界面
	public String toView() throws Exception{
		try{
			if(StringUtils.isBlank(recordId))throw new IcsshsException("id 为空");
			entity = ${classNameLower}BS.queryVOById(Long.valueOf(recordId));
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
		}
		func = FUNCTION_VIEW;
		setPageEditable(false);
		initControllData();
		return INPUT;
	}
	
  /*************************动作处理************************************/
	/** 执行搜索  */
	public String list() throws Exception{
		try{
			conditionMap.put("state", "0");
			pageData = ${classNameLower}BS.queryVOPage(getConditionMap(),getCurrentPage());
			setCurrentPage(pageData.getCurrentPage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
		}
		return SUCCESS;
	}
	
	
	public void prepareSave() throws Exception{
	 	if(StringUtils.isNotBlank(recordId)){
	 		entity = ${classNameLower}BS.queryVOById(Long.valueOf(recordId));
		}else{
			entity = new ${className}VO();
			initSaveVO(entity);
		}
	}
	/** 新增或者修改对象 */
	public String save() throws Exception{
		try{
			if(StringUtils.isBlank(recordId)){
				${className} newObj = new ${className}();
				entity.copyValueTo(newObj);
				${classNameLower}BS.saveObject(newObj);
				addScriptMessage(ScriptMessageUtil.alertSucceed("新增成功,可以继续新加！"));
			}else{
				${className} editObj = new ${className}();
				entity.copyValueTo(editObj);
				${classNameLower}BS.updateObject(editObj);
				addScriptMessage(ScriptMessageUtil.alertSucceed("修改成功！")+"doAction('close');");
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
			initControllData();
			return INPUT;	
		}
		return input();
	}
	
	
	/**删除对象*/
	public String delete() throws Exception{
		try{
			${classNameLower}BS.deleteById(new Long(getRecordId()),${className}.class);
			Struts2Utils.renderText("删除成功！");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			Struts2Utils.renderText("操作未能完成："+e.getMessage());
		}
		return null;
	}

	
	/**------------------getter and setter ------------------------**/
	
	public void set${className}BS(${className}BS  service) {
		${classNameLower}BS = service;
	}
	
	public void setEntity(${className}VO  entity){
		this.entity=entity;
	}
	public ${className}VO getEntity(){
		return this.entity;
	}
}
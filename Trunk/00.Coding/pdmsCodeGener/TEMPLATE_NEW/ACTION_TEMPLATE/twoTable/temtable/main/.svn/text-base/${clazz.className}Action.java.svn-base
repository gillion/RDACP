<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.action.${moduleName};

import org.apache.commons.lang.StringUtils;
import com.fkframe.exception.IcsshsException;
import com.fkframe.struts2.Struts2Utils;
import com.fkframe.tags.right.RightManager;
import com.fkframe.web.ScriptMessageUtil;

import ${basepackage}.action.common.BaseAction;
import ${basepackage}.common.Globals;

import ${basepackage}.data.bo.demo.${className};
import ${basepackage}.data.vo.demo.${className}VO;
import ${basepackage}.service.demo.${className}BS;

/**
 * 
 * ${entityCnName} Action
 *
 */
public class ${className}Action extends BaseAction {
	private static final String RESOURCE_CODE="";//R1上定义的资源code
	public ${className}Action(){
		RightManager.rightAble(RESOURCE_CODE,request);
	}
	
	private ${className}BS  ${classNameLower}BS;
	
	//-- 页面应用到的属性  --//
	private ${className}VO entity;
	//主表查询界面或者编辑界面需要关联查询的控件数据集（需要自己添加）
	private void initControllData(){}
	//新增记录可以在这里赋值默认值,用于页面暂时
	private void initNewVO(${className}VO vo) throws Exception{
		
	}
	//新增记录可以在这里赋值默认保存值（界面没有）
	private void initSaveVO(${className}VO vo) throws Exception{
		vo.setState(Globals.STATE_INIT);
	}
	
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
		initControllData();
		return SUCCESS;
	}
	
	/** 进入新增/编辑页面*/
	@Override
	public String input() throws Exception {
		this.operSerialNo = generateOperSerialNo();
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
				entity = ${classNameLower}BS.queryVOById(rid);
				${classNameLower}BS.copyDetailsToTemp(rid,operSerialNo);
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
			entity = ${classNameLower}BS.queryVOById(rid);
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
			entity = ${classNameLower}BS.queryVOById(rid);
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
				${classNameLower}BS.add${className}(po,operSerialNo);
				//转向
				recordId = String.valueOf(po.get${clazz.pkProperty.name?cap_first}());
				addScriptMessage(ScriptMessageUtil.alertSucceed());
				return toView();
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
				func=FUNCTION_ADD;
				return INPUT;
			}finally{
				initControllData();
			}
		}else{//编辑
			try{
				${className} po = entity.cloneBO();
				${classNameLower}BS.modify${className}(po,operSerialNo);
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
			addScriptMessage(ScriptMessageUtil.alertSucceed(e.getMessage()));
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
		
	
	//getter and setter
	public void set${className}BS(${className}BS ${classNameLower}BS) {
		this.${classNameLower}BS = ${classNameLower}BS;
	}
	
	public ${className}VO getEntity() {
		return entity;
	}
	public void setEntity(${className}VO entity) {
		this.entity = entity;
	}
}
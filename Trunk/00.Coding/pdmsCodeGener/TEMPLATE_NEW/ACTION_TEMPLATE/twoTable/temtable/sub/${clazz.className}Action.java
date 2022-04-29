<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.action.${moduleName};

import java.util.List;
import java.util.ArrayList;

import com.fkframe.struts2.Struts2Utils;
import com.fkframe.web.ScriptMessageUtil;
import org.apache.commons.lang.StringUtils;
import ${basepackage}.action.common.BaseAction;
import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.service.${moduleName}.${className}BS;

import com.fkframe.persist.TempOrderBS;


public class ${className}Action extends BaseAction  {
	
	private ${className}BS ${classNameLower}BS;
	public void set${className}BS(${className}BS ${classNameLower}BS) {this.${classNameLower}BS = ${classNameLower}BS;}

	private TempOrderBS tempOrderBS;
	public TempOrderBS getTempOrderBS() {
		return tempOrderBS;
	}
	public void setTempOrderBS(TempOrderBS tempOrderBS) {
		this.tempOrderBS = tempOrderBS;
	}
	/**
	 *-- 页面属性  -- 
	 */
	private Long parentId;
	private ${className}VO entity;
	private List<${className}VO> details = new ArrayList();//页面列表显示
	//private PageData pageData;
	public final static String FUNCTION_ADD = "ADD";       	 //新建页面
	public final static String FUNCTION_EDIT = "EDIT";       	 //修改页面	
	public final static String FUNCTION_VIEW = "VIEW";       	 //查看页面	
	public final static String FUNCTION_AUDIT = "AUDIT";       //验收审核页面	
	//主表查询界面或者编辑界面需要关联查询的控件数据集（需要自己添加）
	private void initControllData(){};
	private void initNewVO(${className}VO vo){}//新增记录可以在这里赋值默认值,用于页面暂时
	private void initSaveVO(${className}VO vo){}//新增记录可以在这里赋值默认保存值（界面没有）
	/**
	 * -- 页面跳转--
	 */
	//TO 列表界面
	@Override
	public String list() throws Exception{
		try{
			//pageData = invOrderDetailBS.queryPagebySerialNo(operSerialNo,${className}VO.class,${className}VO.DETAIL_TYPE,currentPage);
			//setCurrentPage(pageData.getCurrentPage());
			// details =${classNameLower}BS.queryVOByParentId(parentId);
			details = tempOrderBS.queryBySerialNo(operSerialNo,${className}VO.class,${className}VO.DETAIL_TYPE,false);
		}catch(Exception e){
			logger.error(e.getMessage(),e);//e.printStackTrace();
			addScriptMessage(ScriptMessageUtil.alertErro("查询失败: "+e.getMessage()));
		}
		return SUCCESS;
	}
	/**
	 * 转到正式表的查看界面（不可编辑）
	 * @return
	 */
	public String listReal() {
		try{	
			 details =${classNameLower}BS.queryVOByParentId(parentId);
			//pageData = ${classNameLower}BS.queryVOPageByParentId(parentId, currentPage);
		}catch(Exception e){
			logger.error(e.getMessage(),e);//e.printStackTrace();
			addScriptMessage(ScriptMessageUtil.alertErro("查询失败: "+e.getMessage()));
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
				entity.set${clazz.pkProperty.name?cap_first}(${classNameLower}BS.generateId());
				tempOrderBS.saveTempOrder(entity);
				addActionMessage("添加成功！");
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
				initControllData();
				return INPUT;
			}
		}else{
			try{
				tempOrderBS.updateTempOrder(entity);
				addScriptMessage("alert('修改成功！');doAction('close');");
			}catch(Exception e){
				logger.error(e.getMessage(),e);//e.printStackTrace();
				addScriptMessage(ScriptMessageUtil.alertErro(e.getMessage()));
				initControllData();
				return INPUT;
			}
		}
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
			Struts2Utils.renderText("删除失败:"+e.getMessage());
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
	
	public List<${className}VO> getDetails() {
		return details;
	}
	
	/*public PageData getPageData() {
		return pageData;
	}
	 */
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}

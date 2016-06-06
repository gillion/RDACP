package com.cartan.core.ipfCcmBo.domain;
import java.io.Serializable;


/**
 * IpfCcmBo
 */
public class IpfCcmBo implements Serializable{
	private String ID;//主键
	private String BO_NAME;//业务对象名
	private String BO_TYPE;//对象类型
	private String APP_MODULE;//功能模块
	private String SERVICE_TYPE;//服务类型
	private String JAVA_PATH;//JAVA路径
	private String SERVICE_CATEGORY;//服务分类
	private String TABLE_NAME;//表名
	private String TABLE_TYPE;//表类型
	private String DESCRIPTION;//描述
	private String SEARCH_COLUMNS;//查询条件列数
	private String SEARCH_MODE;//查询模式
	private String PAGE_SIZE;//每页记录
	private String IPF_CCM_UI_LAYOUT_ID;//界面布局ID
	private String UI_LAYOUT_NAME;//界面布局名称
	private String FORM_CELL_MODE;//界面模式
	private String UI_TEMPLATE;//界面模板
	private String FORM_COLUMNS;//每行列数
	private String GRID_STYLE;//表格样式
	private String GRID_ALIGN;//表格列对齐
	private String GRID_EDIT_TYPE;//表格维护方式
	private String GENERATE_OPTION;//代码生成选项
	private String LOCK_ROW_EXPRESS;//行锁定表达式
	private String GRID_TYPE;//表格类型
	private String IS_MAIN_OBJECT;//主对象
	private String IS_INIT_DATA_BO;//初始化数据对象
	private String IS_AUTO_LOAD;//自动查询
	private String IS_NEED_ADV_SEARCH;//需高级查询
	private String NEED_PAGING;//表格分页
	private String IS_GRID_FILTER;//表格列筛选
	private String IS_GRID_CUSTOM;//表格列定义
	private String REMARK;//备注
	private String WHERE_CLAUSE;//WHERE条件
	private String ID_GENERATOR;//ID生成器名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getBoName() {
		return this.BO_NAME;
	}
	
	public void setBoName(String value) {
		this.BO_NAME = value;
	}
	

	public String getBoType() {
		return this.BO_TYPE;
	}
	
	public void setBoType(String value) {
		this.BO_TYPE = value;
	}
	

	public String getAppModule() {
		return this.APP_MODULE;
	}
	
	public void setAppModule(String value) {
		this.APP_MODULE = value;
	}
	

	public String getServiceType() {
		return this.SERVICE_TYPE;
	}
	
	public void setServiceType(String value) {
		this.SERVICE_TYPE = value;
	}
	

	public String getJavaPath() {
		return this.JAVA_PATH;
	}
	
	public void setJavaPath(String value) {
		this.JAVA_PATH = value;
	}
	

	public String getServiceCategory() {
		return this.SERVICE_CATEGORY;
	}
	
	public void setServiceCategory(String value) {
		this.SERVICE_CATEGORY = value;
	}
	

	public String getTableName() {
		return this.TABLE_NAME;
	}
	
	public void setTableName(String value) {
		this.TABLE_NAME = value;
	}
	

	public String getTableType() {
		return this.TABLE_TYPE;
	}
	
	public void setTableType(String value) {
		this.TABLE_TYPE = value;
	}
	

	public String getDescription() {
		return this.DESCRIPTION;
	}
	
	public void setDescription(String value) {
		this.DESCRIPTION = value;
	}
	

	public String getSearchColumns() {
		return this.SEARCH_COLUMNS;
	}
	
	public void setSearchColumns(String value) {
		this.SEARCH_COLUMNS = value;
	}
	

	public String getSearchMode() {
		return this.SEARCH_MODE;
	}
	
	public void setSearchMode(String value) {
		this.SEARCH_MODE = value;
	}
	

	public String getPageSize() {
		return this.PAGE_SIZE;
	}
	
	public void setPageSize(String value) {
		this.PAGE_SIZE = value;
	}
	

	public String getIpfCcmUiLayoutId() {
		return this.IPF_CCM_UI_LAYOUT_ID;
	}
	
	public void setIpfCcmUiLayoutId(String value) {
		this.IPF_CCM_UI_LAYOUT_ID = value;
	}
	

	public String getUiLayoutName() {
		return this.UI_LAYOUT_NAME;
	}
	
	public void setUiLayoutName(String value) {
		this.UI_LAYOUT_NAME = value;
	}
	

	public String getFormCellMode() {
		return this.FORM_CELL_MODE;
	}
	
	public void setFormCellMode(String value) {
		this.FORM_CELL_MODE = value;
	}
	

	public String getUiTemplate() {
		return this.UI_TEMPLATE;
	}
	
	public void setUiTemplate(String value) {
		this.UI_TEMPLATE = value;
	}
	

	public String getFormColumns() {
		return this.FORM_COLUMNS;
	}
	
	public void setFormColumns(String value) {
		this.FORM_COLUMNS = value;
	}
	

	public String getGridStyle() {
		return this.GRID_STYLE;
	}
	
	public void setGridStyle(String value) {
		this.GRID_STYLE = value;
	}
	

	public String getGridAlign() {
		return this.GRID_ALIGN;
	}
	
	public void setGridAlign(String value) {
		this.GRID_ALIGN = value;
	}
	

	public String getGridEditType() {
		return this.GRID_EDIT_TYPE;
	}
	
	public void setGridEditType(String value) {
		this.GRID_EDIT_TYPE = value;
	}
	

	public String getGenerateOption() {
		return this.GENERATE_OPTION;
	}
	
	public void setGenerateOption(String value) {
		this.GENERATE_OPTION = value;
	}
	

	public String getLockRowExpress() {
		return this.LOCK_ROW_EXPRESS;
	}
	
	public void setLockRowExpress(String value) {
		this.LOCK_ROW_EXPRESS = value;
	}
	

	public String getGridType() {
		return this.GRID_TYPE;
	}
	
	public void setGridType(String value) {
		this.GRID_TYPE = value;
	}
	

	public String getIsMainObject() {
		return this.IS_MAIN_OBJECT;
	}
	
	public void setIsMainObject(String value) {
		this.IS_MAIN_OBJECT = value;
	}
	

	public String getIsInitDataBo() {
		return this.IS_INIT_DATA_BO;
	}
	
	public void setIsInitDataBo(String value) {
		this.IS_INIT_DATA_BO = value;
	}
	

	public String getIsAutoLoad() {
		return this.IS_AUTO_LOAD;
	}
	
	public void setIsAutoLoad(String value) {
		this.IS_AUTO_LOAD = value;
	}
	

	public String getIsNeedAdvSearch() {
		return this.IS_NEED_ADV_SEARCH;
	}
	
	public void setIsNeedAdvSearch(String value) {
		this.IS_NEED_ADV_SEARCH = value;
	}
	

	public String getNeedPaging() {
		return this.NEED_PAGING;
	}
	
	public void setNeedPaging(String value) {
		this.NEED_PAGING = value;
	}
	

	public String getIsGridFilter() {
		return this.IS_GRID_FILTER;
	}
	
	public void setIsGridFilter(String value) {
		this.IS_GRID_FILTER = value;
	}
	

	public String getIsGridCustom() {
		return this.IS_GRID_CUSTOM;
	}
	
	public void setIsGridCustom(String value) {
		this.IS_GRID_CUSTOM = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

	public String getWhereClause() {
		return this.WHERE_CLAUSE;
	}
	
	public void setWhereClause(String value) {
		this.WHERE_CLAUSE = value;
	}
	

	public String getIdGenerator() {
		return this.ID_GENERATOR;
	}
	
	public void setIdGenerator(String value) {
		this.ID_GENERATOR = value;
	}
	

}

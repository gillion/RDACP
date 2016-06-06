package com.cartan.core.ipfPoiSetting.domain;
import java.io.Serializable;


/**
 * IpfPoiSetting
 */
public class IpfPoiSetting implements Serializable{
	private String ID;//主键
	private String BO_NAME;//业务对象名称
	private String POI_TYPE;//导入导出类型
	private String TEMPLATE_FILE_NAME;//模板文件名称
	private String TEMPLATE_URL;//模板地址
	private String FILE_NAME;//导入导出文件名
	private String SOURCE_SERVICE;//请求数据路径
	private String CLASS_NAME;//POI对象全名
	private String TEMPLATE_EXT_NAME;//模板文件扩展名
	private String RULE_NO;//导入规则号
	private String DICT_NAME;//数据字典路径
	private String DEAL_SERVICE;//结果处理服务
	private String METHODE_NAME;//结果处理服务方法名
	private String IS_ASYNC;//是否异步下载
	private String ASYNC_PAGE_SIZE;//异步每页行数
	private String TEMPLATE;//模板内容
	private String TEMPLATE_FILE_KEY;//模板文件KEY
	private String PRIMARY_COLUMNS;//主键指定
	private String CHILDREN_TABLE;//子表信息定义类
	private String SORT_EXPRESS;//排序表达式
	private String ALLOW_PARAMETER;//是否接收参数
	private String IPF_DEFINE_COLUMN;//导入字段定义
	
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
	

	public String getPoiType() {
		return this.POI_TYPE;
	}
	
	public void setPoiType(String value) {
		this.POI_TYPE = value;
	}
	

	public String getTemplateFileName() {
		return this.TEMPLATE_FILE_NAME;
	}
	
	public void setTemplateFileName(String value) {
		this.TEMPLATE_FILE_NAME = value;
	}
	

	public String getTemplateUrl() {
		return this.TEMPLATE_URL;
	}
	
	public void setTemplateUrl(String value) {
		this.TEMPLATE_URL = value;
	}
	

	public String getFileName() {
		return this.FILE_NAME;
	}
	
	public void setFileName(String value) {
		this.FILE_NAME = value;
	}
	

	public String getSourceService() {
		return this.SOURCE_SERVICE;
	}
	
	public void setSourceService(String value) {
		this.SOURCE_SERVICE = value;
	}
	

	public String getClassName() {
		return this.CLASS_NAME;
	}
	
	public void setClassName(String value) {
		this.CLASS_NAME = value;
	}
	

	public String getTemplateExtName() {
		return this.TEMPLATE_EXT_NAME;
	}
	
	public void setTemplateExtName(String value) {
		this.TEMPLATE_EXT_NAME = value;
	}
	

	public String getRuleNo() {
		return this.RULE_NO;
	}
	
	public void setRuleNo(String value) {
		this.RULE_NO = value;
	}
	

	public String getDictName() {
		return this.DICT_NAME;
	}
	
	public void setDictName(String value) {
		this.DICT_NAME = value;
	}
	

	public String getDealService() {
		return this.DEAL_SERVICE;
	}
	
	public void setDealService(String value) {
		this.DEAL_SERVICE = value;
	}
	

	public String getMethodeName() {
		return this.METHODE_NAME;
	}
	
	public void setMethodeName(String value) {
		this.METHODE_NAME = value;
	}
	

	public String getIsAsync() {
		return this.IS_ASYNC;
	}
	
	public void setIsAsync(String value) {
		this.IS_ASYNC = value;
	}
	

	public String getAsyncPageSize() {
		return this.ASYNC_PAGE_SIZE;
	}
	
	public void setAsyncPageSize(String value) {
		this.ASYNC_PAGE_SIZE = value;
	}
	

	public String getTemplate() {
		return this.TEMPLATE;
	}
	
	public void setTemplate(String value) {
		this.TEMPLATE = value;
	}
	

	public String getTemplateFileKey() {
		return this.TEMPLATE_FILE_KEY;
	}
	
	public void setTemplateFileKey(String value) {
		this.TEMPLATE_FILE_KEY = value;
	}
	

	public String getPrimaryColumns() {
		return this.PRIMARY_COLUMNS;
	}
	
	public void setPrimaryColumns(String value) {
		this.PRIMARY_COLUMNS = value;
	}
	

	public String getChildrenTable() {
		return this.CHILDREN_TABLE;
	}
	
	public void setChildrenTable(String value) {
		this.CHILDREN_TABLE = value;
	}
	

	public String getSortExpress() {
		return this.SORT_EXPRESS;
	}
	
	public void setSortExpress(String value) {
		this.SORT_EXPRESS = value;
	}
	

	public String getAllowParameter() {
		return this.ALLOW_PARAMETER;
	}
	
	public void setAllowParameter(String value) {
		this.ALLOW_PARAMETER = value;
	}
	

	public String getIpfDefineColumn() {
		return this.IPF_DEFINE_COLUMN;
	}
	
	public void setIpfDefineColumn(String value) {
		this.IPF_DEFINE_COLUMN = value;
	}
	

}

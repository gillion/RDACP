/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfPoiSetting.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfPoiSetting.domain.IpfPoiSetting;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfPoiSettingSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String boName;//业务对象名称
	private String poiType;//导入导出类型
	private String templateFileName;//模板文件名称
	private String templateUrl;//模板地址
	private String fileName;//导入导出文件名
	private String sourceService;//请求数据路径
	private String className;//POI对象全名
	private String templateExtName;//模板文件扩展名
	private String ruleNo;//导入规则号
	private String dictName;//数据字典路径
	private String dealService;//结果处理服务
	private String methodeName;//结果处理服务方法名
	private String isAsync;//是否异步下载
	private String asyncPageSize;//异步每页行数
	private String template;//模板内容
	private String templateFileKey;//模板文件KEY
	private String primaryColumns;//主键指定
	private String childrenTable;//子表信息定义类
	private String sortExpress;//排序表达式
	private String allowParameter;//是否接收参数
	private String ipfDefineColumn;//导入字段定义
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getBoName() {
		return this.boName;
	}
	
	public void setBoName(String boName) {
		this.boName = boName;
	}
	
	

	public String getPoiType() {
		return this.poiType;
	}
	
	public void setPoiType(String poiType) {
		this.poiType = poiType;
	}
	
	

	public String getTemplateFileName() {
		return this.templateFileName;
	}
	
	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}
	
	

	public String getTemplateUrl() {
		return this.templateUrl;
	}
	
	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}
	
	

	public String getFileName() {
		return this.fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

	public String getSourceService() {
		return this.sourceService;
	}
	
	public void setSourceService(String sourceService) {
		this.sourceService = sourceService;
	}
	
	

	public String getClassName() {
		return this.className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	

	public String getTemplateExtName() {
		return this.templateExtName;
	}
	
	public void setTemplateExtName(String templateExtName) {
		this.templateExtName = templateExtName;
	}
	
	

	public String getRuleNo() {
		return this.ruleNo;
	}
	
	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
	
	

	public String getDictName() {
		return this.dictName;
	}
	
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	
	

	public String getDealService() {
		return this.dealService;
	}
	
	public void setDealService(String dealService) {
		this.dealService = dealService;
	}
	
	

	public String getMethodeName() {
		return this.methodeName;
	}
	
	public void setMethodeName(String methodeName) {
		this.methodeName = methodeName;
	}
	
	

	public String getIsAsync() {
		return this.isAsync;
	}
	
	public void setIsAsync(String isAsync) {
		this.isAsync = isAsync;
	}
	
	

	public String getAsyncPageSize() {
		return this.asyncPageSize;
	}
	
	public void setAsyncPageSize(String asyncPageSize) {
		this.asyncPageSize = asyncPageSize;
	}
	
	

	public String getTemplate() {
		return this.template;
	}
	
	public void setTemplate(String template) {
		this.template = template;
	}
	
	

	public String getTemplateFileKey() {
		return this.templateFileKey;
	}
	
	public void setTemplateFileKey(String templateFileKey) {
		this.templateFileKey = templateFileKey;
	}
	
	

	public String getPrimaryColumns() {
		return this.primaryColumns;
	}
	
	public void setPrimaryColumns(String primaryColumns) {
		this.primaryColumns = primaryColumns;
	}
	
	

	public String getChildrenTable() {
		return this.childrenTable;
	}
	
	public void setChildrenTable(String childrenTable) {
		this.childrenTable = childrenTable;
	}
	
	

	public String getSortExpress() {
		return this.sortExpress;
	}
	
	public void setSortExpress(String sortExpress) {
		this.sortExpress = sortExpress;
	}
	
	

	public String getAllowParameter() {
		return this.allowParameter;
	}
	
	public void setAllowParameter(String allowParameter) {
		this.allowParameter = allowParameter;
	}
	
	

	public String getIpfDefineColumn() {
		return this.ipfDefineColumn;
	}
	
	public void setIpfDefineColumn(String ipfDefineColumn) {
		this.ipfDefineColumn = ipfDefineColumn;
	}
	
	
	
	public IpfPoiSettingSelectRequest(){}
	
	public IpfPoiSettingSelectRequest(IpfPoiSetting ipfPoiSetting){
		BeanUtils.copyProperties(ipfPoiSetting,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfPoiSetting bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfPoiSetting cloneBO(){
		IpfPoiSetting bo = new IpfPoiSetting();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfPoiSetting> cloneBOList(List<IpfPoiSettingSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfPoiSetting>(0);
		List<IpfPoiSetting> result = new ArrayList<IpfPoiSetting>(vos.size());
		for(IpfPoiSettingSelectRequest vo: vos){
			IpfPoiSetting bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


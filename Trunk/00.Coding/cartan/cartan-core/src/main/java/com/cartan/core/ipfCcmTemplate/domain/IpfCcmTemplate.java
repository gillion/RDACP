package com.cartan.core.ipfCcmTemplate.domain;
import java.io.Serializable;


/**
 * IpfCcmTemplate
 */
public class IpfCcmTemplate implements Serializable{
	private String ID;//主键
	private String TEMPLATE_FILE;//模板文件
	private String TEMPLATE_DESC;//模板描述
	private String TEMPLATE_TYPE;//模板类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getTemplateFile() {
		return this.TEMPLATE_FILE;
	}
	
	public void setTemplateFile(String value) {
		this.TEMPLATE_FILE = value;
	}
	

	public String getTemplateDesc() {
		return this.TEMPLATE_DESC;
	}
	
	public void setTemplateDesc(String value) {
		this.TEMPLATE_DESC = value;
	}
	

	public String getTemplateType() {
		return this.TEMPLATE_TYPE;
	}
	
	public void setTemplateType(String value) {
		this.TEMPLATE_TYPE = value;
	}
	

}

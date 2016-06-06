package com.cartan.core.ipfCcmBoCheck.domain;
import java.io.Serializable;


/**
 * IpfCcmBoCheck
 */
public class IpfCcmBoCheck implements Serializable{
	private String ID;//主键
	private String CHECK_TYPE;//校验类型
	private String CHECK_NAME;//校验名称
	private String BO_NAME;//业务对象名
	private String PROPERTY_NAME;//属性名称
	private String PROPERTY_DESC;//属性描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getCheckType() {
		return this.CHECK_TYPE;
	}
	
	public void setCheckType(String value) {
		this.CHECK_TYPE = value;
	}
	

	public String getCheckName() {
		return this.CHECK_NAME;
	}
	
	public void setCheckName(String value) {
		this.CHECK_NAME = value;
	}
	

	public String getBoName() {
		return this.BO_NAME;
	}
	
	public void setBoName(String value) {
		this.BO_NAME = value;
	}
	

	public String getPropertyName() {
		return this.PROPERTY_NAME;
	}
	
	public void setPropertyName(String value) {
		this.PROPERTY_NAME = value;
	}
	

	public String getPropertyDesc() {
		return this.PROPERTY_DESC;
	}
	
	public void setPropertyDesc(String value) {
		this.PROPERTY_DESC = value;
	}
	

}

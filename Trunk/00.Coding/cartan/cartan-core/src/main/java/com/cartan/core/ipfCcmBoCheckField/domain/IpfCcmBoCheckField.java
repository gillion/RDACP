package com.cartan.core.ipfCcmBoCheckField.domain;
import java.io.Serializable;


/**
 * IpfCcmBoCheckField
 */
public class IpfCcmBoCheckField implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_CHECK_ID;//校验
	private String PROPERTY_ID;//属性ID
	private String PROPERTY_NAME;//属性名称
	private String PROPERTY_DESC;//属性描述
	private String BO_NAME;//业务对象名
	private String SEQ_NO;//顺序号
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmBoCheckId() {
		return this.IPF_CCM_BO_CHECK_ID;
	}
	
	public void setIpfCcmBoCheckId(String value) {
		this.IPF_CCM_BO_CHECK_ID = value;
	}
	

	public String getPropertyId() {
		return this.PROPERTY_ID;
	}
	
	public void setPropertyId(String value) {
		this.PROPERTY_ID = value;
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
	

	public String getBoName() {
		return this.BO_NAME;
	}
	
	public void setBoName(String value) {
		this.BO_NAME = value;
	}
	

	public String getSeqNo() {
		return this.SEQ_NO;
	}
	
	public void setSeqNo(String value) {
		this.SEQ_NO = value;
	}
	

}

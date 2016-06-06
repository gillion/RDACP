package com.cartan.core.ipfCcmBoPropertyCas.domain;
import java.io.Serializable;


/**
 * IpfCcmBoPropertyCas
 */
public class IpfCcmBoPropertyCas implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_PROPERTY_ID;//属性
	private String CASCADE_PROPERTY_ID;//级联属性
	private String OPERATION;//操作符
	private String TARGET_PROPERTY_NAME;//目标属性名称
	private String TYPE;//类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmBoPropertyId() {
		return this.IPF_CCM_BO_PROPERTY_ID;
	}
	
	public void setIpfCcmBoPropertyId(String value) {
		this.IPF_CCM_BO_PROPERTY_ID = value;
	}
	

	public String getCascadePropertyId() {
		return this.CASCADE_PROPERTY_ID;
	}
	
	public void setCascadePropertyId(String value) {
		this.CASCADE_PROPERTY_ID = value;
	}
	

	public String getOperation() {
		return this.OPERATION;
	}
	
	public void setOperation(String value) {
		this.OPERATION = value;
	}
	

	public String getTargetPropertyName() {
		return this.TARGET_PROPERTY_NAME;
	}
	
	public void setTargetPropertyName(String value) {
		this.TARGET_PROPERTY_NAME = value;
	}
	

	public String getType() {
		return this.TYPE;
	}
	
	public void setType(String value) {
		this.TYPE = value;
	}
	

}

package com.cartan.core.ipfRtmTypeBoAttr.domain;
import java.io.Serializable;


/**
 * IpfRtmTypeBoAttr
 */
public class IpfRtmTypeBoAttr implements Serializable{
	private String ID;//主键
	private String IPF_RTM_TYPE_BO_ID;//运行期配置界面
	private String PROPERTY_NAME;//属性名称
	private String FIELD_TEXT;//属性中文描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfRtmTypeBoId() {
		return this.IPF_RTM_TYPE_BO_ID;
	}
	
	public void setIpfRtmTypeBoId(String value) {
		this.IPF_RTM_TYPE_BO_ID = value;
	}
	

	public String getPropertyName() {
		return this.PROPERTY_NAME;
	}
	
	public void setPropertyName(String value) {
		this.PROPERTY_NAME = value;
	}
	

	public String getFieldText() {
		return this.FIELD_TEXT;
	}
	
	public void setFieldText(String value) {
		this.FIELD_TEXT = value;
	}
	

}

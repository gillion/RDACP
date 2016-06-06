package com.cartan.core.ipfRtmType.domain;
import java.io.Serializable;


/**
 * IpfRtmType
 */
public class IpfRtmType implements Serializable{
	private String ID;//主键
	private String TYPE_CODE;//类别代码
	private String TYPE_NAME;//类别名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getTypeCode() {
		return this.TYPE_CODE;
	}
	
	public void setTypeCode(String value) {
		this.TYPE_CODE = value;
	}
	

	public String getTypeName() {
		return this.TYPE_NAME;
	}
	
	public void setTypeName(String value) {
		this.TYPE_NAME = value;
	}
	

}

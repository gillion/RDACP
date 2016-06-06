package com.cartan.core.ipfDmlElement.domain;
import java.io.Serializable;


/**
 * IpfDmlElement
 */
public class IpfDmlElement implements Serializable{
	private String ID;//主键
	private String ELEMENT_CODE;//数据元素代码
	private String FIELD_TEXT;//显示文本
	private String DATA_TYPE;//数据类型
	private String FIELD_LENGTH;//字段长度
	private String DECIMALS;//小数位
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getElementCode() {
		return this.ELEMENT_CODE;
	}
	
	public void setElementCode(String value) {
		this.ELEMENT_CODE = value;
	}
	

	public String getFieldText() {
		return this.FIELD_TEXT;
	}
	
	public void setFieldText(String value) {
		this.FIELD_TEXT = value;
	}
	

	public String getDataType() {
		return this.DATA_TYPE;
	}
	
	public void setDataType(String value) {
		this.DATA_TYPE = value;
	}
	

	public String getFieldLength() {
		return this.FIELD_LENGTH;
	}
	
	public void setFieldLength(String value) {
		this.FIELD_LENGTH = value;
	}
	

	public String getDecimals() {
		return this.DECIMALS;
	}
	
	public void setDecimals(String value) {
		this.DECIMALS = value;
	}
	

}

package com.cartan.core.ipfDmlColumn.domain;
import java.io.Serializable;


/**
 * IpfDmlColumn
 */
public class IpfDmlColumn implements Serializable{
	private String ID;//主键
	private String IPF_DML_TABLE_ID;//VARCHAR2(50)
	private String COLUMN_NAME;//字段名称
	private String IPF_DML_ELEMENT_ID;//数据元素ID
	private String ELEMENT_CODE;//数据元素代码
	private String FIELD_TEXT;//显示文本
	private String DATA_TYPE;//数据类型
	private String FIELD_LENGTH;//字段长度
	private String DECIMALS;//小数位
	private String IS_NOT_NULL;//非空
	private String IS_PRIMARY_KEY;//主键
	private String DEFAULT_VALUE;//默认值
	private String INIT_VALUE;//初始值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfDmlTableId() {
		return this.IPF_DML_TABLE_ID;
	}
	
	public void setIpfDmlTableId(String value) {
		this.IPF_DML_TABLE_ID = value;
	}
	

	public String getColumnName() {
		return this.COLUMN_NAME;
	}
	
	public void setColumnName(String value) {
		this.COLUMN_NAME = value;
	}
	

	public String getIpfDmlElementId() {
		return this.IPF_DML_ELEMENT_ID;
	}
	
	public void setIpfDmlElementId(String value) {
		this.IPF_DML_ELEMENT_ID = value;
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
	

	public String getIsNotNull() {
		return this.IS_NOT_NULL;
	}
	
	public void setIsNotNull(String value) {
		this.IS_NOT_NULL = value;
	}
	

	public String getIsPrimaryKey() {
		return this.IS_PRIMARY_KEY;
	}
	
	public void setIsPrimaryKey(String value) {
		this.IS_PRIMARY_KEY = value;
	}
	

	public String getDefaultValue() {
		return this.DEFAULT_VALUE;
	}
	
	public void setDefaultValue(String value) {
		this.DEFAULT_VALUE = value;
	}
	

	public String getInitValue() {
		return this.INIT_VALUE;
	}
	
	public void setInitValue(String value) {
		this.INIT_VALUE = value;
	}
	

}

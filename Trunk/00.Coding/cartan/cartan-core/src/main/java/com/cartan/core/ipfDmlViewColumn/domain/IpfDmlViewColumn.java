package com.cartan.core.ipfDmlViewColumn.domain;
import java.io.Serializable;


/**
 * IpfDmlViewColumn
 */
public class IpfDmlViewColumn implements Serializable{
	private String ID;//主键
	private String IPF_DML_VIEW_ID;//视图
	private String COLUMN_NAME;//字段名称
	private String FIELD_TEXT;//字段标题
	private String DATA_TYPE;//数据类型
	private String FIELD_LENGTH;//字段长度
	private String DECIMALS;//小数位
	private String IS_NOT_NULL;//非空
	private String IS_PRIMARY_KEY;//主键
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfDmlViewId() {
		return this.IPF_DML_VIEW_ID;
	}
	
	public void setIpfDmlViewId(String value) {
		this.IPF_DML_VIEW_ID = value;
	}
	

	public String getColumnName() {
		return this.COLUMN_NAME;
	}
	
	public void setColumnName(String value) {
		this.COLUMN_NAME = value;
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
	

}

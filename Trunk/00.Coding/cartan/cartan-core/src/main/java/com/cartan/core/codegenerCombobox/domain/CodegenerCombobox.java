package com.cartan.core.codegenerCombobox.domain;
import java.io.Serializable;


/**
 * CodegenerCombobox
 */
public class CodegenerCombobox implements Serializable{
	private String ID;//主键
	private String SETUP_ID;//基本配置
	private String TABLE_ID;//关联模型
	private String COMBOBOX_FIELD;//下拉字段
	private String CODE_TYPE;//代码类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getSetupId() {
		return this.SETUP_ID;
	}
	
	public void setSetupId(String value) {
		this.SETUP_ID = value;
	}
	

	public String getTableId() {
		return this.TABLE_ID;
	}
	
	public void setTableId(String value) {
		this.TABLE_ID = value;
	}
	

	public String getComboboxField() {
		return this.COMBOBOX_FIELD;
	}
	
	public void setComboboxField(String value) {
		this.COMBOBOX_FIELD = value;
	}
	

	public String getCodeType() {
		return this.CODE_TYPE;
	}
	
	public void setCodeType(String value) {
		this.CODE_TYPE = value;
	}
	

}

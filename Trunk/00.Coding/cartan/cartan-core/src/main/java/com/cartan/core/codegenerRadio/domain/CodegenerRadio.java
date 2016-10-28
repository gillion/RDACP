package com.cartan.core.codegenerRadio.domain;
import java.io.Serializable;


/**
 * CodegenerRadio
 */
public class CodegenerRadio implements Serializable{
	private String ID;//主键
	private String SETUP_ID;//基本配置
	private String TABLE_ID;//关联模型
	private String RADIO_FIELD;//单选字段
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
	

	public String getRadioField() {
		return this.RADIO_FIELD;
	}
	
	public void setRadioField(String value) {
		this.RADIO_FIELD = value;
	}
	

	public String getCodeType() {
		return this.CODE_TYPE;
	}
	
	public void setCodeType(String value) {
		this.CODE_TYPE = value;
	}
	

}

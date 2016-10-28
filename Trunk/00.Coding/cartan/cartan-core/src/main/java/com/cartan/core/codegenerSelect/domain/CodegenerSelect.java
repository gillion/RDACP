package com.cartan.core.codegenerSelect.domain;
import java.io.Serializable;


/**
 * CodegenerSelect
 */
public class CodegenerSelect implements Serializable{
	private String ID;//主键
	private String SETUP_ID;//基本配置
	private String TABLE_ID;//关联模型
	private String SELECT_FIELD;//弹出字段
	private String SELECT_TABLE;//取数模型
	private String SELECT_DES;//描述字段
	
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
	

	public String getSelectField() {
		return this.SELECT_FIELD;
	}
	
	public void setSelectField(String value) {
		this.SELECT_FIELD = value;
	}
	

	public String getSelectTable() {
		return this.SELECT_TABLE;
	}
	
	public void setSelectTable(String value) {
		this.SELECT_TABLE = value;
	}
	

	public String getSelectDes() {
		return this.SELECT_DES;
	}
	
	public void setSelectDes(String value) {
		this.SELECT_DES = value;
	}
	

}

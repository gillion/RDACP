package com.cartan.core.ipfDmlTable.domain;
import java.io.Serializable;


/**
 * IpfDmlTable
 */
public class IpfDmlTable implements Serializable{
	private String ID;//主键
	private String TABLE_NAME;//表名
	private String TABLE_TYPE;//表类型
	private String TABLE_DESC;//表描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getTableName() {
		return this.TABLE_NAME;
	}
	
	public void setTableName(String value) {
		this.TABLE_NAME = value;
	}
	

	public String getTableType() {
		return this.TABLE_TYPE;
	}
	
	public void setTableType(String value) {
		this.TABLE_TYPE = value;
	}
	

	public String getTableDesc() {
		return this.TABLE_DESC;
	}
	
	public void setTableDesc(String value) {
		this.TABLE_DESC = value;
	}
	

}

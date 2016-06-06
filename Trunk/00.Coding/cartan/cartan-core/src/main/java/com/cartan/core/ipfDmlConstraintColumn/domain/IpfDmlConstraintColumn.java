package com.cartan.core.ipfDmlConstraintColumn.domain;
import java.io.Serializable;


/**
 * IpfDmlConstraintColumn
 */
public class IpfDmlConstraintColumn implements Serializable{
	private String ID;//主键
	private String IPF_DML_CONSTRAINT_ID;//约束
	private String COLUMN_NAME;//字段名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfDmlConstraintId() {
		return this.IPF_DML_CONSTRAINT_ID;
	}
	
	public void setIpfDmlConstraintId(String value) {
		this.IPF_DML_CONSTRAINT_ID = value;
	}
	

	public String getColumnName() {
		return this.COLUMN_NAME;
	}
	
	public void setColumnName(String value) {
		this.COLUMN_NAME = value;
	}
	

}

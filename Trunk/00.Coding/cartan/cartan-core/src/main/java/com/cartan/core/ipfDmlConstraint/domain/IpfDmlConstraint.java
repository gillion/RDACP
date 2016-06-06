package com.cartan.core.ipfDmlConstraint.domain;
import java.io.Serializable;


/**
 * IpfDmlConstraint
 */
public class IpfDmlConstraint implements Serializable{
	private String ID;//主键
	private String IPF_DML_TABLE_ID;//表名
	private String CONSTRAINT_NAME;//约束名称
	private String CONSTRAINT_TYPE;//约束类型
	private String COLUMN_NAME;//字段名称
	private String FOREIGN_TABLE_NAME;//外关联表名
	private String FOREIGN_COLUMN_NAME;//外关联字段名
	
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
	

	public String getConstraintName() {
		return this.CONSTRAINT_NAME;
	}
	
	public void setConstraintName(String value) {
		this.CONSTRAINT_NAME = value;
	}
	

	public String getConstraintType() {
		return this.CONSTRAINT_TYPE;
	}
	
	public void setConstraintType(String value) {
		this.CONSTRAINT_TYPE = value;
	}
	

	public String getColumnName() {
		return this.COLUMN_NAME;
	}
	
	public void setColumnName(String value) {
		this.COLUMN_NAME = value;
	}
	

	public String getForeignTableName() {
		return this.FOREIGN_TABLE_NAME;
	}
	
	public void setForeignTableName(String value) {
		this.FOREIGN_TABLE_NAME = value;
	}
	

	public String getForeignColumnName() {
		return this.FOREIGN_COLUMN_NAME;
	}
	
	public void setForeignColumnName(String value) {
		this.FOREIGN_COLUMN_NAME = value;
	}
	

}

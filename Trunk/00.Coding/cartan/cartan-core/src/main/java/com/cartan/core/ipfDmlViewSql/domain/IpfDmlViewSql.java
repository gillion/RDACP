package com.cartan.core.ipfDmlViewSql.domain;
import java.io.Serializable;


/**
 * IpfDmlViewSql
 */
public class IpfDmlViewSql implements Serializable{
	private String ID;//主键
	private String IPF_DML_VIEW_ID;//视图
	private String DBMS_TYPE;//数据库类型
	private String SQL_STATEMENT;//SQL表达式
	
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
	

	public String getDbmsType() {
		return this.DBMS_TYPE;
	}
	
	public void setDbmsType(String value) {
		this.DBMS_TYPE = value;
	}
	

	public String getSqlStatement() {
		return this.SQL_STATEMENT;
	}
	
	public void setSqlStatement(String value) {
		this.SQL_STATEMENT = value;
	}
	

}

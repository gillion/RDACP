package com.cartan.core.ipfDmlIndexColumn.domain;
import java.io.Serializable;


/**
 * IpfDmlIndexColumn
 */
public class IpfDmlIndexColumn implements Serializable{
	private String ID;//主键
	private String IPF_DML_INDEX_ID;//索引
	private String COLUMN_NAME;//字段名称
	private String INDEX_OPTION;//索引选项
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfDmlIndexId() {
		return this.IPF_DML_INDEX_ID;
	}
	
	public void setIpfDmlIndexId(String value) {
		this.IPF_DML_INDEX_ID = value;
	}
	

	public String getColumnName() {
		return this.COLUMN_NAME;
	}
	
	public void setColumnName(String value) {
		this.COLUMN_NAME = value;
	}
	

	public String getIndexOption() {
		return this.INDEX_OPTION;
	}
	
	public void setIndexOption(String value) {
		this.INDEX_OPTION = value;
	}
	

}

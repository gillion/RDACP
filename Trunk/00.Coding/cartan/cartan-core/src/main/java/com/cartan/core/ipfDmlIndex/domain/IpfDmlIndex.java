package com.cartan.core.ipfDmlIndex.domain;
import java.io.Serializable;


/**
 * IpfDmlIndex
 */
public class IpfDmlIndex implements Serializable{
	private String ID;//主键
	private String IPF_DML_TABLE_ID;//表名
	private String INDEX_NAME;//索引名称
	private String INDEX_TYPE;//索引类型
	
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
	

	public String getIndexName() {
		return this.INDEX_NAME;
	}
	
	public void setIndexName(String value) {
		this.INDEX_NAME = value;
	}
	

	public String getIndexType() {
		return this.INDEX_TYPE;
	}
	
	public void setIndexType(String value) {
		this.INDEX_TYPE = value;
	}
	

}

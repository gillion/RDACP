package com.cartan.core.codegenerTable.domain;
import java.io.Serializable;


/**
 * CodegenerTable
 */
public class CodegenerTable implements Serializable{
	private String ID;//主键
	private String SETUP_ID;//配置名称
	private String TABLE_NAME;//表名
	private String TABLE_DES;//中文描述
	private String PARENT_TABLE_NAME;//继承表名
	private String NO_PARENT;//无公共字段
	private String IS_NEW_BSCLASS;//是否新建业务类
	private String PAGE_SIZE;//编辑列数
	
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
	

	public String getTableName() {
		return this.TABLE_NAME;
	}
	
	public void setTableName(String value) {
		this.TABLE_NAME = value;
	}
	

	public String getTableDes() {
		return this.TABLE_DES;
	}
	
	public void setTableDes(String value) {
		this.TABLE_DES = value;
	}
	

	public String getParentTableName() {
		return this.PARENT_TABLE_NAME;
	}
	
	public void setParentTableName(String value) {
		this.PARENT_TABLE_NAME = value;
	}
	

	public String getNoParent() {
		return this.NO_PARENT;
	}
	
	public void setNoParent(String value) {
		this.NO_PARENT = value;
	}
	

	public String getIsNewBsclass() {
		return this.IS_NEW_BSCLASS;
	}
	
	public void setIsNewBsclass(String value) {
		this.IS_NEW_BSCLASS = value;
	}
	

	public String getPageSize() {
		return this.PAGE_SIZE;
	}
	
	public void setPageSize(String value) {
		this.PAGE_SIZE = value;
	}
	

}

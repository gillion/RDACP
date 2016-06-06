package com.cartan.core.ipfCcmShlp.domain;
import java.io.Serializable;


/**
 * IpfCcmShlp
 */
public class IpfCcmShlp implements Serializable{
	private String ID;//主键
	private String SHLP_NAME;//名称
	private String SHLP_STATUS;//状态
	private String DATA_SOURCE;//数据源
	private String DATA_SOURCE_TYPE;//数据源类型
	private String VALUE_COLUMN;//值字段
	private String DISPLAY_COLUMN;//文本字段
	private String RULE_NO;//业务规则号
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getShlpName() {
		return this.SHLP_NAME;
	}
	
	public void setShlpName(String value) {
		this.SHLP_NAME = value;
	}
	

	public String getShlpStatus() {
		return this.SHLP_STATUS;
	}
	
	public void setShlpStatus(String value) {
		this.SHLP_STATUS = value;
	}
	

	public String getDataSource() {
		return this.DATA_SOURCE;
	}
	
	public void setDataSource(String value) {
		this.DATA_SOURCE = value;
	}
	

	public String getDataSourceType() {
		return this.DATA_SOURCE_TYPE;
	}
	
	public void setDataSourceType(String value) {
		this.DATA_SOURCE_TYPE = value;
	}
	

	public String getValueColumn() {
		return this.VALUE_COLUMN;
	}
	
	public void setValueColumn(String value) {
		this.VALUE_COLUMN = value;
	}
	

	public String getDisplayColumn() {
		return this.DISPLAY_COLUMN;
	}
	
	public void setDisplayColumn(String value) {
		this.DISPLAY_COLUMN = value;
	}
	

	public String getRuleNo() {
		return this.RULE_NO;
	}
	
	public void setRuleNo(String value) {
		this.RULE_NO = value;
	}
	

}

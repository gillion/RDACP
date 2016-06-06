package com.cartan.core.ipfRuleRotateDetail.domain;
import java.io.Serializable;


/**
 * IpfRuleRotateDetail
 */
public class IpfRuleRotateDetail implements Serializable{
	private String ID;//主键
	private String IPF_RULE_ROTATE_ID;//周转规则
	private String LINE_ID;//行号
	private String LOT_ATTRIBUTES;//批次属性
	private String SORT_TYPE;//排序
	private String DETAIL_DESC;//描述
	private String IS_ACTIVE;//启用
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfRuleRotateId() {
		return this.IPF_RULE_ROTATE_ID;
	}
	
	public void setIpfRuleRotateId(String value) {
		this.IPF_RULE_ROTATE_ID = value;
	}
	

	public String getLineId() {
		return this.LINE_ID;
	}
	
	public void setLineId(String value) {
		this.LINE_ID = value;
	}
	

	public String getLotAttributes() {
		return this.LOT_ATTRIBUTES;
	}
	
	public void setLotAttributes(String value) {
		this.LOT_ATTRIBUTES = value;
	}
	

	public String getSortType() {
		return this.SORT_TYPE;
	}
	
	public void setSortType(String value) {
		this.SORT_TYPE = value;
	}
	

	public String getDetailDesc() {
		return this.DETAIL_DESC;
	}
	
	public void setDetailDesc(String value) {
		this.DETAIL_DESC = value;
	}
	

	public String getIsActive() {
		return this.IS_ACTIVE;
	}
	
	public void setIsActive(String value) {
		this.IS_ACTIVE = value;
	}
	

}

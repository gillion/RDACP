package com.cartan.core.ipfRuleRotate.domain;
import java.io.Serializable;


/**
 * IpfRuleRotate
 */
public class IpfRuleRotate implements Serializable{
	private String ID;//主键
	private String WAREHOUSE_OFFICE_ID;//周转单位
	private String RULE_CODE;//周转规则代码
	private String RULE_DESC;//描述
	private String IS_ACTIVE;//启用
	private String IS_SYSTEM_CREATE;//系统创建
	private String ROTATE_EXPRESS;//周转规则表达式
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getWarehouseOfficeId() {
		return this.WAREHOUSE_OFFICE_ID;
	}
	
	public void setWarehouseOfficeId(String value) {
		this.WAREHOUSE_OFFICE_ID = value;
	}
	

	public String getRuleCode() {
		return this.RULE_CODE;
	}
	
	public void setRuleCode(String value) {
		this.RULE_CODE = value;
	}
	

	public String getRuleDesc() {
		return this.RULE_DESC;
	}
	
	public void setRuleDesc(String value) {
		this.RULE_DESC = value;
	}
	

	public String getIsActive() {
		return this.IS_ACTIVE;
	}
	
	public void setIsActive(String value) {
		this.IS_ACTIVE = value;
	}
	

	public String getIsSystemCreate() {
		return this.IS_SYSTEM_CREATE;
	}
	
	public void setIsSystemCreate(String value) {
		this.IS_SYSTEM_CREATE = value;
	}
	

	public String getRotateExpress() {
		return this.ROTATE_EXPRESS;
	}
	
	public void setRotateExpress(String value) {
		this.ROTATE_EXPRESS = value;
	}
	

}

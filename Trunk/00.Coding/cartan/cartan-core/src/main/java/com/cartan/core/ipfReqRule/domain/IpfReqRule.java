package com.cartan.core.ipfReqRule.domain;
import java.io.Serializable;


/**
 * IpfReqRule
 */
public class IpfReqRule implements Serializable{
	private String ID;//主键
	private String RULE_NAME;//规则名称
	private String RULE_NO;//规则号
	private String RULE_TYPE;//规则类型
	private String RULE_STATUS;//规则状态
	private String TRIGGER_TYPE;//触发类型
	private String PHYSICAL_LOCATION;//所处物理位置
	private String ACTION_TYPE;//动作类型
	private String BUSINESS_LOCATION;//所处业务位置
	private String BUSINESS_MODULE;//业务模块
	private String DROOLS_ATTRIBUTE;//规则属性
	private String RULE_DESC;//规则描述
	private String IS_DECISION_TABLE;//是否使用决策表
	private String PUBLIC_TYPE;//共享类型
	private String IPF_CCM_BO_ID;//业务对象
	private String IMPORT_DESC;//传参说明
	private String DROOLS_WHEN;//DROOLS条件
	private String DROOLS_THEN;//DROOLS动作
	private String REMARK;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getRuleName() {
		return this.RULE_NAME;
	}
	
	public void setRuleName(String value) {
		this.RULE_NAME = value;
	}
	

	public String getRuleNo() {
		return this.RULE_NO;
	}
	
	public void setRuleNo(String value) {
		this.RULE_NO = value;
	}
	

	public String getRuleType() {
		return this.RULE_TYPE;
	}
	
	public void setRuleType(String value) {
		this.RULE_TYPE = value;
	}
	

	public String getRuleStatus() {
		return this.RULE_STATUS;
	}
	
	public void setRuleStatus(String value) {
		this.RULE_STATUS = value;
	}
	

	public String getTriggerType() {
		return this.TRIGGER_TYPE;
	}
	
	public void setTriggerType(String value) {
		this.TRIGGER_TYPE = value;
	}
	

	public String getPhysicalLocation() {
		return this.PHYSICAL_LOCATION;
	}
	
	public void setPhysicalLocation(String value) {
		this.PHYSICAL_LOCATION = value;
	}
	

	public String getActionType() {
		return this.ACTION_TYPE;
	}
	
	public void setActionType(String value) {
		this.ACTION_TYPE = value;
	}
	

	public String getBusinessLocation() {
		return this.BUSINESS_LOCATION;
	}
	
	public void setBusinessLocation(String value) {
		this.BUSINESS_LOCATION = value;
	}
	

	public String getBusinessModule() {
		return this.BUSINESS_MODULE;
	}
	
	public void setBusinessModule(String value) {
		this.BUSINESS_MODULE = value;
	}
	

	public String getDroolsAttribute() {
		return this.DROOLS_ATTRIBUTE;
	}
	
	public void setDroolsAttribute(String value) {
		this.DROOLS_ATTRIBUTE = value;
	}
	

	public String getRuleDesc() {
		return this.RULE_DESC;
	}
	
	public void setRuleDesc(String value) {
		this.RULE_DESC = value;
	}
	

	public String getIsDecisionTable() {
		return this.IS_DECISION_TABLE;
	}
	
	public void setIsDecisionTable(String value) {
		this.IS_DECISION_TABLE = value;
	}
	

	public String getPublicType() {
		return this.PUBLIC_TYPE;
	}
	
	public void setPublicType(String value) {
		this.PUBLIC_TYPE = value;
	}
	

	public String getIpfCcmBoId() {
		return this.IPF_CCM_BO_ID;
	}
	
	public void setIpfCcmBoId(String value) {
		this.IPF_CCM_BO_ID = value;
	}
	

	public String getImportDesc() {
		return this.IMPORT_DESC;
	}
	
	public void setImportDesc(String value) {
		this.IMPORT_DESC = value;
	}
	

	public String getDroolsWhen() {
		return this.DROOLS_WHEN;
	}
	
	public void setDroolsWhen(String value) {
		this.DROOLS_WHEN = value;
	}
	

	public String getDroolsThen() {
		return this.DROOLS_THEN;
	}
	
	public void setDroolsThen(String value) {
		this.DROOLS_THEN = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

}

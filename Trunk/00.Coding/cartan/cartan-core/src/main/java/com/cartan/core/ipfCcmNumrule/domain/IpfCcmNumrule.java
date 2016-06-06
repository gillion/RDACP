package com.cartan.core.ipfCcmNumrule.domain;
import java.io.Serializable;


/**
 * IpfCcmNumrule
 */
public class IpfCcmNumrule implements Serializable{
	private String ID;//主键
	private String RULE_CODE;//单号规则代码
	private String RULE_NAME;//单号规则名称
	private String RULE_EXPRESSION;//单号生成规则
	private String RULE_STATUS;//单号规则状态
	private String INITIAL_VALUE;//初始值
	private String MAX_VALUE;//最大值
	private String GROWTH;//增长值
	private String REMARK;//备注
	private String IS_ACTIVE;//有效
	private String IPF_CCM_BO_ID;//业务对象ID
	private String BO_NAME;//业务对象名称
	private String IPF_CCM_BO_PROPERTY_ID;//属性ID
	private String PROPERTY_NAME;//属性名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getRuleCode() {
		return this.RULE_CODE;
	}
	
	public void setRuleCode(String value) {
		this.RULE_CODE = value;
	}
	

	public String getRuleName() {
		return this.RULE_NAME;
	}
	
	public void setRuleName(String value) {
		this.RULE_NAME = value;
	}
	

	public String getRuleExpression() {
		return this.RULE_EXPRESSION;
	}
	
	public void setRuleExpression(String value) {
		this.RULE_EXPRESSION = value;
	}
	

	public String getRuleStatus() {
		return this.RULE_STATUS;
	}
	
	public void setRuleStatus(String value) {
		this.RULE_STATUS = value;
	}
	

	public String getInitialValue() {
		return this.INITIAL_VALUE;
	}
	
	public void setInitialValue(String value) {
		this.INITIAL_VALUE = value;
	}
	

	public String getMaxValue() {
		return this.MAX_VALUE;
	}
	
	public void setMaxValue(String value) {
		this.MAX_VALUE = value;
	}
	

	public String getGrowth() {
		return this.GROWTH;
	}
	
	public void setGrowth(String value) {
		this.GROWTH = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

	public String getIsActive() {
		return this.IS_ACTIVE;
	}
	
	public void setIsActive(String value) {
		this.IS_ACTIVE = value;
	}
	

	public String getIpfCcmBoId() {
		return this.IPF_CCM_BO_ID;
	}
	
	public void setIpfCcmBoId(String value) {
		this.IPF_CCM_BO_ID = value;
	}
	

	public String getBoName() {
		return this.BO_NAME;
	}
	
	public void setBoName(String value) {
		this.BO_NAME = value;
	}
	

	public String getIpfCcmBoPropertyId() {
		return this.IPF_CCM_BO_PROPERTY_ID;
	}
	
	public void setIpfCcmBoPropertyId(String value) {
		this.IPF_CCM_BO_PROPERTY_ID = value;
	}
	

	public String getPropertyName() {
		return this.PROPERTY_NAME;
	}
	
	public void setPropertyName(String value) {
		this.PROPERTY_NAME = value;
	}
	

}

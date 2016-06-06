package com.cartan.core.ipfCcmBizruleDtl.domain;
import java.io.Serializable;


/**
 * IpfCcmBizruleDtl
 */
public class IpfCcmBizruleDtl implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BIZRULE_ID;//规则
	private String IPF_CCM_STRATEGY_ID;//策略ID
	private String STRATEGY_CODE;//策略代码
	private String STRATEGY_NAME;//策略名称
	private String REMARK;//备注
	private String RULE_DETAIL_INDEX;//序号
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmBizruleId() {
		return this.IPF_CCM_BIZRULE_ID;
	}
	
	public void setIpfCcmBizruleId(String value) {
		this.IPF_CCM_BIZRULE_ID = value;
	}
	

	public String getIpfCcmStrategyId() {
		return this.IPF_CCM_STRATEGY_ID;
	}
	
	public void setIpfCcmStrategyId(String value) {
		this.IPF_CCM_STRATEGY_ID = value;
	}
	

	public String getStrategyCode() {
		return this.STRATEGY_CODE;
	}
	
	public void setStrategyCode(String value) {
		this.STRATEGY_CODE = value;
	}
	

	public String getStrategyName() {
		return this.STRATEGY_NAME;
	}
	
	public void setStrategyName(String value) {
		this.STRATEGY_NAME = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

	public String getRuleDetailIndex() {
		return this.RULE_DETAIL_INDEX;
	}
	
	public void setRuleDetailIndex(String value) {
		this.RULE_DETAIL_INDEX = value;
	}
	

}

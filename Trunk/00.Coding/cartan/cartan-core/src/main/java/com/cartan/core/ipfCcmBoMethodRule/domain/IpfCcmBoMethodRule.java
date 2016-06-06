package com.cartan.core.ipfCcmBoMethodRule.domain;
import java.io.Serializable;


/**
 * IpfCcmBoMethodRule
 */
public class IpfCcmBoMethodRule implements Serializable{
	private String ID;//主键
	private String IPF_CCB_BO_METHOD_ID;//方法
	private String RULE_NO;//规则号
	private String RULE_NAME;//规则名称
	private String INVOKE_POINT;//调用时机
	private String INVOKE_ORDER;//调用顺序
	private String RULE_ID;//规则ID
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcbBoMethodId() {
		return this.IPF_CCB_BO_METHOD_ID;
	}
	
	public void setIpfCcbBoMethodId(String value) {
		this.IPF_CCB_BO_METHOD_ID = value;
	}
	

	public String getRuleNo() {
		return this.RULE_NO;
	}
	
	public void setRuleNo(String value) {
		this.RULE_NO = value;
	}
	

	public String getRuleName() {
		return this.RULE_NAME;
	}
	
	public void setRuleName(String value) {
		this.RULE_NAME = value;
	}
	

	public String getInvokePoint() {
		return this.INVOKE_POINT;
	}
	
	public void setInvokePoint(String value) {
		this.INVOKE_POINT = value;
	}
	

	public String getInvokeOrder() {
		return this.INVOKE_ORDER;
	}
	
	public void setInvokeOrder(String value) {
		this.INVOKE_ORDER = value;
	}
	

	public String getRuleId() {
		return this.RULE_ID;
	}
	
	public void setRuleId(String value) {
		this.RULE_ID = value;
	}
	

}

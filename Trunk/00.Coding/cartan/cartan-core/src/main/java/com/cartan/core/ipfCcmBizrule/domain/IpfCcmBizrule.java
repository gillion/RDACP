package com.cartan.core.ipfCcmBizrule.domain;
import java.io.Serializable;


/**
 * IpfCcmBizrule
 */
public class IpfCcmBizrule implements Serializable{
	private String ID;//主键
	private String RULE_TYPE;//规则类型
	private String RULE_CLASS;//规则类名
	private String RULE_CODE;//规则编码
	private String RULE_NAME;//规则名称
	private String RULE_DES;//规则描述
	private String IS_SYSTEM_CREATE;//系统创建
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getRuleType() {
		return this.RULE_TYPE;
	}
	
	public void setRuleType(String value) {
		this.RULE_TYPE = value;
	}
	

	public String getRuleClass() {
		return this.RULE_CLASS;
	}
	
	public void setRuleClass(String value) {
		this.RULE_CLASS = value;
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
	

	public String getRuleDes() {
		return this.RULE_DES;
	}
	
	public void setRuleDes(String value) {
		this.RULE_DES = value;
	}
	

	public String getIsSystemCreate() {
		return this.IS_SYSTEM_CREATE;
	}
	
	public void setIsSystemCreate(String value) {
		this.IS_SYSTEM_CREATE = value;
	}
	

}

package com.cartan.core.ruleTableInput.domain;
import java.io.Serializable;


/**
 * 决策表输入
 */
public class RuleTableInput implements Serializable{
	private String ID;//主键
	private String RULE_TABLE_ID;//决策表
	private String OUTPUT_LOCATION;//输出定位
	private String INPUT_VAR;//输入变量
	private String INPUT_VALUE;//输入值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getRuleTableId() {
		return this.RULE_TABLE_ID;
	}
	
	public void setRuleTableId(String value) {
		this.RULE_TABLE_ID = value;
	}
	

	public String getOutputLocation() {
		return this.OUTPUT_LOCATION;
	}
	
	public void setOutputLocation(String value) {
		this.OUTPUT_LOCATION = value;
	}
	

	public String getInputVar() {
		return this.INPUT_VAR;
	}
	
	public void setInputVar(String value) {
		this.INPUT_VAR = value;
	}
	

	public String getInputValue() {
		return this.INPUT_VALUE;
	}
	
	public void setInputValue(String value) {
		this.INPUT_VALUE = value;
	}
	

}

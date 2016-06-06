package com.cartan.core.ruleTableOutput.domain;
import java.io.Serializable;


/**
 * 决策表输出
 */
public class RuleTableOutput implements Serializable{
	private String ID;//主键
	private String RULE_TABLE_ID;//决策表
	private String OUTPUT_LOCATION;//输出定位
	private String OUTPUT_VAR;//输出变量
	private String OUTPUT_VALUE;//输出值
	
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
	

	public String getOutputVar() {
		return this.OUTPUT_VAR;
	}
	
	public void setOutputVar(String value) {
		this.OUTPUT_VAR = value;
	}
	

	public String getOutputValue() {
		return this.OUTPUT_VALUE;
	}
	
	public void setOutputValue(String value) {
		this.OUTPUT_VALUE = value;
	}
	

}

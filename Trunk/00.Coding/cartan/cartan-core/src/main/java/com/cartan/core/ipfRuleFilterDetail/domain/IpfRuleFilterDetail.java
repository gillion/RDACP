package com.cartan.core.ipfRuleFilterDetail.domain;
import java.io.Serializable;


/**
 * IpfRuleFilterDetail
 */
public class IpfRuleFilterDetail implements Serializable{
	private String ID;//主键
	private String IPF_RULE_FILTER_ID;//筛选条件
	private String LINE_ID;//行号
	private String ATTRIBUTE;//表属性
	private String OPERAND;//运算符
	private String LITERAL_VALUE;//值
	private String AND_OR;//AND或者OR
	private String LEFT_PAREN;//左括号数量
	private String RIGHT_PAREN;//右括号数量
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfRuleFilterId() {
		return this.IPF_RULE_FILTER_ID;
	}
	
	public void setIpfRuleFilterId(String value) {
		this.IPF_RULE_FILTER_ID = value;
	}
	

	public String getLineId() {
		return this.LINE_ID;
	}
	
	public void setLineId(String value) {
		this.LINE_ID = value;
	}
	

	public String getAttribute() {
		return this.ATTRIBUTE;
	}
	
	public void setAttribute(String value) {
		this.ATTRIBUTE = value;
	}
	

	public String getOperand() {
		return this.OPERAND;
	}
	
	public void setOperand(String value) {
		this.OPERAND = value;
	}
	

	public String getLiteralValue() {
		return this.LITERAL_VALUE;
	}
	
	public void setLiteralValue(String value) {
		this.LITERAL_VALUE = value;
	}
	

	public String getAndOr() {
		return this.AND_OR;
	}
	
	public void setAndOr(String value) {
		this.AND_OR = value;
	}
	

	public String getLeftParen() {
		return this.LEFT_PAREN;
	}
	
	public void setLeftParen(String value) {
		this.LEFT_PAREN = value;
	}
	

	public String getRightParen() {
		return this.RIGHT_PAREN;
	}
	
	public void setRightParen(String value) {
		this.RIGHT_PAREN = value;
	}
	

}

package com.cartan.core.ruleTreeOutput.domain;
import java.io.Serializable;


/**
 * 决策树输出
 */
public class RuleTreeOutput implements Serializable{
	private String ID;//主键
	private String RULE_TREE_ID;//决策树
	private String TREE_NODE_CODE;//节点代码
	private String TREE_NODE_NAME;//节点名称
	private String OUTPUT_VER;//输出变量
	private String OUTPUT_VALUE;//输出值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getRuleTreeId() {
		return this.RULE_TREE_ID;
	}
	
	public void setRuleTreeId(String value) {
		this.RULE_TREE_ID = value;
	}
	

	public String getTreeNodeCode() {
		return this.TREE_NODE_CODE;
	}
	
	public void setTreeNodeCode(String value) {
		this.TREE_NODE_CODE = value;
	}
	

	public String getTreeNodeName() {
		return this.TREE_NODE_NAME;
	}
	
	public void setTreeNodeName(String value) {
		this.TREE_NODE_NAME = value;
	}
	

	public String getOutputVer() {
		return this.OUTPUT_VER;
	}
	
	public void setOutputVer(String value) {
		this.OUTPUT_VER = value;
	}
	

	public String getOutputValue() {
		return this.OUTPUT_VALUE;
	}
	
	public void setOutputValue(String value) {
		this.OUTPUT_VALUE = value;
	}
	

}

package com.cartan.core.conditionPartitionNode.domain;
import java.io.Serializable;


/**
 * 条件细分节点
 */
public class ConditionPartitionNode implements Serializable{
	private String ID;//主键
	private String CON_PARTITION_ID;//条件细分模型
	private String CON_NODE_NAME;//节点名称
	private String RELATION_MARK;//关系符
	private String VAR_NAME;//变量
	private String OPT_CHAR;//操作符
	private String COMPARE_VALUE;//对比值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getConPartitionId() {
		return this.CON_PARTITION_ID;
	}
	
	public void setConPartitionId(String value) {
		this.CON_PARTITION_ID = value;
	}
	

	public String getConNodeName() {
		return this.CON_NODE_NAME;
	}
	
	public void setConNodeName(String value) {
		this.CON_NODE_NAME = value;
	}
	

	public String getRelationMark() {
		return this.RELATION_MARK;
	}
	
	public void setRelationMark(String value) {
		this.RELATION_MARK = value;
	}
	

	public String getVarName() {
		return this.VAR_NAME;
	}
	
	public void setVarName(String value) {
		this.VAR_NAME = value;
	}
	

	public String getOptChar() {
		return this.OPT_CHAR;
	}
	
	public void setOptChar(String value) {
		this.OPT_CHAR = value;
	}
	

	public String getCompareValue() {
		return this.COMPARE_VALUE;
	}
	
	public void setCompareValue(String value) {
		this.COMPARE_VALUE = value;
	}
	

}

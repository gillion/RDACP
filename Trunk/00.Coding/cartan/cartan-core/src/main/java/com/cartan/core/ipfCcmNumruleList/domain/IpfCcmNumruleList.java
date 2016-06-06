package com.cartan.core.ipfCcmNumruleList.domain;
import java.io.Serializable;


/**
 * IpfCcmNumruleList
 */
public class IpfCcmNumruleList implements Serializable{
	private String ID;//主键
	private String IPF_CCM_NUMRULE_ID;//单号生成规则
	private String CONST_EXPRESSION;//规则内容
	private String CURRENT_VALUE;//当前值
	private String INITIAL_VALUE;//初始值
	private String MAX_VALUE;//最大值
	private String GROWTH;//增长值
	private String REMARK;//备注
	private String IS_ACTIVE;//有效
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmNumruleId() {
		return this.IPF_CCM_NUMRULE_ID;
	}
	
	public void setIpfCcmNumruleId(String value) {
		this.IPF_CCM_NUMRULE_ID = value;
	}
	

	public String getConstExpression() {
		return this.CONST_EXPRESSION;
	}
	
	public void setConstExpression(String value) {
		this.CONST_EXPRESSION = value;
	}
	

	public String getCurrentValue() {
		return this.CURRENT_VALUE;
	}
	
	public void setCurrentValue(String value) {
		this.CURRENT_VALUE = value;
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
	

}

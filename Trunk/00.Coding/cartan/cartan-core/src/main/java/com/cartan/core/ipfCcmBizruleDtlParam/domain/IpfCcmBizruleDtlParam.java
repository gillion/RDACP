package com.cartan.core.ipfCcmBizruleDtlParam.domain;
import java.io.Serializable;


/**
 * IpfCcmBizruleDtlParam
 */
public class IpfCcmBizruleDtlParam implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BIZRULE_ID;//规则
	private String IPF_CCM_STRATEGY_ID;//策略ID
	private String IPF_CCM_STRATEGY_PARAM_ID;//策略参数ID
	private String PARAM_NAME;//参数名
	private String PARAM_DES;//参数描述
	private String PARAM_VALUE;//参数值
	private String PARAM_VALUE_DES;//参数值说明
	
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
	

	public String getIpfCcmStrategyParamId() {
		return this.IPF_CCM_STRATEGY_PARAM_ID;
	}
	
	public void setIpfCcmStrategyParamId(String value) {
		this.IPF_CCM_STRATEGY_PARAM_ID = value;
	}
	

	public String getParamName() {
		return this.PARAM_NAME;
	}
	
	public void setParamName(String value) {
		this.PARAM_NAME = value;
	}
	

	public String getParamDes() {
		return this.PARAM_DES;
	}
	
	public void setParamDes(String value) {
		this.PARAM_DES = value;
	}
	

	public String getParamValue() {
		return this.PARAM_VALUE;
	}
	
	public void setParamValue(String value) {
		this.PARAM_VALUE = value;
	}
	

	public String getParamValueDes() {
		return this.PARAM_VALUE_DES;
	}
	
	public void setParamValueDes(String value) {
		this.PARAM_VALUE_DES = value;
	}
	

}

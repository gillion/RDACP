package com.cartan.core.ipfCcmStrategyParam.domain;
import java.io.Serializable;


/**
 * IpfCcmStrategyParam
 */
public class IpfCcmStrategyParam implements Serializable{
	private String ID;//主键
	private String IPF_CCM_STRATEGY_ID;//策略
	private String PARAM_TYPE;//参数类型
	private String PARAM_NAME;//参数名
	private String PARAM_DES;//参数描述
	private String RTM_CONFIG_CODE;//运行期配置
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmStrategyId() {
		return this.IPF_CCM_STRATEGY_ID;
	}
	
	public void setIpfCcmStrategyId(String value) {
		this.IPF_CCM_STRATEGY_ID = value;
	}
	

	public String getParamType() {
		return this.PARAM_TYPE;
	}
	
	public void setParamType(String value) {
		this.PARAM_TYPE = value;
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
	

	public String getRtmConfigCode() {
		return this.RTM_CONFIG_CODE;
	}
	
	public void setRtmConfigCode(String value) {
		this.RTM_CONFIG_CODE = value;
	}
	

}

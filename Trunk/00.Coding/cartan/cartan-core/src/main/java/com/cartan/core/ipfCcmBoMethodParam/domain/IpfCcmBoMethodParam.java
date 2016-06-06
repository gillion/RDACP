package com.cartan.core.ipfCcmBoMethodParam.domain;
import java.io.Serializable;


/**
 * IpfCcmBoMethodParam
 */
public class IpfCcmBoMethodParam implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_METHOD_ID;//方法
	private String CONSTANT_VALUE;//常量值
	private String IS_CONDITION;//查询条件
	private String METHOD_NAME;//方法名
	private String PARAM_NAME;//参数名
	private String PARAM_REF;//属性名
	private String PARAM_TYPE;//参数值来源类型
	private String BO_NAME_REF;//业务对象名
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmBoMethodId() {
		return this.IPF_CCM_BO_METHOD_ID;
	}
	
	public void setIpfCcmBoMethodId(String value) {
		this.IPF_CCM_BO_METHOD_ID = value;
	}
	

	public String getConstantValue() {
		return this.CONSTANT_VALUE;
	}
	
	public void setConstantValue(String value) {
		this.CONSTANT_VALUE = value;
	}
	

	public String getIsCondition() {
		return this.IS_CONDITION;
	}
	
	public void setIsCondition(String value) {
		this.IS_CONDITION = value;
	}
	

	public String getMethodName() {
		return this.METHOD_NAME;
	}
	
	public void setMethodName(String value) {
		this.METHOD_NAME = value;
	}
	

	public String getParamName() {
		return this.PARAM_NAME;
	}
	
	public void setParamName(String value) {
		this.PARAM_NAME = value;
	}
	

	public String getParamRef() {
		return this.PARAM_REF;
	}
	
	public void setParamRef(String value) {
		this.PARAM_REF = value;
	}
	

	public String getParamType() {
		return this.PARAM_TYPE;
	}
	
	public void setParamType(String value) {
		this.PARAM_TYPE = value;
	}
	

	public String getBoNameRef() {
		return this.BO_NAME_REF;
	}
	
	public void setBoNameRef(String value) {
		this.BO_NAME_REF = value;
	}
	

}

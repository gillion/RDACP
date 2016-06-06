package com.cartan.core.ipfRuleFilter.domain;
import java.io.Serializable;


/**
 * IpfRuleFilter
 */
public class IpfRuleFilter implements Serializable{
	private String ID;//主键
	private String FILTER_CODE;//筛选编号
	private String FILTER_NAME;//筛选名称
	private String FILTER_DESC;//描述
	private String FILTER_EXPRESS;//筛选条件表达式
	private String IS_ACTIVE;//有效
	private String IS_SYSTEM_CREATE;//系统创建
	private String IPF_CCM_BO_ID;//业务对象ID
	private String BO_NAME;//业务对象名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getFilterCode() {
		return this.FILTER_CODE;
	}
	
	public void setFilterCode(String value) {
		this.FILTER_CODE = value;
	}
	

	public String getFilterName() {
		return this.FILTER_NAME;
	}
	
	public void setFilterName(String value) {
		this.FILTER_NAME = value;
	}
	

	public String getFilterDesc() {
		return this.FILTER_DESC;
	}
	
	public void setFilterDesc(String value) {
		this.FILTER_DESC = value;
	}
	

	public String getFilterExpress() {
		return this.FILTER_EXPRESS;
	}
	
	public void setFilterExpress(String value) {
		this.FILTER_EXPRESS = value;
	}
	

	public String getIsActive() {
		return this.IS_ACTIVE;
	}
	
	public void setIsActive(String value) {
		this.IS_ACTIVE = value;
	}
	

	public String getIsSystemCreate() {
		return this.IS_SYSTEM_CREATE;
	}
	
	public void setIsSystemCreate(String value) {
		this.IS_SYSTEM_CREATE = value;
	}
	

	public String getIpfCcmBoId() {
		return this.IPF_CCM_BO_ID;
	}
	
	public void setIpfCcmBoId(String value) {
		this.IPF_CCM_BO_ID = value;
	}
	

	public String getBoName() {
		return this.BO_NAME;
	}
	
	public void setBoName(String value) {
		this.BO_NAME = value;
	}
	

}

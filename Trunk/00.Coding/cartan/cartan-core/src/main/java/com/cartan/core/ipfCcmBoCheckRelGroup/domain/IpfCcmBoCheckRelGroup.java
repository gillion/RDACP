package com.cartan.core.ipfCcmBoCheckRelGroup.domain;
import java.io.Serializable;


/**
 * IpfCcmBoCheckRelGroup
 */
public class IpfCcmBoCheckRelGroup implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_CHECK_ID;//校验
	private String GROUP_NAME;//分组名称
	private String GROUP_DESC;//分组描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmBoCheckId() {
		return this.IPF_CCM_BO_CHECK_ID;
	}
	
	public void setIpfCcmBoCheckId(String value) {
		this.IPF_CCM_BO_CHECK_ID = value;
	}
	

	public String getGroupName() {
		return this.GROUP_NAME;
	}
	
	public void setGroupName(String value) {
		this.GROUP_NAME = value;
	}
	

	public String getGroupDesc() {
		return this.GROUP_DESC;
	}
	
	public void setGroupDesc(String value) {
		this.GROUP_DESC = value;
	}
	

}

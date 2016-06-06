package com.cartan.core.ipfCcmBoCheckGroup.domain;
import java.io.Serializable;


/**
 * IpfCcmBoCheckGroup
 */
public class IpfCcmBoCheckGroup implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_ID;//业务对象
	private String GROUP_NAME;//分组名称
	private String GROUP_DESC;//分组描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmBoId() {
		return this.IPF_CCM_BO_ID;
	}
	
	public void setIpfCcmBoId(String value) {
		this.IPF_CCM_BO_ID = value;
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

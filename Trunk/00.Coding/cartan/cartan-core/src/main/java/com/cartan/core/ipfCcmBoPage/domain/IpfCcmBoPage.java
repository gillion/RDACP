package com.cartan.core.ipfCcmBoPage.domain;
import java.io.Serializable;


/**
 * IpfCcmBoPage
 */
public class IpfCcmBoPage implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_ID;//业务对象
	private String PAGE_TYPE;//页面类型
	private String DESCRIPTION;//描述
	private String PAGE_NAME;//页面名称
	
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
	

	public String getPageType() {
		return this.PAGE_TYPE;
	}
	
	public void setPageType(String value) {
		this.PAGE_TYPE = value;
	}
	

	public String getDescription() {
		return this.DESCRIPTION;
	}
	
	public void setDescription(String value) {
		this.DESCRIPTION = value;
	}
	

	public String getPageName() {
		return this.PAGE_NAME;
	}
	
	public void setPageName(String value) {
		this.PAGE_NAME = value;
	}
	

}

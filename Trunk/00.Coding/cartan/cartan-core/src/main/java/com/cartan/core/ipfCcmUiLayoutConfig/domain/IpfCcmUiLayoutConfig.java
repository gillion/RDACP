package com.cartan.core.ipfCcmUiLayoutConfig.domain;
import java.io.Serializable;


/**
 * IpfCcmUiLayoutConfig
 */
public class IpfCcmUiLayoutConfig implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_ID;//业务对象
	private String BO_ID;//业务对象ID
	private String PAGE_NAME;//页面名称
	private String LAYOUT_ELEMENT_NAME;//布局元素名称
	private String LAYOUT_ELEMENT_DESCRIPTION;//布局元素描述
	private String BO_NAME;//业务对象名称
	private String BO_ELEMENT_NAME;//业务对象布局元素名称
	
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
	

	public String getBoId() {
		return this.BO_ID;
	}
	
	public void setBoId(String value) {
		this.BO_ID = value;
	}
	

	public String getPageName() {
		return this.PAGE_NAME;
	}
	
	public void setPageName(String value) {
		this.PAGE_NAME = value;
	}
	

	public String getLayoutElementName() {
		return this.LAYOUT_ELEMENT_NAME;
	}
	
	public void setLayoutElementName(String value) {
		this.LAYOUT_ELEMENT_NAME = value;
	}
	

	public String getLayoutElementDescription() {
		return this.LAYOUT_ELEMENT_DESCRIPTION;
	}
	
	public void setLayoutElementDescription(String value) {
		this.LAYOUT_ELEMENT_DESCRIPTION = value;
	}
	

	public String getBoName() {
		return this.BO_NAME;
	}
	
	public void setBoName(String value) {
		this.BO_NAME = value;
	}
	

	public String getBoElementName() {
		return this.BO_ELEMENT_NAME;
	}
	
	public void setBoElementName(String value) {
		this.BO_ELEMENT_NAME = value;
	}
	

}

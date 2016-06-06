package com.cartan.core.ipfCcmUiLayoutDetail.domain;
import java.io.Serializable;


/**
 * IpfCcmUiLayoutDetail
 */
public class IpfCcmUiLayoutDetail implements Serializable{
	private String ID;//主键
	private String IPF_CCM_UI_LAYOUT_ID;//界面布局
	private String IPF_CCM_UI_LAYOUT_LIST_ID;//界面布局列表
	private String LAYOUT_ELEMENT_NAME;//名称
	private String DESCRIPTION;//描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmUiLayoutId() {
		return this.IPF_CCM_UI_LAYOUT_ID;
	}
	
	public void setIpfCcmUiLayoutId(String value) {
		this.IPF_CCM_UI_LAYOUT_ID = value;
	}
	

	public String getIpfCcmUiLayoutListId() {
		return this.IPF_CCM_UI_LAYOUT_LIST_ID;
	}
	
	public void setIpfCcmUiLayoutListId(String value) {
		this.IPF_CCM_UI_LAYOUT_LIST_ID = value;
	}
	

	public String getLayoutElementName() {
		return this.LAYOUT_ELEMENT_NAME;
	}
	
	public void setLayoutElementName(String value) {
		this.LAYOUT_ELEMENT_NAME = value;
	}
	

	public String getDescription() {
		return this.DESCRIPTION;
	}
	
	public void setDescription(String value) {
		this.DESCRIPTION = value;
	}
	

}

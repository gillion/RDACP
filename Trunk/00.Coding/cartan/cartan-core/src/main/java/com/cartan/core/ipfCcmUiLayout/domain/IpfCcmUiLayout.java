package com.cartan.core.ipfCcmUiLayout.domain;
import java.io.Serializable;


/**
 * IpfCcmUiLayout
 */
public class IpfCcmUiLayout implements Serializable{
	private String ID;//主键
	private String UI_LAYOUT_NAME;//名称
	private String DESCRIPTION;//描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getUiLayoutName() {
		return this.UI_LAYOUT_NAME;
	}
	
	public void setUiLayoutName(String value) {
		this.UI_LAYOUT_NAME = value;
	}
	

	public String getDescription() {
		return this.DESCRIPTION;
	}
	
	public void setDescription(String value) {
		this.DESCRIPTION = value;
	}
	

}

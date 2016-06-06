package com.cartan.core.ipfCcmUiLayoutList.domain;
import java.io.Serializable;


/**
 * IpfCcmUiLayoutList
 */
public class IpfCcmUiLayoutList implements Serializable{
	private String ID;//主键
	private String IPF_CCM_UI_LAYOUT_ID;//界面布局
	private String PAGE_NAME;//名称
	private String DESCRIPTION;//描述
	private String IMAGE_PATH;//图片路径
	
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
	

	public String getPageName() {
		return this.PAGE_NAME;
	}
	
	public void setPageName(String value) {
		this.PAGE_NAME = value;
	}
	

	public String getDescription() {
		return this.DESCRIPTION;
	}
	
	public void setDescription(String value) {
		this.DESCRIPTION = value;
	}
	

	public String getImagePath() {
		return this.IMAGE_PATH;
	}
	
	public void setImagePath(String value) {
		this.IMAGE_PATH = value;
	}
	

}

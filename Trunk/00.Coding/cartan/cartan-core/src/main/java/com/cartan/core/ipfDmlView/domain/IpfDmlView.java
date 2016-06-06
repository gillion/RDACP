package com.cartan.core.ipfDmlView.domain;
import java.io.Serializable;


/**
 * IpfDmlView
 */
public class IpfDmlView implements Serializable{
	private String ID;//主键
	private String VIEW_NAME;//视图名称
	private String VIEW_DES;//视图描述
	private String VIEW_TYPE;//视图类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getViewName() {
		return this.VIEW_NAME;
	}
	
	public void setViewName(String value) {
		this.VIEW_NAME = value;
	}
	

	public String getViewDes() {
		return this.VIEW_DES;
	}
	
	public void setViewDes(String value) {
		this.VIEW_DES = value;
	}
	

	public String getViewType() {
		return this.VIEW_TYPE;
	}
	
	public void setViewType(String value) {
		this.VIEW_TYPE = value;
	}
	

}

package com.cartan.core.ipfDmlElementText.domain;
import java.io.Serializable;


/**
 * IpfDmlElementText
 */
public class IpfDmlElementText implements Serializable{
	private String ID;//主键
	private String IPF_DML_ELEMENT_ID;//数据元素
	private String DD_LANGUAGE;//语言
	private String DD_TEXT;//文本描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfDmlElementId() {
		return this.IPF_DML_ELEMENT_ID;
	}
	
	public void setIpfDmlElementId(String value) {
		this.IPF_DML_ELEMENT_ID = value;
	}
	

	public String getDdLanguage() {
		return this.DD_LANGUAGE;
	}
	
	public void setDdLanguage(String value) {
		this.DD_LANGUAGE = value;
	}
	

	public String getDdText() {
		return this.DD_TEXT;
	}
	
	public void setDdText(String value) {
		this.DD_TEXT = value;
	}
	

}

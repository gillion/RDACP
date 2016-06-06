package com.cartan.core.ipfCcmShlpText.domain;
import java.io.Serializable;


/**
 * IpfCcmShlpText
 */
public class IpfCcmShlpText implements Serializable{
	private String ID;//主键
	private String IPF_CCM_SHLP_ID;//搜索帮助
	private String DD_LANGUAGE;//语言
	private String DD_TEXT;//文本描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmShlpId() {
		return this.IPF_CCM_SHLP_ID;
	}
	
	public void setIpfCcmShlpId(String value) {
		this.IPF_CCM_SHLP_ID = value;
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

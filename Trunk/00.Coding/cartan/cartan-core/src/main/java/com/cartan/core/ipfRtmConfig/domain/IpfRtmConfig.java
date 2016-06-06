package com.cartan.core.ipfRtmConfig.domain;
import java.io.Serializable;


/**
 * IpfRtmConfig
 */
public class IpfRtmConfig implements Serializable{
	private String ID;//主键
	private String CONFIG_CODE;//配置代码
	private String CONFIG_NAME;//配置名称
	private String TYPE_CODE;//类别代码
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getConfigCode() {
		return this.CONFIG_CODE;
	}
	
	public void setConfigCode(String value) {
		this.CONFIG_CODE = value;
	}
	

	public String getConfigName() {
		return this.CONFIG_NAME;
	}
	
	public void setConfigName(String value) {
		this.CONFIG_NAME = value;
	}
	

	public String getTypeCode() {
		return this.TYPE_CODE;
	}
	
	public void setTypeCode(String value) {
		this.TYPE_CODE = value;
	}
	

}

package com.cartan.core.ipfRtmConfigAttrBo.domain;
import java.io.Serializable;


/**
 * IpfRtmConfigAttrBo
 */
public class IpfRtmConfigAttrBo implements Serializable{
	private String ID;//主键
	private String IPF_RTM_CONFIG_ATTR_ID;//运行期配置明细
	private String IPF_RTM_CONFIG_ID;//运行期配置明细
	private String IPF_CCM_BO_ID;//业务对象ID
	private String BO_NAME;//业务对象名称
	private String BO_DESC;//业务对象描述
	private String BO_ATTRIBUTE_NAME;//属性名称
	private String IS_VISIBLE;//可见
	private String IS_REQUIRED;//必输
	private String DEFAULT_VALUE;//默认值
	private String SHLP_VALUE_FILED;//搜索帮助值字段
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfRtmConfigAttrId() {
		return this.IPF_RTM_CONFIG_ATTR_ID;
	}
	
	public void setIpfRtmConfigAttrId(String value) {
		this.IPF_RTM_CONFIG_ATTR_ID = value;
	}
	

	public String getIpfRtmConfigId() {
		return this.IPF_RTM_CONFIG_ID;
	}
	
	public void setIpfRtmConfigId(String value) {
		this.IPF_RTM_CONFIG_ID = value;
	}
	

	public String getIpfCcmBoId() {
		return this.IPF_CCM_BO_ID;
	}
	
	public void setIpfCcmBoId(String value) {
		this.IPF_CCM_BO_ID = value;
	}
	

	public String getBoName() {
		return this.BO_NAME;
	}
	
	public void setBoName(String value) {
		this.BO_NAME = value;
	}
	

	public String getBoDesc() {
		return this.BO_DESC;
	}
	
	public void setBoDesc(String value) {
		this.BO_DESC = value;
	}
	

	public String getBoAttributeName() {
		return this.BO_ATTRIBUTE_NAME;
	}
	
	public void setBoAttributeName(String value) {
		this.BO_ATTRIBUTE_NAME = value;
	}
	

	public String getIsVisible() {
		return this.IS_VISIBLE;
	}
	
	public void setIsVisible(String value) {
		this.IS_VISIBLE = value;
	}
	

	public String getIsRequired() {
		return this.IS_REQUIRED;
	}
	
	public void setIsRequired(String value) {
		this.IS_REQUIRED = value;
	}
	

	public String getDefaultValue() {
		return this.DEFAULT_VALUE;
	}
	
	public void setDefaultValue(String value) {
		this.DEFAULT_VALUE = value;
	}
	

	public String getShlpValueFiled() {
		return this.SHLP_VALUE_FILED;
	}
	
	public void setShlpValueFiled(String value) {
		this.SHLP_VALUE_FILED = value;
	}
	

}

package com.cartan.core.ipfRtmTypeBo.domain;
import java.io.Serializable;


/**
 * IpfRtmTypeBo
 */
public class IpfRtmTypeBo implements Serializable{
	private String ID;//主键
	private String IPF_RTM_TYPE_ID;//运行期配置类型
	private String IPF_CCM_BO_ID;//业务对象ID
	private String BO_NAME;//业务对象名称
	private String BO_DESC;//业务对象描述
	private String PROPERTY_NAME;//业务对象属性名称
	private String PROPERTY_UTILITY;//属性用途
	private String EXTERNAL_BO_NAME;//外部业务对象名称
	private String EXTERNAL_MATCH_PROPERTY;//查询匹配属性
	private String EXTERNAL_RESULT_PROPERTY;//结果属性
	private String EXTERNAL_BO_ID;//外部业务对象ID
	private String TRIGGER_PROPERTY_NAME;//触发属性名
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfRtmTypeId() {
		return this.IPF_RTM_TYPE_ID;
	}
	
	public void setIpfRtmTypeId(String value) {
		this.IPF_RTM_TYPE_ID = value;
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
	

	public String getPropertyName() {
		return this.PROPERTY_NAME;
	}
	
	public void setPropertyName(String value) {
		this.PROPERTY_NAME = value;
	}
	

	public String getPropertyUtility() {
		return this.PROPERTY_UTILITY;
	}
	
	public void setPropertyUtility(String value) {
		this.PROPERTY_UTILITY = value;
	}
	

	public String getExternalBoName() {
		return this.EXTERNAL_BO_NAME;
	}
	
	public void setExternalBoName(String value) {
		this.EXTERNAL_BO_NAME = value;
	}
	

	public String getExternalMatchProperty() {
		return this.EXTERNAL_MATCH_PROPERTY;
	}
	
	public void setExternalMatchProperty(String value) {
		this.EXTERNAL_MATCH_PROPERTY = value;
	}
	

	public String getExternalResultProperty() {
		return this.EXTERNAL_RESULT_PROPERTY;
	}
	
	public void setExternalResultProperty(String value) {
		this.EXTERNAL_RESULT_PROPERTY = value;
	}
	

	public String getExternalBoId() {
		return this.EXTERNAL_BO_ID;
	}
	
	public void setExternalBoId(String value) {
		this.EXTERNAL_BO_ID = value;
	}
	

	public String getTriggerPropertyName() {
		return this.TRIGGER_PROPERTY_NAME;
	}
	
	public void setTriggerPropertyName(String value) {
		this.TRIGGER_PROPERTY_NAME = value;
	}
	

}

package com.cartan.core.ipfRtmTypeBoMap.domain;
import java.io.Serializable;


/**
 * IpfRtmTypeBoMap
 */
public class IpfRtmTypeBoMap implements Serializable{
	private String ID;//主键
	private String IPF_RTM_TYPE_BO_ID;//运行期配置界面
	private String SOURCE_VALUE;//源值
	private String DEST_VALUE;//目标值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfRtmTypeBoId() {
		return this.IPF_RTM_TYPE_BO_ID;
	}
	
	public void setIpfRtmTypeBoId(String value) {
		this.IPF_RTM_TYPE_BO_ID = value;
	}
	

	public String getSourceValue() {
		return this.SOURCE_VALUE;
	}
	
	public void setSourceValue(String value) {
		this.SOURCE_VALUE = value;
	}
	

	public String getDestValue() {
		return this.DEST_VALUE;
	}
	
	public void setDestValue(String value) {
		this.DEST_VALUE = value;
	}
	

}

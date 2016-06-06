package com.cartan.core.ipfCcmDictValue.domain;
import java.io.Serializable;


/**
 * IpfCcmDictValue
 */
public class IpfCcmDictValue implements Serializable{
	private String ID;//主键
	private String IPF_CCM_DICT_ID;//业务对象
	private String CODE_VALUE;//代码值
	private String DISPLAY_VALUE;//显示值
	private String SEQ_NO;//顺序号
	private String GROUP_VALUE;//分组值
	private String REMARK;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmDictId() {
		return this.IPF_CCM_DICT_ID;
	}
	
	public void setIpfCcmDictId(String value) {
		this.IPF_CCM_DICT_ID = value;
	}
	

	public String getCodeValue() {
		return this.CODE_VALUE;
	}
	
	public void setCodeValue(String value) {
		this.CODE_VALUE = value;
	}
	

	public String getDisplayValue() {
		return this.DISPLAY_VALUE;
	}
	
	public void setDisplayValue(String value) {
		this.DISPLAY_VALUE = value;
	}
	

	public String getSeqNo() {
		return this.SEQ_NO;
	}
	
	public void setSeqNo(String value) {
		this.SEQ_NO = value;
	}
	

	public String getGroupValue() {
		return this.GROUP_VALUE;
	}
	
	public void setGroupValue(String value) {
		this.GROUP_VALUE = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

}

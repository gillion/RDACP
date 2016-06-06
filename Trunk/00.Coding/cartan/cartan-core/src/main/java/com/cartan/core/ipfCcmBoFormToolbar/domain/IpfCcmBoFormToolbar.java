package com.cartan.core.ipfCcmBoFormToolbar.domain;
import java.io.Serializable;


/**
 * IpfCcmBoFormToolbar
 */
public class IpfCcmBoFormToolbar implements Serializable{
	private String ID;//主键
	private String IPF_CCB_BO_ID;//业务对象
	private String METHOD_NAME;//调用方法名称
	private String METHOD_DESC;//调用方法描述
	private String SEQ_NO;//顺序号
	private String METHOD_ID;//方法ID
	private String BUTTON_STYLE;//按钮样式
	private String DISABLED_EXPREE;//可编辑表达式
	private String IS_REFRESH_PARENT_BO;//刷新主表
	private String HOTKEY_TYPE;//热键类型
	private String HOTKEY_VALUE;//热键值
	private String IS_HIDE;//隐藏
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcbBoId() {
		return this.IPF_CCB_BO_ID;
	}
	
	public void setIpfCcbBoId(String value) {
		this.IPF_CCB_BO_ID = value;
	}
	

	public String getMethodName() {
		return this.METHOD_NAME;
	}
	
	public void setMethodName(String value) {
		this.METHOD_NAME = value;
	}
	

	public String getMethodDesc() {
		return this.METHOD_DESC;
	}
	
	public void setMethodDesc(String value) {
		this.METHOD_DESC = value;
	}
	

	public String getSeqNo() {
		return this.SEQ_NO;
	}
	
	public void setSeqNo(String value) {
		this.SEQ_NO = value;
	}
	

	public String getMethodId() {
		return this.METHOD_ID;
	}
	
	public void setMethodId(String value) {
		this.METHOD_ID = value;
	}
	

	public String getButtonStyle() {
		return this.BUTTON_STYLE;
	}
	
	public void setButtonStyle(String value) {
		this.BUTTON_STYLE = value;
	}
	

	public String getDisabledExpree() {
		return this.DISABLED_EXPREE;
	}
	
	public void setDisabledExpree(String value) {
		this.DISABLED_EXPREE = value;
	}
	

	public String getIsRefreshParentBo() {
		return this.IS_REFRESH_PARENT_BO;
	}
	
	public void setIsRefreshParentBo(String value) {
		this.IS_REFRESH_PARENT_BO = value;
	}
	

	public String getHotkeyType() {
		return this.HOTKEY_TYPE;
	}
	
	public void setHotkeyType(String value) {
		this.HOTKEY_TYPE = value;
	}
	

	public String getHotkeyValue() {
		return this.HOTKEY_VALUE;
	}
	
	public void setHotkeyValue(String value) {
		this.HOTKEY_VALUE = value;
	}
	

	public String getIsHide() {
		return this.IS_HIDE;
	}
	
	public void setIsHide(String value) {
		this.IS_HIDE = value;
	}
	

}

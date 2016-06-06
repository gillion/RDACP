package com.cartan.core.ipfCcmBoControlEvent.domain;
import java.io.Serializable;


/**
 * IpfCcmBoControlEvent
 */
public class IpfCcmBoControlEvent implements Serializable{
	private String ID;//主键
	private String IPF_CCB_BO_FORM_COLUMN_ID;//编辑页
	private String EVENT_TYPE;//事件类型
	private String EXEC_TYPE;//执行类型
	private String EXEC_CONTENT;//执行类型
	private String CALL_BACK;//回调JS
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcbBoFormColumnId() {
		return this.IPF_CCB_BO_FORM_COLUMN_ID;
	}
	
	public void setIpfCcbBoFormColumnId(String value) {
		this.IPF_CCB_BO_FORM_COLUMN_ID = value;
	}
	

	public String getEventType() {
		return this.EVENT_TYPE;
	}
	
	public void setEventType(String value) {
		this.EVENT_TYPE = value;
	}
	

	public String getExecType() {
		return this.EXEC_TYPE;
	}
	
	public void setExecType(String value) {
		this.EXEC_TYPE = value;
	}
	

	public String getExecContent() {
		return this.EXEC_CONTENT;
	}
	
	public void setExecContent(String value) {
		this.EXEC_CONTENT = value;
	}
	

	public String getCallBack() {
		return this.CALL_BACK;
	}
	
	public void setCallBack(String value) {
		this.CALL_BACK = value;
	}
	

}

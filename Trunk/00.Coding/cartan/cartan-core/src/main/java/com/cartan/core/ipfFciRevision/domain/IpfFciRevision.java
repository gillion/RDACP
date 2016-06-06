package com.cartan.core.ipfFciRevision.domain;
import java.io.Serializable;


/**
 * IpfFciRevision
 */
public class IpfFciRevision implements Serializable{
	private String ID;//主键
	private String IPF_FCI_VIEW_ID;//视图
	private String IPF_FCI_PROJECT_ID;//项目
	private String REVISION_NUMBER;//修订号
	private String REMARK;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfFciViewId() {
		return this.IPF_FCI_VIEW_ID;
	}
	
	public void setIpfFciViewId(String value) {
		this.IPF_FCI_VIEW_ID = value;
	}
	

	public String getIpfFciProjectId() {
		return this.IPF_FCI_PROJECT_ID;
	}
	
	public void setIpfFciProjectId(String value) {
		this.IPF_FCI_PROJECT_ID = value;
	}
	

	public String getRevisionNumber() {
		return this.REVISION_NUMBER;
	}
	
	public void setRevisionNumber(String value) {
		this.REVISION_NUMBER = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

}

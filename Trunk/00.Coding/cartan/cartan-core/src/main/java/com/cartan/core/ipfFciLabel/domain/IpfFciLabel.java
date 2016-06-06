package com.cartan.core.ipfFciLabel.domain;
import java.io.Serializable;


/**
 * IpfFciLabel
 */
public class IpfFciLabel implements Serializable{
	private String ID;//主键
	private String IPF_FCI_VIEW_ID;//视图
	private String LABEL_NAME;//基线名称
	private String LABEL_DESC;//基线描述
	private String IPF_FCI_BUILD_ID;//编译号
	private String MAJOR_VERSION;//主版本号
	private String MINOR_VERSION;//次版本号
	private String VERSION_BUILD_NUMBER;//版本编译号
	private String REVISION_NUMBER;//修订号
	private String SVN_REVISION;//SVN修订号
	private String SVN_TAGS_PATH;//SVN基线路径
	private String IS_ACTIVE;//启用
	private String VIEW_NAME;//视图名称
	
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
	

	public String getLabelName() {
		return this.LABEL_NAME;
	}
	
	public void setLabelName(String value) {
		this.LABEL_NAME = value;
	}
	

	public String getLabelDesc() {
		return this.LABEL_DESC;
	}
	
	public void setLabelDesc(String value) {
		this.LABEL_DESC = value;
	}
	

	public String getIpfFciBuildId() {
		return this.IPF_FCI_BUILD_ID;
	}
	
	public void setIpfFciBuildId(String value) {
		this.IPF_FCI_BUILD_ID = value;
	}
	

	public String getMajorVersion() {
		return this.MAJOR_VERSION;
	}
	
	public void setMajorVersion(String value) {
		this.MAJOR_VERSION = value;
	}
	

	public String getMinorVersion() {
		return this.MINOR_VERSION;
	}
	
	public void setMinorVersion(String value) {
		this.MINOR_VERSION = value;
	}
	

	public String getVersionBuildNumber() {
		return this.VERSION_BUILD_NUMBER;
	}
	
	public void setVersionBuildNumber(String value) {
		this.VERSION_BUILD_NUMBER = value;
	}
	

	public String getRevisionNumber() {
		return this.REVISION_NUMBER;
	}
	
	public void setRevisionNumber(String value) {
		this.REVISION_NUMBER = value;
	}
	

	public String getSvnRevision() {
		return this.SVN_REVISION;
	}
	
	public void setSvnRevision(String value) {
		this.SVN_REVISION = value;
	}
	

	public String getSvnTagsPath() {
		return this.SVN_TAGS_PATH;
	}
	
	public void setSvnTagsPath(String value) {
		this.SVN_TAGS_PATH = value;
	}
	

	public String getIsActive() {
		return this.IS_ACTIVE;
	}
	
	public void setIsActive(String value) {
		this.IS_ACTIVE = value;
	}
	

	public String getViewName() {
		return this.VIEW_NAME;
	}
	
	public void setViewName(String value) {
		this.VIEW_NAME = value;
	}
	

}

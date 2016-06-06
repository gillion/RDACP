package com.cartan.core.ipfFciBuild.domain;
import java.io.Serializable;


/**
 * IpfFciBuild
 */
public class IpfFciBuild implements Serializable{
	private String ID;//主键
	private String IPF_FCI_VIEW_ID;//视图
	private String IPF_FCI_PROJECT_ID;//项目
	private String MAJOR_VERSION;//主版本号
	private String MINOR_VERSION;//次版本号
	private String MAX_VERSION_BUILD_NUMBER;//最大版本编译号
	private String IS_DEFAULT;//是否默认
	
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
	

	public String getMaxVersionBuildNumber() {
		return this.MAX_VERSION_BUILD_NUMBER;
	}
	
	public void setMaxVersionBuildNumber(String value) {
		this.MAX_VERSION_BUILD_NUMBER = value;
	}
	

	public String getIsDefault() {
		return this.IS_DEFAULT;
	}
	
	public void setIsDefault(String value) {
		this.IS_DEFAULT = value;
	}
	

}

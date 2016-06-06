package com.cartan.core.ipfFciView.domain;
import java.io.Serializable;


/**
 * IpfFciView
 */
public class IpfFciView implements Serializable{
	private String ID;//主键
	private String VIEW_NAME;//视图名称
	private String PROJECT_NAME;//项目名称
	private String VIEW_DESC;//视图描述
	private String SVN_BRANCHES_PATH;//SVN路径
	private String IS_ACTIVE;//启用
	private String CONNECTION_STRING;//目标数据库连接
	private String IPF_FCI_PROJECT_ID;//所属项目
	private String SOURCE_LABEL_ID;//基线名称
	private String IS_PERMISSION_PAGE_ONLY;//只生成页面权限
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getViewName() {
		return this.VIEW_NAME;
	}
	
	public void setViewName(String value) {
		this.VIEW_NAME = value;
	}
	

	public String getProjectName() {
		return this.PROJECT_NAME;
	}
	
	public void setProjectName(String value) {
		this.PROJECT_NAME = value;
	}
	

	public String getViewDesc() {
		return this.VIEW_DESC;
	}
	
	public void setViewDesc(String value) {
		this.VIEW_DESC = value;
	}
	

	public String getSvnBranchesPath() {
		return this.SVN_BRANCHES_PATH;
	}
	
	public void setSvnBranchesPath(String value) {
		this.SVN_BRANCHES_PATH = value;
	}
	

	public String getIsActive() {
		return this.IS_ACTIVE;
	}
	
	public void setIsActive(String value) {
		this.IS_ACTIVE = value;
	}
	

	public String getConnectionString() {
		return this.CONNECTION_STRING;
	}
	
	public void setConnectionString(String value) {
		this.CONNECTION_STRING = value;
	}
	

	public String getIpfFciProjectId() {
		return this.IPF_FCI_PROJECT_ID;
	}
	
	public void setIpfFciProjectId(String value) {
		this.IPF_FCI_PROJECT_ID = value;
	}
	

	public String getSourceLabelId() {
		return this.SOURCE_LABEL_ID;
	}
	
	public void setSourceLabelId(String value) {
		this.SOURCE_LABEL_ID = value;
	}
	

	public String getIsPermissionPageOnly() {
		return this.IS_PERMISSION_PAGE_ONLY;
	}
	
	public void setIsPermissionPageOnly(String value) {
		this.IS_PERMISSION_PAGE_ONLY = value;
	}
	

}

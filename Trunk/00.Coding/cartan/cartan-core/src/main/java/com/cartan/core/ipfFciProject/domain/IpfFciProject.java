package com.cartan.core.ipfFciProject.domain;
import java.io.Serializable;


/**
 * IpfFciProject
 */
public class IpfFciProject implements Serializable{
	private String ID;//主键
	private String PROJECT_NAME;//项目名称
	private String PROJECT_TYPE;//项目类型
	private String PROJECT_DES;//项目描述
	private String DEFAULT_VIEW_ID;//默认视图
	private String SVN_REPOSITORY_PATH;//SVN路径
	private String SVN_USER;//SVN帐户
	private String SVN_PASSWORD;//SVN密码
	private String MAX_REVISON_NUMBER;//最大修订号
	private String DD_LANGUAGE;//默认语言
	private String DB_TYPE;//数据库类型
	private String DB_VERSION;//数据库版本号
	private String IS_ACTIVE;//启用
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getProjectName() {
		return this.PROJECT_NAME;
	}
	
	public void setProjectName(String value) {
		this.PROJECT_NAME = value;
	}
	

	public String getProjectType() {
		return this.PROJECT_TYPE;
	}
	
	public void setProjectType(String value) {
		this.PROJECT_TYPE = value;
	}
	

	public String getProjectDes() {
		return this.PROJECT_DES;
	}
	
	public void setProjectDes(String value) {
		this.PROJECT_DES = value;
	}
	

	public String getDefaultViewId() {
		return this.DEFAULT_VIEW_ID;
	}
	
	public void setDefaultViewId(String value) {
		this.DEFAULT_VIEW_ID = value;
	}
	

	public String getSvnRepositoryPath() {
		return this.SVN_REPOSITORY_PATH;
	}
	
	public void setSvnRepositoryPath(String value) {
		this.SVN_REPOSITORY_PATH = value;
	}
	

	public String getSvnUser() {
		return this.SVN_USER;
	}
	
	public void setSvnUser(String value) {
		this.SVN_USER = value;
	}
	

	public String getSvnPassword() {
		return this.SVN_PASSWORD;
	}
	
	public void setSvnPassword(String value) {
		this.SVN_PASSWORD = value;
	}
	

	public String getMaxRevisonNumber() {
		return this.MAX_REVISON_NUMBER;
	}
	
	public void setMaxRevisonNumber(String value) {
		this.MAX_REVISON_NUMBER = value;
	}
	

	public String getDdLanguage() {
		return this.DD_LANGUAGE;
	}
	
	public void setDdLanguage(String value) {
		this.DD_LANGUAGE = value;
	}
	

	public String getDbType() {
		return this.DB_TYPE;
	}
	
	public void setDbType(String value) {
		this.DB_TYPE = value;
	}
	

	public String getDbVersion() {
		return this.DB_VERSION;
	}
	
	public void setDbVersion(String value) {
		this.DB_VERSION = value;
	}
	

	public String getIsActive() {
		return this.IS_ACTIVE;
	}
	
	public void setIsActive(String value) {
		this.IS_ACTIVE = value;
	}
	

}

package com.cartan.core.ipfCcmEnvironment.domain;
import java.io.Serializable;


/**
 * IpfCcmEnvironment
 */
public class IpfCcmEnvironment implements Serializable{
	private String ID;//主键
	private String USER_CODE;//工程代码
	private String PROJECT_NAME;//工程名称
	private String PROJECT_PATH;//工程路径
	private String SRC_PATH;//原代码路径
	private String TEMPLATE_PATH;//模板工程目录
	private String WEB_CONTENT_NAME;//模板工程名称
	private String TARGET_PROJECT_NAME;//分支工程名称
	private String TARGET_PROJECT_PATH;//分支工程路径
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getUserCode() {
		return this.USER_CODE;
	}
	
	public void setUserCode(String value) {
		this.USER_CODE = value;
	}
	

	public String getProjectName() {
		return this.PROJECT_NAME;
	}
	
	public void setProjectName(String value) {
		this.PROJECT_NAME = value;
	}
	

	public String getProjectPath() {
		return this.PROJECT_PATH;
	}
	
	public void setProjectPath(String value) {
		this.PROJECT_PATH = value;
	}
	

	public String getSrcPath() {
		return this.SRC_PATH;
	}
	
	public void setSrcPath(String value) {
		this.SRC_PATH = value;
	}
	

	public String getTemplatePath() {
		return this.TEMPLATE_PATH;
	}
	
	public void setTemplatePath(String value) {
		this.TEMPLATE_PATH = value;
	}
	

	public String getWebContentName() {
		return this.WEB_CONTENT_NAME;
	}
	
	public void setWebContentName(String value) {
		this.WEB_CONTENT_NAME = value;
	}
	

	public String getTargetProjectName() {
		return this.TARGET_PROJECT_NAME;
	}
	
	public void setTargetProjectName(String value) {
		this.TARGET_PROJECT_NAME = value;
	}
	

	public String getTargetProjectPath() {
		return this.TARGET_PROJECT_PATH;
	}
	
	public void setTargetProjectPath(String value) {
		this.TARGET_PROJECT_PATH = value;
	}
	

}

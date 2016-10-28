package com.cartan.core.loginSession.domain;
import java.io.Serializable;


/**
 * LoginSession
 */
public class LoginSession implements Serializable{
	private String id;//编号
	private String sessionid;//会话
	private String loginUser;//登录用户
	private String UserName;//用户姓名
	private String loginTime;//登录时间
	private String projectName;//projectName
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String Id) {
		this.id = Id;
	}
	

	public String getSessionid() {
		return this.sessionid;
	}
	
	public void setSessionid(String value) {
		this.sessionid = value;
	}
	

	public String getLoginUser() {
		return this.loginUser;
	}
	
	public void setLoginUser(String value) {
		this.loginUser = value;
	}
	

	public String getUserName() {
		return this.UserName;
	}
	
	public void setUserName(String value) {
		this.UserName = value;
	}
	

	public String getLoginTime() {
		return this.loginTime;
	}
	
	public void setLoginTime(String value) {
		this.loginTime = value;
	}
	

	public String getProjectName() {
		return this.projectName;
	}
	
	public void setProjectName(String value) {
		this.projectName = value;
	}
	

}

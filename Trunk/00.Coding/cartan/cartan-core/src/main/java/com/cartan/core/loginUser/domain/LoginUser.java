package com.cartan.core.loginUser.domain;
import java.io.Serializable;


/**
 * LoginUser
 */
public class LoginUser implements Serializable{
	private String id;//编号
	private String user;//账号
	private String pwd;//密码
	private String power;//权限
	private String templateType;//templateType
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String Id) {
		this.id = Id;
	}
	

	public String getUser() {
		return this.user;
	}
	
	public void setUser(String value) {
		this.user = value;
	}
	

	public String getPwd() {
		return this.pwd;
	}
	
	public void setPwd(String value) {
		this.pwd = value;
	}
	

	public String getPower() {
		return this.power;
	}
	
	public void setPower(String value) {
		this.power = value;
	}
	

	public String getTemplateType() {
		return this.templateType;
	}
	
	public void setTemplateType(String value) {
		this.templateType = value;
	}
	

}

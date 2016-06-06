package com.cartan.core.sysUser.domain;
import java.io.Serializable;


/**
 * 平台系统用户表,保存平台管理员用户,开发人员用户的信息.
 */
public class SysUser implements Serializable{
	private String user_id;//userId
	private String user_name;//用户名
	private String password;//MD5加密密码
	private String user_type;//用户类型 1：系统管理员 2：开发者
	private String last_logon_time;//最后登录时间
	private String last_logon_ip;//最后登录IP
	private String status;//1：正常 2：锁定
	private String create_time;//创建时间
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getUserId() {
		return this.user_id;
	}
	
	public void setUserId(String UserId) {
		this.user_id = UserId;
	}
	

	public String getUserName() {
		return this.user_name;
	}
	
	public void setUserName(String value) {
		this.user_name = value;
	}
	

	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	

	public String getUserType() {
		return this.user_type;
	}
	
	public void setUserType(String value) {
		this.user_type = value;
	}
	

	public String getLastLogonTime() {
		return this.last_logon_time;
	}
	
	public void setLastLogonTime(String value) {
		this.last_logon_time = value;
	}
	

	public String getLastLogonIp() {
		return this.last_logon_ip;
	}
	
	public void setLastLogonIp(String value) {
		this.last_logon_ip = value;
	}
	

	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String value) {
		this.status = value;
	}
	

	public String getCreateTime() {
		return this.create_time;
	}
	
	public void setCreateTime(String value) {
		this.create_time = value;
	}
	

}

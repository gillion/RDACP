package com.cartan.core.app.domain;
import java.io.Serializable;


/**
 * 移动应用注册表,开发者提出申请,申请审核通过后生成appkey/secret
 */
public class App implements Serializable{
	private String app_name;//应用名称(英文代号，唯一)
	private String app_label;//应用标识名
	private String appkey;//应用键
	private String secret;//密钥，30位随机串
	private String description;//描述
	private String author;//申请者
	private String create_time;//创建时间
	private String status;//状态 1：未审核 2：审核通过 3：不通过
	private String auditor;//审核者
	private String audit_info;//审核意见
	private String audit_time;//审核时间
	private String curr_version;//最新版本
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getAppName() {
		return this.app_name;
	}
	
	public void setAppName(String AppName) {
		this.app_name = AppName;
	}
	

	public String getAppLabel() {
		return this.app_label;
	}
	
	public void setAppLabel(String value) {
		this.app_label = value;
	}
	

	public String getAppkey() {
		return this.appkey;
	}
	
	public void setAppkey(String value) {
		this.appkey = value;
	}
	

	public String getSecret() {
		return this.secret;
	}
	
	public void setSecret(String value) {
		this.secret = value;
	}
	

	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	

	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String value) {
		this.author = value;
	}
	

	public String getCreateTime() {
		return this.create_time;
	}
	
	public void setCreateTime(String value) {
		this.create_time = value;
	}
	

	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String value) {
		this.status = value;
	}
	

	public String getAuditor() {
		return this.auditor;
	}
	
	public void setAuditor(String value) {
		this.auditor = value;
	}
	

	public String getAuditInfo() {
		return this.audit_info;
	}
	
	public void setAuditInfo(String value) {
		this.audit_info = value;
	}
	

	public String getAuditTime() {
		return this.audit_time;
	}
	
	public void setAuditTime(String value) {
		this.audit_time = value;
	}
	

	public String getCurrVersion() {
		return this.curr_version;
	}
	
	public void setCurrVersion(String value) {
		this.curr_version = value;
	}
	

}

package com.cartan.core.codegener.domain;
import java.io.Serializable;


/**
 * Codegener
 */
public class Codegener implements Serializable{
	private String ID;//主键
	private String SETUP_NAME;//配置名称
	private String BASE_PACKAGE;//基础包
	private String MODULE_NAME;//模块名
	private String ROOT;//根目录
	private String OUTPUT;//输出路径
	private String SYSNAME;//系统名称
	private String STATUS;//状态
	private String LOCK_MAN;//锁定人
	private String LOCK_TIME;//锁定时间
	private String projectName;//projectName
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getSetupName() {
		return this.SETUP_NAME;
	}
	
	public void setSetupName(String value) {
		this.SETUP_NAME = value;
	}
	

	public String getBasePackage() {
		return this.BASE_PACKAGE;
	}
	
	public void setBasePackage(String value) {
		this.BASE_PACKAGE = value;
	}
	

	public String getModuleName() {
		return this.MODULE_NAME;
	}
	
	public void setModuleName(String value) {
		this.MODULE_NAME = value;
	}
	

	public String getRoot() {
		return this.ROOT;
	}
	
	public void setRoot(String value) {
		this.ROOT = value;
	}
	

	public String getOutput() {
		return this.OUTPUT;
	}
	
	public void setOutput(String value) {
		this.OUTPUT = value;
	}
	

	public String getSysname() {
		return this.SYSNAME;
	}
	
	public void setSysname(String value) {
		this.SYSNAME = value;
	}
	

	public String getStatus() {
		return this.STATUS;
	}
	
	public void setStatus(String value) {
		this.STATUS = value;
	}
	

	public String getLockMan() {
		return this.LOCK_MAN;
	}
	
	public void setLockMan(String value) {
		this.LOCK_MAN = value;
	}
	

	public String getLockTime() {
		return this.LOCK_TIME;
	}
	
	public void setLockTime(String value) {
		this.LOCK_TIME = value;
	}
	

	public String getProjectName() {
		return this.projectName;
	}
	
	public void setProjectName(String value) {
		this.projectName = value;
	}
	

}

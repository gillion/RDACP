package com.cartan.core.ruleset.domain;
import java.io.Serializable;


/**
 * 规则集
 */
public class Ruleset implements Serializable{
	private String ID;//主键
	private String RULESET_NAME;//规则集名称
	private String VERSION;//版本
	private String STATUS;//状态
	private String MODIFY_DATE;//修改日期
	private String MODIFYED;//修改人
	private String OWNER;//所有人
	private String LOCKED;//锁定人
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getRulesetName() {
		return this.RULESET_NAME;
	}
	
	public void setRulesetName(String value) {
		this.RULESET_NAME = value;
	}
	

	public String getVersion() {
		return this.VERSION;
	}
	
	public void setVersion(String value) {
		this.VERSION = value;
	}
	

	public String getStatus() {
		return this.STATUS;
	}
	
	public void setStatus(String value) {
		this.STATUS = value;
	}
	

	public String getModifyDate() {
		return this.MODIFY_DATE;
	}
	
	public void setModifyDate(String value) {
		this.MODIFY_DATE = value;
	}
	

	public String getModifyed() {
		return this.MODIFYED;
	}
	
	public void setModifyed(String value) {
		this.MODIFYED = value;
	}
	

	public String getOwner() {
		return this.OWNER;
	}
	
	public void setOwner(String value) {
		this.OWNER = value;
	}
	

	public String getLocked() {
		return this.LOCKED;
	}
	
	public void setLocked(String value) {
		this.LOCKED = value;
	}
	

}

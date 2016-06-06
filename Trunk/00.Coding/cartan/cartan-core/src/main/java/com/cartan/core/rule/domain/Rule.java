package com.cartan.core.rule.domain;
import java.io.Serializable;


/**
 * 规则
 */
public class Rule implements Serializable{
	private String ID;//主键
	private String RULE_NAME;//规则名称
	private String RULESET_ID;//所属规则集
	private String IS_USED;//是否有效
	private String PRI_LEVEL;//优先级
	private String CONTENT_TYPE;//内容类别
	private String EFFECT_DATE;//生效日期
	private String INVALID_DATE;//失效日期
	private String CREATOR;//创建人
	private String CREATE_DATE;//创建日期
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
	

	public String getRuleName() {
		return this.RULE_NAME;
	}
	
	public void setRuleName(String value) {
		this.RULE_NAME = value;
	}
	

	public String getRulesetId() {
		return this.RULESET_ID;
	}
	
	public void setRulesetId(String value) {
		this.RULESET_ID = value;
	}
	

	public String getIsUsed() {
		return this.IS_USED;
	}
	
	public void setIsUsed(String value) {
		this.IS_USED = value;
	}
	

	public String getPriLevel() {
		return this.PRI_LEVEL;
	}
	
	public void setPriLevel(String value) {
		this.PRI_LEVEL = value;
	}
	

	public String getContentType() {
		return this.CONTENT_TYPE;
	}
	
	public void setContentType(String value) {
		this.CONTENT_TYPE = value;
	}
	

	public String getEffectDate() {
		return this.EFFECT_DATE;
	}
	
	public void setEffectDate(String value) {
		this.EFFECT_DATE = value;
	}
	

	public String getInvalidDate() {
		return this.INVALID_DATE;
	}
	
	public void setInvalidDate(String value) {
		this.INVALID_DATE = value;
	}
	

	public String getCreator() {
		return this.CREATOR;
	}
	
	public void setCreator(String value) {
		this.CREATOR = value;
	}
	

	public String getCreateDate() {
		return this.CREATE_DATE;
	}
	
	public void setCreateDate(String value) {
		this.CREATE_DATE = value;
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

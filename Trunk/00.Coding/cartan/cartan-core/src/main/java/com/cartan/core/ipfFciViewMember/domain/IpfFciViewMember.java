package com.cartan.core.ipfFciViewMember.domain;
import java.io.Serializable;


/**
 * IpfFciViewMember
 */
public class IpfFciViewMember implements Serializable{
	private String ID;//主键
	private String IPF_FCI_VIEW_ID;//视图
	private String CONFIG_ITEM_TYPE;//配置项类型
	private String CONFIG_ITEM_CODE;//配置项代码
	private String CONFIG_ITEM_ID;//配置项ID
	private String REVISION_NUMBER;//修订号
	private String SOURCE_TYPE;//来源类型
	private String SOURCE_ITEM_ID;//来源
	private String RELATION_MEMBER_ID;//关联成员
	private String IS_LOCK;//锁定状态
	private String LOCK_USER;//锁定人
	private String LOCK_TIME;//锁定时间
	private String IS_ACTIVE;//启用
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfFciViewId() {
		return this.IPF_FCI_VIEW_ID;
	}
	
	public void setIpfFciViewId(String value) {
		this.IPF_FCI_VIEW_ID = value;
	}
	

	public String getConfigItemType() {
		return this.CONFIG_ITEM_TYPE;
	}
	
	public void setConfigItemType(String value) {
		this.CONFIG_ITEM_TYPE = value;
	}
	

	public String getConfigItemCode() {
		return this.CONFIG_ITEM_CODE;
	}
	
	public void setConfigItemCode(String value) {
		this.CONFIG_ITEM_CODE = value;
	}
	

	public String getConfigItemId() {
		return this.CONFIG_ITEM_ID;
	}
	
	public void setConfigItemId(String value) {
		this.CONFIG_ITEM_ID = value;
	}
	

	public String getRevisionNumber() {
		return this.REVISION_NUMBER;
	}
	
	public void setRevisionNumber(String value) {
		this.REVISION_NUMBER = value;
	}
	

	public String getSourceType() {
		return this.SOURCE_TYPE;
	}
	
	public void setSourceType(String value) {
		this.SOURCE_TYPE = value;
	}
	

	public String getSourceItemId() {
		return this.SOURCE_ITEM_ID;
	}
	
	public void setSourceItemId(String value) {
		this.SOURCE_ITEM_ID = value;
	}
	

	public String getRelationMemberId() {
		return this.RELATION_MEMBER_ID;
	}
	
	public void setRelationMemberId(String value) {
		this.RELATION_MEMBER_ID = value;
	}
	

	public String getIsLock() {
		return this.IS_LOCK;
	}
	
	public void setIsLock(String value) {
		this.IS_LOCK = value;
	}
	

	public String getLockUser() {
		return this.LOCK_USER;
	}
	
	public void setLockUser(String value) {
		this.LOCK_USER = value;
	}
	

	public String getLockTime() {
		return this.LOCK_TIME;
	}
	
	public void setLockTime(String value) {
		this.LOCK_TIME = value;
	}
	

	public String getIsActive() {
		return this.IS_ACTIVE;
	}
	
	public void setIsActive(String value) {
		this.IS_ACTIVE = value;
	}
	

}

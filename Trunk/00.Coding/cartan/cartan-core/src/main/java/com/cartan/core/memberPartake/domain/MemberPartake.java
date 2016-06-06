package com.cartan.core.memberPartake.domain;
import java.io.Serializable;


/**
 * MemberPartake
 */
public class MemberPartake implements Serializable{
	private String id;//参与编号
	private String GroupActId;//活动编号
	private String GroupMemberId;//成员编号
	private String partaketime;//参与时间
	private String spending;//摊分开支
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String Id) {
		this.id = Id;
	}
	

	public String getGroupActId() {
		return this.GroupActId;
	}
	
	public void setGroupActId(String value) {
		this.GroupActId = value;
	}
	

	public String getGroupMemberId() {
		return this.GroupMemberId;
	}
	
	public void setGroupMemberId(String value) {
		this.GroupMemberId = value;
	}
	

	public String getPartaketime() {
		return this.partaketime;
	}
	
	public void setPartaketime(String value) {
		this.partaketime = value;
	}
	

	public String getSpending() {
		return this.spending;
	}
	
	public void setSpending(String value) {
		this.spending = value;
	}
	

}

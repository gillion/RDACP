package com.cartan.core.memberVote.domain;
import java.io.Serializable;


/**
 * MemberVote
 */
public class MemberVote implements Serializable{
	private String id;//投票编号
	private String GroupActId;//活动编号
	private String GroupMemberId;//成员编号
	private String votetime;//投票时间
	private String votestate;//投票状态
	
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
	

	public String getVotetime() {
		return this.votetime;
	}
	
	public void setVotetime(String value) {
		this.votetime = value;
	}
	

	public String getVotestate() {
		return this.votestate;
	}
	
	public void setVotestate(String value) {
		this.votestate = value;
	}
	

}

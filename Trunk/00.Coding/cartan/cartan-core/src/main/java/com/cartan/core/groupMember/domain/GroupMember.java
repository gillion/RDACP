package com.cartan.core.groupMember.domain;
import java.io.Serializable;


/**
 * GroupMember
 */
public class GroupMember implements Serializable{
	private String id;//编号
	private String user;//账号
	private String GroupInfoId;//团体
	private String area;//地区
	private String name;//姓名
	private String tel;//电话
	private String unit;//单位
	private String addr;//住址
	
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
	

	public String getGroupInfoId() {
		return this.GroupInfoId;
	}
	
	public void setGroupInfoId(String value) {
		this.GroupInfoId = value;
	}
	

	public String getArea() {
		return this.area;
	}
	
	public void setArea(String value) {
		this.area = value;
	}
	

	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	

	public String getTel() {
		return this.tel;
	}
	
	public void setTel(String value) {
		this.tel = value;
	}
	

	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String value) {
		this.unit = value;
	}
	

	public String getAddr() {
		return this.addr;
	}
	
	public void setAddr(String value) {
		this.addr = value;
	}
	

}

package com.cartan.core.groupInfo.domain;
import java.io.Serializable;


/**
 * GroupInfo
 */
public class GroupInfo implements Serializable{
	private String id;//编号
	private String type;//类别
	private String name;//名称
	private String createtime;//创建时间
	private String creator;//创建成员
	private String memoinfo;//说明
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String Id) {
		this.id = Id;
	}
	

	public String getType() {
		return this.type;
	}
	
	public void setType(String value) {
		this.type = value;
	}
	

	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	

	public String getCreatetime() {
		return this.createtime;
	}
	
	public void setCreatetime(String value) {
		this.createtime = value;
	}
	

	public String getCreator() {
		return this.creator;
	}
	
	public void setCreator(String value) {
		this.creator = value;
	}
	

	public String getMemoinfo() {
		return this.memoinfo;
	}
	
	public void setMemoinfo(String value) {
		this.memoinfo = value;
	}
	

}

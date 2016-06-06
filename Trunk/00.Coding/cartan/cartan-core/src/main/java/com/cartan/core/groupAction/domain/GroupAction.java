package com.cartan.core.groupAction.domain;
import java.io.Serializable;


/**
 * GroupAction
 */
public class GroupAction implements Serializable{
	private String id;//活动编号
	private String name;//活动名称
	private String begintime;//开始时间
	private String endtime;//结束时间
	private String addr;//活动地址
	private String leadings;//活动负责
	private String memoinfo;//活动备注
	private String mincount;//最少人数
	private String budget;//人均预算
	private String spending;//结算总额
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String Id) {
		this.id = Id;
	}
	

	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	

	public String getBegintime() {
		return this.begintime;
	}
	
	public void setBegintime(String value) {
		this.begintime = value;
	}
	

	public String getEndtime() {
		return this.endtime;
	}
	
	public void setEndtime(String value) {
		this.endtime = value;
	}
	

	public String getAddr() {
		return this.addr;
	}
	
	public void setAddr(String value) {
		this.addr = value;
	}
	

	public String getLeadings() {
		return this.leadings;
	}
	
	public void setLeadings(String value) {
		this.leadings = value;
	}
	

	public String getMemoinfo() {
		return this.memoinfo;
	}
	
	public void setMemoinfo(String value) {
		this.memoinfo = value;
	}
	

	public String getMincount() {
		return this.mincount;
	}
	
	public void setMincount(String value) {
		this.mincount = value;
	}
	

	public String getBudget() {
		return this.budget;
	}
	
	public void setBudget(String value) {
		this.budget = value;
	}
	

	public String getSpending() {
		return this.spending;
	}
	
	public void setSpending(String value) {
		this.spending = value;
	}
	

}

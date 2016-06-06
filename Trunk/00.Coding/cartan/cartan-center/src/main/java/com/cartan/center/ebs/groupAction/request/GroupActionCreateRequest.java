/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupAction.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.groupAction.domain.GroupAction;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class GroupActionCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 100)
	private String id;//活动编号
	@Size(min = 0, max = 100)
	private String name;//活动名称
	@Size(min = 0, max = 100)
	private String begintime;//开始时间
	@Size(min = 0, max = 100)
	private String endtime;//结束时间
	@Size(min = 0, max = 100)
	private String addr;//活动地址
	@Size(min = 0, max = 100)
	private String leadings;//活动负责
	@Size(min = 0, max = 100)
	private String memoinfo;//活动备注
	@Size(min = 0, max = 100)
	private String mincount;//最少人数
	@Size(min = 0, max = 100)
	private String budget;//人均预算
	@Size(min = 0, max = 100)
	private String spending;//结算总额
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getBegintime() {
		return this.begintime;
	}
	
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return this.endtime;
	}
	
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getAddr() {
		return this.addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getLeadings() {
		return this.leadings;
	}
	
	public void setLeadings(String leadings) {
		this.leadings = leadings;
	}
	public String getMemoinfo() {
		return this.memoinfo;
	}
	
	public void setMemoinfo(String memoinfo) {
		this.memoinfo = memoinfo;
	}
	public String getMincount() {
		return this.mincount;
	}
	
	public void setMincount(String mincount) {
		this.mincount = mincount;
	}
	public String getBudget() {
		return this.budget;
	}
	
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getSpending() {
		return this.spending;
	}
	
	public void setSpending(String spending) {
		this.spending = spending;
	}
	
	public GroupActionCreateRequest(){}
	
	public GroupActionCreateRequest(GroupAction groupAction){
		BeanUtils.copyProperties(groupAction,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(GroupAction bo){
		BeanUtils.copyProperties(this,bo);
	}
	public GroupAction cloneBO(){
		GroupAction bo = new GroupAction();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<GroupAction> cloneBOList(List<GroupActionCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<GroupAction>(0);
		List<GroupAction> result = new ArrayList<GroupAction>(vos.size());
		for(GroupActionCreateRequest vo: vos){
			GroupAction bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupMember.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.groupMember.domain.GroupMember;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class GroupMemberCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 200)
	private String id;//编号
	@Size(min = 0, max = 100)
	private String user;//账号
	@Size(min = 0, max = 100)
	private String groupInfoId;//团体
	@Size(min = 0, max = 100)
	private String area;//地区
	@Size(min = 0, max = 100)
	private String name;//姓名
	@Size(min = 0, max = 100)
	private String tel;//电话
	@Size(min = 0, max = 1000)
	private String unit;//单位
	@Size(min = 0, max = 1000)
	private String addr;//住址
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getUser() {
		return this.user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	public String getGroupInfoId() {
		return this.groupInfoId;
	}
	
	public void setGroupInfoId(String groupInfoId) {
		this.groupInfoId = groupInfoId;
	}
	public String getArea() {
		return this.area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return this.tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getAddr() {
		return this.addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public GroupMemberCreateRequest(){}
	
	public GroupMemberCreateRequest(GroupMember groupMember){
		BeanUtils.copyProperties(groupMember,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(GroupMember bo){
		BeanUtils.copyProperties(this,bo);
	}
	public GroupMember cloneBO(){
		GroupMember bo = new GroupMember();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<GroupMember> cloneBOList(List<GroupMemberCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<GroupMember>(0);
		List<GroupMember> result = new ArrayList<GroupMember>(vos.size());
		for(GroupMemberCreateRequest vo: vos){
			GroupMember bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


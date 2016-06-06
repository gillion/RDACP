/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.groupInfo.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.groupInfo.domain.GroupInfo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class GroupInfoUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 100)
	private String id;//编号
	@Size(min = 0, max = 100)
	private String type;//类别
	@Size(min = 0, max = 100)
	private String name;//名称
	@Size(min = 0, max = 100)
	private String createtime;//创建时间
	@Size(min = 0, max = 100)
	private String creator;//创建成员
	@Size(min = 0, max = 100)
	private String memoinfo;//说明
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatetime() {
		return this.createtime;
	}
	
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCreator() {
		return this.creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getMemoinfo() {
		return this.memoinfo;
	}
	
	public void setMemoinfo(String memoinfo) {
		this.memoinfo = memoinfo;
	}
	
	public GroupInfoUpdateRequest(){}
	
	public GroupInfoUpdateRequest(GroupInfo groupInfo){
		BeanUtils.copyProperties(groupInfo,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(GroupInfo bo){
		BeanUtils.copyProperties(this,bo);
	}
	public GroupInfo cloneBO(){
		GroupInfo bo = new GroupInfo();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<GroupInfo> cloneBOList(List<GroupInfoUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<GroupInfo>(0);
		List<GroupInfo> result = new ArrayList<GroupInfo>(vos.size());
		for(GroupInfoUpdateRequest vo: vos){
			GroupInfo bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.memberPartake.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.memberPartake.domain.MemberPartake;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class MemberPartakeCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 100)
	private String id;//参与编号
	@Size(min = 0, max = 100)
	private String groupActId;//活动编号
	@Size(min = 0, max = 100)
	private String groupMemberId;//成员编号
	@Size(min = 0, max = 100)
	private String partaketime;//参与时间
	@Size(min = 0, max = 100)
	private String spending;//摊分开支
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getGroupActId() {
		return this.groupActId;
	}
	
	public void setGroupActId(String groupActId) {
		this.groupActId = groupActId;
	}
	public String getGroupMemberId() {
		return this.groupMemberId;
	}
	
	public void setGroupMemberId(String groupMemberId) {
		this.groupMemberId = groupMemberId;
	}
	public String getPartaketime() {
		return this.partaketime;
	}
	
	public void setPartaketime(String partaketime) {
		this.partaketime = partaketime;
	}
	public String getSpending() {
		return this.spending;
	}
	
	public void setSpending(String spending) {
		this.spending = spending;
	}
	
	public MemberPartakeCreateRequest(){}
	
	public MemberPartakeCreateRequest(MemberPartake memberPartake){
		BeanUtils.copyProperties(memberPartake,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(MemberPartake bo){
		BeanUtils.copyProperties(this,bo);
	}
	public MemberPartake cloneBO(){
		MemberPartake bo = new MemberPartake();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<MemberPartake> cloneBOList(List<MemberPartakeCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<MemberPartake>(0);
		List<MemberPartake> result = new ArrayList<MemberPartake>(vos.size());
		for(MemberPartakeCreateRequest vo: vos){
			MemberPartake bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


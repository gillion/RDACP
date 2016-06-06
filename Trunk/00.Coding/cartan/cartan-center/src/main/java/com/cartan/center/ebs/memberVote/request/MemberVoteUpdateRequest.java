/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.memberVote.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.memberVote.domain.MemberVote;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class MemberVoteUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 100)
	private String id;//投票编号
	@Size(min = 0, max = 100)
	private String groupActId;//活动编号
	@Size(min = 0, max = 100)
	private String groupMemberId;//成员编号
	@Size(min = 0, max = 100)
	private String votetime;//投票时间
	@Size(min = 0, max = 100)
	private String votestate;//投票状态
	
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
	public String getVotetime() {
		return this.votetime;
	}
	
	public void setVotetime(String votetime) {
		this.votetime = votetime;
	}
	public String getVotestate() {
		return this.votestate;
	}
	
	public void setVotestate(String votestate) {
		this.votestate = votestate;
	}
	
	public MemberVoteUpdateRequest(){}
	
	public MemberVoteUpdateRequest(MemberVote memberVote){
		BeanUtils.copyProperties(memberVote,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(MemberVote bo){
		BeanUtils.copyProperties(this,bo);
	}
	public MemberVote cloneBO(){
		MemberVote bo = new MemberVote();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<MemberVote> cloneBOList(List<MemberVoteUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<MemberVote>(0);
		List<MemberVote> result = new ArrayList<MemberVote>(vos.size());
		for(MemberVoteUpdateRequest vo: vos){
			MemberVote bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


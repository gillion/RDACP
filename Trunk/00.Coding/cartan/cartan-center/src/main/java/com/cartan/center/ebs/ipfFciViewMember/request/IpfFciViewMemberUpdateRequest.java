/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfFciViewMember.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfFciViewMember.domain.IpfFciViewMember;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfFciViewMemberUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfFciViewId;//视图
	@Size(min = 0, max = 50)
	private String configItemType;//配置项类型
	@Size(min = 0, max = 50)
	private String configItemCode;//配置项代码
	@Size(min = 0, max = 50)
	private String configItemId;//配置项ID
	@Size(min = 0, max = 50)
	private String revisionNumber;//修订号
	@Size(min = 0, max = 50)
	private String sourceType;//来源类型
	@Size(min = 0, max = 50)
	private String sourceItemId;//来源
	@Size(min = 0, max = 50)
	private String relationMemberId;//关联成员
	@Size(min = 0, max = 50)
	private String isLock;//锁定状态
	@Size(min = 0, max = 50)
	private String lockUser;//锁定人
	@Size(min = 0, max = 20)
	private String lockTime;//锁定时间
	@Size(min = 0, max = 20)
	private String isActive;//启用
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfFciViewId() {
		return this.ipfFciViewId;
	}
	
	public void setIpfFciViewId(String ipfFciViewId) {
		this.ipfFciViewId = ipfFciViewId;
	}
	public String getConfigItemType() {
		return this.configItemType;
	}
	
	public void setConfigItemType(String configItemType) {
		this.configItemType = configItemType;
	}
	public String getConfigItemCode() {
		return this.configItemCode;
	}
	
	public void setConfigItemCode(String configItemCode) {
		this.configItemCode = configItemCode;
	}
	public String getConfigItemId() {
		return this.configItemId;
	}
	
	public void setConfigItemId(String configItemId) {
		this.configItemId = configItemId;
	}
	public String getRevisionNumber() {
		return this.revisionNumber;
	}
	
	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	public String getSourceType() {
		return this.sourceType;
	}
	
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getSourceItemId() {
		return this.sourceItemId;
	}
	
	public void setSourceItemId(String sourceItemId) {
		this.sourceItemId = sourceItemId;
	}
	public String getRelationMemberId() {
		return this.relationMemberId;
	}
	
	public void setRelationMemberId(String relationMemberId) {
		this.relationMemberId = relationMemberId;
	}
	public String getIsLock() {
		return this.isLock;
	}
	
	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}
	public String getLockUser() {
		return this.lockUser;
	}
	
	public void setLockUser(String lockUser) {
		this.lockUser = lockUser;
	}
	public String getLockTime() {
		return this.lockTime;
	}
	
	public void setLockTime(String lockTime) {
		this.lockTime = lockTime;
	}
	public String getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public IpfFciViewMemberUpdateRequest(){}
	
	public IpfFciViewMemberUpdateRequest(IpfFciViewMember ipfFciViewMember){
		BeanUtils.copyProperties(ipfFciViewMember,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfFciViewMember bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfFciViewMember cloneBO(){
		IpfFciViewMember bo = new IpfFciViewMember();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfFciViewMember> cloneBOList(List<IpfFciViewMemberUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfFciViewMember>(0);
		List<IpfFciViewMember> result = new ArrayList<IpfFciViewMember>(vos.size());
		for(IpfFciViewMemberUpdateRequest vo: vos){
			IpfFciViewMember bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


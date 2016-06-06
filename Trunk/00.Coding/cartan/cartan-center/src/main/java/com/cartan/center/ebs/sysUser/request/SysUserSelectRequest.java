/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.center.ebs.sysUser.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.sysUser.domain.SysUser;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

/**
 * @author : liuxb(13720880048@163.com)
 * @date: 2013-09-05
 */
public class SysUserSelectRequest extends AbstractRopRequest {
	private String userId;//userId
	private String userName;//用户名
	private String password;//MD5加密密码
	private String userType;//用户类型 1：系统管理员 2：开发者
	private String lastLogonTime;//最后登录时间
	private String lastLogonTimeEnd;//最后登录时间
	private String lastLogonIp;//最后登录IP
	private String status;//1：正常 2：锁定
	private String createTime;//创建时间
	private String createTimeEnd;//创建时间
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getUserType() {
		return this.userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	

	public String getLastLogonTime() {
		return this.lastLogonTime;
	}
	
	public void setLastLogonTime(String lastLogonTime) {
		this.lastLogonTime = lastLogonTime;
	}
	public String getLastLogonTimeEnd() {
		return this.lastLogonTimeEnd;
	}
	
	public void setLastLogonTimeEnd(String lastLogonTimeEnd) {
		this.lastLogonTimeEnd = lastLogonTimeEnd;
	}
	
	

	public String getLastLogonIp() {
		return this.lastLogonIp;
	}
	
	public void setLastLogonIp(String lastLogonIp) {
		this.lastLogonIp = lastLogonIp;
	}
	
	

	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateTimeEnd() {
		return this.createTimeEnd;
	}
	
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	
	
	
	public SysUserSelectRequest(){}
	
	public SysUserSelectRequest(SysUser sysUser){
		BeanUtils.copyProperties(sysUser,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(SysUser bo){
		BeanUtils.copyProperties(this,bo);
	}
	public SysUser cloneBO(){
		SysUser bo = new SysUser();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<SysUser> cloneBOList(List<SysUserSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<SysUser>(0);
		List<SysUser> result = new ArrayList<SysUser>(vos.size());
		for(SysUserSelectRequest vo: vos){
			SysUser bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.loginUser.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.loginUser.domain.LoginUser;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class LoginUserSelectRequest extends AbstractRopRequest {
	private String id;//编号
	private String user;//账号
	private String pwd;//密码
	private String power;//权限
	
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
	
	

	public String getPwd() {
		return this.pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

	public String getPower() {
		return this.power;
	}
	
	public void setPower(String power) {
		this.power = power;
	}
	
	
	
	public LoginUserSelectRequest(){}
	
	public LoginUserSelectRequest(LoginUser loginUser){
		BeanUtils.copyProperties(loginUser,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(LoginUser bo){
		BeanUtils.copyProperties(this,bo);
	}
	public LoginUser cloneBO(){
		LoginUser bo = new LoginUser();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<LoginUser> cloneBOList(List<LoginUserSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<LoginUser>(0);
		List<LoginUser> result = new ArrayList<LoginUser>(vos.size());
		for(LoginUserSelectRequest vo: vos){
			LoginUser bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


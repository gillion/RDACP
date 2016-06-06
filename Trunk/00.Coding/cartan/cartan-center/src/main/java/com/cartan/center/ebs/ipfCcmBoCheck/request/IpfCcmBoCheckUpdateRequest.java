/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmBoCheck.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoCheck.domain.IpfCcmBoCheck;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoCheckUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String checkType;//校验类型
	@Size(min = 0, max = 50)
	private String checkName;//校验名称
	@Size(min = 0, max = 50)
	private String boName;//业务对象名
	@Size(min = 0, max = 50)
	private String propertyName;//属性名称
	@Size(min = 0, max = 200)
	private String propertyDesc;//属性描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getCheckType() {
		return this.checkType;
	}
	
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getCheckName() {
		return this.checkName;
	}
	
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	public String getBoName() {
		return this.boName;
	}
	
	public void setBoName(String boName) {
		this.boName = boName;
	}
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyDesc() {
		return this.propertyDesc;
	}
	
	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}
	
	public IpfCcmBoCheckUpdateRequest(){}
	
	public IpfCcmBoCheckUpdateRequest(IpfCcmBoCheck ipfCcmBoCheck){
		BeanUtils.copyProperties(ipfCcmBoCheck,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoCheck bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoCheck cloneBO(){
		IpfCcmBoCheck bo = new IpfCcmBoCheck();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoCheck> cloneBOList(List<IpfCcmBoCheckUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoCheck>(0);
		List<IpfCcmBoCheck> result = new ArrayList<IpfCcmBoCheck>(vos.size());
		for(IpfCcmBoCheckUpdateRequest vo: vos){
			IpfCcmBoCheck bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


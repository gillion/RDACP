/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoMethodParam.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoMethodParam.domain.IpfCcmBoMethodParam;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoMethodParamSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcmBoMethodId;//方法
	private String constantValue;//常量值
	private String isCondition;//查询条件
	private String methodName;//方法名
	private String paramName;//参数名
	private String paramRef;//属性名
	private String paramType;//参数值来源类型
	private String boNameRef;//业务对象名
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfCcmBoMethodId() {
		return this.ipfCcmBoMethodId;
	}
	
	public void setIpfCcmBoMethodId(String ipfCcmBoMethodId) {
		this.ipfCcmBoMethodId = ipfCcmBoMethodId;
	}
	
	

	public String getConstantValue() {
		return this.constantValue;
	}
	
	public void setConstantValue(String constantValue) {
		this.constantValue = constantValue;
	}
	
	

	public String getIsCondition() {
		return this.isCondition;
	}
	
	public void setIsCondition(String isCondition) {
		this.isCondition = isCondition;
	}
	
	

	public String getMethodName() {
		return this.methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	

	public String getParamName() {
		return this.paramName;
	}
	
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	

	public String getParamRef() {
		return this.paramRef;
	}
	
	public void setParamRef(String paramRef) {
		this.paramRef = paramRef;
	}
	
	

	public String getParamType() {
		return this.paramType;
	}
	
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	
	

	public String getBoNameRef() {
		return this.boNameRef;
	}
	
	public void setBoNameRef(String boNameRef) {
		this.boNameRef = boNameRef;
	}
	
	
	
	public IpfCcmBoMethodParamSelectRequest(){}
	
	public IpfCcmBoMethodParamSelectRequest(IpfCcmBoMethodParam ipfCcmBoMethodParam){
		BeanUtils.copyProperties(ipfCcmBoMethodParam,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoMethodParam bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoMethodParam cloneBO(){
		IpfCcmBoMethodParam bo = new IpfCcmBoMethodParam();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoMethodParam> cloneBOList(List<IpfCcmBoMethodParamSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoMethodParam>(0);
		List<IpfCcmBoMethodParam> result = new ArrayList<IpfCcmBoMethodParam>(vos.size());
		for(IpfCcmBoMethodParamSelectRequest vo: vos){
			IpfCcmBoMethodParam bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


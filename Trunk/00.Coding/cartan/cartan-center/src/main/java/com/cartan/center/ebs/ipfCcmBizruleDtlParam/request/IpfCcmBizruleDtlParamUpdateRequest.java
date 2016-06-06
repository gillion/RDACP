/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmBizruleDtlParam.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBizruleDtlParam.domain.IpfCcmBizruleDtlParam;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBizruleDtlParamUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBizruleId;//规则
	@Size(min = 0, max = 50)
	private String ipfCcmStrategyId;//策略ID
	@Size(min = 0, max = 50)
	private String ipfCcmStrategyParamId;//策略参数ID
	@Size(min = 0, max = 50)
	private String paramName;//参数名
	@Size(min = 0, max = 1000)
	private String paramDes;//参数描述
	@Size(min = 0, max = 50)
	private String paramValue;//参数值
	@Size(min = 0, max = 1000)
	private String paramValueDes;//参数值说明
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfCcmBizruleId() {
		return this.ipfCcmBizruleId;
	}
	
	public void setIpfCcmBizruleId(String ipfCcmBizruleId) {
		this.ipfCcmBizruleId = ipfCcmBizruleId;
	}
	public String getIpfCcmStrategyId() {
		return this.ipfCcmStrategyId;
	}
	
	public void setIpfCcmStrategyId(String ipfCcmStrategyId) {
		this.ipfCcmStrategyId = ipfCcmStrategyId;
	}
	public String getIpfCcmStrategyParamId() {
		return this.ipfCcmStrategyParamId;
	}
	
	public void setIpfCcmStrategyParamId(String ipfCcmStrategyParamId) {
		this.ipfCcmStrategyParamId = ipfCcmStrategyParamId;
	}
	public String getParamName() {
		return this.paramName;
	}
	
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamDes() {
		return this.paramDes;
	}
	
	public void setParamDes(String paramDes) {
		this.paramDes = paramDes;
	}
	public String getParamValue() {
		return this.paramValue;
	}
	
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getParamValueDes() {
		return this.paramValueDes;
	}
	
	public void setParamValueDes(String paramValueDes) {
		this.paramValueDes = paramValueDes;
	}
	
	public IpfCcmBizruleDtlParamUpdateRequest(){}
	
	public IpfCcmBizruleDtlParamUpdateRequest(IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam){
		BeanUtils.copyProperties(ipfCcmBizruleDtlParam,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBizruleDtlParam bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBizruleDtlParam cloneBO(){
		IpfCcmBizruleDtlParam bo = new IpfCcmBizruleDtlParam();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBizruleDtlParam> cloneBOList(List<IpfCcmBizruleDtlParamUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBizruleDtlParam>(0);
		List<IpfCcmBizruleDtlParam> result = new ArrayList<IpfCcmBizruleDtlParam>(vos.size());
		for(IpfCcmBizruleDtlParamUpdateRequest vo: vos){
			IpfCcmBizruleDtlParam bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


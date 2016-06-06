/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBizruleDtl.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBizruleDtl.domain.IpfCcmBizruleDtl;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBizruleDtlCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBizruleId;//规则
	@Size(min = 0, max = 50)
	private String ipfCcmStrategyId;//策略ID
	@Size(min = 0, max = 50)
	private String strategyCode;//策略代码
	@Size(min = 0, max = 50)
	private String strategyName;//策略名称
	@Size(min = 0, max = 1000)
	private String remark;//备注
	@Size(min = 0, max = 50)
	private String ruleDetailIndex;//序号
	
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
	public String getStrategyCode() {
		return this.strategyCode;
	}
	
	public void setStrategyCode(String strategyCode) {
		this.strategyCode = strategyCode;
	}
	public String getStrategyName() {
		return this.strategyName;
	}
	
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRuleDetailIndex() {
		return this.ruleDetailIndex;
	}
	
	public void setRuleDetailIndex(String ruleDetailIndex) {
		this.ruleDetailIndex = ruleDetailIndex;
	}
	
	public IpfCcmBizruleDtlCreateRequest(){}
	
	public IpfCcmBizruleDtlCreateRequest(IpfCcmBizruleDtl ipfCcmBizruleDtl){
		BeanUtils.copyProperties(ipfCcmBizruleDtl,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBizruleDtl bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBizruleDtl cloneBO(){
		IpfCcmBizruleDtl bo = new IpfCcmBizruleDtl();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBizruleDtl> cloneBOList(List<IpfCcmBizruleDtlCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBizruleDtl>(0);
		List<IpfCcmBizruleDtl> result = new ArrayList<IpfCcmBizruleDtl>(vos.size());
		for(IpfCcmBizruleDtlCreateRequest vo: vos){
			IpfCcmBizruleDtl bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


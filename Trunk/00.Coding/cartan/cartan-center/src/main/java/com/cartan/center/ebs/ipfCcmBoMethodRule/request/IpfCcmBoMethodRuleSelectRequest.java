/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoMethodRule.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoMethodRule.domain.IpfCcmBoMethodRule;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoMethodRuleSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcbBoMethodId;//方法
	private String ruleNo;//规则号
	private String ruleName;//规则名称
	private String invokePoint;//调用时机
	private String invokeOrder;//调用顺序
	private String ruleId;//规则ID
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfCcbBoMethodId() {
		return this.ipfCcbBoMethodId;
	}
	
	public void setIpfCcbBoMethodId(String ipfCcbBoMethodId) {
		this.ipfCcbBoMethodId = ipfCcbBoMethodId;
	}
	
	

	public String getRuleNo() {
		return this.ruleNo;
	}
	
	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
	
	

	public String getRuleName() {
		return this.ruleName;
	}
	
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	
	

	public String getInvokePoint() {
		return this.invokePoint;
	}
	
	public void setInvokePoint(String invokePoint) {
		this.invokePoint = invokePoint;
	}
	
	

	public String getInvokeOrder() {
		return this.invokeOrder;
	}
	
	public void setInvokeOrder(String invokeOrder) {
		this.invokeOrder = invokeOrder;
	}
	
	

	public String getRuleId() {
		return this.ruleId;
	}
	
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	
	
	
	public IpfCcmBoMethodRuleSelectRequest(){}
	
	public IpfCcmBoMethodRuleSelectRequest(IpfCcmBoMethodRule ipfCcmBoMethodRule){
		BeanUtils.copyProperties(ipfCcmBoMethodRule,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoMethodRule bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoMethodRule cloneBO(){
		IpfCcmBoMethodRule bo = new IpfCcmBoMethodRule();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoMethodRule> cloneBOList(List<IpfCcmBoMethodRuleSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoMethodRule>(0);
		List<IpfCcmBoMethodRule> result = new ArrayList<IpfCcmBoMethodRule>(vos.size());
		for(IpfCcmBoMethodRuleSelectRequest vo: vos){
			IpfCcmBoMethodRule bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


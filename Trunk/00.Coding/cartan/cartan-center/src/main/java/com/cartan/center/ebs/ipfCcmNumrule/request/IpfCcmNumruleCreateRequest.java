/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmNumrule.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmNumrule.domain.IpfCcmNumrule;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmNumruleCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ruleCode;//单号规则代码
	@Size(min = 0, max = 50)
	private String ruleName;//单号规则名称
	@Size(min = 0, max = 2000)
	private String ruleExpression;//单号生成规则
	@Size(min = 0, max = 50)
	private String ruleStatus;//单号规则状态
	@Size(min = 0, max = 50)
	private String initialValue;//初始值
	@Size(min = 0, max = 50)
	private String maxValue;//最大值
	@Size(min = 0, max = 50)
	private String growth;//增长值
	@Size(min = 0, max = 1000)
	private String remark;//备注
	@Size(min = 0, max = 20)
	private String isActive;//有效
	@Size(min = 0, max = 50)
	private String ipfCcmBoId;//业务对象ID
	@Size(min = 0, max = 50)
	private String boName;//业务对象名称
	@Size(min = 0, max = 50)
	private String ipfCcmBoPropertyId;//属性ID
	@Size(min = 0, max = 50)
	private String propertyName;//属性名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getRuleCode() {
		return this.ruleCode;
	}
	
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getRuleName() {
		return this.ruleName;
	}
	
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleExpression() {
		return this.ruleExpression;
	}
	
	public void setRuleExpression(String ruleExpression) {
		this.ruleExpression = ruleExpression;
	}
	public String getRuleStatus() {
		return this.ruleStatus;
	}
	
	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}
	public String getInitialValue() {
		return this.initialValue;
	}
	
	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}
	public String getMaxValue() {
		return this.maxValue;
	}
	
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public String getGrowth() {
		return this.growth;
	}
	
	public void setGrowth(String growth) {
		this.growth = growth;
	}
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIpfCcmBoId() {
		return this.ipfCcmBoId;
	}
	
	public void setIpfCcmBoId(String ipfCcmBoId) {
		this.ipfCcmBoId = ipfCcmBoId;
	}
	public String getBoName() {
		return this.boName;
	}
	
	public void setBoName(String boName) {
		this.boName = boName;
	}
	public String getIpfCcmBoPropertyId() {
		return this.ipfCcmBoPropertyId;
	}
	
	public void setIpfCcmBoPropertyId(String ipfCcmBoPropertyId) {
		this.ipfCcmBoPropertyId = ipfCcmBoPropertyId;
	}
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public IpfCcmNumruleCreateRequest(){}
	
	public IpfCcmNumruleCreateRequest(IpfCcmNumrule ipfCcmNumrule){
		BeanUtils.copyProperties(ipfCcmNumrule,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmNumrule bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmNumrule cloneBO(){
		IpfCcmNumrule bo = new IpfCcmNumrule();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmNumrule> cloneBOList(List<IpfCcmNumruleCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmNumrule>(0);
		List<IpfCcmNumrule> result = new ArrayList<IpfCcmNumrule>(vos.size());
		for(IpfCcmNumruleCreateRequest vo: vos){
			IpfCcmNumrule bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


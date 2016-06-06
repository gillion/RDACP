/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBizrule.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBizrule.domain.IpfCcmBizrule;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBizruleCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ruleType;//规则类型
	@Size(min = 0, max = 50)
	private String ruleClass;//规则类名
	@Size(min = 0, max = 50)
	private String ruleCode;//规则编码
	@Size(min = 0, max = 50)
	private String ruleName;//规则名称
	@Size(min = 0, max = 200)
	private String ruleDes;//规则描述
	@Size(min = 0, max = 20)
	private String isSystemCreate;//系统创建
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getRuleType() {
		return this.ruleType;
	}
	
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public String getRuleClass() {
		return this.ruleClass;
	}
	
	public void setRuleClass(String ruleClass) {
		this.ruleClass = ruleClass;
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
	public String getRuleDes() {
		return this.ruleDes;
	}
	
	public void setRuleDes(String ruleDes) {
		this.ruleDes = ruleDes;
	}
	public String getIsSystemCreate() {
		return this.isSystemCreate;
	}
	
	public void setIsSystemCreate(String isSystemCreate) {
		this.isSystemCreate = isSystemCreate;
	}
	
	public IpfCcmBizruleCreateRequest(){}
	
	public IpfCcmBizruleCreateRequest(IpfCcmBizrule ipfCcmBizrule){
		BeanUtils.copyProperties(ipfCcmBizrule,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBizrule bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBizrule cloneBO(){
		IpfCcmBizrule bo = new IpfCcmBizrule();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBizrule> cloneBOList(List<IpfCcmBizruleCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBizrule>(0);
		List<IpfCcmBizrule> result = new ArrayList<IpfCcmBizrule>(vos.size());
		for(IpfCcmBizruleCreateRequest vo: vos){
			IpfCcmBizrule bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


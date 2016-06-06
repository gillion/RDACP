/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfReqRule.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfReqRule.domain.IpfReqRule;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfReqRuleSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ruleName;//规则名称
	private String ruleNo;//规则号
	private String ruleType;//规则类型
	private String ruleStatus;//规则状态
	private String triggerType;//触发类型
	private String physicalLocation;//所处物理位置
	private String actionType;//动作类型
	private String businessLocation;//所处业务位置
	private String businessModule;//业务模块
	private String droolsAttribute;//规则属性
	private String ruleDesc;//规则描述
	private String isDecisionTable;//是否使用决策表
	private String publicType;//共享类型
	private String ipfCcmBoId;//业务对象
	private String importDesc;//传参说明
	private String droolsWhen;//DROOLS条件
	private String droolsThen;//DROOLS动作
	private String remark;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getRuleName() {
		return this.ruleName;
	}
	
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	
	

	public String getRuleNo() {
		return this.ruleNo;
	}
	
	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
	
	

	public String getRuleType() {
		return this.ruleType;
	}
	
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	
	

	public String getRuleStatus() {
		return this.ruleStatus;
	}
	
	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}
	
	

	public String getTriggerType() {
		return this.triggerType;
	}
	
	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}
	
	

	public String getPhysicalLocation() {
		return this.physicalLocation;
	}
	
	public void setPhysicalLocation(String physicalLocation) {
		this.physicalLocation = physicalLocation;
	}
	
	

	public String getActionType() {
		return this.actionType;
	}
	
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	

	public String getBusinessLocation() {
		return this.businessLocation;
	}
	
	public void setBusinessLocation(String businessLocation) {
		this.businessLocation = businessLocation;
	}
	
	

	public String getBusinessModule() {
		return this.businessModule;
	}
	
	public void setBusinessModule(String businessModule) {
		this.businessModule = businessModule;
	}
	
	

	public String getDroolsAttribute() {
		return this.droolsAttribute;
	}
	
	public void setDroolsAttribute(String droolsAttribute) {
		this.droolsAttribute = droolsAttribute;
	}
	
	

	public String getRuleDesc() {
		return this.ruleDesc;
	}
	
	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}
	
	

	public String getIsDecisionTable() {
		return this.isDecisionTable;
	}
	
	public void setIsDecisionTable(String isDecisionTable) {
		this.isDecisionTable = isDecisionTable;
	}
	
	

	public String getPublicType() {
		return this.publicType;
	}
	
	public void setPublicType(String publicType) {
		this.publicType = publicType;
	}
	
	

	public String getIpfCcmBoId() {
		return this.ipfCcmBoId;
	}
	
	public void setIpfCcmBoId(String ipfCcmBoId) {
		this.ipfCcmBoId = ipfCcmBoId;
	}
	
	

	public String getImportDesc() {
		return this.importDesc;
	}
	
	public void setImportDesc(String importDesc) {
		this.importDesc = importDesc;
	}
	
	

	public String getDroolsWhen() {
		return this.droolsWhen;
	}
	
	public void setDroolsWhen(String droolsWhen) {
		this.droolsWhen = droolsWhen;
	}
	
	

	public String getDroolsThen() {
		return this.droolsThen;
	}
	
	public void setDroolsThen(String droolsThen) {
		this.droolsThen = droolsThen;
	}
	
	

	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	public IpfReqRuleSelectRequest(){}
	
	public IpfReqRuleSelectRequest(IpfReqRule ipfReqRule){
		BeanUtils.copyProperties(ipfReqRule,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfReqRule bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfReqRule cloneBO(){
		IpfReqRule bo = new IpfReqRule();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfReqRule> cloneBOList(List<IpfReqRuleSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfReqRule>(0);
		List<IpfReqRule> result = new ArrayList<IpfReqRule>(vos.size());
		for(IpfReqRuleSelectRequest vo: vos){
			IpfReqRule bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.rule.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.rule.domain.Rule;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class RuleSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ruleName;//规则
	private String rulesetId;//规则集
	private String isUsed;//是否有效
	private String priLevel;//优先级
	private String contentType;//内容类别
	private String effectDate;//生效日期
	private String invalidDate;//失效日期
	private String creator;//创建人
	private String createDate;//创建日期
	private String modifyDate;//修改日期
	private String modifyed;//修改人
	private String owner;//所有人
	private String locked;//锁定人
	
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
	
	

	public String getRulesetId() {
		return this.rulesetId;
	}
	
	public void setRulesetId(String rulesetId) {
		this.rulesetId = rulesetId;
	}
	
	

	public String getIsUsed() {
		return this.isUsed;
	}
	
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	
	

	public String getPriLevel() {
		return this.priLevel;
	}
	
	public void setPriLevel(String priLevel) {
		this.priLevel = priLevel;
	}
	
	

	public String getContentType() {
		return this.contentType;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	

	public String getEffectDate() {
		return this.effectDate;
	}
	
	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}
	
	

	public String getInvalidDate() {
		return this.invalidDate;
	}
	
	public void setInvalidDate(String invalidDate) {
		this.invalidDate = invalidDate;
	}
	
	

	public String getCreator() {
		return this.creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	

	public String getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	

	public String getModifyDate() {
		return this.modifyDate;
	}
	
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	

	public String getModifyed() {
		return this.modifyed;
	}
	
	public void setModifyed(String modifyed) {
		this.modifyed = modifyed;
	}
	
	

	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

	public String getLocked() {
		return this.locked;
	}
	
	public void setLocked(String locked) {
		this.locked = locked;
	}
	
	
	
	public RuleSelectRequest(){}
	
	public RuleSelectRequest(Rule rule){
		BeanUtils.copyProperties(rule,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(Rule bo){
		BeanUtils.copyProperties(this,bo);
	}
	public Rule cloneBO(){
		Rule bo = new Rule();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<Rule> cloneBOList(List<RuleSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<Rule>(0);
		List<Rule> result = new ArrayList<Rule>(vos.size());
		for(RuleSelectRequest vo: vos){
			Rule bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleset.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ruleset.domain.Ruleset;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class RulesetSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String rulesetName;//规则集
	private String version;//版本
	private String status;//状态
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
	

	public String getRulesetName() {
		return this.rulesetName;
	}
	
	public void setRulesetName(String rulesetName) {
		this.rulesetName = rulesetName;
	}
	
	

	public String getVersion() {
		return this.version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	

	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
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
	
	
	
	public RulesetSelectRequest(){}
	
	public RulesetSelectRequest(Ruleset ruleset){
		BeanUtils.copyProperties(ruleset,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(Ruleset bo){
		BeanUtils.copyProperties(this,bo);
	}
	public Ruleset cloneBO(){
		Ruleset bo = new Ruleset();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<Ruleset> cloneBOList(List<RulesetSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<Ruleset>(0);
		List<Ruleset> result = new ArrayList<Ruleset>(vos.size());
		for(RulesetSelectRequest vo: vos){
			Ruleset bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


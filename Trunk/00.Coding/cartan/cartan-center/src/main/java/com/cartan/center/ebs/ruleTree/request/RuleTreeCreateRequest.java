/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTree.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ruleTree.domain.RuleTree;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class RuleTreeCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 200)
	private String ruleTreeName;//决策树
	@Size(min = 0, max = 50)
	private String version;//版本
	@Size(min = 0, max = 50)
	private String status;//状态
	@Size(min = 0, max = 1)
	private String outputWay;//输出方式
	@Size(min = 0, max = 20)
	private String modifyDate;//修改日期
	@Size(min = 0, max = 50)
	private String modifyed;//修改人
	@Size(min = 0, max = 50)
	private String owner;//所有人
	@Size(min = 0, max = 50)
	private String locked;//锁定人
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getRuleTreeName() {
		return this.ruleTreeName;
	}
	
	public void setRuleTreeName(String ruleTreeName) {
		this.ruleTreeName = ruleTreeName;
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
	public String getOutputWay() {
		return this.outputWay;
	}
	
	public void setOutputWay(String outputWay) {
		this.outputWay = outputWay;
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
	
	public RuleTreeCreateRequest(){}
	
	public RuleTreeCreateRequest(RuleTree ruleTree){
		BeanUtils.copyProperties(ruleTree,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(RuleTree bo){
		BeanUtils.copyProperties(this,bo);
	}
	public RuleTree cloneBO(){
		RuleTree bo = new RuleTree();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<RuleTree> cloneBOList(List<RuleTreeCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<RuleTree>(0);
		List<RuleTree> result = new ArrayList<RuleTree>(vos.size());
		for(RuleTreeCreateRequest vo: vos){
			RuleTree bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ruleTableInput.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ruleTableInput.domain.RuleTableInput;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class RuleTableInputUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 200)
	private String ruleTableId;//决策表
	@Size(min = 0, max = 50)
	private String outputLocation;//输出定位
	@Size(min = 0, max = 50)
	private String inputVar;//输入变量
	@Size(min = 0, max = 50)
	private String inputValue;//输入值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getRuleTableId() {
		return this.ruleTableId;
	}
	
	public void setRuleTableId(String ruleTableId) {
		this.ruleTableId = ruleTableId;
	}
	public String getOutputLocation() {
		return this.outputLocation;
	}
	
	public void setOutputLocation(String outputLocation) {
		this.outputLocation = outputLocation;
	}
	public String getInputVar() {
		return this.inputVar;
	}
	
	public void setInputVar(String inputVar) {
		this.inputVar = inputVar;
	}
	public String getInputValue() {
		return this.inputValue;
	}
	
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}
	
	public RuleTableInputUpdateRequest(){}
	
	public RuleTableInputUpdateRequest(RuleTableInput ruleTableInput){
		BeanUtils.copyProperties(ruleTableInput,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(RuleTableInput bo){
		BeanUtils.copyProperties(this,bo);
	}
	public RuleTableInput cloneBO(){
		RuleTableInput bo = new RuleTableInput();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<RuleTableInput> cloneBOList(List<RuleTableInputUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<RuleTableInput>(0);
		List<RuleTableInput> result = new ArrayList<RuleTableInput>(vos.size());
		for(RuleTableInputUpdateRequest vo: vos){
			RuleTableInput bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTableOutput.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ruleTableOutput.domain.RuleTableOutput;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class RuleTableOutputSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ruleTableId;//决策表
	private String outputLocation;//输出定位
	private String outputVar;//输出变量
	private String outputValue;//输出值
	
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
	
	

	public String getOutputVar() {
		return this.outputVar;
	}
	
	public void setOutputVar(String outputVar) {
		this.outputVar = outputVar;
	}
	
	

	public String getOutputValue() {
		return this.outputValue;
	}
	
	public void setOutputValue(String outputValue) {
		this.outputValue = outputValue;
	}
	
	
	
	public RuleTableOutputSelectRequest(){}
	
	public RuleTableOutputSelectRequest(RuleTableOutput ruleTableOutput){
		BeanUtils.copyProperties(ruleTableOutput,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(RuleTableOutput bo){
		BeanUtils.copyProperties(this,bo);
	}
	public RuleTableOutput cloneBO(){
		RuleTableOutput bo = new RuleTableOutput();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<RuleTableOutput> cloneBOList(List<RuleTableOutputSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<RuleTableOutput>(0);
		List<RuleTableOutput> result = new ArrayList<RuleTableOutput>(vos.size());
		for(RuleTableOutputSelectRequest vo: vos){
			RuleTableOutput bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


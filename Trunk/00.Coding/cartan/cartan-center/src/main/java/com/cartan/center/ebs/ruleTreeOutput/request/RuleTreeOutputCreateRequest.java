/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ruleTreeOutput.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ruleTreeOutput.domain.RuleTreeOutput;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class RuleTreeOutputCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ruleTreeId;//决策树
	@Size(min = 0, max = 50)
	private String treeNodeCode;//节点代码
	@Size(min = 0, max = 200)
	private String treeNodeName;//节点名称
	@Size(min = 0, max = 50)
	private String outputVer;//输出变量
	@Size(min = 0, max = 50)
	private String outputValue;//输出值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getRuleTreeId() {
		return this.ruleTreeId;
	}
	
	public void setRuleTreeId(String ruleTreeId) {
		this.ruleTreeId = ruleTreeId;
	}
	public String getTreeNodeCode() {
		return this.treeNodeCode;
	}
	
	public void setTreeNodeCode(String treeNodeCode) {
		this.treeNodeCode = treeNodeCode;
	}
	public String getTreeNodeName() {
		return this.treeNodeName;
	}
	
	public void setTreeNodeName(String treeNodeName) {
		this.treeNodeName = treeNodeName;
	}
	public String getOutputVer() {
		return this.outputVer;
	}
	
	public void setOutputVer(String outputVer) {
		this.outputVer = outputVer;
	}
	public String getOutputValue() {
		return this.outputValue;
	}
	
	public void setOutputValue(String outputValue) {
		this.outputValue = outputValue;
	}
	
	public RuleTreeOutputCreateRequest(){}
	
	public RuleTreeOutputCreateRequest(RuleTreeOutput ruleTreeOutput){
		BeanUtils.copyProperties(ruleTreeOutput,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(RuleTreeOutput bo){
		BeanUtils.copyProperties(this,bo);
	}
	public RuleTreeOutput cloneBO(){
		RuleTreeOutput bo = new RuleTreeOutput();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<RuleTreeOutput> cloneBOList(List<RuleTreeOutputCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<RuleTreeOutput>(0);
		List<RuleTreeOutput> result = new ArrayList<RuleTreeOutput>(vos.size());
		for(RuleTreeOutputCreateRequest vo: vos){
			RuleTreeOutput bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


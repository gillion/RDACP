/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.conditionPartitionNode.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.conditionPartitionNode.domain.ConditionPartitionNode;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class ConditionPartitionNodeSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String conPartitionId;//条件模型
	private String conNodeName;//节点名称
	private String relationMark;//关系符
	private String varName;//变量
	private String optChar;//操作符
	private String compareValue;//对比值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getConPartitionId() {
		return this.conPartitionId;
	}
	
	public void setConPartitionId(String conPartitionId) {
		this.conPartitionId = conPartitionId;
	}
	
	

	public String getConNodeName() {
		return this.conNodeName;
	}
	
	public void setConNodeName(String conNodeName) {
		this.conNodeName = conNodeName;
	}
	
	

	public String getRelationMark() {
		return this.relationMark;
	}
	
	public void setRelationMark(String relationMark) {
		this.relationMark = relationMark;
	}
	
	

	public String getVarName() {
		return this.varName;
	}
	
	public void setVarName(String varName) {
		this.varName = varName;
	}
	
	

	public String getOptChar() {
		return this.optChar;
	}
	
	public void setOptChar(String optChar) {
		this.optChar = optChar;
	}
	
	

	public String getCompareValue() {
		return this.compareValue;
	}
	
	public void setCompareValue(String compareValue) {
		this.compareValue = compareValue;
	}
	
	
	
	public ConditionPartitionNodeSelectRequest(){}
	
	public ConditionPartitionNodeSelectRequest(ConditionPartitionNode conditionPartitionNode){
		BeanUtils.copyProperties(conditionPartitionNode,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(ConditionPartitionNode bo){
		BeanUtils.copyProperties(this,bo);
	}
	public ConditionPartitionNode cloneBO(){
		ConditionPartitionNode bo = new ConditionPartitionNode();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<ConditionPartitionNode> cloneBOList(List<ConditionPartitionNodeSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<ConditionPartitionNode>(0);
		List<ConditionPartitionNode> result = new ArrayList<ConditionPartitionNode>(vos.size());
		for(ConditionPartitionNodeSelectRequest vo: vos){
			ConditionPartitionNode bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


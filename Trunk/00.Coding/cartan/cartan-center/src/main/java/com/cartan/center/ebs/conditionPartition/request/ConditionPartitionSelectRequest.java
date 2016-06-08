/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.conditionPartition.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.conditionPartition.domain.ConditionPartition;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class ConditionPartitionSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String conditionName;//条件模型
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
	

	public String getConditionName() {
		return this.conditionName;
	}
	
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
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
	
	
	
	public ConditionPartitionSelectRequest(){}
	
	public ConditionPartitionSelectRequest(ConditionPartition conditionPartition){
		BeanUtils.copyProperties(conditionPartition,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(ConditionPartition bo){
		BeanUtils.copyProperties(this,bo);
	}
	public ConditionPartition cloneBO(){
		ConditionPartition bo = new ConditionPartition();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<ConditionPartition> cloneBOList(List<ConditionPartitionSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<ConditionPartition>(0);
		List<ConditionPartition> result = new ArrayList<ConditionPartition>(vos.size());
		for(ConditionPartitionSelectRequest vo: vos){
			ConditionPartition bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


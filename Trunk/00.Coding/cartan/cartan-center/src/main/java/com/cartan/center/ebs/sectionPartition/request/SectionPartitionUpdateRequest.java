/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.sectionPartition.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.sectionPartition.domain.SectionPartition;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class SectionPartitionUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 200)
	private String sectionName;//分段模型
	@Size(min = 0, max = 50)
	private String status;//状态
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
	public String getSectionName() {
		return this.sectionName;
	}
	
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
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
	
	public SectionPartitionUpdateRequest(){}
	
	public SectionPartitionUpdateRequest(SectionPartition sectionPartition){
		BeanUtils.copyProperties(sectionPartition,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(SectionPartition bo){
		BeanUtils.copyProperties(this,bo);
	}
	public SectionPartition cloneBO(){
		SectionPartition bo = new SectionPartition();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<SectionPartition> cloneBOList(List<SectionPartitionUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<SectionPartition>(0);
		List<SectionPartition> result = new ArrayList<SectionPartition>(vos.size());
		for(SectionPartitionUpdateRequest vo: vos){
			SectionPartition bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


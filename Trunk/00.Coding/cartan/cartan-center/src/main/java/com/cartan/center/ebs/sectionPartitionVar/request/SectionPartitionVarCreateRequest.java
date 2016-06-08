/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.sectionPartitionVar.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.sectionPartitionVar.domain.SectionPartitionVar;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class SectionPartitionVarCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String sectionParitionId;//分段模型
	@Size(min = 0, max = 200)
	private String varName;//变量名称
	@Size(min = 0, max = 50)
	private String sectionLowerMark;//下限符号
	@Size(min = 0, max = 20)
	private String sectionLowerLimit;//下限
	@Size(min = 0, max = 50)
	private String sectionUpperMark;//上限符号
	@Size(min = 0, max = 50)
	private String sectionUpperLimit;//上限
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getSectionParitionId() {
		return this.sectionParitionId;
	}
	
	public void setSectionParitionId(String sectionParitionId) {
		this.sectionParitionId = sectionParitionId;
	}
	public String getVarName() {
		return this.varName;
	}
	
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public String getSectionLowerMark() {
		return this.sectionLowerMark;
	}
	
	public void setSectionLowerMark(String sectionLowerMark) {
		this.sectionLowerMark = sectionLowerMark;
	}
	public String getSectionLowerLimit() {
		return this.sectionLowerLimit;
	}
	
	public void setSectionLowerLimit(String sectionLowerLimit) {
		this.sectionLowerLimit = sectionLowerLimit;
	}
	public String getSectionUpperMark() {
		return this.sectionUpperMark;
	}
	
	public void setSectionUpperMark(String sectionUpperMark) {
		this.sectionUpperMark = sectionUpperMark;
	}
	public String getSectionUpperLimit() {
		return this.sectionUpperLimit;
	}
	
	public void setSectionUpperLimit(String sectionUpperLimit) {
		this.sectionUpperLimit = sectionUpperLimit;
	}
	
	public SectionPartitionVarCreateRequest(){}
	
	public SectionPartitionVarCreateRequest(SectionPartitionVar sectionPartitionVar){
		BeanUtils.copyProperties(sectionPartitionVar,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(SectionPartitionVar bo){
		BeanUtils.copyProperties(this,bo);
	}
	public SectionPartitionVar cloneBO(){
		SectionPartitionVar bo = new SectionPartitionVar();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<SectionPartitionVar> cloneBOList(List<SectionPartitionVarCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<SectionPartitionVar>(0);
		List<SectionPartitionVar> result = new ArrayList<SectionPartitionVar>(vos.size());
		for(SectionPartitionVarCreateRequest vo: vos){
			SectionPartitionVar bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


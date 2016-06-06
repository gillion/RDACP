/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoRelation.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoRelation.domain.IpfCcmBoRelation;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoRelationSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcmBoId;//业务对象
	private String propertyName;//属性名称
	private String subBoName;//子对象名称
	private String subBoRelType;//子对象关系类型
	private String objectType;//对象类型
	private String description;//描述
	private String subBoOrderNo;//子业务对象的排序号
	private String persistentSaveType;//子业务对象保存方式
	private String gridEditType;//表格维护方式
	private String linkBoName;//关联对象名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfCcmBoId() {
		return this.ipfCcmBoId;
	}
	
	public void setIpfCcmBoId(String ipfCcmBoId) {
		this.ipfCcmBoId = ipfCcmBoId;
	}
	
	

	public String getPropertyName() {
		return this.propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	

	public String getSubBoName() {
		return this.subBoName;
	}
	
	public void setSubBoName(String subBoName) {
		this.subBoName = subBoName;
	}
	
	

	public String getSubBoRelType() {
		return this.subBoRelType;
	}
	
	public void setSubBoRelType(String subBoRelType) {
		this.subBoRelType = subBoRelType;
	}
	
	

	public String getObjectType() {
		return this.objectType;
	}
	
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	
	

	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getSubBoOrderNo() {
		return this.subBoOrderNo;
	}
	
	public void setSubBoOrderNo(String subBoOrderNo) {
		this.subBoOrderNo = subBoOrderNo;
	}
	
	

	public String getPersistentSaveType() {
		return this.persistentSaveType;
	}
	
	public void setPersistentSaveType(String persistentSaveType) {
		this.persistentSaveType = persistentSaveType;
	}
	
	

	public String getGridEditType() {
		return this.gridEditType;
	}
	
	public void setGridEditType(String gridEditType) {
		this.gridEditType = gridEditType;
	}
	
	

	public String getLinkBoName() {
		return this.linkBoName;
	}
	
	public void setLinkBoName(String linkBoName) {
		this.linkBoName = linkBoName;
	}
	
	
	
	public IpfCcmBoRelationSelectRequest(){}
	
	public IpfCcmBoRelationSelectRequest(IpfCcmBoRelation ipfCcmBoRelation){
		BeanUtils.copyProperties(ipfCcmBoRelation,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoRelation bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoRelation cloneBO(){
		IpfCcmBoRelation bo = new IpfCcmBoRelation();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoRelation> cloneBOList(List<IpfCcmBoRelationSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoRelation>(0);
		List<IpfCcmBoRelation> result = new ArrayList<IpfCcmBoRelation>(vos.size());
		for(IpfCcmBoRelationSelectRequest vo: vos){
			IpfCcmBoRelation bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


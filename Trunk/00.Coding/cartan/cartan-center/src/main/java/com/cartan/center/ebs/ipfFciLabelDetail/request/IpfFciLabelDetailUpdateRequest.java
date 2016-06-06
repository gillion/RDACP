/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfFciLabelDetail.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfFciLabelDetail.domain.IpfFciLabelDetail;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfFciLabelDetailUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfFciLabelId;//基线
	@Size(min = 0, max = 50)
	private String ipfFciViewId;//视图
	@Size(min = 0, max = 50)
	private String configItemType;//配置项名称
	@Size(min = 0, max = 50)
	private String configItemCode;//配置项代码
	@Size(min = 0, max = 50)
	private String configItemId;//配置项ID
	@Size(min = 0, max = 50)
	private String revisionNumber;//修订号
	@Size(min = 0, max = 50)
	private String relationMemberId;//关联成员
	@Size(min = 0, max = 20)
	private String isActive;//启用
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfFciLabelId() {
		return this.ipfFciLabelId;
	}
	
	public void setIpfFciLabelId(String ipfFciLabelId) {
		this.ipfFciLabelId = ipfFciLabelId;
	}
	public String getIpfFciViewId() {
		return this.ipfFciViewId;
	}
	
	public void setIpfFciViewId(String ipfFciViewId) {
		this.ipfFciViewId = ipfFciViewId;
	}
	public String getConfigItemType() {
		return this.configItemType;
	}
	
	public void setConfigItemType(String configItemType) {
		this.configItemType = configItemType;
	}
	public String getConfigItemCode() {
		return this.configItemCode;
	}
	
	public void setConfigItemCode(String configItemCode) {
		this.configItemCode = configItemCode;
	}
	public String getConfigItemId() {
		return this.configItemId;
	}
	
	public void setConfigItemId(String configItemId) {
		this.configItemId = configItemId;
	}
	public String getRevisionNumber() {
		return this.revisionNumber;
	}
	
	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	public String getRelationMemberId() {
		return this.relationMemberId;
	}
	
	public void setRelationMemberId(String relationMemberId) {
		this.relationMemberId = relationMemberId;
	}
	public String getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public IpfFciLabelDetailUpdateRequest(){}
	
	public IpfFciLabelDetailUpdateRequest(IpfFciLabelDetail ipfFciLabelDetail){
		BeanUtils.copyProperties(ipfFciLabelDetail,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfFciLabelDetail bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfFciLabelDetail cloneBO(){
		IpfFciLabelDetail bo = new IpfFciLabelDetail();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfFciLabelDetail> cloneBOList(List<IpfFciLabelDetailUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfFciLabelDetail>(0);
		List<IpfFciLabelDetail> result = new ArrayList<IpfFciLabelDetail>(vos.size());
		for(IpfFciLabelDetailUpdateRequest vo: vos){
			IpfFciLabelDetail bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


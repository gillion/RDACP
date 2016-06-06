/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfRuleRotateDetail.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRuleRotateDetail.domain.IpfRuleRotateDetail;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRuleRotateDetailUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfRuleRotateId;//周转规则
	@Size(min = 0, max = 50)
	private String lineId;//行号
	@Size(min = 0, max = 50)
	private String lotAttributes;//批次属性
	@Size(min = 0, max = 50)
	private String sortType;//排序
	@Size(min = 0, max = 2000)
	private String detailDesc;//描述
	@Size(min = 0, max = 20)
	private String isActive;//启用
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfRuleRotateId() {
		return this.ipfRuleRotateId;
	}
	
	public void setIpfRuleRotateId(String ipfRuleRotateId) {
		this.ipfRuleRotateId = ipfRuleRotateId;
	}
	public String getLineId() {
		return this.lineId;
	}
	
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getLotAttributes() {
		return this.lotAttributes;
	}
	
	public void setLotAttributes(String lotAttributes) {
		this.lotAttributes = lotAttributes;
	}
	public String getSortType() {
		return this.sortType;
	}
	
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public String getDetailDesc() {
		return this.detailDesc;
	}
	
	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}
	public String getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public IpfRuleRotateDetailUpdateRequest(){}
	
	public IpfRuleRotateDetailUpdateRequest(IpfRuleRotateDetail ipfRuleRotateDetail){
		BeanUtils.copyProperties(ipfRuleRotateDetail,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRuleRotateDetail bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRuleRotateDetail cloneBO(){
		IpfRuleRotateDetail bo = new IpfRuleRotateDetail();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRuleRotateDetail> cloneBOList(List<IpfRuleRotateDetailUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRuleRotateDetail>(0);
		List<IpfRuleRotateDetail> result = new ArrayList<IpfRuleRotateDetail>(vos.size());
		for(IpfRuleRotateDetailUpdateRequest vo: vos){
			IpfRuleRotateDetail bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


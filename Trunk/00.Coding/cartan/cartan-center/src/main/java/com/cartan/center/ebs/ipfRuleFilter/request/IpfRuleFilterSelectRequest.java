/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleFilter.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRuleFilter.domain.IpfRuleFilter;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRuleFilterSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String filterCode;//筛选编号
	private String filterName;//筛选名称
	private String filterDesc;//描述
	private String filterExpress;//筛选条件表达式
	private String isActive;//有效
	private String isSystemCreate;//系统创建
	private String ipfCcmBoId;//业务对象ID
	private String boName;//业务对象名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getFilterCode() {
		return this.filterCode;
	}
	
	public void setFilterCode(String filterCode) {
		this.filterCode = filterCode;
	}
	
	

	public String getFilterName() {
		return this.filterName;
	}
	
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
	

	public String getFilterDesc() {
		return this.filterDesc;
	}
	
	public void setFilterDesc(String filterDesc) {
		this.filterDesc = filterDesc;
	}
	
	

	public String getFilterExpress() {
		return this.filterExpress;
	}
	
	public void setFilterExpress(String filterExpress) {
		this.filterExpress = filterExpress;
	}
	
	

	public String getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	

	public String getIsSystemCreate() {
		return this.isSystemCreate;
	}
	
	public void setIsSystemCreate(String isSystemCreate) {
		this.isSystemCreate = isSystemCreate;
	}
	
	

	public String getIpfCcmBoId() {
		return this.ipfCcmBoId;
	}
	
	public void setIpfCcmBoId(String ipfCcmBoId) {
		this.ipfCcmBoId = ipfCcmBoId;
	}
	
	

	public String getBoName() {
		return this.boName;
	}
	
	public void setBoName(String boName) {
		this.boName = boName;
	}
	
	
	
	public IpfRuleFilterSelectRequest(){}
	
	public IpfRuleFilterSelectRequest(IpfRuleFilter ipfRuleFilter){
		BeanUtils.copyProperties(ipfRuleFilter,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRuleFilter bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRuleFilter cloneBO(){
		IpfRuleFilter bo = new IpfRuleFilter();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRuleFilter> cloneBOList(List<IpfRuleFilterSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRuleFilter>(0);
		List<IpfRuleFilter> result = new ArrayList<IpfRuleFilter>(vos.size());
		for(IpfRuleFilterSelectRequest vo: vos){
			IpfRuleFilter bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


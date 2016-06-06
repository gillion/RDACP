/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleRotate.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRuleRotate.domain.IpfRuleRotate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRuleRotateCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String warehouseOfficeId;//周转单位
	@Size(min = 0, max = 50)
	private String ruleCode;//周转规则代码
	@Size(min = 0, max = 200)
	private String ruleDesc;//描述
	@Size(min = 0, max = 20)
	private String isActive;//启用
	@Size(min = 0, max = 20)
	private String isSystemCreate;//系统创建
	@Size(min = 0, max = 2000)
	private String rotateExpress;//周转规则表达式
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getWarehouseOfficeId() {
		return this.warehouseOfficeId;
	}
	
	public void setWarehouseOfficeId(String warehouseOfficeId) {
		this.warehouseOfficeId = warehouseOfficeId;
	}
	public String getRuleCode() {
		return this.ruleCode;
	}
	
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getRuleDesc() {
		return this.ruleDesc;
	}
	
	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
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
	public String getRotateExpress() {
		return this.rotateExpress;
	}
	
	public void setRotateExpress(String rotateExpress) {
		this.rotateExpress = rotateExpress;
	}
	
	public IpfRuleRotateCreateRequest(){}
	
	public IpfRuleRotateCreateRequest(IpfRuleRotate ipfRuleRotate){
		BeanUtils.copyProperties(ipfRuleRotate,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRuleRotate bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRuleRotate cloneBO(){
		IpfRuleRotate bo = new IpfRuleRotate();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRuleRotate> cloneBOList(List<IpfRuleRotateCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRuleRotate>(0);
		List<IpfRuleRotate> result = new ArrayList<IpfRuleRotate>(vos.size());
		for(IpfRuleRotateCreateRequest vo: vos){
			IpfRuleRotate bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


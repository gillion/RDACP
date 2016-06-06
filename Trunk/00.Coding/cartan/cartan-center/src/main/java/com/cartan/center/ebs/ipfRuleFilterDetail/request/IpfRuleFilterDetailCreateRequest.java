/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRuleFilterDetail.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRuleFilterDetail.domain.IpfRuleFilterDetail;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRuleFilterDetailCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfRuleFilterId;//筛选条件
	@Size(min = 0, max = 50)
	private String lineId;//行号
	@Size(min = 0, max = 50)
	private String attribute;//表属性
	@Size(min = 0, max = 50)
	private String operand;//运算符
	@Size(min = 0, max = 50)
	private String literalValue;//值
	@Size(min = 0, max = 50)
	private String andOr;//AND或者OR
	@Size(min = 0, max = 50)
	private String leftParen;//左括号数量
	@Size(min = 0, max = 50)
	private String rightParen;//右括号数量
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfRuleFilterId() {
		return this.ipfRuleFilterId;
	}
	
	public void setIpfRuleFilterId(String ipfRuleFilterId) {
		this.ipfRuleFilterId = ipfRuleFilterId;
	}
	public String getLineId() {
		return this.lineId;
	}
	
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getAttribute() {
		return this.attribute;
	}
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getOperand() {
		return this.operand;
	}
	
	public void setOperand(String operand) {
		this.operand = operand;
	}
	public String getLiteralValue() {
		return this.literalValue;
	}
	
	public void setLiteralValue(String literalValue) {
		this.literalValue = literalValue;
	}
	public String getAndOr() {
		return this.andOr;
	}
	
	public void setAndOr(String andOr) {
		this.andOr = andOr;
	}
	public String getLeftParen() {
		return this.leftParen;
	}
	
	public void setLeftParen(String leftParen) {
		this.leftParen = leftParen;
	}
	public String getRightParen() {
		return this.rightParen;
	}
	
	public void setRightParen(String rightParen) {
		this.rightParen = rightParen;
	}
	
	public IpfRuleFilterDetailCreateRequest(){}
	
	public IpfRuleFilterDetailCreateRequest(IpfRuleFilterDetail ipfRuleFilterDetail){
		BeanUtils.copyProperties(ipfRuleFilterDetail,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRuleFilterDetail bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRuleFilterDetail cloneBO(){
		IpfRuleFilterDetail bo = new IpfRuleFilterDetail();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRuleFilterDetail> cloneBOList(List<IpfRuleFilterDetailCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRuleFilterDetail>(0);
		List<IpfRuleFilterDetail> result = new ArrayList<IpfRuleFilterDetail>(vos.size());
		for(IpfRuleFilterDetailCreateRequest vo: vos){
			IpfRuleFilterDetail bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


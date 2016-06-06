/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmNumruleList.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmNumruleList.domain.IpfCcmNumruleList;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmNumruleListSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcmNumruleId;//单号生成规则
	private String constExpression;//规则内容
	private String currentValue;//当前值
	private String initialValue;//初始值
	private String maxValue;//最大值
	private String growth;//增长值
	private String remark;//备注
	private String isActive;//有效
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfCcmNumruleId() {
		return this.ipfCcmNumruleId;
	}
	
	public void setIpfCcmNumruleId(String ipfCcmNumruleId) {
		this.ipfCcmNumruleId = ipfCcmNumruleId;
	}
	
	

	public String getConstExpression() {
		return this.constExpression;
	}
	
	public void setConstExpression(String constExpression) {
		this.constExpression = constExpression;
	}
	
	

	public String getCurrentValue() {
		return this.currentValue;
	}
	
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}
	
	

	public String getInitialValue() {
		return this.initialValue;
	}
	
	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}
	
	

	public String getMaxValue() {
		return this.maxValue;
	}
	
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	
	

	public String getGrowth() {
		return this.growth;
	}
	
	public void setGrowth(String growth) {
		this.growth = growth;
	}
	
	

	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	public String getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	
	public IpfCcmNumruleListSelectRequest(){}
	
	public IpfCcmNumruleListSelectRequest(IpfCcmNumruleList ipfCcmNumruleList){
		BeanUtils.copyProperties(ipfCcmNumruleList,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmNumruleList bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmNumruleList cloneBO(){
		IpfCcmNumruleList bo = new IpfCcmNumruleList();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmNumruleList> cloneBOList(List<IpfCcmNumruleListSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmNumruleList>(0);
		List<IpfCcmNumruleList> result = new ArrayList<IpfCcmNumruleList>(vos.size());
		for(IpfCcmNumruleListSelectRequest vo: vos){
			IpfCcmNumruleList bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


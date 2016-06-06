/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoPropertyCas.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoPropertyCas.domain.IpfCcmBoPropertyCas;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoPropertyCasSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcmBoPropertyId;//属性
	private String cascadePropertyId;//级联属性
	private String operation;//操作符
	private String targetPropertyName;//目标属性名称
	private String type;//类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfCcmBoPropertyId() {
		return this.ipfCcmBoPropertyId;
	}
	
	public void setIpfCcmBoPropertyId(String ipfCcmBoPropertyId) {
		this.ipfCcmBoPropertyId = ipfCcmBoPropertyId;
	}
	
	

	public String getCascadePropertyId() {
		return this.cascadePropertyId;
	}
	
	public void setCascadePropertyId(String cascadePropertyId) {
		this.cascadePropertyId = cascadePropertyId;
	}
	
	

	public String getOperation() {
		return this.operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

	public String getTargetPropertyName() {
		return this.targetPropertyName;
	}
	
	public void setTargetPropertyName(String targetPropertyName) {
		this.targetPropertyName = targetPropertyName;
	}
	
	

	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	public IpfCcmBoPropertyCasSelectRequest(){}
	
	public IpfCcmBoPropertyCasSelectRequest(IpfCcmBoPropertyCas ipfCcmBoPropertyCas){
		BeanUtils.copyProperties(ipfCcmBoPropertyCas,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoPropertyCas bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoPropertyCas cloneBO(){
		IpfCcmBoPropertyCas bo = new IpfCcmBoPropertyCas();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoPropertyCas> cloneBOList(List<IpfCcmBoPropertyCasSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoPropertyCas>(0);
		List<IpfCcmBoPropertyCas> result = new ArrayList<IpfCcmBoPropertyCas>(vos.size());
		for(IpfCcmBoPropertyCasSelectRequest vo: vos){
			IpfCcmBoPropertyCas bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


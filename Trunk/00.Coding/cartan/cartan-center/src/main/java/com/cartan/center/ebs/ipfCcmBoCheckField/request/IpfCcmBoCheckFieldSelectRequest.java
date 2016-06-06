/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheckField.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoCheckField.domain.IpfCcmBoCheckField;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoCheckFieldSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcmBoCheckId;//校验
	private String propertyId;//属性ID
	private String propertyName;//属性名称
	private String propertyDesc;//属性描述
	private String boName;//业务对象名
	private String seqNo;//顺序号
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfCcmBoCheckId() {
		return this.ipfCcmBoCheckId;
	}
	
	public void setIpfCcmBoCheckId(String ipfCcmBoCheckId) {
		this.ipfCcmBoCheckId = ipfCcmBoCheckId;
	}
	
	

	public String getPropertyId() {
		return this.propertyId;
	}
	
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	

	public String getPropertyName() {
		return this.propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	

	public String getPropertyDesc() {
		return this.propertyDesc;
	}
	
	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}
	
	

	public String getBoName() {
		return this.boName;
	}
	
	public void setBoName(String boName) {
		this.boName = boName;
	}
	
	

	public String getSeqNo() {
		return this.seqNo;
	}
	
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	
	
	public IpfCcmBoCheckFieldSelectRequest(){}
	
	public IpfCcmBoCheckFieldSelectRequest(IpfCcmBoCheckField ipfCcmBoCheckField){
		BeanUtils.copyProperties(ipfCcmBoCheckField,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoCheckField bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoCheckField cloneBO(){
		IpfCcmBoCheckField bo = new IpfCcmBoCheckField();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoCheckField> cloneBOList(List<IpfCcmBoCheckFieldSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoCheckField>(0);
		List<IpfCcmBoCheckField> result = new ArrayList<IpfCcmBoCheckField>(vos.size());
		for(IpfCcmBoCheckFieldSelectRequest vo: vos){
			IpfCcmBoCheckField bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


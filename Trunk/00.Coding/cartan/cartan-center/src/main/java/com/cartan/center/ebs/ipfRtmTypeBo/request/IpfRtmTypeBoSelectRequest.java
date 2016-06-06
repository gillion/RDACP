/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmTypeBo.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRtmTypeBo.domain.IpfRtmTypeBo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRtmTypeBoSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfRtmTypeId;//运行期配置类型
	private String ipfCcmBoId;//业务对象ID
	private String boName;//业务对象名称
	private String boDesc;//业务对象描述
	private String propertyName;//业务对象属性名称
	private String propertyUtility;//属性用途
	private String externalBoName;//外部业务对象名称
	private String externalMatchProperty;//查询匹配属性
	private String externalResultProperty;//结果属性
	private String externalBoId;//外部业务对象ID
	private String triggerPropertyName;//触发属性名
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfRtmTypeId() {
		return this.ipfRtmTypeId;
	}
	
	public void setIpfRtmTypeId(String ipfRtmTypeId) {
		this.ipfRtmTypeId = ipfRtmTypeId;
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
	
	

	public String getBoDesc() {
		return this.boDesc;
	}
	
	public void setBoDesc(String boDesc) {
		this.boDesc = boDesc;
	}
	
	

	public String getPropertyName() {
		return this.propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	

	public String getPropertyUtility() {
		return this.propertyUtility;
	}
	
	public void setPropertyUtility(String propertyUtility) {
		this.propertyUtility = propertyUtility;
	}
	
	

	public String getExternalBoName() {
		return this.externalBoName;
	}
	
	public void setExternalBoName(String externalBoName) {
		this.externalBoName = externalBoName;
	}
	
	

	public String getExternalMatchProperty() {
		return this.externalMatchProperty;
	}
	
	public void setExternalMatchProperty(String externalMatchProperty) {
		this.externalMatchProperty = externalMatchProperty;
	}
	
	

	public String getExternalResultProperty() {
		return this.externalResultProperty;
	}
	
	public void setExternalResultProperty(String externalResultProperty) {
		this.externalResultProperty = externalResultProperty;
	}
	
	

	public String getExternalBoId() {
		return this.externalBoId;
	}
	
	public void setExternalBoId(String externalBoId) {
		this.externalBoId = externalBoId;
	}
	
	

	public String getTriggerPropertyName() {
		return this.triggerPropertyName;
	}
	
	public void setTriggerPropertyName(String triggerPropertyName) {
		this.triggerPropertyName = triggerPropertyName;
	}
	
	
	
	public IpfRtmTypeBoSelectRequest(){}
	
	public IpfRtmTypeBoSelectRequest(IpfRtmTypeBo ipfRtmTypeBo){
		BeanUtils.copyProperties(ipfRtmTypeBo,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRtmTypeBo bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRtmTypeBo cloneBO(){
		IpfRtmTypeBo bo = new IpfRtmTypeBo();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRtmTypeBo> cloneBOList(List<IpfRtmTypeBoSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRtmTypeBo>(0);
		List<IpfRtmTypeBo> result = new ArrayList<IpfRtmTypeBo>(vos.size());
		for(IpfRtmTypeBoSelectRequest vo: vos){
			IpfRtmTypeBo bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


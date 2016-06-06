/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfRtmConfigAttrBo.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRtmConfigAttrBo.domain.IpfRtmConfigAttrBo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRtmConfigAttrBoUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfRtmConfigAttrId;//运行期配置明细
	@Size(min = 0, max = 50)
	private String ipfRtmConfigId;//运行期配置明细
	@Size(min = 0, max = 50)
	private String ipfCcmBoId;//业务对象ID
	@Size(min = 0, max = 50)
	private String boName;//业务对象名称
	@Size(min = 0, max = 1000)
	private String boDesc;//业务对象描述
	@Size(min = 0, max = 50)
	private String boAttributeName;//属性名称
	@Size(min = 0, max = 20)
	private String isVisible;//可见
	@Size(min = 0, max = 20)
	private String isRequired;//必输
	@Size(min = 0, max = 50)
	private String defaultValue;//默认值
	@Size(min = 0, max = 50)
	private String shlpValueFiled;//搜索帮助值字段
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfRtmConfigAttrId() {
		return this.ipfRtmConfigAttrId;
	}
	
	public void setIpfRtmConfigAttrId(String ipfRtmConfigAttrId) {
		this.ipfRtmConfigAttrId = ipfRtmConfigAttrId;
	}
	public String getIpfRtmConfigId() {
		return this.ipfRtmConfigId;
	}
	
	public void setIpfRtmConfigId(String ipfRtmConfigId) {
		this.ipfRtmConfigId = ipfRtmConfigId;
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
	public String getBoAttributeName() {
		return this.boAttributeName;
	}
	
	public void setBoAttributeName(String boAttributeName) {
		this.boAttributeName = boAttributeName;
	}
	public String getIsVisible() {
		return this.isVisible;
	}
	
	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
	public String getIsRequired() {
		return this.isRequired;
	}
	
	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getShlpValueFiled() {
		return this.shlpValueFiled;
	}
	
	public void setShlpValueFiled(String shlpValueFiled) {
		this.shlpValueFiled = shlpValueFiled;
	}
	
	public IpfRtmConfigAttrBoUpdateRequest(){}
	
	public IpfRtmConfigAttrBoUpdateRequest(IpfRtmConfigAttrBo ipfRtmConfigAttrBo){
		BeanUtils.copyProperties(ipfRtmConfigAttrBo,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRtmConfigAttrBo bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRtmConfigAttrBo cloneBO(){
		IpfRtmConfigAttrBo bo = new IpfRtmConfigAttrBo();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRtmConfigAttrBo> cloneBOList(List<IpfRtmConfigAttrBoUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRtmConfigAttrBo>(0);
		List<IpfRtmConfigAttrBo> result = new ArrayList<IpfRtmConfigAttrBo>(vos.size());
		for(IpfRtmConfigAttrBoUpdateRequest vo: vos){
			IpfRtmConfigAttrBo bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


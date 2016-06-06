/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfRtmConfig.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRtmConfig.domain.IpfRtmConfig;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRtmConfigUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String configCode;//配置代码
	@Size(min = 0, max = 50)
	private String configName;//配置名称
	@Size(min = 0, max = 50)
	private String typeCode;//类别代码
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getConfigCode() {
		return this.configCode;
	}
	
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}
	public String getConfigName() {
		return this.configName;
	}
	
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public String getTypeCode() {
		return this.typeCode;
	}
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	public IpfRtmConfigUpdateRequest(){}
	
	public IpfRtmConfigUpdateRequest(IpfRtmConfig ipfRtmConfig){
		BeanUtils.copyProperties(ipfRtmConfig,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRtmConfig bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRtmConfig cloneBO(){
		IpfRtmConfig bo = new IpfRtmConfig();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRtmConfig> cloneBOList(List<IpfRtmConfigUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRtmConfig>(0);
		List<IpfRtmConfig> result = new ArrayList<IpfRtmConfig>(vos.size());
		for(IpfRtmConfigUpdateRequest vo: vos){
			IpfRtmConfig bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


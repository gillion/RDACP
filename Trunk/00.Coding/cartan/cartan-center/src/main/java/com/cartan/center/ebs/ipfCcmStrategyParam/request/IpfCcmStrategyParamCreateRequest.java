/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmStrategyParam.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmStrategyParam.domain.IpfCcmStrategyParam;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmStrategyParamCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmStrategyId;//策略
	@Size(min = 0, max = 50)
	private String paramType;//参数类型
	@Size(min = 0, max = 50)
	private String paramName;//参数名
	@Size(min = 0, max = 1000)
	private String paramDes;//参数描述
	@Size(min = 0, max = 50)
	private String rtmConfigCode;//运行期配置
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfCcmStrategyId() {
		return this.ipfCcmStrategyId;
	}
	
	public void setIpfCcmStrategyId(String ipfCcmStrategyId) {
		this.ipfCcmStrategyId = ipfCcmStrategyId;
	}
	public String getParamType() {
		return this.paramType;
	}
	
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	public String getParamName() {
		return this.paramName;
	}
	
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamDes() {
		return this.paramDes;
	}
	
	public void setParamDes(String paramDes) {
		this.paramDes = paramDes;
	}
	public String getRtmConfigCode() {
		return this.rtmConfigCode;
	}
	
	public void setRtmConfigCode(String rtmConfigCode) {
		this.rtmConfigCode = rtmConfigCode;
	}
	
	public IpfCcmStrategyParamCreateRequest(){}
	
	public IpfCcmStrategyParamCreateRequest(IpfCcmStrategyParam ipfCcmStrategyParam){
		BeanUtils.copyProperties(ipfCcmStrategyParam,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmStrategyParam bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmStrategyParam cloneBO(){
		IpfCcmStrategyParam bo = new IpfCcmStrategyParam();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmStrategyParam> cloneBOList(List<IpfCcmStrategyParamCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmStrategyParam>(0);
		List<IpfCcmStrategyParam> result = new ArrayList<IpfCcmStrategyParam>(vos.size());
		for(IpfCcmStrategyParamCreateRequest vo: vos){
			IpfCcmStrategyParam bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


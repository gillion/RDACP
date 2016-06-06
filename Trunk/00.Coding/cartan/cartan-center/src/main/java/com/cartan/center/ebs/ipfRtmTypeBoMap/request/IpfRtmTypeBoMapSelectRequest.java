/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmTypeBoMap.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRtmTypeBoMap.domain.IpfRtmTypeBoMap;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRtmTypeBoMapSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfRtmTypeBoId;//运行期配置界面
	private String sourceValue;//源值
	private String destValue;//目标值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfRtmTypeBoId() {
		return this.ipfRtmTypeBoId;
	}
	
	public void setIpfRtmTypeBoId(String ipfRtmTypeBoId) {
		this.ipfRtmTypeBoId = ipfRtmTypeBoId;
	}
	
	

	public String getSourceValue() {
		return this.sourceValue;
	}
	
	public void setSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
	}
	
	

	public String getDestValue() {
		return this.destValue;
	}
	
	public void setDestValue(String destValue) {
		this.destValue = destValue;
	}
	
	
	
	public IpfRtmTypeBoMapSelectRequest(){}
	
	public IpfRtmTypeBoMapSelectRequest(IpfRtmTypeBoMap ipfRtmTypeBoMap){
		BeanUtils.copyProperties(ipfRtmTypeBoMap,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRtmTypeBoMap bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRtmTypeBoMap cloneBO(){
		IpfRtmTypeBoMap bo = new IpfRtmTypeBoMap();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRtmTypeBoMap> cloneBOList(List<IpfRtmTypeBoMapSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRtmTypeBoMap>(0);
		List<IpfRtmTypeBoMap> result = new ArrayList<IpfRtmTypeBoMap>(vos.size());
		for(IpfRtmTypeBoMapSelectRequest vo: vos){
			IpfRtmTypeBoMap bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


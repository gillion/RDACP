/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfRtmTypeBoAttr.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRtmTypeBoAttr.domain.IpfRtmTypeBoAttr;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRtmTypeBoAttrUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfRtmTypeBoId;//运行期配置界面
	@Size(min = 0, max = 50)
	private String propertyName;//属性名称
	@Size(min = 0, max = 200)
	private String fieldText;//属性中文描述
	
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
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getFieldText() {
		return this.fieldText;
	}
	
	public void setFieldText(String fieldText) {
		this.fieldText = fieldText;
	}
	
	public IpfRtmTypeBoAttrUpdateRequest(){}
	
	public IpfRtmTypeBoAttrUpdateRequest(IpfRtmTypeBoAttr ipfRtmTypeBoAttr){
		BeanUtils.copyProperties(ipfRtmTypeBoAttr,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRtmTypeBoAttr bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRtmTypeBoAttr cloneBO(){
		IpfRtmTypeBoAttr bo = new IpfRtmTypeBoAttr();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRtmTypeBoAttr> cloneBOList(List<IpfRtmTypeBoAttrUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRtmTypeBoAttr>(0);
		List<IpfRtmTypeBoAttr> result = new ArrayList<IpfRtmTypeBoAttr>(vos.size());
		for(IpfRtmTypeBoAttrUpdateRequest vo: vos){
			IpfRtmTypeBoAttr bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


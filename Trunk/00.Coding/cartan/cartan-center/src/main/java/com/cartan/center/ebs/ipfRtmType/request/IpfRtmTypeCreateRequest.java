/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfRtmType.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRtmType.domain.IpfRtmType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRtmTypeCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String typeCode;//类别代码
	@Size(min = 0, max = 50)
	private String typeName;//类别名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getTypeCode() {
		return this.typeCode;
	}
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return this.typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public IpfRtmTypeCreateRequest(){}
	
	public IpfRtmTypeCreateRequest(IpfRtmType ipfRtmType){
		BeanUtils.copyProperties(ipfRtmType,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRtmType bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRtmType cloneBO(){
		IpfRtmType bo = new IpfRtmType();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRtmType> cloneBOList(List<IpfRtmTypeCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRtmType>(0);
		List<IpfRtmType> result = new ArrayList<IpfRtmType>(vos.size());
		for(IpfRtmTypeCreateRequest vo: vos){
			IpfRtmType bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


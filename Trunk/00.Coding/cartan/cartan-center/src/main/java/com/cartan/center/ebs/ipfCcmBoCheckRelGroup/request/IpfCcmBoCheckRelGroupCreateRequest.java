/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheckRelGroup.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoCheckRelGroup.domain.IpfCcmBoCheckRelGroup;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoCheckRelGroupCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBoCheckId;//校验
	@Size(min = 0, max = 50)
	private String groupName;//分组名称
	@Size(min = 0, max = 200)
	private String groupDesc;//分组描述
	
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
	public String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDesc() {
		return this.groupDesc;
	}
	
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	
	public IpfCcmBoCheckRelGroupCreateRequest(){}
	
	public IpfCcmBoCheckRelGroupCreateRequest(IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup){
		BeanUtils.copyProperties(ipfCcmBoCheckRelGroup,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoCheckRelGroup bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoCheckRelGroup cloneBO(){
		IpfCcmBoCheckRelGroup bo = new IpfCcmBoCheckRelGroup();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoCheckRelGroup> cloneBOList(List<IpfCcmBoCheckRelGroupCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoCheckRelGroup>(0);
		List<IpfCcmBoCheckRelGroup> result = new ArrayList<IpfCcmBoCheckRelGroup>(vos.size());
		for(IpfCcmBoCheckRelGroupCreateRequest vo: vos){
			IpfCcmBoCheckRelGroup bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


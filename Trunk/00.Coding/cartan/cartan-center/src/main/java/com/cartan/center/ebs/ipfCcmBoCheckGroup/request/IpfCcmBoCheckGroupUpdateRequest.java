/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmBoCheckGroup.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoCheckGroup.domain.IpfCcmBoCheckGroup;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoCheckGroupUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBoId;//业务对象
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
	public String getIpfCcmBoId() {
		return this.ipfCcmBoId;
	}
	
	public void setIpfCcmBoId(String ipfCcmBoId) {
		this.ipfCcmBoId = ipfCcmBoId;
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
	
	public IpfCcmBoCheckGroupUpdateRequest(){}
	
	public IpfCcmBoCheckGroupUpdateRequest(IpfCcmBoCheckGroup ipfCcmBoCheckGroup){
		BeanUtils.copyProperties(ipfCcmBoCheckGroup,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoCheckGroup bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoCheckGroup cloneBO(){
		IpfCcmBoCheckGroup bo = new IpfCcmBoCheckGroup();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoCheckGroup> cloneBOList(List<IpfCcmBoCheckGroupUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoCheckGroup>(0);
		List<IpfCcmBoCheckGroup> result = new ArrayList<IpfCcmBoCheckGroup>(vos.size());
		for(IpfCcmBoCheckGroupUpdateRequest vo: vos){
			IpfCcmBoCheckGroup bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayout.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmUiLayout.domain.IpfCcmUiLayout;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmUiLayoutSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String uiLayoutName;//名称
	private String description;//描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getUiLayoutName() {
		return this.uiLayoutName;
	}
	
	public void setUiLayoutName(String uiLayoutName) {
		this.uiLayoutName = uiLayoutName;
	}
	
	

	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public IpfCcmUiLayoutSelectRequest(){}
	
	public IpfCcmUiLayoutSelectRequest(IpfCcmUiLayout ipfCcmUiLayout){
		BeanUtils.copyProperties(ipfCcmUiLayout,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmUiLayout bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmUiLayout cloneBO(){
		IpfCcmUiLayout bo = new IpfCcmUiLayout();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmUiLayout> cloneBOList(List<IpfCcmUiLayoutSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmUiLayout>(0);
		List<IpfCcmUiLayout> result = new ArrayList<IpfCcmUiLayout>(vos.size());
		for(IpfCcmUiLayoutSelectRequest vo: vos){
			IpfCcmUiLayout bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


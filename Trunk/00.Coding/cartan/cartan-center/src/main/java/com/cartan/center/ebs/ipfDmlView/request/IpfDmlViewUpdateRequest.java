/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfDmlView.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlView.domain.IpfDmlView;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlViewUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String viewName;//视图名称
	@Size(min = 0, max = 1000)
	private String viewDes;//视图描述
	@Size(min = 0, max = 50)
	private String viewType;//视图类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getViewName() {
		return this.viewName;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public String getViewDes() {
		return this.viewDes;
	}
	
	public void setViewDes(String viewDes) {
		this.viewDes = viewDes;
	}
	public String getViewType() {
		return this.viewType;
	}
	
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
	public IpfDmlViewUpdateRequest(){}
	
	public IpfDmlViewUpdateRequest(IpfDmlView ipfDmlView){
		BeanUtils.copyProperties(ipfDmlView,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlView bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlView cloneBO(){
		IpfDmlView bo = new IpfDmlView();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlView> cloneBOList(List<IpfDmlViewUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlView>(0);
		List<IpfDmlView> result = new ArrayList<IpfDmlView>(vos.size());
		for(IpfDmlViewUpdateRequest vo: vos){
			IpfDmlView bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


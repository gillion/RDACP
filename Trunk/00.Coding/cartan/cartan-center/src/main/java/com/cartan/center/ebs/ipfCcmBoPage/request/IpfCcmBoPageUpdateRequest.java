/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmBoPage.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoPage.domain.IpfCcmBoPage;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoPageUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBoId;//业务对象
	@Size(min = 0, max = 50)
	private String pageType;//页面类型
	@Size(min = 0, max = 1000)
	private String description;//描述
	@Size(min = 0, max = 50)
	private String pageName;//页面名称
	
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
	public String getPageType() {
		return this.pageType;
	}
	
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPageName() {
		return this.pageName;
	}
	
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	public IpfCcmBoPageUpdateRequest(){}
	
	public IpfCcmBoPageUpdateRequest(IpfCcmBoPage ipfCcmBoPage){
		BeanUtils.copyProperties(ipfCcmBoPage,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoPage bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoPage cloneBO(){
		IpfCcmBoPage bo = new IpfCcmBoPage();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoPage> cloneBOList(List<IpfCcmBoPageUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoPage>(0);
		List<IpfCcmBoPage> result = new ArrayList<IpfCcmBoPage>(vos.size());
		for(IpfCcmBoPageUpdateRequest vo: vos){
			IpfCcmBoPage bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


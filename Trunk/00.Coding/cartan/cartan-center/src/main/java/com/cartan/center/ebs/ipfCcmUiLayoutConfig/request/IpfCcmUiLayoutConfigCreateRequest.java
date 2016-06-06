/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayoutConfig.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmUiLayoutConfig.domain.IpfCcmUiLayoutConfig;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmUiLayoutConfigCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBoId;//业务对象
	@Size(min = 0, max = 50)
	private String boId;//业务对象ID
	@Size(min = 0, max = 50)
	private String pageName;//页面名称
	@Size(min = 0, max = 50)
	private String layoutElementName;//布局元素名称
	@Size(min = 0, max = 200)
	private String layoutElementDescription;//布局元素描述
	@Size(min = 0, max = 50)
	private String boName;//业务对象名称
	@Size(min = 0, max = 50)
	private String boElementName;//业务对象布局元素名称
	
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
	public String getBoId() {
		return this.boId;
	}
	
	public void setBoId(String boId) {
		this.boId = boId;
	}
	public String getPageName() {
		return this.pageName;
	}
	
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getLayoutElementName() {
		return this.layoutElementName;
	}
	
	public void setLayoutElementName(String layoutElementName) {
		this.layoutElementName = layoutElementName;
	}
	public String getLayoutElementDescription() {
		return this.layoutElementDescription;
	}
	
	public void setLayoutElementDescription(String layoutElementDescription) {
		this.layoutElementDescription = layoutElementDescription;
	}
	public String getBoName() {
		return this.boName;
	}
	
	public void setBoName(String boName) {
		this.boName = boName;
	}
	public String getBoElementName() {
		return this.boElementName;
	}
	
	public void setBoElementName(String boElementName) {
		this.boElementName = boElementName;
	}
	
	public IpfCcmUiLayoutConfigCreateRequest(){}
	
	public IpfCcmUiLayoutConfigCreateRequest(IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig){
		BeanUtils.copyProperties(ipfCcmUiLayoutConfig,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmUiLayoutConfig bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmUiLayoutConfig cloneBO(){
		IpfCcmUiLayoutConfig bo = new IpfCcmUiLayoutConfig();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmUiLayoutConfig> cloneBOList(List<IpfCcmUiLayoutConfigCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmUiLayoutConfig>(0);
		List<IpfCcmUiLayoutConfig> result = new ArrayList<IpfCcmUiLayoutConfig>(vos.size());
		for(IpfCcmUiLayoutConfigCreateRequest vo: vos){
			IpfCcmUiLayoutConfig bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


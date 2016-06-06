/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfFciBuild.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfFciBuild.domain.IpfFciBuild;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfFciBuildUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfFciViewId;//视图
	@Size(min = 0, max = 50)
	private String ipfFciProjectId;//项目
	@Size(min = 0, max = 50)
	private String majorVersion;//主版本号
	@Size(min = 0, max = 50)
	private String minorVersion;//次版本号
	@Size(min = 0, max = 50)
	private String maxVersionBuildNumber;//最大版本编译号
	@Size(min = 0, max = 20)
	private String isDefault;//是否默认
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfFciViewId() {
		return this.ipfFciViewId;
	}
	
	public void setIpfFciViewId(String ipfFciViewId) {
		this.ipfFciViewId = ipfFciViewId;
	}
	public String getIpfFciProjectId() {
		return this.ipfFciProjectId;
	}
	
	public void setIpfFciProjectId(String ipfFciProjectId) {
		this.ipfFciProjectId = ipfFciProjectId;
	}
	public String getMajorVersion() {
		return this.majorVersion;
	}
	
	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}
	public String getMinorVersion() {
		return this.minorVersion;
	}
	
	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
	}
	public String getMaxVersionBuildNumber() {
		return this.maxVersionBuildNumber;
	}
	
	public void setMaxVersionBuildNumber(String maxVersionBuildNumber) {
		this.maxVersionBuildNumber = maxVersionBuildNumber;
	}
	public String getIsDefault() {
		return this.isDefault;
	}
	
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	
	public IpfFciBuildUpdateRequest(){}
	
	public IpfFciBuildUpdateRequest(IpfFciBuild ipfFciBuild){
		BeanUtils.copyProperties(ipfFciBuild,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfFciBuild bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfFciBuild cloneBO(){
		IpfFciBuild bo = new IpfFciBuild();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfFciBuild> cloneBOList(List<IpfFciBuildUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfFciBuild>(0);
		List<IpfFciBuild> result = new ArrayList<IpfFciBuild>(vos.size());
		for(IpfFciBuildUpdateRequest vo: vos){
			IpfFciBuild bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


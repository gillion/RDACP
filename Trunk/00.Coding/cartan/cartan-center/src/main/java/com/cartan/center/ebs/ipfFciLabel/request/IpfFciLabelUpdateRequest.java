/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfFciLabel.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfFciLabel.domain.IpfFciLabel;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfFciLabelUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfFciViewId;//视图
	@Size(min = 0, max = 50)
	private String labelName;//基线名称
	@Size(min = 0, max = 200)
	private String labelDesc;//基线描述
	@Size(min = 0, max = 50)
	private String ipfFciBuildId;//编译号
	@Size(min = 0, max = 50)
	private String majorVersion;//主版本号
	@Size(min = 0, max = 50)
	private String minorVersion;//次版本号
	@Size(min = 0, max = 50)
	private String versionBuildNumber;//版本编译号
	@Size(min = 0, max = 50)
	private String revisionNumber;//修订号
	@Size(min = 0, max = 50)
	private String svnRevision;//SVN修订号
	@Size(min = 0, max = 1000)
	private String svnTagsPath;//SVN基线路径
	@Size(min = 0, max = 20)
	private String isActive;//启用
	@Size(min = 0, max = 50)
	private String viewName;//视图名称
	
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
	public String getLabelName() {
		return this.labelName;
	}
	
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getLabelDesc() {
		return this.labelDesc;
	}
	
	public void setLabelDesc(String labelDesc) {
		this.labelDesc = labelDesc;
	}
	public String getIpfFciBuildId() {
		return this.ipfFciBuildId;
	}
	
	public void setIpfFciBuildId(String ipfFciBuildId) {
		this.ipfFciBuildId = ipfFciBuildId;
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
	public String getVersionBuildNumber() {
		return this.versionBuildNumber;
	}
	
	public void setVersionBuildNumber(String versionBuildNumber) {
		this.versionBuildNumber = versionBuildNumber;
	}
	public String getRevisionNumber() {
		return this.revisionNumber;
	}
	
	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	public String getSvnRevision() {
		return this.svnRevision;
	}
	
	public void setSvnRevision(String svnRevision) {
		this.svnRevision = svnRevision;
	}
	public String getSvnTagsPath() {
		return this.svnTagsPath;
	}
	
	public void setSvnTagsPath(String svnTagsPath) {
		this.svnTagsPath = svnTagsPath;
	}
	public String getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getViewName() {
		return this.viewName;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	public IpfFciLabelUpdateRequest(){}
	
	public IpfFciLabelUpdateRequest(IpfFciLabel ipfFciLabel){
		BeanUtils.copyProperties(ipfFciLabel,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfFciLabel bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfFciLabel cloneBO(){
		IpfFciLabel bo = new IpfFciLabel();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfFciLabel> cloneBOList(List<IpfFciLabelUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfFciLabel>(0);
		List<IpfFciLabel> result = new ArrayList<IpfFciLabel>(vos.size());
		for(IpfFciLabelUpdateRequest vo: vos){
			IpfFciLabel bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


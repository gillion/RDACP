/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfFciView.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfFciView.domain.IpfFciView;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfFciViewUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String viewName;//视图名称
	@Size(min = 0, max = 50)
	private String projectName;//项目名称
	@Size(min = 0, max = 50)
	private String viewDesc;//视图描述
	@Size(min = 0, max = 200)
	private String svnBranchesPath;//SVN路径
	@Size(min = 0, max = 20)
	private String isActive;//启用
	@Size(min = 0, max = 1000)
	private String connectionString;//目标数据库连接
	@Size(min = 0, max = 50)
	private String ipfFciProjectId;//所属项目
	@Size(min = 0, max = 50)
	private String sourceLabelId;//基线名称
	@Size(min = 0, max = 20)
	private String isPermissionPageOnly;//只生成页面权限
	
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
	public String getProjectName() {
		return this.projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getViewDesc() {
		return this.viewDesc;
	}
	
	public void setViewDesc(String viewDesc) {
		this.viewDesc = viewDesc;
	}
	public String getSvnBranchesPath() {
		return this.svnBranchesPath;
	}
	
	public void setSvnBranchesPath(String svnBranchesPath) {
		this.svnBranchesPath = svnBranchesPath;
	}
	public String getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getConnectionString() {
		return this.connectionString;
	}
	
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	public String getIpfFciProjectId() {
		return this.ipfFciProjectId;
	}
	
	public void setIpfFciProjectId(String ipfFciProjectId) {
		this.ipfFciProjectId = ipfFciProjectId;
	}
	public String getSourceLabelId() {
		return this.sourceLabelId;
	}
	
	public void setSourceLabelId(String sourceLabelId) {
		this.sourceLabelId = sourceLabelId;
	}
	public String getIsPermissionPageOnly() {
		return this.isPermissionPageOnly;
	}
	
	public void setIsPermissionPageOnly(String isPermissionPageOnly) {
		this.isPermissionPageOnly = isPermissionPageOnly;
	}
	
	public IpfFciViewUpdateRequest(){}
	
	public IpfFciViewUpdateRequest(IpfFciView ipfFciView){
		BeanUtils.copyProperties(ipfFciView,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfFciView bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfFciView cloneBO(){
		IpfFciView bo = new IpfFciView();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfFciView> cloneBOList(List<IpfFciViewUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfFciView>(0);
		List<IpfFciView> result = new ArrayList<IpfFciView>(vos.size());
		for(IpfFciViewUpdateRequest vo: vos){
			IpfFciView bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


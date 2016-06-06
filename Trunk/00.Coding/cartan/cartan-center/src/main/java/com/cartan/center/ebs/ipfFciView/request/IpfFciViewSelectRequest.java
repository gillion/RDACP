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

public class IpfFciViewSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String viewName;//视图名称
	private String projectName;//项目名称
	private String viewDesc;//视图描述
	private String svnBranchesPath;//SVN路径
	private String isActive;//启用
	private String connectionString;//目标数据库连接
	private String ipfFciProjectId;//所属项目
	private String sourceLabelId;//基线名称
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
	
	
	
	public IpfFciViewSelectRequest(){}
	
	public IpfFciViewSelectRequest(IpfFciView ipfFciView){
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
	
	public static List<IpfFciView> cloneBOList(List<IpfFciViewSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfFciView>(0);
		List<IpfFciView> result = new ArrayList<IpfFciView>(vos.size());
		for(IpfFciViewSelectRequest vo: vos){
			IpfFciView bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


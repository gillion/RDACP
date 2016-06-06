/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciProject.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfFciProject.domain.IpfFciProject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfFciProjectSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String projectName;//项目名称
	private String projectType;//项目类型
	private String projectDes;//项目描述
	private String defaultViewId;//默认视图
	private String svnRepositoryPath;//SVN路径
	private String svnUser;//SVN帐户
	private String svnPassword;//SVN密码
	private String maxRevisonNumber;//最大修订号
	private String ddLanguage;//默认语言
	private String dbType;//数据库类型
	private String dbVersion;//数据库版本号
	private String isActive;//启用
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getProjectName() {
		return this.projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	

	public String getProjectType() {
		return this.projectType;
	}
	
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	

	public String getProjectDes() {
		return this.projectDes;
	}
	
	public void setProjectDes(String projectDes) {
		this.projectDes = projectDes;
	}
	
	

	public String getDefaultViewId() {
		return this.defaultViewId;
	}
	
	public void setDefaultViewId(String defaultViewId) {
		this.defaultViewId = defaultViewId;
	}
	
	

	public String getSvnRepositoryPath() {
		return this.svnRepositoryPath;
	}
	
	public void setSvnRepositoryPath(String svnRepositoryPath) {
		this.svnRepositoryPath = svnRepositoryPath;
	}
	
	

	public String getSvnUser() {
		return this.svnUser;
	}
	
	public void setSvnUser(String svnUser) {
		this.svnUser = svnUser;
	}
	
	

	public String getSvnPassword() {
		return this.svnPassword;
	}
	
	public void setSvnPassword(String svnPassword) {
		this.svnPassword = svnPassword;
	}
	
	

	public String getMaxRevisonNumber() {
		return this.maxRevisonNumber;
	}
	
	public void setMaxRevisonNumber(String maxRevisonNumber) {
		this.maxRevisonNumber = maxRevisonNumber;
	}
	
	

	public String getDdLanguage() {
		return this.ddLanguage;
	}
	
	public void setDdLanguage(String ddLanguage) {
		this.ddLanguage = ddLanguage;
	}
	
	

	public String getDbType() {
		return this.dbType;
	}
	
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	
	

	public String getDbVersion() {
		return this.dbVersion;
	}
	
	public void setDbVersion(String dbVersion) {
		this.dbVersion = dbVersion;
	}
	
	

	public String getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	
	public IpfFciProjectSelectRequest(){}
	
	public IpfFciProjectSelectRequest(IpfFciProject ipfFciProject){
		BeanUtils.copyProperties(ipfFciProject,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfFciProject bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfFciProject cloneBO(){
		IpfFciProject bo = new IpfFciProject();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfFciProject> cloneBOList(List<IpfFciProjectSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfFciProject>(0);
		List<IpfFciProject> result = new ArrayList<IpfFciProject>(vos.size());
		for(IpfFciProjectSelectRequest vo: vos){
			IpfFciProject bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


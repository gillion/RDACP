/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmEnvironment.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmEnvironment.domain.IpfCcmEnvironment;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmEnvironmentCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 200)
	private String userCode;//工程代码
	@Size(min = 0, max = 50)
	private String projectName;//工程名称
	@Size(min = 0, max = 1)
	private String projectPath;//工程路径
	@Size(min = 0, max = 1)
	private String srcPath;//原代码路径
	@Size(min = 0, max = 50)
	private String templatePath;//模板工程目录
	@Size(min = 0, max = 20)
	private String webContentName;//模板工程名称
	@Size(min = 0, max = 20)
	private String targetProjectName;//分支工程名称
	@Size(min = 0, max = 50)
	private String targetProjectPath;//分支工程路径
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getUserCode() {
		return this.userCode;
	}
	
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getProjectName() {
		return this.projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectPath() {
		return this.projectPath;
	}
	
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public String getSrcPath() {
		return this.srcPath;
	}
	
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getTemplatePath() {
		return this.templatePath;
	}
	
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
	public String getWebContentName() {
		return this.webContentName;
	}
	
	public void setWebContentName(String webContentName) {
		this.webContentName = webContentName;
	}
	public String getTargetProjectName() {
		return this.targetProjectName;
	}
	
	public void setTargetProjectName(String targetProjectName) {
		this.targetProjectName = targetProjectName;
	}
	public String getTargetProjectPath() {
		return this.targetProjectPath;
	}
	
	public void setTargetProjectPath(String targetProjectPath) {
		this.targetProjectPath = targetProjectPath;
	}
	
	public IpfCcmEnvironmentCreateRequest(){}
	
	public IpfCcmEnvironmentCreateRequest(IpfCcmEnvironment ipfCcmEnvironment){
		BeanUtils.copyProperties(ipfCcmEnvironment,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmEnvironment bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmEnvironment cloneBO(){
		IpfCcmEnvironment bo = new IpfCcmEnvironment();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmEnvironment> cloneBOList(List<IpfCcmEnvironmentCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmEnvironment>(0);
		List<IpfCcmEnvironment> result = new ArrayList<IpfCcmEnvironment>(vos.size());
		for(IpfCcmEnvironmentCreateRequest vo: vos){
			IpfCcmEnvironment bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


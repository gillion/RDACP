/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegener.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.codegener.domain.Codegener;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class CodegenerSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String setupName;//配置名称
	private String basePackage;//基础包
	private String moduleName;//模块名
	private String root;//根目录
	private String output;//输出路径
	private String sysname;//系统名称

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    private String sid;//SessionId
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getSetupName() {
		return this.setupName;
	}
	
	public void setSetupName(String setupName) {
		this.setupName = setupName;
	}
	
	

	public String getBasePackage() {
		return this.basePackage;
	}
	
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	
	

	public String getModuleName() {
		return this.moduleName;
	}
	
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	

	public String getRoot() {
		return this.root;
	}
	
	public void setRoot(String root) {
		this.root = root;
	}
	
	

	public String getOutput() {
		return this.output;
	}
	
	public void setOutput(String output) {
		this.output = output;
	}
	
	

	public String getSysname() {
		return this.sysname;
	}
	
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	
	
	
	public CodegenerSelectRequest(){}
	
	public CodegenerSelectRequest(Codegener codegener){
		BeanUtils.copyProperties(codegener,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(Codegener bo){
		BeanUtils.copyProperties(this,bo);
	}
	public Codegener cloneBO(){
		Codegener bo = new Codegener();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<Codegener> cloneBOList(List<CodegenerSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<Codegener>(0);
		List<Codegener> result = new ArrayList<Codegener>(vos.size());
		for(CodegenerSelectRequest vo: vos){
			Codegener bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


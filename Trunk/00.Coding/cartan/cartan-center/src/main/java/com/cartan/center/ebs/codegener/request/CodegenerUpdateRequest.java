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
import javax.xml.bind.annotation.XmlAttribute;

public class CodegenerUpdateRequest extends AbstractRopRequest {

    @XmlAttribute
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 1000)
	private String setupName;//配置名称
	@Size(min = 0, max = 200)
	private String basePackage;//基础包
	@Size(min = 0, max = 200)
	private String moduleName;//模块名
	@Size(min = 0, max = 1000)
	private String root;//根目录
	@Size(min = 0, max = 1000)
	private String output;//输出路径
	@Size(min = 0, max = 200)
	private String sysname;//系统名称
    @Size(min = 0, max = 50)
    private String status;//状态
    @Size(min = 0, max = 50)
    private String lockMan;//锁定人
    @Size(min = 0, max = 50)
    private String lockTime;//锁定时间
	
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLockMan() {
        return this.lockMan;
    }

    public void setLockMan(String lockMan) {
        this.lockMan = lockMan;
    }

    public String getLockTime() {
        return this.lockTime;
    }

    public void setLockTime(String lockTime) {
        this.lockTime = lockTime;
    }
	
	public CodegenerUpdateRequest(){}
	
	public CodegenerUpdateRequest(Codegener codegener){
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
	
	public static List<Codegener> cloneBOList(List<CodegenerUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<Codegener>(0);
		List<Codegener> result = new ArrayList<Codegener>(vos.size());
		for(CodegenerUpdateRequest vo: vos){
			Codegener bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


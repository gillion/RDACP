/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmTemplate.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmTemplate.domain.IpfCcmTemplate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmTemplateCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 200)
	private String templateFile;//模板文件
	@Size(min = 0, max = 200)
	private String templateDesc;//模板描述
	@Size(min = 0, max = 20)
	private String templateType;//模板类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getTemplateFile() {
		return this.templateFile;
	}
	
	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}
	public String getTemplateDesc() {
		return this.templateDesc;
	}
	
	public void setTemplateDesc(String templateDesc) {
		this.templateDesc = templateDesc;
	}
	public String getTemplateType() {
		return this.templateType;
	}
	
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	
	public IpfCcmTemplateCreateRequest(){}
	
	public IpfCcmTemplateCreateRequest(IpfCcmTemplate ipfCcmTemplate){
		BeanUtils.copyProperties(ipfCcmTemplate,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmTemplate bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmTemplate cloneBO(){
		IpfCcmTemplate bo = new IpfCcmTemplate();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmTemplate> cloneBOList(List<IpfCcmTemplateCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmTemplate>(0);
		List<IpfCcmTemplate> result = new ArrayList<IpfCcmTemplate>(vos.size());
		for(IpfCcmTemplateCreateRequest vo: vos){
			IpfCcmTemplate bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}

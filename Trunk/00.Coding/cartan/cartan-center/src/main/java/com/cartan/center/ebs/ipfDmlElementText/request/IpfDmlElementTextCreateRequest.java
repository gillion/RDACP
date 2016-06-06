/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlElementText.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlElementText.domain.IpfDmlElementText;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlElementTextCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfDmlElementId;//数据元素
	@Size(min = 0, max = 50)
	private String ddLanguage;//语言
	@Size(min = 0, max = 1000)
	private String ddText;//文本描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfDmlElementId() {
		return this.ipfDmlElementId;
	}
	
	public void setIpfDmlElementId(String ipfDmlElementId) {
		this.ipfDmlElementId = ipfDmlElementId;
	}
	public String getDdLanguage() {
		return this.ddLanguage;
	}
	
	public void setDdLanguage(String ddLanguage) {
		this.ddLanguage = ddLanguage;
	}
	public String getDdText() {
		return this.ddText;
	}
	
	public void setDdText(String ddText) {
		this.ddText = ddText;
	}
	
	public IpfDmlElementTextCreateRequest(){}
	
	public IpfDmlElementTextCreateRequest(IpfDmlElementText ipfDmlElementText){
		BeanUtils.copyProperties(ipfDmlElementText,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlElementText bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlElementText cloneBO(){
		IpfDmlElementText bo = new IpfDmlElementText();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlElementText> cloneBOList(List<IpfDmlElementTextCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlElementText>(0);
		List<IpfDmlElementText> result = new ArrayList<IpfDmlElementText>(vos.size());
		for(IpfDmlElementTextCreateRequest vo: vos){
			IpfDmlElementText bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


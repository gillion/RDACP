/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmShlpText.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmShlpText.domain.IpfCcmShlpText;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmShlpTextUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmShlpId;//搜索帮助
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
	public String getIpfCcmShlpId() {
		return this.ipfCcmShlpId;
	}
	
	public void setIpfCcmShlpId(String ipfCcmShlpId) {
		this.ipfCcmShlpId = ipfCcmShlpId;
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
	
	public IpfCcmShlpTextUpdateRequest(){}
	
	public IpfCcmShlpTextUpdateRequest(IpfCcmShlpText ipfCcmShlpText){
		BeanUtils.copyProperties(ipfCcmShlpText,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmShlpText bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmShlpText cloneBO(){
		IpfCcmShlpText bo = new IpfCcmShlpText();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmShlpText> cloneBOList(List<IpfCcmShlpTextUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmShlpText>(0);
		List<IpfCcmShlpText> result = new ArrayList<IpfCcmShlpText>(vos.size());
		for(IpfCcmShlpTextUpdateRequest vo: vos){
			IpfCcmShlpText bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


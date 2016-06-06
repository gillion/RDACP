/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayoutDetail.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmUiLayoutDetail.domain.IpfCcmUiLayoutDetail;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmUiLayoutDetailSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcmUiLayoutId;//界面布局
	private String ipfCcmUiLayoutListId;//界面布局列表
	private String layoutElementName;//名称
	private String description;//描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfCcmUiLayoutId() {
		return this.ipfCcmUiLayoutId;
	}
	
	public void setIpfCcmUiLayoutId(String ipfCcmUiLayoutId) {
		this.ipfCcmUiLayoutId = ipfCcmUiLayoutId;
	}
	
	

	public String getIpfCcmUiLayoutListId() {
		return this.ipfCcmUiLayoutListId;
	}
	
	public void setIpfCcmUiLayoutListId(String ipfCcmUiLayoutListId) {
		this.ipfCcmUiLayoutListId = ipfCcmUiLayoutListId;
	}
	
	

	public String getLayoutElementName() {
		return this.layoutElementName;
	}
	
	public void setLayoutElementName(String layoutElementName) {
		this.layoutElementName = layoutElementName;
	}
	
	

	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public IpfCcmUiLayoutDetailSelectRequest(){}
	
	public IpfCcmUiLayoutDetailSelectRequest(IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail){
		BeanUtils.copyProperties(ipfCcmUiLayoutDetail,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmUiLayoutDetail bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmUiLayoutDetail cloneBO(){
		IpfCcmUiLayoutDetail bo = new IpfCcmUiLayoutDetail();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmUiLayoutDetail> cloneBOList(List<IpfCcmUiLayoutDetailSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmUiLayoutDetail>(0);
		List<IpfCcmUiLayoutDetail> result = new ArrayList<IpfCcmUiLayoutDetail>(vos.size());
		for(IpfCcmUiLayoutDetailSelectRequest vo: vos){
			IpfCcmUiLayoutDetail bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


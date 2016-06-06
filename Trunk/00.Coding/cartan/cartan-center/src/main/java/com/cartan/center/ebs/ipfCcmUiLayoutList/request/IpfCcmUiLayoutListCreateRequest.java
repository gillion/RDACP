/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmUiLayoutList.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmUiLayoutList.domain.IpfCcmUiLayoutList;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmUiLayoutListCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmUiLayoutId;//界面布局
	@Size(min = 0, max = 50)
	private String pageName;//名称
	@Size(min = 0, max = 50)
	private String description;//描述
	@Size(min = 0, max = 200)
	private String imagePath;//图片路径
	
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
	public String getPageName() {
		return this.pageName;
	}
	
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return this.imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public IpfCcmUiLayoutListCreateRequest(){}
	
	public IpfCcmUiLayoutListCreateRequest(IpfCcmUiLayoutList ipfCcmUiLayoutList){
		BeanUtils.copyProperties(ipfCcmUiLayoutList,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmUiLayoutList bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmUiLayoutList cloneBO(){
		IpfCcmUiLayoutList bo = new IpfCcmUiLayoutList();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmUiLayoutList> cloneBOList(List<IpfCcmUiLayoutListCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmUiLayoutList>(0);
		List<IpfCcmUiLayoutList> result = new ArrayList<IpfCcmUiLayoutList>(vos.size());
		for(IpfCcmUiLayoutListCreateRequest vo: vos){
			IpfCcmUiLayoutList bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoFormToolbar.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoFormToolbar.domain.IpfCcmBoFormToolbar;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoFormToolbarCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcbBoId;//业务对象
	@Size(min = 0, max = 50)
	private String methodName;//调用方法名称
	@Size(min = 0, max = 200)
	private String methodDesc;//调用方法描述
	@Size(min = 0, max = 50)
	private String seqNo;//顺序号
	@Size(min = 0, max = 50)
	private String methodId;//方法ID
	@Size(min = 0, max = 50)
	private String buttonStyle;//按钮样式
	@Size(min = 0, max = 1000)
	private String disabledExpree;//可编辑表达式
	@Size(min = 0, max = 50)
	private String isRefreshParentBo;//刷新主表
	@Size(min = 0, max = 50)
	private String hotkeyType;//热键类型
	@Size(min = 0, max = 50)
	private String hotkeyValue;//热键值
	@Size(min = 0, max = 20)
	private String isHide;//隐藏
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfCcbBoId() {
		return this.ipfCcbBoId;
	}
	
	public void setIpfCcbBoId(String ipfCcbBoId) {
		this.ipfCcbBoId = ipfCcbBoId;
	}
	public String getMethodName() {
		return this.methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getMethodDesc() {
		return this.methodDesc;
	}
	
	public void setMethodDesc(String methodDesc) {
		this.methodDesc = methodDesc;
	}
	public String getSeqNo() {
		return this.seqNo;
	}
	
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getMethodId() {
		return this.methodId;
	}
	
	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}
	public String getButtonStyle() {
		return this.buttonStyle;
	}
	
	public void setButtonStyle(String buttonStyle) {
		this.buttonStyle = buttonStyle;
	}
	public String getDisabledExpree() {
		return this.disabledExpree;
	}
	
	public void setDisabledExpree(String disabledExpree) {
		this.disabledExpree = disabledExpree;
	}
	public String getIsRefreshParentBo() {
		return this.isRefreshParentBo;
	}
	
	public void setIsRefreshParentBo(String isRefreshParentBo) {
		this.isRefreshParentBo = isRefreshParentBo;
	}
	public String getHotkeyType() {
		return this.hotkeyType;
	}
	
	public void setHotkeyType(String hotkeyType) {
		this.hotkeyType = hotkeyType;
	}
	public String getHotkeyValue() {
		return this.hotkeyValue;
	}
	
	public void setHotkeyValue(String hotkeyValue) {
		this.hotkeyValue = hotkeyValue;
	}
	public String getIsHide() {
		return this.isHide;
	}
	
	public void setIsHide(String isHide) {
		this.isHide = isHide;
	}
	
	public IpfCcmBoFormToolbarCreateRequest(){}
	
	public IpfCcmBoFormToolbarCreateRequest(IpfCcmBoFormToolbar ipfCcmBoFormToolbar){
		BeanUtils.copyProperties(ipfCcmBoFormToolbar,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoFormToolbar bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoFormToolbar cloneBO(){
		IpfCcmBoFormToolbar bo = new IpfCcmBoFormToolbar();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoFormToolbar> cloneBOList(List<IpfCcmBoFormToolbarCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoFormToolbar>(0);
		List<IpfCcmBoFormToolbar> result = new ArrayList<IpfCcmBoFormToolbar>(vos.size());
		for(IpfCcmBoFormToolbarCreateRequest vo: vos){
			IpfCcmBoFormToolbar bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


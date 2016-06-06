/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoMethod.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoMethod.domain.IpfCcmBoMethod;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoMethodSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcmBoId;//业务对象
	private String boType;//对象类型
	private String boRefId;//业务对象引用ID
	private String icon;//图标
	private String remark;//备注
	private String methodDesc;//方法描述
	private String methodName;//方法名称
	private String methodType;//方法类型
	private String url;//调用的URL地址
	private String isDefault;//默认方法
	private String isVisible;//可见
	private String refShlpName;//搜索帮助名称
	private String ruleNo;//规则号
	private String jumpMethodId;//跳转方法ID
	private String jumpMethodName;//跳转方法名称
	private String jumpBoName;//跳转业务对象名
	private String width;//宽
	private String height;//高
	private String groupName;//校验分组名称
	private String groupDesc;//校验分组描述
	private String isCache;//是否缓存
	private String cacheType;//缓存类型
	private String requestType;//请求类型
	private String jumpWindowTitle;//弹窗标题
	private String isRefreshParentBo;//是否刷新主表
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfCcmBoId() {
		return this.ipfCcmBoId;
	}
	
	public void setIpfCcmBoId(String ipfCcmBoId) {
		this.ipfCcmBoId = ipfCcmBoId;
	}
	
	

	public String getBoType() {
		return this.boType;
	}
	
	public void setBoType(String boType) {
		this.boType = boType;
	}
	
	

	public String getBoRefId() {
		return this.boRefId;
	}
	
	public void setBoRefId(String boRefId) {
		this.boRefId = boRefId;
	}
	
	

	public String getIcon() {
		return this.icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	

	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	public String getMethodDesc() {
		return this.methodDesc;
	}
	
	public void setMethodDesc(String methodDesc) {
		this.methodDesc = methodDesc;
	}
	
	

	public String getMethodName() {
		return this.methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	

	public String getMethodType() {
		return this.methodType;
	}
	
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	
	

	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	

	public String getIsDefault() {
		return this.isDefault;
	}
	
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	
	

	public String getIsVisible() {
		return this.isVisible;
	}
	
	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
	
	

	public String getRefShlpName() {
		return this.refShlpName;
	}
	
	public void setRefShlpName(String refShlpName) {
		this.refShlpName = refShlpName;
	}
	
	

	public String getRuleNo() {
		return this.ruleNo;
	}
	
	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
	
	

	public String getJumpMethodId() {
		return this.jumpMethodId;
	}
	
	public void setJumpMethodId(String jumpMethodId) {
		this.jumpMethodId = jumpMethodId;
	}
	
	

	public String getJumpMethodName() {
		return this.jumpMethodName;
	}
	
	public void setJumpMethodName(String jumpMethodName) {
		this.jumpMethodName = jumpMethodName;
	}
	
	

	public String getJumpBoName() {
		return this.jumpBoName;
	}
	
	public void setJumpBoName(String jumpBoName) {
		this.jumpBoName = jumpBoName;
	}
	
	

	public String getWidth() {
		return this.width;
	}
	
	public void setWidth(String width) {
		this.width = width;
	}
	
	

	public String getHeight() {
		return this.height;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	
	

	public String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	

	public String getGroupDesc() {
		return this.groupDesc;
	}
	
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	
	

	public String getIsCache() {
		return this.isCache;
	}
	
	public void setIsCache(String isCache) {
		this.isCache = isCache;
	}
	
	

	public String getCacheType() {
		return this.cacheType;
	}
	
	public void setCacheType(String cacheType) {
		this.cacheType = cacheType;
	}
	
	

	public String getRequestType() {
		return this.requestType;
	}
	
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	

	public String getJumpWindowTitle() {
		return this.jumpWindowTitle;
	}
	
	public void setJumpWindowTitle(String jumpWindowTitle) {
		this.jumpWindowTitle = jumpWindowTitle;
	}
	
	

	public String getIsRefreshParentBo() {
		return this.isRefreshParentBo;
	}
	
	public void setIsRefreshParentBo(String isRefreshParentBo) {
		this.isRefreshParentBo = isRefreshParentBo;
	}
	
	
	
	public IpfCcmBoMethodSelectRequest(){}
	
	public IpfCcmBoMethodSelectRequest(IpfCcmBoMethod ipfCcmBoMethod){
		BeanUtils.copyProperties(ipfCcmBoMethod,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoMethod bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoMethod cloneBO(){
		IpfCcmBoMethod bo = new IpfCcmBoMethod();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoMethod> cloneBOList(List<IpfCcmBoMethodSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoMethod>(0);
		List<IpfCcmBoMethod> result = new ArrayList<IpfCcmBoMethod>(vos.size());
		for(IpfCcmBoMethodSelectRequest vo: vos){
			IpfCcmBoMethod bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


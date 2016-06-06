package com.cartan.core.ipfCcmBoMethod.domain;
import java.io.Serializable;


/**
 * IpfCcmBoMethod
 */
public class IpfCcmBoMethod implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_ID;//业务对象
	private String BO_TYPE;//对象类型
	private String BO_REF_ID;//业务对象引用ID
	private String ICON;//图标
	private String REMARK;//备注
	private String METHOD_DESC;//方法描述
	private String METHOD_NAME;//方法名称
	private String METHOD_TYPE;//方法类型
	private String URL;//调用的URL地址
	private String IS_DEFAULT;//默认方法
	private String IS_VISIBLE;//可见
	private String REF_SHLP_NAME;//搜索帮助名称
	private String RULE_NO;//规则号
	private String JUMP_METHOD_ID;//跳转方法ID
	private String JUMP_METHOD_NAME;//跳转方法名称
	private String JUMP_BO_NAME;//跳转业务对象名
	private String WIDTH;//宽
	private String HEIGHT;//高
	private String GROUP_NAME;//校验分组名称
	private String GROUP_DESC;//校验分组描述
	private String IS_CACHE;//是否缓存
	private String CACHE_TYPE;//缓存类型
	private String REQUEST_TYPE;//请求类型
	private String JUMP_WINDOW_TITLE;//弹窗标题
	private String IS_REFRESH_PARENT_BO;//是否刷新主表
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmBoId() {
		return this.IPF_CCM_BO_ID;
	}
	
	public void setIpfCcmBoId(String value) {
		this.IPF_CCM_BO_ID = value;
	}
	

	public String getBoType() {
		return this.BO_TYPE;
	}
	
	public void setBoType(String value) {
		this.BO_TYPE = value;
	}
	

	public String getBoRefId() {
		return this.BO_REF_ID;
	}
	
	public void setBoRefId(String value) {
		this.BO_REF_ID = value;
	}
	

	public String getIcon() {
		return this.ICON;
	}
	
	public void setIcon(String value) {
		this.ICON = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

	public String getMethodDesc() {
		return this.METHOD_DESC;
	}
	
	public void setMethodDesc(String value) {
		this.METHOD_DESC = value;
	}
	

	public String getMethodName() {
		return this.METHOD_NAME;
	}
	
	public void setMethodName(String value) {
		this.METHOD_NAME = value;
	}
	

	public String getMethodType() {
		return this.METHOD_TYPE;
	}
	
	public void setMethodType(String value) {
		this.METHOD_TYPE = value;
	}
	

	public String getUrl() {
		return this.URL;
	}
	
	public void setUrl(String value) {
		this.URL = value;
	}
	

	public String getIsDefault() {
		return this.IS_DEFAULT;
	}
	
	public void setIsDefault(String value) {
		this.IS_DEFAULT = value;
	}
	

	public String getIsVisible() {
		return this.IS_VISIBLE;
	}
	
	public void setIsVisible(String value) {
		this.IS_VISIBLE = value;
	}
	

	public String getRefShlpName() {
		return this.REF_SHLP_NAME;
	}
	
	public void setRefShlpName(String value) {
		this.REF_SHLP_NAME = value;
	}
	

	public String getRuleNo() {
		return this.RULE_NO;
	}
	
	public void setRuleNo(String value) {
		this.RULE_NO = value;
	}
	

	public String getJumpMethodId() {
		return this.JUMP_METHOD_ID;
	}
	
	public void setJumpMethodId(String value) {
		this.JUMP_METHOD_ID = value;
	}
	

	public String getJumpMethodName() {
		return this.JUMP_METHOD_NAME;
	}
	
	public void setJumpMethodName(String value) {
		this.JUMP_METHOD_NAME = value;
	}
	

	public String getJumpBoName() {
		return this.JUMP_BO_NAME;
	}
	
	public void setJumpBoName(String value) {
		this.JUMP_BO_NAME = value;
	}
	

	public String getWidth() {
		return this.WIDTH;
	}
	
	public void setWidth(String value) {
		this.WIDTH = value;
	}
	

	public String getHeight() {
		return this.HEIGHT;
	}
	
	public void setHeight(String value) {
		this.HEIGHT = value;
	}
	

	public String getGroupName() {
		return this.GROUP_NAME;
	}
	
	public void setGroupName(String value) {
		this.GROUP_NAME = value;
	}
	

	public String getGroupDesc() {
		return this.GROUP_DESC;
	}
	
	public void setGroupDesc(String value) {
		this.GROUP_DESC = value;
	}
	

	public String getIsCache() {
		return this.IS_CACHE;
	}
	
	public void setIsCache(String value) {
		this.IS_CACHE = value;
	}
	

	public String getCacheType() {
		return this.CACHE_TYPE;
	}
	
	public void setCacheType(String value) {
		this.CACHE_TYPE = value;
	}
	

	public String getRequestType() {
		return this.REQUEST_TYPE;
	}
	
	public void setRequestType(String value) {
		this.REQUEST_TYPE = value;
	}
	

	public String getJumpWindowTitle() {
		return this.JUMP_WINDOW_TITLE;
	}
	
	public void setJumpWindowTitle(String value) {
		this.JUMP_WINDOW_TITLE = value;
	}
	

	public String getIsRefreshParentBo() {
		return this.IS_REFRESH_PARENT_BO;
	}
	
	public void setIsRefreshParentBo(String value) {
		this.IS_REFRESH_PARENT_BO = value;
	}
	

}

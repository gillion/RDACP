package com.cartan.core.ipfCcmBoRelation.domain;
import java.io.Serializable;


/**
 * IpfCcmBoRelation
 */
public class IpfCcmBoRelation implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_ID;//业务对象
	private String PROPERTY_NAME;//属性名称
	private String SUB_BO_NAME;//子对象名称
	private String SUB_BO_REL_TYPE;//子对象关系类型
	private String OBJECT_TYPE;//对象类型
	private String DESCRIPTION;//描述
	private String SUB_BO_ORDER_NO;//子业务对象的排序号
	private String PERSISTENT_SAVE_TYPE;//子业务对象保存方式
	private String GRID_EDIT_TYPE;//表格维护方式
	private String LINK_BO_NAME;//关联对象名称
	
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
	

	public String getPropertyName() {
		return this.PROPERTY_NAME;
	}
	
	public void setPropertyName(String value) {
		this.PROPERTY_NAME = value;
	}
	

	public String getSubBoName() {
		return this.SUB_BO_NAME;
	}
	
	public void setSubBoName(String value) {
		this.SUB_BO_NAME = value;
	}
	

	public String getSubBoRelType() {
		return this.SUB_BO_REL_TYPE;
	}
	
	public void setSubBoRelType(String value) {
		this.SUB_BO_REL_TYPE = value;
	}
	

	public String getObjectType() {
		return this.OBJECT_TYPE;
	}
	
	public void setObjectType(String value) {
		this.OBJECT_TYPE = value;
	}
	

	public String getDescription() {
		return this.DESCRIPTION;
	}
	
	public void setDescription(String value) {
		this.DESCRIPTION = value;
	}
	

	public String getSubBoOrderNo() {
		return this.SUB_BO_ORDER_NO;
	}
	
	public void setSubBoOrderNo(String value) {
		this.SUB_BO_ORDER_NO = value;
	}
	

	public String getPersistentSaveType() {
		return this.PERSISTENT_SAVE_TYPE;
	}
	
	public void setPersistentSaveType(String value) {
		this.PERSISTENT_SAVE_TYPE = value;
	}
	

	public String getGridEditType() {
		return this.GRID_EDIT_TYPE;
	}
	
	public void setGridEditType(String value) {
		this.GRID_EDIT_TYPE = value;
	}
	

	public String getLinkBoName() {
		return this.LINK_BO_NAME;
	}
	
	public void setLinkBoName(String value) {
		this.LINK_BO_NAME = value;
	}
	

}

package com.cartan.core.ipfCcmBoFormCell.domain;
import java.io.Serializable;


/**
 * IpfCcmBoFormCell
 */
public class IpfCcmBoFormCell implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_ID;//业务对象
	private String FORM_TYPE;//界面类型
	private String IS_DEFAULT;//默认FORM
	private String CELL_NAME;//栅格名称
	private String CELL_TYPE;//栅格类型
	private String CELL_HEIGH;//栅格高度
	private String IS_SHOW_GROUP;//显示分组
	private String GROUP_WIDGET;//分组控件
	private String ELEMENT_CODE;//数据元素代码
	private String GROUP_TITLE;//分组标题
	private String UNIT_COUNT;//包含栅格数
	private String IS_PARENT;//包含子栅格
	private String CHILDREN_LINE_COUNT;//子栅格行数
	private String PARENT_CELL_NAME;//父栅格
	private String ROW_NO;//所属栅格行
	private String COLUMN_NO;//所属栅格列
	private String LABEL_UNIT_COUNT;//标签占栅格数
	
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
	

	public String getFormType() {
		return this.FORM_TYPE;
	}
	
	public void setFormType(String value) {
		this.FORM_TYPE = value;
	}
	

	public String getIsDefault() {
		return this.IS_DEFAULT;
	}
	
	public void setIsDefault(String value) {
		this.IS_DEFAULT = value;
	}
	

	public String getCellName() {
		return this.CELL_NAME;
	}
	
	public void setCellName(String value) {
		this.CELL_NAME = value;
	}
	

	public String getCellType() {
		return this.CELL_TYPE;
	}
	
	public void setCellType(String value) {
		this.CELL_TYPE = value;
	}
	

	public String getCellHeigh() {
		return this.CELL_HEIGH;
	}
	
	public void setCellHeigh(String value) {
		this.CELL_HEIGH = value;
	}
	

	public String getIsShowGroup() {
		return this.IS_SHOW_GROUP;
	}
	
	public void setIsShowGroup(String value) {
		this.IS_SHOW_GROUP = value;
	}
	

	public String getGroupWidget() {
		return this.GROUP_WIDGET;
	}
	
	public void setGroupWidget(String value) {
		this.GROUP_WIDGET = value;
	}
	

	public String getElementCode() {
		return this.ELEMENT_CODE;
	}
	
	public void setElementCode(String value) {
		this.ELEMENT_CODE = value;
	}
	

	public String getGroupTitle() {
		return this.GROUP_TITLE;
	}
	
	public void setGroupTitle(String value) {
		this.GROUP_TITLE = value;
	}
	

	public String getUnitCount() {
		return this.UNIT_COUNT;
	}
	
	public void setUnitCount(String value) {
		this.UNIT_COUNT = value;
	}
	

	public String getIsParent() {
		return this.IS_PARENT;
	}
	
	public void setIsParent(String value) {
		this.IS_PARENT = value;
	}
	

	public String getChildrenLineCount() {
		return this.CHILDREN_LINE_COUNT;
	}
	
	public void setChildrenLineCount(String value) {
		this.CHILDREN_LINE_COUNT = value;
	}
	

	public String getParentCellName() {
		return this.PARENT_CELL_NAME;
	}
	
	public void setParentCellName(String value) {
		this.PARENT_CELL_NAME = value;
	}
	

	public String getRowNo() {
		return this.ROW_NO;
	}
	
	public void setRowNo(String value) {
		this.ROW_NO = value;
	}
	

	public String getColumnNo() {
		return this.COLUMN_NO;
	}
	
	public void setColumnNo(String value) {
		this.COLUMN_NO = value;
	}
	

	public String getLabelUnitCount() {
		return this.LABEL_UNIT_COUNT;
	}
	
	public void setLabelUnitCount(String value) {
		this.LABEL_UNIT_COUNT = value;
	}
	

}

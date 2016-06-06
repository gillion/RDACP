package com.cartan.core.ipfCcmBoPageLayout.domain;
import java.io.Serializable;


/**
 * IpfCcmBoPageLayout
 */
public class IpfCcmBoPageLayout implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_PAGE_ID;//页面
	private String LAYOUT_TYPE;//页面布局类型
	private String LAYOUT_CONTAINER_TYPE;//页面布局容器类型
	private String LAYOUT_BO_NAME;//页面布局业务对象名称
	private String STYLE_CLASS;//样式名称
	private String STYLE;//样式
	private String FORM_TYPE;//表单类型
	private String ELEMENT_NAME;//布局元素名称
	private String HEIGHT;//栅格高度
	private String IS_SHOW_GROUP;//显示分组
	private String GROUP_WIDGET;//分组控件
	private String GROUP_MSG_CODE;//分组标题系统消息代码
	private String GROUP_TITLE;//分组标题
	private String UNIT_COUNT;//包含栅格数
	private String IS_PARENT;//是否父栅格
	private String CHILDREN_LINE_COUNT;//子栅格行数
	private String CELL_NAME;//栅格名称
	private String ROW_NO;//行号
	private String COLUMN_NO;//列号
	private String LABEL_UNIT_COUNT;//标签占栅格数
	private String SEQ_NO;//序号
	private String CONTROL_CONNECTOR;//连接符号
	private String PARENT_CELL_NAME;//父栅格
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmBoPageId() {
		return this.IPF_CCM_BO_PAGE_ID;
	}
	
	public void setIpfCcmBoPageId(String value) {
		this.IPF_CCM_BO_PAGE_ID = value;
	}
	

	public String getLayoutType() {
		return this.LAYOUT_TYPE;
	}
	
	public void setLayoutType(String value) {
		this.LAYOUT_TYPE = value;
	}
	

	public String getLayoutContainerType() {
		return this.LAYOUT_CONTAINER_TYPE;
	}
	
	public void setLayoutContainerType(String value) {
		this.LAYOUT_CONTAINER_TYPE = value;
	}
	

	public String getLayoutBoName() {
		return this.LAYOUT_BO_NAME;
	}
	
	public void setLayoutBoName(String value) {
		this.LAYOUT_BO_NAME = value;
	}
	

	public String getStyleClass() {
		return this.STYLE_CLASS;
	}
	
	public void setStyleClass(String value) {
		this.STYLE_CLASS = value;
	}
	

	public String getStyle() {
		return this.STYLE;
	}
	
	public void setStyle(String value) {
		this.STYLE = value;
	}
	

	public String getFormType() {
		return this.FORM_TYPE;
	}
	
	public void setFormType(String value) {
		this.FORM_TYPE = value;
	}
	

	public String getElementName() {
		return this.ELEMENT_NAME;
	}
	
	public void setElementName(String value) {
		this.ELEMENT_NAME = value;
	}
	

	public String getHeight() {
		return this.HEIGHT;
	}
	
	public void setHeight(String value) {
		this.HEIGHT = value;
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
	

	public String getGroupMsgCode() {
		return this.GROUP_MSG_CODE;
	}
	
	public void setGroupMsgCode(String value) {
		this.GROUP_MSG_CODE = value;
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
	

	public String getCellName() {
		return this.CELL_NAME;
	}
	
	public void setCellName(String value) {
		this.CELL_NAME = value;
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
	

	public String getSeqNo() {
		return this.SEQ_NO;
	}
	
	public void setSeqNo(String value) {
		this.SEQ_NO = value;
	}
	

	public String getControlConnector() {
		return this.CONTROL_CONNECTOR;
	}
	
	public void setControlConnector(String value) {
		this.CONTROL_CONNECTOR = value;
	}
	

	public String getParentCellName() {
		return this.PARENT_CELL_NAME;
	}
	
	public void setParentCellName(String value) {
		this.PARENT_CELL_NAME = value;
	}
	

}

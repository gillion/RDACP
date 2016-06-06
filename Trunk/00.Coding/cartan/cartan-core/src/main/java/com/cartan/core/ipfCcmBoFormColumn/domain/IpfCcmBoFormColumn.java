package com.cartan.core.ipfCcmBoFormColumn.domain;
import java.io.Serializable;


/**
 * IpfCcmBoFormColumn
 */
public class IpfCcmBoFormColumn implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_ID;//业务对象
	private String DEFAULT_VALUE;//初始值
	private String IS_GROUP;//分组
	private String GROUP_NAME;//分组名
	private String IS_CA_NOTE;//是否管理标签页
	private String IS_HEADER;//台头
	private String IS_NOT_NULL;//非空
	private String IS_READ_ONLY;//只读
	private String PROPERTY_NAME;//属性名称
	private String PROPERTY_TYPE;//属性类型
	private String COLUMN_NO;//列号
	private String ROW_NO;//行号
	private String UI_TYPE;//组件类型
	private String IS_VISIBLE;//显示
	private String PROPERTY_ID;//属性ID
	private String RULE_NO;//规则号
	private String COLUMN_STYLE;//列样式
	private String DISPLAY_LABLE;//字段文本是否显示
	private String LABLE_STYLE;//标签样式
	private String CELL_NAME;//单元格名称
	private String TEXT_FORM_HEIGHT;//多行文本控制高度
	private String TEXT_LINE_NUM;//多行文本行数
	private String INLINE_WIDTH;//查询控件高度
	private String INLINE_ORDER_NO;//查询顺序
	private String INLINE_CONNECTOR;//查询连接符
	private String IS_SHOW_LABEL;//显示标签
	private String IS_RADIO_INLINE;//控件内联
	private String TAB_INDEX;//Tab顺序
	private String INIT_VALUE_TYPE;//初始值类型
	private String CORRECT_TYPE;//转换类型
	private String ACTIVE_EXPRESS;//可编辑表达式
	
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
	

	public String getDefaultValue() {
		return this.DEFAULT_VALUE;
	}
	
	public void setDefaultValue(String value) {
		this.DEFAULT_VALUE = value;
	}
	

	public String getIsGroup() {
		return this.IS_GROUP;
	}
	
	public void setIsGroup(String value) {
		this.IS_GROUP = value;
	}
	

	public String getGroupName() {
		return this.GROUP_NAME;
	}
	
	public void setGroupName(String value) {
		this.GROUP_NAME = value;
	}
	

	public String getIsCaNote() {
		return this.IS_CA_NOTE;
	}
	
	public void setIsCaNote(String value) {
		this.IS_CA_NOTE = value;
	}
	

	public String getIsHeader() {
		return this.IS_HEADER;
	}
	
	public void setIsHeader(String value) {
		this.IS_HEADER = value;
	}
	

	public String getIsNotNull() {
		return this.IS_NOT_NULL;
	}
	
	public void setIsNotNull(String value) {
		this.IS_NOT_NULL = value;
	}
	

	public String getIsReadOnly() {
		return this.IS_READ_ONLY;
	}
	
	public void setIsReadOnly(String value) {
		this.IS_READ_ONLY = value;
	}
	

	public String getPropertyName() {
		return this.PROPERTY_NAME;
	}
	
	public void setPropertyName(String value) {
		this.PROPERTY_NAME = value;
	}
	

	public String getPropertyType() {
		return this.PROPERTY_TYPE;
	}
	
	public void setPropertyType(String value) {
		this.PROPERTY_TYPE = value;
	}
	

	public String getColumnNo() {
		return this.COLUMN_NO;
	}
	
	public void setColumnNo(String value) {
		this.COLUMN_NO = value;
	}
	

	public String getRowNo() {
		return this.ROW_NO;
	}
	
	public void setRowNo(String value) {
		this.ROW_NO = value;
	}
	

	public String getUiType() {
		return this.UI_TYPE;
	}
	
	public void setUiType(String value) {
		this.UI_TYPE = value;
	}
	

	public String getIsVisible() {
		return this.IS_VISIBLE;
	}
	
	public void setIsVisible(String value) {
		this.IS_VISIBLE = value;
	}
	

	public String getPropertyId() {
		return this.PROPERTY_ID;
	}
	
	public void setPropertyId(String value) {
		this.PROPERTY_ID = value;
	}
	

	public String getRuleNo() {
		return this.RULE_NO;
	}
	
	public void setRuleNo(String value) {
		this.RULE_NO = value;
	}
	

	public String getColumnStyle() {
		return this.COLUMN_STYLE;
	}
	
	public void setColumnStyle(String value) {
		this.COLUMN_STYLE = value;
	}
	

	public String getDisplayLable() {
		return this.DISPLAY_LABLE;
	}
	
	public void setDisplayLable(String value) {
		this.DISPLAY_LABLE = value;
	}
	

	public String getLableStyle() {
		return this.LABLE_STYLE;
	}
	
	public void setLableStyle(String value) {
		this.LABLE_STYLE = value;
	}
	

	public String getCellName() {
		return this.CELL_NAME;
	}
	
	public void setCellName(String value) {
		this.CELL_NAME = value;
	}
	

	public String getTextFormHeight() {
		return this.TEXT_FORM_HEIGHT;
	}
	
	public void setTextFormHeight(String value) {
		this.TEXT_FORM_HEIGHT = value;
	}
	

	public String getTextLineNum() {
		return this.TEXT_LINE_NUM;
	}
	
	public void setTextLineNum(String value) {
		this.TEXT_LINE_NUM = value;
	}
	

	public String getInlineWidth() {
		return this.INLINE_WIDTH;
	}
	
	public void setInlineWidth(String value) {
		this.INLINE_WIDTH = value;
	}
	

	public String getInlineOrderNo() {
		return this.INLINE_ORDER_NO;
	}
	
	public void setInlineOrderNo(String value) {
		this.INLINE_ORDER_NO = value;
	}
	

	public String getInlineConnector() {
		return this.INLINE_CONNECTOR;
	}
	
	public void setInlineConnector(String value) {
		this.INLINE_CONNECTOR = value;
	}
	

	public String getIsShowLabel() {
		return this.IS_SHOW_LABEL;
	}
	
	public void setIsShowLabel(String value) {
		this.IS_SHOW_LABEL = value;
	}
	

	public String getIsRadioInline() {
		return this.IS_RADIO_INLINE;
	}
	
	public void setIsRadioInline(String value) {
		this.IS_RADIO_INLINE = value;
	}
	

	public String getTabIndex() {
		return this.TAB_INDEX;
	}
	
	public void setTabIndex(String value) {
		this.TAB_INDEX = value;
	}
	

	public String getInitValueType() {
		return this.INIT_VALUE_TYPE;
	}
	
	public void setInitValueType(String value) {
		this.INIT_VALUE_TYPE = value;
	}
	

	public String getCorrectType() {
		return this.CORRECT_TYPE;
	}
	
	public void setCorrectType(String value) {
		this.CORRECT_TYPE = value;
	}
	

	public String getActiveExpress() {
		return this.ACTIVE_EXPRESS;
	}
	
	public void setActiveExpress(String value) {
		this.ACTIVE_EXPRESS = value;
	}
	

}

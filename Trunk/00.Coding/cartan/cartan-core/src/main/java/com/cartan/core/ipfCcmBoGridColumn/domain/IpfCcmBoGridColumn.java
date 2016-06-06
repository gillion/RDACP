package com.cartan.core.ipfCcmBoGridColumn.domain;
import java.io.Serializable;


/**
 * IpfCcmBoGridColumn
 */
public class IpfCcmBoGridColumn implements Serializable{
	private String ID;//主键
	private String IPF_CCM_BO_ID;//业务对象
	private String DEFAULT_VALUE;//初始值
	private String IS_CONDITION;//查询条件
	private String IS_RANGE;//区间查询条件
	private String CORRECT_TYPE;//转换类型
	private String IS_SUM;//汇总
	private String IS_NOT_NULL;//非空
	private String IS_ORDER_BY;//排序
	private String PROPERTY_NAME;//属性名
	private String PROPERTY_TYPE;//属性类型
	private String UI_TYPE;//组件类型
	private String COLUMN_NO;//列号
	private String IS_READ_ONLY;//只读
	private String IS_VISIBLE;//显示
	private String WIDTH;//列宽
	private String PROPERTY_ID;//属性ID
	private String CELL_RULE_NO;//单元格处理规则号
	private String METHOD_ID;//调用方法ID
	private String METHOD_NAME;//调用方法名称
	private String SEARCH_COLUMN_NO;//查询条件列号
	private String SEARCH_ROW_NO;//查询条件行号
	private String OPERATION;//查询操作符
	private String CONDITION_VISIBLE;//查询条件可见性
	private String SHLP_VALUE_TYPE;//值类型
	private String IS_QUICK_SEARCH;//快捷查询
	private String QUICK_CELL_NAME;//快捷查询对应栅格
	private String QUICK_TEXT_FORM_HEIGHT;//快捷查询多行文本控制高度
	private String QUICK_TEXT_LINE_NUM;//快捷查询多行文本行数
	private String QUICK_INLINE_WIDTH;//快捷查询控件高度
	private String QUICK_INLINE_ORDER_NO;//快捷查询顺序
	private String QUICK_INLINE_CONNECTOR;//快捷查询连接符
	private String IS_QUICK_SHOW_LABEL;//快捷查询显示标签
	private String IS_QUICK_RADIO_INLINE;//快捷查询内联
	private String IS_ADV_SEARCH;//需高级查询
	private String ADV_CELL_NAME;//高级查询对应栅格
	private String ADV_TEXT_FORM_HEIGHT;//高级查询多行文本控制高度
	private String ADV_TEXT_LINE_NUM;//高级查询多行文本行数
	private String ADV_INLINE_WIDTH;//高级查询控件高度
	private String ADV_INLINE_ORDER_NO;//高级查询顺序
	private String ADV_INLINE_CONNECTOR;//高级查询连接符
	private String IS_ADV_SHOW_LABEL;//高级查询显示标签
	private String IS_ADV_RADIO_INLINE;//高级查询内联
	private String TAB_INDEX;//Tab顺序
	private String IS_CELL_EDITABLE;//表格可编辑
	private String INIT_VALUE_TYPE;//初始值类型
	private String INIT_VALUE_TYPE2;//初始值类型2
	private String DEFAULT_VALUE2;//初始值2
	private String FIELD_SORT;//字段排序
	private String ACTIVE_EXPRESS;//可编辑表达式
	private String LOCK_COLUMN_EXPRESS;//列锁定表达式
	private String UNLOCK_COLUMN_EXPRESS;//列解锁表达式
	private String IS_SHOW_SORT;//显示排序
	
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
	

	public String getIsCondition() {
		return this.IS_CONDITION;
	}
	
	public void setIsCondition(String value) {
		this.IS_CONDITION = value;
	}
	

	public String getIsRange() {
		return this.IS_RANGE;
	}
	
	public void setIsRange(String value) {
		this.IS_RANGE = value;
	}
	

	public String getCorrectType() {
		return this.CORRECT_TYPE;
	}
	
	public void setCorrectType(String value) {
		this.CORRECT_TYPE = value;
	}
	

	public String getIsSum() {
		return this.IS_SUM;
	}
	
	public void setIsSum(String value) {
		this.IS_SUM = value;
	}
	

	public String getIsNotNull() {
		return this.IS_NOT_NULL;
	}
	
	public void setIsNotNull(String value) {
		this.IS_NOT_NULL = value;
	}
	

	public String getIsOrderBy() {
		return this.IS_ORDER_BY;
	}
	
	public void setIsOrderBy(String value) {
		this.IS_ORDER_BY = value;
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
	

	public String getUiType() {
		return this.UI_TYPE;
	}
	
	public void setUiType(String value) {
		this.UI_TYPE = value;
	}
	

	public String getColumnNo() {
		return this.COLUMN_NO;
	}
	
	public void setColumnNo(String value) {
		this.COLUMN_NO = value;
	}
	

	public String getIsReadOnly() {
		return this.IS_READ_ONLY;
	}
	
	public void setIsReadOnly(String value) {
		this.IS_READ_ONLY = value;
	}
	

	public String getIsVisible() {
		return this.IS_VISIBLE;
	}
	
	public void setIsVisible(String value) {
		this.IS_VISIBLE = value;
	}
	

	public String getWidth() {
		return this.WIDTH;
	}
	
	public void setWidth(String value) {
		this.WIDTH = value;
	}
	

	public String getPropertyId() {
		return this.PROPERTY_ID;
	}
	
	public void setPropertyId(String value) {
		this.PROPERTY_ID = value;
	}
	

	public String getCellRuleNo() {
		return this.CELL_RULE_NO;
	}
	
	public void setCellRuleNo(String value) {
		this.CELL_RULE_NO = value;
	}
	

	public String getMethodId() {
		return this.METHOD_ID;
	}
	
	public void setMethodId(String value) {
		this.METHOD_ID = value;
	}
	

	public String getMethodName() {
		return this.METHOD_NAME;
	}
	
	public void setMethodName(String value) {
		this.METHOD_NAME = value;
	}
	

	public String getSearchColumnNo() {
		return this.SEARCH_COLUMN_NO;
	}
	
	public void setSearchColumnNo(String value) {
		this.SEARCH_COLUMN_NO = value;
	}
	

	public String getSearchRowNo() {
		return this.SEARCH_ROW_NO;
	}
	
	public void setSearchRowNo(String value) {
		this.SEARCH_ROW_NO = value;
	}
	

	public String getOperation() {
		return this.OPERATION;
	}
	
	public void setOperation(String value) {
		this.OPERATION = value;
	}
	

	public String getConditionVisible() {
		return this.CONDITION_VISIBLE;
	}
	
	public void setConditionVisible(String value) {
		this.CONDITION_VISIBLE = value;
	}
	

	public String getShlpValueType() {
		return this.SHLP_VALUE_TYPE;
	}
	
	public void setShlpValueType(String value) {
		this.SHLP_VALUE_TYPE = value;
	}
	

	public String getIsQuickSearch() {
		return this.IS_QUICK_SEARCH;
	}
	
	public void setIsQuickSearch(String value) {
		this.IS_QUICK_SEARCH = value;
	}
	

	public String getQuickCellName() {
		return this.QUICK_CELL_NAME;
	}
	
	public void setQuickCellName(String value) {
		this.QUICK_CELL_NAME = value;
	}
	

	public String getQuickTextFormHeight() {
		return this.QUICK_TEXT_FORM_HEIGHT;
	}
	
	public void setQuickTextFormHeight(String value) {
		this.QUICK_TEXT_FORM_HEIGHT = value;
	}
	

	public String getQuickTextLineNum() {
		return this.QUICK_TEXT_LINE_NUM;
	}
	
	public void setQuickTextLineNum(String value) {
		this.QUICK_TEXT_LINE_NUM = value;
	}
	

	public String getQuickInlineWidth() {
		return this.QUICK_INLINE_WIDTH;
	}
	
	public void setQuickInlineWidth(String value) {
		this.QUICK_INLINE_WIDTH = value;
	}
	

	public String getQuickInlineOrderNo() {
		return this.QUICK_INLINE_ORDER_NO;
	}
	
	public void setQuickInlineOrderNo(String value) {
		this.QUICK_INLINE_ORDER_NO = value;
	}
	

	public String getQuickInlineConnector() {
		return this.QUICK_INLINE_CONNECTOR;
	}
	
	public void setQuickInlineConnector(String value) {
		this.QUICK_INLINE_CONNECTOR = value;
	}
	

	public String getIsQuickShowLabel() {
		return this.IS_QUICK_SHOW_LABEL;
	}
	
	public void setIsQuickShowLabel(String value) {
		this.IS_QUICK_SHOW_LABEL = value;
	}
	

	public String getIsQuickRadioInline() {
		return this.IS_QUICK_RADIO_INLINE;
	}
	
	public void setIsQuickRadioInline(String value) {
		this.IS_QUICK_RADIO_INLINE = value;
	}
	

	public String getIsAdvSearch() {
		return this.IS_ADV_SEARCH;
	}
	
	public void setIsAdvSearch(String value) {
		this.IS_ADV_SEARCH = value;
	}
	

	public String getAdvCellName() {
		return this.ADV_CELL_NAME;
	}
	
	public void setAdvCellName(String value) {
		this.ADV_CELL_NAME = value;
	}
	

	public String getAdvTextFormHeight() {
		return this.ADV_TEXT_FORM_HEIGHT;
	}
	
	public void setAdvTextFormHeight(String value) {
		this.ADV_TEXT_FORM_HEIGHT = value;
	}
	

	public String getAdvTextLineNum() {
		return this.ADV_TEXT_LINE_NUM;
	}
	
	public void setAdvTextLineNum(String value) {
		this.ADV_TEXT_LINE_NUM = value;
	}
	

	public String getAdvInlineWidth() {
		return this.ADV_INLINE_WIDTH;
	}
	
	public void setAdvInlineWidth(String value) {
		this.ADV_INLINE_WIDTH = value;
	}
	

	public String getAdvInlineOrderNo() {
		return this.ADV_INLINE_ORDER_NO;
	}
	
	public void setAdvInlineOrderNo(String value) {
		this.ADV_INLINE_ORDER_NO = value;
	}
	

	public String getAdvInlineConnector() {
		return this.ADV_INLINE_CONNECTOR;
	}
	
	public void setAdvInlineConnector(String value) {
		this.ADV_INLINE_CONNECTOR = value;
	}
	

	public String getIsAdvShowLabel() {
		return this.IS_ADV_SHOW_LABEL;
	}
	
	public void setIsAdvShowLabel(String value) {
		this.IS_ADV_SHOW_LABEL = value;
	}
	

	public String getIsAdvRadioInline() {
		return this.IS_ADV_RADIO_INLINE;
	}
	
	public void setIsAdvRadioInline(String value) {
		this.IS_ADV_RADIO_INLINE = value;
	}
	

	public String getTabIndex() {
		return this.TAB_INDEX;
	}
	
	public void setTabIndex(String value) {
		this.TAB_INDEX = value;
	}
	

	public String getIsCellEditable() {
		return this.IS_CELL_EDITABLE;
	}
	
	public void setIsCellEditable(String value) {
		this.IS_CELL_EDITABLE = value;
	}
	

	public String getInitValueType() {
		return this.INIT_VALUE_TYPE;
	}
	
	public void setInitValueType(String value) {
		this.INIT_VALUE_TYPE = value;
	}
	

	public String getInitValueType2() {
		return this.INIT_VALUE_TYPE2;
	}
	
	public void setInitValueType2(String value) {
		this.INIT_VALUE_TYPE2 = value;
	}
	

	public String getDefaultValue2() {
		return this.DEFAULT_VALUE2;
	}
	
	public void setDefaultValue2(String value) {
		this.DEFAULT_VALUE2 = value;
	}
	

	public String getFieldSort() {
		return this.FIELD_SORT;
	}
	
	public void setFieldSort(String value) {
		this.FIELD_SORT = value;
	}
	

	public String getActiveExpress() {
		return this.ACTIVE_EXPRESS;
	}
	
	public void setActiveExpress(String value) {
		this.ACTIVE_EXPRESS = value;
	}
	

	public String getLockColumnExpress() {
		return this.LOCK_COLUMN_EXPRESS;
	}
	
	public void setLockColumnExpress(String value) {
		this.LOCK_COLUMN_EXPRESS = value;
	}
	

	public String getUnlockColumnExpress() {
		return this.UNLOCK_COLUMN_EXPRESS;
	}
	
	public void setUnlockColumnExpress(String value) {
		this.UNLOCK_COLUMN_EXPRESS = value;
	}
	

	public String getIsShowSort() {
		return this.IS_SHOW_SORT;
	}
	
	public void setIsShowSort(String value) {
		this.IS_SHOW_SORT = value;
	}
	

}

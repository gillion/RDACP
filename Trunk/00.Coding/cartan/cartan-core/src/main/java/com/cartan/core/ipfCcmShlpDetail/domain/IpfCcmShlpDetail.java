package com.cartan.core.ipfCcmShlpDetail.domain;
import java.io.Serializable;


/**
 * IpfCcmShlpDetail
 */
public class IpfCcmShlpDetail implements Serializable{
	private String ID;//主键
	private String IPF_CCM_SHLP_ID;//搜索帮助
	private String SHLP_NAME;//搜索帮助名称
	private String FIELD_NAME;//字段名
	private String FIELD_TEXT;//显示文本
	private String LIST_POSITION;//字段清单中的位置
	private String IS_VISIBLE;//是否清单中显示
	private String IS_INPUT;//输入参数
	private String IS_OUTPUT;//输出参数
	private String DETAIL_STATUS;//状态
	private String DATA_TYPE;//数据类型
	private String DECIMALS;//小数位
	private String DEFAULT_VALUE;//默认值
	private String COLUMN_LENGTH;//长度
	private String CONDITION_POSITION;//条件字段位置
	private String OPERATION;//操作符
	private String IS_ROLL_CHANGE;//条件选择类型
	private String IS_EDITABLE;//弹出窗表格中可编辑
	private String DDTEXT;//字段中文描述
	private String IS_SORT;//排序
	private String SORT_ORDER;//排序顺序
	private String SORT_TYPE;//排序类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfCcmShlpId() {
		return this.IPF_CCM_SHLP_ID;
	}
	
	public void setIpfCcmShlpId(String value) {
		this.IPF_CCM_SHLP_ID = value;
	}
	

	public String getShlpName() {
		return this.SHLP_NAME;
	}
	
	public void setShlpName(String value) {
		this.SHLP_NAME = value;
	}
	

	public String getFieldName() {
		return this.FIELD_NAME;
	}
	
	public void setFieldName(String value) {
		this.FIELD_NAME = value;
	}
	

	public String getFieldText() {
		return this.FIELD_TEXT;
	}
	
	public void setFieldText(String value) {
		this.FIELD_TEXT = value;
	}
	

	public String getListPosition() {
		return this.LIST_POSITION;
	}
	
	public void setListPosition(String value) {
		this.LIST_POSITION = value;
	}
	

	public String getIsVisible() {
		return this.IS_VISIBLE;
	}
	
	public void setIsVisible(String value) {
		this.IS_VISIBLE = value;
	}
	

	public String getIsInput() {
		return this.IS_INPUT;
	}
	
	public void setIsInput(String value) {
		this.IS_INPUT = value;
	}
	

	public String getIsOutput() {
		return this.IS_OUTPUT;
	}
	
	public void setIsOutput(String value) {
		this.IS_OUTPUT = value;
	}
	

	public String getDetailStatus() {
		return this.DETAIL_STATUS;
	}
	
	public void setDetailStatus(String value) {
		this.DETAIL_STATUS = value;
	}
	

	public String getDataType() {
		return this.DATA_TYPE;
	}
	
	public void setDataType(String value) {
		this.DATA_TYPE = value;
	}
	

	public String getDecimals() {
		return this.DECIMALS;
	}
	
	public void setDecimals(String value) {
		this.DECIMALS = value;
	}
	

	public String getDefaultValue() {
		return this.DEFAULT_VALUE;
	}
	
	public void setDefaultValue(String value) {
		this.DEFAULT_VALUE = value;
	}
	

	public String getColumnLength() {
		return this.COLUMN_LENGTH;
	}
	
	public void setColumnLength(String value) {
		this.COLUMN_LENGTH = value;
	}
	

	public String getConditionPosition() {
		return this.CONDITION_POSITION;
	}
	
	public void setConditionPosition(String value) {
		this.CONDITION_POSITION = value;
	}
	

	public String getOperation() {
		return this.OPERATION;
	}
	
	public void setOperation(String value) {
		this.OPERATION = value;
	}
	

	public String getIsRollChange() {
		return this.IS_ROLL_CHANGE;
	}
	
	public void setIsRollChange(String value) {
		this.IS_ROLL_CHANGE = value;
	}
	

	public String getIsEditable() {
		return this.IS_EDITABLE;
	}
	
	public void setIsEditable(String value) {
		this.IS_EDITABLE = value;
	}
	

	public String getDdtext() {
		return this.DDTEXT;
	}
	
	public void setDdtext(String value) {
		this.DDTEXT = value;
	}
	

	public String getIsSort() {
		return this.IS_SORT;
	}
	
	public void setIsSort(String value) {
		this.IS_SORT = value;
	}
	

	public String getSortOrder() {
		return this.SORT_ORDER;
	}
	
	public void setSortOrder(String value) {
		this.SORT_ORDER = value;
	}
	

	public String getSortType() {
		return this.SORT_TYPE;
	}
	
	public void setSortType(String value) {
		this.SORT_TYPE = value;
	}
	

}

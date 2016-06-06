package com.cartan.core.ipfCcmBoProperty.domain;
import java.io.Serializable;


/**
 * IpfCcmBoProperty
 */
public class IpfCcmBoProperty implements Serializable{
	private String ID;//主键
	private String PROPERTY_NAME;//属性名
	private String COLUMN_NAME;//字段名
	private String PROPERTY_TYPE;//属性类型
	private String SUB_BO_LAYOUT_TYPE;//布局类型
	private String TABLE_NAME;//表名
	private String MAX_VALUE;//最大值
	private String MIN_VALUE;//最小值
	private String ELEMENT_CODE;//数据元素代码
	private String FIELD_TEXT;//显示文本
	private String DATA_TYPE;//数据类型
	private String FIELD_LENGTH;//字段长度
	private String DECIMALS;//小数位
	private String IS_NOT_NULL;//非空
	private String IS_KEY;//主键
	private String SUB_BO_NAME;//子业务对象名
	private String SUB_BO_REL_TYPE;//关联BO类型
	private String SUB_BO_REL_PRO;//关系对象属性
	private String SUB_BO_ORDER_NO;//子业务对象的排序号
	private String PERSISTENT_SAVE_TYPE;//子业务对象保存方式
	private String REL_SUB_BO_PRO_NAME;//关联子业务对象属性名称
	private String SEARCH_HELP;//搜索帮助名
	private String REF_PRO_NAME;//搜索帮助关联属性
	private String DICT_TABLE_NAME;//字典表
	private String DICT_GROUP_VALUE;//字典分组值
	private String FETCH_WAY;//取数方式
	private String FIX_VALUE;//取数固定值
	private String VALUE_EXPRESSION;//取数表达式
	private String VLAUE_RULE_NO;//取数规则号
	private String PRE_CONDITION;//前提条件
	private String OPT_CONDITION;//选择条件
	private String IS_SURCHARGE;//附加费
	private String IS_REALTIME_CALCULATE;//实时计算
	private String RP_TYPE;//收付类型
	private String CUST_ID_PROPERTY_NAME;//客户代码属性名称
	private String BUSINESS_DATE_PROPERTY_NAME;//业务日期属性名称
	private String IPF_CCM_BO_ID;//所属业务对象
	private String AUTH_FIELD;//授权字段
	private String HELP_INDEX;//帮助索引号
	private String NUMBER_OBJECT_ID;//号码对象ID
	private String REL_BO_METHOD;//关联业务对象方法名
	private String REL_BO_NAME;//关联业务对象名
	private String SH_TABLE;//搜索帮助表或视图
	private String SH_VALUE_COLUMN;//值字段
	private String VALIDACTION_TYPE;//数据校验类型
	private String VALIDACTION_REGEX;//数据校验正则表达式
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getPropertyName() {
		return this.PROPERTY_NAME;
	}
	
	public void setPropertyName(String value) {
		this.PROPERTY_NAME = value;
	}
	

	public String getColumnName() {
		return this.COLUMN_NAME;
	}
	
	public void setColumnName(String value) {
		this.COLUMN_NAME = value;
	}
	

	public String getPropertyType() {
		return this.PROPERTY_TYPE;
	}
	
	public void setPropertyType(String value) {
		this.PROPERTY_TYPE = value;
	}
	

	public String getSubBoLayoutType() {
		return this.SUB_BO_LAYOUT_TYPE;
	}
	
	public void setSubBoLayoutType(String value) {
		this.SUB_BO_LAYOUT_TYPE = value;
	}
	

	public String getTableName() {
		return this.TABLE_NAME;
	}
	
	public void setTableName(String value) {
		this.TABLE_NAME = value;
	}
	

	public String getMaxValue() {
		return this.MAX_VALUE;
	}
	
	public void setMaxValue(String value) {
		this.MAX_VALUE = value;
	}
	

	public String getMinValue() {
		return this.MIN_VALUE;
	}
	
	public void setMinValue(String value) {
		this.MIN_VALUE = value;
	}
	

	public String getElementCode() {
		return this.ELEMENT_CODE;
	}
	
	public void setElementCode(String value) {
		this.ELEMENT_CODE = value;
	}
	

	public String getFieldText() {
		return this.FIELD_TEXT;
	}
	
	public void setFieldText(String value) {
		this.FIELD_TEXT = value;
	}
	

	public String getDataType() {
		return this.DATA_TYPE;
	}
	
	public void setDataType(String value) {
		this.DATA_TYPE = value;
	}
	

	public String getFieldLength() {
		return this.FIELD_LENGTH;
	}
	
	public void setFieldLength(String value) {
		this.FIELD_LENGTH = value;
	}
	

	public String getDecimals() {
		return this.DECIMALS;
	}
	
	public void setDecimals(String value) {
		this.DECIMALS = value;
	}
	

	public String getIsNotNull() {
		return this.IS_NOT_NULL;
	}
	
	public void setIsNotNull(String value) {
		this.IS_NOT_NULL = value;
	}
	

	public String getIsKey() {
		return this.IS_KEY;
	}
	
	public void setIsKey(String value) {
		this.IS_KEY = value;
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
	

	public String getSubBoRelPro() {
		return this.SUB_BO_REL_PRO;
	}
	
	public void setSubBoRelPro(String value) {
		this.SUB_BO_REL_PRO = value;
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
	

	public String getRelSubBoProName() {
		return this.REL_SUB_BO_PRO_NAME;
	}
	
	public void setRelSubBoProName(String value) {
		this.REL_SUB_BO_PRO_NAME = value;
	}
	

	public String getSearchHelp() {
		return this.SEARCH_HELP;
	}
	
	public void setSearchHelp(String value) {
		this.SEARCH_HELP = value;
	}
	

	public String getRefProName() {
		return this.REF_PRO_NAME;
	}
	
	public void setRefProName(String value) {
		this.REF_PRO_NAME = value;
	}
	

	public String getDictTableName() {
		return this.DICT_TABLE_NAME;
	}
	
	public void setDictTableName(String value) {
		this.DICT_TABLE_NAME = value;
	}
	

	public String getDictGroupValue() {
		return this.DICT_GROUP_VALUE;
	}
	
	public void setDictGroupValue(String value) {
		this.DICT_GROUP_VALUE = value;
	}
	

	public String getFetchWay() {
		return this.FETCH_WAY;
	}
	
	public void setFetchWay(String value) {
		this.FETCH_WAY = value;
	}
	

	public String getFixValue() {
		return this.FIX_VALUE;
	}
	
	public void setFixValue(String value) {
		this.FIX_VALUE = value;
	}
	

	public String getValueExpression() {
		return this.VALUE_EXPRESSION;
	}
	
	public void setValueExpression(String value) {
		this.VALUE_EXPRESSION = value;
	}
	

	public String getVlaueRuleNo() {
		return this.VLAUE_RULE_NO;
	}
	
	public void setVlaueRuleNo(String value) {
		this.VLAUE_RULE_NO = value;
	}
	

	public String getPreCondition() {
		return this.PRE_CONDITION;
	}
	
	public void setPreCondition(String value) {
		this.PRE_CONDITION = value;
	}
	

	public String getOptCondition() {
		return this.OPT_CONDITION;
	}
	
	public void setOptCondition(String value) {
		this.OPT_CONDITION = value;
	}
	

	public String getIsSurcharge() {
		return this.IS_SURCHARGE;
	}
	
	public void setIsSurcharge(String value) {
		this.IS_SURCHARGE = value;
	}
	

	public String getIsRealtimeCalculate() {
		return this.IS_REALTIME_CALCULATE;
	}
	
	public void setIsRealtimeCalculate(String value) {
		this.IS_REALTIME_CALCULATE = value;
	}
	

	public String getRpType() {
		return this.RP_TYPE;
	}
	
	public void setRpType(String value) {
		this.RP_TYPE = value;
	}
	

	public String getCustIdPropertyName() {
		return this.CUST_ID_PROPERTY_NAME;
	}
	
	public void setCustIdPropertyName(String value) {
		this.CUST_ID_PROPERTY_NAME = value;
	}
	

	public String getBusinessDatePropertyName() {
		return this.BUSINESS_DATE_PROPERTY_NAME;
	}
	
	public void setBusinessDatePropertyName(String value) {
		this.BUSINESS_DATE_PROPERTY_NAME = value;
	}
	

	public String getIpfCcmBoId() {
		return this.IPF_CCM_BO_ID;
	}
	
	public void setIpfCcmBoId(String value) {
		this.IPF_CCM_BO_ID = value;
	}
	

	public String getAuthField() {
		return this.AUTH_FIELD;
	}
	
	public void setAuthField(String value) {
		this.AUTH_FIELD = value;
	}
	

	public String getHelpIndex() {
		return this.HELP_INDEX;
	}
	
	public void setHelpIndex(String value) {
		this.HELP_INDEX = value;
	}
	

	public String getNumberObjectId() {
		return this.NUMBER_OBJECT_ID;
	}
	
	public void setNumberObjectId(String value) {
		this.NUMBER_OBJECT_ID = value;
	}
	

	public String getRelBoMethod() {
		return this.REL_BO_METHOD;
	}
	
	public void setRelBoMethod(String value) {
		this.REL_BO_METHOD = value;
	}
	

	public String getRelBoName() {
		return this.REL_BO_NAME;
	}
	
	public void setRelBoName(String value) {
		this.REL_BO_NAME = value;
	}
	

	public String getShTable() {
		return this.SH_TABLE;
	}
	
	public void setShTable(String value) {
		this.SH_TABLE = value;
	}
	

	public String getShValueColumn() {
		return this.SH_VALUE_COLUMN;
	}
	
	public void setShValueColumn(String value) {
		this.SH_VALUE_COLUMN = value;
	}
	

	public String getValidactionType() {
		return this.VALIDACTION_TYPE;
	}
	
	public void setValidactionType(String value) {
		this.VALIDACTION_TYPE = value;
	}
	

	public String getValidactionRegex() {
		return this.VALIDACTION_REGEX;
	}
	
	public void setValidactionRegex(String value) {
		this.VALIDACTION_REGEX = value;
	}
	

}

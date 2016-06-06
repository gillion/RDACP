/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoProperty.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoProperty.domain.IpfCcmBoProperty;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoPropertyCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String propertyName;//属性名
	@Size(min = 0, max = 50)
	private String columnName;//字段名
	@Size(min = 0, max = 50)
	private String propertyType;//属性类型
	@Size(min = 0, max = 50)
	private String subBoLayoutType;//布局类型
	@Size(min = 0, max = 50)
	private String tableName;//表名
	@Size(min = 0, max = 50)
	private String maxValue;//最大值
	@Size(min = 0, max = 50)
	private String minValue;//最小值
	@Size(min = 0, max = 50)
	private String elementCode;//数据元素代码
	@Size(min = 0, max = 1000)
	private String fieldText;//显示文本
	@Size(min = 0, max = 50)
	private String dataType;//数据类型
	@Size(min = 0, max = 50)
	private String fieldLength;//字段长度
	@Size(min = 0, max = 50)
	private String decimals;//小数位
	@Size(min = 0, max = 20)
	private String isNotNull;//非空
	@Size(min = 0, max = 20)
	private String isKey;//主键
	@Size(min = 0, max = 50)
	private String subBoName;//子业务对象名
	@Size(min = 0, max = 50)
	private String subBoRelType;//关联BO类型
	@Size(min = 0, max = 50)
	private String subBoRelPro;//关系对象属性
	@Size(min = 0, max = 50)
	private String subBoOrderNo;//子业务对象的排序号
	@Size(min = 0, max = 50)
	private String persistentSaveType;//子业务对象保存方式
	@Size(min = 0, max = 50)
	private String relSubBoProName;//关联子业务对象属性名称
	@Size(min = 0, max = 50)
	private String searchHelp;//搜索帮助名
	@Size(min = 0, max = 50)
	private String refProName;//搜索帮助关联属性
	@Size(min = 0, max = 50)
	private String dictTableName;//字典表
	@Size(min = 0, max = 50)
	private String dictGroupValue;//字典分组值
	@Size(min = 0, max = 50)
	private String fetchWay;//取数方式
	@Size(min = 0, max = 50)
	private String fixValue;//取数固定值
	@Size(min = 0, max = 2000)
	private String valueExpression;//取数表达式
	@Size(min = 0, max = 50)
	private String vlaueRuleNo;//取数规则号
	@Size(min = 0, max = 2000)
	private String preCondition;//前提条件
	@Size(min = 0, max = 2000)
	private String optCondition;//选择条件
	@Size(min = 0, max = 20)
	private String isSurcharge;//附加费
	@Size(min = 0, max = 20)
	private String isRealtimeCalculate;//实时计算
	@Size(min = 0, max = 20)
	private String rpType;//收付类型
	@Size(min = 0, max = 50)
	private String custIdPropertyName;//客户代码属性名称
	@Size(min = 0, max = 50)
	private String businessDatePropertyName;//业务日期属性名称
	@Size(min = 0, max = 50)
	private String ipfCcmBoId;//所属业务对象
	@Size(min = 0, max = 50)
	private String authField;//授权字段
	@Size(min = 0, max = 50)
	private String helpIndex;//帮助索引号
	@Size(min = 0, max = 50)
	private String numberObjectId;//号码对象ID
	@Size(min = 0, max = 50)
	private String relBoMethod;//关联业务对象方法名
	@Size(min = 0, max = 50)
	private String relBoName;//关联业务对象名
	@Size(min = 0, max = 50)
	private String shTable;//搜索帮助表或视图
	@Size(min = 0, max = 50)
	private String shValueColumn;//值字段
	@Size(min = 0, max = 50)
	private String validactionType;//数据校验类型
	@Size(min = 0, max = 50)
	private String validactionRegex;//数据校验正则表达式
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getColumnName() {
		return this.columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getPropertyType() {
		return this.propertyType;
	}
	
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getSubBoLayoutType() {
		return this.subBoLayoutType;
	}
	
	public void setSubBoLayoutType(String subBoLayoutType) {
		this.subBoLayoutType = subBoLayoutType;
	}
	public String getTableName() {
		return this.tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getMaxValue() {
		return this.maxValue;
	}
	
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public String getMinValue() {
		return this.minValue;
	}
	
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getElementCode() {
		return this.elementCode;
	}
	
	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}
	public String getFieldText() {
		return this.fieldText;
	}
	
	public void setFieldText(String fieldText) {
		this.fieldText = fieldText;
	}
	public String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getFieldLength() {
		return this.fieldLength;
	}
	
	public void setFieldLength(String fieldLength) {
		this.fieldLength = fieldLength;
	}
	public String getDecimals() {
		return this.decimals;
	}
	
	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}
	public String getIsNotNull() {
		return this.isNotNull;
	}
	
	public void setIsNotNull(String isNotNull) {
		this.isNotNull = isNotNull;
	}
	public String getIsKey() {
		return this.isKey;
	}
	
	public void setIsKey(String isKey) {
		this.isKey = isKey;
	}
	public String getSubBoName() {
		return this.subBoName;
	}
	
	public void setSubBoName(String subBoName) {
		this.subBoName = subBoName;
	}
	public String getSubBoRelType() {
		return this.subBoRelType;
	}
	
	public void setSubBoRelType(String subBoRelType) {
		this.subBoRelType = subBoRelType;
	}
	public String getSubBoRelPro() {
		return this.subBoRelPro;
	}
	
	public void setSubBoRelPro(String subBoRelPro) {
		this.subBoRelPro = subBoRelPro;
	}
	public String getSubBoOrderNo() {
		return this.subBoOrderNo;
	}
	
	public void setSubBoOrderNo(String subBoOrderNo) {
		this.subBoOrderNo = subBoOrderNo;
	}
	public String getPersistentSaveType() {
		return this.persistentSaveType;
	}
	
	public void setPersistentSaveType(String persistentSaveType) {
		this.persistentSaveType = persistentSaveType;
	}
	public String getRelSubBoProName() {
		return this.relSubBoProName;
	}
	
	public void setRelSubBoProName(String relSubBoProName) {
		this.relSubBoProName = relSubBoProName;
	}
	public String getSearchHelp() {
		return this.searchHelp;
	}
	
	public void setSearchHelp(String searchHelp) {
		this.searchHelp = searchHelp;
	}
	public String getRefProName() {
		return this.refProName;
	}
	
	public void setRefProName(String refProName) {
		this.refProName = refProName;
	}
	public String getDictTableName() {
		return this.dictTableName;
	}
	
	public void setDictTableName(String dictTableName) {
		this.dictTableName = dictTableName;
	}
	public String getDictGroupValue() {
		return this.dictGroupValue;
	}
	
	public void setDictGroupValue(String dictGroupValue) {
		this.dictGroupValue = dictGroupValue;
	}
	public String getFetchWay() {
		return this.fetchWay;
	}
	
	public void setFetchWay(String fetchWay) {
		this.fetchWay = fetchWay;
	}
	public String getFixValue() {
		return this.fixValue;
	}
	
	public void setFixValue(String fixValue) {
		this.fixValue = fixValue;
	}
	public String getValueExpression() {
		return this.valueExpression;
	}
	
	public void setValueExpression(String valueExpression) {
		this.valueExpression = valueExpression;
	}
	public String getVlaueRuleNo() {
		return this.vlaueRuleNo;
	}
	
	public void setVlaueRuleNo(String vlaueRuleNo) {
		this.vlaueRuleNo = vlaueRuleNo;
	}
	public String getPreCondition() {
		return this.preCondition;
	}
	
	public void setPreCondition(String preCondition) {
		this.preCondition = preCondition;
	}
	public String getOptCondition() {
		return this.optCondition;
	}
	
	public void setOptCondition(String optCondition) {
		this.optCondition = optCondition;
	}
	public String getIsSurcharge() {
		return this.isSurcharge;
	}
	
	public void setIsSurcharge(String isSurcharge) {
		this.isSurcharge = isSurcharge;
	}
	public String getIsRealtimeCalculate() {
		return this.isRealtimeCalculate;
	}
	
	public void setIsRealtimeCalculate(String isRealtimeCalculate) {
		this.isRealtimeCalculate = isRealtimeCalculate;
	}
	public String getRpType() {
		return this.rpType;
	}
	
	public void setRpType(String rpType) {
		this.rpType = rpType;
	}
	public String getCustIdPropertyName() {
		return this.custIdPropertyName;
	}
	
	public void setCustIdPropertyName(String custIdPropertyName) {
		this.custIdPropertyName = custIdPropertyName;
	}
	public String getBusinessDatePropertyName() {
		return this.businessDatePropertyName;
	}
	
	public void setBusinessDatePropertyName(String businessDatePropertyName) {
		this.businessDatePropertyName = businessDatePropertyName;
	}
	public String getIpfCcmBoId() {
		return this.ipfCcmBoId;
	}
	
	public void setIpfCcmBoId(String ipfCcmBoId) {
		this.ipfCcmBoId = ipfCcmBoId;
	}
	public String getAuthField() {
		return this.authField;
	}
	
	public void setAuthField(String authField) {
		this.authField = authField;
	}
	public String getHelpIndex() {
		return this.helpIndex;
	}
	
	public void setHelpIndex(String helpIndex) {
		this.helpIndex = helpIndex;
	}
	public String getNumberObjectId() {
		return this.numberObjectId;
	}
	
	public void setNumberObjectId(String numberObjectId) {
		this.numberObjectId = numberObjectId;
	}
	public String getRelBoMethod() {
		return this.relBoMethod;
	}
	
	public void setRelBoMethod(String relBoMethod) {
		this.relBoMethod = relBoMethod;
	}
	public String getRelBoName() {
		return this.relBoName;
	}
	
	public void setRelBoName(String relBoName) {
		this.relBoName = relBoName;
	}
	public String getShTable() {
		return this.shTable;
	}
	
	public void setShTable(String shTable) {
		this.shTable = shTable;
	}
	public String getShValueColumn() {
		return this.shValueColumn;
	}
	
	public void setShValueColumn(String shValueColumn) {
		this.shValueColumn = shValueColumn;
	}
	public String getValidactionType() {
		return this.validactionType;
	}
	
	public void setValidactionType(String validactionType) {
		this.validactionType = validactionType;
	}
	public String getValidactionRegex() {
		return this.validactionRegex;
	}
	
	public void setValidactionRegex(String validactionRegex) {
		this.validactionRegex = validactionRegex;
	}
	
	public IpfCcmBoPropertyCreateRequest(){}
	
	public IpfCcmBoPropertyCreateRequest(IpfCcmBoProperty ipfCcmBoProperty){
		BeanUtils.copyProperties(ipfCcmBoProperty,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoProperty bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoProperty cloneBO(){
		IpfCcmBoProperty bo = new IpfCcmBoProperty();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoProperty> cloneBOList(List<IpfCcmBoPropertyCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoProperty>(0);
		List<IpfCcmBoProperty> result = new ArrayList<IpfCcmBoProperty>(vos.size());
		for(IpfCcmBoPropertyCreateRequest vo: vos){
			IpfCcmBoProperty bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


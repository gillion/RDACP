/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoGridColumn.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoGridColumn.domain.IpfCcmBoGridColumn;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoGridColumnSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcmBoId;//业务对象
	private String defaultValue;//初始值
	private String isCondition;//查询条件
	private String isRange;//区间查询条件
	private String correctType;//转换类型
	private String isSum;//汇总
	private String isNotNull;//非空
	private String isOrderBy;//排序
	private String propertyName;//属性名
	private String propertyType;//属性类型
	private String uiType;//组件类型
	private String columnNo;//列号
	private String isReadOnly;//只读
	private String isVisible;//显示
	private String width;//列宽
	private String propertyId;//属性ID
	private String cellRuleNo;//单元格处理规则号
	private String methodId;//调用方法ID
	private String methodName;//调用方法名称
	private String searchColumnNo;//查询条件列号
	private String searchRowNo;//查询条件行号
	private String operation;//查询操作符
	private String conditionVisible;//查询条件可见性
	private String shlpValueType;//值类型
	private String isQuickSearch;//快捷查询
	private String quickCellName;//快捷查询对应栅格
	private String quickTextFormHeight;//快捷查询多行文本控制高度
	private String quickTextLineNum;//快捷查询多行文本行数
	private String quickInlineWidth;//快捷查询控件高度
	private String quickInlineOrderNo;//快捷查询顺序
	private String quickInlineConnector;//快捷查询连接符
	private String isQuickShowLabel;//快捷查询显示标签
	private String isQuickRadioInline;//快捷查询内联
	private String isAdvSearch;//需高级查询
	private String advCellName;//高级查询对应栅格
	private String advTextFormHeight;//高级查询多行文本控制高度
	private String advTextLineNum;//高级查询多行文本行数
	private String advInlineWidth;//高级查询控件高度
	private String advInlineOrderNo;//高级查询顺序
	private String advInlineConnector;//高级查询连接符
	private String isAdvShowLabel;//高级查询显示标签
	private String isAdvRadioInline;//高级查询内联
	private String tabIndex;//Tab顺序
	private String isCellEditable;//表格可编辑
	private String initValueType;//初始值类型
	private String initValueType2;//初始值类型2
	private String defaultValue2;//初始值2
	private String fieldSort;//字段排序
	private String activeExpress;//可编辑表达式
	private String lockColumnExpress;//列锁定表达式
	private String unlockColumnExpress;//列解锁表达式
	private String isShowSort;//显示排序
	
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
	
	

	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	

	public String getIsCondition() {
		return this.isCondition;
	}
	
	public void setIsCondition(String isCondition) {
		this.isCondition = isCondition;
	}
	
	

	public String getIsRange() {
		return this.isRange;
	}
	
	public void setIsRange(String isRange) {
		this.isRange = isRange;
	}
	
	

	public String getCorrectType() {
		return this.correctType;
	}
	
	public void setCorrectType(String correctType) {
		this.correctType = correctType;
	}
	
	

	public String getIsSum() {
		return this.isSum;
	}
	
	public void setIsSum(String isSum) {
		this.isSum = isSum;
	}
	
	

	public String getIsNotNull() {
		return this.isNotNull;
	}
	
	public void setIsNotNull(String isNotNull) {
		this.isNotNull = isNotNull;
	}
	
	

	public String getIsOrderBy() {
		return this.isOrderBy;
	}
	
	public void setIsOrderBy(String isOrderBy) {
		this.isOrderBy = isOrderBy;
	}
	
	

	public String getPropertyName() {
		return this.propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	

	public String getPropertyType() {
		return this.propertyType;
	}
	
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	

	public String getUiType() {
		return this.uiType;
	}
	
	public void setUiType(String uiType) {
		this.uiType = uiType;
	}
	
	

	public String getColumnNo() {
		return this.columnNo;
	}
	
	public void setColumnNo(String columnNo) {
		this.columnNo = columnNo;
	}
	
	

	public String getIsReadOnly() {
		return this.isReadOnly;
	}
	
	public void setIsReadOnly(String isReadOnly) {
		this.isReadOnly = isReadOnly;
	}
	
	

	public String getIsVisible() {
		return this.isVisible;
	}
	
	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
	
	

	public String getWidth() {
		return this.width;
	}
	
	public void setWidth(String width) {
		this.width = width;
	}
	
	

	public String getPropertyId() {
		return this.propertyId;
	}
	
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	

	public String getCellRuleNo() {
		return this.cellRuleNo;
	}
	
	public void setCellRuleNo(String cellRuleNo) {
		this.cellRuleNo = cellRuleNo;
	}
	
	

	public String getMethodId() {
		return this.methodId;
	}
	
	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}
	
	

	public String getMethodName() {
		return this.methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	

	public String getSearchColumnNo() {
		return this.searchColumnNo;
	}
	
	public void setSearchColumnNo(String searchColumnNo) {
		this.searchColumnNo = searchColumnNo;
	}
	
	

	public String getSearchRowNo() {
		return this.searchRowNo;
	}
	
	public void setSearchRowNo(String searchRowNo) {
		this.searchRowNo = searchRowNo;
	}
	
	

	public String getOperation() {
		return this.operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

	public String getConditionVisible() {
		return this.conditionVisible;
	}
	
	public void setConditionVisible(String conditionVisible) {
		this.conditionVisible = conditionVisible;
	}
	
	

	public String getShlpValueType() {
		return this.shlpValueType;
	}
	
	public void setShlpValueType(String shlpValueType) {
		this.shlpValueType = shlpValueType;
	}
	
	

	public String getIsQuickSearch() {
		return this.isQuickSearch;
	}
	
	public void setIsQuickSearch(String isQuickSearch) {
		this.isQuickSearch = isQuickSearch;
	}
	
	

	public String getQuickCellName() {
		return this.quickCellName;
	}
	
	public void setQuickCellName(String quickCellName) {
		this.quickCellName = quickCellName;
	}
	
	

	public String getQuickTextFormHeight() {
		return this.quickTextFormHeight;
	}
	
	public void setQuickTextFormHeight(String quickTextFormHeight) {
		this.quickTextFormHeight = quickTextFormHeight;
	}
	
	

	public String getQuickTextLineNum() {
		return this.quickTextLineNum;
	}
	
	public void setQuickTextLineNum(String quickTextLineNum) {
		this.quickTextLineNum = quickTextLineNum;
	}
	
	

	public String getQuickInlineWidth() {
		return this.quickInlineWidth;
	}
	
	public void setQuickInlineWidth(String quickInlineWidth) {
		this.quickInlineWidth = quickInlineWidth;
	}
	
	

	public String getQuickInlineOrderNo() {
		return this.quickInlineOrderNo;
	}
	
	public void setQuickInlineOrderNo(String quickInlineOrderNo) {
		this.quickInlineOrderNo = quickInlineOrderNo;
	}
	
	

	public String getQuickInlineConnector() {
		return this.quickInlineConnector;
	}
	
	public void setQuickInlineConnector(String quickInlineConnector) {
		this.quickInlineConnector = quickInlineConnector;
	}
	
	

	public String getIsQuickShowLabel() {
		return this.isQuickShowLabel;
	}
	
	public void setIsQuickShowLabel(String isQuickShowLabel) {
		this.isQuickShowLabel = isQuickShowLabel;
	}
	
	

	public String getIsQuickRadioInline() {
		return this.isQuickRadioInline;
	}
	
	public void setIsQuickRadioInline(String isQuickRadioInline) {
		this.isQuickRadioInline = isQuickRadioInline;
	}
	
	

	public String getIsAdvSearch() {
		return this.isAdvSearch;
	}
	
	public void setIsAdvSearch(String isAdvSearch) {
		this.isAdvSearch = isAdvSearch;
	}
	
	

	public String getAdvCellName() {
		return this.advCellName;
	}
	
	public void setAdvCellName(String advCellName) {
		this.advCellName = advCellName;
	}
	
	

	public String getAdvTextFormHeight() {
		return this.advTextFormHeight;
	}
	
	public void setAdvTextFormHeight(String advTextFormHeight) {
		this.advTextFormHeight = advTextFormHeight;
	}
	
	

	public String getAdvTextLineNum() {
		return this.advTextLineNum;
	}
	
	public void setAdvTextLineNum(String advTextLineNum) {
		this.advTextLineNum = advTextLineNum;
	}
	
	

	public String getAdvInlineWidth() {
		return this.advInlineWidth;
	}
	
	public void setAdvInlineWidth(String advInlineWidth) {
		this.advInlineWidth = advInlineWidth;
	}
	
	

	public String getAdvInlineOrderNo() {
		return this.advInlineOrderNo;
	}
	
	public void setAdvInlineOrderNo(String advInlineOrderNo) {
		this.advInlineOrderNo = advInlineOrderNo;
	}
	
	

	public String getAdvInlineConnector() {
		return this.advInlineConnector;
	}
	
	public void setAdvInlineConnector(String advInlineConnector) {
		this.advInlineConnector = advInlineConnector;
	}
	
	

	public String getIsAdvShowLabel() {
		return this.isAdvShowLabel;
	}
	
	public void setIsAdvShowLabel(String isAdvShowLabel) {
		this.isAdvShowLabel = isAdvShowLabel;
	}
	
	

	public String getIsAdvRadioInline() {
		return this.isAdvRadioInline;
	}
	
	public void setIsAdvRadioInline(String isAdvRadioInline) {
		this.isAdvRadioInline = isAdvRadioInline;
	}
	
	

	public String getTabIndex() {
		return this.tabIndex;
	}
	
	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}
	
	

	public String getIsCellEditable() {
		return this.isCellEditable;
	}
	
	public void setIsCellEditable(String isCellEditable) {
		this.isCellEditable = isCellEditable;
	}
	
	

	public String getInitValueType() {
		return this.initValueType;
	}
	
	public void setInitValueType(String initValueType) {
		this.initValueType = initValueType;
	}
	
	

	public String getInitValueType2() {
		return this.initValueType2;
	}
	
	public void setInitValueType2(String initValueType2) {
		this.initValueType2 = initValueType2;
	}
	
	

	public String getDefaultValue2() {
		return this.defaultValue2;
	}
	
	public void setDefaultValue2(String defaultValue2) {
		this.defaultValue2 = defaultValue2;
	}
	
	

	public String getFieldSort() {
		return this.fieldSort;
	}
	
	public void setFieldSort(String fieldSort) {
		this.fieldSort = fieldSort;
	}
	
	

	public String getActiveExpress() {
		return this.activeExpress;
	}
	
	public void setActiveExpress(String activeExpress) {
		this.activeExpress = activeExpress;
	}
	
	

	public String getLockColumnExpress() {
		return this.lockColumnExpress;
	}
	
	public void setLockColumnExpress(String lockColumnExpress) {
		this.lockColumnExpress = lockColumnExpress;
	}
	
	

	public String getUnlockColumnExpress() {
		return this.unlockColumnExpress;
	}
	
	public void setUnlockColumnExpress(String unlockColumnExpress) {
		this.unlockColumnExpress = unlockColumnExpress;
	}
	
	

	public String getIsShowSort() {
		return this.isShowSort;
	}
	
	public void setIsShowSort(String isShowSort) {
		this.isShowSort = isShowSort;
	}
	
	
	
	public IpfCcmBoGridColumnSelectRequest(){}
	
	public IpfCcmBoGridColumnSelectRequest(IpfCcmBoGridColumn ipfCcmBoGridColumn){
		BeanUtils.copyProperties(ipfCcmBoGridColumn,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoGridColumn bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoGridColumn cloneBO(){
		IpfCcmBoGridColumn bo = new IpfCcmBoGridColumn();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoGridColumn> cloneBOList(List<IpfCcmBoGridColumnSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoGridColumn>(0);
		List<IpfCcmBoGridColumn> result = new ArrayList<IpfCcmBoGridColumn>(vos.size());
		for(IpfCcmBoGridColumnSelectRequest vo: vos){
			IpfCcmBoGridColumn bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


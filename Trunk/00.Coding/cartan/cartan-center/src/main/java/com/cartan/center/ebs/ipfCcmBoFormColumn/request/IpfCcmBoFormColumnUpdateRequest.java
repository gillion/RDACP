/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmBoFormColumn.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoFormColumn.domain.IpfCcmBoFormColumn;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoFormColumnUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBoId;//业务对象
	@Size(min = 0, max = 50)
	private String defaultValue;//初始值
	@Size(min = 0, max = 20)
	private String isGroup;//分组
	@Size(min = 0, max = 50)
	private String groupName;//分组名
	@Size(min = 0, max = 20)
	private String isCaNote;//是否管理标签页
	@Size(min = 0, max = 20)
	private String isHeader;//台头
	@Size(min = 0, max = 20)
	private String isNotNull;//非空
	@Size(min = 0, max = 20)
	private String isReadOnly;//只读
	@Size(min = 0, max = 50)
	private String propertyName;//属性名称
	@Size(min = 0, max = 50)
	private String propertyType;//属性类型
	@Size(min = 0, max = 50)
	private String columnNo;//列号
	@Size(min = 0, max = 50)
	private String rowNo;//行号
	@Size(min = 0, max = 50)
	private String uiType;//组件类型
	@Size(min = 0, max = 20)
	private String isVisible;//显示
	@Size(min = 0, max = 50)
	private String propertyId;//属性ID
	@Size(min = 0, max = 50)
	private String ruleNo;//规则号
	@Size(min = 0, max = 50)
	private String columnStyle;//列样式
	@Size(min = 0, max = 50)
	private String displayLable;//字段文本是否显示
	@Size(min = 0, max = 50)
	private String lableStyle;//标签样式
	@Size(min = 0, max = 50)
	private String cellName;//单元格名称
	@Size(min = 0, max = 50)
	private String textFormHeight;//多行文本控制高度
	@Size(min = 0, max = 50)
	private String textLineNum;//多行文本行数
	@Size(min = 0, max = 50)
	private String inlineWidth;//查询控件高度
	@Size(min = 0, max = 50)
	private String inlineOrderNo;//查询顺序
	@Size(min = 0, max = 50)
	private String inlineConnector;//查询连接符
	@Size(min = 0, max = 50)
	private String isShowLabel;//显示标签
	@Size(min = 0, max = 50)
	private String isRadioInline;//控件内联
	@Size(min = 0, max = 50)
	private String tabIndex;//Tab顺序
	@Size(min = 0, max = 50)
	private String initValueType;//初始值类型
	@Size(min = 0, max = 50)
	private String correctType;//转换类型
	@Size(min = 0, max = 1000)
	private String activeExpress;//可编辑表达式
	
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
	public String getIsGroup() {
		return this.isGroup;
	}
	
	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}
	public String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getIsCaNote() {
		return this.isCaNote;
	}
	
	public void setIsCaNote(String isCaNote) {
		this.isCaNote = isCaNote;
	}
	public String getIsHeader() {
		return this.isHeader;
	}
	
	public void setIsHeader(String isHeader) {
		this.isHeader = isHeader;
	}
	public String getIsNotNull() {
		return this.isNotNull;
	}
	
	public void setIsNotNull(String isNotNull) {
		this.isNotNull = isNotNull;
	}
	public String getIsReadOnly() {
		return this.isReadOnly;
	}
	
	public void setIsReadOnly(String isReadOnly) {
		this.isReadOnly = isReadOnly;
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
	public String getColumnNo() {
		return this.columnNo;
	}
	
	public void setColumnNo(String columnNo) {
		this.columnNo = columnNo;
	}
	public String getRowNo() {
		return this.rowNo;
	}
	
	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}
	public String getUiType() {
		return this.uiType;
	}
	
	public void setUiType(String uiType) {
		this.uiType = uiType;
	}
	public String getIsVisible() {
		return this.isVisible;
	}
	
	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
	public String getPropertyId() {
		return this.propertyId;
	}
	
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public String getRuleNo() {
		return this.ruleNo;
	}
	
	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
	public String getColumnStyle() {
		return this.columnStyle;
	}
	
	public void setColumnStyle(String columnStyle) {
		this.columnStyle = columnStyle;
	}
	public String getDisplayLable() {
		return this.displayLable;
	}
	
	public void setDisplayLable(String displayLable) {
		this.displayLable = displayLable;
	}
	public String getLableStyle() {
		return this.lableStyle;
	}
	
	public void setLableStyle(String lableStyle) {
		this.lableStyle = lableStyle;
	}
	public String getCellName() {
		return this.cellName;
	}
	
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public String getTextFormHeight() {
		return this.textFormHeight;
	}
	
	public void setTextFormHeight(String textFormHeight) {
		this.textFormHeight = textFormHeight;
	}
	public String getTextLineNum() {
		return this.textLineNum;
	}
	
	public void setTextLineNum(String textLineNum) {
		this.textLineNum = textLineNum;
	}
	public String getInlineWidth() {
		return this.inlineWidth;
	}
	
	public void setInlineWidth(String inlineWidth) {
		this.inlineWidth = inlineWidth;
	}
	public String getInlineOrderNo() {
		return this.inlineOrderNo;
	}
	
	public void setInlineOrderNo(String inlineOrderNo) {
		this.inlineOrderNo = inlineOrderNo;
	}
	public String getInlineConnector() {
		return this.inlineConnector;
	}
	
	public void setInlineConnector(String inlineConnector) {
		this.inlineConnector = inlineConnector;
	}
	public String getIsShowLabel() {
		return this.isShowLabel;
	}
	
	public void setIsShowLabel(String isShowLabel) {
		this.isShowLabel = isShowLabel;
	}
	public String getIsRadioInline() {
		return this.isRadioInline;
	}
	
	public void setIsRadioInline(String isRadioInline) {
		this.isRadioInline = isRadioInline;
	}
	public String getTabIndex() {
		return this.tabIndex;
	}
	
	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}
	public String getInitValueType() {
		return this.initValueType;
	}
	
	public void setInitValueType(String initValueType) {
		this.initValueType = initValueType;
	}
	public String getCorrectType() {
		return this.correctType;
	}
	
	public void setCorrectType(String correctType) {
		this.correctType = correctType;
	}
	public String getActiveExpress() {
		return this.activeExpress;
	}
	
	public void setActiveExpress(String activeExpress) {
		this.activeExpress = activeExpress;
	}
	
	public IpfCcmBoFormColumnUpdateRequest(){}
	
	public IpfCcmBoFormColumnUpdateRequest(IpfCcmBoFormColumn ipfCcmBoFormColumn){
		BeanUtils.copyProperties(ipfCcmBoFormColumn,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoFormColumn bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoFormColumn cloneBO(){
		IpfCcmBoFormColumn bo = new IpfCcmBoFormColumn();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoFormColumn> cloneBOList(List<IpfCcmBoFormColumnUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoFormColumn>(0);
		List<IpfCcmBoFormColumn> result = new ArrayList<IpfCcmBoFormColumn>(vos.size());
		for(IpfCcmBoFormColumnUpdateRequest vo: vos){
			IpfCcmBoFormColumn bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmBoPgLoElement.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoPgLoElement.domain.IpfCcmBoPgLoElement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoPgLoElementUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBoPageLayoutId;//页面布局
	@Size(min = 0, max = 50)
	private String seqNo;//序号
	@Size(min = 0, max = 50)
	private String layoutElementType;//页面布局元素类型
	@Size(min = 0, max = 50)
	private String layoutBoName;//页面布局业务对象名称
	@Size(min = 0, max = 50)
	private String controlHeight;//控件高度
	@Size(min = 0, max = 50)
	private String controlWidth;//控件宽度
	@Size(min = 0, max = 50)
	private String textLineNum;//多行文本行数
	@Size(min = 0, max = 50)
	private String controlConnector;//连接符
	@Size(min = 0, max = 20)
	private String isNotNull;//非空
	@Size(min = 0, max = 20)
	private String isReadOnly;//只读
	@Size(min = 0, max = 50)
	private String uiType;//控件类型
	@Size(min = 0, max = 20)
	private String isVisible;//可见
	@Size(min = 0, max = 50)
	private String columnStyle;//列样式
	@Size(min = 0, max = 50)
	private String lableStyle;//标签样式
	@Size(min = 0, max = 20)
	private String isShowLable;//显示标签
	@Size(min = 0, max = 20)
	private String isInline;//控件内联
	@Size(min = 0, max = 50)
	private String tabIndex;//Tab顺序
	@Size(min = 0, max = 50)
	private String defaultValue;//默认值
	@Size(min = 0, max = 50)
	private String initValueType;//初始值类型
	@Size(min = 0, max = 50)
	private String correctType;//转换类型
	@Size(min = 0, max = 50)
	private String conditionType;//查询条件类型
	@Size(min = 0, max = 50)
	private String operation;//操作符
	@Size(min = 0, max = 50)
	private String queryType;//查询类型
	@Size(min = 0, max = 50)
	private String rangeType;//区间类型
	@Size(min = 0, max = 50)
	private String methodName;//方法名称
	@Size(min = 0, max = 50)
	private String propertyName;//属性名
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfCcmBoPageLayoutId() {
		return this.ipfCcmBoPageLayoutId;
	}
	
	public void setIpfCcmBoPageLayoutId(String ipfCcmBoPageLayoutId) {
		this.ipfCcmBoPageLayoutId = ipfCcmBoPageLayoutId;
	}
	public String getSeqNo() {
		return this.seqNo;
	}
	
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getLayoutElementType() {
		return this.layoutElementType;
	}
	
	public void setLayoutElementType(String layoutElementType) {
		this.layoutElementType = layoutElementType;
	}
	public String getLayoutBoName() {
		return this.layoutBoName;
	}
	
	public void setLayoutBoName(String layoutBoName) {
		this.layoutBoName = layoutBoName;
	}
	public String getControlHeight() {
		return this.controlHeight;
	}
	
	public void setControlHeight(String controlHeight) {
		this.controlHeight = controlHeight;
	}
	public String getControlWidth() {
		return this.controlWidth;
	}
	
	public void setControlWidth(String controlWidth) {
		this.controlWidth = controlWidth;
	}
	public String getTextLineNum() {
		return this.textLineNum;
	}
	
	public void setTextLineNum(String textLineNum) {
		this.textLineNum = textLineNum;
	}
	public String getControlConnector() {
		return this.controlConnector;
	}
	
	public void setControlConnector(String controlConnector) {
		this.controlConnector = controlConnector;
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
	public String getColumnStyle() {
		return this.columnStyle;
	}
	
	public void setColumnStyle(String columnStyle) {
		this.columnStyle = columnStyle;
	}
	public String getLableStyle() {
		return this.lableStyle;
	}
	
	public void setLableStyle(String lableStyle) {
		this.lableStyle = lableStyle;
	}
	public String getIsShowLable() {
		return this.isShowLable;
	}
	
	public void setIsShowLable(String isShowLable) {
		this.isShowLable = isShowLable;
	}
	public String getIsInline() {
		return this.isInline;
	}
	
	public void setIsInline(String isInline) {
		this.isInline = isInline;
	}
	public String getTabIndex() {
		return this.tabIndex;
	}
	
	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
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
	public String getConditionType() {
		return this.conditionType;
	}
	
	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
	public String getOperation() {
		return this.operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getQueryType() {
		return this.queryType;
	}
	
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public String getRangeType() {
		return this.rangeType;
	}
	
	public void setRangeType(String rangeType) {
		this.rangeType = rangeType;
	}
	public String getMethodName() {
		return this.methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public IpfCcmBoPgLoElementUpdateRequest(){}
	
	public IpfCcmBoPgLoElementUpdateRequest(IpfCcmBoPgLoElement ipfCcmBoPgLoElement){
		BeanUtils.copyProperties(ipfCcmBoPgLoElement,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoPgLoElement bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoPgLoElement cloneBO(){
		IpfCcmBoPgLoElement bo = new IpfCcmBoPgLoElement();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoPgLoElement> cloneBOList(List<IpfCcmBoPgLoElementUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoPgLoElement>(0);
		List<IpfCcmBoPgLoElement> result = new ArrayList<IpfCcmBoPgLoElement>(vos.size());
		for(IpfCcmBoPgLoElementUpdateRequest vo: vos){
			IpfCcmBoPgLoElement bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


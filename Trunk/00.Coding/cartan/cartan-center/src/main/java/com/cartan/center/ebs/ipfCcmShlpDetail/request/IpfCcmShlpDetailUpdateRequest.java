/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmShlpDetail.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmShlpDetail.domain.IpfCcmShlpDetail;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmShlpDetailUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmShlpId;//搜索帮助
	@Size(min = 0, max = 50)
	private String shlpName;//搜索帮助名称
	@Size(min = 0, max = 50)
	private String fieldName;//字段名
	@Size(min = 0, max = 1000)
	private String fieldText;//显示文本
	@Size(min = 0, max = 50)
	private String listPosition;//字段清单中的位置
	@Size(min = 0, max = 20)
	private String isVisible;//是否清单中显示
	@Size(min = 0, max = 20)
	private String isInput;//输入参数
	@Size(min = 0, max = 20)
	private String isOutput;//输出参数
	@Size(min = 0, max = 50)
	private String detailStatus;//状态
	@Size(min = 0, max = 50)
	private String dataType;//数据类型
	@Size(min = 0, max = 50)
	private String decimals;//小数位
	@Size(min = 0, max = 50)
	private String defaultValue;//默认值
	@Size(min = 0, max = 50)
	private String columnLength;//长度
	@Size(min = 0, max = 50)
	private String conditionPosition;//条件字段位置
	@Size(min = 0, max = 50)
	private String operation;//操作符
	@Size(min = 0, max = 20)
	private String isRollChange;//条件选择类型
	@Size(min = 0, max = 20)
	private String isEditable;//弹出窗表格中可编辑
	@Size(min = 0, max = 1000)
	private String ddtext;//字段中文描述
	@Size(min = 0, max = 20)
	private String isSort;//排序
	@Size(min = 0, max = 50)
	private String sortOrder;//排序顺序
	@Size(min = 0, max = 50)
	private String sortType;//排序类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfCcmShlpId() {
		return this.ipfCcmShlpId;
	}
	
	public void setIpfCcmShlpId(String ipfCcmShlpId) {
		this.ipfCcmShlpId = ipfCcmShlpId;
	}
	public String getShlpName() {
		return this.shlpName;
	}
	
	public void setShlpName(String shlpName) {
		this.shlpName = shlpName;
	}
	public String getFieldName() {
		return this.fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldText() {
		return this.fieldText;
	}
	
	public void setFieldText(String fieldText) {
		this.fieldText = fieldText;
	}
	public String getListPosition() {
		return this.listPosition;
	}
	
	public void setListPosition(String listPosition) {
		this.listPosition = listPosition;
	}
	public String getIsVisible() {
		return this.isVisible;
	}
	
	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
	public String getIsInput() {
		return this.isInput;
	}
	
	public void setIsInput(String isInput) {
		this.isInput = isInput;
	}
	public String getIsOutput() {
		return this.isOutput;
	}
	
	public void setIsOutput(String isOutput) {
		this.isOutput = isOutput;
	}
	public String getDetailStatus() {
		return this.detailStatus;
	}
	
	public void setDetailStatus(String detailStatus) {
		this.detailStatus = detailStatus;
	}
	public String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDecimals() {
		return this.decimals;
	}
	
	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getColumnLength() {
		return this.columnLength;
	}
	
	public void setColumnLength(String columnLength) {
		this.columnLength = columnLength;
	}
	public String getConditionPosition() {
		return this.conditionPosition;
	}
	
	public void setConditionPosition(String conditionPosition) {
		this.conditionPosition = conditionPosition;
	}
	public String getOperation() {
		return this.operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getIsRollChange() {
		return this.isRollChange;
	}
	
	public void setIsRollChange(String isRollChange) {
		this.isRollChange = isRollChange;
	}
	public String getIsEditable() {
		return this.isEditable;
	}
	
	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}
	public String getDdtext() {
		return this.ddtext;
	}
	
	public void setDdtext(String ddtext) {
		this.ddtext = ddtext;
	}
	public String getIsSort() {
		return this.isSort;
	}
	
	public void setIsSort(String isSort) {
		this.isSort = isSort;
	}
	public String getSortOrder() {
		return this.sortOrder;
	}
	
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getSortType() {
		return this.sortType;
	}
	
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	public IpfCcmShlpDetailUpdateRequest(){}
	
	public IpfCcmShlpDetailUpdateRequest(IpfCcmShlpDetail ipfCcmShlpDetail){
		BeanUtils.copyProperties(ipfCcmShlpDetail,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmShlpDetail bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmShlpDetail cloneBO(){
		IpfCcmShlpDetail bo = new IpfCcmShlpDetail();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmShlpDetail> cloneBOList(List<IpfCcmShlpDetailUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmShlpDetail>(0);
		List<IpfCcmShlpDetail> result = new ArrayList<IpfCcmShlpDetail>(vos.size());
		for(IpfCcmShlpDetailUpdateRequest vo: vos){
			IpfCcmShlpDetail bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


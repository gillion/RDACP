/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmBoFormCell.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoFormCell.domain.IpfCcmBoFormCell;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoFormCellUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBoId;//业务对象
	@Size(min = 0, max = 50)
	private String formType;//界面类型
	@Size(min = 0, max = 20)
	private String isDefault;//默认FORM
	@Size(min = 0, max = 50)
	private String cellName;//栅格名称
	@Size(min = 0, max = 50)
	private String cellType;//栅格类型
	@Size(min = 0, max = 50)
	private String cellHeigh;//栅格高度
	@Size(min = 0, max = 20)
	private String isShowGroup;//显示分组
	@Size(min = 0, max = 50)
	private String groupWidget;//分组控件
	@Size(min = 0, max = 50)
	private String elementCode;//数据元素代码
	@Size(min = 0, max = 50)
	private String groupTitle;//分组标题
	@Size(min = 0, max = 50)
	private String unitCount;//包含栅格数
	@Size(min = 0, max = 20)
	private String isParent;//包含子栅格
	@Size(min = 0, max = 50)
	private String childrenLineCount;//子栅格行数
	@Size(min = 0, max = 50)
	private String parentCellName;//父栅格
	@Size(min = 0, max = 50)
	private String rowNo;//所属栅格行
	@Size(min = 0, max = 50)
	private String columnNo;//所属栅格列
	@Size(min = 0, max = 50)
	private String labelUnitCount;//标签占栅格数
	
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
	public String getFormType() {
		return this.formType;
	}
	
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getIsDefault() {
		return this.isDefault;
	}
	
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public String getCellName() {
		return this.cellName;
	}
	
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public String getCellType() {
		return this.cellType;
	}
	
	public void setCellType(String cellType) {
		this.cellType = cellType;
	}
	public String getCellHeigh() {
		return this.cellHeigh;
	}
	
	public void setCellHeigh(String cellHeigh) {
		this.cellHeigh = cellHeigh;
	}
	public String getIsShowGroup() {
		return this.isShowGroup;
	}
	
	public void setIsShowGroup(String isShowGroup) {
		this.isShowGroup = isShowGroup;
	}
	public String getGroupWidget() {
		return this.groupWidget;
	}
	
	public void setGroupWidget(String groupWidget) {
		this.groupWidget = groupWidget;
	}
	public String getElementCode() {
		return this.elementCode;
	}
	
	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}
	public String getGroupTitle() {
		return this.groupTitle;
	}
	
	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}
	public String getUnitCount() {
		return this.unitCount;
	}
	
	public void setUnitCount(String unitCount) {
		this.unitCount = unitCount;
	}
	public String getIsParent() {
		return this.isParent;
	}
	
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	public String getChildrenLineCount() {
		return this.childrenLineCount;
	}
	
	public void setChildrenLineCount(String childrenLineCount) {
		this.childrenLineCount = childrenLineCount;
	}
	public String getParentCellName() {
		return this.parentCellName;
	}
	
	public void setParentCellName(String parentCellName) {
		this.parentCellName = parentCellName;
	}
	public String getRowNo() {
		return this.rowNo;
	}
	
	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}
	public String getColumnNo() {
		return this.columnNo;
	}
	
	public void setColumnNo(String columnNo) {
		this.columnNo = columnNo;
	}
	public String getLabelUnitCount() {
		return this.labelUnitCount;
	}
	
	public void setLabelUnitCount(String labelUnitCount) {
		this.labelUnitCount = labelUnitCount;
	}
	
	public IpfCcmBoFormCellUpdateRequest(){}
	
	public IpfCcmBoFormCellUpdateRequest(IpfCcmBoFormCell ipfCcmBoFormCell){
		BeanUtils.copyProperties(ipfCcmBoFormCell,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoFormCell bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoFormCell cloneBO(){
		IpfCcmBoFormCell bo = new IpfCcmBoFormCell();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoFormCell> cloneBOList(List<IpfCcmBoFormCellUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoFormCell>(0);
		List<IpfCcmBoFormCell> result = new ArrayList<IpfCcmBoFormCell>(vos.size());
		for(IpfCcmBoFormCellUpdateRequest vo: vos){
			IpfCcmBoFormCell bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


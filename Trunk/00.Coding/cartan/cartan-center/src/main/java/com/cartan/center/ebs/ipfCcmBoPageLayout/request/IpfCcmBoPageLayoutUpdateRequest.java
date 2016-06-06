/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmBoPageLayout.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoPageLayout.domain.IpfCcmBoPageLayout;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoPageLayoutUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmBoPageId;//页面
	@Size(min = 0, max = 50)
	private String layoutType;//页面布局类型
	@Size(min = 0, max = 50)
	private String layoutContainerType;//页面布局容器类型
	@Size(min = 0, max = 50)
	private String layoutBoName;//页面布局业务对象名称
	@Size(min = 0, max = 50)
	private String styleClass;//样式名称
	@Size(min = 0, max = 50)
	private String style;//样式
	@Size(min = 0, max = 50)
	private String formType;//表单类型
	@Size(min = 0, max = 50)
	private String elementName;//布局元素名称
	@Size(min = 0, max = 50)
	private String height;//栅格高度
	@Size(min = 0, max = 50)
	private String isShowGroup;//显示分组
	@Size(min = 0, max = 50)
	private String groupWidget;//分组控件
	@Size(min = 0, max = 50)
	private String groupMsgCode;//分组标题系统消息代码
	@Size(min = 0, max = 50)
	private String groupTitle;//分组标题
	@Size(min = 0, max = 50)
	private String unitCount;//包含栅格数
	@Size(min = 0, max = 50)
	private String isParent;//是否父栅格
	@Size(min = 0, max = 50)
	private String childrenLineCount;//子栅格行数
	@Size(min = 0, max = 50)
	private String cellName;//栅格名称
	@Size(min = 0, max = 50)
	private String rowNo;//行号
	@Size(min = 0, max = 50)
	private String columnNo;//列号
	@Size(min = 0, max = 50)
	private String labelUnitCount;//标签占栅格数
	@Size(min = 0, max = 50)
	private String seqNo;//序号
	@Size(min = 0, max = 50)
	private String controlConnector;//连接符号
	@Size(min = 0, max = 50)
	private String parentCellName;//父栅格
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfCcmBoPageId() {
		return this.ipfCcmBoPageId;
	}
	
	public void setIpfCcmBoPageId(String ipfCcmBoPageId) {
		this.ipfCcmBoPageId = ipfCcmBoPageId;
	}
	public String getLayoutType() {
		return this.layoutType;
	}
	
	public void setLayoutType(String layoutType) {
		this.layoutType = layoutType;
	}
	public String getLayoutContainerType() {
		return this.layoutContainerType;
	}
	
	public void setLayoutContainerType(String layoutContainerType) {
		this.layoutContainerType = layoutContainerType;
	}
	public String getLayoutBoName() {
		return this.layoutBoName;
	}
	
	public void setLayoutBoName(String layoutBoName) {
		this.layoutBoName = layoutBoName;
	}
	public String getStyleClass() {
		return this.styleClass;
	}
	
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	public String getStyle() {
		return this.style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	public String getFormType() {
		return this.formType;
	}
	
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getElementName() {
		return this.elementName;
	}
	
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public String getHeight() {
		return this.height;
	}
	
	public void setHeight(String height) {
		this.height = height;
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
	public String getGroupMsgCode() {
		return this.groupMsgCode;
	}
	
	public void setGroupMsgCode(String groupMsgCode) {
		this.groupMsgCode = groupMsgCode;
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
	public String getCellName() {
		return this.cellName;
	}
	
	public void setCellName(String cellName) {
		this.cellName = cellName;
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
	public String getSeqNo() {
		return this.seqNo;
	}
	
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getControlConnector() {
		return this.controlConnector;
	}
	
	public void setControlConnector(String controlConnector) {
		this.controlConnector = controlConnector;
	}
	public String getParentCellName() {
		return this.parentCellName;
	}
	
	public void setParentCellName(String parentCellName) {
		this.parentCellName = parentCellName;
	}
	
	public IpfCcmBoPageLayoutUpdateRequest(){}
	
	public IpfCcmBoPageLayoutUpdateRequest(IpfCcmBoPageLayout ipfCcmBoPageLayout){
		BeanUtils.copyProperties(ipfCcmBoPageLayout,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoPageLayout bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoPageLayout cloneBO(){
		IpfCcmBoPageLayout bo = new IpfCcmBoPageLayout();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoPageLayout> cloneBOList(List<IpfCcmBoPageLayoutUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoPageLayout>(0);
		List<IpfCcmBoPageLayout> result = new ArrayList<IpfCcmBoPageLayout>(vos.size());
		for(IpfCcmBoPageLayoutUpdateRequest vo: vos){
			IpfCcmBoPageLayout bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


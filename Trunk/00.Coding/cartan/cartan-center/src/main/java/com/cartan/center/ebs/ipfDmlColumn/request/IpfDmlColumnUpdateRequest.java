/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfDmlColumn.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlColumn.domain.IpfDmlColumn;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlColumnUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfDmlTableId;//表名
	@Size(min = 0, max = 50)
	private String columnName;//字段名称
	@Size(min = 0, max = 50)
	private String ipfDmlElementId;//数据元素ID
	@Size(min = 0, max = 50)
	private String elementCode;//数据元素代码
	@Size(min = 0, max = 200)
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
	private String isPrimaryKey;//主键
	@Size(min = 0, max = 50)
	private String defaultValue;//默认值
	@Size(min = 0, max = 50)
	private String initValue;//初始值
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfDmlTableId() {
		return this.ipfDmlTableId;
	}
	
	public void setIpfDmlTableId(String ipfDmlTableId) {
		this.ipfDmlTableId = ipfDmlTableId;
	}
	public String getColumnName() {
		return this.columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getIpfDmlElementId() {
		return this.ipfDmlElementId;
	}
	
	public void setIpfDmlElementId(String ipfDmlElementId) {
		this.ipfDmlElementId = ipfDmlElementId;
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
	public String getIsPrimaryKey() {
		return this.isPrimaryKey;
	}
	
	public void setIsPrimaryKey(String isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getInitValue() {
		return this.initValue;
	}
	
	public void setInitValue(String initValue) {
		this.initValue = initValue;
	}
	
	public IpfDmlColumnUpdateRequest(){}
	
	public IpfDmlColumnUpdateRequest(IpfDmlColumn ipfDmlColumn){
		BeanUtils.copyProperties(ipfDmlColumn,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlColumn bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlColumn cloneBO(){
		IpfDmlColumn bo = new IpfDmlColumn();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlColumn> cloneBOList(List<IpfDmlColumnUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlColumn>(0);
		List<IpfDmlColumn> result = new ArrayList<IpfDmlColumn>(vos.size());
		for(IpfDmlColumnUpdateRequest vo: vos){
			IpfDmlColumn bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


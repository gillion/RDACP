/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlViewColumn.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlViewColumn.domain.IpfDmlViewColumn;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlViewColumnCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfDmlViewId;//视图
	@Size(min = 0, max = 50)
	private String columnName;//字段名称
	@Size(min = 0, max = 50)
	private String fieldText;//字段标题
	@Size(min = 0, max = 50)
	private String dataType;//数据类型
	@Size(min = 0, max = 50)
	private String fieldLength;//字段长度
	@Size(min = 0, max = 20)
	private String decimals;//小数位
	@Size(min = 0, max = 20)
	private String isNotNull;//非空
	@Size(min = 0, max = 20)
	private String isPrimaryKey;//主键
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfDmlViewId() {
		return this.ipfDmlViewId;
	}
	
	public void setIpfDmlViewId(String ipfDmlViewId) {
		this.ipfDmlViewId = ipfDmlViewId;
	}
	public String getColumnName() {
		return this.columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
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
	
	public IpfDmlViewColumnCreateRequest(){}
	
	public IpfDmlViewColumnCreateRequest(IpfDmlViewColumn ipfDmlViewColumn){
		BeanUtils.copyProperties(ipfDmlViewColumn,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlViewColumn bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlViewColumn cloneBO(){
		IpfDmlViewColumn bo = new IpfDmlViewColumn();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlViewColumn> cloneBOList(List<IpfDmlViewColumnCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlViewColumn>(0);
		List<IpfDmlViewColumn> result = new ArrayList<IpfDmlViewColumn>(vos.size());
		for(IpfDmlViewColumnCreateRequest vo: vos){
			IpfDmlViewColumn bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


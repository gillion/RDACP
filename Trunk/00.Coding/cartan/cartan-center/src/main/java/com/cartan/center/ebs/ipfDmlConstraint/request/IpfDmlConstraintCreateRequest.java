/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlConstraint.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlConstraint.domain.IpfDmlConstraint;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlConstraintCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfDmlTableId;//表名
	@Size(min = 0, max = 50)
	private String constraintName;//约束名称
	@Size(min = 0, max = 50)
	private String constraintType;//约束类型
	@Size(min = 0, max = 50)
	private String columnName;//字段名称
	@Size(min = 0, max = 50)
	private String foreignTableName;//外关联表名
	@Size(min = 0, max = 50)
	private String foreignColumnName;//外关联字段名
	
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
	public String getConstraintName() {
		return this.constraintName;
	}
	
	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
	}
	public String getConstraintType() {
		return this.constraintType;
	}
	
	public void setConstraintType(String constraintType) {
		this.constraintType = constraintType;
	}
	public String getColumnName() {
		return this.columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getForeignTableName() {
		return this.foreignTableName;
	}
	
	public void setForeignTableName(String foreignTableName) {
		this.foreignTableName = foreignTableName;
	}
	public String getForeignColumnName() {
		return this.foreignColumnName;
	}
	
	public void setForeignColumnName(String foreignColumnName) {
		this.foreignColumnName = foreignColumnName;
	}
	
	public IpfDmlConstraintCreateRequest(){}
	
	public IpfDmlConstraintCreateRequest(IpfDmlConstraint ipfDmlConstraint){
		BeanUtils.copyProperties(ipfDmlConstraint,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlConstraint bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlConstraint cloneBO(){
		IpfDmlConstraint bo = new IpfDmlConstraint();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlConstraint> cloneBOList(List<IpfDmlConstraintCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlConstraint>(0);
		List<IpfDmlConstraint> result = new ArrayList<IpfDmlConstraint>(vos.size());
		for(IpfDmlConstraintCreateRequest vo: vos){
			IpfDmlConstraint bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


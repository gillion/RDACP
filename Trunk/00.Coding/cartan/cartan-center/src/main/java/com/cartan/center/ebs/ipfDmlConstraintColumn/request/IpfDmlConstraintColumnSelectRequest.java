/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlConstraintColumn.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlConstraintColumn.domain.IpfDmlConstraintColumn;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlConstraintColumnSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfDmlConstraintId;//约束
	private String columnName;//字段名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfDmlConstraintId() {
		return this.ipfDmlConstraintId;
	}
	
	public void setIpfDmlConstraintId(String ipfDmlConstraintId) {
		this.ipfDmlConstraintId = ipfDmlConstraintId;
	}
	
	

	public String getColumnName() {
		return this.columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	
	
	public IpfDmlConstraintColumnSelectRequest(){}
	
	public IpfDmlConstraintColumnSelectRequest(IpfDmlConstraintColumn ipfDmlConstraintColumn){
		BeanUtils.copyProperties(ipfDmlConstraintColumn,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlConstraintColumn bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlConstraintColumn cloneBO(){
		IpfDmlConstraintColumn bo = new IpfDmlConstraintColumn();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlConstraintColumn> cloneBOList(List<IpfDmlConstraintColumnSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlConstraintColumn>(0);
		List<IpfDmlConstraintColumn> result = new ArrayList<IpfDmlConstraintColumn>(vos.size());
		for(IpfDmlConstraintColumnSelectRequest vo: vos){
			IpfDmlConstraintColumn bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


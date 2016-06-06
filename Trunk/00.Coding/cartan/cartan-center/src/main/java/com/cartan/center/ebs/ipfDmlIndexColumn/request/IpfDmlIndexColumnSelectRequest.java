/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlIndexColumn.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlIndexColumn.domain.IpfDmlIndexColumn;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlIndexColumnSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfDmlIndexId;//索引
	private String columnName;//字段名称
	private String indexOption;//索引选项
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfDmlIndexId() {
		return this.ipfDmlIndexId;
	}
	
	public void setIpfDmlIndexId(String ipfDmlIndexId) {
		this.ipfDmlIndexId = ipfDmlIndexId;
	}
	
	

	public String getColumnName() {
		return this.columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	

	public String getIndexOption() {
		return this.indexOption;
	}
	
	public void setIndexOption(String indexOption) {
		this.indexOption = indexOption;
	}
	
	
	
	public IpfDmlIndexColumnSelectRequest(){}
	
	public IpfDmlIndexColumnSelectRequest(IpfDmlIndexColumn ipfDmlIndexColumn){
		BeanUtils.copyProperties(ipfDmlIndexColumn,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlIndexColumn bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlIndexColumn cloneBO(){
		IpfDmlIndexColumn bo = new IpfDmlIndexColumn();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlIndexColumn> cloneBOList(List<IpfDmlIndexColumnSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlIndexColumn>(0);
		List<IpfDmlIndexColumn> result = new ArrayList<IpfDmlIndexColumn>(vos.size());
		for(IpfDmlIndexColumnSelectRequest vo: vos){
			IpfDmlIndexColumn bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


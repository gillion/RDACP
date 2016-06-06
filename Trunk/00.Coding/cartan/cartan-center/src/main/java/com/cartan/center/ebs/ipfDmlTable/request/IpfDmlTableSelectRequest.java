/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlTable.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlTable.domain.IpfDmlTable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlTableSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String tableName;//表名
	private String tableType;//表类型
	private String tableDesc;//表描述
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getTableName() {
		return this.tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	

	public String getTableType() {
		return this.tableType;
	}
	
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	
	

	public String getTableDesc() {
		return this.tableDesc;
	}
	
	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}
	
	
	
	public IpfDmlTableSelectRequest(){}
	
	public IpfDmlTableSelectRequest(IpfDmlTable ipfDmlTable){
		BeanUtils.copyProperties(ipfDmlTable,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlTable bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlTable cloneBO(){
		IpfDmlTable bo = new IpfDmlTable();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlTable> cloneBOList(List<IpfDmlTableSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlTable>(0);
		List<IpfDmlTable> result = new ArrayList<IpfDmlTable>(vos.size());
		for(IpfDmlTableSelectRequest vo: vos){
			IpfDmlTable bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


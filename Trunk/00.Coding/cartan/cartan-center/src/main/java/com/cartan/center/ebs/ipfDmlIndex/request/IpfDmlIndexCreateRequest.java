/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlIndex.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlIndex.domain.IpfDmlIndex;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlIndexCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfDmlTableId;//表名
	@Size(min = 0, max = 50)
	private String indexName;//索引名称
	@Size(min = 0, max = 50)
	private String indexType;//索引类型
	
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
	public String getIndexName() {
		return this.indexName;
	}
	
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getIndexType() {
		return this.indexType;
	}
	
	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}
	
	public IpfDmlIndexCreateRequest(){}
	
	public IpfDmlIndexCreateRequest(IpfDmlIndex ipfDmlIndex){
		BeanUtils.copyProperties(ipfDmlIndex,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlIndex bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlIndex cloneBO(){
		IpfDmlIndex bo = new IpfDmlIndex();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlIndex> cloneBOList(List<IpfDmlIndexCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlIndex>(0);
		List<IpfDmlIndex> result = new ArrayList<IpfDmlIndex>(vos.size());
		for(IpfDmlIndexCreateRequest vo: vos){
			IpfDmlIndex bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


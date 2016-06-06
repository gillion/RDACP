/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfFciRevision.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfFciRevision.domain.IpfFciRevision;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfFciRevisionSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfFciViewId;//视图
	private String ipfFciProjectId;//项目
	private String revisionNumber;//修订号
	private String remark;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfFciViewId() {
		return this.ipfFciViewId;
	}
	
	public void setIpfFciViewId(String ipfFciViewId) {
		this.ipfFciViewId = ipfFciViewId;
	}
	
	

	public String getIpfFciProjectId() {
		return this.ipfFciProjectId;
	}
	
	public void setIpfFciProjectId(String ipfFciProjectId) {
		this.ipfFciProjectId = ipfFciProjectId;
	}
	
	

	public String getRevisionNumber() {
		return this.revisionNumber;
	}
	
	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	
	

	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	public IpfFciRevisionSelectRequest(){}
	
	public IpfFciRevisionSelectRequest(IpfFciRevision ipfFciRevision){
		BeanUtils.copyProperties(ipfFciRevision,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfFciRevision bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfFciRevision cloneBO(){
		IpfFciRevision bo = new IpfFciRevision();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfFciRevision> cloneBOList(List<IpfFciRevisionSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfFciRevision>(0);
		List<IpfFciRevision> result = new ArrayList<IpfFciRevision>(vos.size());
		for(IpfFciRevisionSelectRequest vo: vos){
			IpfFciRevision bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


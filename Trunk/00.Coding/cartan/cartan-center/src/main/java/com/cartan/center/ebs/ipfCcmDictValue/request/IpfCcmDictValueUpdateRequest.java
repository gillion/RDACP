/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmDictValue.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmDictValue.domain.IpfCcmDictValue;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmDictValueUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfCcmDictId;//业务对象
	@Size(min = 0, max = 50)
	private String codeValue;//代码值
	@Size(min = 0, max = 50)
	private String displayValue;//显示值
	@Size(min = 0, max = 50)
	private String seqNo;//顺序号
	@Size(min = 0, max = 50)
	private String groupValue;//分组值
	@Size(min = 0, max = 1000)
	private String remark;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfCcmDictId() {
		return this.ipfCcmDictId;
	}
	
	public void setIpfCcmDictId(String ipfCcmDictId) {
		this.ipfCcmDictId = ipfCcmDictId;
	}
	public String getCodeValue() {
		return this.codeValue;
	}
	
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getDisplayValue() {
		return this.displayValue;
	}
	
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	public String getSeqNo() {
		return this.seqNo;
	}
	
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getGroupValue() {
		return this.groupValue;
	}
	
	public void setGroupValue(String groupValue) {
		this.groupValue = groupValue;
	}
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public IpfCcmDictValueUpdateRequest(){}
	
	public IpfCcmDictValueUpdateRequest(IpfCcmDictValue ipfCcmDictValue){
		BeanUtils.copyProperties(ipfCcmDictValue,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmDictValue bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmDictValue cloneBO(){
		IpfCcmDictValue bo = new IpfCcmDictValue();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmDictValue> cloneBOList(List<IpfCcmDictValueUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmDictValue>(0);
		List<IpfCcmDictValue> result = new ArrayList<IpfCcmDictValue>(vos.size());
		for(IpfCcmDictValueUpdateRequest vo: vos){
			IpfCcmDictValue bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


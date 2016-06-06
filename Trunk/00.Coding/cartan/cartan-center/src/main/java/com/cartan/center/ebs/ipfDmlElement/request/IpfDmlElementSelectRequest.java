/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfDmlElement.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlElement.domain.IpfDmlElement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlElementSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String elementCode;//数据元素代码
	private String fieldText;//显示文本
	private String dataType;//数据类型
	private String fieldLength;//字段长度
	private String decimals;//小数位
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	
	
	public IpfDmlElementSelectRequest(){}
	
	public IpfDmlElementSelectRequest(IpfDmlElement ipfDmlElement){
		BeanUtils.copyProperties(ipfDmlElement,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlElement bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlElement cloneBO(){
		IpfDmlElement bo = new IpfDmlElement();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlElement> cloneBOList(List<IpfDmlElementSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlElement>(0);
		List<IpfDmlElement> result = new ArrayList<IpfDmlElement>(vos.size());
		for(IpfDmlElementSelectRequest vo: vos){
			IpfDmlElement bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


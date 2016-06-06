/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoControlEvent.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBoControlEvent.domain.IpfCcmBoControlEvent;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoControlEventSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String ipfCcbBoFormColumnId;//编辑页
	private String eventType;//事件类型
	private String execType;//执行类型
	private String execContent;//执行类型
	private String callBack;//回调JS
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getIpfCcbBoFormColumnId() {
		return this.ipfCcbBoFormColumnId;
	}
	
	public void setIpfCcbBoFormColumnId(String ipfCcbBoFormColumnId) {
		this.ipfCcbBoFormColumnId = ipfCcbBoFormColumnId;
	}
	
	

	public String getEventType() {
		return this.eventType;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	

	public String getExecType() {
		return this.execType;
	}
	
	public void setExecType(String execType) {
		this.execType = execType;
	}
	
	

	public String getExecContent() {
		return this.execContent;
	}
	
	public void setExecContent(String execContent) {
		this.execContent = execContent;
	}
	
	

	public String getCallBack() {
		return this.callBack;
	}
	
	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}
	
	
	
	public IpfCcmBoControlEventSelectRequest(){}
	
	public IpfCcmBoControlEventSelectRequest(IpfCcmBoControlEvent ipfCcmBoControlEvent){
		BeanUtils.copyProperties(ipfCcmBoControlEvent,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBoControlEvent bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBoControlEvent cloneBO(){
		IpfCcmBoControlEvent bo = new IpfCcmBoControlEvent();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBoControlEvent> cloneBOList(List<IpfCcmBoControlEventSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBoControlEvent>(0);
		List<IpfCcmBoControlEvent> result = new ArrayList<IpfCcmBoControlEvent>(vos.size());
		for(IpfCcmBoControlEventSelectRequest vo: vos){
			IpfCcmBoControlEvent bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfDmlScriptPublish.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfDmlScriptPublish.domain.IpfDmlScriptPublish;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfDmlScriptPublishUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String fileName;//文件名称
	@Size(min = 0, max = 50)
	private String fileDes;//文件描述
	@Size(min = 0, max = 2000)
	private String fileContent;//文件内容
	@Size(min = 0, max = 20)
	private String isPublished;//已发布
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getFileName() {
		return this.fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDes() {
		return this.fileDes;
	}
	
	public void setFileDes(String fileDes) {
		this.fileDes = fileDes;
	}
	public String getFileContent() {
		return this.fileContent;
	}
	
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public String getIsPublished() {
		return this.isPublished;
	}
	
	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}
	
	public IpfDmlScriptPublishUpdateRequest(){}
	
	public IpfDmlScriptPublishUpdateRequest(IpfDmlScriptPublish ipfDmlScriptPublish){
		BeanUtils.copyProperties(ipfDmlScriptPublish,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfDmlScriptPublish bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfDmlScriptPublish cloneBO(){
		IpfDmlScriptPublish bo = new IpfDmlScriptPublish();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfDmlScriptPublish> cloneBOList(List<IpfDmlScriptPublishUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfDmlScriptPublish>(0);
		List<IpfDmlScriptPublish> result = new ArrayList<IpfDmlScriptPublish>(vos.size());
		for(IpfDmlScriptPublishUpdateRequest vo: vos){
			IpfDmlScriptPublish bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


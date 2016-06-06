package com.cartan.core.ipfDmlScriptPublish.domain;
import java.io.Serializable;


/**
 * IpfDmlScriptPublish
 */
public class IpfDmlScriptPublish implements Serializable{
	private String ID;//主键
	private String FILE_NAME;//文件名称
	private String FILE_DES;//文件描述
	private String FILE_CONTENT;//文件内容
	private String IS_PUBLISHED;//已发布
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getFileName() {
		return this.FILE_NAME;
	}
	
	public void setFileName(String value) {
		this.FILE_NAME = value;
	}
	

	public String getFileDes() {
		return this.FILE_DES;
	}
	
	public void setFileDes(String value) {
		this.FILE_DES = value;
	}
	

	public String getFileContent() {
		return this.FILE_CONTENT;
	}
	
	public void setFileContent(String value) {
		this.FILE_CONTENT = value;
	}
	

	public String getIsPublished() {
		return this.IS_PUBLISHED;
	}
	
	public void setIsPublished(String value) {
		this.IS_PUBLISHED = value;
	}
	

}

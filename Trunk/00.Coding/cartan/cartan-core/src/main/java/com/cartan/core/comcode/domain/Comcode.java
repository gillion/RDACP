package com.cartan.core.comcode.domain;
import java.io.Serializable;


/**
 * 常用代码
 */
public class Comcode implements Serializable{
	private String ID;//代码编号
	private String TYPECODE;//代码类别
	private String CODE;//常用代码
	private String NAME;//中文名称
	private String SHORTNAME;//缩写简称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getTypecode() {
		return this.TYPECODE;
	}
	
	public void setTypecode(String value) {
		this.TYPECODE = value;
	}
	

	public String getCode() {
		return this.CODE;
	}
	
	public void setCode(String value) {
		this.CODE = value;
	}
	

	public String getName() {
		return this.NAME;
	}
	
	public void setName(String value) {
		this.NAME = value;
	}
	

	public String getShortname() {
		return this.SHORTNAME;
	}
	
	public void setShortname(String value) {
		this.SHORTNAME = value;
	}
	

}

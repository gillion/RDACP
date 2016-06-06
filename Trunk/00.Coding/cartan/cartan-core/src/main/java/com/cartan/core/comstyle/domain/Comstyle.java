package com.cartan.core.comstyle.domain;
import java.io.Serializable;


/**
 * 代码类别
 */
public class Comstyle implements Serializable{
	private String ID;//类别编号
	private String CODE;//类别代码
	private String NAME;//类别名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
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
	

}

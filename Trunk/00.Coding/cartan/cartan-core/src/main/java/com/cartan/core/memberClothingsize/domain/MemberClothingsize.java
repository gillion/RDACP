package com.cartan.core.memberClothingsize.domain;
import java.io.Serializable;


/**
 * MemberClothingsize
 */
public class MemberClothingsize implements Serializable{
	private String id;//编号
	private String name;//姓名
	private String depart;//部门
	private String height;//身高
	private String weight;//体重
	private String clothingSize;//尺码
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String Id) {
		this.id = Id;
	}
	

	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	

	public String getDepart() {
		return this.depart;
	}
	
	public void setDepart(String value) {
		this.depart = value;
	}
	

	public String getHeight() {
		return this.height;
	}
	
	public void setHeight(String value) {
		this.height = value;
	}
	

	public String getWeight() {
		return this.weight;
	}
	
	public void setWeight(String value) {
		this.weight = value;
	}
	

	public String getClothingSize() {
		return this.clothingSize;
	}
	
	public void setClothingSize(String value) {
		this.clothingSize = value;
	}
	

}

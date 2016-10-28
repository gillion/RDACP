package com.cartan.core.sectionPartitionVar.domain;
import java.io.Serializable;


/**
 * 分段细分变量
 */
public class SectionPartitionVar implements Serializable{
	private String ID;//主键
	private String SECTION_PARITION_ID;//分段细分模型
	private String VAR_NAME;//变量名称
	private String SECTION_LOWER_MARK;//区间下限符号
	private String SECTION_LOWER_LIMIT;//区间下限
	private String SECTION_UPPER_MARK;//区间上限符号
	private String SECTION_UPPER_LIMIT;//区间上限
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getSectionParitionId() {
		return this.SECTION_PARITION_ID;
	}
	
	public void setSectionParitionId(String value) {
		this.SECTION_PARITION_ID = value;
	}
	

	public String getVarName() {
		return this.VAR_NAME;
	}
	
	public void setVarName(String value) {
		this.VAR_NAME = value;
	}
	

	public String getSectionLowerMark() {
		return this.SECTION_LOWER_MARK;
	}
	
	public void setSectionLowerMark(String value) {
		this.SECTION_LOWER_MARK = value;
	}
	

	public String getSectionLowerLimit() {
		return this.SECTION_LOWER_LIMIT;
	}
	
	public void setSectionLowerLimit(String value) {
		this.SECTION_LOWER_LIMIT = value;
	}
	

	public String getSectionUpperMark() {
		return this.SECTION_UPPER_MARK;
	}
	
	public void setSectionUpperMark(String value) {
		this.SECTION_UPPER_MARK = value;
	}
	

	public String getSectionUpperLimit() {
		return this.SECTION_UPPER_LIMIT;
	}
	
	public void setSectionUpperLimit(String value) {
		this.SECTION_UPPER_LIMIT = value;
	}
	

}

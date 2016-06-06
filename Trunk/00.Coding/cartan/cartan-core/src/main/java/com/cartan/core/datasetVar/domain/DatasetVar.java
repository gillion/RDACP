package com.cartan.core.datasetVar.domain;
import java.io.Serializable;


/**
 * 数据集变量
 */
public class DatasetVar implements Serializable{
	private String ID;//主键
	private String DATASET_ID;//数据集
	private String VAR_NAME;//变量名称
	private String VAR_DES;//变量中文名称
	private String IS_DERIVED;//是否衍生
	private String IS_SET;//是否集合
	private String VAR_TYPE;//变量类型
	private String SPAN_BEGIN;//约束取值范围开始
	private String SPAN_END;//约束取值范围结束
	private String IS_OUTPUT;//是否输出
	private String DEF_VALUE;//缺省值
	private String REMARK;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getDatasetId() {
		return this.DATASET_ID;
	}
	
	public void setDatasetId(String value) {
		this.DATASET_ID = value;
	}
	

	public String getVarName() {
		return this.VAR_NAME;
	}
	
	public void setVarName(String value) {
		this.VAR_NAME = value;
	}
	

	public String getVarDes() {
		return this.VAR_DES;
	}
	
	public void setVarDes(String value) {
		this.VAR_DES = value;
	}
	

	public String getIsDerived() {
		return this.IS_DERIVED;
	}
	
	public void setIsDerived(String value) {
		this.IS_DERIVED = value;
	}
	

	public String getIsSet() {
		return this.IS_SET;
	}
	
	public void setIsSet(String value) {
		this.IS_SET = value;
	}
	

	public String getVarType() {
		return this.VAR_TYPE;
	}
	
	public void setVarType(String value) {
		this.VAR_TYPE = value;
	}
	

	public String getSpanBegin() {
		return this.SPAN_BEGIN;
	}
	
	public void setSpanBegin(String value) {
		this.SPAN_BEGIN = value;
	}
	

	public String getSpanEnd() {
		return this.SPAN_END;
	}
	
	public void setSpanEnd(String value) {
		this.SPAN_END = value;
	}
	

	public String getIsOutput() {
		return this.IS_OUTPUT;
	}
	
	public void setIsOutput(String value) {
		this.IS_OUTPUT = value;
	}
	

	public String getDefValue() {
		return this.DEF_VALUE;
	}
	
	public void setDefValue(String value) {
		this.DEF_VALUE = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

}

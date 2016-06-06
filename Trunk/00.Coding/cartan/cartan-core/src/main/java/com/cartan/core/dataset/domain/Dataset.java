package com.cartan.core.dataset.domain;
import java.io.Serializable;


/**
 * 数据集
 */
public class Dataset implements Serializable{
	private String ID;//主键
	private String DATASET_NAME;//数据集名称
	private String DATASET_DES;//数据集中文名称
	private String DATASET_TYPE;//类型
	private String REMARK;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getDatasetName() {
		return this.DATASET_NAME;
	}
	
	public void setDatasetName(String value) {
		this.DATASET_NAME = value;
	}
	

	public String getDatasetDes() {
		return this.DATASET_DES;
	}
	
	public void setDatasetDes(String value) {
		this.DATASET_DES = value;
	}
	

	public String getDatasetType() {
		return this.DATASET_TYPE;
	}
	
	public void setDatasetType(String value) {
		this.DATASET_TYPE = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

}

package com.cartan.core.ipfCcmDict.domain;
import java.io.Serializable;


/**
 * IpfCcmDict
 */
public class IpfCcmDict implements Serializable{
	private String ID;//主键
	private String DICT_CODE;//字典代码
	private String DICT_NAME;//字典名称
	private String DICT_TYPE;//字典类型
	private String CODE_COLUMN;//字典代码字段
	private String NAME_COLUMN;//字典名称字段
	private String KEY_COLUMN;//字典ID字段
	private String TABLE_NAME;//字典表名
	private String IS_GROUP;//是否分组
	private String GROUP_COLUMN;//分组字段
	private String REMARK;//备注
	private String ORDER_COLUMN;//排序字段
	private String IS_SYSTEM;//是否系统
	private String DATA_TYPE;//数据类型
	private String FIELD_LENGTH;//字段长度
	private String DECIMALS;//小数位
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getDictCode() {
		return this.DICT_CODE;
	}
	
	public void setDictCode(String value) {
		this.DICT_CODE = value;
	}
	

	public String getDictName() {
		return this.DICT_NAME;
	}
	
	public void setDictName(String value) {
		this.DICT_NAME = value;
	}
	

	public String getDictType() {
		return this.DICT_TYPE;
	}
	
	public void setDictType(String value) {
		this.DICT_TYPE = value;
	}
	

	public String getCodeColumn() {
		return this.CODE_COLUMN;
	}
	
	public void setCodeColumn(String value) {
		this.CODE_COLUMN = value;
	}
	

	public String getNameColumn() {
		return this.NAME_COLUMN;
	}
	
	public void setNameColumn(String value) {
		this.NAME_COLUMN = value;
	}
	

	public String getKeyColumn() {
		return this.KEY_COLUMN;
	}
	
	public void setKeyColumn(String value) {
		this.KEY_COLUMN = value;
	}
	

	public String getTableName() {
		return this.TABLE_NAME;
	}
	
	public void setTableName(String value) {
		this.TABLE_NAME = value;
	}
	

	public String getIsGroup() {
		return this.IS_GROUP;
	}
	
	public void setIsGroup(String value) {
		this.IS_GROUP = value;
	}
	

	public String getGroupColumn() {
		return this.GROUP_COLUMN;
	}
	
	public void setGroupColumn(String value) {
		this.GROUP_COLUMN = value;
	}
	

	public String getRemark() {
		return this.REMARK;
	}
	
	public void setRemark(String value) {
		this.REMARK = value;
	}
	

	public String getOrderColumn() {
		return this.ORDER_COLUMN;
	}
	
	public void setOrderColumn(String value) {
		this.ORDER_COLUMN = value;
	}
	

	public String getIsSystem() {
		return this.IS_SYSTEM;
	}
	
	public void setIsSystem(String value) {
		this.IS_SYSTEM = value;
	}
	

	public String getDataType() {
		return this.DATA_TYPE;
	}
	
	public void setDataType(String value) {
		this.DATA_TYPE = value;
	}
	

	public String getFieldLength() {
		return this.FIELD_LENGTH;
	}
	
	public void setFieldLength(String value) {
		this.FIELD_LENGTH = value;
	}
	

	public String getDecimals() {
		return this.DECIMALS;
	}
	
	public void setDecimals(String value) {
		this.DECIMALS = value;
	}
	

}

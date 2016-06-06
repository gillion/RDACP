package com.cartan.core.ipfRtmConfigAttr.domain;
import java.io.Serializable;


/**
 * IpfRtmConfigAttr
 */
public class IpfRtmConfigAttr implements Serializable{
	private String ID;//主键
	private String IPF_RTM_CONFIG_ID;//运行期配置
	private String SEQ_NO;//序号
	private String DISPLAY_LABEL;//显示名称
	private String DATA_TYPE;//数据类型
	private String UI_TYPE;//UI组件类型
	private String DICT_TABLE_NAME;//字典表编码
	private String DICT_GROUP_VALUE;//字典表分组名
	private String SEARCH_HELP;//搜索帮助名
	private String SH_VALUE_COLUMN;//搜索帮助值字段
	private String SH_DISPLAY_COLUMN;//搜索帮助文本字段
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getIpfRtmConfigId() {
		return this.IPF_RTM_CONFIG_ID;
	}
	
	public void setIpfRtmConfigId(String value) {
		this.IPF_RTM_CONFIG_ID = value;
	}
	

	public String getSeqNo() {
		return this.SEQ_NO;
	}
	
	public void setSeqNo(String value) {
		this.SEQ_NO = value;
	}
	

	public String getDisplayLabel() {
		return this.DISPLAY_LABEL;
	}
	
	public void setDisplayLabel(String value) {
		this.DISPLAY_LABEL = value;
	}
	

	public String getDataType() {
		return this.DATA_TYPE;
	}
	
	public void setDataType(String value) {
		this.DATA_TYPE = value;
	}
	

	public String getUiType() {
		return this.UI_TYPE;
	}
	
	public void setUiType(String value) {
		this.UI_TYPE = value;
	}
	

	public String getDictTableName() {
		return this.DICT_TABLE_NAME;
	}
	
	public void setDictTableName(String value) {
		this.DICT_TABLE_NAME = value;
	}
	

	public String getDictGroupValue() {
		return this.DICT_GROUP_VALUE;
	}
	
	public void setDictGroupValue(String value) {
		this.DICT_GROUP_VALUE = value;
	}
	

	public String getSearchHelp() {
		return this.SEARCH_HELP;
	}
	
	public void setSearchHelp(String value) {
		this.SEARCH_HELP = value;
	}
	

	public String getShValueColumn() {
		return this.SH_VALUE_COLUMN;
	}
	
	public void setShValueColumn(String value) {
		this.SH_VALUE_COLUMN = value;
	}
	

	public String getShDisplayColumn() {
		return this.SH_DISPLAY_COLUMN;
	}
	
	public void setShDisplayColumn(String value) {
		this.SH_DISPLAY_COLUMN = value;
	}
	

}

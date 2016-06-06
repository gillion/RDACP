/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmDict.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmDict.domain.IpfCcmDict;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmDictCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String dictCode;//字典代码
	@Size(min = 0, max = 50)
	private String dictName;//字典名称
	@Size(min = 0, max = 50)
	private String dictType;//字典类型
	@Size(min = 0, max = 50)
	private String codeColumn;//字典代码字段
	@Size(min = 0, max = 50)
	private String nameColumn;//字典名称字段
	@Size(min = 0, max = 50)
	private String keyColumn;//字典ID字段
	@Size(min = 0, max = 50)
	private String tableName;//字典表名
	@Size(min = 0, max = 20)
	private String isGroup;//是否分组
	@Size(min = 0, max = 50)
	private String groupColumn;//分组字段
	@Size(min = 0, max = 1000)
	private String remark;//备注
	@Size(min = 0, max = 50)
	private String orderColumn;//排序字段
	@Size(min = 0, max = 20)
	private String isSystem;//是否系统
	@Size(min = 0, max = 50)
	private String dataType;//数据类型
	@Size(min = 0, max = 50)
	private String fieldLength;//字段长度
	@Size(min = 0, max = 50)
	private String decimals;//小数位
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getDictCode() {
		return this.dictCode;
	}
	
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	public String getDictName() {
		return this.dictName;
	}
	
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public String getDictType() {
		return this.dictType;
	}
	
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	public String getCodeColumn() {
		return this.codeColumn;
	}
	
	public void setCodeColumn(String codeColumn) {
		this.codeColumn = codeColumn;
	}
	public String getNameColumn() {
		return this.nameColumn;
	}
	
	public void setNameColumn(String nameColumn) {
		this.nameColumn = nameColumn;
	}
	public String getKeyColumn() {
		return this.keyColumn;
	}
	
	public void setKeyColumn(String keyColumn) {
		this.keyColumn = keyColumn;
	}
	public String getTableName() {
		return this.tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getIsGroup() {
		return this.isGroup;
	}
	
	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}
	public String getGroupColumn() {
		return this.groupColumn;
	}
	
	public void setGroupColumn(String groupColumn) {
		this.groupColumn = groupColumn;
	}
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOrderColumn() {
		return this.orderColumn;
	}
	
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public String getIsSystem() {
		return this.isSystem;
	}
	
	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}
	public String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getFieldLength() {
		return this.fieldLength;
	}
	
	public void setFieldLength(String fieldLength) {
		this.fieldLength = fieldLength;
	}
	public String getDecimals() {
		return this.decimals;
	}
	
	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}
	
	public IpfCcmDictCreateRequest(){}
	
	public IpfCcmDictCreateRequest(IpfCcmDict ipfCcmDict){
		BeanUtils.copyProperties(ipfCcmDict,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmDict bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmDict cloneBO(){
		IpfCcmDict bo = new IpfCcmDict();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmDict> cloneBOList(List<IpfCcmDictCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmDict>(0);
		List<IpfCcmDict> result = new ArrayList<IpfCcmDict>(vos.size());
		for(IpfCcmDictCreateRequest vo: vos){
			IpfCcmDict bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


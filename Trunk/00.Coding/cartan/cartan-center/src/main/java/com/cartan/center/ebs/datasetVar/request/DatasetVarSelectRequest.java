/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.datasetVar.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.datasetVar.domain.DatasetVar;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class DatasetVarSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String datasetId;//数据集
	private String varName;//变量
	private String varDes;//变量描述
	private String isDerived;//是否衍生
	private String isSet;//是否集合
	private String varType;//变量类型
	private String spanBegin;//取值起始
	private String spanEnd;//取值结束
	private String isOutput;//是否输出
	private String defValue;//缺省值
	private String remark;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getDatasetId() {
		return this.datasetId;
	}
	
	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}
	
	

	public String getVarName() {
		return this.varName;
	}
	
	public void setVarName(String varName) {
		this.varName = varName;
	}
	
	

	public String getVarDes() {
		return this.varDes;
	}
	
	public void setVarDes(String varDes) {
		this.varDes = varDes;
	}
	
	

	public String getIsDerived() {
		return this.isDerived;
	}
	
	public void setIsDerived(String isDerived) {
		this.isDerived = isDerived;
	}
	
	

	public String getIsSet() {
		return this.isSet;
	}
	
	public void setIsSet(String isSet) {
		this.isSet = isSet;
	}
	
	

	public String getVarType() {
		return this.varType;
	}
	
	public void setVarType(String varType) {
		this.varType = varType;
	}
	
	

	public String getSpanBegin() {
		return this.spanBegin;
	}
	
	public void setSpanBegin(String spanBegin) {
		this.spanBegin = spanBegin;
	}
	
	

	public String getSpanEnd() {
		return this.spanEnd;
	}
	
	public void setSpanEnd(String spanEnd) {
		this.spanEnd = spanEnd;
	}
	
	

	public String getIsOutput() {
		return this.isOutput;
	}
	
	public void setIsOutput(String isOutput) {
		this.isOutput = isOutput;
	}
	
	

	public String getDefValue() {
		return this.defValue;
	}
	
	public void setDefValue(String defValue) {
		this.defValue = defValue;
	}
	
	

	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	public DatasetVarSelectRequest(){}
	
	public DatasetVarSelectRequest(DatasetVar datasetVar){
		BeanUtils.copyProperties(datasetVar,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(DatasetVar bo){
		BeanUtils.copyProperties(this,bo);
	}
	public DatasetVar cloneBO(){
		DatasetVar bo = new DatasetVar();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<DatasetVar> cloneBOList(List<DatasetVarSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<DatasetVar>(0);
		List<DatasetVar> result = new ArrayList<DatasetVar>(vos.size());
		for(DatasetVarSelectRequest vo: vos){
			DatasetVar bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


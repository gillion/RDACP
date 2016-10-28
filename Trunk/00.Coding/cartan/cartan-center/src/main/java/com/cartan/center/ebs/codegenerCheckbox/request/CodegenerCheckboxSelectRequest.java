/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegenerCheckbox.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.codegenerCheckbox.domain.CodegenerCheckbox;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class CodegenerCheckboxSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String setupId;//基本配置
	private String tableId;//关联模型
	private String checkboxField;//复选字段
	private String codeType;//代码类型
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getSetupId() {
		return this.setupId;
	}
	
	public void setSetupId(String setupId) {
		this.setupId = setupId;
	}
	
	

	public String getTableId() {
		return this.tableId;
	}
	
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	
	

	public String getCheckboxField() {
		return this.checkboxField;
	}
	
	public void setCheckboxField(String checkboxField) {
		this.checkboxField = checkboxField;
	}
	
	

	public String getCodeType() {
		return this.codeType;
	}
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	
	
	public CodegenerCheckboxSelectRequest(){}
	
	public CodegenerCheckboxSelectRequest(CodegenerCheckbox codegenerCheckbox){
		BeanUtils.copyProperties(codegenerCheckbox,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(CodegenerCheckbox bo){
		BeanUtils.copyProperties(this,bo);
	}
	public CodegenerCheckbox cloneBO(){
		CodegenerCheckbox bo = new CodegenerCheckbox();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<CodegenerCheckbox> cloneBOList(List<CodegenerCheckboxSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<CodegenerCheckbox>(0);
		List<CodegenerCheckbox> result = new ArrayList<CodegenerCheckbox>(vos.size());
		for(CodegenerCheckboxSelectRequest vo: vos){
			CodegenerCheckbox bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


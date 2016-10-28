/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.codegenerCombobox.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.codegenerCombobox.domain.CodegenerCombobox;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class CodegenerComboboxUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String setupId;//基本配置
	@Size(min = 0, max = 50)
	private String tableId;//关联模型
	@Size(min = 0, max = 50)
	private String comboboxField;//下拉字段
	@Size(min = 0, max = 50)
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
	public String getComboboxField() {
		return this.comboboxField;
	}
	
	public void setComboboxField(String comboboxField) {
		this.comboboxField = comboboxField;
	}
	public String getCodeType() {
		return this.codeType;
	}
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	public CodegenerComboboxUpdateRequest(){}
	
	public CodegenerComboboxUpdateRequest(CodegenerCombobox codegenerCombobox){
		BeanUtils.copyProperties(codegenerCombobox,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(CodegenerCombobox bo){
		BeanUtils.copyProperties(this,bo);
	}
	public CodegenerCombobox cloneBO(){
		CodegenerCombobox bo = new CodegenerCombobox();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<CodegenerCombobox> cloneBOList(List<CodegenerComboboxUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<CodegenerCombobox>(0);
		List<CodegenerCombobox> result = new ArrayList<CodegenerCombobox>(vos.size());
		for(CodegenerComboboxUpdateRequest vo: vos){
			CodegenerCombobox bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


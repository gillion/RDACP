/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegenerRadio.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.codegenerRadio.domain.CodegenerRadio;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class CodegenerRadioCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String setupId;//基本配置
	@Size(min = 0, max = 50)
	private String tableId;//关联模型
	@Size(min = 0, max = 50)
	private String radioField;//单选字段
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
	public String getRadioField() {
		return this.radioField;
	}
	
	public void setRadioField(String radioField) {
		this.radioField = radioField;
	}
	public String getCodeType() {
		return this.codeType;
	}
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	public CodegenerRadioCreateRequest(){}
	
	public CodegenerRadioCreateRequest(CodegenerRadio codegenerRadio){
		BeanUtils.copyProperties(codegenerRadio,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(CodegenerRadio bo){
		BeanUtils.copyProperties(this,bo);
	}
	public CodegenerRadio cloneBO(){
		CodegenerRadio bo = new CodegenerRadio();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<CodegenerRadio> cloneBOList(List<CodegenerRadioCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<CodegenerRadio>(0);
		List<CodegenerRadio> result = new ArrayList<CodegenerRadio>(vos.size());
		for(CodegenerRadioCreateRequest vo: vos){
			CodegenerRadio bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.codegenerSelect.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.codegenerSelect.domain.CodegenerSelect;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class CodegenerSelectCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String setupId;//基本配置
	@Size(min = 0, max = 50)
	private String tableId;//关联模型
	@Size(min = 0, max = 50)
	private String selectField;//弹出字段
	@Size(min = 0, max = 50)
	private String selectTable;//取数模型
	@Size(min = 0, max = 50)
	private String selectDes;//描述字段
	
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
	public String getSelectField() {
		return this.selectField;
	}
	
	public void setSelectField(String selectField) {
		this.selectField = selectField;
	}
	public String getSelectTable() {
		return this.selectTable;
	}
	
	public void setSelectTable(String selectTable) {
		this.selectTable = selectTable;
	}
	public String getSelectDes() {
		return this.selectDes;
	}
	
	public void setSelectDes(String selectDes) {
		this.selectDes = selectDes;
	}
	
	public CodegenerSelectCreateRequest(){}
	
	public CodegenerSelectCreateRequest(CodegenerSelect codegenerSelect){
		BeanUtils.copyProperties(codegenerSelect,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(CodegenerSelect bo){
		BeanUtils.copyProperties(this,bo);
	}
	public CodegenerSelect cloneBO(){
		CodegenerSelect bo = new CodegenerSelect();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<CodegenerSelect> cloneBOList(List<CodegenerSelectCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<CodegenerSelect>(0);
		List<CodegenerSelect> result = new ArrayList<CodegenerSelect>(vos.size());
		for(CodegenerSelectCreateRequest vo: vos){
			CodegenerSelect bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


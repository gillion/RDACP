/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.codegenerTable.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.codegenerTable.domain.CodegenerTable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class CodegenerTableUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String setupId;//配置名称
	@Size(min = 0, max = 200)
	private String tableName;//表名
	@Size(min = 0, max = 200)
	private String tableDes;//中文描述
	@Size(min = 0, max = 200)
	private String parentTableName;//继承表名
	@Size(min = 0, max = 3)
	private String noParent;//无公共字段
	@Size(min = 0, max = 3)
	private String isNewBsclass;//是否新建业务类
	@Size(min = 0, max = 50)
	private String pageSize;//编辑列数
	
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
	public String getTableName() {
		return this.tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableDes() {
		return this.tableDes;
	}
	
	public void setTableDes(String tableDes) {
		this.tableDes = tableDes;
	}
	public String getParentTableName() {
		return this.parentTableName;
	}
	
	public void setParentTableName(String parentTableName) {
		this.parentTableName = parentTableName;
	}
	public String getNoParent() {
		return this.noParent;
	}
	
	public void setNoParent(String noParent) {
		this.noParent = noParent;
	}
	public String getIsNewBsclass() {
		return this.isNewBsclass;
	}
	
	public void setIsNewBsclass(String isNewBsclass) {
		this.isNewBsclass = isNewBsclass;
	}
	public String getPageSize() {
		return this.pageSize;
	}
	
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	public CodegenerTableUpdateRequest(){}
	
	public CodegenerTableUpdateRequest(CodegenerTable codegenerTable){
		BeanUtils.copyProperties(codegenerTable,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(CodegenerTable bo){
		BeanUtils.copyProperties(this,bo);
	}
	public CodegenerTable cloneBO(){
		CodegenerTable bo = new CodegenerTable();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<CodegenerTable> cloneBOList(List<CodegenerTableUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<CodegenerTable>(0);
		List<CodegenerTable> result = new ArrayList<CodegenerTable>(vos.size());
		for(CodegenerTableUpdateRequest vo: vos){
			CodegenerTable bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


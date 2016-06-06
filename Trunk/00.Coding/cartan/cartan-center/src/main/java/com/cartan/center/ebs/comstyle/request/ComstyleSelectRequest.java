/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.comstyle.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.comstyle.domain.Comstyle;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class ComstyleSelectRequest extends AbstractRopRequest {
	private String id;//类别编号
	private String code;//类别代码
	private String name;//类别名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public ComstyleSelectRequest(){}
	
	public ComstyleSelectRequest(Comstyle comstyle){
		BeanUtils.copyProperties(comstyle,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(Comstyle bo){
		BeanUtils.copyProperties(this,bo);
	}
	public Comstyle cloneBO(){
		Comstyle bo = new Comstyle();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<Comstyle> cloneBOList(List<ComstyleSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<Comstyle>(0);
		List<Comstyle> result = new ArrayList<Comstyle>(vos.size());
		for(ComstyleSelectRequest vo: vos){
			Comstyle bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


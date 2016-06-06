/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.comcode.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.comcode.domain.Comcode;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class ComcodeCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 100)
	private String id;//代码编号
	@Size(min = 0, max = 100)
	private String typecode;//代码类别
	@Size(min = 0, max = 100)
	private String code;//常用代码
	@Size(min = 0, max = 100)
	private String name;//中文名称
	@Size(min = 0, max = 100)
	private String shortname;//缩写简称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getTypecode() {
		return this.typecode;
	}
	
	public void setTypecode(String typecode) {
		this.typecode = typecode;
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
	public String getShortname() {
		return this.shortname;
	}
	
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	
	public ComcodeCreateRequest(){}
	
	public ComcodeCreateRequest(Comcode comcode){
		BeanUtils.copyProperties(comcode,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(Comcode bo){
		BeanUtils.copyProperties(this,bo);
	}
	public Comcode cloneBO(){
		Comcode bo = new Comcode();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<Comcode> cloneBOList(List<ComcodeCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<Comcode>(0);
		List<Comcode> result = new ArrayList<Comcode>(vos.size());
		for(ComcodeCreateRequest vo: vos){
			Comcode bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


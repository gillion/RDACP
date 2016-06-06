/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.memberClothingsize.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.memberClothingsize.domain.MemberClothingsize;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class MemberClothingsizeUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 100)
	private String id;//编号
	@Size(min = 0, max = 100)
	private String name;//姓名
	@Size(min = 0, max = 100)
	private String depart;//部门
	@Size(min = 0, max = 100)
	private String height;//身高
	@Size(min = 0, max = 100)
	private String weight;//体重
	@Size(min = 0, max = 100)
	private String clothingSize;//尺码
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getDepart() {
		return this.depart;
	}
	
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getHeight() {
		return this.height;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return this.weight;
	}
	
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getClothingSize() {
		return this.clothingSize;
	}
	
	public void setClothingSize(String clothingSize) {
		this.clothingSize = clothingSize;
	}
	
	public MemberClothingsizeUpdateRequest(){}
	
	public MemberClothingsizeUpdateRequest(MemberClothingsize memberClothingsize){
		BeanUtils.copyProperties(memberClothingsize,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(MemberClothingsize bo){
		BeanUtils.copyProperties(this,bo);
	}
	public MemberClothingsize cloneBO(){
		MemberClothingsize bo = new MemberClothingsize();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<MemberClothingsize> cloneBOList(List<MemberClothingsizeUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<MemberClothingsize>(0);
		List<MemberClothingsize> result = new ArrayList<MemberClothingsize>(vos.size());
		for(MemberClothingsizeUpdateRequest vo: vos){
			MemberClothingsize bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


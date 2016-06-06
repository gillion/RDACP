/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.dataset.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.dataset.domain.Dataset;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class DatasetCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String datasetName;//数据集
	@Size(min = 0, max = 200)
	private String datasetDes;//数据集描述
	@Size(min = 0, max = 50)
	private String datasetType;//类型
	@Size(min = 0, max = 1000)
	private String remark;//备注
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getDatasetName() {
		return this.datasetName;
	}
	
	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}
	public String getDatasetDes() {
		return this.datasetDes;
	}
	
	public void setDatasetDes(String datasetDes) {
		this.datasetDes = datasetDes;
	}
	public String getDatasetType() {
		return this.datasetType;
	}
	
	public void setDatasetType(String datasetType) {
		this.datasetType = datasetType;
	}
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public DatasetCreateRequest(){}
	
	public DatasetCreateRequest(Dataset dataset){
		BeanUtils.copyProperties(dataset,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(Dataset bo){
		BeanUtils.copyProperties(this,bo);
	}
	public Dataset cloneBO(){
		Dataset bo = new Dataset();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<Dataset> cloneBOList(List<DatasetCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<Dataset>(0);
		List<Dataset> result = new ArrayList<Dataset>(vos.size());
		for(DatasetCreateRequest vo: vos){
			Dataset bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


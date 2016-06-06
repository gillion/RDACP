/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfCcmShlp.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmShlp.domain.IpfCcmShlp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmShlpUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String shlpName;//名称
	@Size(min = 0, max = 50)
	private String shlpStatus;//状态
	@Size(min = 0, max = 1000)
	private String dataSource;//数据源
	@Size(min = 0, max = 50)
	private String dataSourceType;//数据源类型
	@Size(min = 0, max = 50)
	private String valueColumn;//值字段
	@Size(min = 0, max = 50)
	private String displayColumn;//文本字段
	@Size(min = 0, max = 50)
	private String ruleNo;//业务规则号
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getShlpName() {
		return this.shlpName;
	}
	
	public void setShlpName(String shlpName) {
		this.shlpName = shlpName;
	}
	public String getShlpStatus() {
		return this.shlpStatus;
	}
	
	public void setShlpStatus(String shlpStatus) {
		this.shlpStatus = shlpStatus;
	}
	public String getDataSource() {
		return this.dataSource;
	}
	
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getDataSourceType() {
		return this.dataSourceType;
	}
	
	public void setDataSourceType(String dataSourceType) {
		this.dataSourceType = dataSourceType;
	}
	public String getValueColumn() {
		return this.valueColumn;
	}
	
	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}
	public String getDisplayColumn() {
		return this.displayColumn;
	}
	
	public void setDisplayColumn(String displayColumn) {
		this.displayColumn = displayColumn;
	}
	public String getRuleNo() {
		return this.ruleNo;
	}
	
	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
	
	public IpfCcmShlpUpdateRequest(){}
	
	public IpfCcmShlpUpdateRequest(IpfCcmShlp ipfCcmShlp){
		BeanUtils.copyProperties(ipfCcmShlp,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmShlp bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmShlp cloneBO(){
		IpfCcmShlp bo = new IpfCcmShlp();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmShlp> cloneBOList(List<IpfCcmShlpUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmShlp>(0);
		List<IpfCcmShlp> result = new ArrayList<IpfCcmShlp>(vos.size());
		for(IpfCcmShlpUpdateRequest vo: vos){
			IpfCcmShlp bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


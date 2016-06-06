/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10 
 */
package com.cartan.center.ebs.ipfRtmConfigAttr.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfRtmConfigAttr.domain.IpfRtmConfigAttr;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfRtmConfigAttrUpdateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String ipfRtmConfigId;//运行期配置
	@Size(min = 0, max = 50)
	private String seqNo;//序号
	@Size(min = 0, max = 50)
	private String displayLabel;//显示名称
	@Size(min = 0, max = 50)
	private String dataType;//数据类型
	@Size(min = 0, max = 50)
	private String uiType;//UI组件类型
	@Size(min = 0, max = 50)
	private String dictTableName;//字典表编码
	@Size(min = 0, max = 50)
	private String dictGroupValue;//字典表分组名
	@Size(min = 0, max = 50)
	private String searchHelp;//搜索帮助名
	@Size(min = 0, max = 50)
	private String shValueColumn;//搜索帮助值字段
	@Size(min = 0, max = 50)
	private String shDisplayColumn;//搜索帮助文本字段
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getIpfRtmConfigId() {
		return this.ipfRtmConfigId;
	}
	
	public void setIpfRtmConfigId(String ipfRtmConfigId) {
		this.ipfRtmConfigId = ipfRtmConfigId;
	}
	public String getSeqNo() {
		return this.seqNo;
	}
	
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getDisplayLabel() {
		return this.displayLabel;
	}
	
	public void setDisplayLabel(String displayLabel) {
		this.displayLabel = displayLabel;
	}
	public String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getUiType() {
		return this.uiType;
	}
	
	public void setUiType(String uiType) {
		this.uiType = uiType;
	}
	public String getDictTableName() {
		return this.dictTableName;
	}
	
	public void setDictTableName(String dictTableName) {
		this.dictTableName = dictTableName;
	}
	public String getDictGroupValue() {
		return this.dictGroupValue;
	}
	
	public void setDictGroupValue(String dictGroupValue) {
		this.dictGroupValue = dictGroupValue;
	}
	public String getSearchHelp() {
		return this.searchHelp;
	}
	
	public void setSearchHelp(String searchHelp) {
		this.searchHelp = searchHelp;
	}
	public String getShValueColumn() {
		return this.shValueColumn;
	}
	
	public void setShValueColumn(String shValueColumn) {
		this.shValueColumn = shValueColumn;
	}
	public String getShDisplayColumn() {
		return this.shDisplayColumn;
	}
	
	public void setShDisplayColumn(String shDisplayColumn) {
		this.shDisplayColumn = shDisplayColumn;
	}
	
	public IpfRtmConfigAttrUpdateRequest(){}
	
	public IpfRtmConfigAttrUpdateRequest(IpfRtmConfigAttr ipfRtmConfigAttr){
		BeanUtils.copyProperties(ipfRtmConfigAttr,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfRtmConfigAttr bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfRtmConfigAttr cloneBO(){
		IpfRtmConfigAttr bo = new IpfRtmConfigAttr();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfRtmConfigAttr> cloneBOList(List<IpfRtmConfigAttrUpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfRtmConfigAttr>(0);
		List<IpfRtmConfigAttr> result = new ArrayList<IpfRtmConfigAttr>(vos.size());
		for(IpfRtmConfigAttrUpdateRequest vo: vos){
			IpfRtmConfigAttr bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


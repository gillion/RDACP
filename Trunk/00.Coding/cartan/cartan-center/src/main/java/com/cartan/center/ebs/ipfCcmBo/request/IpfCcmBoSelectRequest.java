/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBo.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmBo.domain.IpfCcmBo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmBoSelectRequest extends AbstractRopRequest {
	private String id;//主键
	private String boName;//业务对象名
	private String boType;//对象类型
	private String appModule;//功能模块
	private String serviceType;//服务类型
	private String javaPath;//JAVA路径
	private String serviceCategory;//服务分类
	private String tableName;//表名
	private String tableType;//表类型
	private String description;//描述
	private String searchColumns;//查询条件列数
	private String searchMode;//查询模式
	private String pageSize;//每页记录
	private String ipfCcmUiLayoutId;//界面布局ID
	private String uiLayoutName;//界面布局名称
	private String formCellMode;//界面模式
	private String uiTemplate;//界面模板
	private String formColumns;//每行列数
	private String gridStyle;//表格样式
	private String gridAlign;//表格列对齐
	private String gridEditType;//表格维护方式
	private String generateOption;//代码生成选项
	private String lockRowExpress;//行锁定表达式
	private String gridType;//表格类型
	private String isMainObject;//主对象
	private String isInitDataBo;//初始化数据对象
	private String isAutoLoad;//自动查询
	private String isNeedAdvSearch;//需高级查询
	private String needPaging;//表格分页
	private String isGridFilter;//表格列筛选
	private String isGridCustom;//表格列定义
	private String remark;//备注
	private String whereClause;//WHERE条件
	private String idGenerator;//ID生成器名称
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getBoName() {
		return this.boName;
	}
	
	public void setBoName(String boName) {
		this.boName = boName;
	}
	
	

	public String getBoType() {
		return this.boType;
	}
	
	public void setBoType(String boType) {
		this.boType = boType;
	}
	
	

	public String getAppModule() {
		return this.appModule;
	}
	
	public void setAppModule(String appModule) {
		this.appModule = appModule;
	}
	
	

	public String getServiceType() {
		return this.serviceType;
	}
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	

	public String getJavaPath() {
		return this.javaPath;
	}
	
	public void setJavaPath(String javaPath) {
		this.javaPath = javaPath;
	}
	
	

	public String getServiceCategory() {
		return this.serviceCategory;
	}
	
	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	
	

	public String getTableName() {
		return this.tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	

	public String getTableType() {
		return this.tableType;
	}
	
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	
	

	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getSearchColumns() {
		return this.searchColumns;
	}
	
	public void setSearchColumns(String searchColumns) {
		this.searchColumns = searchColumns;
	}
	
	

	public String getSearchMode() {
		return this.searchMode;
	}
	
	public void setSearchMode(String searchMode) {
		this.searchMode = searchMode;
	}
	
	

	public String getPageSize() {
		return this.pageSize;
	}
	
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	

	public String getIpfCcmUiLayoutId() {
		return this.ipfCcmUiLayoutId;
	}
	
	public void setIpfCcmUiLayoutId(String ipfCcmUiLayoutId) {
		this.ipfCcmUiLayoutId = ipfCcmUiLayoutId;
	}
	
	

	public String getUiLayoutName() {
		return this.uiLayoutName;
	}
	
	public void setUiLayoutName(String uiLayoutName) {
		this.uiLayoutName = uiLayoutName;
	}
	
	

	public String getFormCellMode() {
		return this.formCellMode;
	}
	
	public void setFormCellMode(String formCellMode) {
		this.formCellMode = formCellMode;
	}
	
	

	public String getUiTemplate() {
		return this.uiTemplate;
	}
	
	public void setUiTemplate(String uiTemplate) {
		this.uiTemplate = uiTemplate;
	}
	
	

	public String getFormColumns() {
		return this.formColumns;
	}
	
	public void setFormColumns(String formColumns) {
		this.formColumns = formColumns;
	}
	
	

	public String getGridStyle() {
		return this.gridStyle;
	}
	
	public void setGridStyle(String gridStyle) {
		this.gridStyle = gridStyle;
	}
	
	

	public String getGridAlign() {
		return this.gridAlign;
	}
	
	public void setGridAlign(String gridAlign) {
		this.gridAlign = gridAlign;
	}
	
	

	public String getGridEditType() {
		return this.gridEditType;
	}
	
	public void setGridEditType(String gridEditType) {
		this.gridEditType = gridEditType;
	}
	
	

	public String getGenerateOption() {
		return this.generateOption;
	}
	
	public void setGenerateOption(String generateOption) {
		this.generateOption = generateOption;
	}
	
	

	public String getLockRowExpress() {
		return this.lockRowExpress;
	}
	
	public void setLockRowExpress(String lockRowExpress) {
		this.lockRowExpress = lockRowExpress;
	}
	
	

	public String getGridType() {
		return this.gridType;
	}
	
	public void setGridType(String gridType) {
		this.gridType = gridType;
	}
	
	

	public String getIsMainObject() {
		return this.isMainObject;
	}
	
	public void setIsMainObject(String isMainObject) {
		this.isMainObject = isMainObject;
	}
	
	

	public String getIsInitDataBo() {
		return this.isInitDataBo;
	}
	
	public void setIsInitDataBo(String isInitDataBo) {
		this.isInitDataBo = isInitDataBo;
	}
	
	

	public String getIsAutoLoad() {
		return this.isAutoLoad;
	}
	
	public void setIsAutoLoad(String isAutoLoad) {
		this.isAutoLoad = isAutoLoad;
	}
	
	

	public String getIsNeedAdvSearch() {
		return this.isNeedAdvSearch;
	}
	
	public void setIsNeedAdvSearch(String isNeedAdvSearch) {
		this.isNeedAdvSearch = isNeedAdvSearch;
	}
	
	

	public String getNeedPaging() {
		return this.needPaging;
	}
	
	public void setNeedPaging(String needPaging) {
		this.needPaging = needPaging;
	}
	
	

	public String getIsGridFilter() {
		return this.isGridFilter;
	}
	
	public void setIsGridFilter(String isGridFilter) {
		this.isGridFilter = isGridFilter;
	}
	
	

	public String getIsGridCustom() {
		return this.isGridCustom;
	}
	
	public void setIsGridCustom(String isGridCustom) {
		this.isGridCustom = isGridCustom;
	}
	
	

	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	public String getWhereClause() {
		return this.whereClause;
	}
	
	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}
	
	

	public String getIdGenerator() {
		return this.idGenerator;
	}
	
	public void setIdGenerator(String idGenerator) {
		this.idGenerator = idGenerator;
	}
	
	
	
	public IpfCcmBoSelectRequest(){}
	
	public IpfCcmBoSelectRequest(IpfCcmBo ipfCcmBo){
		BeanUtils.copyProperties(ipfCcmBo,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmBo bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmBo cloneBO(){
		IpfCcmBo bo = new IpfCcmBo();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmBo> cloneBOList(List<IpfCcmBoSelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmBo>(0);
		List<IpfCcmBo> result = new ArrayList<IpfCcmBo>(vos.size());
		for(IpfCcmBoSelectRequest vo: vos){
			IpfCcmBo bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}


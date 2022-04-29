<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign fatherClassName = fatherClazz.className>   
<#assign fatherClassNameLower = fatherClassName?uncap_first>

<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.service.${moduleName};
import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.bo.${moduleName}.${fatherClassName};
import ${basepackage}.data.vo.${moduleName}.${className}VO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.fkframe.query.PageData;
import ${basepackage}.service.common.BaseBS;

public interface ${className}BS extends BaseBS {
	
	public Long generateId() ;
	
	public ${className}VO queryVOById(Long id);
	public List<${className}VO> queryVOByParentId(Long orderId);
	public List<${className}VO> queryVOByParentId(List<Long> orderIds);
	public PageData queryVOPageByParentId(Long parentId,Integer pageNo);
	
	
	public void del${className}ByIds(Long... ids)throws Exception;
	public ${className} add${className}(${className} entity) throws Exception;
	public ${className} modify${className}(${className} entity)throws Exception;
	
	public void saveOrUpdateByParent(${fatherClassName} parentEntity, Long operSeriaNo,Long pid) throws Exception;
	public void deleteByParentId(Long parentId) throws Exception;
	public void copyToTemp(Long parentId,Long operSerialNo) throws Exception;	
}


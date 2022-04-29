<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign fatherClassName = fatherClazz.className>   
<#assign fatherClassNameLower = fatherClassName?uncap_first>

<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.service.${moduleName};
import ${basepackage}.data.bo.${moduleName}.${className};
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
	public PageData queryVOPageByParentId(Long parentId,Integer pageNo);
	
	
	/**
	 * 
	 * @param addList新增的数据
	 * @param updList修改的数据
	 * @param delList删除的数据
	 * @throws Exception
	 */
	public void saveOrUpdate${className}s(List<${className}> addList,List<${className}> updList,List<${className}> delList) throws Exception;
	
	/**
	 * 根据主表id删除明细表数据
	 * @param countOrderId 主表ID
	 * @throws Exception
	 */
	public void deleteByParentId(Long ${mainClazzId}) throws Exception;
	
	public ${className} add${className}(${className} entity) throws Exception;
	public ${className} modify${className}(${className} entity)throws Exception;
	public void del${className}ByIds(Long... ids)throws Exception;
	public void del${className}(${className} entity)throws Exception;
}


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
	public PageData queryVOPageByParentId(Long parentId,Integer pageNo);
	
	public void del${className}ByIds(Long... ids) throws Exception;
	
	/**
	 * 新增数据，由于是新增并无真实id，子表用临时表的KeyNum做父节点ID
	 * @param entity
	 * @param operSeriaNo
	 * @param tid 临时表的主键，查询子表是用这个关联
	 * @return
	 * @throws Exception
	 */
	public ${className} add${className}(${className} entity,Long operSeriaNo,Long tid) throws Exception;
	public ${className} modify${className}(${className} entity,Long operSeriaNo)throws Exception;
	
	public void saveOrUpdateByParent(${fatherClassName} ${fatherClassNameLower},Long operSeriaNo) throws Exception;
	public void deleteByParentId(Long ${mainClazzId}) throws Exception;
	public void copyToTemp(Long noticeId,Long operSerialNo) throws Exception;	
}
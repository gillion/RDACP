<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign fatherClassName = fatherClazz.className>   
<#assign fatherClassNameLower = fatherClassName?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.service.${moduleName};
import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.data.bo.${moduleName}.${fatherClassName};
import java.util.List;
import com.fkframe.query.PageData;
import ${basepackage}.service.common.BaseBS;

public interface ${className}BS extends BaseBS {
	
	public Long generateId() ;
	public ${className}VO queryVOById(Long id);
	public List<${className}VO> queryVOByParentId(Long orderId);	
	public PageData queryVOPageByParentId(Long parentId,Integer pageNo);
	
	public void del${className}ByIds(Long... ids)throws Exception;
	public void del${className}(${className} entity)throws Exception;
	public ${className} add${className}(${className} entity,Long operSeriaNo) throws Exception;
	public ${className} modify${className}(${className} entity,Long operSeriaNo)throws Exception;
	
	public void saveOrUpdateByParent(${fatherClassName} ${fatherClassNameLower}, Long operSeriaNo) throws Exception;
	public void saveOrUpdateTemList(List<${className}VO>[] ${className}List) throws Exception;
	
	public void deleteByParentId(Long ${mainClazzId}) throws Exception;
	public void copyToTemp(Long ${mainClazzId},Long operSerialNo) throws Exception;
	
}


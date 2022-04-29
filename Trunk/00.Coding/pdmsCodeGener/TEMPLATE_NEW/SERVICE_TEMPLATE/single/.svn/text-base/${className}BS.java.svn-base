<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.service.${moduleName};

import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.service.common.BaseBS;
import com.fkframe.query.PageData;
import java.util.List;
import java.util.Map;

/**
 *${entityCnName} SERVICE接口 
 */
public interface ${className}BS extends BaseBS {
	public ${className}VO queryVOById(Long id);
	public PageData queryVOPage(Map<String,?> queryParams,Integer pageNo);  
	public List<${className}VO> queryVOByParam(Map<String,?> queryParams);
	
	
}


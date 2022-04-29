<#assign className = clazz.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameFull = "${basepackage}.data.bo.${moduleName}.${className}"> 
<#assign VONameFull = "${basepackage}.data.vo.${moduleName}.${className}VO"> 
package ${basepackage}.service.${moduleName};

import ${basepackage}.data.bo.${moduleName}.${className};
import ${basepackage}.data.vo.${moduleName}.${className}VO;
import ${basepackage}.service.common.BaseBS;
import java.io.Serializable;
import com.fkframe.query.PageData;
import java.util.List;
import java.util.Map;

/**
 *${entityCnName} SERVICE接口 
 *
 */
public interface ${className}BS extends BaseBS {
	
	public Long generateId() ;//主键值获取
	
	/**通用查询方法***/
	public ${className}VO queryVOById(Long id);
	public PageData queryVOPage(Map<String,?> queryParams,Integer pageNo);  
	
	/**持久化方法**/
	public void del${className}ByIds(Long... ids)throws Exception;
	public void del${className}(${className} entity)throws Exception;
	public ${className} audit${className}(Long id,boolean auditFlag) throws Exception;
	
	/**1临时表**/
	public void copyDetailsToTemp(Long id,Long serialNBR) throws Exception;
	public ${className} add${className}(${className} entity,Long operSeriaNo) throws Exception;
	public ${className} modify${className}(${className} entity,Long operSeriaNo)throws Exception;
}
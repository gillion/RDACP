<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.service.${moduleName};

import cn.com.xcs.framework.persist.Page;

import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.common.service.${moduleName}.base.${className}ServiceBase;
import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public interface ${className}Service<T> extends ${className}ServiceBase<T> {
	
}

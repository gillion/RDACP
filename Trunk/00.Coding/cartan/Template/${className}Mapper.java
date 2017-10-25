<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.mapper.${moduleName};

import cn.com.xcs.framework.persist.Page;

import cn.ibm.dao.BaseDao;
import ${basepackage}.common.dao.${moduleName}.base.${className}DaoIBBase;
import ${basepackage}.common.pojo.${moduleName}.${className};

import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public interface ${className}Mapper extends ${className}DaoIBBase{

}

<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.dao.${moduleName}.impl;

import cn.com.xcs.framework.persist.Page;

import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.common.dao.${moduleName}.${className}DaoIB;
import ${basepackage}.common.dao.${moduleName}.impl.base.${className}DaoImplIBBase;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ${className}DaoImplIB extends ${className}DaoImplIBBase implements ${className}DaoIB{
	
}
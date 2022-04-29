<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.dao.${moduleName};

import cn.com.xcs.framework.persist.Page;

import cn.cst.kcgl.common.dao.BaseDao;

import ${basepackage}.common.pojo.${className};

import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: wangjf
 * Date: 16-7-12
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public interface ${className}DaoIB extends ${className}DaoIBBase{

}

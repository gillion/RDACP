<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.service.${moduleName};

import cn.com.xcs.framework.persist.Page;

import ${basepackage}.common.pojo.${className};

import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-7-13
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public interface ${className}ServiceIB extends ${className}ServiceIBBase {

}

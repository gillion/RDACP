<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.view.${moduleName};

import ${basepackage}.common.view.${moduleName}.base.${className}ViewBase;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
public class ${className}View extends ${className}ViewBase{
    /** default constructor */
    public ${className}View(){

    }
}
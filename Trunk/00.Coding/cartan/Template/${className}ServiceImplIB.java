<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.service.${moduleName}.impl;

import cn.com.xcs.framework.persist.Page;

import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.common.dao.${moduleName}.${className}DaoIB;
import ${basepackage}.common.service.${moduleName}.${className}ServiceIB;
import ${basepackage}.common.service.${moduleName}.impl.base.${className}ServiceImplIBBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-13
 * Time: 下午2:32
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ${className}ServiceImplIB extends ${className}ServiceImplIBBase implements ${className}ServiceIB {

    @Resource
    private ${className}DaoIB ${classNameLower}DaoIB;
}
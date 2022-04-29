<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.service.${moduleName}.impl;

import cn.com.xcs.framework.persist.Page;

import ${basepackage}.common.pojo.${className};
import ${basepackage}.common.dao.${moduleName}.${className}Dao;
import ${basepackage}.common.service.${moduleName}.${className}Service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ${className}ServiceImpl extends ${className}ServiceImplBase implements ${className}Service {
	
}

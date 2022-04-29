<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.dao.${moduleName}.impl;

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.persist.orm.PageHibernateDaoSupport;

import ${basepackage}.common.dao.${moduleName}.${className}Dao;
import ${basepackage}.common.pojo.${className};

import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.helper.Validate;
import org.springframework.stereotype.Repository;

/**
 * ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 下午3:12
 */
@Repository
public class ${className}DaoImpl extends ${className}DaoImplBase implements ${className}Dao {
	
}
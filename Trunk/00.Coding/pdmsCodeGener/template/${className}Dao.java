<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.dao.${moduleName};

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.persist.orm.HibernateDao;

import ${basepackage}.common.pojo.${className};

import org.jsoup.helper.Validate;

import java.util.List;


/**
 * ${table.tableAlias}Dao
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 下午3:08
 */
public interface ${className}Dao extends ${className}DaoBase {
	
}

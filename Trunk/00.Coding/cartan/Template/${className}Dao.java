<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.dao.${moduleName};

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.persist.orm.HibernateDao;
import ${basepackage}.common.dao.${moduleName}.base.${className}DaoBase;
import ${basepackage}.common.pojo.${moduleName}.${className};

import org.jsoup.helper.Validate;

import java.util.List;


/**
 * ${table.tableAlias}Dao
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午3:08
 */
public interface ${className}Dao<T> extends ${className}DaoBase<T> {
	
}

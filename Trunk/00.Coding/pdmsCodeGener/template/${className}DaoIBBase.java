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
public interface ${className}DaoIBBase extends BaseDao<${className},String>{

    /**
     * 根据ID获取对象
     * @param id  主键id
     * @return
     */
    public ${className} get${className}ById(String id);

    /**
     * 分页查询${table.tableAlias}对象
     * @param page
     * @return
     */
    public Page get${className}Page(Page page,${className} ${classNameLower});

    /**
     * 列表查询${table.tableAlias}对象
     * @param
     * @return
     */
    public List<${className}> get${className}List(${className} ${classNameLower});

    <#if noparent == "0"||noparent == "2">
    /**
     * 根据ID删除对象
     * @param id  主键id
     */
    public int delete${className}ById(String id);

    /**
     * 新增${table.tableAlias}
     * @param ${classNameLower}   ${table.tableAlias}对象
     */
    public void save${className}(${className} ${classNameLower});

    /**
     * 更新${table.tableAlias}
     * @param ${classNameLower}     ${table.tableAlias}对象
     * @return
     */
    public int update${className}(${className} ${classNameLower});
    </#if>


}

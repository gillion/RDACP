<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.service.${moduleName};

import cn.com.xcs.framework.persist.Page;

import cn.cst.kcgl.common.service.BaseService;

import ${basepackage}.common.pojo.${className};

import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public interface ${className}ServiceBase extends BaseService {

    /**
     * 分页模糊查找${table.tableAlias}列表信息
     * @param page		分页对象
     * @param ${classNameLower} ${table.tableAlias}
     * @return
     */
    public Page find${className}sByParams(Page page, ${className} ${classNameLower});
    <#if noparent == "0"||noparent == "2">
    /**
     * 保存${table.tableAlias}信息
     * @param ${classNameLower} ${table.tableAlias}
     */
    public void save${className}(${className} ${classNameLower},int ... noMakeId);

    /**
     * 修改${table.tableAlias}信息
     * @param ${classNameLower} ${table.tableAlias}
     */
    public void update${className}(${className} ${classNameLower});

    /**
     * 删除${table.tableAlias}信息
     * @param id
     */
    public void delete${className}(String id);
    /**
     * 批量删除${table.tableAlias}信息
     * @param ids 主键列表，用逗号分隔
     */
    public void deleteIds(String ids);
    </#if>

    /**
     * 根据id${table.tableAlias}信息
     * @param id
     */
    public ${className} get${className}(String id);

    /**
     * 根据${classNameLower}获取${table.tableAlias}对象列表信息
     * @param ${classNameLower}
     */
    public List<${className}> ${classNameLower}sByParams(${className} ${classNameLower});
}

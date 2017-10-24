<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign bigger = "&gt;">
<#assign smaller = "&lt;">
<#assign leftbit = "#{">
<#assign rightbit = "}">
<#assign prikey = "ID">
<#assign pricolumn = "id">
<#assign priSqlType = "Long">
<#list table.columns as column>
<#if column.pk>
<#assign pricolumnUp = column.columnName>
<#assign pricolumn = column.columnName?uncap_first>
<#assign prikey = column.sqlName>
<#assign priSqlType = column.sqlTypeName>
</#if>	
</#list>
package ${basepackage}.common.controller.${moduleName}.base;

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.web.controller.PageController;
import cn.com.xcs.framework.web.ui.UIPage;
import cn.ibm.view.ResultInfo;

import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.common.service.${moduleName}.${className}ServiceIB;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午1:41
 * To change this template use File | Settings | File Templates.
 */
public class ${className}ControllerIBBase extends PageController {
    protected Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private ${className}ServiceIB ${classNameLower}ServiceIB;

    <#if noparent == "0"||noparent == "2">
    /**
     * 新增${table.tableAlias}
     * @param ${classNameLower}
     * @return
     */
    @RequestMapping(value ="save")
    @ResponseBody
    public ResultInfo save(${className} ${classNameLower}){
        ResultInfo resultInfo = ResultInfo.getInstance(this.getClass());
        try{
            this.${classNameLower}ServiceIB.save${className}(${classNameLower});
            resultInfo.setMessage("success");
        }catch(Exception e) {
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultInfo;
    }

    /**
     * 根据id删除${table.tableAlias}
     * @param id
     * @return
     */
    @RequestMapping(value="delete")
    @ResponseBody
    public ResultInfo delete(<#if priSqlType=="NUMBER">Long<#else>String</#if> id){
        ResultInfo resultInfo = ResultInfo.getInstance(this.getClass());
        try{
            int num = this.${classNameLower}ServiceIB.delete${className}ById(id);
            resultInfo.setMessage(num+"条记录删除成功");
        }catch (Exception e){
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return  resultInfo;
    }

    /**
     * 修改${table.tableAlias}
     * @param ${classNameLower}
     * @return
     */
    @RequestMapping(value="update")
    @ResponseBody
    public ResultInfo update(${className} ${classNameLower}){
        ResultInfo resultInfo = ResultInfo.getInstance(this.getClass());
        try{
            int num = this.${classNameLower}ServiceIB.update${className}(${classNameLower});
            resultInfo.setMessage(num+"条记录更新成功");
        }catch (Exception e){
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return  resultInfo;
    }
    </#if>
    /**
     * 分页显示${table.tableAlias}
     * @param page
     * @param rows
     * @param ${classNameLower}
     * @return
     */
    @RequestMapping(value="getPage")
    @ResponseBody
    public ResultInfo<UIPage> getPage(Integer page,Integer rows,${className} ${classNameLower}){
        Page pager = this.getPage(page, rows);
        ResultInfo<UIPage> resultInfo = ResultInfo.getInstance(UIPage.class);
        try {
            pager = this.${classNameLower}ServiceIB.get${className}Page(pager,${classNameLower});
            resultInfo.setData(this.pageCreator.toUIPage(pager));
        } catch (Exception e) {
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultInfo;
    }
    
    /**
     * 通过id查找${table.tableAlias}对象
     * @param ${classNameLower}
     * @return
     */
    @RequestMapping(value="getById")
    @ResponseBody
    public ResultInfo<${className}> getById(${className} ${classNameLower}){
        ResultInfo<${className}> resultInfo = ResultInfo.getInstance(${className}.class);
        try{
            ${className} ${classNameLower}View = this.${classNameLower}ServiceIB.get${className}ById(${classNameLower}.getId());
            resultInfo.setData(${classNameLower}View);
        }catch (Exception e){
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return resultInfo;
    }

    /**
     * 列出全部${table.tableAlias}
     * @param page
     * @param rows
     * @param ${classNameLower}
     * @return
     */
    @RequestMapping(value="getList")
    @ResponseBody
    public ResultInfo getList(Integer page,Integer rows,${className} ${classNameLower}){
        Page pager = this.getPage(page, rows);
        ResultInfo resultInfo = ResultInfo.getInstance(this.getClass());
        try {
            List<${className}> list = this.${classNameLower}ServiceIB.get${className}List(${classNameLower});
            resultInfo.setData(list);
        } catch (Exception e) {
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultInfo;
    }
}

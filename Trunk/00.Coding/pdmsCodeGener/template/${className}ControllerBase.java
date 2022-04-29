<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.controller.${moduleName};

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.web.controller.PageController;
import cn.com.xcs.framework.web.ui.UIPage;

import cn.cst.kcgl.common.view.ResultInfo;

import ${basepackage}.common.pojo.${className};
import ${basepackage}.common.service.${moduleName}.${className}Service;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 上午11:55
 */
public class ${className}ControllerBase extends PageController {
    protected Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private ${className}Service ${classNameLower}Service;

    <#if noparent == "0"||noparent == "2">
    /**
     * 保存${table.tableAlias}信息
     * @param ${classNameLower} ${table.tableAlias}
     */
    @RequestMapping(value = "/saveBatch", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveBatch(@RequestBody List<${className}> ${classNameLower}List){
        ResultInfo  resultInfo = ResultInfo.getInstance(this.getClass());
        try {
        	for (int i=0;i<${classNameLower}List.size();i++){
        		if ((null!=${classNameLower}List.get(i).getId())&&(null!=this.${classNameLower}Service.get${className}(${classNameLower}List.get(i).getId()))){
        			this.${classNameLower}Service.update${className}(${classNameLower}List.get(i));
        		}else{
        			this.${classNameLower}Service.save${className}(${classNameLower}List.get(i));
        		}
        	}
            resultInfo.setData("success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultInfo.setErrorMessage(e.getMessage());
        }
        return resultInfo;
    }
    /**
     * 保存${table.tableAlias}信息
     * @param ${classNameLower} ${table.tableAlias}
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo save(${className} ${classNameLower}){
        ResultInfo  resultInfo = ResultInfo.getInstance(this.getClass());
        try {
            this.${classNameLower}Service.save${className}(${classNameLower});
            resultInfo.setData("success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultInfo.setErrorMessage(e.getMessage());
        }
        return resultInfo;
    }
    
    /**
     * 删除${table.tableAlias}信息
     * @param id
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo delete(String id){
        ResultInfo  resultInfo = ResultInfo.getInstance(this.getClass());
        try {
            if(StringUtils.isNotBlank(id)){
                this.${classNameLower}Service.delete${className}(id);
                resultInfo.setData("success");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultInfo.setErrorMessage(e.getMessage());
        }
        return resultInfo;
    }

    /**
     * 删除${table.tableAlias}信息
     * @param id
     */
    @RequestMapping(value = "/deleteIds", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteIds(String ids){
        ResultInfo  resultInfo = ResultInfo.getInstance(this.getClass());
        try {
            if(StringUtils.isNotBlank(ids)){
                this.${classNameLower}Service.deleteIds(ids);
                resultInfo.setData("success");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultInfo.setErrorMessage(e.getMessage());
        }
        return resultInfo;
    }
    /**
     * 修改${table.tableAlias}信息
     * @param ${classNameLower} ${table.tableAlias}
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo update(${className} ${classNameLower}){
        ResultInfo  resultInfo = ResultInfo.getInstance(this.getClass());
        try {
            this.${classNameLower}Service.update${className}(${classNameLower});
            resultInfo.setData("success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultInfo.setErrorMessage(e.getMessage());
        }
        return resultInfo;
    }
    </#if>
    /**
     * 跳转修改页面
     * @param  id
     */
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo<${className}> getById(String id){
    	ResultInfo<${className}> resultInfo = ResultInfo.getInstance(${className}.class);
        try{
        //根据id加载数据
            ${className} ${classNameLower}View = this.${classNameLower}Service.get${className}(id);
            resultInfo.setData(${classNameLower}View);
        }catch (Exception e){
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return resultInfo;
    }
    
    
    /**
     * 根据礼品编号，礼品名称属性分页模糊查找${table.tableAlias}列表信息
     * @param page		分页对象
     * @param ${classNameLower} ${table.tableAlias}
     * @return
     */
    @RequestMapping(value = "/findListsByParams", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo<UIPage> findListsByParams(Integer page, Integer rows,${className} ${classNameLower}){
        Page pager = this.getPage(page, rows);
        ResultInfo<UIPage> resultInfo = ResultInfo.getInstance(UIPage.class);
        try {
            pager = this.${classNameLower}Service.find${className}sByParams(pager,${classNameLower});
            resultInfo.setData(this.pageCreator.toUIPage(pager));
        } catch (Exception e) {
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return resultInfo;
    }
}

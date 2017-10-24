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

import cn.ibm.service.common.ExpExcelService;
import ${basepackage}.common.service.${moduleName}.${className}ServiceIB;
import cn.ibm.view.ResultInfo;
import cn.ibm.service.HandlerAdapter;
import ${basepackage}.common.pojo.${moduleName}.${className};

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 上午11:55
 */
public class ${className}ControllerBase extends PageController {
    protected Logger logger = Logger.getLogger(this.getClass());

<#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
    @Resource(name = "${classNameLower}Handler")
    private HandlerAdapter<${className}Service> ${classNameLower}Handler;
<#else>
    @Resource
    private ${className}Service<${className}> ${classNameLower}Service;
</#if>
    @Resource
    private ${className}ServiceIB ${classNameLower}ServiceIB;
    @Resource
    private ExpExcelService exportExcelService;

    <#if noparent == "0"||noparent == "2"||noparent == "3">
    /**
     * 保存${table.tableAlias}信息
     * @param ${classNameLower}List ${table.tableAlias}
     */
    @RequestMapping(value = "/saveBatch", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveBatch(@RequestBody List<${className}> ${classNameLower}List){
        ResultInfo  resultInfo = ResultInfo.getInstance(this.getClass());
<#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
        try {
        	for (int i=0;i<${classNameLower}List.size();i++){
        		if ((null!=${classNameLower}List.get(i).getId())&&(null!=this.${classNameLower}Handler.getService().getObject(${classNameLower}List.get(i).getId()))){
        			this.${classNameLower}Handler.getService().update(${classNameLower}List.get(i));
        		}else{
        			this.${classNameLower}Handler.getService().save(${classNameLower}List.get(i));
        		}
        	}
            resultInfo.setData("success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultInfo.setErrorMessage(e.getMessage());
        }
<#else>
        try {
            for (int i=0;i<${classNameLower}List.size();i++){
                if ((null!=${classNameLower}List.get(i).getId())&&(null!=this.${classNameLower}Service.getObject(${classNameLower}List.get(i).getId()))){
                    this.${classNameLower}Service.update(${classNameLower}List.get(i));
                }else{
                    this.${classNameLower}Service.save(${classNameLower}List.get(i));
                }
            }
            resultInfo.setData("success");
        } catch (Exception e) {
                logger.error(e.getMessage(), e);
        resultInfo.setErrorMessage(e.getMessage());
        }
</#if>
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
<#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
            this.${classNameLower}Handler.getService().save(${classNameLower});
<#else>
            this.${classNameLower}Service.save(${classNameLower});
</#if>
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
    public ResultInfo delete(<#if priSqlType=="NUMBER">Long<#else>String</#if> id){
        ResultInfo  resultInfo = ResultInfo.getInstance(this.getClass());
        try {
<#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
        this.${classNameLower}Handler.getService().delete(id);
<#else>
        this.${classNameLower}Service.delete(id);
</#if>
                resultInfo.setData("success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultInfo.setErrorMessage(e.getMessage());
        }
        return resultInfo;
    }

    /**
     * 删除${table.tableAlias}信息
     * @param ids
     */
    @RequestMapping(value = "/deleteIds", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteIds(String ids){
        ResultInfo  resultInfo = ResultInfo.getInstance(this.getClass());
        try {
            if(StringUtils.isNotBlank(ids)){
<#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
            this.${classNameLower}Handler.getService().deleteIds(ids);
<#else>
            this.${classNameLower}Service.deleteIds(ids);
</#if>
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
<#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
        this.${classNameLower}Handler.getService().update(${classNameLower});
<#else>
        this.${classNameLower}Service.update(${classNameLower});
</#if>
            resultInfo.setData("success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultInfo.setErrorMessage(e.getMessage());
        }
        return resultInfo;
    }
    </#if>
    /**
     * 根据ID获取对象
     * @param  id
     */
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo<${className}> getById(<#if priSqlType=="NUMBER">Long<#else>String</#if> id){
    	ResultInfo<${className}> resultInfo = ResultInfo.getInstance(${className}.class);
        try{
        //根据id加载数据
        <#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
            ${className} ${classNameLower}View = (${className}) this.${classNameLower}Handler.getService().getObject(id);
        <#else>
            ${className} ${classNameLower}View = (${className}) this.${classNameLower}Service.getObject(id);
        </#if>
            resultInfo.setData(${classNameLower}View);
        }catch (Exception e){
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return resultInfo;
    }
    
    
    /**
     * 根据${classNameLower}分页模糊查找${table.tableAlias}列表信息
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
        <#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
            pager = this.${classNameLower}Handler.getService().findByParams(pager,${classNameLower});
        <#else>
            pager = this.${classNameLower}Service.findByParams(pager,${classNameLower});
        </#if>
            resultInfo.setData(this.pageCreator.toUIPage(pager));
        } catch (Exception e) {
            resultInfo.setErrorMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return resultInfo;
    }
    /**
     * 跳转到新增页面
     */
    @RequestMapping(value = "/toSavePage")
    public ModelAndView toSavePage(){
        ModelAndView modelAndView = new ModelAndView("test/${moduleName}/${className}Add");
        return modelAndView;
    }
    /**
     * 跳转到修改页面
     */
    @RequestMapping(value = "/toUpdatePage")
    public ModelAndView toUpdatePage(<#if priSqlType=="NUMBER">Long<#else>String</#if> id){
        ModelAndView modelAndView = new ModelAndView("test/${moduleName}/${className}Add");
        ${className} ${classNameLower} =  null;
        try {
        <#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
            ${classNameLower} = (${className}) this.${classNameLower}Handler.getService().getObject(id);
        <#else>
            ${classNameLower} = (${className}) this.${classNameLower}Service.getObject(id);
        </#if>
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("${classNameLower}",${classNameLower});
        return modelAndView;
    }
    /**
     * 跳转到查看页面
     */
    @RequestMapping(value = "/toViewPage")
    public ModelAndView toViewPage(<#if priSqlType=="NUMBER">Long<#else>String</#if> id){
        ModelAndView modelAndView = new ModelAndView("test/${moduleName}/${className}AddIB");
        ${className} ${classNameLower} = null;
        try {
        <#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
            ${classNameLower} =(${className}) this.${classNameLower}Handler.getService().getObject(id);
        <#else>
            ${classNameLower} =(${className}) this.${classNameLower}Service.getObject(id);
        </#if>
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        modelAndView.addObject("${classNameLower}",${classNameLower});
        return modelAndView;
    }
    /**
     * 根据${classNameLower}查询条件导出页面
     */
    @RequestMapping(value = "/exportPage",method = RequestMethod.POST )
    @ResponseBody
    public ResultInfo export(${className} ${classNameLower}, HttpServletRequest request,HttpServletResponse response){
            ResultInfo resultInfo = ResultInfo.getInstance(this.getClass());
        try{
        <#if (inherittable!='')&&(noparent == "0"||noparent == "2")>
            List<${className}> list = this.${classNameLower}Handler.getService().listEquals(${classNameLower});
        <#else>
            List<${className}> list = this.${classNameLower}Service.listEquals(${classNameLower});
        </#if>
            Map<String ,Object> map = new HashMap<String,Object>();
            map.put("excel",list);
            this.exportExcelService.exportExcelForTemplate(map, "E:\\Project\\pdqc-parent\\pdqc-web\\src\\main\\webapp\\content\\excel\\${classNameLower}.xls","",response);
        } catch (Exception e){
            resultInfo.setErrorMessage(e.getMessage());
        }
        return resultInfo;
    }
}

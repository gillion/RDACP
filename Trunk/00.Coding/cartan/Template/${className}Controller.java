<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign inherittableLower = inherittable?uncap_first>
package ${basepackage}.web.controller.${moduleName};

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.web.controller.PageController;
import cn.com.xcs.framework.web.ui.UIPage;

import cn.ibm.view.ResultInfo;

import ${basepackage}.common.controller.${moduleName}.base.${className}ControllerBase;

import ${basepackage}.common.pojo.${moduleName}.${className};

import ${basepackage}.common.service.${moduleName}.${className}Service;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 上午11:55
 */
@Controller
@RequestMapping("/${classNameLower}")
public class ${className}Controller extends ${className}ControllerBase {
@Resource
private ${className}Service ${classNameLower}Service;
}

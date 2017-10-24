<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.web.controller.${moduleName};

import cn.com.xcs.framework.persist.Page;
import cn.com.xcs.framework.web.controller.PageController;
import cn.com.xcs.framework.web.ui.UIPage;

import cn.ibm.view.ResultInfo;
import ${basepackage}.common.controller.${moduleName}.base.${className}ControllerIBBase;

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
@Controller
@RequestMapping("/${classNameLower}IB")
public class ${className}ControllerIB extends ${className}ControllerIBBase {
    @Resource
    private ${className}ServiceIB ${classNameLower}ServiceIB;
}

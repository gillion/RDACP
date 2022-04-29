<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.web.controller.${moduleName};

import java.io.IOException;
import java.math.BigDecimal;

import cn.com.xcs.framework.web.ui.UIPage;
import cn.cst.BaseControllerTest;
import ${basepackage}.common.pojo.${className};
import ${basepackage}.web.controller.${moduleName}.${className}Controller;
import cn.cst.kcgl.common.view.ResultInfo;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;


public class  ${className}ControllerTest extends ${className}ControllerBaseTest {
	
}
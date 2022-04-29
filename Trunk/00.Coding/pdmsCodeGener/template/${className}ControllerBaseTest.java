<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.web.controller.${moduleName};

import java.io.IOException;
import java.math.BigDecimal;

import cn.com.xcs.framework.web.ui.UIPage;
import cn.cst.BaseControllerTest;
import ${basepackage}.common.pojo.${className};
import cn.cst.kcgl.common.view.ResultInfo;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;


public class  ${className}ControllerBaseTest extends BaseControllerTest {
    public MockHttpServletRequest request;
    public MockHttpServletResponse response;
    public MockHttpSession session;
    public ${className}Controller ${classNameLower}Controller;
    public String testId;
    
    @Before
    public void before() throws IOException {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        session = new MockHttpSession();
        request.setCharacterEncoding("UTF-8");
       
        ${classNameLower}Controller = (${className}Controller) this.applicationContext.getBean("${classNameLower}Controller");
        this.findListsByParamsTest();
    }

<#if noparent == "0"||noparent == "2">
    @Test
    @Rollback(value=false)
    public void saveTest() throws IOException {
        /*request.setMethod("POST");
		request.addParameter("username", "aa");
		ModelAndView mav =new ModelAndView();
		request.addParameter("password", "bb");*/
        ${className} ${classNameLower} =new  ${className}();

        ResultInfo resultInfo=${classNameLower}Controller.save(${classNameLower});
        ResultInfo<${className}> ${classNameLower}1 = ${classNameLower}Controller.getById(${classNameLower}.getId());

        Assert.assertNotNull(resultInfo);
        Assert.assertEquals("�����ɹ�",resultInfo.getMessage());
        Assert.assertEquals(1,(int)resultInfo.getStatus());
        Assert.assertNotNull(resultInfo.getData());
        String ${classNameLower}str= (String)resultInfo.getData();
        System.out.println(${classNameLower}str);
    }

</#if>
    @Test
    public void findListsByParamsTest() throws IOException {
        ${className} ${classNameLower} =new  ${className}();
        ResultInfo<UIPage> resultInfo= ${classNameLower}Controller.findListsByParams(1,10,${classNameLower});
        ${className} ${classNameLower}Res;
        if (resultInfo.getData().getRows().size()>0){
            ${classNameLower}Res= (${className})resultInfo.getData().getRows().get(0);
            testId= ${classNameLower}Res.getId();
        }
    }

	@Test
 	public void getByIdTest() throws IOException {
        /*request.setMethod("POST");
		request.addParameter("username", "aa");
		ModelAndView mav =new ModelAndView();
		request.addParameter("password", "bb");*/
        ResultInfo<${className}>  ${classNameLower}Obj=${classNameLower}Controller.getById(testId);

        Assert.assertNotNull(${classNameLower}Obj);
        Assert.assertEquals("�����ɹ�",${classNameLower}Obj.getMessage());
        Assert.assertNotNull(${classNameLower}Obj.getData());
        Assert.assertEquals(1, (int) ${classNameLower}Obj.getStatus());
        ${className} ${classNameLower}1=  ${classNameLower}Obj.getData();
        Assert.assertEquals(testId, ${classNameLower}1.getId());
		System.out.println(${classNameLower}Obj);
	}

<#if noparent == "0"||noparent == "2">
    @Test
    @Rollback(value=false)
    public void updateTest() throws IOException {
        /*request.setMethod("POST");
		request.addParameter("username", "aa");
		ModelAndView mav =new ModelAndView();
		request.addParameter("password", "bb");*/
        ResultInfo<${className}> resultInfo1=${classNameLower}Controller.getById(testId);
        ${className} ${classNameLower} =resultInfo1.getData();

        ResultInfo resultInfo=${classNameLower}Controller.update(${classNameLower});
        Assert.assertNotNull(resultInfo);
        Assert.assertEquals("�����ɹ�",resultInfo.getMessage());
        Assert.assertEquals(1,(int)resultInfo.getStatus());
        Assert.assertNotNull(resultInfo.getData());
        String ${classNameLower}str= (String)resultInfo.getData();
        System.out.println(${classNameLower}str);
    }

    @Test
    @Rollback(value=false)
    public void deleteTest() throws IOException {
        ResultInfo resultInfo= ${classNameLower}Controller.delete(testId);
    }

</#if>
}
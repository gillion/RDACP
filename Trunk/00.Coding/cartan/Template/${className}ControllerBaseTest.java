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
package ${basepackage}.web.controller.${moduleName}.base;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import cn.com.xcs.framework.web.ui.UIPage;
import cn.cst.BaseControllerTest;
import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.web.controller.${moduleName}.${className}Controller;
import cn.ibm.view.ResultInfo;
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
    public <#if priSqlType=="NUMBER">Long<#else>String</#if> testId;
    
    @Before
    public void before() throws IOException {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        session = new MockHttpSession();
        request.setCharacterEncoding("UTF-8");
       
        ${classNameLower}Controller = (${className}Controller) this.applicationContext.getBean("${classNameLower}Controller");
        this.findListsByParamsTest();
    }

<#if noparent == "0"||noparent == "2"||noparent == "3">
    @Test
    @Rollback(value=false)
    public void saveTest() throws IOException {
        /*request.setMethod("POST");
		request.addParameter("username", "aa");
		ModelAndView mav =new ModelAndView();
		request.addParameter("password", "bb");*/
        ${className} ${classNameLower} =new  ${className}();

<#list table.columns as column>
<#if !column.pk>
<#if column.javaType == "String">
        ${classNameLower}.set${column.columnName}("3");
<#elseif column.javaType == "BigDecimal">
<#if column.sqlName == "RECORD_VERSION">
        ${classNameLower}.set${column.columnName}(1);
<#else>
        ${classNameLower}.set${column.columnName}(BigDecimal.valueOf(3));
</#if>
<#elseif column.javaType == "Long">
        ${classNameLower}.set${column.columnName}(3L);
<#elseif column.javaType == "Date">
        ${classNameLower}.set${column.columnName}(stringToDate("2016-01-01"));
<#elseif column.javaType == "Boolean">
        ${classNameLower}.set${column.columnName}(true);
</#if>
</#if>
</#list>
        ResultInfo resultInfo=${classNameLower}Controller.save(${classNameLower});
        ResultInfo<${className}> ${classNameLower}1 = ${classNameLower}Controller.getById(${classNameLower}.getId());

        Assert.assertNotNull(resultInfo);
       // Assert.assertEquals("",resultInfo.getMessage());
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
      //  Assert.assertEquals("",${classNameLower}Obj.getMessage());
        Assert.assertNotNull(${classNameLower}Obj.getData());
        Assert.assertEquals(1, (int) ${classNameLower}Obj.getStatus());
        ${className} ${classNameLower}1=  ${classNameLower}Obj.getData();
        Assert.assertEquals(testId, ${classNameLower}1.getId());
		System.out.println(${classNameLower}Obj);
	}

<#if noparent == "0"||noparent == "2"||noparent == "3">
    @Test
    @Rollback(value=false)
    public void updateTest() throws IOException {
        /*request.setMethod("POST");
		request.addParameter("username", "aa");
		ModelAndView mav =new ModelAndView();
		request.addParameter("password", "bb");*/
        ResultInfo<${className}> resultInfo1=${classNameLower}Controller.getById(testId);
        ${className} ${classNameLower} =resultInfo1.getData();

<#list table.columns as column>
<#if !column.sqlName?starts_with("DEFINE") && !column.pk >
<#if column.javaType == "String">
        ${classNameLower}.set${column.columnName}("3");
<#elseif column.javaType == "BigDecimal">
<#if column.sqlName == "RECORD_VERSION">
        ${classNameLower}.set${column.columnName}(1);
<#else>
        ${classNameLower}.set${column.columnName}(BigDecimal.valueOf(3));
</#if>
<#elseif column.javaType == "Long">
        ${classNameLower}.set${column.columnName}(3L);
<#elseif column.javaType == "Date">
        ${classNameLower}.set${column.columnName}(stringToDate("2016-01-01"));
<#elseif column.javaType == "Boolean">
        ${classNameLower}.set${column.columnName}(true);
</#if>
</#if>
</#list>
        ResultInfo resultInfo=${classNameLower}Controller.update(${classNameLower});
        Assert.assertNotNull(resultInfo);
       // Assert.assertEquals("",resultInfo.getMessage());
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

@Test
@Rollback(value=false)
public void saveBatchTest() throws IOException {
    /*request.setMethod("POST");
    request.addParameter("username", "aa");
    ModelAndView mav =new ModelAndView();
    request.addParameter("password", "bb");*/
    List<${className}> ${classNameLower}List = new ArrayList<${className}>();
    ${className}  ${classNameLower} = new ${className}();
<#list table.columns as column>
<#if !column.pk>
<#if column.javaType == "String">
    ${classNameLower}.set${column.columnName}("3");
<#elseif column.javaType == "BigDecimal">
<#if column.sqlName == "RECORD_VERSION">
    ${classNameLower}.set${column.columnName}(1);
<#else>
    ${classNameLower}.set${column.columnName}(BigDecimal.valueOf(3));
</#if>
<#elseif column.javaType == "Long">
    ${classNameLower}.set${column.columnName}(3L);
<#elseif column.javaType == "Date">
    ${classNameLower}.set${column.columnName}(stringToDate("2016-01-01"));
<#elseif column.javaType == "Boolean">
    ${classNameLower}.set${column.columnName}(true);
</#if>
</#if>
</#list>
    ${classNameLower}List.add(${classNameLower});
    ${className}  ${classNameLower}1= new ${className}();
<#list table.columns as column>
<#if !column.pk>
<#if column.javaType == "String">
    ${classNameLower}1.set${column.columnName}("3");
<#elseif column.javaType == "BigDecimal">
<#if column.sqlName == "RECORD_VERSION">
    ${classNameLower}1.set${column.columnName}(1);
<#else>
    ${classNameLower}1.set${column.columnName}(BigDecimal.valueOf(3));
</#if>
<#elseif column.javaType == "Long">
    ${classNameLower}1.set${column.columnName}(3L);
<#elseif column.javaType == "Date">
    ${classNameLower}1.set${column.columnName}(stringToDate("2016-01-01"));
<#elseif column.javaType == "Boolean">
    ${classNameLower}1.set${column.columnName}(true);
</#if>
</#if>
</#list>
    ${classNameLower}List.add(${classNameLower}1);
    ResultInfo<${className}> resultInfo= ${classNameLower}Controller.saveBatch(${classNameLower}List);
}

@Test
@Rollback(value=false)
public void deleteIdsTest() throws IOException {
        ResultInfo resultInfo= ${classNameLower}Controller.deleteIds(<#if priSqlType=="NUMBER">String.valueOf(testId)<#else>testId</#if>);
}

</#if>
}
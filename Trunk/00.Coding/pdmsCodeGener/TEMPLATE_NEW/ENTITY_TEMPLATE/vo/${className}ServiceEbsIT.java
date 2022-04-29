<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package ${basepackage}.ebs.${classNameLower};

import ${basepackage}.CartanRopClient;
import ${basepackage}.ebs.${classNameLower}.request.*;
import ${basepackage}.ebs.${classNameLower}.response.*;
import com.rop.client.CompositeResponse;
import com.rop.client.RopClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.apache.log4j.Logger;
import com.ridge.util.CodeUtils;

public class ${className}ServiceEbsIT extends UnitilsTestNG {
    <#assign porpNo = 0>
	<#list table.columns as column>
       <#assign porpNo=porpNo+1>
       <#if porpNo==1>
  			<#assign columnlowkey = column.columnNameLower> 
       		<#assign columnkey = column.columnName>     
       		<#assign columnsqlkey = column.sqlName>   		
		</#if>
        <#if column.pk>
			<#assign columnlowkey = column.columnNameLower>  
			<#assign columnkey = column.columnName>   	   
       		<#assign columnsqlkey = column.sqlName>   			   		
		</#if>
	</#list>
    static Logger logger = Logger.getLogger(${className}ServiceEbsIT.class.getName());
    @Test
    public void testGetSession(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ${className}GetSessionRequest ${classNameLower}Request = new ${className}GetSessionRequest();
     	CompositeResponse<${className}GetSessionResponse> response =
                 ropClient.buildClientRequest().get(${classNameLower}Request, ${className}GetSessionResponse.class, "${classNameLower}.getSession", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文!");
        }
     }

    @Test
    public void create${className}(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ${className}CreateRequest ${classNameLower}Request = new ${className}CreateRequest();
    	<#list table.columns as column>
    	<#if column.pk>
    	<#if column.javaType == "String">
    	<#if (column.size==36)>
	   	${classNameLower}Request.set${column.columnName}(CodeUtils.uuid()); 
    	<#else> 
	   	${classNameLower}Request.set${column.columnName}("1");
	   	</#if>
	   	<#elseif column.javaType == "Long" >
	   	${classNameLower}Request.set${column.columnName}("100"); 
	   	</#if>
    	<#else> 
	   	<#if column.javaType == "String">
	   	<#if (column.size==14)>
	   	${classNameLower}Request.set${column.columnName}("20120101120101");
    	<#else> 
	   	${classNameLower}Request.set${column.columnName}("1");
	   	</#if>
	   	<#elseif column.javaType == "BigDecimal" >
	   	${classNameLower}Request.set${column.columnName}("1.1");
	   	<#elseif column.javaType == "Long" >
	   	${classNameLower}Request.set${column.columnName}("1");
	   	<#elseif column.javaType == "Date" >
	   	${classNameLower}Request.set${column.columnName}("2012-01-01");
	   	<#elseif column.javaType == "Boolean" >
	   	${classNameLower}Request.set${column.columnName}("true");    	
	   	</#if>
	   	</#if>
	   	</#list>
        CompositeResponse<${className}CreateResponse> response =
                ropClient.buildClientRequest().get(${classNameLower}Request, ${className}CreateResponse.class, "${classNameLower}.create${className}", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ${className}CreateResponse ${classNameLower}Response = response.getSuccessResponse();
    }

    @Test
    public void delete${className}(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ${className}DeleteRequest ${classNameLower}Request = new ${className}DeleteRequest();
    	<#list table.columns as column>
    	<#if column.pk>
	   	<#if column.javaType == "String">
	   	<#if (column.size==14)>
	   	${classNameLower}Request.set${column.columnName}("20120101120101");
    	<#else> 
	   	${classNameLower}Request.set${column.columnName}("1");
	   	</#if>
	   	<#elseif column.javaType == "BigDecimal" >
	   	${classNameLower}Request.set${column.columnName}("1.1");
	   	<#elseif column.javaType == "Long" >
	   	${classNameLower}Request.set${column.columnName}("1");
	   	<#elseif column.javaType == "Date" >
	   	${classNameLower}Request.set${column.columnName}("2012-01-01");
	   	<#elseif column.javaType == "Boolean" >
	   	${classNameLower}Request.set${column.columnName}("true");    	
	   	</#if>
	   	</#if>
	   	</#list>
        CompositeResponse<${className}DeleteResponse> response =
                ropClient.buildClientRequest().get(${classNameLower}Request, ${className}DeleteResponse.class, "${classNameLower}.delete${className}", "1.0");

        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ${className}DeleteResponse ${classNameLower}Response = response.getSuccessResponse();
    }




    @Test
    public void update${className}(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ${className}UpdateRequest ${classNameLower}Request = new ${className}UpdateRequest();
    	<#list table.columns as column>
	   	<#if column.javaType == "String">
	   	<#if (column.size==14)>
	   	${classNameLower}Request.set${column.columnName}("20120101120101");
    	<#else> 
	   	${classNameLower}Request.set${column.columnName}("1");
	   	</#if>
	   	<#elseif column.javaType == "BigDecimal" >
	   	${classNameLower}Request.set${column.columnName}("1.1");
	   	<#elseif column.javaType == "Long" >
	   	${classNameLower}Request.set${column.columnName}("1");
	   	<#elseif column.javaType == "Date" >
	   	${classNameLower}Request.set${column.columnName}("2012-01-01");
	   	<#elseif column.javaType == "Boolean" >
	   	${classNameLower}Request.set${column.columnName}("true");    	
	   	</#if>
	   	</#list>
        CompositeResponse<${className}UpdateResponse> response =
                ropClient.buildClientRequest().get(${classNameLower}Request, ${className}UpdateResponse.class, "${classNameLower}.update${className}", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ${className}UpdateResponse ${classNameLower}Response = response.getSuccessResponse();
    }


    @Test
    public void get${className}(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ${className}GetRequest ${classNameLower}Request = new ${className}GetRequest();
    	<#list table.columns as column>
    	<#if column.pk>
	   	<#if column.javaType == "String">
	   	<#if (column.size==14)>
	   	${classNameLower}Request.set${column.columnName}("20120101120101");
    	<#else> 
	   	${classNameLower}Request.set${column.columnName}("1");
	   	</#if>
	   	<#elseif column.javaType == "BigDecimal" >
	   	${classNameLower}Request.set${column.columnName}("1");
	   	<#elseif column.javaType == "Long" >
	   	${classNameLower}Request.set${column.columnName}("1");
	   	<#elseif column.javaType == "Date" >
	   	${classNameLower}Request.set${column.columnName}("2012-01-01");
	   	<#elseif column.javaType == "Boolean" >
	   	${classNameLower}Request.set${column.columnName}("true");    	
	   	</#if>
	   	</#if>
	   	</#list>
        CompositeResponse<${className}GetResponse> response =
                ropClient.buildClientRequest().get(${classNameLower}Request, ${className}GetResponse.class, "${classNameLower}.get${className}", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ${className}GetResponse ${classNameLower}Response = response.getSuccessResponse();
    }

    @Test
    public void selectAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ${className}SelectAllRequest ${classNameLower}Request = new ${className}SelectAllRequest();

        CompositeResponse<${className}SelectAllResponse> response =
                ropClient.buildClientRequest().get(${classNameLower}Request, ${className}SelectAllResponse.class, "${classNameLower}.selectAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ${className}SelectAllResponse ${classNameLower}Response = response.getSuccessResponse();
    }

    @Test
    public void countAll(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ${className}CountAllRequest ${classNameLower}Request = new ${className}CountAllRequest();

        CompositeResponse<${className}CountAllResponse> response =
                ropClient.buildClientRequest().get(${classNameLower}Request, ${className}CountAllResponse.class, "${classNameLower}.countAll", "1.0");
        Assert.assertTrue(response.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ${className}CountAllResponse ${classNameLower}Response = response.getSuccessResponse();
        Assert.assertNotNull(${classNameLower}Response.getResultString());
    }

    @Test
    public void select${className}(){
        RopClient ropClient = CartanRopClient.getRopClient();
        ${className}SelectRequest ${classNameLower}Request = new ${className}SelectRequest();
    	<#list table.columns as column>
	   	<#if column.javaType == "String">
	   	<#if (column.size==14)>
	   	${classNameLower}Request.set${column.columnName}("20120101120101");
    	<#else> 
	   	${classNameLower}Request.set${column.columnName}("1");
	   	</#if>
	   	<#elseif column.javaType == "BigDecimal" >
	   	${classNameLower}Request.set${column.columnName}("1.1");
	   	<#elseif column.javaType == "Long" >
	   	${classNameLower}Request.set${column.columnName}("1");
	   	<#elseif column.javaType == "Date" >
	   	${classNameLower}Request.set${column.columnName}("2012-01-01");
	   	<#elseif column.javaType == "Boolean" >
	   	${classNameLower}Request.set${column.columnName}("true");    	
	   	</#if>
	   	</#list>
        CompositeResponse<${className}CreateResponse> response =
                ropClient.buildClientRequest().get(${classNameLower}Request, ${className}CreateResponse.class, "${classNameLower}.create${className}", "1.0");
        Assert.assertTrue(response.isSuccessful());
    	<#list table.columns as column>
	   	<#if column.javaType == "String">
	   	<#if (column.size==14)>
	   	${classNameLower}Request.set${column.columnName}("20120101120101");
    	<#else> 
	   	${classNameLower}Request.set${column.columnName}("1");
	   	</#if>	   	
	   	<#elseif column.javaType == "BigDecimal" >
	   	${classNameLower}Request.set${column.columnName}("1");
	   	<#elseif column.javaType == "Long" >
	   	${classNameLower}Request.set${column.columnName}("1");
	   	<#elseif column.javaType == "Date" >
	   	${classNameLower}Request.set${column.columnName}("2012-01-01");
	   	<#elseif column.javaType == "Boolean" >
	   	${classNameLower}Request.set${column.columnName}("true");    	
	   	</#if>
	   	</#list>
        CompositeResponse<${className}SelectResponse> response1 =
                ropClient.buildClientRequest().get(${classNameLower}Request, ${className}SelectResponse.class, "${classNameLower}.select${className}", "1.0");
        Assert.assertTrue(response1.isSuccessful());
        if (logger.isDebugEnabled()){
            if(response.isSuccessful())
                logger.debug("成功返回报文！");
        }
        ${className}SelectResponse ${classNameLower}Response = response1.getSuccessResponse();
        Assert.assertNotNull(${classNameLower}Response.getResultJson());
        CompositeResponse<${className}DeleteResponse> response2 =
                ropClient.buildClientRequest().get(${classNameLower}Request, ${className}DeleteResponse.class, "${classNameLower}.delete${className}", "1.0");

    }
}

<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage};
import ${basepackage}.${classNameLower}.dao.${className}Mapper;
import ${basepackage}.${classNameLower}.domain.${className};
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;
import java.util.ArrayList;
import static org.testng.Assert.*;

@SpringApplicationContext({"spring/applicationContext-core.xml"})
public class ${className}DaoTest extends BaseTest{
    static Logger logger = Logger.getLogger(${className}DaoTest.class.getName());
	@SpringBeanByType
	private SqlSessionTemplate sqlSessionTemplate;

    @Test
    @DataSet
    public void ${className}DaoTest() throws Exception {
    	${className}Mapper ${classNameLower}Mapper=sqlSessionTemplate.getMapper(${className}Mapper.class);
        if(logger.isDebugEnabled()){
            logger.debug("1、新增记录：");
        }
    	${className} ${classNameLower}=new ${className}();
    	<#list table.columns as column>        
    	if(logger.isDebugEnabled()){
            logger.debug("${column.columnAlias}：3");
        }
    	<#if column.javaType == "String">
    	${classNameLower}.set${column.columnName}("3");
    	<#elseif column.javaType == "BigDecimal" >
    	${classNameLower}.set${column.columnName}(3);
    	<#elseif column.javaType == "Long" >
    	${classNameLower}.set${column.columnName}(3L);
    	<#elseif column.javaType == "Date" >
    	${classNameLower}.set${column.columnName}(stringToDate("2012-01-01"));
    	<#elseif column.javaType == "Boolean" >
    	${classNameLower}.set${column.columnName}(true);    	
    	</#if>
    	</#list>
    	${classNameLower}Mapper.create${className}(${classNameLower});
    	assertNotNull(${classNameLower}Mapper.get${className}("3"));
        if (logger.isDebugEnabled()){
            logger.debug("验证新增记录已存在!");
        }
        if(logger.isDebugEnabled()){
            logger.debug("2、变更记录为：");
        }
    	${classNameLower}=new ${className}();
    	<#list table.columns as column>
    	<#if column.pk>
        if(logger.isDebugEnabled()){
            logger.debug("${column.columnAlias}（主键）2：");
        }
    	<#if column.javaType == "String">
    	${classNameLower}.set${column.columnName}("2");
    	<#elseif column.javaType == "BigDecimal" >
    	${classNameLower}.set${column.columnName}(2);   	
    	</#if>    	
    	<#else>
        if(logger.isDebugEnabled()){
            logger.debug("${column.columnAlias}：3");
        }
    	<#if column.javaType == "String">
    	${classNameLower}.set${column.columnName}("3");
    	<#elseif column.javaType == "BigDecimal" >
    	${classNameLower}.set${column.columnName}(3);
    	<#elseif column.javaType == "Long" >
    	${classNameLower}.set${column.columnName}(3L);
    	<#elseif column.javaType == "Date" >
    	${classNameLower}.set${column.columnName}(stringToDate("2012-01-01"));
    	<#elseif column.javaType == "Boolean" >
    	${classNameLower}.set${column.columnName}(true);    	
    	</#if>
    	</#if>
    	</#list>
    	${classNameLower}Mapper.update${className}(${classNameLower});
    	assertNotNull(${classNameLower}Mapper.get${className}("2"));   
        if (logger.isDebugEnabled()){
            logger.debug("变更记录成功!");
        }

    	assertTrue(${classNameLower}Mapper.countAll()>0);
        if(logger.isDebugEnabled()){
            logger.debug("3、获取记录数大于零");
        }        
        if(logger.isDebugEnabled()){
            logger.debug("4、获取列表：");
        }
        ArrayList<${className}> ${classNameLower}s = ${classNameLower}Mapper.selectAll();
    	assertTrue(${classNameLower}s.size()>0);   
        if(logger.isDebugEnabled()){
            logger.debug("获取列表成功");
        }
        if(logger.isDebugEnabled()){
            logger.debug("5、根据条件查询列表：");
        }
        ${classNameLower}=new ${className}();
        <#list table.columns as column>
    	<#if column.javaType == "String">
    	${classNameLower}.set${column.columnName}("3");   	
    	</#if>
    	</#list>
        ArrayList<${className}> list=${classNameLower}Mapper.selectWithCondition(${classNameLower},"");
        <#list table.columns as column>
        assertEquals("3", list.get(0).get${column.columnName}());
    	</#list>
        if(logger.isDebugEnabled()){
            logger.debug("根据条件查询成功");
        }
        if(logger.isDebugEnabled()){
            logger.debug("6、删除记录：");
        }
    	${classNameLower}Mapper.delete${className}("3");
    	assertNull(${classNameLower}Mapper.get${className}("3"));  
        if(logger.isDebugEnabled()){
            logger.debug("删除记录成功");
        }
        
    }
}

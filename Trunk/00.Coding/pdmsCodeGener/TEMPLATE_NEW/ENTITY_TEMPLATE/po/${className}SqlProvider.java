<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign leftbit = "#{">   
<#assign rightbit = "}">   
/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package ${basepackage}.${classNameLower}.dao;

import ${basepackage}.${classNameLower}.domain.${className};
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class ${className}SqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from ${databaseName}.${table.sqlName} where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        ${className} ${classNameLower}=new ${className}();
        ${classNameLower}=(${className})parameter.get("${classNameLower}");

    	<#list table.columns as column>
    	<#if column.javaType == "String">
    		<#if column.pk>
        if(StringUtils.isNotBlank(${classNameLower}.get${column.columnName}())){
        	conditionsStr.append(" and ${column.sqlName} = ${leftbit}${classNameLower}.${column.sqlName}${rightbit} ");
        }    		
	    	<#elseif (column.size==14)>
        if(StringUtils.isNotBlank(${classNameLower}.get${column.columnName}())){
        	conditionsStr.append(" and ${column.sqlName} = ${leftbit}${classNameLower}.${column.sqlName}${rightbit} ");
        }
	    	<#elseif (column.size==8)>
        if(StringUtils.isNotBlank(${classNameLower}.get${column.columnName}())){
        	conditionsStr.append(" and ${column.sqlName} = ${leftbit}${classNameLower}.${column.sqlName}${rightbit} ");
        }	    	
	    	<#else>	    	
    			<#if (column.size>3)>
        if(StringUtils.isNotBlank(${classNameLower}.get${column.columnName}())){
        	conditionsStr.append(" and ${column.sqlName} like  CONCAT('%',${leftbit}${classNameLower}.${column.sqlName}${rightbit},'%')");
        }
		        <#else>
        if(StringUtils.isNotBlank(${classNameLower}.get${column.columnName}())){
        	conditionsStr.append(" and ${column.sqlName} = ${leftbit}${classNameLower}.${column.sqlName}${rightbit} ");
        }
		        </#if>
		    </#if>
	    </#if>
    	</#list>
        return  conditionsStr.toString();
    }
}



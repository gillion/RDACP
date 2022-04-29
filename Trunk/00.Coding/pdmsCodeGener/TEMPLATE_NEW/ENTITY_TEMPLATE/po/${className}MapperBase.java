<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign leftbit = "#{">   
<#assign rightbit = "}">   
package ${basepackage}.${classNameLower}.dao;

import ${basepackage}.${classNameLower}.domain.${className};
import ${basepackage}.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface ${className}MapperBase {
    <#assign porpNo = 0>
	<#list table.columns as column>
       <#assign porpNo=porpNo+1>
       <#if porpNo==1>
       		<#assign columnkey = column.columnNameLower>     
       		<#assign columnsqlkey = column.sqlName>   		
		</#if>
        <#if column.pk>
			<#assign columnkey = column.columnNameLower>   	   
       		<#assign columnsqlkey = column.sqlName>   			   		
		</#if>
	</#list>
	@Select("SELECT * FROM ${databaseName}.${table.sqlName} s WHERE s.${columnsqlkey} = ${leftbit}${columnkey}${rightbit}")
	${className} get${className}(String ${columnkey});
	
	@Insert("INSERT INTO ${databaseName}.${table.sqlName}(<#assign porpNo = 0><#list table.columns as column><#assign porpNo=porpNo+1><#if porpNo==1>${column.sqlName}<#else>,${column.sqlName}</#if></#list>) VALUES(<#assign porpNo = 0><#list table.columns as column><#assign porpNo=porpNo+1><#if porpNo == 1>${leftbit}${column.columnNameLower}${rightbit}<#else>,${leftbit}${column.columnNameLower}${rightbit}</#if></#list>)")
    void create${className}(${className} ${classNameLower});
    
    @Delete("DELETE FROM ${databaseName}.${table.sqlName} WHERE ${columnsqlkey} = ${leftbit}${columnkey}${rightbit}")
    void delete${className}(String ${columnkey});

    @Update("update ${databaseName}.${table.sqlName} set <#assign porpNo = 0><#list table.columns as column><#if !(columnkey = column.columnNameLower)><#assign porpNo=porpNo+1><#if porpNo==1>${column.sqlName}=${leftbit}${column.columnNameLower}${rightbit}<#else>,${column.sqlName}=${leftbit}${column.columnNameLower}${rightbit}</#if></#if></#list> where ${columnsqlkey} = ${leftbit}${columnkey}${rightbit}")
    void update${className}(${className} ${classNameLower});

    @Select("select count(*) c from ${databaseName}.${table.sqlName}")
    int countAll();
    
    @Select("select * from ${databaseName}.${table.sqlName} order by ${columnsqlkey} asc")
    ArrayList<${className}> selectAll();
    
    @SelectProvider(type = ${className}SqlProvider.class, method = "getSql")
    ArrayList<${className}> selectWithCondition(@Param("${classNameLower}") ${className} ${classNameLower},@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<${className}> selectBySql(@Param("SqlStr") String SqlStr);
}


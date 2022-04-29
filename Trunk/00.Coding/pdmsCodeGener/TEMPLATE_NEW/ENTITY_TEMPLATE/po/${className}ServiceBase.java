<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${classNameLower}.service;

import com.cartan.core.BaseService;
import ${basepackage}.${classNameLower}.dao.${className}Mapper;
import ${basepackage}.${classNameLower}.domain.${className};
import org.springframework.beans.factory.annotation.Autowired;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ${className}ServiceBase extends BaseService {
    private ${className}Mapper ${classNameLower}Mapper;
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
    public ${className} get${className}(String ${columnkey}){
        return ${classNameLower}Mapper.get${className}(${columnkey});
    }

    public void create${className}(${className} ${classNameLower}){
    	${classNameLower}Mapper.create${className}(${classNameLower});
    }

    public void delete${className}(String ${columnkey}){
    	${classNameLower}Mapper.delete${className}(${columnkey});
    }

    public void update${className}(${className} ${classNameLower}){
    	${classNameLower}Mapper.update${className}(${classNameLower});
    }

    public int countAll(){
       return ${classNameLower}Mapper.countAll();
    }

    public ArrayList<${className}> selectAll(){
      return ${classNameLower}Mapper.selectAll();
    }
    
    public ${className}Mapper get${className}Mapper() {
    	if(this.${classNameLower}Mapper == null){
            this.${classNameLower}Mapper = this.getSqlSessionTemplate().getMapper(${className}Mapper.class);
        }
        return this.${classNameLower}Mapper;
    }
        
    public void set${className}Mapper(${className}Mapper ${classNameLower}Mapper) {
        this.${classNameLower}Mapper = ${classNameLower}Mapper;
    }
    
    @Override
    protected void initMappers(SqlSessionTemplate sqlSessionTemplate) {
         this.${classNameLower}Mapper = sqlSessionTemplate.getMapper(${className}Mapper.class);
    }
        
    /** 
     * 按条件查询
     * @param ${classNameLower}
     * @return
     */
    public ArrayList<${className}> selectWithCondition(${className} ${classNameLower}){
        return  ${classNameLower}Mapper.selectWithCondition(${classNameLower},"");
    }

    /** 按条件查询
     * @param ${classNameLower}
     * @conditions
     * @return
     */
    public ArrayList<${className}> selectWithCondition(${className} ${classNameLower},String conditions){
        return  ${classNameLower}Mapper.selectWithCondition(${classNameLower},conditions);
    }
    
    /** 按SQL语句查询
     * @param SqlStr
     * @return
     */
    public ArrayList<${className}> selectBySql(String SqlStr){
        return  ${classNameLower}Mapper.selectBySql(SqlStr);
    }
}
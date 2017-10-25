<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign bigger = "&gt;">
<#assign smaller = "&lt;">
<#assign leftbit = "#{">
<#assign rightbit = "}">
<#assign leftsit = "#{">
<#assign rightsit = "}">
<#assign leftbracket = "#{">
<#assign rightbracket = "}">
<#assign prikey = "ID">
<#assign pricolumn = "id">
<#assign priSqlType = "Long">
<#assign prijavaType = "Long">
<#assign firstprikey = "ID">
<#assign firstpricolumn = "id">
<#assign firstpriSqlType = "Long">
<#assign firstprijavaType = "Long">
<#assign isHasKey = 0>
<#assign keycount = 0>
<#list table.columns as column>
<#assign keycount = keycount+1>
<#if keycount==1>
<#assign firstpricolumn = column.columnName?uncap_first>
<#assign firstprikey = column.sqlName>
<#assign firstpriSqlType = column.sqlTypeName>
<#assign firstprijavaType = column.sqlTypeName>
</#if>
<#if column.pk>
<#assign pricolumn = column.columnName?uncap_first>
<#assign prikey = column.sqlName>
<#assign priSqlType = column.sqlTypeName>
<#assign prijavaType = column.javaType>
<#assign isHasKey = 1>
</#if>	
</#list>
package ${basepackage}.common.dao.${moduleName}.impl.base;

import cn.com.xcs.framework.persist.Page;

import cn.ibm.dao.impl.BaseDaoImpl;

import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.common.dao.${moduleName}.base.${className}DaoIBBase;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ibm.view.PageVO;
import cn.ibm.view.PagedResult;
import cn.ibm.view.ConditionVO;
import java.math.BigDecimal;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ${className}DaoImplIBBase extends BaseDaoImpl<${className},String> implements ${className}DaoIBBase{

	<#if isHasKey==1>
	public ${className} selectById(@Param("${pricolumn}"<#if priSqlType=="VARCHAR2"||priSqlType=="NVARCHAR2"||priSqlType=="CHAR">String<#else>Long</#if> ${pricolumn});
	<#else>
	public ${className} selectById(@Param("${firstpricolumn}" Long ${firstpricolumn});
	</#if>

	List<${className}>findByIds(List<<#if isHasKey==1><#if priSqlType=="VARCHAR2"||priSqlType=="NVARCHAR2"||priSqlType=="CHAR">String<#else>Long</#if><#else>Long</#if>> ids);

	List<${className}>find(@Param("conditions") List<ConditionVO> conditions);

	List<${className}>findByPage(@Param("pageVO") PageVO pageVO,@Param("conditions") List<ConditionVO> conditions);

	public int insert(@Param("${classNameLower}") ${className} ${classNameLower});

	public int update(@Param("${classNameLower}") ${className} ${classNameLower});

	public int delete(@Param("${classNameLower}") ${className} ${classNameLower});

	<#if isHasKey==1>
	public int deleteById(@Param("${pricolumn}"<#if priSqlType=="VARCHAR2"||priSqlType=="NVARCHAR2"||priSqlType=="CHAR">String<#else>Long</#if> ${pricolumn});
	<#else>
	public int deleteById(@Param("${firstpricolumn}" Long ${firstpricolumn});
	</#if>
	public int findByEntityCount(@Param("conditions") List<ConditionVO> conditions);

	public int getSequence();

	public int deleteByCond(@Param("conditions") List<ConditionVO> conditions);

	List<${className}>findSumByCond(@Param("groupfields") List<ConditionVO> groupfields,@Param("conditions") List<ConditionVO> conditions);

	public PagedResult<${className}> findPageByCondOrder(@Param("pageVO") PageVO pageVO,@Param("conditions") List<ConditionVO> conditions);

	public int findPageByCondOrderCount(@Param("pageVO") PageVO pageVO,@Param("conditions") List<ConditionVO> conditions);

	List<${className}> findSameByCond(@Param("samefields") List<ConditionVO> samefields,@Param("conditions") List<ConditionVO> conditions);

	List<${className}> findSumOrAvgInfo(@Param("conditions") List<ConditionVO> conditions);

	int batchDelete(@Param("voList") List<${className}> voList);

	List<${className}> findInstanceListInfo(@Param("${classNameLower}") ${className} ${classNameLower});

    /**
     * 根据ID获取对象
     * @param id  主键id
     * @return
     */
    public ${className} get${className}ById(<#if priSqlType=="NUMBER">Long<#else>String</#if> id){
    	Map<String,<#if priSqlType=="NUMBER">Long<#else>String</#if>> params=new HashMap<String,<#if priSqlType=="NUMBER">Long<#else>String</#if>>();
        params.put("id", id);
       return (${className}) this.queryOneBySql("${basepackage}.common.mapper.${moduleName}.${className}Mapper.get${className}ById",params);
    }

    /**
     * 分页查询${table.tableAlias}对象
     * @param page
     * @return
     */
    public Page get${className}Page(Page page,${className} ${classNameLower}){
    	<@generate/>
        return this.queryForPage("${basepackage}.common.mapper.${moduleName}.${className}Mapper.get${className}Page",params,page);
    }

    /**
     * 列表查询${table.tableAlias}对象
     * @param
     * @return
     */
    public List<${className}> get${className}List(${className} ${classNameLower}){
    	<@generate/>
        return (List<${className}>) this.queryBySql("${basepackage}.common.mapper.${moduleName}.${className}Mapper.get${className}Page",params);
    }

    <#if noparent == "0"||noparent == "2">
    /**
     * 根据ID删除对象
     * @param id  主键id
     */
    public int delete${className}ById(<#if priSqlType=="NUMBER">Long<#else>String</#if> id){
    	Map<String,<#if priSqlType=="NUMBER">Long<#else>String</#if>> params=new HashMap<String,<#if priSqlType=="NUMBER">Long<#else>String</#if>>();
        params.put("id", id);
        return this.deleteBySql("${basepackage}.common.mapper.${moduleName}.${className}Mapper.delete${className}ById",params);
    }

    /**
     * 新增${table.tableAlias}
     * @param ${classNameLower}   ${table.tableAlias}对象
     */
    public void save${className}(${className} ${classNameLower}){
    	<@generate/>
        this.createBySql("${basepackage}.common.mapper.${moduleName}.${className}Mapper.save${className}",params);
    }

    /**
     * 更新${table.tableAlias}
     * @param ${classNameLower}     ${table.tableAlias}对象
     * @return
     */
    public int update${className}(${className} ${classNameLower}){
        <@generateUpdate/>
        return this.updateBySql("${basepackage}.common.mapper.${moduleName}.${className}Mapper.update${className}",params);
    }
    </#if>
}
<#macro generate>
		Map<String,Object> params = new HashMap<String,Object>();
<#list table.columns as column>
		params.put("${column.columnName?uncap_first}",${classNameLower}.get${column.columnName}());//${column.columnAlias}
</#list>
</#macro>
<#macro generateUpdate>
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("id", ${classNameLower}.getId());
			
<#list table.columns as column>
		<#if !column.pk>
		if(null == ${classNameLower}.get${column.columnName}()){
			<#if column.javaType == "String">
			params.put("${column.columnName?uncap_first}", "");//${column.columnAlias}
			<#else>
			params.put("${column.columnName?uncap_first}", 0);//${column.columnAlias}
			</#if>
		}else{
			params.put("${column.columnName?uncap_first}",${classNameLower}.get${column.columnName}());//${column.columnAlias}
		}
		</#if>
</#list>
</#macro>

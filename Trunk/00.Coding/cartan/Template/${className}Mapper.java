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
package ${basepackage}.common.mapper.${moduleName};

import cn.com.xcs.framework.persist.Page;

import cn.ibm.dao.BaseDao;
import ${basepackage}.common.dao.${moduleName}.base.${className}DaoIBBase;
import ${basepackage}.common.pojo.${moduleName}.${className};

import java.util.List;

import org.apache.ibatis.annotations.Param;
import cn.ibm.view.PageVO;
import cn.ibm.view.PageResult;
import cn.ibm.view.ConditionVO;
import java.math.BigDecimal;

/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public interface ${className}Mapper extends ${className}DaoIBBase{

<#if isHasKey==1>
public ${className} selectById(@Param("${pricolumn}")<#if priSqlType=="VARCHAR2"||priSqlType=="NVARCHAR2"||priSqlType=="CHAR">String<#else>Long</#if> ${pricolumn});
<#else>
public ${className} selectById(@Param("${firstpricolumn}") Long ${firstpricolumn});
</#if>

List<${className}>findByIds(List<<#if isHasKey==1><#if priSqlType=="VARCHAR2"||priSqlType=="NVARCHAR2"||priSqlType=="CHAR">String<#else>Long</#if><#else>Long</#if>> ids);

List<${className}>find(@Param("conditions") List<ConditionVO> conditions);

List<${className}>findByPage(@Param("pageVO") PageVO pageVO,@Param("conditions") List<ConditionVO> conditions);

public int insert(@Param("${classNameLower}") ${className} ${classNameLower});

public int update(@Param("${classNameLower}") ${className} ${classNameLower});

<#if isHasKey==1>
public int deleteById(@Param("${pricolumn}") <#if priSqlType=="VARCHAR2"||priSqlType=="NVARCHAR2"||priSqlType=="CHAR">String<#else>Long</#if> ${pricolumn});
<#else>
public int deleteById(@Param("${firstpricolumn}") Long ${firstpricolumn});
</#if>
public int findByEntityCount(@Param("conditions") List<ConditionVO> conditions);

public int getSequence();

public int deleteByCond(@Param("conditions") List<ConditionVO> conditions);

List<${className}>findSumByCond(@Param("groupfields") List<ConditionVO> groupfields,@Param("conditions") List<ConditionVO> conditions);

public PageResult<${className}> findPageByCondOrder(@Param("pageVO") PageVO pageVO,@Param("conditions") List<ConditionVO> conditions);

public int findPageByCondOrderCount(@Param("pageVO") PageVO pageVO,@Param("conditions") List<ConditionVO> conditions);

List<${className}> findSameByCond(@Param("samefields") List<ConditionVO> samefields,@Param("conditions") List<ConditionVO> conditions);

List<${className}> findSumOrAvgInfo(@Param("conditions") List<ConditionVO> conditions);

int batchDelete(@Param("voList") List<${className}> voList);

List<${className}> findInstanceListInfo(@Param("${classNameLower}") ${className} ${classNameLower});

}

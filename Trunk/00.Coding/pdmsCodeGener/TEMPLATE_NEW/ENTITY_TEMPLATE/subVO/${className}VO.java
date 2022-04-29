<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign strArray = ("STRING_H01,STRING_H02,STRING_H03,STRING_H04,STRING_H05,STRING_H06,STRING_H07,STRING_H08,STRING_H09,STRING_H10,STRING_H11,STRING_H12,STRING_H13,STRING_H14,STRING_H15,STRING_H16,STRING_H17,STRING_H18,STRING_H19,STRING_H20"?split(","))>
<#assign longArray = ("NUM_N01,NUM_N02,NUM_N03,NUM_N04,NUM_N05,NUM_N06,NUM_N07,NUM_N08,NUM_N09,NUM_N10,NUM_N11,NUM_N12,NUM_N13,NUM_N14,NUM_N15"?split(","))>
<#assign numerArray = ("NUM_D01,NUM_D02,NUM_D03,NUM_D04,NUM_D05,NUM_D06,NUM_D07,NUM_D08,NUM_D09,NUM_D10"?split(","))>
<#assign dateArray = ("DATETIME01,DATETIME02,DATETIME03,DATETIME04,DATETIME05"?split(","))>
package ${basepackage}.data.vo.${moduleName};
import ${basepackage}.data.bo.${moduleName}.${className};
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.beans.BeanUtils;
import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fkframe.persist.po.TempOrder;

/**
 * ${table.tableAlias}
 *
 */
@Entity
@Table(name = "TEMP_ORDER")
public class ${className}VO extends TempOrder{
	private static final long serialVersionUID = 1L;
	/////////////////////////////////SQL 映射语句///////////////////
	public static final String QUERY_SQL = "select obj.* from ${table.sqlName} obj" ;
	
	//属性
	<@generateFields/>
	
	// 这里补充页面需要关联显示的属性

	///////////////////////////getter and setter////////////////////////////
	<@generatePkProperties/>
	<@generateNoPkProperties/>
	

	<#macro generateFields>
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	<#if column.sqlName == "DETAIL_ID" || column.sqlName == "ORDER_ID" >
	<#elseif column.sqlName == "STATE">
	private ${column.javaType} ${column.columnNameLower} = "0";
	<#else>
	private ${column.javaType} ${column.columnNameLower};//${column.columnAlias}
	</#if>
	</#if>
	</#list>
	</#macro>
	
	
	<#macro generatePkProperties>
	<#list table.columns as column>
	<#if column.pk && column.sqlName != "DETAIL_ID">
	@Transient
	public ${column.javaType} get${column.columnName}() {
		this.${column.columnNameLower} = super.getDetailId();
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		super.setDetailId(value);
		this.${column.columnNameLower} = value;
	}
		
	<#elseif (column.sqlName == foreignKey?upper_case) && column.sqlName != "ORDER_ID">
	@Transient
	public ${column.javaType} get${column.columnName}() {
		this.${column.columnNameLower}=super.getOrderId();
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		super.setOrderId(value);
		this.${column.columnNameLower} = value;
	}
	</#if>
	</#list>
	</#macro>
	
	
	<#macro generateNoPkProperties>
	<#assign strIndex = 0>
	<#assign longIndex = 0>
	<#assign numberIndex = 0>
	<#assign dateIndex = 0>
	
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	<#if (!column.pk) &&(column.sqlName != foreignKey?upper_case)&&(column.sqlName != "DETAIL_ID" && column.sqlName != "ORDER_ID")>
	<#if column.javaType == "String">
	@Column(name = "${strArray[strIndex]}", unique = ${column.unique?string}, nullable = ${column.nullable?string},length = ${column.size})
	<#assign strIndex = strIndex+1>
	<#elseif column.javaType == "Long">
	@Column(name = "${longArray[longIndex]}", unique = ${column.unique?string}, nullable = ${column.nullable?string},length = ${column.size})
	<#assign longIndex = longIndex+1>
	<#elseif column.javaType == "BigDecimal">
	@Column(name = "${numerArray[numberIndex]}", precision=${column.size},scale = ${column.decimalDigits},unique = ${column.unique?string}, nullable = ${column.nullable?string})
	<#assign numberIndex = numberIndex+1>
	<#elseif column.javaType == "Date">
	@Column(name = "${dateArray[dateIndex]}", unique = ${column.unique?string}, nullable = ${column.nullable?string})
	<#assign dateIndex = dateIndex+1>
	</#if>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	</#if>
	</#if>
	</#list>
	</#macro>
	///////////////////////////////////////////////////////
	public static final String DETAIL_TYPE="${className}";
	public ${className}VO(){
		this.setDetailType(DETAIL_TYPE);
	}
	public ${className}VO(${className} ${classNameLower}){
		BeanUtils.copyProperties(${classNameLower},this);
		this.setDetailType(DETAIL_TYPE);
	}
	
	
	public void copyValueTo(${className} bo){
		BeanUtils.copyProperties(this,bo);
	}
	
	public ${className} cloneBO(){
		${className} bo = new ${className}();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<${className}> cloneBOList(List<${className}VO> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<${className}>(0);
		List<${className}> result = new ArrayList<${className}>(vos.size());
		for(${className}VO vo: vos){
			${className} bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}
}
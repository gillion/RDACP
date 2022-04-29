<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.data.vo.${moduleName};
import ${basepackage}.data.bo.${moduleName}.${className};
import org.springframework.beans.BeanUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

/**
 * ${table.tableAlias}
 *
 */
public class ${className}VO implements Serializable{
	private static final long serialVersionUID = 1L;
	/////////////////////////////////SQL 映射语句///////////////////
	public static final String QUERY_SQL = "select obj.* from ${table.sqlName} obj" ;
	
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	<#if column.sqlName == "STATE">
	private ${column.javaType} ${column.columnNameLower} = "0";
	<#else>
	private ${column.javaType} ${column.columnNameLower};//${column.columnAlias}
	</#if>
	</#if>
	</#list>
	
	//这里补充页面需要关联显示的属性
	
	/////////////////////////getter and setter //////////////////////////
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	</#if>
	</#list>
	
	
	//////////////////////////////////////////////////////
	public ${className}VO(){}

	public ${className}VO(${className} ${classNameLower}){
		BeanUtils.copyProperties(${classNameLower},this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
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
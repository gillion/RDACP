<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package ${basepackage}.ebs.${classNameLower}.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.${classNameLower}.domain.${className};
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class ${className}SelectRequest extends AbstractRopRequest {
	<@generateFields/>

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    private String sid;//SessionId
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	<@generatePkProperties/>
	<@generateNotPkProperties/>
	
	public ${className}SelectRequest(){}
	
	public ${className}SelectRequest(${className} ${classNameLower}){
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
	
	public static List<${className}> cloneBOList(List<${className}SelectRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<${className}>(0);
		List<${className}> result = new ArrayList<${className}>(vos.size());
		for(${className}SelectRequest vo: vos){
			${className} bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}

<#macro generateFields>
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	private String ${column.columnNameLower};//${column.columnAlias}
	</#if>	
	<#if column.javaType == "String">
	<#if (column.size==14)>
		<#if !column.sqlName?starts_with("DEFINE")>
	private String ${column.columnNameLower}End;//${column.columnAlias}
		</#if>
	</#if>
	</#if>	
	</#list>
</#macro>


<#macro generateConstructor>
	public ${className}(){}
</#macro>

<#macro generatePkProperties>
	<#list table.columns as column>
	<#if column.pk>
	public String get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(String ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	
	</#if>
	</#list>
</#macro>



<#macro generateNotPkProperties>
	<#list table.columns as column>
	<#if !column.sqlName?starts_with("DEFINE")>
	<#if !column.pk>

	public String get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(String ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	<#if column.javaType == "String">
	<#if (column.size==14)>
	public String get${column.columnName}End() {
		return this.${column.columnNameLower}End;
	}
	
	public void set${column.columnName}End(String ${column.columnNameLower}End) {
		this.${column.columnNameLower}End = ${column.columnNameLower}End;
	}
	</#if>
	</#if>
	
	
	</#if>
	</#if>
	</#list>
</#macro>
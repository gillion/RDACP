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
import javax.xml.bind.annotation.XmlAttribute;

public class ${className}UpdateRequest extends AbstractRopRequest {

    @XmlAttribute
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
	<@generateFields/>
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	<@generatePkProperties/>
	<@generateNotPkProperties/>
	
	public ${className}UpdateRequest(){}
	
	public ${className}UpdateRequest(${className} ${classNameLower}){
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
	
	public static List<${className}> cloneBOList(List<${className}UpdateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<${className}>(0);
		List<${className}> result = new ArrayList<${className}>(vos.size());
		for(${className}UpdateRequest vo: vos){
			${className} bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}

<#macro generateFields>
	<#list table.columns as column>
	<#if !column.pk>
	<#if !column.nullable>
	@NotEmpty
	</#if>	
	</#if>	
	<#if column.javaType == "String">
	<#if (column.size==14)>
	@Pattern(regexp = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})([-\\/\\._]{0,1})(((0[13578]|1[02])([-\\/\\._]{0,1})(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)([-\\/\\._]{0,1})(0[1-9]|[12][0-9]|30))|(02([-\\/\\._]{0,1})(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))([-\\/\\._]{0,1})02([-\\/\\._]{0,1})29))\\s{0,1}(([01][0-9]|2[0-3])\\:{0,1}([0-5][0-9])\\:{0,1}([0-5][0-9]))$")
	@Size(min = 0, max = 14)		
	<#else>
	<#if !column.pk>
	</#if>
	@Size(min = 0, max = ${column.size})
	</#if>
	<#elseif column.javaType == "BigDecimal" >
	@Pattern(regexp = "^(\\-|\\+)?[\\d]{1,10}\\.[\\d]{1,10}$")
	<#elseif column.javaType == "Long">
	@Pattern(regexp = "^(\\+|-)?\\d+$")
	</#if>
	<#if !column.sqlName?starts_with("DEFINE")>
	private String ${column.columnNameLower};//${column.columnAlias}
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
	</#if>
	</#if>
	</#list>
</#macro>
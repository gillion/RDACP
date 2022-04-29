<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.pojo;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigDecimal;
<#if inherittable!=''>
import ${basepackage}.common.pojo.${inherittable}Base;
<#else>
import ${basepackage}.common.pojo.${className}Base;
</#if>
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 16-7-12
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="${table.sqlName}")
<#if inherittable!=''>
public class ${className} extends ${inherittable}Base {
<#else>
public class ${className} extends ${className}Base{
</#if>
    /** default constructor */
    public ${className}(){

    }
}
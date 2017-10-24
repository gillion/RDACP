<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.pojo.${moduleName};
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigDecimal;
import ${basepackage}.common.pojo.${moduleName}.base.${className}Base;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
/**
 * tableName: ${table.tableAlias}
 * Created with IntelliJ IDEA.
 * User: node
 * Date: 16-7-12
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="${table.sqlName}")
public class ${className} extends ${className}Base{
    /** default constructor */
    public ${className}(){

    }
}
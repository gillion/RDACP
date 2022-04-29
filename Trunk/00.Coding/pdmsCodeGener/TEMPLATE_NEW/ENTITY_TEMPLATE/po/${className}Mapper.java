<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign leftbit = "#{">   
<#assign rightbit = "}">   
package ${basepackage}.${classNameLower}.dao;

import ${basepackage}.${classNameLower}.domain.${className};
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface ${className}Mapper extends  ${className}MapperBase{

}


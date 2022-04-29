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
public class ${className}Service extends ${className}ServiceBase {
	
    
}
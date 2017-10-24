<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.common.mapper.${moduleName}.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.apache.commons.lang.StringUtils;
import ${basepackage}.common.pojo.${moduleName}.${className};
import ${basepackage}.common.view.${moduleName}.${className}View;
import cn.ibm.view.ViewMapper;

/**
 * ${table.tableAlias}  返回给前端页面的vo封装类
 * @author node
 */
@Component
public class ${className}ViewBaseMapper implements ViewMapper<${className}, ${className}View>{

    @Override
    public ${className}View mapping(${className} ${classNameLower}) {
        ${className}View view = new ${className}View();
        <@generateView/>
        return view;
    }

    @Override
    public List<${className}View> mapping(List<${className}> ${classNameLower}s) {
        List<${className}View> views = new ArrayList<${className}View>();
        if(${classNameLower}s==null){
            return views;
        }
        for(${className} ${classNameLower}:${classNameLower}s){
            views.add(this.mapping(${classNameLower}));
        }
        return views;
    }

}
<#macro generateView>
<#list table.columns as column>
        if (null!=${classNameLower}.get${column.columnName}()){
            view.set${column.columnName}(${classNameLower}.get${column.columnName}());
        }
</#list>
</#macro>

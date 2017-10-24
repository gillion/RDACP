<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign inherittableLower = inherittable?uncap_first>
package ${basepackage}.common.service.${moduleName};
import cn.ibm.service.BaseService;
import cn.ibm.service.HandlerAdapter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhengsd
 */
@Component("${classNameLower}Handler")
public class ${className}Handler extends HandlerAdapter<BaseService> {

    @Resource(name = "${className}Service")
    private BaseService ${classNameLower}Service;

    @Resource(name = "${inherittable}Service")
    private BaseService ${inherittableLower}Service;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setOneService(${classNameLower}Service);
        this.setTwoService(${inherittableLower}Service);
    }
}

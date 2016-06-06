/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmTemplate.dao;

import com.cartan.core.ipfCcmTemplate.domain.IpfCcmTemplate;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmTemplateSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_template where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmTemplate ipfCcmTemplate=new IpfCcmTemplate();
        ipfCcmTemplate=(IpfCcmTemplate)parameter.get("ipfCcmTemplate");

        if(StringUtils.isNotBlank(ipfCcmTemplate.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmTemplate.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmTemplate.getTemplateFile())){
        	conditionsStr.append(" and TEMPLATE_FILE like  CONCAT('%',#{ipfCcmTemplate.TEMPLATE_FILE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmTemplate.getTemplateDesc())){
        	conditionsStr.append(" and TEMPLATE_DESC like  CONCAT('%',#{ipfCcmTemplate.TEMPLATE_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmTemplate.getTemplateType())){
        	conditionsStr.append(" and TEMPLATE_TYPE like  CONCAT('%',#{ipfCcmTemplate.TEMPLATE_TYPE},'%')");
        }
        return  conditionsStr.toString();
    }
}



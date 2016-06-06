/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmEnvironment.dao;

import com.cartan.core.ipfCcmEnvironment.domain.IpfCcmEnvironment;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmEnvironmentSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_environment where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmEnvironment ipfCcmEnvironment=new IpfCcmEnvironment();
        ipfCcmEnvironment=(IpfCcmEnvironment)parameter.get("ipfCcmEnvironment");

        if(StringUtils.isNotBlank(ipfCcmEnvironment.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmEnvironment.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmEnvironment.getUserCode())){
        	conditionsStr.append(" and USER_CODE like  CONCAT('%',#{ipfCcmEnvironment.USER_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmEnvironment.getProjectName())){
        	conditionsStr.append(" and PROJECT_NAME like  CONCAT('%',#{ipfCcmEnvironment.PROJECT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmEnvironment.getProjectPath())){
        	conditionsStr.append(" and PROJECT_PATH = #{ipfCcmEnvironment.PROJECT_PATH} ");
        }
        if(StringUtils.isNotBlank(ipfCcmEnvironment.getSrcPath())){
        	conditionsStr.append(" and SRC_PATH = #{ipfCcmEnvironment.SRC_PATH} ");
        }
        if(StringUtils.isNotBlank(ipfCcmEnvironment.getTemplatePath())){
        	conditionsStr.append(" and TEMPLATE_PATH like  CONCAT('%',#{ipfCcmEnvironment.TEMPLATE_PATH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmEnvironment.getWebContentName())){
        	conditionsStr.append(" and WEB_CONTENT_NAME like  CONCAT('%',#{ipfCcmEnvironment.WEB_CONTENT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmEnvironment.getTargetProjectName())){
        	conditionsStr.append(" and TARGET_PROJECT_NAME like  CONCAT('%',#{ipfCcmEnvironment.TARGET_PROJECT_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmEnvironment.getTargetProjectPath())){
        	conditionsStr.append(" and TARGET_PROJECT_PATH like  CONCAT('%',#{ipfCcmEnvironment.TARGET_PROJECT_PATH},'%')");
        }
        return  conditionsStr.toString();
    }
}



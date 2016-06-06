/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRtmConfig.dao;

import com.cartan.core.ipfRtmConfig.domain.IpfRtmConfig;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRtmConfigSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rtm_config where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRtmConfig ipfRtmConfig=new IpfRtmConfig();
        ipfRtmConfig=(IpfRtmConfig)parameter.get("ipfRtmConfig");

        if(StringUtils.isNotBlank(ipfRtmConfig.getId())){
        	conditionsStr.append(" and ID = #{ipfRtmConfig.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRtmConfig.getConfigCode())){
        	conditionsStr.append(" and CONFIG_CODE like  CONCAT('%',#{ipfRtmConfig.CONFIG_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfig.getConfigName())){
        	conditionsStr.append(" and CONFIG_NAME like  CONCAT('%',#{ipfRtmConfig.CONFIG_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfig.getTypeCode())){
        	conditionsStr.append(" and TYPE_CODE like  CONCAT('%',#{ipfRtmConfig.TYPE_CODE},'%')");
        }
        return  conditionsStr.toString();
    }
}



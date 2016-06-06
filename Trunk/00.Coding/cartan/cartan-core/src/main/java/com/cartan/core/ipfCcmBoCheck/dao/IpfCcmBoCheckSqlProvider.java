/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoCheck.dao;

import com.cartan.core.ipfCcmBoCheck.domain.IpfCcmBoCheck;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoCheckSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_check where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoCheck ipfCcmBoCheck=new IpfCcmBoCheck();
        ipfCcmBoCheck=(IpfCcmBoCheck)parameter.get("ipfCcmBoCheck");

        if(StringUtils.isNotBlank(ipfCcmBoCheck.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoCheck.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoCheck.getCheckType())){
        	conditionsStr.append(" and CHECK_TYPE like  CONCAT('%',#{ipfCcmBoCheck.CHECK_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheck.getCheckName())){
        	conditionsStr.append(" and CHECK_NAME like  CONCAT('%',#{ipfCcmBoCheck.CHECK_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheck.getBoName())){
        	conditionsStr.append(" and BO_NAME like  CONCAT('%',#{ipfCcmBoCheck.BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheck.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoCheck.PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheck.getPropertyDesc())){
        	conditionsStr.append(" and PROPERTY_DESC like  CONCAT('%',#{ipfCcmBoCheck.PROPERTY_DESC},'%')");
        }
        return  conditionsStr.toString();
    }
}



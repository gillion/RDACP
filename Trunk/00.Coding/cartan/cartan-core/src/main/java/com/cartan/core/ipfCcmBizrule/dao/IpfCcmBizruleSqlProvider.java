/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBizrule.dao;

import com.cartan.core.ipfCcmBizrule.domain.IpfCcmBizrule;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBizruleSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bizrule where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBizrule ipfCcmBizrule=new IpfCcmBizrule();
        ipfCcmBizrule=(IpfCcmBizrule)parameter.get("ipfCcmBizrule");

        if(StringUtils.isNotBlank(ipfCcmBizrule.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBizrule.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBizrule.getRuleType())){
        	conditionsStr.append(" and RULE_TYPE like  CONCAT('%',#{ipfCcmBizrule.RULE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizrule.getRuleClass())){
        	conditionsStr.append(" and RULE_CLASS like  CONCAT('%',#{ipfCcmBizrule.RULE_CLASS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizrule.getRuleCode())){
        	conditionsStr.append(" and RULE_CODE like  CONCAT('%',#{ipfCcmBizrule.RULE_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizrule.getRuleName())){
        	conditionsStr.append(" and RULE_NAME like  CONCAT('%',#{ipfCcmBizrule.RULE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizrule.getRuleDes())){
        	conditionsStr.append(" and RULE_DES like  CONCAT('%',#{ipfCcmBizrule.RULE_DES},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizrule.getIsSystemCreate())){
        	conditionsStr.append(" and IS_SYSTEM_CREATE like  CONCAT('%',#{ipfCcmBizrule.IS_SYSTEM_CREATE},'%')");
        }
        return  conditionsStr.toString();
    }
}



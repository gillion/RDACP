/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmNumrule.dao;

import com.cartan.core.ipfCcmNumrule.domain.IpfCcmNumrule;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmNumruleSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_numrule where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmNumrule ipfCcmNumrule=new IpfCcmNumrule();
        ipfCcmNumrule=(IpfCcmNumrule)parameter.get("ipfCcmNumrule");

        if(StringUtils.isNotBlank(ipfCcmNumrule.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmNumrule.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmNumrule.getRuleCode())){
        	conditionsStr.append(" and RULE_CODE like  CONCAT('%',#{ipfCcmNumrule.RULE_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getRuleName())){
        	conditionsStr.append(" and RULE_NAME like  CONCAT('%',#{ipfCcmNumrule.RULE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getRuleExpression())){
        	conditionsStr.append(" and RULE_EXPRESSION like  CONCAT('%',#{ipfCcmNumrule.RULE_EXPRESSION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getRuleStatus())){
        	conditionsStr.append(" and RULE_STATUS like  CONCAT('%',#{ipfCcmNumrule.RULE_STATUS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getInitialValue())){
        	conditionsStr.append(" and INITIAL_VALUE like  CONCAT('%',#{ipfCcmNumrule.INITIAL_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getMaxValue())){
        	conditionsStr.append(" and MAX_VALUE like  CONCAT('%',#{ipfCcmNumrule.MAX_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getGrowth())){
        	conditionsStr.append(" and GROWTH like  CONCAT('%',#{ipfCcmNumrule.GROWTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{ipfCcmNumrule.REMARK},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfCcmNumrule.IS_ACTIVE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmNumrule.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getBoName())){
        	conditionsStr.append(" and BO_NAME like  CONCAT('%',#{ipfCcmNumrule.BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getIpfCcmBoPropertyId())){
        	conditionsStr.append(" and IPF_CCM_BO_PROPERTY_ID like  CONCAT('%',#{ipfCcmNumrule.IPF_CCM_BO_PROPERTY_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumrule.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfCcmNumrule.PROPERTY_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}



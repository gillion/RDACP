/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfReqRule.dao;

import com.cartan.core.ipfReqRule.domain.IpfReqRule;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfReqRuleSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_req_rule where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfReqRule ipfReqRule=new IpfReqRule();
        ipfReqRule=(IpfReqRule)parameter.get("ipfReqRule");

        if(StringUtils.isNotBlank(ipfReqRule.getId())){
        	conditionsStr.append(" and ID = #{ipfReqRule.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfReqRule.getRuleName())){
        	conditionsStr.append(" and RULE_NAME like  CONCAT('%',#{ipfReqRule.RULE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getRuleNo())){
        	conditionsStr.append(" and RULE_NO like  CONCAT('%',#{ipfReqRule.RULE_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getRuleType())){
        	conditionsStr.append(" and RULE_TYPE like  CONCAT('%',#{ipfReqRule.RULE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getRuleStatus())){
        	conditionsStr.append(" and RULE_STATUS like  CONCAT('%',#{ipfReqRule.RULE_STATUS},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getTriggerType())){
        	conditionsStr.append(" and TRIGGER_TYPE like  CONCAT('%',#{ipfReqRule.TRIGGER_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getPhysicalLocation())){
        	conditionsStr.append(" and PHYSICAL_LOCATION like  CONCAT('%',#{ipfReqRule.PHYSICAL_LOCATION},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getActionType())){
        	conditionsStr.append(" and ACTION_TYPE like  CONCAT('%',#{ipfReqRule.ACTION_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getBusinessLocation())){
        	conditionsStr.append(" and BUSINESS_LOCATION like  CONCAT('%',#{ipfReqRule.BUSINESS_LOCATION},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getBusinessModule())){
        	conditionsStr.append(" and BUSINESS_MODULE like  CONCAT('%',#{ipfReqRule.BUSINESS_MODULE},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getDroolsAttribute())){
        	conditionsStr.append(" and DROOLS_ATTRIBUTE like  CONCAT('%',#{ipfReqRule.DROOLS_ATTRIBUTE},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getRuleDesc())){
        	conditionsStr.append(" and RULE_DESC like  CONCAT('%',#{ipfReqRule.RULE_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getIsDecisionTable())){
        	conditionsStr.append(" and IS_DECISION_TABLE like  CONCAT('%',#{ipfReqRule.IS_DECISION_TABLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getPublicType())){
        	conditionsStr.append(" and PUBLIC_TYPE like  CONCAT('%',#{ipfReqRule.PUBLIC_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfReqRule.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getImportDesc())){
        	conditionsStr.append(" and IMPORT_DESC like  CONCAT('%',#{ipfReqRule.IMPORT_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getDroolsWhen())){
        	conditionsStr.append(" and DROOLS_WHEN like  CONCAT('%',#{ipfReqRule.DROOLS_WHEN},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getDroolsThen())){
        	conditionsStr.append(" and DROOLS_THEN like  CONCAT('%',#{ipfReqRule.DROOLS_THEN},'%')");
        }
        if(StringUtils.isNotBlank(ipfReqRule.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{ipfReqRule.REMARK},'%')");
        }
        return  conditionsStr.toString();
    }
}



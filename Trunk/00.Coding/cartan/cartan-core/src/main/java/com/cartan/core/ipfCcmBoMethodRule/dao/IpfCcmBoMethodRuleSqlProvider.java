/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoMethodRule.dao;

import com.cartan.core.ipfCcmBoMethodRule.domain.IpfCcmBoMethodRule;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoMethodRuleSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_method_rule where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoMethodRule ipfCcmBoMethodRule=new IpfCcmBoMethodRule();
        ipfCcmBoMethodRule=(IpfCcmBoMethodRule)parameter.get("ipfCcmBoMethodRule");

        if(StringUtils.isNotBlank(ipfCcmBoMethodRule.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoMethodRule.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoMethodRule.getIpfCcbBoMethodId())){
        	conditionsStr.append(" and IPF_CCB_BO_METHOD_ID like  CONCAT('%',#{ipfCcmBoMethodRule.IPF_CCB_BO_METHOD_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodRule.getRuleNo())){
        	conditionsStr.append(" and RULE_NO like  CONCAT('%',#{ipfCcmBoMethodRule.RULE_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodRule.getRuleName())){
        	conditionsStr.append(" and RULE_NAME like  CONCAT('%',#{ipfCcmBoMethodRule.RULE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodRule.getInvokePoint())){
        	conditionsStr.append(" and INVOKE_POINT like  CONCAT('%',#{ipfCcmBoMethodRule.INVOKE_POINT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodRule.getInvokeOrder())){
        	conditionsStr.append(" and INVOKE_ORDER like  CONCAT('%',#{ipfCcmBoMethodRule.INVOKE_ORDER},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodRule.getRuleId())){
        	conditionsStr.append(" and RULE_ID like  CONCAT('%',#{ipfCcmBoMethodRule.RULE_ID},'%')");
        }
        return  conditionsStr.toString();
    }
}



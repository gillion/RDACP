/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBizruleDtl.dao;

import com.cartan.core.ipfCcmBizruleDtl.domain.IpfCcmBizruleDtl;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBizruleDtlSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bizrule_dtl where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBizruleDtl ipfCcmBizruleDtl=new IpfCcmBizruleDtl();
        ipfCcmBizruleDtl=(IpfCcmBizruleDtl)parameter.get("ipfCcmBizruleDtl");

        if(StringUtils.isNotBlank(ipfCcmBizruleDtl.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBizruleDtl.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBizruleDtl.getIpfCcmBizruleId())){
        	conditionsStr.append(" and IPF_CCM_BIZRULE_ID like  CONCAT('%',#{ipfCcmBizruleDtl.IPF_CCM_BIZRULE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtl.getIpfCcmStrategyId())){
        	conditionsStr.append(" and IPF_CCM_STRATEGY_ID like  CONCAT('%',#{ipfCcmBizruleDtl.IPF_CCM_STRATEGY_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtl.getStrategyCode())){
        	conditionsStr.append(" and STRATEGY_CODE like  CONCAT('%',#{ipfCcmBizruleDtl.STRATEGY_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtl.getStrategyName())){
        	conditionsStr.append(" and STRATEGY_NAME like  CONCAT('%',#{ipfCcmBizruleDtl.STRATEGY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtl.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{ipfCcmBizruleDtl.REMARK},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtl.getRuleDetailIndex())){
        	conditionsStr.append(" and RULE_DETAIL_INDEX like  CONCAT('%',#{ipfCcmBizruleDtl.RULE_DETAIL_INDEX},'%')");
        }
        return  conditionsStr.toString();
    }
}



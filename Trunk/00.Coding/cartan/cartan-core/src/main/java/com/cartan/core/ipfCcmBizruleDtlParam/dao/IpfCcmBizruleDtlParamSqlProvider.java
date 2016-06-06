/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBizruleDtlParam.dao;

import com.cartan.core.ipfCcmBizruleDtlParam.domain.IpfCcmBizruleDtlParam;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBizruleDtlParamSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bizrule_dtl_param where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam=new IpfCcmBizruleDtlParam();
        ipfCcmBizruleDtlParam=(IpfCcmBizruleDtlParam)parameter.get("ipfCcmBizruleDtlParam");

        if(StringUtils.isNotBlank(ipfCcmBizruleDtlParam.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBizruleDtlParam.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBizruleDtlParam.getIpfCcmBizruleId())){
        	conditionsStr.append(" and IPF_CCM_BIZRULE_ID like  CONCAT('%',#{ipfCcmBizruleDtlParam.IPF_CCM_BIZRULE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtlParam.getIpfCcmStrategyId())){
        	conditionsStr.append(" and IPF_CCM_STRATEGY_ID like  CONCAT('%',#{ipfCcmBizruleDtlParam.IPF_CCM_STRATEGY_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtlParam.getIpfCcmStrategyParamId())){
        	conditionsStr.append(" and IPF_CCM_STRATEGY_PARAM_ID like  CONCAT('%',#{ipfCcmBizruleDtlParam.IPF_CCM_STRATEGY_PARAM_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtlParam.getParamName())){
        	conditionsStr.append(" and PARAM_NAME like  CONCAT('%',#{ipfCcmBizruleDtlParam.PARAM_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtlParam.getParamDes())){
        	conditionsStr.append(" and PARAM_DES like  CONCAT('%',#{ipfCcmBizruleDtlParam.PARAM_DES},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtlParam.getParamValue())){
        	conditionsStr.append(" and PARAM_VALUE like  CONCAT('%',#{ipfCcmBizruleDtlParam.PARAM_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBizruleDtlParam.getParamValueDes())){
        	conditionsStr.append(" and PARAM_VALUE_DES like  CONCAT('%',#{ipfCcmBizruleDtlParam.PARAM_VALUE_DES},'%')");
        }
        return  conditionsStr.toString();
    }
}



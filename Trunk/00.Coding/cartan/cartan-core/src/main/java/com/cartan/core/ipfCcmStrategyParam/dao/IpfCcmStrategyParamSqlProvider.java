/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmStrategyParam.dao;

import com.cartan.core.ipfCcmStrategyParam.domain.IpfCcmStrategyParam;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmStrategyParamSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_strategy_param where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmStrategyParam ipfCcmStrategyParam=new IpfCcmStrategyParam();
        ipfCcmStrategyParam=(IpfCcmStrategyParam)parameter.get("ipfCcmStrategyParam");

        if(StringUtils.isNotBlank(ipfCcmStrategyParam.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmStrategyParam.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmStrategyParam.getIpfCcmStrategyId())){
        	conditionsStr.append(" and IPF_CCM_STRATEGY_ID like  CONCAT('%',#{ipfCcmStrategyParam.IPF_CCM_STRATEGY_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategyParam.getParamType())){
        	conditionsStr.append(" and PARAM_TYPE like  CONCAT('%',#{ipfCcmStrategyParam.PARAM_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategyParam.getParamName())){
        	conditionsStr.append(" and PARAM_NAME like  CONCAT('%',#{ipfCcmStrategyParam.PARAM_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategyParam.getParamDes())){
        	conditionsStr.append(" and PARAM_DES like  CONCAT('%',#{ipfCcmStrategyParam.PARAM_DES},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategyParam.getRtmConfigCode())){
        	conditionsStr.append(" and RTM_CONFIG_CODE like  CONCAT('%',#{ipfCcmStrategyParam.RTM_CONFIG_CODE},'%')");
        }
        return  conditionsStr.toString();
    }
}



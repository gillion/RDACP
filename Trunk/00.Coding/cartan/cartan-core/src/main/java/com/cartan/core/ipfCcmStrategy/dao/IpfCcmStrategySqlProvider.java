/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmStrategy.dao;

import com.cartan.core.ipfCcmStrategy.domain.IpfCcmStrategy;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmStrategySqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_strategy where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmStrategy ipfCcmStrategy=new IpfCcmStrategy();
        ipfCcmStrategy=(IpfCcmStrategy)parameter.get("ipfCcmStrategy");

        if(StringUtils.isNotBlank(ipfCcmStrategy.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmStrategy.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmStrategy.getStrategyType())){
        	conditionsStr.append(" and STRATEGY_TYPE like  CONCAT('%',#{ipfCcmStrategy.STRATEGY_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getStrategyCode())){
        	conditionsStr.append(" and STRATEGY_CODE like  CONCAT('%',#{ipfCcmStrategy.STRATEGY_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getStrategyName())){
        	conditionsStr.append(" and STRATEGY_NAME like  CONCAT('%',#{ipfCcmStrategy.STRATEGY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getStrategyDes())){
        	conditionsStr.append(" and STRATEGY_DES like  CONCAT('%',#{ipfCcmStrategy.STRATEGY_DES},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getDrlFile())){
        	conditionsStr.append(" and DRL_FILE like  CONCAT('%',#{ipfCcmStrategy.DRL_FILE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getDrlRoute())){
        	conditionsStr.append(" and DRL_ROUTE like  CONCAT('%',#{ipfCcmStrategy.DRL_ROUTE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getPackageName())){
        	conditionsStr.append(" and PACKAGE_NAME like  CONCAT('%',#{ipfCcmStrategy.PACKAGE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getRuleNo())){
        	conditionsStr.append(" and RULE_NO like  CONCAT('%',#{ipfCcmStrategy.RULE_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getRuleType())){
        	conditionsStr.append(" and RULE_TYPE like  CONCAT('%',#{ipfCcmStrategy.RULE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getSourceCode())){
        	conditionsStr.append(" and SOURCE_CODE like  CONCAT('%',#{ipfCcmStrategy.SOURCE_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmStrategy.getSvnRevision())){
        	conditionsStr.append(" and SVN_REVISION like  CONCAT('%',#{ipfCcmStrategy.SVN_REVISION},'%')");
        }
        return  conditionsStr.toString();
    }
}



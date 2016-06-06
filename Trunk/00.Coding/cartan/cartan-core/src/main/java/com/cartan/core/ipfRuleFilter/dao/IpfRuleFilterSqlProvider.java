/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRuleFilter.dao;

import com.cartan.core.ipfRuleFilter.domain.IpfRuleFilter;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRuleFilterSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rule_filter where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRuleFilter ipfRuleFilter=new IpfRuleFilter();
        ipfRuleFilter=(IpfRuleFilter)parameter.get("ipfRuleFilter");

        if(StringUtils.isNotBlank(ipfRuleFilter.getId())){
        	conditionsStr.append(" and ID = #{ipfRuleFilter.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRuleFilter.getFilterCode())){
        	conditionsStr.append(" and FILTER_CODE like  CONCAT('%',#{ipfRuleFilter.FILTER_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilter.getFilterName())){
        	conditionsStr.append(" and FILTER_NAME like  CONCAT('%',#{ipfRuleFilter.FILTER_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilter.getFilterDesc())){
        	conditionsStr.append(" and FILTER_DESC like  CONCAT('%',#{ipfRuleFilter.FILTER_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilter.getFilterExpress())){
        	conditionsStr.append(" and FILTER_EXPRESS like  CONCAT('%',#{ipfRuleFilter.FILTER_EXPRESS},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilter.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfRuleFilter.IS_ACTIVE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilter.getIsSystemCreate())){
        	conditionsStr.append(" and IS_SYSTEM_CREATE like  CONCAT('%',#{ipfRuleFilter.IS_SYSTEM_CREATE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilter.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfRuleFilter.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilter.getBoName())){
        	conditionsStr.append(" and BO_NAME like  CONCAT('%',#{ipfRuleFilter.BO_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}



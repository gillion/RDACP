/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRuleFilterDetail.dao;

import com.cartan.core.ipfRuleFilterDetail.domain.IpfRuleFilterDetail;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRuleFilterDetailSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rule_filter_detail where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRuleFilterDetail ipfRuleFilterDetail=new IpfRuleFilterDetail();
        ipfRuleFilterDetail=(IpfRuleFilterDetail)parameter.get("ipfRuleFilterDetail");

        if(StringUtils.isNotBlank(ipfRuleFilterDetail.getId())){
        	conditionsStr.append(" and ID = #{ipfRuleFilterDetail.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRuleFilterDetail.getIpfRuleFilterId())){
        	conditionsStr.append(" and IPF_RULE_FILTER_ID like  CONCAT('%',#{ipfRuleFilterDetail.IPF_RULE_FILTER_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilterDetail.getLineId())){
        	conditionsStr.append(" and LINE_ID like  CONCAT('%',#{ipfRuleFilterDetail.LINE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilterDetail.getAttribute())){
        	conditionsStr.append(" and ATTRIBUTE like  CONCAT('%',#{ipfRuleFilterDetail.ATTRIBUTE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilterDetail.getOperand())){
        	conditionsStr.append(" and OPERAND like  CONCAT('%',#{ipfRuleFilterDetail.OPERAND},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilterDetail.getLiteralValue())){
        	conditionsStr.append(" and LITERAL_VALUE like  CONCAT('%',#{ipfRuleFilterDetail.LITERAL_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilterDetail.getAndOr())){
        	conditionsStr.append(" and AND_OR like  CONCAT('%',#{ipfRuleFilterDetail.AND_OR},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilterDetail.getLeftParen())){
        	conditionsStr.append(" and LEFT_PAREN like  CONCAT('%',#{ipfRuleFilterDetail.LEFT_PAREN},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleFilterDetail.getRightParen())){
        	conditionsStr.append(" and RIGHT_PAREN like  CONCAT('%',#{ipfRuleFilterDetail.RIGHT_PAREN},'%')");
        }
        return  conditionsStr.toString();
    }
}



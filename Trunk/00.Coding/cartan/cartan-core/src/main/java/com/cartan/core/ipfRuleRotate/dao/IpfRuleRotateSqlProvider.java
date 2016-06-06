/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRuleRotate.dao;

import com.cartan.core.ipfRuleRotate.domain.IpfRuleRotate;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRuleRotateSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rule_rotate where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRuleRotate ipfRuleRotate=new IpfRuleRotate();
        ipfRuleRotate=(IpfRuleRotate)parameter.get("ipfRuleRotate");

        if(StringUtils.isNotBlank(ipfRuleRotate.getId())){
        	conditionsStr.append(" and ID = #{ipfRuleRotate.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRuleRotate.getWarehouseOfficeId())){
        	conditionsStr.append(" and WAREHOUSE_OFFICE_ID like  CONCAT('%',#{ipfRuleRotate.WAREHOUSE_OFFICE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotate.getRuleCode())){
        	conditionsStr.append(" and RULE_CODE like  CONCAT('%',#{ipfRuleRotate.RULE_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotate.getRuleDesc())){
        	conditionsStr.append(" and RULE_DESC like  CONCAT('%',#{ipfRuleRotate.RULE_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotate.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfRuleRotate.IS_ACTIVE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotate.getIsSystemCreate())){
        	conditionsStr.append(" and IS_SYSTEM_CREATE like  CONCAT('%',#{ipfRuleRotate.IS_SYSTEM_CREATE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRuleRotate.getRotateExpress())){
        	conditionsStr.append(" and ROTATE_EXPRESS like  CONCAT('%',#{ipfRuleRotate.ROTATE_EXPRESS},'%')");
        }
        return  conditionsStr.toString();
    }
}



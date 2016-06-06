/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ruleTableInput.dao;

import com.cartan.core.ruleTableInput.domain.RuleTableInput;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class RuleTableInputSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.T_RULE_TABLE_INPUT where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        RuleTableInput ruleTableInput=new RuleTableInput();
        ruleTableInput=(RuleTableInput)parameter.get("ruleTableInput");

        if(StringUtils.isNotBlank(ruleTableInput.getId())){
        	conditionsStr.append(" and ID = #{ruleTableInput.ID} ");
        }    		
        if(StringUtils.isNotBlank(ruleTableInput.getRuleTableId())){
        	conditionsStr.append(" and RULE_TABLE_ID like  CONCAT('%',#{ruleTableInput.RULE_TABLE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ruleTableInput.getOutputLocation())){
        	conditionsStr.append(" and OUTPUT_LOCATION like  CONCAT('%',#{ruleTableInput.OUTPUT_LOCATION},'%')");
        }
        if(StringUtils.isNotBlank(ruleTableInput.getInputVar())){
        	conditionsStr.append(" and INPUT_VAR like  CONCAT('%',#{ruleTableInput.INPUT_VAR},'%')");
        }
        if(StringUtils.isNotBlank(ruleTableInput.getInputValue())){
        	conditionsStr.append(" and INPUT_VALUE like  CONCAT('%',#{ruleTableInput.INPUT_VALUE},'%')");
        }
        return  conditionsStr.toString();
    }
}



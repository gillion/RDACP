/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ruleTableOutput.dao;

import com.cartan.core.ruleTableOutput.domain.RuleTableOutput;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class RuleTableOutputSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_rule_table_output where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        RuleTableOutput ruleTableOutput=new RuleTableOutput();
        ruleTableOutput=(RuleTableOutput)parameter.get("ruleTableOutput");

        if(StringUtils.isNotBlank(ruleTableOutput.getId())){
        	conditionsStr.append(" and ID = #{ruleTableOutput.ID} ");
        }    		
        if(StringUtils.isNotBlank(ruleTableOutput.getRuleTableId())){
        	conditionsStr.append(" and RULE_TABLE_ID like  CONCAT('%',#{ruleTableOutput.RULE_TABLE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ruleTableOutput.getOutputLocation())){
        	conditionsStr.append(" and OUTPUT_LOCATION like  CONCAT('%',#{ruleTableOutput.OUTPUT_LOCATION},'%')");
        }
        if(StringUtils.isNotBlank(ruleTableOutput.getOutputVar())){
        	conditionsStr.append(" and OUTPUT_VAR like  CONCAT('%',#{ruleTableOutput.OUTPUT_VAR},'%')");
        }
        if(StringUtils.isNotBlank(ruleTableOutput.getOutputValue())){
        	conditionsStr.append(" and OUTPUT_VALUE like  CONCAT('%',#{ruleTableOutput.OUTPUT_VALUE},'%')");
        }
        return  conditionsStr.toString();
    }
}



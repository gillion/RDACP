/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ruleTreeOutput.dao;

import com.cartan.core.ruleTreeOutput.domain.RuleTreeOutput;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class RuleTreeOutputSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_rule_tree_output where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        RuleTreeOutput ruleTreeOutput=new RuleTreeOutput();
        ruleTreeOutput=(RuleTreeOutput)parameter.get("ruleTreeOutput");

        if(StringUtils.isNotBlank(ruleTreeOutput.getId())){
        	conditionsStr.append(" and ID = #{ruleTreeOutput.ID} ");
        }    		
        if(StringUtils.isNotBlank(ruleTreeOutput.getRuleTreeId())){
        	conditionsStr.append(" and RULE_TREE_ID like  CONCAT('%',#{ruleTreeOutput.RULE_TREE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ruleTreeOutput.getTreeNodeCode())){
        	conditionsStr.append(" and TREE_NODE_CODE like  CONCAT('%',#{ruleTreeOutput.TREE_NODE_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ruleTreeOutput.getTreeNodeName())){
        	conditionsStr.append(" and TREE_NODE_NAME like  CONCAT('%',#{ruleTreeOutput.TREE_NODE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ruleTreeOutput.getOutputVer())){
        	conditionsStr.append(" and OUTPUT_VER like  CONCAT('%',#{ruleTreeOutput.OUTPUT_VER},'%')");
        }
        if(StringUtils.isNotBlank(ruleTreeOutput.getOutputValue())){
        	conditionsStr.append(" and OUTPUT_VALUE like  CONCAT('%',#{ruleTreeOutput.OUTPUT_VALUE},'%')");
        }
        return  conditionsStr.toString();
    }
}



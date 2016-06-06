/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ruleTree.dao;

import com.cartan.core.ruleTree.domain.RuleTree;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class RuleTreeSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.T_RULE_TREE where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        RuleTree ruleTree=new RuleTree();
        ruleTree=(RuleTree)parameter.get("ruleTree");

        if(StringUtils.isNotBlank(ruleTree.getId())){
        	conditionsStr.append(" and ID = #{ruleTree.ID} ");
        }    		
        if(StringUtils.isNotBlank(ruleTree.getRuleTreeName())){
        	conditionsStr.append(" and RULE_TREE_NAME like  CONCAT('%',#{ruleTree.RULE_TREE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ruleTree.getVersion())){
        	conditionsStr.append(" and VERSION like  CONCAT('%',#{ruleTree.VERSION},'%')");
        }
        if(StringUtils.isNotBlank(ruleTree.getStatus())){
        	conditionsStr.append(" and STATUS like  CONCAT('%',#{ruleTree.STATUS},'%')");
        }
        if(StringUtils.isNotBlank(ruleTree.getOutputWay())){
        	conditionsStr.append(" and OUTPUT_WAY = #{ruleTree.OUTPUT_WAY} ");
        }
        if(StringUtils.isNotBlank(ruleTree.getModifyDate())){
        	conditionsStr.append(" and MODIFY_DATE like  CONCAT('%',#{ruleTree.MODIFY_DATE},'%')");
        }
        if(StringUtils.isNotBlank(ruleTree.getModifyed())){
        	conditionsStr.append(" and MODIFYED like  CONCAT('%',#{ruleTree.MODIFYED},'%')");
        }
        if(StringUtils.isNotBlank(ruleTree.getOwner())){
        	conditionsStr.append(" and OWNER like  CONCAT('%',#{ruleTree.OWNER},'%')");
        }
        if(StringUtils.isNotBlank(ruleTree.getLocked())){
        	conditionsStr.append(" and LOCKED like  CONCAT('%',#{ruleTree.LOCKED},'%')");
        }
        return  conditionsStr.toString();
    }
}



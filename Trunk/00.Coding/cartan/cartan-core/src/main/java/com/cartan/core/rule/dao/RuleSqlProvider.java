/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.rule.dao;

import com.cartan.core.rule.domain.Rule;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class RuleSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.T_RULE where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        Rule rule=new Rule();
        rule=(Rule)parameter.get("rule");

        if(StringUtils.isNotBlank(rule.getId())){
        	conditionsStr.append(" and ID = #{rule.ID} ");
        }    		
        if(StringUtils.isNotBlank(rule.getRuleName())){
        	conditionsStr.append(" and RULE_NAME like  CONCAT('%',#{rule.RULE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(rule.getRulesetId())){
        	conditionsStr.append(" and RULESET_ID like  CONCAT('%',#{rule.RULESET_ID},'%')");
        }
        if(StringUtils.isNotBlank(rule.getIsUsed())){
        	conditionsStr.append(" and IS_USED = #{rule.IS_USED} ");
        }
        if(StringUtils.isNotBlank(rule.getPriLevel())){
        	conditionsStr.append(" and PRI_LEVEL = #{rule.PRI_LEVEL} ");
        }
        if(StringUtils.isNotBlank(rule.getContentType())){
        	conditionsStr.append(" and CONTENT_TYPE like  CONCAT('%',#{rule.CONTENT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(rule.getEffectDate())){
        	conditionsStr.append(" and EFFECT_DATE like  CONCAT('%',#{rule.EFFECT_DATE},'%')");
        }
        if(StringUtils.isNotBlank(rule.getInvalidDate())){
        	conditionsStr.append(" and INVALID_DATE like  CONCAT('%',#{rule.INVALID_DATE},'%')");
        }
        if(StringUtils.isNotBlank(rule.getCreator())){
        	conditionsStr.append(" and CREATOR like  CONCAT('%',#{rule.CREATOR},'%')");
        }
        if(StringUtils.isNotBlank(rule.getCreateDate())){
        	conditionsStr.append(" and CREATE_DATE like  CONCAT('%',#{rule.CREATE_DATE},'%')");
        }
        if(StringUtils.isNotBlank(rule.getModifyDate())){
        	conditionsStr.append(" and MODIFY_DATE like  CONCAT('%',#{rule.MODIFY_DATE},'%')");
        }
        if(StringUtils.isNotBlank(rule.getModifyed())){
        	conditionsStr.append(" and MODIFYED like  CONCAT('%',#{rule.MODIFYED},'%')");
        }
        if(StringUtils.isNotBlank(rule.getOwner())){
        	conditionsStr.append(" and OWNER like  CONCAT('%',#{rule.OWNER},'%')");
        }
        if(StringUtils.isNotBlank(rule.getLocked())){
        	conditionsStr.append(" and LOCKED like  CONCAT('%',#{rule.LOCKED},'%')");
        }
        return  conditionsStr.toString();
    }
}



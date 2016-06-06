/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ruleTable.dao;

import com.cartan.core.ruleTable.domain.RuleTable;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class RuleTableSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.T_RULE_TABLE where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        RuleTable ruleTable=new RuleTable();
        ruleTable=(RuleTable)parameter.get("ruleTable");

        if(StringUtils.isNotBlank(ruleTable.getId())){
        	conditionsStr.append(" and ID = #{ruleTable.ID} ");
        }    		
        if(StringUtils.isNotBlank(ruleTable.getRuleTableName())){
        	conditionsStr.append(" and RULE_TABLE_NAME like  CONCAT('%',#{ruleTable.RULE_TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ruleTable.getVersion())){
        	conditionsStr.append(" and VERSION like  CONCAT('%',#{ruleTable.VERSION},'%')");
        }
        if(StringUtils.isNotBlank(ruleTable.getStatus())){
        	conditionsStr.append(" and STATUS like  CONCAT('%',#{ruleTable.STATUS},'%')");
        }
        if(StringUtils.isNotBlank(ruleTable.getModifyDate())){
        	conditionsStr.append(" and MODIFY_DATE like  CONCAT('%',#{ruleTable.MODIFY_DATE},'%')");
        }
        if(StringUtils.isNotBlank(ruleTable.getModifyed())){
        	conditionsStr.append(" and MODIFYED like  CONCAT('%',#{ruleTable.MODIFYED},'%')");
        }
        if(StringUtils.isNotBlank(ruleTable.getOwner())){
        	conditionsStr.append(" and OWNER like  CONCAT('%',#{ruleTable.OWNER},'%')");
        }
        if(StringUtils.isNotBlank(ruleTable.getLocked())){
        	conditionsStr.append(" and LOCKED like  CONCAT('%',#{ruleTable.LOCKED},'%')");
        }
        return  conditionsStr.toString();
    }
}



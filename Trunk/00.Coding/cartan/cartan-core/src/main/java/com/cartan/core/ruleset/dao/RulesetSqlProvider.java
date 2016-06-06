/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ruleset.dao;

import com.cartan.core.ruleset.domain.Ruleset;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class RulesetSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.T_RULESET where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        Ruleset ruleset=new Ruleset();
        ruleset=(Ruleset)parameter.get("ruleset");

        if(StringUtils.isNotBlank(ruleset.getId())){
        	conditionsStr.append(" and ID = #{ruleset.ID} ");
        }    		
        if(StringUtils.isNotBlank(ruleset.getRulesetName())){
        	conditionsStr.append(" and RULESET_NAME like  CONCAT('%',#{ruleset.RULESET_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ruleset.getVersion())){
        	conditionsStr.append(" and VERSION like  CONCAT('%',#{ruleset.VERSION},'%')");
        }
        if(StringUtils.isNotBlank(ruleset.getStatus())){
        	conditionsStr.append(" and STATUS like  CONCAT('%',#{ruleset.STATUS},'%')");
        }
        if(StringUtils.isNotBlank(ruleset.getModifyDate())){
        	conditionsStr.append(" and MODIFY_DATE like  CONCAT('%',#{ruleset.MODIFY_DATE},'%')");
        }
        if(StringUtils.isNotBlank(ruleset.getModifyed())){
        	conditionsStr.append(" and MODIFYED like  CONCAT('%',#{ruleset.MODIFYED},'%')");
        }
        if(StringUtils.isNotBlank(ruleset.getOwner())){
        	conditionsStr.append(" and OWNER like  CONCAT('%',#{ruleset.OWNER},'%')");
        }
        if(StringUtils.isNotBlank(ruleset.getLocked())){
        	conditionsStr.append(" and LOCKED like  CONCAT('%',#{ruleset.LOCKED},'%')");
        }
        return  conditionsStr.toString();
    }
}



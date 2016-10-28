/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.conditionPartition.dao;

import com.cartan.core.conditionPartition.domain.ConditionPartition;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class ConditionPartitionSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.T_CONDITION_PARTITION where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        ConditionPartition conditionPartition=new ConditionPartition();
        conditionPartition=(ConditionPartition)parameter.get("conditionPartition");

        if(StringUtils.isNotBlank(conditionPartition.getId())){
        	conditionsStr.append(" and ID = #{conditionPartition.ID} ");
        }    		
        if(StringUtils.isNotBlank(conditionPartition.getConditionName())){
        	conditionsStr.append(" and CONDITION_NAME like  CONCAT('%',#{conditionPartition.CONDITION_NAME},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartition.getStatus())){
        	conditionsStr.append(" and STATUS like  CONCAT('%',#{conditionPartition.STATUS},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartition.getModifyDate())){
        	conditionsStr.append(" and MODIFY_DATE like  CONCAT('%',#{conditionPartition.MODIFY_DATE},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartition.getModifyed())){
        	conditionsStr.append(" and MODIFYED like  CONCAT('%',#{conditionPartition.MODIFYED},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartition.getOwner())){
        	conditionsStr.append(" and OWNER like  CONCAT('%',#{conditionPartition.OWNER},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartition.getLocked())){
        	conditionsStr.append(" and LOCKED like  CONCAT('%',#{conditionPartition.LOCKED},'%')");
        }
        return  conditionsStr.toString();
    }
}



/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.conditionPartitionNode.dao;

import com.cartan.core.conditionPartitionNode.domain.ConditionPartitionNode;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class ConditionPartitionNodeSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_condition_partition_node where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        ConditionPartitionNode conditionPartitionNode=new ConditionPartitionNode();
        conditionPartitionNode=(ConditionPartitionNode)parameter.get("conditionPartitionNode");

        if(StringUtils.isNotBlank(conditionPartitionNode.getId())){
        	conditionsStr.append(" and ID = #{conditionPartitionNode.ID} ");
        }    		
        if(StringUtils.isNotBlank(conditionPartitionNode.getConPartitionId())){
        	conditionsStr.append(" and CON_PARTITION_ID like  CONCAT('%',#{conditionPartitionNode.CON_PARTITION_ID},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartitionNode.getConNodeName())){
        	conditionsStr.append(" and CON_NODE_NAME like  CONCAT('%',#{conditionPartitionNode.CON_NODE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartitionNode.getRelationMark())){
        	conditionsStr.append(" and RELATION_MARK like  CONCAT('%',#{conditionPartitionNode.RELATION_MARK},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartitionNode.getVarName())){
        	conditionsStr.append(" and VAR_NAME like  CONCAT('%',#{conditionPartitionNode.VAR_NAME},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartitionNode.getOptChar())){
        	conditionsStr.append(" and OPT_CHAR like  CONCAT('%',#{conditionPartitionNode.OPT_CHAR},'%')");
        }
        if(StringUtils.isNotBlank(conditionPartitionNode.getCompareValue())){
        	conditionsStr.append(" and COMPARE_VALUE like  CONCAT('%',#{conditionPartitionNode.COMPARE_VALUE},'%')");
        }
        return  conditionsStr.toString();
    }
}



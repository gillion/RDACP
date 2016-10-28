package com.cartan.core.conditionPartitionNode.dao;

import com.cartan.core.conditionPartitionNode.domain.ConditionPartitionNode;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface ConditionPartitionNodeMapperBase {
	@Select("SELECT * FROM cartan_common.T_CONDITION_PARTITION_NODE s WHERE s.ID = #{id}")
	ConditionPartitionNode getConditionPartitionNode(String id);
	
	@Insert("INSERT INTO cartan_common.T_CONDITION_PARTITION_NODE(ID,CON_PARTITION_ID,CON_NODE_NAME,RELATION_MARK,VAR_NAME,OPT_CHAR,COMPARE_VALUE) VALUES(#{id},#{conPartitionId},#{conNodeName},#{relationMark},#{varName},#{optChar},#{compareValue})")
    void createConditionPartitionNode(ConditionPartitionNode conditionPartitionNode);
    
    @Delete("DELETE FROM cartan_common.T_CONDITION_PARTITION_NODE WHERE ID = #{id}")
    void deleteConditionPartitionNode(String id);

    @Update("update cartan_common.T_CONDITION_PARTITION_NODE set CON_PARTITION_ID=#{conPartitionId},CON_NODE_NAME=#{conNodeName},RELATION_MARK=#{relationMark},VAR_NAME=#{varName},OPT_CHAR=#{optChar},COMPARE_VALUE=#{compareValue} where ID = #{id}")
    void updateConditionPartitionNode(ConditionPartitionNode conditionPartitionNode);

    @Select("select count(*) c from cartan_common.T_CONDITION_PARTITION_NODE")
    int countAll();
    
    @Select("select * from cartan_common.T_CONDITION_PARTITION_NODE order by ID asc")
    ArrayList<ConditionPartitionNode> selectAll();
    
    @SelectProvider(type = ConditionPartitionNodeSqlProvider.class, method = "getSql")
    ArrayList<ConditionPartitionNode> selectWithCondition(@Param("conditionPartitionNode") ConditionPartitionNode conditionPartitionNode,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<ConditionPartitionNode> selectBySql(@Param("SqlStr") String SqlStr);
}


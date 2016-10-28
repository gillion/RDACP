package com.cartan.core.conditionPartition.dao;

import com.cartan.core.conditionPartition.domain.ConditionPartition;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface ConditionPartitionMapperBase {
	@Select("SELECT * FROM cartan_common.T_CONDITION_PARTITION s WHERE s.ID = #{id}")
	ConditionPartition getConditionPartition(String id);
	
	@Insert("INSERT INTO cartan_common.T_CONDITION_PARTITION(ID,CONDITION_NAME,STATUS,MODIFY_DATE,MODIFYED,OWNER,LOCKED) VALUES(#{id},#{conditionName},#{status},#{modifyDate},#{modifyed},#{owner},#{locked})")
    void createConditionPartition(ConditionPartition conditionPartition);
    
    @Delete("DELETE FROM cartan_common.T_CONDITION_PARTITION WHERE ID = #{id}")
    void deleteConditionPartition(String id);

    @Update("update cartan_common.T_CONDITION_PARTITION set CONDITION_NAME=#{conditionName},STATUS=#{status},MODIFY_DATE=#{modifyDate},MODIFYED=#{modifyed},OWNER=#{owner},LOCKED=#{locked} where ID = #{id}")
    void updateConditionPartition(ConditionPartition conditionPartition);

    @Select("select count(*) c from cartan_common.T_CONDITION_PARTITION")
    int countAll();
    
    @Select("select * from cartan_common.T_CONDITION_PARTITION order by ID asc")
    ArrayList<ConditionPartition> selectAll();
    
    @SelectProvider(type = ConditionPartitionSqlProvider.class, method = "getSql")
    ArrayList<ConditionPartition> selectWithCondition(@Param("conditionPartition") ConditionPartition conditionPartition,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<ConditionPartition> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.ruleTree.dao;

import com.cartan.core.ruleTree.domain.RuleTree;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface RuleTreeMapperBase {
	@Select("SELECT * FROM cartan_common.T_RULE_TREE s WHERE s.ID = #{id}")
	RuleTree getRuleTree(String id);
	
	@Insert("INSERT INTO cartan_common.T_RULE_TREE(ID,RULE_TREE_NAME,VERSION,STATUS,OUTPUT_WAY,MODIFY_DATE,MODIFYED,OWNER,LOCKED) VALUES(#{id},#{ruleTreeName},#{version},#{status},#{outputWay},#{modifyDate},#{modifyed},#{owner},#{locked})")
    void createRuleTree(RuleTree ruleTree);
    
    @Delete("DELETE FROM cartan_common.T_RULE_TREE WHERE ID = #{id}")
    void deleteRuleTree(String id);

    @Update("update cartan_common.T_RULE_TREE set RULE_TREE_NAME=#{ruleTreeName},VERSION=#{version},STATUS=#{status},OUTPUT_WAY=#{outputWay},MODIFY_DATE=#{modifyDate},MODIFYED=#{modifyed},OWNER=#{owner},LOCKED=#{locked} where ID = #{id}")
    void updateRuleTree(RuleTree ruleTree);

    @Select("select count(*) c from cartan_common.T_RULE_TREE")
    int countAll();
    
    @Select("select * from cartan_common.T_RULE_TREE order by ID asc")
    ArrayList<RuleTree> selectAll();
    
    @SelectProvider(type = RuleTreeSqlProvider.class, method = "getSql")
    ArrayList<RuleTree> selectWithCondition(@Param("ruleTree") RuleTree ruleTree,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<RuleTree> selectBySql(@Param("SqlStr") String SqlStr);
}


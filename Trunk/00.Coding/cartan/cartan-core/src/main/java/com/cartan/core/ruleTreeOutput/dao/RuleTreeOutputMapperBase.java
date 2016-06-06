package com.cartan.core.ruleTreeOutput.dao;

import com.cartan.core.ruleTreeOutput.domain.RuleTreeOutput;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface RuleTreeOutputMapperBase {
	@Select("SELECT * FROM cartan_common.T_RULE_TREE_OUTPUT s WHERE s.ID = #{id}")
	RuleTreeOutput getRuleTreeOutput(String id);
	
	@Insert("INSERT INTO cartan_common.T_RULE_TREE_OUTPUT(ID,RULE_TREE_ID,TREE_NODE_CODE,TREE_NODE_NAME,OUTPUT_VER,OUTPUT_VALUE) VALUES(#{id},#{ruleTreeId},#{treeNodeCode},#{treeNodeName},#{outputVer},#{outputValue})")
    void createRuleTreeOutput(RuleTreeOutput ruleTreeOutput);
    
    @Delete("DELETE FROM cartan_common.T_RULE_TREE_OUTPUT WHERE ID = #{id}")
    void deleteRuleTreeOutput(String id);

    @Update("update cartan_common.T_RULE_TREE_OUTPUT set RULE_TREE_ID=#{ruleTreeId},TREE_NODE_CODE=#{treeNodeCode},TREE_NODE_NAME=#{treeNodeName},OUTPUT_VER=#{outputVer},OUTPUT_VALUE=#{outputValue} where ID = #{id}")
    void updateRuleTreeOutput(RuleTreeOutput ruleTreeOutput);

    @Select("select count(*) c from cartan_common.T_RULE_TREE_OUTPUT")
    int countAll();
    
    @Select("select * from cartan_common.T_RULE_TREE_OUTPUT order by ID asc")
    ArrayList<RuleTreeOutput> selectAll();
    
    @SelectProvider(type = RuleTreeOutputSqlProvider.class, method = "getSql")
    ArrayList<RuleTreeOutput> selectWithCondition(@Param("ruleTreeOutput") RuleTreeOutput ruleTreeOutput,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<RuleTreeOutput> selectBySql(@Param("SqlStr") String SqlStr);
}


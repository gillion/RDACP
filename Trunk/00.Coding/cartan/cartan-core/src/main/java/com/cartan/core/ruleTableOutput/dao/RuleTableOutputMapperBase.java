package com.cartan.core.ruleTableOutput.dao;

import com.cartan.core.ruleTableOutput.domain.RuleTableOutput;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface RuleTableOutputMapperBase {
	@Select("SELECT * FROM cartan_common.T_RULE_TABLE_OUTPUT s WHERE s.ID = #{id}")
	RuleTableOutput getRuleTableOutput(String id);
	
	@Insert("INSERT INTO cartan_common.T_RULE_TABLE_OUTPUT(ID,RULE_TABLE_ID,OUTPUT_LOCATION,OUTPUT_VAR,OUTPUT_VALUE) VALUES(#{id},#{ruleTableId},#{outputLocation},#{outputVar},#{outputValue})")
    void createRuleTableOutput(RuleTableOutput ruleTableOutput);
    
    @Delete("DELETE FROM cartan_common.T_RULE_TABLE_OUTPUT WHERE ID = #{id}")
    void deleteRuleTableOutput(String id);

    @Update("update cartan_common.T_RULE_TABLE_OUTPUT set RULE_TABLE_ID=#{ruleTableId},OUTPUT_LOCATION=#{outputLocation},OUTPUT_VAR=#{outputVar},OUTPUT_VALUE=#{outputValue} where ID = #{id}")
    void updateRuleTableOutput(RuleTableOutput ruleTableOutput);

    @Select("select count(*) c from cartan_common.T_RULE_TABLE_OUTPUT")
    int countAll();
    
    @Select("select * from cartan_common.T_RULE_TABLE_OUTPUT order by ID asc")
    ArrayList<RuleTableOutput> selectAll();
    
    @SelectProvider(type = RuleTableOutputSqlProvider.class, method = "getSql")
    ArrayList<RuleTableOutput> selectWithCondition(@Param("ruleTableOutput") RuleTableOutput ruleTableOutput,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<RuleTableOutput> selectBySql(@Param("SqlStr") String SqlStr);
}


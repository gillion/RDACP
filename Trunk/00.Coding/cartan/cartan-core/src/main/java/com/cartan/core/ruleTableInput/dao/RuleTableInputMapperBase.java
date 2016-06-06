package com.cartan.core.ruleTableInput.dao;

import com.cartan.core.ruleTableInput.domain.RuleTableInput;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface RuleTableInputMapperBase {
	@Select("SELECT * FROM cartan_common.T_RULE_TABLE_INPUT s WHERE s.ID = #{id}")
	RuleTableInput getRuleTableInput(String id);
	
	@Insert("INSERT INTO cartan_common.T_RULE_TABLE_INPUT(ID,RULE_TABLE_ID,OUTPUT_LOCATION,INPUT_VAR,INPUT_VALUE) VALUES(#{id},#{ruleTableId},#{outputLocation},#{inputVar},#{inputValue})")
    void createRuleTableInput(RuleTableInput ruleTableInput);
    
    @Delete("DELETE FROM cartan_common.T_RULE_TABLE_INPUT WHERE ID = #{id}")
    void deleteRuleTableInput(String id);

    @Update("update cartan_common.T_RULE_TABLE_INPUT set RULE_TABLE_ID=#{ruleTableId},OUTPUT_LOCATION=#{outputLocation},INPUT_VAR=#{inputVar},INPUT_VALUE=#{inputValue} where ID = #{id}")
    void updateRuleTableInput(RuleTableInput ruleTableInput);

    @Select("select count(*) c from cartan_common.T_RULE_TABLE_INPUT")
    int countAll();
    
    @Select("select * from cartan_common.T_RULE_TABLE_INPUT order by ID asc")
    ArrayList<RuleTableInput> selectAll();
    
    @SelectProvider(type = RuleTableInputSqlProvider.class, method = "getSql")
    ArrayList<RuleTableInput> selectWithCondition(@Param("ruleTableInput") RuleTableInput ruleTableInput,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<RuleTableInput> selectBySql(@Param("SqlStr") String SqlStr);
}


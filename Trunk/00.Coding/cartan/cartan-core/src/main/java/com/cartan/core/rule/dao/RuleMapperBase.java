package com.cartan.core.rule.dao;

import com.cartan.core.rule.domain.Rule;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface RuleMapperBase {
	@Select("SELECT * FROM cartan_common.T_RULE s WHERE s.ID = #{id}")
	Rule getRule(String id);
	
	@Insert("INSERT INTO cartan_common.T_RULE(ID,RULE_NAME,RULESET_ID,IS_USED,PRI_LEVEL,CONTENT_TYPE,EFFECT_DATE,INVALID_DATE,CREATOR,CREATE_DATE,MODIFY_DATE,MODIFYED,OWNER,LOCKED) VALUES(#{id},#{ruleName},#{rulesetId},#{isUsed},#{priLevel},#{contentType},#{effectDate},#{invalidDate},#{creator},#{createDate},#{modifyDate},#{modifyed},#{owner},#{locked})")
    void createRule(Rule rule);
    
    @Delete("DELETE FROM cartan_common.T_RULE WHERE ID = #{id}")
    void deleteRule(String id);

    @Update("update cartan_common.T_RULE set RULE_NAME=#{ruleName},RULESET_ID=#{rulesetId},IS_USED=#{isUsed},PRI_LEVEL=#{priLevel},CONTENT_TYPE=#{contentType},EFFECT_DATE=#{effectDate},INVALID_DATE=#{invalidDate},CREATOR=#{creator},CREATE_DATE=#{createDate},MODIFY_DATE=#{modifyDate},MODIFYED=#{modifyed},OWNER=#{owner},LOCKED=#{locked} where ID = #{id}")
    void updateRule(Rule rule);

    @Select("select count(*) c from cartan_common.T_RULE")
    int countAll();
    
    @Select("select * from cartan_common.T_RULE order by ID asc")
    ArrayList<Rule> selectAll();
    
    @SelectProvider(type = RuleSqlProvider.class, method = "getSql")
    ArrayList<Rule> selectWithCondition(@Param("rule") Rule rule,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<Rule> selectBySql(@Param("SqlStr") String SqlStr);
}


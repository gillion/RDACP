package com.cartan.core.ruleTable.dao;

import com.cartan.core.ruleTable.domain.RuleTable;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface RuleTableMapperBase {
	@Select("SELECT * FROM cartan_common.T_RULE_TABLE s WHERE s.ID = #{id}")
	RuleTable getRuleTable(String id);
	
	@Insert("INSERT INTO cartan_common.T_RULE_TABLE(ID,RULE_TABLE_NAME,VERSION,STATUS,MODIFY_DATE,MODIFYED,OWNER,LOCKED) VALUES(#{id},#{ruleTableName},#{version},#{status},#{modifyDate},#{modifyed},#{owner},#{locked})")
    void createRuleTable(RuleTable ruleTable);
    
    @Delete("DELETE FROM cartan_common.T_RULE_TABLE WHERE ID = #{id}")
    void deleteRuleTable(String id);

    @Update("update cartan_common.T_RULE_TABLE set RULE_TABLE_NAME=#{ruleTableName},VERSION=#{version},STATUS=#{status},MODIFY_DATE=#{modifyDate},MODIFYED=#{modifyed},OWNER=#{owner},LOCKED=#{locked} where ID = #{id}")
    void updateRuleTable(RuleTable ruleTable);

    @Select("select count(*) c from cartan_common.T_RULE_TABLE")
    int countAll();
    
    @Select("select * from cartan_common.T_RULE_TABLE order by ID asc")
    ArrayList<RuleTable> selectAll();
    
    @SelectProvider(type = RuleTableSqlProvider.class, method = "getSql")
    ArrayList<RuleTable> selectWithCondition(@Param("ruleTable") RuleTable ruleTable,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<RuleTable> selectBySql(@Param("SqlStr") String SqlStr);
}


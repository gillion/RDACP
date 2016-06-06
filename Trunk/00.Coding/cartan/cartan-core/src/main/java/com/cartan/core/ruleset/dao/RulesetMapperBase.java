package com.cartan.core.ruleset.dao;

import com.cartan.core.ruleset.domain.Ruleset;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface RulesetMapperBase {
	@Select("SELECT * FROM cartan_common.T_RULESET s WHERE s.ID = #{id}")
	Ruleset getRuleset(String id);
	
	@Insert("INSERT INTO cartan_common.T_RULESET(ID,RULESET_NAME,VERSION,STATUS,MODIFY_DATE,MODIFYED,OWNER,LOCKED) VALUES(#{id},#{rulesetName},#{version},#{status},#{modifyDate},#{modifyed},#{owner},#{locked})")
    void createRuleset(Ruleset ruleset);
    
    @Delete("DELETE FROM cartan_common.T_RULESET WHERE ID = #{id}")
    void deleteRuleset(String id);

    @Update("update cartan_common.T_RULESET set RULESET_NAME=#{rulesetName},VERSION=#{version},STATUS=#{status},MODIFY_DATE=#{modifyDate},MODIFYED=#{modifyed},OWNER=#{owner},LOCKED=#{locked} where ID = #{id}")
    void updateRuleset(Ruleset ruleset);

    @Select("select count(*) c from cartan_common.T_RULESET")
    int countAll();
    
    @Select("select * from cartan_common.T_RULESET order by ID asc")
    ArrayList<Ruleset> selectAll();
    
    @SelectProvider(type = RulesetSqlProvider.class, method = "getSql")
    ArrayList<Ruleset> selectWithCondition(@Param("ruleset") Ruleset ruleset,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<Ruleset> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.groupAction.dao;

import com.cartan.core.groupAction.domain.GroupAction;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface GroupActionMapperBase {
	@Select("SELECT * FROM cartan_common.t_group_action s WHERE s.id = #{id}")
	GroupAction getGroupAction(String id);
	
	@Insert("INSERT INTO cartan_common.t_group_action(id,name,begintime,endtime,addr,leadings,memoinfo,mincount,budget,spending) VALUES(#{id},#{name},#{begintime},#{endtime},#{addr},#{leadings},#{memoinfo},#{mincount},#{budget},#{spending})")
    void createGroupAction(GroupAction groupAction);
    
    @Delete("DELETE FROM cartan_common.t_group_action WHERE id = #{id}")
    void deleteGroupAction(String id);

    @Update("update cartan_common.t_group_action set name=#{name},begintime=#{begintime},endtime=#{endtime},addr=#{addr},leadings=#{leadings},memoinfo=#{memoinfo},mincount=#{mincount},budget=#{budget},spending=#{spending} where id = #{id}")
    void updateGroupAction(GroupAction groupAction);

    @Select("select count(*) c from cartan_common.t_group_action")
    int countAll();
    
    @Select("select * from cartan_common.t_group_action order by id asc")
    ArrayList<GroupAction> selectAll();
    
    @SelectProvider(type = GroupActionSqlProvider.class, method = "getSql")
    ArrayList<GroupAction> selectWithCondition(@Param("groupAction") GroupAction groupAction,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<GroupAction> selectBySql(@Param("SqlStr") String SqlStr);
}


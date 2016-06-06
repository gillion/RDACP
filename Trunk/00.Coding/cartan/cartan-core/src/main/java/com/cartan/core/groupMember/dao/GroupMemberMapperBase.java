package com.cartan.core.groupMember.dao;

import com.cartan.core.groupMember.domain.GroupMember;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface GroupMemberMapperBase {
	@Select("SELECT * FROM cartan_common.t_group_member s WHERE s.id = #{id}")
	GroupMember getGroupMember(String id);
	
	@Insert("INSERT INTO cartan_common.t_group_member(id,user,GroupInfoId,area,name,tel,unit,addr) VALUES(#{id},#{user},#{groupInfoId},#{area},#{name},#{tel},#{unit},#{addr})")
    void createGroupMember(GroupMember groupMember);
    
    @Delete("DELETE FROM cartan_common.t_group_member WHERE id = #{id}")
    void deleteGroupMember(String id);

    @Update("update cartan_common.t_group_member set user=#{user},GroupInfoId=#{groupInfoId},area=#{area},name=#{name},tel=#{tel},unit=#{unit},addr=#{addr} where id = #{id}")
    void updateGroupMember(GroupMember groupMember);

    @Select("select count(*) c from cartan_common.t_group_member")
    int countAll();
    
    @Select("select * from cartan_common.t_group_member order by id asc")
    ArrayList<GroupMember> selectAll();
    
    @SelectProvider(type = GroupMemberSqlProvider.class, method = "getSql")
    ArrayList<GroupMember> selectWithCondition(@Param("groupMember") GroupMember groupMember,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<GroupMember> selectBySql(@Param("SqlStr") String SqlStr);
}


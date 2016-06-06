package com.cartan.core.groupInfo.dao;

import com.cartan.core.groupInfo.domain.GroupInfo;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface GroupInfoMapperBase {
	@Select("SELECT * FROM cartan_common.t_group_info s WHERE s.id = #{id}")
	GroupInfo getGroupInfo(String id);
	
	@Insert("INSERT INTO cartan_common.t_group_info(id,type,name,createtime,creator,memoinfo) VALUES(#{id},#{type},#{name},#{createtime},#{creator},#{memoinfo})")
    void createGroupInfo(GroupInfo groupInfo);
    
    @Delete("DELETE FROM cartan_common.t_group_info WHERE id = #{id}")
    void deleteGroupInfo(String id);

    @Update("update cartan_common.t_group_info set type=#{type},name=#{name},createtime=#{createtime},creator=#{creator},memoinfo=#{memoinfo} where id = #{id}")
    void updateGroupInfo(GroupInfo groupInfo);

    @Select("select count(*) c from cartan_common.t_group_info")
    int countAll();
    
    @Select("select * from cartan_common.t_group_info order by id asc")
    ArrayList<GroupInfo> selectAll();
    
    @SelectProvider(type = GroupInfoSqlProvider.class, method = "getSql")
    ArrayList<GroupInfo> selectWithCondition(@Param("groupInfo") GroupInfo groupInfo,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<GroupInfo> selectBySql(@Param("SqlStr") String SqlStr);
}


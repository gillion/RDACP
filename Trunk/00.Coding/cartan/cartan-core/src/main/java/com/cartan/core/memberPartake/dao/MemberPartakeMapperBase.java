package com.cartan.core.memberPartake.dao;

import com.cartan.core.memberPartake.domain.MemberPartake;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface MemberPartakeMapperBase {
	@Select("SELECT * FROM cartan_common.t_member_partake s WHERE s.id = #{id}")
	MemberPartake getMemberPartake(String id);
	
	@Insert("INSERT INTO cartan_common.t_member_partake(id,GroupActId,GroupMemberId,partaketime,spending) VALUES(#{id},#{groupActId},#{groupMemberId},#{partaketime},#{spending})")
    void createMemberPartake(MemberPartake memberPartake);
    
    @Delete("DELETE FROM cartan_common.t_member_partake WHERE id = #{id}")
    void deleteMemberPartake(String id);

    @Update("update cartan_common.t_member_partake set GroupActId=#{groupActId},GroupMemberId=#{groupMemberId},partaketime=#{partaketime},spending=#{spending} where id = #{id}")
    void updateMemberPartake(MemberPartake memberPartake);

    @Select("select count(*) c from cartan_common.t_member_partake")
    int countAll();
    
    @Select("select * from cartan_common.t_member_partake order by id asc")
    ArrayList<MemberPartake> selectAll();
    
    @SelectProvider(type = MemberPartakeSqlProvider.class, method = "getSql")
    ArrayList<MemberPartake> selectWithCondition(@Param("memberPartake") MemberPartake memberPartake,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<MemberPartake> selectBySql(@Param("SqlStr") String SqlStr);
}


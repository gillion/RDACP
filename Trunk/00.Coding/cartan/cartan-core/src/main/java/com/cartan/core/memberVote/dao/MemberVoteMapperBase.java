package com.cartan.core.memberVote.dao;

import com.cartan.core.memberVote.domain.MemberVote;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface MemberVoteMapperBase {
	@Select("SELECT * FROM cartan_common.t_member_vote s WHERE s.id = #{id}")
	MemberVote getMemberVote(String id);
	
	@Insert("INSERT INTO cartan_common.t_member_vote(id,GroupActId,GroupMemberId,votetime,votestate) VALUES(#{id},#{groupActId},#{groupMemberId},#{votetime},#{votestate})")
    void createMemberVote(MemberVote memberVote);
    
    @Delete("DELETE FROM cartan_common.t_member_vote WHERE id = #{id}")
    void deleteMemberVote(String id);

    @Update("update cartan_common.t_member_vote set GroupActId=#{groupActId},GroupMemberId=#{groupMemberId},votetime=#{votetime},votestate=#{votestate} where id = #{id}")
    void updateMemberVote(MemberVote memberVote);

    @Select("select count(*) c from cartan_common.t_member_vote")
    int countAll();
    
    @Select("select * from cartan_common.t_member_vote order by id asc")
    ArrayList<MemberVote> selectAll();
    
    @SelectProvider(type = MemberVoteSqlProvider.class, method = "getSql")
    ArrayList<MemberVote> selectWithCondition(@Param("memberVote") MemberVote memberVote,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<MemberVote> selectBySql(@Param("SqlStr") String SqlStr);
}


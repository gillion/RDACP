package com.cartan.core.memberClothingsize.dao;

import com.cartan.core.memberClothingsize.domain.MemberClothingsize;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface MemberClothingsizeMapperBase {
	@Select("SELECT * FROM cartan_common.t_member_clothingsize s WHERE s.id = #{id}")
	MemberClothingsize getMemberClothingsize(String id);
	
	@Insert("INSERT INTO cartan_common.t_member_clothingsize(id,name,depart,height,weight,clothingSize) VALUES(#{id},#{name},#{depart},#{height},#{weight},#{clothingSize})")
    void createMemberClothingsize(MemberClothingsize memberClothingsize);
    
    @Delete("DELETE FROM cartan_common.t_member_clothingsize WHERE id = #{id}")
    void deleteMemberClothingsize(String id);

    @Update("update cartan_common.t_member_clothingsize set name=#{name},depart=#{depart},height=#{height},weight=#{weight},clothingSize=#{clothingSize} where id = #{id}")
    void updateMemberClothingsize(MemberClothingsize memberClothingsize);

    @Select("select count(*) c from cartan_common.t_member_clothingsize")
    int countAll();
    
    @Select("select * from cartan_common.t_member_clothingsize order by id asc")
    ArrayList<MemberClothingsize> selectAll();
    
    @SelectProvider(type = MemberClothingsizeSqlProvider.class, method = "getSql")
    ArrayList<MemberClothingsize> selectWithCondition(@Param("memberClothingsize") MemberClothingsize memberClothingsize,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<MemberClothingsize> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.comcode.dao;

import com.cartan.core.comcode.domain.Comcode;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface ComcodeMapperBase {
	@Select("SELECT * FROM cartan_common.T_COMCODE s WHERE s.ID = #{id}")
	Comcode getComcode(String id);
	
	@Insert("INSERT INTO cartan_common.T_COMCODE(ID,TYPECODE,CODE,NAME,SHORTNAME) VALUES(#{id},#{typecode},#{code},#{name},#{shortname})")
    void createComcode(Comcode comcode);
    
    @Delete("DELETE FROM cartan_common.T_COMCODE WHERE ID = #{id}")
    void deleteComcode(String id);

    @Update("update cartan_common.T_COMCODE set TYPECODE=#{typecode},CODE=#{code},NAME=#{name},SHORTNAME=#{shortname} where ID = #{id}")
    void updateComcode(Comcode comcode);

    @Select("select count(*) c from cartan_common.T_COMCODE")
    int countAll();
    
    @Select("select * from cartan_common.T_COMCODE order by ID asc")
    ArrayList<Comcode> selectAll();
    
    @SelectProvider(type = ComcodeSqlProvider.class, method = "getSql")
    ArrayList<Comcode> selectWithCondition(@Param("comcode") Comcode comcode,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<Comcode> selectBySql(@Param("SqlStr") String SqlStr);
}


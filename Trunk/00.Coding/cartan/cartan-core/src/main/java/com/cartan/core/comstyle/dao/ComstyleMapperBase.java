package com.cartan.core.comstyle.dao;

import com.cartan.core.comstyle.domain.Comstyle;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface ComstyleMapperBase {
	@Select("SELECT * FROM cartan_common.T_COMSTYLE s WHERE s.ID = #{id}")
	Comstyle getComstyle(String id);
	
	@Insert("INSERT INTO cartan_common.T_COMSTYLE(ID,CODE,NAME) VALUES(#{id},#{code},#{name})")
    void createComstyle(Comstyle comstyle);
    
    @Delete("DELETE FROM cartan_common.T_COMSTYLE WHERE ID = #{id}")
    void deleteComstyle(String id);

    @Update("update cartan_common.T_COMSTYLE set CODE=#{code},NAME=#{name} where ID = #{id}")
    void updateComstyle(Comstyle comstyle);

    @Select("select count(*) c from cartan_common.T_COMSTYLE")
    int countAll();
    
    @Select("select * from cartan_common.T_COMSTYLE order by ID asc")
    ArrayList<Comstyle> selectAll();
    
    @SelectProvider(type = ComstyleSqlProvider.class, method = "getSql")
    ArrayList<Comstyle> selectWithCondition(@Param("comstyle") Comstyle comstyle,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<Comstyle> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.codegener.dao;

import com.cartan.core.codegener.domain.Codegener;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface CodegenerMapperBase {
	@Select("SELECT * FROM cartan_common.t_codegener s WHERE s.ID = #{id}")
	Codegener getCodegener(String id);
	
	@Insert("INSERT INTO cartan_common.t_codegener(ID,SETUP_NAME,BASE_PACKAGE,MODULE_NAME,ROOT,OUTPUT,SYSNAME,STATUS,LOCK_MAN,LOCK_TIME,projectName) VALUES(#{id},#{setupName},#{basePackage},#{moduleName},#{root},#{output},#{sysname},#{status},#{lockMan},#{lockTime},#{projectName})")
    void createCodegener(Codegener codegener);
    
    @Delete("DELETE FROM cartan_common.t_codegener WHERE ID = #{id}")
    void deleteCodegener(String id);

    @Update("update cartan_common.t_codegener set SETUP_NAME=#{setupName},BASE_PACKAGE=#{basePackage},MODULE_NAME=#{moduleName},ROOT=#{root},OUTPUT=#{output},SYSNAME=#{sysname},STATUS=#{status},LOCK_MAN=#{lockMan},LOCK_TIME=#{lockTime},projectName=#{projectName} where ID = #{id}")
    void updateCodegener(Codegener codegener);

    @Select("select count(*) c from cartan_common.t_codegener")
    int countAll();
    
    @Select("select * from cartan_common.t_codegener order by ID asc")
    ArrayList<Codegener> selectAll();
    
    @SelectProvider(type = CodegenerSqlProvider.class, method = "getSql")
    ArrayList<Codegener> selectWithCondition(@Param("codegener") Codegener codegener,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<Codegener> selectBySql(@Param("SqlStr") String SqlStr);
}


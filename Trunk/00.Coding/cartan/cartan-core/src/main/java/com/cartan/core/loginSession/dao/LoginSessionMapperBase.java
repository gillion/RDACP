package com.cartan.core.loginSession.dao;

import com.cartan.core.loginSession.domain.LoginSession;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface LoginSessionMapperBase {
	@Select("SELECT * FROM cartan_common.t_login_session s WHERE s.id = #{id}")
	LoginSession getLoginSession(String id);
	
	@Insert("INSERT INTO cartan_common.t_login_session(id,sessionid,loginUser,UserName,loginTime,projectName) VALUES(#{id},#{sessionid},#{loginUser},#{userName},#{loginTime},#{projectName})")
    void createLoginSession(LoginSession loginSession);
    
    @Delete("DELETE FROM cartan_common.t_login_session WHERE id = #{id}")
    void deleteLoginSession(String id);

    @Update("update cartan_common.t_login_session set sessionid=#{sessionid},loginUser=#{loginUser},UserName=#{userName},loginTime=#{loginTime},projectName=#{projectName} where id = #{id}")
    void updateLoginSession(LoginSession loginSession);

    @Select("select count(*) c from cartan_common.t_login_session")
    int countAll();
    
    @Select("select * from cartan_common.t_login_session order by id asc")
    ArrayList<LoginSession> selectAll();
    
    @SelectProvider(type = LoginSessionSqlProvider.class, method = "getSql")
    ArrayList<LoginSession> selectWithCondition(@Param("loginSession") LoginSession loginSession,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<LoginSession> selectBySql(@Param("SqlStr") String SqlStr);
}


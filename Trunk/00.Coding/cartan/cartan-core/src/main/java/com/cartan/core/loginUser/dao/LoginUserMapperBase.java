package com.cartan.core.loginUser.dao;

import com.cartan.core.loginUser.domain.LoginUser;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface LoginUserMapperBase {
	@Select("SELECT * FROM cartan_common.t_login_user s WHERE s.id = #{id}")
	LoginUser getLoginUser(String id);
	
	@Insert("INSERT INTO cartan_common.t_login_user(id,user,pwd,power) VALUES(#{id},#{user},#{pwd},#{power})")
    void createLoginUser(LoginUser loginUser);
    
    @Delete("DELETE FROM cartan_common.t_login_user WHERE id = #{id}")
    void deleteLoginUser(String id);

    @Update("update cartan_common.t_login_user set user=#{user},pwd=#{pwd},power=#{power} where id = #{id}")
    void updateLoginUser(LoginUser loginUser);

    @Select("select count(*) c from cartan_common.t_login_user")
    int countAll();
    
    @Select("select * from cartan_common.t_login_user order by id asc")
    ArrayList<LoginUser> selectAll();
    
    @SelectProvider(type = LoginUserSqlProvider.class, method = "getSql")
    ArrayList<LoginUser> selectWithCondition(@Param("loginUser") LoginUser loginUser,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<LoginUser> selectBySql(@Param("SqlStr") String SqlStr);
}


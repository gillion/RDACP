package com.cartan.core.sysUser.dao;

import com.cartan.core.sysUser.domain.SysUser;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface SysUserMapperBase {
	@Select("SELECT * FROM cartan_common.t_sys_user s WHERE s.user_id = #{userId}")
	SysUser getSysUser(String userId);
	
	@Insert("INSERT INTO cartan_common.t_sys_user(user_id,user_name,password,user_type,last_logon_time,last_logon_ip,status,create_time) VALUES(#{userId},#{userName},#{password},#{userType},#{lastLogonTime},#{lastLogonIp},#{status},#{createTime})")
    void createSysUser(SysUser sysUser);
    
    @Delete("DELETE FROM cartan_common.t_sys_user WHERE user_id = #{userId}")
    void deleteSysUser(String userId);

    @Update("update cartan_common.t_sys_user set user_name=#{userName},password=#{password},user_type=#{userType},last_logon_time=#{lastLogonTime},last_logon_ip=#{lastLogonIp},status=#{status},create_time=#{createTime} where user_id = #{userId}")
    void updateSysUser(SysUser sysUser);

    @Select("select count(*) c from cartan_common.t_sys_user")
    int countAll();
    
    @Select("select * from cartan_common.t_sys_user order by user_id asc")
    ArrayList<SysUser> selectAll();
    
    @SelectProvider(type = SysUserSqlProvider.class, method = "getSql")
    ArrayList<SysUser> selectWithCondition(@Param("sysUser") SysUser sysUser,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<SysUser> selectBySql(@Param("SqlStr") String SqlStr);
}


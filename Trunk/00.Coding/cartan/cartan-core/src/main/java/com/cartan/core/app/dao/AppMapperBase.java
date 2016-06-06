package com.cartan.core.app.dao;

import com.cartan.core.app.domain.App;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface AppMapperBase {
	@Select("SELECT * FROM cartan_common.t_app s WHERE s.app_name = #{appName}")
	App getApp(String appName);
	
	@Insert("INSERT INTO cartan_common.t_app(app_name,app_label,appkey,secret,description,author,create_time,status,auditor,audit_info,audit_time,curr_version) VALUES(#{appName},#{appLabel},#{appkey},#{secret},#{description},#{author},#{createTime},#{status},#{auditor},#{auditInfo},#{auditTime},#{currVersion})")
    void createApp(App app);
    
    @Delete("DELETE FROM cartan_common.t_app WHERE app_name = #{appName}")
    void deleteApp(String appName);

    @Update("update cartan_common.t_app set app_label=#{appLabel},appkey=#{appkey},secret=#{secret},description=#{description},author=#{author},create_time=#{createTime},status=#{status},auditor=#{auditor},audit_info=#{auditInfo},audit_time=#{auditTime},curr_version=#{currVersion} where app_name = #{appName}")
    void updateApp(App app);

    @Select("select count(*) c from cartan_common.t_app")
    int countAll();
    
    @Select("select * from cartan_common.t_app order by app_name asc")
    ArrayList<App> selectAll();
    
    @SelectProvider(type = AppSqlProvider.class, method = "getSql")
    ArrayList<App> selectWithCondition(@Param("app") App app,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<App> selectBySql(@Param("SqlStr") String SqlStr);
}


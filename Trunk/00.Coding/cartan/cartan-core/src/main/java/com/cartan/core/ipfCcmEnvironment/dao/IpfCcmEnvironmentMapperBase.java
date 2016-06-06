package com.cartan.core.ipfCcmEnvironment.dao;

import com.cartan.core.ipfCcmEnvironment.domain.IpfCcmEnvironment;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmEnvironmentMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_environment s WHERE s.ID = #{id}")
	IpfCcmEnvironment getIpfCcmEnvironment(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_environment(ID,USER_CODE,PROJECT_NAME,PROJECT_PATH,SRC_PATH,TEMPLATE_PATH,WEB_CONTENT_NAME,TARGET_PROJECT_NAME,TARGET_PROJECT_PATH) VALUES(#{id},#{userCode},#{projectName},#{projectPath},#{srcPath},#{templatePath},#{webContentName},#{targetProjectName},#{targetProjectPath})")
    void createIpfCcmEnvironment(IpfCcmEnvironment ipfCcmEnvironment);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_environment WHERE ID = #{id}")
    void deleteIpfCcmEnvironment(String id);

    @Update("update cartan_common.t_ipf_ccm_environment set USER_CODE=#{userCode},PROJECT_NAME=#{projectName},PROJECT_PATH=#{projectPath},SRC_PATH=#{srcPath},TEMPLATE_PATH=#{templatePath},WEB_CONTENT_NAME=#{webContentName},TARGET_PROJECT_NAME=#{targetProjectName},TARGET_PROJECT_PATH=#{targetProjectPath} where ID = #{id}")
    void updateIpfCcmEnvironment(IpfCcmEnvironment ipfCcmEnvironment);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_environment")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_environment order by ID asc")
    ArrayList<IpfCcmEnvironment> selectAll();
    
    @SelectProvider(type = IpfCcmEnvironmentSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmEnvironment> selectWithCondition(@Param("ipfCcmEnvironment") IpfCcmEnvironment ipfCcmEnvironment,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmEnvironment> selectBySql(@Param("SqlStr") String SqlStr);
}


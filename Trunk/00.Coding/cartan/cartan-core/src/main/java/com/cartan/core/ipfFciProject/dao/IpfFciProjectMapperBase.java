package com.cartan.core.ipfFciProject.dao;

import com.cartan.core.ipfFciProject.domain.IpfFciProject;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfFciProjectMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_fci_project s WHERE s.ID = #{id}")
	IpfFciProject getIpfFciProject(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_fci_project(ID,PROJECT_NAME,PROJECT_TYPE,PROJECT_DES,DEFAULT_VIEW_ID,SVN_REPOSITORY_PATH,SVN_USER,SVN_PASSWORD,MAX_REVISON_NUMBER,DD_LANGUAGE,DB_TYPE,DB_VERSION,IS_ACTIVE) VALUES(#{id},#{projectName},#{projectType},#{projectDes},#{defaultViewId},#{svnRepositoryPath},#{svnUser},#{svnPassword},#{maxRevisonNumber},#{ddLanguage},#{dbType},#{dbVersion},#{isActive})")
    void createIpfFciProject(IpfFciProject ipfFciProject);
    
    @Delete("DELETE FROM cartan_common.t_ipf_fci_project WHERE ID = #{id}")
    void deleteIpfFciProject(String id);

    @Update("update cartan_common.t_ipf_fci_project set PROJECT_NAME=#{projectName},PROJECT_TYPE=#{projectType},PROJECT_DES=#{projectDes},DEFAULT_VIEW_ID=#{defaultViewId},SVN_REPOSITORY_PATH=#{svnRepositoryPath},SVN_USER=#{svnUser},SVN_PASSWORD=#{svnPassword},MAX_REVISON_NUMBER=#{maxRevisonNumber},DD_LANGUAGE=#{ddLanguage},DB_TYPE=#{dbType},DB_VERSION=#{dbVersion},IS_ACTIVE=#{isActive} where ID = #{id}")
    void updateIpfFciProject(IpfFciProject ipfFciProject);

    @Select("select count(*) c from cartan_common.t_ipf_fci_project")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_fci_project order by ID asc")
    ArrayList<IpfFciProject> selectAll();
    
    @SelectProvider(type = IpfFciProjectSqlProvider.class, method = "getSql")
    ArrayList<IpfFciProject> selectWithCondition(@Param("ipfFciProject") IpfFciProject ipfFciProject,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfFciProject> selectBySql(@Param("SqlStr") String SqlStr);
}


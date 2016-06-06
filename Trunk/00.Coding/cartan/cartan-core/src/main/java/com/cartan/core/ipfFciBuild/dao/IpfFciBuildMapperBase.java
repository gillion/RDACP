package com.cartan.core.ipfFciBuild.dao;

import com.cartan.core.ipfFciBuild.domain.IpfFciBuild;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfFciBuildMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_fci_build s WHERE s.ID = #{id}")
	IpfFciBuild getIpfFciBuild(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_fci_build(ID,IPF_FCI_VIEW_ID,IPF_FCI_PROJECT_ID,MAJOR_VERSION,MINOR_VERSION,MAX_VERSION_BUILD_NUMBER,IS_DEFAULT) VALUES(#{id},#{ipfFciViewId},#{ipfFciProjectId},#{majorVersion},#{minorVersion},#{maxVersionBuildNumber},#{isDefault})")
    void createIpfFciBuild(IpfFciBuild ipfFciBuild);
    
    @Delete("DELETE FROM cartan_common.t_ipf_fci_build WHERE ID = #{id}")
    void deleteIpfFciBuild(String id);

    @Update("update cartan_common.t_ipf_fci_build set IPF_FCI_VIEW_ID=#{ipfFciViewId},IPF_FCI_PROJECT_ID=#{ipfFciProjectId},MAJOR_VERSION=#{majorVersion},MINOR_VERSION=#{minorVersion},MAX_VERSION_BUILD_NUMBER=#{maxVersionBuildNumber},IS_DEFAULT=#{isDefault} where ID = #{id}")
    void updateIpfFciBuild(IpfFciBuild ipfFciBuild);

    @Select("select count(*) c from cartan_common.t_ipf_fci_build")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_fci_build order by ID asc")
    ArrayList<IpfFciBuild> selectAll();
    
    @SelectProvider(type = IpfFciBuildSqlProvider.class, method = "getSql")
    ArrayList<IpfFciBuild> selectWithCondition(@Param("ipfFciBuild") IpfFciBuild ipfFciBuild,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfFciBuild> selectBySql(@Param("SqlStr") String SqlStr);
}


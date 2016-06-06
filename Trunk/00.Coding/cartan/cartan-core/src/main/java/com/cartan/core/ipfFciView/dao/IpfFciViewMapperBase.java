package com.cartan.core.ipfFciView.dao;

import com.cartan.core.ipfFciView.domain.IpfFciView;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfFciViewMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_fci_view s WHERE s.ID = #{id}")
	IpfFciView getIpfFciView(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_fci_view(ID,VIEW_NAME,PROJECT_NAME,VIEW_DESC,SVN_BRANCHES_PATH,IS_ACTIVE,CONNECTION_STRING,IPF_FCI_PROJECT_ID,SOURCE_LABEL_ID,IS_PERMISSION_PAGE_ONLY) VALUES(#{id},#{viewName},#{projectName},#{viewDesc},#{svnBranchesPath},#{isActive},#{connectionString},#{ipfFciProjectId},#{sourceLabelId},#{isPermissionPageOnly})")
    void createIpfFciView(IpfFciView ipfFciView);
    
    @Delete("DELETE FROM cartan_common.t_ipf_fci_view WHERE ID = #{id}")
    void deleteIpfFciView(String id);

    @Update("update cartan_common.t_ipf_fci_view set VIEW_NAME=#{viewName},PROJECT_NAME=#{projectName},VIEW_DESC=#{viewDesc},SVN_BRANCHES_PATH=#{svnBranchesPath},IS_ACTIVE=#{isActive},CONNECTION_STRING=#{connectionString},IPF_FCI_PROJECT_ID=#{ipfFciProjectId},SOURCE_LABEL_ID=#{sourceLabelId},IS_PERMISSION_PAGE_ONLY=#{isPermissionPageOnly} where ID = #{id}")
    void updateIpfFciView(IpfFciView ipfFciView);

    @Select("select count(*) c from cartan_common.t_ipf_fci_view")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_fci_view order by ID asc")
    ArrayList<IpfFciView> selectAll();
    
    @SelectProvider(type = IpfFciViewSqlProvider.class, method = "getSql")
    ArrayList<IpfFciView> selectWithCondition(@Param("ipfFciView") IpfFciView ipfFciView,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfFciView> selectBySql(@Param("SqlStr") String SqlStr);
}


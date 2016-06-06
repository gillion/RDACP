package com.cartan.core.ipfFciRevision.dao;

import com.cartan.core.ipfFciRevision.domain.IpfFciRevision;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfFciRevisionMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_fci_revision s WHERE s.ID = #{id}")
	IpfFciRevision getIpfFciRevision(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_fci_revision(ID,IPF_FCI_VIEW_ID,IPF_FCI_PROJECT_ID,REVISION_NUMBER,REMARK) VALUES(#{id},#{ipfFciViewId},#{ipfFciProjectId},#{revisionNumber},#{remark})")
    void createIpfFciRevision(IpfFciRevision ipfFciRevision);
    
    @Delete("DELETE FROM cartan_common.t_ipf_fci_revision WHERE ID = #{id}")
    void deleteIpfFciRevision(String id);

    @Update("update cartan_common.t_ipf_fci_revision set IPF_FCI_VIEW_ID=#{ipfFciViewId},IPF_FCI_PROJECT_ID=#{ipfFciProjectId},REVISION_NUMBER=#{revisionNumber},REMARK=#{remark} where ID = #{id}")
    void updateIpfFciRevision(IpfFciRevision ipfFciRevision);

    @Select("select count(*) c from cartan_common.t_ipf_fci_revision")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_fci_revision order by ID asc")
    ArrayList<IpfFciRevision> selectAll();
    
    @SelectProvider(type = IpfFciRevisionSqlProvider.class, method = "getSql")
    ArrayList<IpfFciRevision> selectWithCondition(@Param("ipfFciRevision") IpfFciRevision ipfFciRevision,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfFciRevision> selectBySql(@Param("SqlStr") String SqlStr);
}


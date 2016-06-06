package com.cartan.core.ipfCcmBoCheckRelGroup.dao;

import com.cartan.core.ipfCcmBoCheckRelGroup.domain.IpfCcmBoCheckRelGroup;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoCheckRelGroupMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_check_rel_group s WHERE s.ID = #{id}")
	IpfCcmBoCheckRelGroup getIpfCcmBoCheckRelGroup(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_check_rel_group(ID,IPF_CCM_BO_CHECK_ID,GROUP_NAME,GROUP_DESC) VALUES(#{id},#{ipfCcmBoCheckId},#{groupName},#{groupDesc})")
    void createIpfCcmBoCheckRelGroup(IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_check_rel_group WHERE ID = #{id}")
    void deleteIpfCcmBoCheckRelGroup(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_check_rel_group set IPF_CCM_BO_CHECK_ID=#{ipfCcmBoCheckId},GROUP_NAME=#{groupName},GROUP_DESC=#{groupDesc} where ID = #{id}")
    void updateIpfCcmBoCheckRelGroup(IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_check_rel_group")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_check_rel_group order by ID asc")
    ArrayList<IpfCcmBoCheckRelGroup> selectAll();
    
    @SelectProvider(type = IpfCcmBoCheckRelGroupSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoCheckRelGroup> selectWithCondition(@Param("ipfCcmBoCheckRelGroup") IpfCcmBoCheckRelGroup ipfCcmBoCheckRelGroup,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoCheckRelGroup> selectBySql(@Param("SqlStr") String SqlStr);
}


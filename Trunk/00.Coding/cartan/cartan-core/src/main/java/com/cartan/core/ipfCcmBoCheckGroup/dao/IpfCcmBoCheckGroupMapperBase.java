package com.cartan.core.ipfCcmBoCheckGroup.dao;

import com.cartan.core.ipfCcmBoCheckGroup.domain.IpfCcmBoCheckGroup;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoCheckGroupMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_check_group s WHERE s.ID = #{id}")
	IpfCcmBoCheckGroup getIpfCcmBoCheckGroup(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_check_group(ID,IPF_CCM_BO_ID,GROUP_NAME,GROUP_DESC) VALUES(#{id},#{ipfCcmBoId},#{groupName},#{groupDesc})")
    void createIpfCcmBoCheckGroup(IpfCcmBoCheckGroup ipfCcmBoCheckGroup);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_check_group WHERE ID = #{id}")
    void deleteIpfCcmBoCheckGroup(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_check_group set IPF_CCM_BO_ID=#{ipfCcmBoId},GROUP_NAME=#{groupName},GROUP_DESC=#{groupDesc} where ID = #{id}")
    void updateIpfCcmBoCheckGroup(IpfCcmBoCheckGroup ipfCcmBoCheckGroup);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_check_group")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_check_group order by ID asc")
    ArrayList<IpfCcmBoCheckGroup> selectAll();
    
    @SelectProvider(type = IpfCcmBoCheckGroupSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoCheckGroup> selectWithCondition(@Param("ipfCcmBoCheckGroup") IpfCcmBoCheckGroup ipfCcmBoCheckGroup,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoCheckGroup> selectBySql(@Param("SqlStr") String SqlStr);
}


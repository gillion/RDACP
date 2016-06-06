package com.cartan.core.ipfCcmBoCheck.dao;

import com.cartan.core.ipfCcmBoCheck.domain.IpfCcmBoCheck;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoCheckMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_check s WHERE s.ID = #{id}")
	IpfCcmBoCheck getIpfCcmBoCheck(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_check(ID,CHECK_TYPE,CHECK_NAME,BO_NAME,PROPERTY_NAME,PROPERTY_DESC) VALUES(#{id},#{checkType},#{checkName},#{boName},#{propertyName},#{propertyDesc})")
    void createIpfCcmBoCheck(IpfCcmBoCheck ipfCcmBoCheck);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_check WHERE ID = #{id}")
    void deleteIpfCcmBoCheck(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_check set CHECK_TYPE=#{checkType},CHECK_NAME=#{checkName},BO_NAME=#{boName},PROPERTY_NAME=#{propertyName},PROPERTY_DESC=#{propertyDesc} where ID = #{id}")
    void updateIpfCcmBoCheck(IpfCcmBoCheck ipfCcmBoCheck);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_check")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_check order by ID asc")
    ArrayList<IpfCcmBoCheck> selectAll();
    
    @SelectProvider(type = IpfCcmBoCheckSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoCheck> selectWithCondition(@Param("ipfCcmBoCheck") IpfCcmBoCheck ipfCcmBoCheck,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoCheck> selectBySql(@Param("SqlStr") String SqlStr);
}


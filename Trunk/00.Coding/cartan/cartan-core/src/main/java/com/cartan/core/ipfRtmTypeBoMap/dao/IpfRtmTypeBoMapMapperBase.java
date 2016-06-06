package com.cartan.core.ipfRtmTypeBoMap.dao;

import com.cartan.core.ipfRtmTypeBoMap.domain.IpfRtmTypeBoMap;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRtmTypeBoMapMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rtm_type_bo_map s WHERE s.ID = #{id}")
	IpfRtmTypeBoMap getIpfRtmTypeBoMap(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rtm_type_bo_map(ID,IPF_RTM_TYPE_BO_ID,SOURCE_VALUE,DEST_VALUE) VALUES(#{id},#{ipfRtmTypeBoId},#{sourceValue},#{destValue})")
    void createIpfRtmTypeBoMap(IpfRtmTypeBoMap ipfRtmTypeBoMap);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rtm_type_bo_map WHERE ID = #{id}")
    void deleteIpfRtmTypeBoMap(String id);

    @Update("update cartan_common.t_ipf_rtm_type_bo_map set IPF_RTM_TYPE_BO_ID=#{ipfRtmTypeBoId},SOURCE_VALUE=#{sourceValue},DEST_VALUE=#{destValue} where ID = #{id}")
    void updateIpfRtmTypeBoMap(IpfRtmTypeBoMap ipfRtmTypeBoMap);

    @Select("select count(*) c from cartan_common.t_ipf_rtm_type_bo_map")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rtm_type_bo_map order by ID asc")
    ArrayList<IpfRtmTypeBoMap> selectAll();
    
    @SelectProvider(type = IpfRtmTypeBoMapSqlProvider.class, method = "getSql")
    ArrayList<IpfRtmTypeBoMap> selectWithCondition(@Param("ipfRtmTypeBoMap") IpfRtmTypeBoMap ipfRtmTypeBoMap,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRtmTypeBoMap> selectBySql(@Param("SqlStr") String SqlStr);
}


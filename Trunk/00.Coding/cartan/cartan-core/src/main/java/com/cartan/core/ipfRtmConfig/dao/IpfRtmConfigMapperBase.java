package com.cartan.core.ipfRtmConfig.dao;

import com.cartan.core.ipfRtmConfig.domain.IpfRtmConfig;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRtmConfigMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rtm_config s WHERE s.ID = #{id}")
	IpfRtmConfig getIpfRtmConfig(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rtm_config(ID,CONFIG_CODE,CONFIG_NAME,TYPE_CODE) VALUES(#{id},#{configCode},#{configName},#{typeCode})")
    void createIpfRtmConfig(IpfRtmConfig ipfRtmConfig);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rtm_config WHERE ID = #{id}")
    void deleteIpfRtmConfig(String id);

    @Update("update cartan_common.t_ipf_rtm_config set CONFIG_CODE=#{configCode},CONFIG_NAME=#{configName},TYPE_CODE=#{typeCode} where ID = #{id}")
    void updateIpfRtmConfig(IpfRtmConfig ipfRtmConfig);

    @Select("select count(*) c from cartan_common.t_ipf_rtm_config")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rtm_config order by ID asc")
    ArrayList<IpfRtmConfig> selectAll();
    
    @SelectProvider(type = IpfRtmConfigSqlProvider.class, method = "getSql")
    ArrayList<IpfRtmConfig> selectWithCondition(@Param("ipfRtmConfig") IpfRtmConfig ipfRtmConfig,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRtmConfig> selectBySql(@Param("SqlStr") String SqlStr);
}


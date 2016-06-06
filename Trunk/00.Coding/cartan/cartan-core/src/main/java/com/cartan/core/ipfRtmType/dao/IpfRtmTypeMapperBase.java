package com.cartan.core.ipfRtmType.dao;

import com.cartan.core.ipfRtmType.domain.IpfRtmType;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRtmTypeMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rtm_type s WHERE s.ID = #{id}")
	IpfRtmType getIpfRtmType(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rtm_type(ID,TYPE_CODE,TYPE_NAME) VALUES(#{id},#{typeCode},#{typeName})")
    void createIpfRtmType(IpfRtmType ipfRtmType);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rtm_type WHERE ID = #{id}")
    void deleteIpfRtmType(String id);

    @Update("update cartan_common.t_ipf_rtm_type set TYPE_CODE=#{typeCode},TYPE_NAME=#{typeName} where ID = #{id}")
    void updateIpfRtmType(IpfRtmType ipfRtmType);

    @Select("select count(*) c from cartan_common.t_ipf_rtm_type")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rtm_type order by ID asc")
    ArrayList<IpfRtmType> selectAll();
    
    @SelectProvider(type = IpfRtmTypeSqlProvider.class, method = "getSql")
    ArrayList<IpfRtmType> selectWithCondition(@Param("ipfRtmType") IpfRtmType ipfRtmType,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRtmType> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.ipfRtmTypeBoAttr.dao;

import com.cartan.core.ipfRtmTypeBoAttr.domain.IpfRtmTypeBoAttr;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRtmTypeBoAttrMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rtm_type_bo_attr s WHERE s.ID = #{id}")
	IpfRtmTypeBoAttr getIpfRtmTypeBoAttr(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rtm_type_bo_attr(ID,IPF_RTM_TYPE_BO_ID,PROPERTY_NAME,FIELD_TEXT) VALUES(#{id},#{ipfRtmTypeBoId},#{propertyName},#{fieldText})")
    void createIpfRtmTypeBoAttr(IpfRtmTypeBoAttr ipfRtmTypeBoAttr);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rtm_type_bo_attr WHERE ID = #{id}")
    void deleteIpfRtmTypeBoAttr(String id);

    @Update("update cartan_common.t_ipf_rtm_type_bo_attr set IPF_RTM_TYPE_BO_ID=#{ipfRtmTypeBoId},PROPERTY_NAME=#{propertyName},FIELD_TEXT=#{fieldText} where ID = #{id}")
    void updateIpfRtmTypeBoAttr(IpfRtmTypeBoAttr ipfRtmTypeBoAttr);

    @Select("select count(*) c from cartan_common.t_ipf_rtm_type_bo_attr")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rtm_type_bo_attr order by ID asc")
    ArrayList<IpfRtmTypeBoAttr> selectAll();
    
    @SelectProvider(type = IpfRtmTypeBoAttrSqlProvider.class, method = "getSql")
    ArrayList<IpfRtmTypeBoAttr> selectWithCondition(@Param("ipfRtmTypeBoAttr") IpfRtmTypeBoAttr ipfRtmTypeBoAttr,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRtmTypeBoAttr> selectBySql(@Param("SqlStr") String SqlStr);
}


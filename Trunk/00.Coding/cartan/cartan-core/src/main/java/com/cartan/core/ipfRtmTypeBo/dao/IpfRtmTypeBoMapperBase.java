package com.cartan.core.ipfRtmTypeBo.dao;

import com.cartan.core.ipfRtmTypeBo.domain.IpfRtmTypeBo;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRtmTypeBoMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rtm_type_bo s WHERE s.ID = #{id}")
	IpfRtmTypeBo getIpfRtmTypeBo(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rtm_type_bo(ID,IPF_RTM_TYPE_ID,IPF_CCM_BO_ID,BO_NAME,BO_DESC,PROPERTY_NAME,PROPERTY_UTILITY,EXTERNAL_BO_NAME,EXTERNAL_MATCH_PROPERTY,EXTERNAL_RESULT_PROPERTY,EXTERNAL_BO_ID,TRIGGER_PROPERTY_NAME) VALUES(#{id},#{ipfRtmTypeId},#{ipfCcmBoId},#{boName},#{boDesc},#{propertyName},#{propertyUtility},#{externalBoName},#{externalMatchProperty},#{externalResultProperty},#{externalBoId},#{triggerPropertyName})")
    void createIpfRtmTypeBo(IpfRtmTypeBo ipfRtmTypeBo);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rtm_type_bo WHERE ID = #{id}")
    void deleteIpfRtmTypeBo(String id);

    @Update("update cartan_common.t_ipf_rtm_type_bo set IPF_RTM_TYPE_ID=#{ipfRtmTypeId},IPF_CCM_BO_ID=#{ipfCcmBoId},BO_NAME=#{boName},BO_DESC=#{boDesc},PROPERTY_NAME=#{propertyName},PROPERTY_UTILITY=#{propertyUtility},EXTERNAL_BO_NAME=#{externalBoName},EXTERNAL_MATCH_PROPERTY=#{externalMatchProperty},EXTERNAL_RESULT_PROPERTY=#{externalResultProperty},EXTERNAL_BO_ID=#{externalBoId},TRIGGER_PROPERTY_NAME=#{triggerPropertyName} where ID = #{id}")
    void updateIpfRtmTypeBo(IpfRtmTypeBo ipfRtmTypeBo);

    @Select("select count(*) c from cartan_common.t_ipf_rtm_type_bo")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rtm_type_bo order by ID asc")
    ArrayList<IpfRtmTypeBo> selectAll();
    
    @SelectProvider(type = IpfRtmTypeBoSqlProvider.class, method = "getSql")
    ArrayList<IpfRtmTypeBo> selectWithCondition(@Param("ipfRtmTypeBo") IpfRtmTypeBo ipfRtmTypeBo,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRtmTypeBo> selectBySql(@Param("SqlStr") String SqlStr);
}


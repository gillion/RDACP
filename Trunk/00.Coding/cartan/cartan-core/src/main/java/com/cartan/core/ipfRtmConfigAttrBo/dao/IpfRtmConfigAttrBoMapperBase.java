package com.cartan.core.ipfRtmConfigAttrBo.dao;

import com.cartan.core.ipfRtmConfigAttrBo.domain.IpfRtmConfigAttrBo;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRtmConfigAttrBoMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rtm_config_attr_bo s WHERE s.ID = #{id}")
	IpfRtmConfigAttrBo getIpfRtmConfigAttrBo(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rtm_config_attr_bo(ID,IPF_RTM_CONFIG_ATTR_ID,IPF_RTM_CONFIG_ID,IPF_CCM_BO_ID,BO_NAME,BO_DESC,BO_ATTRIBUTE_NAME,IS_VISIBLE,IS_REQUIRED,DEFAULT_VALUE,SHLP_VALUE_FILED) VALUES(#{id},#{ipfRtmConfigAttrId},#{ipfRtmConfigId},#{ipfCcmBoId},#{boName},#{boDesc},#{boAttributeName},#{isVisible},#{isRequired},#{defaultValue},#{shlpValueFiled})")
    void createIpfRtmConfigAttrBo(IpfRtmConfigAttrBo ipfRtmConfigAttrBo);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rtm_config_attr_bo WHERE ID = #{id}")
    void deleteIpfRtmConfigAttrBo(String id);

    @Update("update cartan_common.t_ipf_rtm_config_attr_bo set IPF_RTM_CONFIG_ATTR_ID=#{ipfRtmConfigAttrId},IPF_RTM_CONFIG_ID=#{ipfRtmConfigId},IPF_CCM_BO_ID=#{ipfCcmBoId},BO_NAME=#{boName},BO_DESC=#{boDesc},BO_ATTRIBUTE_NAME=#{boAttributeName},IS_VISIBLE=#{isVisible},IS_REQUIRED=#{isRequired},DEFAULT_VALUE=#{defaultValue},SHLP_VALUE_FILED=#{shlpValueFiled} where ID = #{id}")
    void updateIpfRtmConfigAttrBo(IpfRtmConfigAttrBo ipfRtmConfigAttrBo);

    @Select("select count(*) c from cartan_common.t_ipf_rtm_config_attr_bo")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rtm_config_attr_bo order by ID asc")
    ArrayList<IpfRtmConfigAttrBo> selectAll();
    
    @SelectProvider(type = IpfRtmConfigAttrBoSqlProvider.class, method = "getSql")
    ArrayList<IpfRtmConfigAttrBo> selectWithCondition(@Param("ipfRtmConfigAttrBo") IpfRtmConfigAttrBo ipfRtmConfigAttrBo,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRtmConfigAttrBo> selectBySql(@Param("SqlStr") String SqlStr);
}


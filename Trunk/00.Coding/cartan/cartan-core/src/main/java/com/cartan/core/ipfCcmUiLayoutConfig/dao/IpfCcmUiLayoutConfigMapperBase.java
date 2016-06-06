package com.cartan.core.ipfCcmUiLayoutConfig.dao;

import com.cartan.core.ipfCcmUiLayoutConfig.domain.IpfCcmUiLayoutConfig;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmUiLayoutConfigMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_ui_layout_config s WHERE s.ID = #{id}")
	IpfCcmUiLayoutConfig getIpfCcmUiLayoutConfig(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_ui_layout_config(ID,IPF_CCM_BO_ID,BO_ID,PAGE_NAME,LAYOUT_ELEMENT_NAME,LAYOUT_ELEMENT_DESCRIPTION,BO_NAME,BO_ELEMENT_NAME) VALUES(#{id},#{ipfCcmBoId},#{boId},#{pageName},#{layoutElementName},#{layoutElementDescription},#{boName},#{boElementName})")
    void createIpfCcmUiLayoutConfig(IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_ui_layout_config WHERE ID = #{id}")
    void deleteIpfCcmUiLayoutConfig(String id);

    @Update("update cartan_common.t_ipf_ccm_ui_layout_config set IPF_CCM_BO_ID=#{ipfCcmBoId},BO_ID=#{boId},PAGE_NAME=#{pageName},LAYOUT_ELEMENT_NAME=#{layoutElementName},LAYOUT_ELEMENT_DESCRIPTION=#{layoutElementDescription},BO_NAME=#{boName},BO_ELEMENT_NAME=#{boElementName} where ID = #{id}")
    void updateIpfCcmUiLayoutConfig(IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_ui_layout_config")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_ui_layout_config order by ID asc")
    ArrayList<IpfCcmUiLayoutConfig> selectAll();
    
    @SelectProvider(type = IpfCcmUiLayoutConfigSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmUiLayoutConfig> selectWithCondition(@Param("ipfCcmUiLayoutConfig") IpfCcmUiLayoutConfig ipfCcmUiLayoutConfig,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmUiLayoutConfig> selectBySql(@Param("SqlStr") String SqlStr);
}


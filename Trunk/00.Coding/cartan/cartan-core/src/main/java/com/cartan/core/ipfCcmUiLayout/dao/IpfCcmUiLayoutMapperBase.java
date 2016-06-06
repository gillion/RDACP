package com.cartan.core.ipfCcmUiLayout.dao;

import com.cartan.core.ipfCcmUiLayout.domain.IpfCcmUiLayout;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmUiLayoutMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_ui_layout s WHERE s.ID = #{id}")
	IpfCcmUiLayout getIpfCcmUiLayout(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_ui_layout(ID,UI_LAYOUT_NAME,DESCRIPTION) VALUES(#{id},#{uiLayoutName},#{description})")
    void createIpfCcmUiLayout(IpfCcmUiLayout ipfCcmUiLayout);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_ui_layout WHERE ID = #{id}")
    void deleteIpfCcmUiLayout(String id);

    @Update("update cartan_common.t_ipf_ccm_ui_layout set UI_LAYOUT_NAME=#{uiLayoutName},DESCRIPTION=#{description} where ID = #{id}")
    void updateIpfCcmUiLayout(IpfCcmUiLayout ipfCcmUiLayout);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_ui_layout")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_ui_layout order by ID asc")
    ArrayList<IpfCcmUiLayout> selectAll();
    
    @SelectProvider(type = IpfCcmUiLayoutSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmUiLayout> selectWithCondition(@Param("ipfCcmUiLayout") IpfCcmUiLayout ipfCcmUiLayout,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmUiLayout> selectBySql(@Param("SqlStr") String SqlStr);
}


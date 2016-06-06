package com.cartan.core.ipfCcmUiLayoutDetail.dao;

import com.cartan.core.ipfCcmUiLayoutDetail.domain.IpfCcmUiLayoutDetail;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmUiLayoutDetailMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_ui_layout_detail s WHERE s.ID = #{id}")
	IpfCcmUiLayoutDetail getIpfCcmUiLayoutDetail(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_ui_layout_detail(ID,IPF_CCM_UI_LAYOUT_ID,IPF_CCM_UI_LAYOUT_LIST_ID,LAYOUT_ELEMENT_NAME,DESCRIPTION) VALUES(#{id},#{ipfCcmUiLayoutId},#{ipfCcmUiLayoutListId},#{layoutElementName},#{description})")
    void createIpfCcmUiLayoutDetail(IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_ui_layout_detail WHERE ID = #{id}")
    void deleteIpfCcmUiLayoutDetail(String id);

    @Update("update cartan_common.t_ipf_ccm_ui_layout_detail set IPF_CCM_UI_LAYOUT_ID=#{ipfCcmUiLayoutId},IPF_CCM_UI_LAYOUT_LIST_ID=#{ipfCcmUiLayoutListId},LAYOUT_ELEMENT_NAME=#{layoutElementName},DESCRIPTION=#{description} where ID = #{id}")
    void updateIpfCcmUiLayoutDetail(IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_ui_layout_detail")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_ui_layout_detail order by ID asc")
    ArrayList<IpfCcmUiLayoutDetail> selectAll();
    
    @SelectProvider(type = IpfCcmUiLayoutDetailSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmUiLayoutDetail> selectWithCondition(@Param("ipfCcmUiLayoutDetail") IpfCcmUiLayoutDetail ipfCcmUiLayoutDetail,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmUiLayoutDetail> selectBySql(@Param("SqlStr") String SqlStr);
}


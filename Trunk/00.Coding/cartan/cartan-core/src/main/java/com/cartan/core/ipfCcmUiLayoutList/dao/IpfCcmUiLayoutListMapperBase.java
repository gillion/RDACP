package com.cartan.core.ipfCcmUiLayoutList.dao;

import com.cartan.core.ipfCcmUiLayoutList.domain.IpfCcmUiLayoutList;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmUiLayoutListMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_ui_layout_list s WHERE s.ID = #{id}")
	IpfCcmUiLayoutList getIpfCcmUiLayoutList(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_ui_layout_list(ID,IPF_CCM_UI_LAYOUT_ID,PAGE_NAME,DESCRIPTION,IMAGE_PATH) VALUES(#{id},#{ipfCcmUiLayoutId},#{pageName},#{description},#{imagePath})")
    void createIpfCcmUiLayoutList(IpfCcmUiLayoutList ipfCcmUiLayoutList);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_ui_layout_list WHERE ID = #{id}")
    void deleteIpfCcmUiLayoutList(String id);

    @Update("update cartan_common.t_ipf_ccm_ui_layout_list set IPF_CCM_UI_LAYOUT_ID=#{ipfCcmUiLayoutId},PAGE_NAME=#{pageName},DESCRIPTION=#{description},IMAGE_PATH=#{imagePath} where ID = #{id}")
    void updateIpfCcmUiLayoutList(IpfCcmUiLayoutList ipfCcmUiLayoutList);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_ui_layout_list")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_ui_layout_list order by ID asc")
    ArrayList<IpfCcmUiLayoutList> selectAll();
    
    @SelectProvider(type = IpfCcmUiLayoutListSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmUiLayoutList> selectWithCondition(@Param("ipfCcmUiLayoutList") IpfCcmUiLayoutList ipfCcmUiLayoutList,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmUiLayoutList> selectBySql(@Param("SqlStr") String SqlStr);
}


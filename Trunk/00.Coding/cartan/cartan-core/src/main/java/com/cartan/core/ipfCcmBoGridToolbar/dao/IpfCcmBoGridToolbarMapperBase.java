package com.cartan.core.ipfCcmBoGridToolbar.dao;

import com.cartan.core.ipfCcmBoGridToolbar.domain.IpfCcmBoGridToolbar;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoGridToolbarMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_grid_toolbar s WHERE s.ID = #{id}")
	IpfCcmBoGridToolbar getIpfCcmBoGridToolbar(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_grid_toolbar(ID,IPF_CCB_BO_ID,METHOD_NAME,METHOD_DESC,SEQ_NO,METHOD_ID,BUTTON_STYLE,DISABLED_EXPREE,IS_REFRESH_PARENT_BO,HOTKEY_TYPE,HOTKEY_VALUE,IS_HIDE) VALUES(#{id},#{ipfCcbBoId},#{methodName},#{methodDesc},#{seqNo},#{methodId},#{buttonStyle},#{disabledExpree},#{isRefreshParentBo},#{hotkeyType},#{hotkeyValue},#{isHide})")
    void createIpfCcmBoGridToolbar(IpfCcmBoGridToolbar ipfCcmBoGridToolbar);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_grid_toolbar WHERE ID = #{id}")
    void deleteIpfCcmBoGridToolbar(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_grid_toolbar set IPF_CCB_BO_ID=#{ipfCcbBoId},METHOD_NAME=#{methodName},METHOD_DESC=#{methodDesc},SEQ_NO=#{seqNo},METHOD_ID=#{methodId},BUTTON_STYLE=#{buttonStyle},DISABLED_EXPREE=#{disabledExpree},IS_REFRESH_PARENT_BO=#{isRefreshParentBo},HOTKEY_TYPE=#{hotkeyType},HOTKEY_VALUE=#{hotkeyValue},IS_HIDE=#{isHide} where ID = #{id}")
    void updateIpfCcmBoGridToolbar(IpfCcmBoGridToolbar ipfCcmBoGridToolbar);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_grid_toolbar")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_grid_toolbar order by ID asc")
    ArrayList<IpfCcmBoGridToolbar> selectAll();
    
    @SelectProvider(type = IpfCcmBoGridToolbarSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoGridToolbar> selectWithCondition(@Param("ipfCcmBoGridToolbar") IpfCcmBoGridToolbar ipfCcmBoGridToolbar,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoGridToolbar> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.ipfCcmBoFormToolbar.dao;

import com.cartan.core.ipfCcmBoFormToolbar.domain.IpfCcmBoFormToolbar;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoFormToolbarMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_form_toolbar s WHERE s.ID = #{id}")
	IpfCcmBoFormToolbar getIpfCcmBoFormToolbar(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_form_toolbar(ID,IPF_CCB_BO_ID,METHOD_NAME,METHOD_DESC,SEQ_NO,METHOD_ID,BUTTON_STYLE,DISABLED_EXPREE,IS_REFRESH_PARENT_BO,HOTKEY_TYPE,HOTKEY_VALUE,IS_HIDE) VALUES(#{id},#{ipfCcbBoId},#{methodName},#{methodDesc},#{seqNo},#{methodId},#{buttonStyle},#{disabledExpree},#{isRefreshParentBo},#{hotkeyType},#{hotkeyValue},#{isHide})")
    void createIpfCcmBoFormToolbar(IpfCcmBoFormToolbar ipfCcmBoFormToolbar);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_form_toolbar WHERE ID = #{id}")
    void deleteIpfCcmBoFormToolbar(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_form_toolbar set IPF_CCB_BO_ID=#{ipfCcbBoId},METHOD_NAME=#{methodName},METHOD_DESC=#{methodDesc},SEQ_NO=#{seqNo},METHOD_ID=#{methodId},BUTTON_STYLE=#{buttonStyle},DISABLED_EXPREE=#{disabledExpree},IS_REFRESH_PARENT_BO=#{isRefreshParentBo},HOTKEY_TYPE=#{hotkeyType},HOTKEY_VALUE=#{hotkeyValue},IS_HIDE=#{isHide} where ID = #{id}")
    void updateIpfCcmBoFormToolbar(IpfCcmBoFormToolbar ipfCcmBoFormToolbar);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_form_toolbar")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_form_toolbar order by ID asc")
    ArrayList<IpfCcmBoFormToolbar> selectAll();
    
    @SelectProvider(type = IpfCcmBoFormToolbarSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoFormToolbar> selectWithCondition(@Param("ipfCcmBoFormToolbar") IpfCcmBoFormToolbar ipfCcmBoFormToolbar,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoFormToolbar> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.ipfCcmShlpText.dao;

import com.cartan.core.ipfCcmShlpText.domain.IpfCcmShlpText;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmShlpTextMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_shlp_text s WHERE s.ID = #{id}")
	IpfCcmShlpText getIpfCcmShlpText(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_shlp_text(ID,IPF_CCM_SHLP_ID,DD_LANGUAGE,DD_TEXT) VALUES(#{id},#{ipfCcmShlpId},#{ddLanguage},#{ddText})")
    void createIpfCcmShlpText(IpfCcmShlpText ipfCcmShlpText);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_shlp_text WHERE ID = #{id}")
    void deleteIpfCcmShlpText(String id);

    @Update("update cartan_common.t_ipf_ccm_shlp_text set IPF_CCM_SHLP_ID=#{ipfCcmShlpId},DD_LANGUAGE=#{ddLanguage},DD_TEXT=#{ddText} where ID = #{id}")
    void updateIpfCcmShlpText(IpfCcmShlpText ipfCcmShlpText);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_shlp_text")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_shlp_text order by ID asc")
    ArrayList<IpfCcmShlpText> selectAll();
    
    @SelectProvider(type = IpfCcmShlpTextSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmShlpText> selectWithCondition(@Param("ipfCcmShlpText") IpfCcmShlpText ipfCcmShlpText,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmShlpText> selectBySql(@Param("SqlStr") String SqlStr);
}


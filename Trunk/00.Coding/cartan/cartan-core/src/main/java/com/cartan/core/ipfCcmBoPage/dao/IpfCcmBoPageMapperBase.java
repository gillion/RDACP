package com.cartan.core.ipfCcmBoPage.dao;

import com.cartan.core.ipfCcmBoPage.domain.IpfCcmBoPage;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoPageMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_page s WHERE s.ID = #{id}")
	IpfCcmBoPage getIpfCcmBoPage(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_page(ID,IPF_CCM_BO_ID,PAGE_TYPE,DESCRIPTION,PAGE_NAME) VALUES(#{id},#{ipfCcmBoId},#{pageType},#{description},#{pageName})")
    void createIpfCcmBoPage(IpfCcmBoPage ipfCcmBoPage);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_page WHERE ID = #{id}")
    void deleteIpfCcmBoPage(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_page set IPF_CCM_BO_ID=#{ipfCcmBoId},PAGE_TYPE=#{pageType},DESCRIPTION=#{description},PAGE_NAME=#{pageName} where ID = #{id}")
    void updateIpfCcmBoPage(IpfCcmBoPage ipfCcmBoPage);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_page")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_page order by ID asc")
    ArrayList<IpfCcmBoPage> selectAll();
    
    @SelectProvider(type = IpfCcmBoPageSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoPage> selectWithCondition(@Param("ipfCcmBoPage") IpfCcmBoPage ipfCcmBoPage,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoPage> selectBySql(@Param("SqlStr") String SqlStr);
}


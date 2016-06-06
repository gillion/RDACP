package com.cartan.core.ipfCcmBoPropertyCas.dao;

import com.cartan.core.ipfCcmBoPropertyCas.domain.IpfCcmBoPropertyCas;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoPropertyCasMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_property_cas s WHERE s.ID = #{id}")
	IpfCcmBoPropertyCas getIpfCcmBoPropertyCas(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_property_cas(ID,IPF_CCM_BO_PROPERTY_ID,CASCADE_PROPERTY_ID,OPERATION,TARGET_PROPERTY_NAME,TYPE) VALUES(#{id},#{ipfCcmBoPropertyId},#{cascadePropertyId},#{operation},#{targetPropertyName},#{type})")
    void createIpfCcmBoPropertyCas(IpfCcmBoPropertyCas ipfCcmBoPropertyCas);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_property_cas WHERE ID = #{id}")
    void deleteIpfCcmBoPropertyCas(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_property_cas set IPF_CCM_BO_PROPERTY_ID=#{ipfCcmBoPropertyId},CASCADE_PROPERTY_ID=#{cascadePropertyId},OPERATION=#{operation},TARGET_PROPERTY_NAME=#{targetPropertyName},TYPE=#{type} where ID = #{id}")
    void updateIpfCcmBoPropertyCas(IpfCcmBoPropertyCas ipfCcmBoPropertyCas);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_property_cas")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_property_cas order by ID asc")
    ArrayList<IpfCcmBoPropertyCas> selectAll();
    
    @SelectProvider(type = IpfCcmBoPropertyCasSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoPropertyCas> selectWithCondition(@Param("ipfCcmBoPropertyCas") IpfCcmBoPropertyCas ipfCcmBoPropertyCas,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoPropertyCas> selectBySql(@Param("SqlStr") String SqlStr);
}


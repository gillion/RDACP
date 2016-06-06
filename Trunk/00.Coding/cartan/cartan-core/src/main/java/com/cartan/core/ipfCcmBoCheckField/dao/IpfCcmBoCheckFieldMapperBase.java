package com.cartan.core.ipfCcmBoCheckField.dao;

import com.cartan.core.ipfCcmBoCheckField.domain.IpfCcmBoCheckField;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoCheckFieldMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_check_field s WHERE s.ID = #{id}")
	IpfCcmBoCheckField getIpfCcmBoCheckField(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_check_field(ID,IPF_CCM_BO_CHECK_ID,PROPERTY_ID,PROPERTY_NAME,PROPERTY_DESC,BO_NAME,SEQ_NO) VALUES(#{id},#{ipfCcmBoCheckId},#{propertyId},#{propertyName},#{propertyDesc},#{boName},#{seqNo})")
    void createIpfCcmBoCheckField(IpfCcmBoCheckField ipfCcmBoCheckField);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_check_field WHERE ID = #{id}")
    void deleteIpfCcmBoCheckField(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_check_field set IPF_CCM_BO_CHECK_ID=#{ipfCcmBoCheckId},PROPERTY_ID=#{propertyId},PROPERTY_NAME=#{propertyName},PROPERTY_DESC=#{propertyDesc},BO_NAME=#{boName},SEQ_NO=#{seqNo} where ID = #{id}")
    void updateIpfCcmBoCheckField(IpfCcmBoCheckField ipfCcmBoCheckField);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_check_field")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_check_field order by ID asc")
    ArrayList<IpfCcmBoCheckField> selectAll();
    
    @SelectProvider(type = IpfCcmBoCheckFieldSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoCheckField> selectWithCondition(@Param("ipfCcmBoCheckField") IpfCcmBoCheckField ipfCcmBoCheckField,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoCheckField> selectBySql(@Param("SqlStr") String SqlStr);
}


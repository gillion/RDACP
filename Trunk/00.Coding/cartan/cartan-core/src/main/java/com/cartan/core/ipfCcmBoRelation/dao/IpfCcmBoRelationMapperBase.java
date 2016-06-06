package com.cartan.core.ipfCcmBoRelation.dao;

import com.cartan.core.ipfCcmBoRelation.domain.IpfCcmBoRelation;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoRelationMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_relation s WHERE s.ID = #{id}")
	IpfCcmBoRelation getIpfCcmBoRelation(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_relation(ID,IPF_CCM_BO_ID,PROPERTY_NAME,SUB_BO_NAME,SUB_BO_REL_TYPE,OBJECT_TYPE,DESCRIPTION,SUB_BO_ORDER_NO,PERSISTENT_SAVE_TYPE,GRID_EDIT_TYPE,LINK_BO_NAME) VALUES(#{id},#{ipfCcmBoId},#{propertyName},#{subBoName},#{subBoRelType},#{objectType},#{description},#{subBoOrderNo},#{persistentSaveType},#{gridEditType},#{linkBoName})")
    void createIpfCcmBoRelation(IpfCcmBoRelation ipfCcmBoRelation);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_relation WHERE ID = #{id}")
    void deleteIpfCcmBoRelation(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_relation set IPF_CCM_BO_ID=#{ipfCcmBoId},PROPERTY_NAME=#{propertyName},SUB_BO_NAME=#{subBoName},SUB_BO_REL_TYPE=#{subBoRelType},OBJECT_TYPE=#{objectType},DESCRIPTION=#{description},SUB_BO_ORDER_NO=#{subBoOrderNo},PERSISTENT_SAVE_TYPE=#{persistentSaveType},GRID_EDIT_TYPE=#{gridEditType},LINK_BO_NAME=#{linkBoName} where ID = #{id}")
    void updateIpfCcmBoRelation(IpfCcmBoRelation ipfCcmBoRelation);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_relation")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_relation order by ID asc")
    ArrayList<IpfCcmBoRelation> selectAll();
    
    @SelectProvider(type = IpfCcmBoRelationSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoRelation> selectWithCondition(@Param("ipfCcmBoRelation") IpfCcmBoRelation ipfCcmBoRelation,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoRelation> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.ipfCcmBoMethodParam.dao;

import com.cartan.core.ipfCcmBoMethodParam.domain.IpfCcmBoMethodParam;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoMethodParamMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_method_param s WHERE s.ID = #{id}")
	IpfCcmBoMethodParam getIpfCcmBoMethodParam(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_method_param(ID,IPF_CCM_BO_METHOD_ID,CONSTANT_VALUE,IS_CONDITION,METHOD_NAME,PARAM_NAME,PARAM_REF,PARAM_TYPE,BO_NAME_REF) VALUES(#{id},#{ipfCcmBoMethodId},#{constantValue},#{isCondition},#{methodName},#{paramName},#{paramRef},#{paramType},#{boNameRef})")
    void createIpfCcmBoMethodParam(IpfCcmBoMethodParam ipfCcmBoMethodParam);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_method_param WHERE ID = #{id}")
    void deleteIpfCcmBoMethodParam(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_method_param set IPF_CCM_BO_METHOD_ID=#{ipfCcmBoMethodId},CONSTANT_VALUE=#{constantValue},IS_CONDITION=#{isCondition},METHOD_NAME=#{methodName},PARAM_NAME=#{paramName},PARAM_REF=#{paramRef},PARAM_TYPE=#{paramType},BO_NAME_REF=#{boNameRef} where ID = #{id}")
    void updateIpfCcmBoMethodParam(IpfCcmBoMethodParam ipfCcmBoMethodParam);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_method_param")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_method_param order by ID asc")
    ArrayList<IpfCcmBoMethodParam> selectAll();
    
    @SelectProvider(type = IpfCcmBoMethodParamSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoMethodParam> selectWithCondition(@Param("ipfCcmBoMethodParam") IpfCcmBoMethodParam ipfCcmBoMethodParam,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoMethodParam> selectBySql(@Param("SqlStr") String SqlStr);
}


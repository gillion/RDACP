package com.cartan.core.ipfCcmBizruleDtlParam.dao;

import com.cartan.core.ipfCcmBizruleDtlParam.domain.IpfCcmBizruleDtlParam;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBizruleDtlParamMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bizrule_dtl_param s WHERE s.ID = #{id}")
	IpfCcmBizruleDtlParam getIpfCcmBizruleDtlParam(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bizrule_dtl_param(ID,IPF_CCM_BIZRULE_ID,IPF_CCM_STRATEGY_ID,IPF_CCM_STRATEGY_PARAM_ID,PARAM_NAME,PARAM_DES,PARAM_VALUE,PARAM_VALUE_DES) VALUES(#{id},#{ipfCcmBizruleId},#{ipfCcmStrategyId},#{ipfCcmStrategyParamId},#{paramName},#{paramDes},#{paramValue},#{paramValueDes})")
    void createIpfCcmBizruleDtlParam(IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bizrule_dtl_param WHERE ID = #{id}")
    void deleteIpfCcmBizruleDtlParam(String id);

    @Update("update cartan_common.t_ipf_ccm_bizrule_dtl_param set IPF_CCM_BIZRULE_ID=#{ipfCcmBizruleId},IPF_CCM_STRATEGY_ID=#{ipfCcmStrategyId},IPF_CCM_STRATEGY_PARAM_ID=#{ipfCcmStrategyParamId},PARAM_NAME=#{paramName},PARAM_DES=#{paramDes},PARAM_VALUE=#{paramValue},PARAM_VALUE_DES=#{paramValueDes} where ID = #{id}")
    void updateIpfCcmBizruleDtlParam(IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bizrule_dtl_param")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bizrule_dtl_param order by ID asc")
    ArrayList<IpfCcmBizruleDtlParam> selectAll();
    
    @SelectProvider(type = IpfCcmBizruleDtlParamSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBizruleDtlParam> selectWithCondition(@Param("ipfCcmBizruleDtlParam") IpfCcmBizruleDtlParam ipfCcmBizruleDtlParam,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBizruleDtlParam> selectBySql(@Param("SqlStr") String SqlStr);
}


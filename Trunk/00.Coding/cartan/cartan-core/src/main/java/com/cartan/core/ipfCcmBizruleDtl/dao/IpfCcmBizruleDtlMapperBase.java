package com.cartan.core.ipfCcmBizruleDtl.dao;

import com.cartan.core.ipfCcmBizruleDtl.domain.IpfCcmBizruleDtl;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBizruleDtlMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bizrule_dtl s WHERE s.ID = #{id}")
	IpfCcmBizruleDtl getIpfCcmBizruleDtl(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bizrule_dtl(ID,IPF_CCM_BIZRULE_ID,IPF_CCM_STRATEGY_ID,STRATEGY_CODE,STRATEGY_NAME,REMARK,RULE_DETAIL_INDEX) VALUES(#{id},#{ipfCcmBizruleId},#{ipfCcmStrategyId},#{strategyCode},#{strategyName},#{remark},#{ruleDetailIndex})")
    void createIpfCcmBizruleDtl(IpfCcmBizruleDtl ipfCcmBizruleDtl);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bizrule_dtl WHERE ID = #{id}")
    void deleteIpfCcmBizruleDtl(String id);

    @Update("update cartan_common.t_ipf_ccm_bizrule_dtl set IPF_CCM_BIZRULE_ID=#{ipfCcmBizruleId},IPF_CCM_STRATEGY_ID=#{ipfCcmStrategyId},STRATEGY_CODE=#{strategyCode},STRATEGY_NAME=#{strategyName},REMARK=#{remark},RULE_DETAIL_INDEX=#{ruleDetailIndex} where ID = #{id}")
    void updateIpfCcmBizruleDtl(IpfCcmBizruleDtl ipfCcmBizruleDtl);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bizrule_dtl")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bizrule_dtl order by ID asc")
    ArrayList<IpfCcmBizruleDtl> selectAll();
    
    @SelectProvider(type = IpfCcmBizruleDtlSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBizruleDtl> selectWithCondition(@Param("ipfCcmBizruleDtl") IpfCcmBizruleDtl ipfCcmBizruleDtl,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBizruleDtl> selectBySql(@Param("SqlStr") String SqlStr);
}


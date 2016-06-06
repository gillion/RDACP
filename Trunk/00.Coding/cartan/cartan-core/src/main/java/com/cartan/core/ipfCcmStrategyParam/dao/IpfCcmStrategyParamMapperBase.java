package com.cartan.core.ipfCcmStrategyParam.dao;

import com.cartan.core.ipfCcmStrategyParam.domain.IpfCcmStrategyParam;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmStrategyParamMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_strategy_param s WHERE s.ID = #{id}")
	IpfCcmStrategyParam getIpfCcmStrategyParam(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_strategy_param(ID,IPF_CCM_STRATEGY_ID,PARAM_TYPE,PARAM_NAME,PARAM_DES,RTM_CONFIG_CODE) VALUES(#{id},#{ipfCcmStrategyId},#{paramType},#{paramName},#{paramDes},#{rtmConfigCode})")
    void createIpfCcmStrategyParam(IpfCcmStrategyParam ipfCcmStrategyParam);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_strategy_param WHERE ID = #{id}")
    void deleteIpfCcmStrategyParam(String id);

    @Update("update cartan_common.t_ipf_ccm_strategy_param set IPF_CCM_STRATEGY_ID=#{ipfCcmStrategyId},PARAM_TYPE=#{paramType},PARAM_NAME=#{paramName},PARAM_DES=#{paramDes},RTM_CONFIG_CODE=#{rtmConfigCode} where ID = #{id}")
    void updateIpfCcmStrategyParam(IpfCcmStrategyParam ipfCcmStrategyParam);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_strategy_param")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_strategy_param order by ID asc")
    ArrayList<IpfCcmStrategyParam> selectAll();
    
    @SelectProvider(type = IpfCcmStrategyParamSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmStrategyParam> selectWithCondition(@Param("ipfCcmStrategyParam") IpfCcmStrategyParam ipfCcmStrategyParam,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmStrategyParam> selectBySql(@Param("SqlStr") String SqlStr);
}


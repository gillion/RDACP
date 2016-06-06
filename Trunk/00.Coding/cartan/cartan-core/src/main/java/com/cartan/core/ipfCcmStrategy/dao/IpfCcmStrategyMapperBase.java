package com.cartan.core.ipfCcmStrategy.dao;

import com.cartan.core.ipfCcmStrategy.domain.IpfCcmStrategy;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmStrategyMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_strategy s WHERE s.ID = #{id}")
	IpfCcmStrategy getIpfCcmStrategy(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_strategy(ID,STRATEGY_TYPE,STRATEGY_CODE,STRATEGY_NAME,STRATEGY_DES,DRL_FILE,DRL_ROUTE,PACKAGE_NAME,RULE_NO,RULE_TYPE,SOURCE_CODE,SVN_REVISION) VALUES(#{id},#{strategyType},#{strategyCode},#{strategyName},#{strategyDes},#{drlFile},#{drlRoute},#{packageName},#{ruleNo},#{ruleType},#{sourceCode},#{svnRevision})")
    void createIpfCcmStrategy(IpfCcmStrategy ipfCcmStrategy);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_strategy WHERE ID = #{id}")
    void deleteIpfCcmStrategy(String id);

    @Update("update cartan_common.t_ipf_ccm_strategy set STRATEGY_TYPE=#{strategyType},STRATEGY_CODE=#{strategyCode},STRATEGY_NAME=#{strategyName},STRATEGY_DES=#{strategyDes},DRL_FILE=#{drlFile},DRL_ROUTE=#{drlRoute},PACKAGE_NAME=#{packageName},RULE_NO=#{ruleNo},RULE_TYPE=#{ruleType},SOURCE_CODE=#{sourceCode},SVN_REVISION=#{svnRevision} where ID = #{id}")
    void updateIpfCcmStrategy(IpfCcmStrategy ipfCcmStrategy);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_strategy")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_strategy order by ID asc")
    ArrayList<IpfCcmStrategy> selectAll();
    
    @SelectProvider(type = IpfCcmStrategySqlProvider.class, method = "getSql")
    ArrayList<IpfCcmStrategy> selectWithCondition(@Param("ipfCcmStrategy") IpfCcmStrategy ipfCcmStrategy,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmStrategy> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.ipfRuleFilter.dao;

import com.cartan.core.ipfRuleFilter.domain.IpfRuleFilter;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRuleFilterMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rule_filter s WHERE s.ID = #{id}")
	IpfRuleFilter getIpfRuleFilter(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rule_filter(ID,FILTER_CODE,FILTER_NAME,FILTER_DESC,FILTER_EXPRESS,IS_ACTIVE,IS_SYSTEM_CREATE,IPF_CCM_BO_ID,BO_NAME) VALUES(#{id},#{filterCode},#{filterName},#{filterDesc},#{filterExpress},#{isActive},#{isSystemCreate},#{ipfCcmBoId},#{boName})")
    void createIpfRuleFilter(IpfRuleFilter ipfRuleFilter);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rule_filter WHERE ID = #{id}")
    void deleteIpfRuleFilter(String id);

    @Update("update cartan_common.t_ipf_rule_filter set FILTER_CODE=#{filterCode},FILTER_NAME=#{filterName},FILTER_DESC=#{filterDesc},FILTER_EXPRESS=#{filterExpress},IS_ACTIVE=#{isActive},IS_SYSTEM_CREATE=#{isSystemCreate},IPF_CCM_BO_ID=#{ipfCcmBoId},BO_NAME=#{boName} where ID = #{id}")
    void updateIpfRuleFilter(IpfRuleFilter ipfRuleFilter);

    @Select("select count(*) c from cartan_common.t_ipf_rule_filter")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rule_filter order by ID asc")
    ArrayList<IpfRuleFilter> selectAll();
    
    @SelectProvider(type = IpfRuleFilterSqlProvider.class, method = "getSql")
    ArrayList<IpfRuleFilter> selectWithCondition(@Param("ipfRuleFilter") IpfRuleFilter ipfRuleFilter,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRuleFilter> selectBySql(@Param("SqlStr") String SqlStr);
}


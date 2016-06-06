package com.cartan.core.ipfCcmBoMethodRule.dao;

import com.cartan.core.ipfCcmBoMethodRule.domain.IpfCcmBoMethodRule;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoMethodRuleMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_method_rule s WHERE s.ID = #{id}")
	IpfCcmBoMethodRule getIpfCcmBoMethodRule(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_method_rule(ID,IPF_CCB_BO_METHOD_ID,RULE_NO,RULE_NAME,INVOKE_POINT,INVOKE_ORDER,RULE_ID) VALUES(#{id},#{ipfCcbBoMethodId},#{ruleNo},#{ruleName},#{invokePoint},#{invokeOrder},#{ruleId})")
    void createIpfCcmBoMethodRule(IpfCcmBoMethodRule ipfCcmBoMethodRule);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_method_rule WHERE ID = #{id}")
    void deleteIpfCcmBoMethodRule(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_method_rule set IPF_CCB_BO_METHOD_ID=#{ipfCcbBoMethodId},RULE_NO=#{ruleNo},RULE_NAME=#{ruleName},INVOKE_POINT=#{invokePoint},INVOKE_ORDER=#{invokeOrder},RULE_ID=#{ruleId} where ID = #{id}")
    void updateIpfCcmBoMethodRule(IpfCcmBoMethodRule ipfCcmBoMethodRule);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_method_rule")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_method_rule order by ID asc")
    ArrayList<IpfCcmBoMethodRule> selectAll();
    
    @SelectProvider(type = IpfCcmBoMethodRuleSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoMethodRule> selectWithCondition(@Param("ipfCcmBoMethodRule") IpfCcmBoMethodRule ipfCcmBoMethodRule,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoMethodRule> selectBySql(@Param("SqlStr") String SqlStr);
}


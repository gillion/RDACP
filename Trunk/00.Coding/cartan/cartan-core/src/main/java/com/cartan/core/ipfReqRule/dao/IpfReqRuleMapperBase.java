package com.cartan.core.ipfReqRule.dao;

import com.cartan.core.ipfReqRule.domain.IpfReqRule;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfReqRuleMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_req_rule s WHERE s.ID = #{id}")
	IpfReqRule getIpfReqRule(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_req_rule(ID,RULE_NAME,RULE_NO,RULE_TYPE,RULE_STATUS,TRIGGER_TYPE,PHYSICAL_LOCATION,ACTION_TYPE,BUSINESS_LOCATION,BUSINESS_MODULE,DROOLS_ATTRIBUTE,RULE_DESC,IS_DECISION_TABLE,PUBLIC_TYPE,IPF_CCM_BO_ID,IMPORT_DESC,DROOLS_WHEN,DROOLS_THEN,REMARK) VALUES(#{id},#{ruleName},#{ruleNo},#{ruleType},#{ruleStatus},#{triggerType},#{physicalLocation},#{actionType},#{businessLocation},#{businessModule},#{droolsAttribute},#{ruleDesc},#{isDecisionTable},#{publicType},#{ipfCcmBoId},#{importDesc},#{droolsWhen},#{droolsThen},#{remark})")
    void createIpfReqRule(IpfReqRule ipfReqRule);
    
    @Delete("DELETE FROM cartan_common.t_ipf_req_rule WHERE ID = #{id}")
    void deleteIpfReqRule(String id);

    @Update("update cartan_common.t_ipf_req_rule set RULE_NAME=#{ruleName},RULE_NO=#{ruleNo},RULE_TYPE=#{ruleType},RULE_STATUS=#{ruleStatus},TRIGGER_TYPE=#{triggerType},PHYSICAL_LOCATION=#{physicalLocation},ACTION_TYPE=#{actionType},BUSINESS_LOCATION=#{businessLocation},BUSINESS_MODULE=#{businessModule},DROOLS_ATTRIBUTE=#{droolsAttribute},RULE_DESC=#{ruleDesc},IS_DECISION_TABLE=#{isDecisionTable},PUBLIC_TYPE=#{publicType},IPF_CCM_BO_ID=#{ipfCcmBoId},IMPORT_DESC=#{importDesc},DROOLS_WHEN=#{droolsWhen},DROOLS_THEN=#{droolsThen},REMARK=#{remark} where ID = #{id}")
    void updateIpfReqRule(IpfReqRule ipfReqRule);

    @Select("select count(*) c from cartan_common.t_ipf_req_rule")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_req_rule order by ID asc")
    ArrayList<IpfReqRule> selectAll();
    
    @SelectProvider(type = IpfReqRuleSqlProvider.class, method = "getSql")
    ArrayList<IpfReqRule> selectWithCondition(@Param("ipfReqRule") IpfReqRule ipfReqRule,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfReqRule> selectBySql(@Param("SqlStr") String SqlStr);
}


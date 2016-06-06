package com.cartan.core.ipfCcmNumrule.dao;

import com.cartan.core.ipfCcmNumrule.domain.IpfCcmNumrule;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmNumruleMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_numrule s WHERE s.ID = #{id}")
	IpfCcmNumrule getIpfCcmNumrule(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_numrule(ID,RULE_CODE,RULE_NAME,RULE_EXPRESSION,RULE_STATUS,INITIAL_VALUE,MAX_VALUE,GROWTH,REMARK,IS_ACTIVE,IPF_CCM_BO_ID,BO_NAME,IPF_CCM_BO_PROPERTY_ID,PROPERTY_NAME) VALUES(#{id},#{ruleCode},#{ruleName},#{ruleExpression},#{ruleStatus},#{initialValue},#{maxValue},#{growth},#{remark},#{isActive},#{ipfCcmBoId},#{boName},#{ipfCcmBoPropertyId},#{propertyName})")
    void createIpfCcmNumrule(IpfCcmNumrule ipfCcmNumrule);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_numrule WHERE ID = #{id}")
    void deleteIpfCcmNumrule(String id);

    @Update("update cartan_common.t_ipf_ccm_numrule set RULE_CODE=#{ruleCode},RULE_NAME=#{ruleName},RULE_EXPRESSION=#{ruleExpression},RULE_STATUS=#{ruleStatus},INITIAL_VALUE=#{initialValue},MAX_VALUE=#{maxValue},GROWTH=#{growth},REMARK=#{remark},IS_ACTIVE=#{isActive},IPF_CCM_BO_ID=#{ipfCcmBoId},BO_NAME=#{boName},IPF_CCM_BO_PROPERTY_ID=#{ipfCcmBoPropertyId},PROPERTY_NAME=#{propertyName} where ID = #{id}")
    void updateIpfCcmNumrule(IpfCcmNumrule ipfCcmNumrule);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_numrule")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_numrule order by ID asc")
    ArrayList<IpfCcmNumrule> selectAll();
    
    @SelectProvider(type = IpfCcmNumruleSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmNumrule> selectWithCondition(@Param("ipfCcmNumrule") IpfCcmNumrule ipfCcmNumrule,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmNumrule> selectBySql(@Param("SqlStr") String SqlStr);
}


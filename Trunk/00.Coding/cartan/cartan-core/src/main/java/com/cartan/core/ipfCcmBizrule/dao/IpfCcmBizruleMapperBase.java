package com.cartan.core.ipfCcmBizrule.dao;

import com.cartan.core.ipfCcmBizrule.domain.IpfCcmBizrule;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBizruleMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bizrule s WHERE s.ID = #{id}")
	IpfCcmBizrule getIpfCcmBizrule(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bizrule(ID,RULE_TYPE,RULE_CLASS,RULE_CODE,RULE_NAME,RULE_DES,IS_SYSTEM_CREATE) VALUES(#{id},#{ruleType},#{ruleClass},#{ruleCode},#{ruleName},#{ruleDes},#{isSystemCreate})")
    void createIpfCcmBizrule(IpfCcmBizrule ipfCcmBizrule);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bizrule WHERE ID = #{id}")
    void deleteIpfCcmBizrule(String id);

    @Update("update cartan_common.t_ipf_ccm_bizrule set RULE_TYPE=#{ruleType},RULE_CLASS=#{ruleClass},RULE_CODE=#{ruleCode},RULE_NAME=#{ruleName},RULE_DES=#{ruleDes},IS_SYSTEM_CREATE=#{isSystemCreate} where ID = #{id}")
    void updateIpfCcmBizrule(IpfCcmBizrule ipfCcmBizrule);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bizrule")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bizrule order by ID asc")
    ArrayList<IpfCcmBizrule> selectAll();
    
    @SelectProvider(type = IpfCcmBizruleSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBizrule> selectWithCondition(@Param("ipfCcmBizrule") IpfCcmBizrule ipfCcmBizrule,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBizrule> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.ipfRuleFilterDetail.dao;

import com.cartan.core.ipfRuleFilterDetail.domain.IpfRuleFilterDetail;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRuleFilterDetailMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rule_filter_detail s WHERE s.ID = #{id}")
	IpfRuleFilterDetail getIpfRuleFilterDetail(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rule_filter_detail(ID,IPF_RULE_FILTER_ID,LINE_ID,ATTRIBUTE,OPERAND,LITERAL_VALUE,AND_OR,LEFT_PAREN,RIGHT_PAREN) VALUES(#{id},#{ipfRuleFilterId},#{lineId},#{attribute},#{operand},#{literalValue},#{andOr},#{leftParen},#{rightParen})")
    void createIpfRuleFilterDetail(IpfRuleFilterDetail ipfRuleFilterDetail);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rule_filter_detail WHERE ID = #{id}")
    void deleteIpfRuleFilterDetail(String id);

    @Update("update cartan_common.t_ipf_rule_filter_detail set IPF_RULE_FILTER_ID=#{ipfRuleFilterId},LINE_ID=#{lineId},ATTRIBUTE=#{attribute},OPERAND=#{operand},LITERAL_VALUE=#{literalValue},AND_OR=#{andOr},LEFT_PAREN=#{leftParen},RIGHT_PAREN=#{rightParen} where ID = #{id}")
    void updateIpfRuleFilterDetail(IpfRuleFilterDetail ipfRuleFilterDetail);

    @Select("select count(*) c from cartan_common.t_ipf_rule_filter_detail")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rule_filter_detail order by ID asc")
    ArrayList<IpfRuleFilterDetail> selectAll();
    
    @SelectProvider(type = IpfRuleFilterDetailSqlProvider.class, method = "getSql")
    ArrayList<IpfRuleFilterDetail> selectWithCondition(@Param("ipfRuleFilterDetail") IpfRuleFilterDetail ipfRuleFilterDetail,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRuleFilterDetail> selectBySql(@Param("SqlStr") String SqlStr);
}


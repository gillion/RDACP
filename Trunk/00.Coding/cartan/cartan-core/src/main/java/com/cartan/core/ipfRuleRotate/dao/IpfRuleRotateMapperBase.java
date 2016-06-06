package com.cartan.core.ipfRuleRotate.dao;

import com.cartan.core.ipfRuleRotate.domain.IpfRuleRotate;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRuleRotateMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rule_rotate s WHERE s.ID = #{id}")
	IpfRuleRotate getIpfRuleRotate(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rule_rotate(ID,WAREHOUSE_OFFICE_ID,RULE_CODE,RULE_DESC,IS_ACTIVE,IS_SYSTEM_CREATE,ROTATE_EXPRESS) VALUES(#{id},#{warehouseOfficeId},#{ruleCode},#{ruleDesc},#{isActive},#{isSystemCreate},#{rotateExpress})")
    void createIpfRuleRotate(IpfRuleRotate ipfRuleRotate);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rule_rotate WHERE ID = #{id}")
    void deleteIpfRuleRotate(String id);

    @Update("update cartan_common.t_ipf_rule_rotate set WAREHOUSE_OFFICE_ID=#{warehouseOfficeId},RULE_CODE=#{ruleCode},RULE_DESC=#{ruleDesc},IS_ACTIVE=#{isActive},IS_SYSTEM_CREATE=#{isSystemCreate},ROTATE_EXPRESS=#{rotateExpress} where ID = #{id}")
    void updateIpfRuleRotate(IpfRuleRotate ipfRuleRotate);

    @Select("select count(*) c from cartan_common.t_ipf_rule_rotate")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rule_rotate order by ID asc")
    ArrayList<IpfRuleRotate> selectAll();
    
    @SelectProvider(type = IpfRuleRotateSqlProvider.class, method = "getSql")
    ArrayList<IpfRuleRotate> selectWithCondition(@Param("ipfRuleRotate") IpfRuleRotate ipfRuleRotate,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRuleRotate> selectBySql(@Param("SqlStr") String SqlStr);
}


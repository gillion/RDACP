package com.cartan.core.ipfCcmNumruleList.dao;

import com.cartan.core.ipfCcmNumruleList.domain.IpfCcmNumruleList;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmNumruleListMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_numrule_list s WHERE s.ID = #{id}")
	IpfCcmNumruleList getIpfCcmNumruleList(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_numrule_list(ID,IPF_CCM_NUMRULE_ID,CONST_EXPRESSION,CURRENT_VALUE,INITIAL_VALUE,MAX_VALUE,GROWTH,REMARK,IS_ACTIVE) VALUES(#{id},#{ipfCcmNumruleId},#{constExpression},#{currentValue},#{initialValue},#{maxValue},#{growth},#{remark},#{isActive})")
    void createIpfCcmNumruleList(IpfCcmNumruleList ipfCcmNumruleList);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_numrule_list WHERE ID = #{id}")
    void deleteIpfCcmNumruleList(String id);

    @Update("update cartan_common.t_ipf_ccm_numrule_list set IPF_CCM_NUMRULE_ID=#{ipfCcmNumruleId},CONST_EXPRESSION=#{constExpression},CURRENT_VALUE=#{currentValue},INITIAL_VALUE=#{initialValue},MAX_VALUE=#{maxValue},GROWTH=#{growth},REMARK=#{remark},IS_ACTIVE=#{isActive} where ID = #{id}")
    void updateIpfCcmNumruleList(IpfCcmNumruleList ipfCcmNumruleList);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_numrule_list")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_numrule_list order by ID asc")
    ArrayList<IpfCcmNumruleList> selectAll();
    
    @SelectProvider(type = IpfCcmNumruleListSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmNumruleList> selectWithCondition(@Param("ipfCcmNumruleList") IpfCcmNumruleList ipfCcmNumruleList,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmNumruleList> selectBySql(@Param("SqlStr") String SqlStr);
}


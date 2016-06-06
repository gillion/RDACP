package com.cartan.core.ipfCcmShlp.dao;

import com.cartan.core.ipfCcmShlp.domain.IpfCcmShlp;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmShlpMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_shlp s WHERE s.ID = #{id}")
	IpfCcmShlp getIpfCcmShlp(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_shlp(ID,SHLP_NAME,SHLP_STATUS,DATA_SOURCE,DATA_SOURCE_TYPE,VALUE_COLUMN,DISPLAY_COLUMN,RULE_NO) VALUES(#{id},#{shlpName},#{shlpStatus},#{dataSource},#{dataSourceType},#{valueColumn},#{displayColumn},#{ruleNo})")
    void createIpfCcmShlp(IpfCcmShlp ipfCcmShlp);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_shlp WHERE ID = #{id}")
    void deleteIpfCcmShlp(String id);

    @Update("update cartan_common.t_ipf_ccm_shlp set SHLP_NAME=#{shlpName},SHLP_STATUS=#{shlpStatus},DATA_SOURCE=#{dataSource},DATA_SOURCE_TYPE=#{dataSourceType},VALUE_COLUMN=#{valueColumn},DISPLAY_COLUMN=#{displayColumn},RULE_NO=#{ruleNo} where ID = #{id}")
    void updateIpfCcmShlp(IpfCcmShlp ipfCcmShlp);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_shlp")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_shlp order by ID asc")
    ArrayList<IpfCcmShlp> selectAll();
    
    @SelectProvider(type = IpfCcmShlpSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmShlp> selectWithCondition(@Param("ipfCcmShlp") IpfCcmShlp ipfCcmShlp,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmShlp> selectBySql(@Param("SqlStr") String SqlStr);
}


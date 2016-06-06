package com.cartan.core.ipfRuleRotateDetail.dao;

import com.cartan.core.ipfRuleRotateDetail.domain.IpfRuleRotateDetail;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRuleRotateDetailMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rule_rotate_detail s WHERE s.ID = #{id}")
	IpfRuleRotateDetail getIpfRuleRotateDetail(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rule_rotate_detail(ID,IPF_RULE_ROTATE_ID,LINE_ID,LOT_ATTRIBUTES,SORT_TYPE,DETAIL_DESC,IS_ACTIVE) VALUES(#{id},#{ipfRuleRotateId},#{lineId},#{lotAttributes},#{sortType},#{detailDesc},#{isActive})")
    void createIpfRuleRotateDetail(IpfRuleRotateDetail ipfRuleRotateDetail);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rule_rotate_detail WHERE ID = #{id}")
    void deleteIpfRuleRotateDetail(String id);

    @Update("update cartan_common.t_ipf_rule_rotate_detail set IPF_RULE_ROTATE_ID=#{ipfRuleRotateId},LINE_ID=#{lineId},LOT_ATTRIBUTES=#{lotAttributes},SORT_TYPE=#{sortType},DETAIL_DESC=#{detailDesc},IS_ACTIVE=#{isActive} where ID = #{id}")
    void updateIpfRuleRotateDetail(IpfRuleRotateDetail ipfRuleRotateDetail);

    @Select("select count(*) c from cartan_common.t_ipf_rule_rotate_detail")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rule_rotate_detail order by ID asc")
    ArrayList<IpfRuleRotateDetail> selectAll();
    
    @SelectProvider(type = IpfRuleRotateDetailSqlProvider.class, method = "getSql")
    ArrayList<IpfRuleRotateDetail> selectWithCondition(@Param("ipfRuleRotateDetail") IpfRuleRotateDetail ipfRuleRotateDetail,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRuleRotateDetail> selectBySql(@Param("SqlStr") String SqlStr);
}


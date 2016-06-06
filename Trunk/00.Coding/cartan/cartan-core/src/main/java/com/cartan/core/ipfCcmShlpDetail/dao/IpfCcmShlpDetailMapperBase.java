package com.cartan.core.ipfCcmShlpDetail.dao;

import com.cartan.core.ipfCcmShlpDetail.domain.IpfCcmShlpDetail;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmShlpDetailMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_shlp_detail s WHERE s.ID = #{id}")
	IpfCcmShlpDetail getIpfCcmShlpDetail(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_shlp_detail(ID,IPF_CCM_SHLP_ID,SHLP_NAME,FIELD_NAME,FIELD_TEXT,LIST_POSITION,IS_VISIBLE,IS_INPUT,IS_OUTPUT,DETAIL_STATUS,DATA_TYPE,DECIMALS,DEFAULT_VALUE,COLUMN_LENGTH,CONDITION_POSITION,OPERATION,IS_ROLL_CHANGE,IS_EDITABLE,DDTEXT,IS_SORT,SORT_ORDER,SORT_TYPE) VALUES(#{id},#{ipfCcmShlpId},#{shlpName},#{fieldName},#{fieldText},#{listPosition},#{isVisible},#{isInput},#{isOutput},#{detailStatus},#{dataType},#{decimals},#{defaultValue},#{columnLength},#{conditionPosition},#{operation},#{isRollChange},#{isEditable},#{ddtext},#{isSort},#{sortOrder},#{sortType})")
    void createIpfCcmShlpDetail(IpfCcmShlpDetail ipfCcmShlpDetail);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_shlp_detail WHERE ID = #{id}")
    void deleteIpfCcmShlpDetail(String id);

    @Update("update cartan_common.t_ipf_ccm_shlp_detail set IPF_CCM_SHLP_ID=#{ipfCcmShlpId},SHLP_NAME=#{shlpName},FIELD_NAME=#{fieldName},FIELD_TEXT=#{fieldText},LIST_POSITION=#{listPosition},IS_VISIBLE=#{isVisible},IS_INPUT=#{isInput},IS_OUTPUT=#{isOutput},DETAIL_STATUS=#{detailStatus},DATA_TYPE=#{dataType},DECIMALS=#{decimals},DEFAULT_VALUE=#{defaultValue},COLUMN_LENGTH=#{columnLength},CONDITION_POSITION=#{conditionPosition},OPERATION=#{operation},IS_ROLL_CHANGE=#{isRollChange},IS_EDITABLE=#{isEditable},DDTEXT=#{ddtext},IS_SORT=#{isSort},SORT_ORDER=#{sortOrder},SORT_TYPE=#{sortType} where ID = #{id}")
    void updateIpfCcmShlpDetail(IpfCcmShlpDetail ipfCcmShlpDetail);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_shlp_detail")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_shlp_detail order by ID asc")
    ArrayList<IpfCcmShlpDetail> selectAll();
    
    @SelectProvider(type = IpfCcmShlpDetailSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmShlpDetail> selectWithCondition(@Param("ipfCcmShlpDetail") IpfCcmShlpDetail ipfCcmShlpDetail,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmShlpDetail> selectBySql(@Param("SqlStr") String SqlStr);
}


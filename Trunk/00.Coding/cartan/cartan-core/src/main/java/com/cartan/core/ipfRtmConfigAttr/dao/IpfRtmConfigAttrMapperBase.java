package com.cartan.core.ipfRtmConfigAttr.dao;

import com.cartan.core.ipfRtmConfigAttr.domain.IpfRtmConfigAttr;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfRtmConfigAttrMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_rtm_config_attr s WHERE s.ID = #{id}")
	IpfRtmConfigAttr getIpfRtmConfigAttr(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_rtm_config_attr(ID,IPF_RTM_CONFIG_ID,SEQ_NO,DISPLAY_LABEL,DATA_TYPE,UI_TYPE,DICT_TABLE_NAME,DICT_GROUP_VALUE,SEARCH_HELP,SH_VALUE_COLUMN,SH_DISPLAY_COLUMN) VALUES(#{id},#{ipfRtmConfigId},#{seqNo},#{displayLabel},#{dataType},#{uiType},#{dictTableName},#{dictGroupValue},#{searchHelp},#{shValueColumn},#{shDisplayColumn})")
    void createIpfRtmConfigAttr(IpfRtmConfigAttr ipfRtmConfigAttr);
    
    @Delete("DELETE FROM cartan_common.t_ipf_rtm_config_attr WHERE ID = #{id}")
    void deleteIpfRtmConfigAttr(String id);

    @Update("update cartan_common.t_ipf_rtm_config_attr set IPF_RTM_CONFIG_ID=#{ipfRtmConfigId},SEQ_NO=#{seqNo},DISPLAY_LABEL=#{displayLabel},DATA_TYPE=#{dataType},UI_TYPE=#{uiType},DICT_TABLE_NAME=#{dictTableName},DICT_GROUP_VALUE=#{dictGroupValue},SEARCH_HELP=#{searchHelp},SH_VALUE_COLUMN=#{shValueColumn},SH_DISPLAY_COLUMN=#{shDisplayColumn} where ID = #{id}")
    void updateIpfRtmConfigAttr(IpfRtmConfigAttr ipfRtmConfigAttr);

    @Select("select count(*) c from cartan_common.t_ipf_rtm_config_attr")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_rtm_config_attr order by ID asc")
    ArrayList<IpfRtmConfigAttr> selectAll();
    
    @SelectProvider(type = IpfRtmConfigAttrSqlProvider.class, method = "getSql")
    ArrayList<IpfRtmConfigAttr> selectWithCondition(@Param("ipfRtmConfigAttr") IpfRtmConfigAttr ipfRtmConfigAttr,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfRtmConfigAttr> selectBySql(@Param("SqlStr") String SqlStr);
}


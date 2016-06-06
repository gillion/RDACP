package com.cartan.core.ipfPoiSetting.dao;

import com.cartan.core.ipfPoiSetting.domain.IpfPoiSetting;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfPoiSettingMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_poi_setting s WHERE s.ID = #{id}")
	IpfPoiSetting getIpfPoiSetting(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_poi_setting(ID,BO_NAME,POI_TYPE,TEMPLATE_FILE_NAME,TEMPLATE_URL,FILE_NAME,SOURCE_SERVICE,CLASS_NAME,TEMPLATE_EXT_NAME,RULE_NO,DICT_NAME,DEAL_SERVICE,METHODE_NAME,IS_ASYNC,ASYNC_PAGE_SIZE,TEMPLATE,TEMPLATE_FILE_KEY,PRIMARY_COLUMNS,CHILDREN_TABLE,SORT_EXPRESS,ALLOW_PARAMETER,IPF_DEFINE_COLUMN) VALUES(#{id},#{boName},#{poiType},#{templateFileName},#{templateUrl},#{fileName},#{sourceService},#{className},#{templateExtName},#{ruleNo},#{dictName},#{dealService},#{methodeName},#{isAsync},#{asyncPageSize},#{template},#{templateFileKey},#{primaryColumns},#{childrenTable},#{sortExpress},#{allowParameter},#{ipfDefineColumn})")
    void createIpfPoiSetting(IpfPoiSetting ipfPoiSetting);
    
    @Delete("DELETE FROM cartan_common.t_ipf_poi_setting WHERE ID = #{id}")
    void deleteIpfPoiSetting(String id);

    @Update("update cartan_common.t_ipf_poi_setting set BO_NAME=#{boName},POI_TYPE=#{poiType},TEMPLATE_FILE_NAME=#{templateFileName},TEMPLATE_URL=#{templateUrl},FILE_NAME=#{fileName},SOURCE_SERVICE=#{sourceService},CLASS_NAME=#{className},TEMPLATE_EXT_NAME=#{templateExtName},RULE_NO=#{ruleNo},DICT_NAME=#{dictName},DEAL_SERVICE=#{dealService},METHODE_NAME=#{methodeName},IS_ASYNC=#{isAsync},ASYNC_PAGE_SIZE=#{asyncPageSize},TEMPLATE=#{template},TEMPLATE_FILE_KEY=#{templateFileKey},PRIMARY_COLUMNS=#{primaryColumns},CHILDREN_TABLE=#{childrenTable},SORT_EXPRESS=#{sortExpress},ALLOW_PARAMETER=#{allowParameter},IPF_DEFINE_COLUMN=#{ipfDefineColumn} where ID = #{id}")
    void updateIpfPoiSetting(IpfPoiSetting ipfPoiSetting);

    @Select("select count(*) c from cartan_common.t_ipf_poi_setting")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_poi_setting order by ID asc")
    ArrayList<IpfPoiSetting> selectAll();
    
    @SelectProvider(type = IpfPoiSettingSqlProvider.class, method = "getSql")
    ArrayList<IpfPoiSetting> selectWithCondition(@Param("ipfPoiSetting") IpfPoiSetting ipfPoiSetting,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfPoiSetting> selectBySql(@Param("SqlStr") String SqlStr);
}


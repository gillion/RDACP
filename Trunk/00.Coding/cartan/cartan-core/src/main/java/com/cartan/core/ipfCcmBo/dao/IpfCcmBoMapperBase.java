package com.cartan.core.ipfCcmBo.dao;

import com.cartan.core.ipfCcmBo.domain.IpfCcmBo;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo s WHERE s.ID = #{id}")
	IpfCcmBo getIpfCcmBo(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo(ID,BO_NAME,BO_TYPE,APP_MODULE,SERVICE_TYPE,JAVA_PATH,SERVICE_CATEGORY,TABLE_NAME,TABLE_TYPE,DESCRIPTION,SEARCH_COLUMNS,SEARCH_MODE,PAGE_SIZE,IPF_CCM_UI_LAYOUT_ID,UI_LAYOUT_NAME,FORM_CELL_MODE,UI_TEMPLATE,FORM_COLUMNS,GRID_STYLE,GRID_ALIGN,GRID_EDIT_TYPE,GENERATE_OPTION,LOCK_ROW_EXPRESS,GRID_TYPE,IS_MAIN_OBJECT,IS_INIT_DATA_BO,IS_AUTO_LOAD,IS_NEED_ADV_SEARCH,NEED_PAGING,IS_GRID_FILTER,IS_GRID_CUSTOM,REMARK,WHERE_CLAUSE,ID_GENERATOR) VALUES(#{id},#{boName},#{boType},#{appModule},#{serviceType},#{javaPath},#{serviceCategory},#{tableName},#{tableType},#{description},#{searchColumns},#{searchMode},#{pageSize},#{ipfCcmUiLayoutId},#{uiLayoutName},#{formCellMode},#{uiTemplate},#{formColumns},#{gridStyle},#{gridAlign},#{gridEditType},#{generateOption},#{lockRowExpress},#{gridType},#{isMainObject},#{isInitDataBo},#{isAutoLoad},#{isNeedAdvSearch},#{needPaging},#{isGridFilter},#{isGridCustom},#{remark},#{whereClause},#{idGenerator})")
    void createIpfCcmBo(IpfCcmBo ipfCcmBo);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo WHERE ID = #{id}")
    void deleteIpfCcmBo(String id);

    @Update("update cartan_common.t_ipf_ccm_bo set BO_NAME=#{boName},BO_TYPE=#{boType},APP_MODULE=#{appModule},SERVICE_TYPE=#{serviceType},JAVA_PATH=#{javaPath},SERVICE_CATEGORY=#{serviceCategory},TABLE_NAME=#{tableName},TABLE_TYPE=#{tableType},DESCRIPTION=#{description},SEARCH_COLUMNS=#{searchColumns},SEARCH_MODE=#{searchMode},PAGE_SIZE=#{pageSize},IPF_CCM_UI_LAYOUT_ID=#{ipfCcmUiLayoutId},UI_LAYOUT_NAME=#{uiLayoutName},FORM_CELL_MODE=#{formCellMode},UI_TEMPLATE=#{uiTemplate},FORM_COLUMNS=#{formColumns},GRID_STYLE=#{gridStyle},GRID_ALIGN=#{gridAlign},GRID_EDIT_TYPE=#{gridEditType},GENERATE_OPTION=#{generateOption},LOCK_ROW_EXPRESS=#{lockRowExpress},GRID_TYPE=#{gridType},IS_MAIN_OBJECT=#{isMainObject},IS_INIT_DATA_BO=#{isInitDataBo},IS_AUTO_LOAD=#{isAutoLoad},IS_NEED_ADV_SEARCH=#{isNeedAdvSearch},NEED_PAGING=#{needPaging},IS_GRID_FILTER=#{isGridFilter},IS_GRID_CUSTOM=#{isGridCustom},REMARK=#{remark},WHERE_CLAUSE=#{whereClause},ID_GENERATOR=#{idGenerator} where ID = #{id}")
    void updateIpfCcmBo(IpfCcmBo ipfCcmBo);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo order by ID asc")
    ArrayList<IpfCcmBo> selectAll();
    
    @SelectProvider(type = IpfCcmBoSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBo> selectWithCondition(@Param("ipfCcmBo") IpfCcmBo ipfCcmBo,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBo> selectBySql(@Param("SqlStr") String SqlStr);
}


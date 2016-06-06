package com.cartan.core.ipfCcmBoPageLayout.dao;

import com.cartan.core.ipfCcmBoPageLayout.domain.IpfCcmBoPageLayout;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoPageLayoutMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_page_layout s WHERE s.ID = #{id}")
	IpfCcmBoPageLayout getIpfCcmBoPageLayout(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_page_layout(ID,IPF_CCM_BO_PAGE_ID,LAYOUT_TYPE,LAYOUT_CONTAINER_TYPE,LAYOUT_BO_NAME,STYLE_CLASS,STYLE,FORM_TYPE,ELEMENT_NAME,HEIGHT,IS_SHOW_GROUP,GROUP_WIDGET,GROUP_MSG_CODE,GROUP_TITLE,UNIT_COUNT,IS_PARENT,CHILDREN_LINE_COUNT,CELL_NAME,ROW_NO,COLUMN_NO,LABEL_UNIT_COUNT,SEQ_NO,CONTROL_CONNECTOR,PARENT_CELL_NAME) VALUES(#{id},#{ipfCcmBoPageId},#{layoutType},#{layoutContainerType},#{layoutBoName},#{styleClass},#{style},#{formType},#{elementName},#{height},#{isShowGroup},#{groupWidget},#{groupMsgCode},#{groupTitle},#{unitCount},#{isParent},#{childrenLineCount},#{cellName},#{rowNo},#{columnNo},#{labelUnitCount},#{seqNo},#{controlConnector},#{parentCellName})")
    void createIpfCcmBoPageLayout(IpfCcmBoPageLayout ipfCcmBoPageLayout);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_page_layout WHERE ID = #{id}")
    void deleteIpfCcmBoPageLayout(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_page_layout set IPF_CCM_BO_PAGE_ID=#{ipfCcmBoPageId},LAYOUT_TYPE=#{layoutType},LAYOUT_CONTAINER_TYPE=#{layoutContainerType},LAYOUT_BO_NAME=#{layoutBoName},STYLE_CLASS=#{styleClass},STYLE=#{style},FORM_TYPE=#{formType},ELEMENT_NAME=#{elementName},HEIGHT=#{height},IS_SHOW_GROUP=#{isShowGroup},GROUP_WIDGET=#{groupWidget},GROUP_MSG_CODE=#{groupMsgCode},GROUP_TITLE=#{groupTitle},UNIT_COUNT=#{unitCount},IS_PARENT=#{isParent},CHILDREN_LINE_COUNT=#{childrenLineCount},CELL_NAME=#{cellName},ROW_NO=#{rowNo},COLUMN_NO=#{columnNo},LABEL_UNIT_COUNT=#{labelUnitCount},SEQ_NO=#{seqNo},CONTROL_CONNECTOR=#{controlConnector},PARENT_CELL_NAME=#{parentCellName} where ID = #{id}")
    void updateIpfCcmBoPageLayout(IpfCcmBoPageLayout ipfCcmBoPageLayout);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_page_layout")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_page_layout order by ID asc")
    ArrayList<IpfCcmBoPageLayout> selectAll();
    
    @SelectProvider(type = IpfCcmBoPageLayoutSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoPageLayout> selectWithCondition(@Param("ipfCcmBoPageLayout") IpfCcmBoPageLayout ipfCcmBoPageLayout,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoPageLayout> selectBySql(@Param("SqlStr") String SqlStr);
}


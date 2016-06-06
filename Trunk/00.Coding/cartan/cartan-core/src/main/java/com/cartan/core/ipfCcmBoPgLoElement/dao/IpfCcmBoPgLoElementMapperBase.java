package com.cartan.core.ipfCcmBoPgLoElement.dao;

import com.cartan.core.ipfCcmBoPgLoElement.domain.IpfCcmBoPgLoElement;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoPgLoElementMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_pg_lo_element s WHERE s.ID = #{id}")
	IpfCcmBoPgLoElement getIpfCcmBoPgLoElement(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_pg_lo_element(ID,IPF_CCM_BO_PAGE_LAYOUT_ID,SEQ_NO,LAYOUT_ELEMENT_TYPE,LAYOUT_BO_NAME,CONTROL_HEIGHT,CONTROL_WIDTH,TEXT_LINE_NUM,CONTROL_CONNECTOR,IS_NOT_NULL,IS_READ_ONLY,UI_TYPE,IS_VISIBLE,COLUMN_STYLE,LABLE_STYLE,IS_SHOW_LABLE,IS_INLINE,TAB_INDEX,DEFAULT_VALUE,INIT_VALUE_TYPE,CORRECT_TYPE,CONDITION_TYPE,OPERATION,QUERY_TYPE,RANGE_TYPE,METHOD_NAME,PROPERTY_NAME) VALUES(#{id},#{ipfCcmBoPageLayoutId},#{seqNo},#{layoutElementType},#{layoutBoName},#{controlHeight},#{controlWidth},#{textLineNum},#{controlConnector},#{isNotNull},#{isReadOnly},#{uiType},#{isVisible},#{columnStyle},#{lableStyle},#{isShowLable},#{isInline},#{tabIndex},#{defaultValue},#{initValueType},#{correctType},#{conditionType},#{operation},#{queryType},#{rangeType},#{methodName},#{propertyName})")
    void createIpfCcmBoPgLoElement(IpfCcmBoPgLoElement ipfCcmBoPgLoElement);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_pg_lo_element WHERE ID = #{id}")
    void deleteIpfCcmBoPgLoElement(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_pg_lo_element set IPF_CCM_BO_PAGE_LAYOUT_ID=#{ipfCcmBoPageLayoutId},SEQ_NO=#{seqNo},LAYOUT_ELEMENT_TYPE=#{layoutElementType},LAYOUT_BO_NAME=#{layoutBoName},CONTROL_HEIGHT=#{controlHeight},CONTROL_WIDTH=#{controlWidth},TEXT_LINE_NUM=#{textLineNum},CONTROL_CONNECTOR=#{controlConnector},IS_NOT_NULL=#{isNotNull},IS_READ_ONLY=#{isReadOnly},UI_TYPE=#{uiType},IS_VISIBLE=#{isVisible},COLUMN_STYLE=#{columnStyle},LABLE_STYLE=#{lableStyle},IS_SHOW_LABLE=#{isShowLable},IS_INLINE=#{isInline},TAB_INDEX=#{tabIndex},DEFAULT_VALUE=#{defaultValue},INIT_VALUE_TYPE=#{initValueType},CORRECT_TYPE=#{correctType},CONDITION_TYPE=#{conditionType},OPERATION=#{operation},QUERY_TYPE=#{queryType},RANGE_TYPE=#{rangeType},METHOD_NAME=#{methodName},PROPERTY_NAME=#{propertyName} where ID = #{id}")
    void updateIpfCcmBoPgLoElement(IpfCcmBoPgLoElement ipfCcmBoPgLoElement);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_pg_lo_element")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_pg_lo_element order by ID asc")
    ArrayList<IpfCcmBoPgLoElement> selectAll();
    
    @SelectProvider(type = IpfCcmBoPgLoElementSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoPgLoElement> selectWithCondition(@Param("ipfCcmBoPgLoElement") IpfCcmBoPgLoElement ipfCcmBoPgLoElement,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoPgLoElement> selectBySql(@Param("SqlStr") String SqlStr);
}


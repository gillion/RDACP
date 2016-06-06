package com.cartan.core.ipfCcmBoGridColumn.dao;

import com.cartan.core.ipfCcmBoGridColumn.domain.IpfCcmBoGridColumn;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoGridColumnMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_grid_column s WHERE s.ID = #{id}")
	IpfCcmBoGridColumn getIpfCcmBoGridColumn(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_grid_column(ID,IPF_CCM_BO_ID,DEFAULT_VALUE,IS_CONDITION,IS_RANGE,CORRECT_TYPE,IS_SUM,IS_NOT_NULL,IS_ORDER_BY,PROPERTY_NAME,PROPERTY_TYPE,UI_TYPE,COLUMN_NO,IS_READ_ONLY,IS_VISIBLE,WIDTH,PROPERTY_ID,CELL_RULE_NO,METHOD_ID,METHOD_NAME,SEARCH_COLUMN_NO,SEARCH_ROW_NO,OPERATION,CONDITION_VISIBLE,SHLP_VALUE_TYPE,IS_QUICK_SEARCH,QUICK_CELL_NAME,QUICK_TEXT_FORM_HEIGHT,QUICK_TEXT_LINE_NUM,QUICK_INLINE_WIDTH,QUICK_INLINE_ORDER_NO,QUICK_INLINE_CONNECTOR,IS_QUICK_SHOW_LABEL,IS_QUICK_RADIO_INLINE,IS_ADV_SEARCH,ADV_CELL_NAME,ADV_TEXT_FORM_HEIGHT,ADV_TEXT_LINE_NUM,ADV_INLINE_WIDTH,ADV_INLINE_ORDER_NO,ADV_INLINE_CONNECTOR,IS_ADV_SHOW_LABEL,IS_ADV_RADIO_INLINE,TAB_INDEX,IS_CELL_EDITABLE,INIT_VALUE_TYPE,INIT_VALUE_TYPE2,DEFAULT_VALUE2,FIELD_SORT,ACTIVE_EXPRESS,LOCK_COLUMN_EXPRESS,UNLOCK_COLUMN_EXPRESS,IS_SHOW_SORT) VALUES(#{id},#{ipfCcmBoId},#{defaultValue},#{isCondition},#{isRange},#{correctType},#{isSum},#{isNotNull},#{isOrderBy},#{propertyName},#{propertyType},#{uiType},#{columnNo},#{isReadOnly},#{isVisible},#{width},#{propertyId},#{cellRuleNo},#{methodId},#{methodName},#{searchColumnNo},#{searchRowNo},#{operation},#{conditionVisible},#{shlpValueType},#{isQuickSearch},#{quickCellName},#{quickTextFormHeight},#{quickTextLineNum},#{quickInlineWidth},#{quickInlineOrderNo},#{quickInlineConnector},#{isQuickShowLabel},#{isQuickRadioInline},#{isAdvSearch},#{advCellName},#{advTextFormHeight},#{advTextLineNum},#{advInlineWidth},#{advInlineOrderNo},#{advInlineConnector},#{isAdvShowLabel},#{isAdvRadioInline},#{tabIndex},#{isCellEditable},#{initValueType},#{initValueType2},#{defaultValue2},#{fieldSort},#{activeExpress},#{lockColumnExpress},#{unlockColumnExpress},#{isShowSort})")
    void createIpfCcmBoGridColumn(IpfCcmBoGridColumn ipfCcmBoGridColumn);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_grid_column WHERE ID = #{id}")
    void deleteIpfCcmBoGridColumn(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_grid_column set IPF_CCM_BO_ID=#{ipfCcmBoId},DEFAULT_VALUE=#{defaultValue},IS_CONDITION=#{isCondition},IS_RANGE=#{isRange},CORRECT_TYPE=#{correctType},IS_SUM=#{isSum},IS_NOT_NULL=#{isNotNull},IS_ORDER_BY=#{isOrderBy},PROPERTY_NAME=#{propertyName},PROPERTY_TYPE=#{propertyType},UI_TYPE=#{uiType},COLUMN_NO=#{columnNo},IS_READ_ONLY=#{isReadOnly},IS_VISIBLE=#{isVisible},WIDTH=#{width},PROPERTY_ID=#{propertyId},CELL_RULE_NO=#{cellRuleNo},METHOD_ID=#{methodId},METHOD_NAME=#{methodName},SEARCH_COLUMN_NO=#{searchColumnNo},SEARCH_ROW_NO=#{searchRowNo},OPERATION=#{operation},CONDITION_VISIBLE=#{conditionVisible},SHLP_VALUE_TYPE=#{shlpValueType},IS_QUICK_SEARCH=#{isQuickSearch},QUICK_CELL_NAME=#{quickCellName},QUICK_TEXT_FORM_HEIGHT=#{quickTextFormHeight},QUICK_TEXT_LINE_NUM=#{quickTextLineNum},QUICK_INLINE_WIDTH=#{quickInlineWidth},QUICK_INLINE_ORDER_NO=#{quickInlineOrderNo},QUICK_INLINE_CONNECTOR=#{quickInlineConnector},IS_QUICK_SHOW_LABEL=#{isQuickShowLabel},IS_QUICK_RADIO_INLINE=#{isQuickRadioInline},IS_ADV_SEARCH=#{isAdvSearch},ADV_CELL_NAME=#{advCellName},ADV_TEXT_FORM_HEIGHT=#{advTextFormHeight},ADV_TEXT_LINE_NUM=#{advTextLineNum},ADV_INLINE_WIDTH=#{advInlineWidth},ADV_INLINE_ORDER_NO=#{advInlineOrderNo},ADV_INLINE_CONNECTOR=#{advInlineConnector},IS_ADV_SHOW_LABEL=#{isAdvShowLabel},IS_ADV_RADIO_INLINE=#{isAdvRadioInline},TAB_INDEX=#{tabIndex},IS_CELL_EDITABLE=#{isCellEditable},INIT_VALUE_TYPE=#{initValueType},INIT_VALUE_TYPE2=#{initValueType2},DEFAULT_VALUE2=#{defaultValue2},FIELD_SORT=#{fieldSort},ACTIVE_EXPRESS=#{activeExpress},LOCK_COLUMN_EXPRESS=#{lockColumnExpress},UNLOCK_COLUMN_EXPRESS=#{unlockColumnExpress},IS_SHOW_SORT=#{isShowSort} where ID = #{id}")
    void updateIpfCcmBoGridColumn(IpfCcmBoGridColumn ipfCcmBoGridColumn);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_grid_column")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_grid_column order by ID asc")
    ArrayList<IpfCcmBoGridColumn> selectAll();
    
    @SelectProvider(type = IpfCcmBoGridColumnSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoGridColumn> selectWithCondition(@Param("ipfCcmBoGridColumn") IpfCcmBoGridColumn ipfCcmBoGridColumn,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoGridColumn> selectBySql(@Param("SqlStr") String SqlStr);
}


package com.cartan.core.ipfCcmBoFormColumn.dao;

import com.cartan.core.ipfCcmBoFormColumn.domain.IpfCcmBoFormColumn;
import com.cartan.core.SqlProvider;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

public interface IpfCcmBoFormColumnMapperBase {
	@Select("SELECT * FROM cartan_common.t_ipf_ccm_bo_form_column s WHERE s.ID = #{id}")
	IpfCcmBoFormColumn getIpfCcmBoFormColumn(String id);
	
	@Insert("INSERT INTO cartan_common.t_ipf_ccm_bo_form_column(ID,IPF_CCM_BO_ID,DEFAULT_VALUE,IS_GROUP,GROUP_NAME,IS_CA_NOTE,IS_HEADER,IS_NOT_NULL,IS_READ_ONLY,PROPERTY_NAME,PROPERTY_TYPE,COLUMN_NO,ROW_NO,UI_TYPE,IS_VISIBLE,PROPERTY_ID,RULE_NO,COLUMN_STYLE,DISPLAY_LABLE,LABLE_STYLE,CELL_NAME,TEXT_FORM_HEIGHT,TEXT_LINE_NUM,INLINE_WIDTH,INLINE_ORDER_NO,INLINE_CONNECTOR,IS_SHOW_LABEL,IS_RADIO_INLINE,TAB_INDEX,INIT_VALUE_TYPE,CORRECT_TYPE,ACTIVE_EXPRESS) VALUES(#{id},#{ipfCcmBoId},#{defaultValue},#{isGroup},#{groupName},#{isCaNote},#{isHeader},#{isNotNull},#{isReadOnly},#{propertyName},#{propertyType},#{columnNo},#{rowNo},#{uiType},#{isVisible},#{propertyId},#{ruleNo},#{columnStyle},#{displayLable},#{lableStyle},#{cellName},#{textFormHeight},#{textLineNum},#{inlineWidth},#{inlineOrderNo},#{inlineConnector},#{isShowLabel},#{isRadioInline},#{tabIndex},#{initValueType},#{correctType},#{activeExpress})")
    void createIpfCcmBoFormColumn(IpfCcmBoFormColumn ipfCcmBoFormColumn);
    
    @Delete("DELETE FROM cartan_common.t_ipf_ccm_bo_form_column WHERE ID = #{id}")
    void deleteIpfCcmBoFormColumn(String id);

    @Update("update cartan_common.t_ipf_ccm_bo_form_column set IPF_CCM_BO_ID=#{ipfCcmBoId},DEFAULT_VALUE=#{defaultValue},IS_GROUP=#{isGroup},GROUP_NAME=#{groupName},IS_CA_NOTE=#{isCaNote},IS_HEADER=#{isHeader},IS_NOT_NULL=#{isNotNull},IS_READ_ONLY=#{isReadOnly},PROPERTY_NAME=#{propertyName},PROPERTY_TYPE=#{propertyType},COLUMN_NO=#{columnNo},ROW_NO=#{rowNo},UI_TYPE=#{uiType},IS_VISIBLE=#{isVisible},PROPERTY_ID=#{propertyId},RULE_NO=#{ruleNo},COLUMN_STYLE=#{columnStyle},DISPLAY_LABLE=#{displayLable},LABLE_STYLE=#{lableStyle},CELL_NAME=#{cellName},TEXT_FORM_HEIGHT=#{textFormHeight},TEXT_LINE_NUM=#{textLineNum},INLINE_WIDTH=#{inlineWidth},INLINE_ORDER_NO=#{inlineOrderNo},INLINE_CONNECTOR=#{inlineConnector},IS_SHOW_LABEL=#{isShowLabel},IS_RADIO_INLINE=#{isRadioInline},TAB_INDEX=#{tabIndex},INIT_VALUE_TYPE=#{initValueType},CORRECT_TYPE=#{correctType},ACTIVE_EXPRESS=#{activeExpress} where ID = #{id}")
    void updateIpfCcmBoFormColumn(IpfCcmBoFormColumn ipfCcmBoFormColumn);

    @Select("select count(*) c from cartan_common.t_ipf_ccm_bo_form_column")
    int countAll();
    
    @Select("select * from cartan_common.t_ipf_ccm_bo_form_column order by ID asc")
    ArrayList<IpfCcmBoFormColumn> selectAll();
    
    @SelectProvider(type = IpfCcmBoFormColumnSqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoFormColumn> selectWithCondition(@Param("ipfCcmBoFormColumn") IpfCcmBoFormColumn ipfCcmBoFormColumn,@Param("conditions") String conditions);

    @SelectProvider(type = SqlProvider.class, method = "getSql")
    ArrayList<IpfCcmBoFormColumn> selectBySql(@Param("SqlStr") String SqlStr);
}


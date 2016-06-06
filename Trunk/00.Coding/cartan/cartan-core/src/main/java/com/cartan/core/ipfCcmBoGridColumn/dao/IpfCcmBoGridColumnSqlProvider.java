/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoGridColumn.dao;

import com.cartan.core.ipfCcmBoGridColumn.domain.IpfCcmBoGridColumn;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoGridColumnSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_grid_column where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoGridColumn ipfCcmBoGridColumn=new IpfCcmBoGridColumn();
        ipfCcmBoGridColumn=(IpfCcmBoGridColumn)parameter.get("ipfCcmBoGridColumn");

        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoGridColumn.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmBoGridColumn.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getDefaultValue())){
        	conditionsStr.append(" and DEFAULT_VALUE like  CONCAT('%',#{ipfCcmBoGridColumn.DEFAULT_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsCondition())){
        	conditionsStr.append(" and IS_CONDITION like  CONCAT('%',#{ipfCcmBoGridColumn.IS_CONDITION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsRange())){
        	conditionsStr.append(" and IS_RANGE like  CONCAT('%',#{ipfCcmBoGridColumn.IS_RANGE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getCorrectType())){
        	conditionsStr.append(" and CORRECT_TYPE like  CONCAT('%',#{ipfCcmBoGridColumn.CORRECT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsSum())){
        	conditionsStr.append(" and IS_SUM like  CONCAT('%',#{ipfCcmBoGridColumn.IS_SUM},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsNotNull())){
        	conditionsStr.append(" and IS_NOT_NULL like  CONCAT('%',#{ipfCcmBoGridColumn.IS_NOT_NULL},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsOrderBy())){
        	conditionsStr.append(" and IS_ORDER_BY like  CONCAT('%',#{ipfCcmBoGridColumn.IS_ORDER_BY},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoGridColumn.PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getPropertyType())){
        	conditionsStr.append(" and PROPERTY_TYPE like  CONCAT('%',#{ipfCcmBoGridColumn.PROPERTY_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getUiType())){
        	conditionsStr.append(" and UI_TYPE like  CONCAT('%',#{ipfCcmBoGridColumn.UI_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getColumnNo())){
        	conditionsStr.append(" and COLUMN_NO like  CONCAT('%',#{ipfCcmBoGridColumn.COLUMN_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsReadOnly())){
        	conditionsStr.append(" and IS_READ_ONLY like  CONCAT('%',#{ipfCcmBoGridColumn.IS_READ_ONLY},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsVisible())){
        	conditionsStr.append(" and IS_VISIBLE like  CONCAT('%',#{ipfCcmBoGridColumn.IS_VISIBLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getWidth())){
        	conditionsStr.append(" and WIDTH like  CONCAT('%',#{ipfCcmBoGridColumn.WIDTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getPropertyId())){
        	conditionsStr.append(" and PROPERTY_ID like  CONCAT('%',#{ipfCcmBoGridColumn.PROPERTY_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getCellRuleNo())){
        	conditionsStr.append(" and CELL_RULE_NO like  CONCAT('%',#{ipfCcmBoGridColumn.CELL_RULE_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getMethodId())){
        	conditionsStr.append(" and METHOD_ID like  CONCAT('%',#{ipfCcmBoGridColumn.METHOD_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getMethodName())){
        	conditionsStr.append(" and METHOD_NAME like  CONCAT('%',#{ipfCcmBoGridColumn.METHOD_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getSearchColumnNo())){
        	conditionsStr.append(" and SEARCH_COLUMN_NO like  CONCAT('%',#{ipfCcmBoGridColumn.SEARCH_COLUMN_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getSearchRowNo())){
        	conditionsStr.append(" and SEARCH_ROW_NO like  CONCAT('%',#{ipfCcmBoGridColumn.SEARCH_ROW_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getOperation())){
        	conditionsStr.append(" and OPERATION like  CONCAT('%',#{ipfCcmBoGridColumn.OPERATION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getConditionVisible())){
        	conditionsStr.append(" and CONDITION_VISIBLE like  CONCAT('%',#{ipfCcmBoGridColumn.CONDITION_VISIBLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getShlpValueType())){
        	conditionsStr.append(" and SHLP_VALUE_TYPE like  CONCAT('%',#{ipfCcmBoGridColumn.SHLP_VALUE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsQuickSearch())){
        	conditionsStr.append(" and IS_QUICK_SEARCH like  CONCAT('%',#{ipfCcmBoGridColumn.IS_QUICK_SEARCH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getQuickCellName())){
        	conditionsStr.append(" and QUICK_CELL_NAME like  CONCAT('%',#{ipfCcmBoGridColumn.QUICK_CELL_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getQuickTextFormHeight())){
        	conditionsStr.append(" and QUICK_TEXT_FORM_HEIGHT like  CONCAT('%',#{ipfCcmBoGridColumn.QUICK_TEXT_FORM_HEIGHT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getQuickTextLineNum())){
        	conditionsStr.append(" and QUICK_TEXT_LINE_NUM like  CONCAT('%',#{ipfCcmBoGridColumn.QUICK_TEXT_LINE_NUM},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getQuickInlineWidth())){
        	conditionsStr.append(" and QUICK_INLINE_WIDTH like  CONCAT('%',#{ipfCcmBoGridColumn.QUICK_INLINE_WIDTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getQuickInlineOrderNo())){
        	conditionsStr.append(" and QUICK_INLINE_ORDER_NO like  CONCAT('%',#{ipfCcmBoGridColumn.QUICK_INLINE_ORDER_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getQuickInlineConnector())){
        	conditionsStr.append(" and QUICK_INLINE_CONNECTOR like  CONCAT('%',#{ipfCcmBoGridColumn.QUICK_INLINE_CONNECTOR},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsQuickShowLabel())){
        	conditionsStr.append(" and IS_QUICK_SHOW_LABEL like  CONCAT('%',#{ipfCcmBoGridColumn.IS_QUICK_SHOW_LABEL},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsQuickRadioInline())){
        	conditionsStr.append(" and IS_QUICK_RADIO_INLINE like  CONCAT('%',#{ipfCcmBoGridColumn.IS_QUICK_RADIO_INLINE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsAdvSearch())){
        	conditionsStr.append(" and IS_ADV_SEARCH like  CONCAT('%',#{ipfCcmBoGridColumn.IS_ADV_SEARCH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getAdvCellName())){
        	conditionsStr.append(" and ADV_CELL_NAME like  CONCAT('%',#{ipfCcmBoGridColumn.ADV_CELL_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getAdvTextFormHeight())){
        	conditionsStr.append(" and ADV_TEXT_FORM_HEIGHT like  CONCAT('%',#{ipfCcmBoGridColumn.ADV_TEXT_FORM_HEIGHT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getAdvTextLineNum())){
        	conditionsStr.append(" and ADV_TEXT_LINE_NUM like  CONCAT('%',#{ipfCcmBoGridColumn.ADV_TEXT_LINE_NUM},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getAdvInlineWidth())){
        	conditionsStr.append(" and ADV_INLINE_WIDTH like  CONCAT('%',#{ipfCcmBoGridColumn.ADV_INLINE_WIDTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getAdvInlineOrderNo())){
        	conditionsStr.append(" and ADV_INLINE_ORDER_NO like  CONCAT('%',#{ipfCcmBoGridColumn.ADV_INLINE_ORDER_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getAdvInlineConnector())){
        	conditionsStr.append(" and ADV_INLINE_CONNECTOR like  CONCAT('%',#{ipfCcmBoGridColumn.ADV_INLINE_CONNECTOR},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsAdvShowLabel())){
        	conditionsStr.append(" and IS_ADV_SHOW_LABEL like  CONCAT('%',#{ipfCcmBoGridColumn.IS_ADV_SHOW_LABEL},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsAdvRadioInline())){
        	conditionsStr.append(" and IS_ADV_RADIO_INLINE like  CONCAT('%',#{ipfCcmBoGridColumn.IS_ADV_RADIO_INLINE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getTabIndex())){
        	conditionsStr.append(" and TAB_INDEX like  CONCAT('%',#{ipfCcmBoGridColumn.TAB_INDEX},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsCellEditable())){
        	conditionsStr.append(" and IS_CELL_EDITABLE like  CONCAT('%',#{ipfCcmBoGridColumn.IS_CELL_EDITABLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getInitValueType())){
        	conditionsStr.append(" and INIT_VALUE_TYPE like  CONCAT('%',#{ipfCcmBoGridColumn.INIT_VALUE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getInitValueType2())){
        	conditionsStr.append(" and INIT_VALUE_TYPE2 like  CONCAT('%',#{ipfCcmBoGridColumn.INIT_VALUE_TYPE2},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getDefaultValue2())){
        	conditionsStr.append(" and DEFAULT_VALUE2 like  CONCAT('%',#{ipfCcmBoGridColumn.DEFAULT_VALUE2},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getFieldSort())){
        	conditionsStr.append(" and FIELD_SORT like  CONCAT('%',#{ipfCcmBoGridColumn.FIELD_SORT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getActiveExpress())){
        	conditionsStr.append(" and ACTIVE_EXPRESS like  CONCAT('%',#{ipfCcmBoGridColumn.ACTIVE_EXPRESS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getLockColumnExpress())){
        	conditionsStr.append(" and LOCK_COLUMN_EXPRESS like  CONCAT('%',#{ipfCcmBoGridColumn.LOCK_COLUMN_EXPRESS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getUnlockColumnExpress())){
        	conditionsStr.append(" and UNLOCK_COLUMN_EXPRESS like  CONCAT('%',#{ipfCcmBoGridColumn.UNLOCK_COLUMN_EXPRESS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoGridColumn.getIsShowSort())){
        	conditionsStr.append(" and IS_SHOW_SORT like  CONCAT('%',#{ipfCcmBoGridColumn.IS_SHOW_SORT},'%')");
        }
        return  conditionsStr.toString();
    }
}



/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoFormColumn.dao;

import com.cartan.core.ipfCcmBoFormColumn.domain.IpfCcmBoFormColumn;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoFormColumnSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_form_column where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoFormColumn ipfCcmBoFormColumn=new IpfCcmBoFormColumn();
        ipfCcmBoFormColumn=(IpfCcmBoFormColumn)parameter.get("ipfCcmBoFormColumn");

        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoFormColumn.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmBoFormColumn.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getDefaultValue())){
        	conditionsStr.append(" and DEFAULT_VALUE like  CONCAT('%',#{ipfCcmBoFormColumn.DEFAULT_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getIsGroup())){
        	conditionsStr.append(" and IS_GROUP like  CONCAT('%',#{ipfCcmBoFormColumn.IS_GROUP},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getGroupName())){
        	conditionsStr.append(" and GROUP_NAME like  CONCAT('%',#{ipfCcmBoFormColumn.GROUP_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getIsCaNote())){
        	conditionsStr.append(" and IS_CA_NOTE like  CONCAT('%',#{ipfCcmBoFormColumn.IS_CA_NOTE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getIsHeader())){
        	conditionsStr.append(" and IS_HEADER like  CONCAT('%',#{ipfCcmBoFormColumn.IS_HEADER},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getIsNotNull())){
        	conditionsStr.append(" and IS_NOT_NULL like  CONCAT('%',#{ipfCcmBoFormColumn.IS_NOT_NULL},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getIsReadOnly())){
        	conditionsStr.append(" and IS_READ_ONLY like  CONCAT('%',#{ipfCcmBoFormColumn.IS_READ_ONLY},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoFormColumn.PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getPropertyType())){
        	conditionsStr.append(" and PROPERTY_TYPE like  CONCAT('%',#{ipfCcmBoFormColumn.PROPERTY_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getColumnNo())){
        	conditionsStr.append(" and COLUMN_NO like  CONCAT('%',#{ipfCcmBoFormColumn.COLUMN_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getRowNo())){
        	conditionsStr.append(" and ROW_NO like  CONCAT('%',#{ipfCcmBoFormColumn.ROW_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getUiType())){
        	conditionsStr.append(" and UI_TYPE like  CONCAT('%',#{ipfCcmBoFormColumn.UI_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getIsVisible())){
        	conditionsStr.append(" and IS_VISIBLE like  CONCAT('%',#{ipfCcmBoFormColumn.IS_VISIBLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getPropertyId())){
        	conditionsStr.append(" and PROPERTY_ID like  CONCAT('%',#{ipfCcmBoFormColumn.PROPERTY_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getRuleNo())){
        	conditionsStr.append(" and RULE_NO like  CONCAT('%',#{ipfCcmBoFormColumn.RULE_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getColumnStyle())){
        	conditionsStr.append(" and COLUMN_STYLE like  CONCAT('%',#{ipfCcmBoFormColumn.COLUMN_STYLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getDisplayLable())){
        	conditionsStr.append(" and DISPLAY_LABLE like  CONCAT('%',#{ipfCcmBoFormColumn.DISPLAY_LABLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getLableStyle())){
        	conditionsStr.append(" and LABLE_STYLE like  CONCAT('%',#{ipfCcmBoFormColumn.LABLE_STYLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getCellName())){
        	conditionsStr.append(" and CELL_NAME like  CONCAT('%',#{ipfCcmBoFormColumn.CELL_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getTextFormHeight())){
        	conditionsStr.append(" and TEXT_FORM_HEIGHT like  CONCAT('%',#{ipfCcmBoFormColumn.TEXT_FORM_HEIGHT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getTextLineNum())){
        	conditionsStr.append(" and TEXT_LINE_NUM like  CONCAT('%',#{ipfCcmBoFormColumn.TEXT_LINE_NUM},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getInlineWidth())){
        	conditionsStr.append(" and INLINE_WIDTH like  CONCAT('%',#{ipfCcmBoFormColumn.INLINE_WIDTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getInlineOrderNo())){
        	conditionsStr.append(" and INLINE_ORDER_NO like  CONCAT('%',#{ipfCcmBoFormColumn.INLINE_ORDER_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getInlineConnector())){
        	conditionsStr.append(" and INLINE_CONNECTOR like  CONCAT('%',#{ipfCcmBoFormColumn.INLINE_CONNECTOR},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getIsShowLabel())){
        	conditionsStr.append(" and IS_SHOW_LABEL like  CONCAT('%',#{ipfCcmBoFormColumn.IS_SHOW_LABEL},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getIsRadioInline())){
        	conditionsStr.append(" and IS_RADIO_INLINE like  CONCAT('%',#{ipfCcmBoFormColumn.IS_RADIO_INLINE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getTabIndex())){
        	conditionsStr.append(" and TAB_INDEX like  CONCAT('%',#{ipfCcmBoFormColumn.TAB_INDEX},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getInitValueType())){
        	conditionsStr.append(" and INIT_VALUE_TYPE like  CONCAT('%',#{ipfCcmBoFormColumn.INIT_VALUE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getCorrectType())){
        	conditionsStr.append(" and CORRECT_TYPE like  CONCAT('%',#{ipfCcmBoFormColumn.CORRECT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoFormColumn.getActiveExpress())){
        	conditionsStr.append(" and ACTIVE_EXPRESS like  CONCAT('%',#{ipfCcmBoFormColumn.ACTIVE_EXPRESS},'%')");
        }
        return  conditionsStr.toString();
    }
}



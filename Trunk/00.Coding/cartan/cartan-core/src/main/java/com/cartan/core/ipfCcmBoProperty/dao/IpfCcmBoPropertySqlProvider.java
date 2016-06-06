/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoProperty.dao;

import com.cartan.core.ipfCcmBoProperty.domain.IpfCcmBoProperty;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoPropertySqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_property where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoProperty ipfCcmBoProperty=new IpfCcmBoProperty();
        ipfCcmBoProperty=(IpfCcmBoProperty)parameter.get("ipfCcmBoProperty");

        if(StringUtils.isNotBlank(ipfCcmBoProperty.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoProperty.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoProperty.PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getColumnName())){
        	conditionsStr.append(" and COLUMN_NAME like  CONCAT('%',#{ipfCcmBoProperty.COLUMN_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getPropertyType())){
        	conditionsStr.append(" and PROPERTY_TYPE like  CONCAT('%',#{ipfCcmBoProperty.PROPERTY_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getSubBoLayoutType())){
        	conditionsStr.append(" and SUB_BO_LAYOUT_TYPE like  CONCAT('%',#{ipfCcmBoProperty.SUB_BO_LAYOUT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getTableName())){
        	conditionsStr.append(" and TABLE_NAME like  CONCAT('%',#{ipfCcmBoProperty.TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getMaxValue())){
        	conditionsStr.append(" and MAX_VALUE like  CONCAT('%',#{ipfCcmBoProperty.MAX_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getMinValue())){
        	conditionsStr.append(" and MIN_VALUE like  CONCAT('%',#{ipfCcmBoProperty.MIN_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getElementCode())){
        	conditionsStr.append(" and ELEMENT_CODE like  CONCAT('%',#{ipfCcmBoProperty.ELEMENT_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getFieldText())){
        	conditionsStr.append(" and FIELD_TEXT like  CONCAT('%',#{ipfCcmBoProperty.FIELD_TEXT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getDataType())){
        	conditionsStr.append(" and DATA_TYPE like  CONCAT('%',#{ipfCcmBoProperty.DATA_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getFieldLength())){
        	conditionsStr.append(" and FIELD_LENGTH like  CONCAT('%',#{ipfCcmBoProperty.FIELD_LENGTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getDecimals())){
        	conditionsStr.append(" and DECIMALS like  CONCAT('%',#{ipfCcmBoProperty.DECIMALS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getIsNotNull())){
        	conditionsStr.append(" and IS_NOT_NULL like  CONCAT('%',#{ipfCcmBoProperty.IS_NOT_NULL},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getIsKey())){
        	conditionsStr.append(" and IS_KEY like  CONCAT('%',#{ipfCcmBoProperty.IS_KEY},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getSubBoName())){
        	conditionsStr.append(" and SUB_BO_NAME like  CONCAT('%',#{ipfCcmBoProperty.SUB_BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getSubBoRelType())){
        	conditionsStr.append(" and SUB_BO_REL_TYPE like  CONCAT('%',#{ipfCcmBoProperty.SUB_BO_REL_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getSubBoRelPro())){
        	conditionsStr.append(" and SUB_BO_REL_PRO like  CONCAT('%',#{ipfCcmBoProperty.SUB_BO_REL_PRO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getSubBoOrderNo())){
        	conditionsStr.append(" and SUB_BO_ORDER_NO like  CONCAT('%',#{ipfCcmBoProperty.SUB_BO_ORDER_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getPersistentSaveType())){
        	conditionsStr.append(" and PERSISTENT_SAVE_TYPE like  CONCAT('%',#{ipfCcmBoProperty.PERSISTENT_SAVE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getRelSubBoProName())){
        	conditionsStr.append(" and REL_SUB_BO_PRO_NAME like  CONCAT('%',#{ipfCcmBoProperty.REL_SUB_BO_PRO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getSearchHelp())){
        	conditionsStr.append(" and SEARCH_HELP like  CONCAT('%',#{ipfCcmBoProperty.SEARCH_HELP},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getRefProName())){
        	conditionsStr.append(" and REF_PRO_NAME like  CONCAT('%',#{ipfCcmBoProperty.REF_PRO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getDictTableName())){
        	conditionsStr.append(" and DICT_TABLE_NAME like  CONCAT('%',#{ipfCcmBoProperty.DICT_TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getDictGroupValue())){
        	conditionsStr.append(" and DICT_GROUP_VALUE like  CONCAT('%',#{ipfCcmBoProperty.DICT_GROUP_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getFetchWay())){
        	conditionsStr.append(" and FETCH_WAY like  CONCAT('%',#{ipfCcmBoProperty.FETCH_WAY},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getFixValue())){
        	conditionsStr.append(" and FIX_VALUE like  CONCAT('%',#{ipfCcmBoProperty.FIX_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getValueExpression())){
        	conditionsStr.append(" and VALUE_EXPRESSION like  CONCAT('%',#{ipfCcmBoProperty.VALUE_EXPRESSION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getVlaueRuleNo())){
        	conditionsStr.append(" and VLAUE_RULE_NO like  CONCAT('%',#{ipfCcmBoProperty.VLAUE_RULE_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getPreCondition())){
        	conditionsStr.append(" and PRE_CONDITION like  CONCAT('%',#{ipfCcmBoProperty.PRE_CONDITION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getOptCondition())){
        	conditionsStr.append(" and OPT_CONDITION like  CONCAT('%',#{ipfCcmBoProperty.OPT_CONDITION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getIsSurcharge())){
        	conditionsStr.append(" and IS_SURCHARGE like  CONCAT('%',#{ipfCcmBoProperty.IS_SURCHARGE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getIsRealtimeCalculate())){
        	conditionsStr.append(" and IS_REALTIME_CALCULATE like  CONCAT('%',#{ipfCcmBoProperty.IS_REALTIME_CALCULATE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getRpType())){
        	conditionsStr.append(" and RP_TYPE like  CONCAT('%',#{ipfCcmBoProperty.RP_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getCustIdPropertyName())){
        	conditionsStr.append(" and CUST_ID_PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoProperty.CUST_ID_PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getBusinessDatePropertyName())){
        	conditionsStr.append(" and BUSINESS_DATE_PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoProperty.BUSINESS_DATE_PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfCcmBoProperty.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getAuthField())){
        	conditionsStr.append(" and AUTH_FIELD like  CONCAT('%',#{ipfCcmBoProperty.AUTH_FIELD},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getHelpIndex())){
        	conditionsStr.append(" and HELP_INDEX like  CONCAT('%',#{ipfCcmBoProperty.HELP_INDEX},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getNumberObjectId())){
        	conditionsStr.append(" and NUMBER_OBJECT_ID like  CONCAT('%',#{ipfCcmBoProperty.NUMBER_OBJECT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getRelBoMethod())){
        	conditionsStr.append(" and REL_BO_METHOD like  CONCAT('%',#{ipfCcmBoProperty.REL_BO_METHOD},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getRelBoName())){
        	conditionsStr.append(" and REL_BO_NAME like  CONCAT('%',#{ipfCcmBoProperty.REL_BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getShTable())){
        	conditionsStr.append(" and SH_TABLE like  CONCAT('%',#{ipfCcmBoProperty.SH_TABLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getShValueColumn())){
        	conditionsStr.append(" and SH_VALUE_COLUMN like  CONCAT('%',#{ipfCcmBoProperty.SH_VALUE_COLUMN},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getValidactionType())){
        	conditionsStr.append(" and VALIDACTION_TYPE like  CONCAT('%',#{ipfCcmBoProperty.VALIDACTION_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoProperty.getValidactionRegex())){
        	conditionsStr.append(" and VALIDACTION_REGEX like  CONCAT('%',#{ipfCcmBoProperty.VALIDACTION_REGEX},'%')");
        }
        return  conditionsStr.toString();
    }
}



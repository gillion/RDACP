/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoPgLoElement.dao;

import com.cartan.core.ipfCcmBoPgLoElement.domain.IpfCcmBoPgLoElement;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoPgLoElementSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_pg_lo_element where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoPgLoElement ipfCcmBoPgLoElement=new IpfCcmBoPgLoElement();
        ipfCcmBoPgLoElement=(IpfCcmBoPgLoElement)parameter.get("ipfCcmBoPgLoElement");

        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoPgLoElement.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getIpfCcmBoPageLayoutId())){
        	conditionsStr.append(" and IPF_CCM_BO_PAGE_LAYOUT_ID like  CONCAT('%',#{ipfCcmBoPgLoElement.IPF_CCM_BO_PAGE_LAYOUT_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getSeqNo())){
        	conditionsStr.append(" and SEQ_NO like  CONCAT('%',#{ipfCcmBoPgLoElement.SEQ_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getLayoutElementType())){
        	conditionsStr.append(" and LAYOUT_ELEMENT_TYPE like  CONCAT('%',#{ipfCcmBoPgLoElement.LAYOUT_ELEMENT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getLayoutBoName())){
        	conditionsStr.append(" and LAYOUT_BO_NAME like  CONCAT('%',#{ipfCcmBoPgLoElement.LAYOUT_BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getControlHeight())){
        	conditionsStr.append(" and CONTROL_HEIGHT like  CONCAT('%',#{ipfCcmBoPgLoElement.CONTROL_HEIGHT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getControlWidth())){
        	conditionsStr.append(" and CONTROL_WIDTH like  CONCAT('%',#{ipfCcmBoPgLoElement.CONTROL_WIDTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getTextLineNum())){
        	conditionsStr.append(" and TEXT_LINE_NUM like  CONCAT('%',#{ipfCcmBoPgLoElement.TEXT_LINE_NUM},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getControlConnector())){
        	conditionsStr.append(" and CONTROL_CONNECTOR like  CONCAT('%',#{ipfCcmBoPgLoElement.CONTROL_CONNECTOR},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getIsNotNull())){
        	conditionsStr.append(" and IS_NOT_NULL like  CONCAT('%',#{ipfCcmBoPgLoElement.IS_NOT_NULL},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getIsReadOnly())){
        	conditionsStr.append(" and IS_READ_ONLY like  CONCAT('%',#{ipfCcmBoPgLoElement.IS_READ_ONLY},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getUiType())){
        	conditionsStr.append(" and UI_TYPE like  CONCAT('%',#{ipfCcmBoPgLoElement.UI_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getIsVisible())){
        	conditionsStr.append(" and IS_VISIBLE like  CONCAT('%',#{ipfCcmBoPgLoElement.IS_VISIBLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getColumnStyle())){
        	conditionsStr.append(" and COLUMN_STYLE like  CONCAT('%',#{ipfCcmBoPgLoElement.COLUMN_STYLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getLableStyle())){
        	conditionsStr.append(" and LABLE_STYLE like  CONCAT('%',#{ipfCcmBoPgLoElement.LABLE_STYLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getIsShowLable())){
        	conditionsStr.append(" and IS_SHOW_LABLE like  CONCAT('%',#{ipfCcmBoPgLoElement.IS_SHOW_LABLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getIsInline())){
        	conditionsStr.append(" and IS_INLINE like  CONCAT('%',#{ipfCcmBoPgLoElement.IS_INLINE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getTabIndex())){
        	conditionsStr.append(" and TAB_INDEX like  CONCAT('%',#{ipfCcmBoPgLoElement.TAB_INDEX},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getDefaultValue())){
        	conditionsStr.append(" and DEFAULT_VALUE like  CONCAT('%',#{ipfCcmBoPgLoElement.DEFAULT_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getInitValueType())){
        	conditionsStr.append(" and INIT_VALUE_TYPE like  CONCAT('%',#{ipfCcmBoPgLoElement.INIT_VALUE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getCorrectType())){
        	conditionsStr.append(" and CORRECT_TYPE like  CONCAT('%',#{ipfCcmBoPgLoElement.CORRECT_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getConditionType())){
        	conditionsStr.append(" and CONDITION_TYPE like  CONCAT('%',#{ipfCcmBoPgLoElement.CONDITION_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getOperation())){
        	conditionsStr.append(" and OPERATION like  CONCAT('%',#{ipfCcmBoPgLoElement.OPERATION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getQueryType())){
        	conditionsStr.append(" and QUERY_TYPE like  CONCAT('%',#{ipfCcmBoPgLoElement.QUERY_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getRangeType())){
        	conditionsStr.append(" and RANGE_TYPE like  CONCAT('%',#{ipfCcmBoPgLoElement.RANGE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getMethodName())){
        	conditionsStr.append(" and METHOD_NAME like  CONCAT('%',#{ipfCcmBoPgLoElement.METHOD_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPgLoElement.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoPgLoElement.PROPERTY_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}



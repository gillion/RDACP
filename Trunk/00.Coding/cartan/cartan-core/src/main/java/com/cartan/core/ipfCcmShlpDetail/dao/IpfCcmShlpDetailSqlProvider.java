/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmShlpDetail.dao;

import com.cartan.core.ipfCcmShlpDetail.domain.IpfCcmShlpDetail;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmShlpDetailSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_shlp_detail where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmShlpDetail ipfCcmShlpDetail=new IpfCcmShlpDetail();
        ipfCcmShlpDetail=(IpfCcmShlpDetail)parameter.get("ipfCcmShlpDetail");

        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmShlpDetail.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getIpfCcmShlpId())){
        	conditionsStr.append(" and IPF_CCM_SHLP_ID like  CONCAT('%',#{ipfCcmShlpDetail.IPF_CCM_SHLP_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getShlpName())){
        	conditionsStr.append(" and SHLP_NAME like  CONCAT('%',#{ipfCcmShlpDetail.SHLP_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getFieldName())){
        	conditionsStr.append(" and FIELD_NAME like  CONCAT('%',#{ipfCcmShlpDetail.FIELD_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getFieldText())){
        	conditionsStr.append(" and FIELD_TEXT like  CONCAT('%',#{ipfCcmShlpDetail.FIELD_TEXT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getListPosition())){
        	conditionsStr.append(" and LIST_POSITION like  CONCAT('%',#{ipfCcmShlpDetail.LIST_POSITION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getIsVisible())){
        	conditionsStr.append(" and IS_VISIBLE like  CONCAT('%',#{ipfCcmShlpDetail.IS_VISIBLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getIsInput())){
        	conditionsStr.append(" and IS_INPUT like  CONCAT('%',#{ipfCcmShlpDetail.IS_INPUT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getIsOutput())){
        	conditionsStr.append(" and IS_OUTPUT like  CONCAT('%',#{ipfCcmShlpDetail.IS_OUTPUT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getDetailStatus())){
        	conditionsStr.append(" and DETAIL_STATUS like  CONCAT('%',#{ipfCcmShlpDetail.DETAIL_STATUS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getDataType())){
        	conditionsStr.append(" and DATA_TYPE like  CONCAT('%',#{ipfCcmShlpDetail.DATA_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getDecimals())){
        	conditionsStr.append(" and DECIMALS like  CONCAT('%',#{ipfCcmShlpDetail.DECIMALS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getDefaultValue())){
        	conditionsStr.append(" and DEFAULT_VALUE like  CONCAT('%',#{ipfCcmShlpDetail.DEFAULT_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getColumnLength())){
        	conditionsStr.append(" and COLUMN_LENGTH like  CONCAT('%',#{ipfCcmShlpDetail.COLUMN_LENGTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getConditionPosition())){
        	conditionsStr.append(" and CONDITION_POSITION like  CONCAT('%',#{ipfCcmShlpDetail.CONDITION_POSITION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getOperation())){
        	conditionsStr.append(" and OPERATION like  CONCAT('%',#{ipfCcmShlpDetail.OPERATION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getIsRollChange())){
        	conditionsStr.append(" and IS_ROLL_CHANGE like  CONCAT('%',#{ipfCcmShlpDetail.IS_ROLL_CHANGE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getIsEditable())){
        	conditionsStr.append(" and IS_EDITABLE like  CONCAT('%',#{ipfCcmShlpDetail.IS_EDITABLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getDdtext())){
        	conditionsStr.append(" and DDTEXT like  CONCAT('%',#{ipfCcmShlpDetail.DDTEXT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getIsSort())){
        	conditionsStr.append(" and IS_SORT like  CONCAT('%',#{ipfCcmShlpDetail.IS_SORT},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getSortOrder())){
        	conditionsStr.append(" and SORT_ORDER like  CONCAT('%',#{ipfCcmShlpDetail.SORT_ORDER},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlpDetail.getSortType())){
        	conditionsStr.append(" and SORT_TYPE like  CONCAT('%',#{ipfCcmShlpDetail.SORT_TYPE},'%')");
        }
        return  conditionsStr.toString();
    }
}



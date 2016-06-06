/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRtmConfigAttr.dao;

import com.cartan.core.ipfRtmConfigAttr.domain.IpfRtmConfigAttr;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRtmConfigAttrSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rtm_config_attr where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRtmConfigAttr ipfRtmConfigAttr=new IpfRtmConfigAttr();
        ipfRtmConfigAttr=(IpfRtmConfigAttr)parameter.get("ipfRtmConfigAttr");

        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getId())){
        	conditionsStr.append(" and ID = #{ipfRtmConfigAttr.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getIpfRtmConfigId())){
        	conditionsStr.append(" and IPF_RTM_CONFIG_ID like  CONCAT('%',#{ipfRtmConfigAttr.IPF_RTM_CONFIG_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getSeqNo())){
        	conditionsStr.append(" and SEQ_NO like  CONCAT('%',#{ipfRtmConfigAttr.SEQ_NO},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getDisplayLabel())){
        	conditionsStr.append(" and DISPLAY_LABEL like  CONCAT('%',#{ipfRtmConfigAttr.DISPLAY_LABEL},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getDataType())){
        	conditionsStr.append(" and DATA_TYPE like  CONCAT('%',#{ipfRtmConfigAttr.DATA_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getUiType())){
        	conditionsStr.append(" and UI_TYPE like  CONCAT('%',#{ipfRtmConfigAttr.UI_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getDictTableName())){
        	conditionsStr.append(" and DICT_TABLE_NAME like  CONCAT('%',#{ipfRtmConfigAttr.DICT_TABLE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getDictGroupValue())){
        	conditionsStr.append(" and DICT_GROUP_VALUE like  CONCAT('%',#{ipfRtmConfigAttr.DICT_GROUP_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getSearchHelp())){
        	conditionsStr.append(" and SEARCH_HELP like  CONCAT('%',#{ipfRtmConfigAttr.SEARCH_HELP},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getShValueColumn())){
        	conditionsStr.append(" and SH_VALUE_COLUMN like  CONCAT('%',#{ipfRtmConfigAttr.SH_VALUE_COLUMN},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttr.getShDisplayColumn())){
        	conditionsStr.append(" and SH_DISPLAY_COLUMN like  CONCAT('%',#{ipfRtmConfigAttr.SH_DISPLAY_COLUMN},'%')");
        }
        return  conditionsStr.toString();
    }
}



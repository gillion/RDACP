/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRtmConfigAttrBo.dao;

import com.cartan.core.ipfRtmConfigAttrBo.domain.IpfRtmConfigAttrBo;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRtmConfigAttrBoSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rtm_config_attr_bo where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRtmConfigAttrBo ipfRtmConfigAttrBo=new IpfRtmConfigAttrBo();
        ipfRtmConfigAttrBo=(IpfRtmConfigAttrBo)parameter.get("ipfRtmConfigAttrBo");

        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getId())){
        	conditionsStr.append(" and ID = #{ipfRtmConfigAttrBo.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getIpfRtmConfigAttrId())){
        	conditionsStr.append(" and IPF_RTM_CONFIG_ATTR_ID like  CONCAT('%',#{ipfRtmConfigAttrBo.IPF_RTM_CONFIG_ATTR_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getIpfRtmConfigId())){
        	conditionsStr.append(" and IPF_RTM_CONFIG_ID like  CONCAT('%',#{ipfRtmConfigAttrBo.IPF_RTM_CONFIG_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfRtmConfigAttrBo.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getBoName())){
        	conditionsStr.append(" and BO_NAME like  CONCAT('%',#{ipfRtmConfigAttrBo.BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getBoDesc())){
        	conditionsStr.append(" and BO_DESC like  CONCAT('%',#{ipfRtmConfigAttrBo.BO_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getBoAttributeName())){
        	conditionsStr.append(" and BO_ATTRIBUTE_NAME like  CONCAT('%',#{ipfRtmConfigAttrBo.BO_ATTRIBUTE_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getIsVisible())){
        	conditionsStr.append(" and IS_VISIBLE like  CONCAT('%',#{ipfRtmConfigAttrBo.IS_VISIBLE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getIsRequired())){
        	conditionsStr.append(" and IS_REQUIRED like  CONCAT('%',#{ipfRtmConfigAttrBo.IS_REQUIRED},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getDefaultValue())){
        	conditionsStr.append(" and DEFAULT_VALUE like  CONCAT('%',#{ipfRtmConfigAttrBo.DEFAULT_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmConfigAttrBo.getShlpValueFiled())){
        	conditionsStr.append(" and SHLP_VALUE_FILED like  CONCAT('%',#{ipfRtmConfigAttrBo.SHLP_VALUE_FILED},'%')");
        }
        return  conditionsStr.toString();
    }
}



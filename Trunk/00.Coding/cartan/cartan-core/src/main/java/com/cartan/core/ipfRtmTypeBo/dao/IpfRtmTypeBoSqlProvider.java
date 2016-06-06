/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRtmTypeBo.dao;

import com.cartan.core.ipfRtmTypeBo.domain.IpfRtmTypeBo;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRtmTypeBoSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rtm_type_bo where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRtmTypeBo ipfRtmTypeBo=new IpfRtmTypeBo();
        ipfRtmTypeBo=(IpfRtmTypeBo)parameter.get("ipfRtmTypeBo");

        if(StringUtils.isNotBlank(ipfRtmTypeBo.getId())){
        	conditionsStr.append(" and ID = #{ipfRtmTypeBo.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getIpfRtmTypeId())){
        	conditionsStr.append(" and IPF_RTM_TYPE_ID like  CONCAT('%',#{ipfRtmTypeBo.IPF_RTM_TYPE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getIpfCcmBoId())){
        	conditionsStr.append(" and IPF_CCM_BO_ID like  CONCAT('%',#{ipfRtmTypeBo.IPF_CCM_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getBoName())){
        	conditionsStr.append(" and BO_NAME like  CONCAT('%',#{ipfRtmTypeBo.BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getBoDesc())){
        	conditionsStr.append(" and BO_DESC like  CONCAT('%',#{ipfRtmTypeBo.BO_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfRtmTypeBo.PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getPropertyUtility())){
        	conditionsStr.append(" and PROPERTY_UTILITY like  CONCAT('%',#{ipfRtmTypeBo.PROPERTY_UTILITY},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getExternalBoName())){
        	conditionsStr.append(" and EXTERNAL_BO_NAME like  CONCAT('%',#{ipfRtmTypeBo.EXTERNAL_BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getExternalMatchProperty())){
        	conditionsStr.append(" and EXTERNAL_MATCH_PROPERTY like  CONCAT('%',#{ipfRtmTypeBo.EXTERNAL_MATCH_PROPERTY},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getExternalResultProperty())){
        	conditionsStr.append(" and EXTERNAL_RESULT_PROPERTY like  CONCAT('%',#{ipfRtmTypeBo.EXTERNAL_RESULT_PROPERTY},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getExternalBoId())){
        	conditionsStr.append(" and EXTERNAL_BO_ID like  CONCAT('%',#{ipfRtmTypeBo.EXTERNAL_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBo.getTriggerPropertyName())){
        	conditionsStr.append(" and TRIGGER_PROPERTY_NAME like  CONCAT('%',#{ipfRtmTypeBo.TRIGGER_PROPERTY_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}



/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRtmTypeBoAttr.dao;

import com.cartan.core.ipfRtmTypeBoAttr.domain.IpfRtmTypeBoAttr;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRtmTypeBoAttrSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rtm_type_bo_attr where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRtmTypeBoAttr ipfRtmTypeBoAttr=new IpfRtmTypeBoAttr();
        ipfRtmTypeBoAttr=(IpfRtmTypeBoAttr)parameter.get("ipfRtmTypeBoAttr");

        if(StringUtils.isNotBlank(ipfRtmTypeBoAttr.getId())){
        	conditionsStr.append(" and ID = #{ipfRtmTypeBoAttr.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRtmTypeBoAttr.getIpfRtmTypeBoId())){
        	conditionsStr.append(" and IPF_RTM_TYPE_BO_ID like  CONCAT('%',#{ipfRtmTypeBoAttr.IPF_RTM_TYPE_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBoAttr.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfRtmTypeBoAttr.PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBoAttr.getFieldText())){
        	conditionsStr.append(" and FIELD_TEXT like  CONCAT('%',#{ipfRtmTypeBoAttr.FIELD_TEXT},'%')");
        }
        return  conditionsStr.toString();
    }
}



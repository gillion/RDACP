/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRtmTypeBoMap.dao;

import com.cartan.core.ipfRtmTypeBoMap.domain.IpfRtmTypeBoMap;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRtmTypeBoMapSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rtm_type_bo_map where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRtmTypeBoMap ipfRtmTypeBoMap=new IpfRtmTypeBoMap();
        ipfRtmTypeBoMap=(IpfRtmTypeBoMap)parameter.get("ipfRtmTypeBoMap");

        if(StringUtils.isNotBlank(ipfRtmTypeBoMap.getId())){
        	conditionsStr.append(" and ID = #{ipfRtmTypeBoMap.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRtmTypeBoMap.getIpfRtmTypeBoId())){
        	conditionsStr.append(" and IPF_RTM_TYPE_BO_ID like  CONCAT('%',#{ipfRtmTypeBoMap.IPF_RTM_TYPE_BO_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBoMap.getSourceValue())){
        	conditionsStr.append(" and SOURCE_VALUE like  CONCAT('%',#{ipfRtmTypeBoMap.SOURCE_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmTypeBoMap.getDestValue())){
        	conditionsStr.append(" and DEST_VALUE like  CONCAT('%',#{ipfRtmTypeBoMap.DEST_VALUE},'%')");
        }
        return  conditionsStr.toString();
    }
}



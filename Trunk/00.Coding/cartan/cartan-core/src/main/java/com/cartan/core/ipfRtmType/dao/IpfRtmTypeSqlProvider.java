/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfRtmType.dao;

import com.cartan.core.ipfRtmType.domain.IpfRtmType;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfRtmTypeSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_rtm_type where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfRtmType ipfRtmType=new IpfRtmType();
        ipfRtmType=(IpfRtmType)parameter.get("ipfRtmType");

        if(StringUtils.isNotBlank(ipfRtmType.getId())){
        	conditionsStr.append(" and ID = #{ipfRtmType.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfRtmType.getTypeCode())){
        	conditionsStr.append(" and TYPE_CODE like  CONCAT('%',#{ipfRtmType.TYPE_CODE},'%')");
        }
        if(StringUtils.isNotBlank(ipfRtmType.getTypeName())){
        	conditionsStr.append(" and TYPE_NAME like  CONCAT('%',#{ipfRtmType.TYPE_NAME},'%')");
        }
        return  conditionsStr.toString();
    }
}



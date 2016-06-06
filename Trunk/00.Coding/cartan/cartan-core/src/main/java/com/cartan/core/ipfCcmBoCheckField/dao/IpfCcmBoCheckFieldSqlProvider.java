/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoCheckField.dao;

import com.cartan.core.ipfCcmBoCheckField.domain.IpfCcmBoCheckField;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoCheckFieldSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_check_field where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoCheckField ipfCcmBoCheckField=new IpfCcmBoCheckField();
        ipfCcmBoCheckField=(IpfCcmBoCheckField)parameter.get("ipfCcmBoCheckField");

        if(StringUtils.isNotBlank(ipfCcmBoCheckField.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoCheckField.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoCheckField.getIpfCcmBoCheckId())){
        	conditionsStr.append(" and IPF_CCM_BO_CHECK_ID like  CONCAT('%',#{ipfCcmBoCheckField.IPF_CCM_BO_CHECK_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheckField.getPropertyId())){
        	conditionsStr.append(" and PROPERTY_ID like  CONCAT('%',#{ipfCcmBoCheckField.PROPERTY_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheckField.getPropertyName())){
        	conditionsStr.append(" and PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoCheckField.PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheckField.getPropertyDesc())){
        	conditionsStr.append(" and PROPERTY_DESC like  CONCAT('%',#{ipfCcmBoCheckField.PROPERTY_DESC},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheckField.getBoName())){
        	conditionsStr.append(" and BO_NAME like  CONCAT('%',#{ipfCcmBoCheckField.BO_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoCheckField.getSeqNo())){
        	conditionsStr.append(" and SEQ_NO like  CONCAT('%',#{ipfCcmBoCheckField.SEQ_NO},'%')");
        }
        return  conditionsStr.toString();
    }
}



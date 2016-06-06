/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoPropertyCas.dao;

import com.cartan.core.ipfCcmBoPropertyCas.domain.IpfCcmBoPropertyCas;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoPropertyCasSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_property_cas where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoPropertyCas ipfCcmBoPropertyCas=new IpfCcmBoPropertyCas();
        ipfCcmBoPropertyCas=(IpfCcmBoPropertyCas)parameter.get("ipfCcmBoPropertyCas");

        if(StringUtils.isNotBlank(ipfCcmBoPropertyCas.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoPropertyCas.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoPropertyCas.getIpfCcmBoPropertyId())){
        	conditionsStr.append(" and IPF_CCM_BO_PROPERTY_ID like  CONCAT('%',#{ipfCcmBoPropertyCas.IPF_CCM_BO_PROPERTY_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPropertyCas.getCascadePropertyId())){
        	conditionsStr.append(" and CASCADE_PROPERTY_ID like  CONCAT('%',#{ipfCcmBoPropertyCas.CASCADE_PROPERTY_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPropertyCas.getOperation())){
        	conditionsStr.append(" and OPERATION like  CONCAT('%',#{ipfCcmBoPropertyCas.OPERATION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPropertyCas.getTargetPropertyName())){
        	conditionsStr.append(" and TARGET_PROPERTY_NAME like  CONCAT('%',#{ipfCcmBoPropertyCas.TARGET_PROPERTY_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoPropertyCas.getType())){
        	conditionsStr.append(" and TYPE like  CONCAT('%',#{ipfCcmBoPropertyCas.TYPE},'%')");
        }
        return  conditionsStr.toString();
    }
}



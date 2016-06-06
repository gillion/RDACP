/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmBoMethodParam.dao;

import com.cartan.core.ipfCcmBoMethodParam.domain.IpfCcmBoMethodParam;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmBoMethodParamSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_bo_method_param where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmBoMethodParam ipfCcmBoMethodParam=new IpfCcmBoMethodParam();
        ipfCcmBoMethodParam=(IpfCcmBoMethodParam)parameter.get("ipfCcmBoMethodParam");

        if(StringUtils.isNotBlank(ipfCcmBoMethodParam.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmBoMethodParam.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmBoMethodParam.getIpfCcmBoMethodId())){
        	conditionsStr.append(" and IPF_CCM_BO_METHOD_ID like  CONCAT('%',#{ipfCcmBoMethodParam.IPF_CCM_BO_METHOD_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodParam.getConstantValue())){
        	conditionsStr.append(" and CONSTANT_VALUE like  CONCAT('%',#{ipfCcmBoMethodParam.CONSTANT_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodParam.getIsCondition())){
        	conditionsStr.append(" and IS_CONDITION like  CONCAT('%',#{ipfCcmBoMethodParam.IS_CONDITION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodParam.getMethodName())){
        	conditionsStr.append(" and METHOD_NAME like  CONCAT('%',#{ipfCcmBoMethodParam.METHOD_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodParam.getParamName())){
        	conditionsStr.append(" and PARAM_NAME like  CONCAT('%',#{ipfCcmBoMethodParam.PARAM_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodParam.getParamRef())){
        	conditionsStr.append(" and PARAM_REF like  CONCAT('%',#{ipfCcmBoMethodParam.PARAM_REF},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodParam.getParamType())){
        	conditionsStr.append(" and PARAM_TYPE like  CONCAT('%',#{ipfCcmBoMethodParam.PARAM_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmBoMethodParam.getBoNameRef())){
        	conditionsStr.append(" and BO_NAME_REF like  CONCAT('%',#{ipfCcmBoMethodParam.BO_NAME_REF},'%')");
        }
        return  conditionsStr.toString();
    }
}



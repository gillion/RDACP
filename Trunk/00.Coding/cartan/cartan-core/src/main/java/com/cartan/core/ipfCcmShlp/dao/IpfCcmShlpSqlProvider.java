/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmShlp.dao;

import com.cartan.core.ipfCcmShlp.domain.IpfCcmShlp;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmShlpSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_shlp where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmShlp ipfCcmShlp=new IpfCcmShlp();
        ipfCcmShlp=(IpfCcmShlp)parameter.get("ipfCcmShlp");

        if(StringUtils.isNotBlank(ipfCcmShlp.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmShlp.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmShlp.getShlpName())){
        	conditionsStr.append(" and SHLP_NAME like  CONCAT('%',#{ipfCcmShlp.SHLP_NAME},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlp.getShlpStatus())){
        	conditionsStr.append(" and SHLP_STATUS like  CONCAT('%',#{ipfCcmShlp.SHLP_STATUS},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlp.getDataSource())){
        	conditionsStr.append(" and DATA_SOURCE like  CONCAT('%',#{ipfCcmShlp.DATA_SOURCE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlp.getDataSourceType())){
        	conditionsStr.append(" and DATA_SOURCE_TYPE like  CONCAT('%',#{ipfCcmShlp.DATA_SOURCE_TYPE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlp.getValueColumn())){
        	conditionsStr.append(" and VALUE_COLUMN like  CONCAT('%',#{ipfCcmShlp.VALUE_COLUMN},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlp.getDisplayColumn())){
        	conditionsStr.append(" and DISPLAY_COLUMN like  CONCAT('%',#{ipfCcmShlp.DISPLAY_COLUMN},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmShlp.getRuleNo())){
        	conditionsStr.append(" and RULE_NO like  CONCAT('%',#{ipfCcmShlp.RULE_NO},'%')");
        }
        return  conditionsStr.toString();
    }
}



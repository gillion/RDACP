/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.ipfCcmNumruleList.dao;

import com.cartan.core.ipfCcmNumruleList.domain.IpfCcmNumruleList;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class IpfCcmNumruleListSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_ipf_ccm_numrule_list where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        IpfCcmNumruleList ipfCcmNumruleList=new IpfCcmNumruleList();
        ipfCcmNumruleList=(IpfCcmNumruleList)parameter.get("ipfCcmNumruleList");

        if(StringUtils.isNotBlank(ipfCcmNumruleList.getId())){
        	conditionsStr.append(" and ID = #{ipfCcmNumruleList.ID} ");
        }    		
        if(StringUtils.isNotBlank(ipfCcmNumruleList.getIpfCcmNumruleId())){
        	conditionsStr.append(" and IPF_CCM_NUMRULE_ID like  CONCAT('%',#{ipfCcmNumruleList.IPF_CCM_NUMRULE_ID},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumruleList.getConstExpression())){
        	conditionsStr.append(" and CONST_EXPRESSION like  CONCAT('%',#{ipfCcmNumruleList.CONST_EXPRESSION},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumruleList.getCurrentValue())){
        	conditionsStr.append(" and CURRENT_VALUE like  CONCAT('%',#{ipfCcmNumruleList.CURRENT_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumruleList.getInitialValue())){
        	conditionsStr.append(" and INITIAL_VALUE like  CONCAT('%',#{ipfCcmNumruleList.INITIAL_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumruleList.getMaxValue())){
        	conditionsStr.append(" and MAX_VALUE like  CONCAT('%',#{ipfCcmNumruleList.MAX_VALUE},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumruleList.getGrowth())){
        	conditionsStr.append(" and GROWTH like  CONCAT('%',#{ipfCcmNumruleList.GROWTH},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumruleList.getRemark())){
        	conditionsStr.append(" and REMARK like  CONCAT('%',#{ipfCcmNumruleList.REMARK},'%')");
        }
        if(StringUtils.isNotBlank(ipfCcmNumruleList.getIsActive())){
        	conditionsStr.append(" and IS_ACTIVE like  CONCAT('%',#{ipfCcmNumruleList.IS_ACTIVE},'%')");
        }
        return  conditionsStr.toString();
    }
}


